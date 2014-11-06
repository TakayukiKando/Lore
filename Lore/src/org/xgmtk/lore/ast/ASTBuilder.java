/*
 * [Apache License 2.0]
 * Copyright 2014 T.Kando and Inuyama-ya sanpu.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xgmtk.lore.ast;

import static org.xgmtk.lore.ast.ASTNodes.id;
import static org.xgmtk.lore.ast.ASTNodes.node;
import static org.xgmtk.lore.ast.ASTNodes.lit;
import static org.xgmtk.lore.ast.Locator.loc;
import static org.xgmtk.lore.utils.EncodeFinder.findEncodeInfo;
import static org.xgmtk.lore.utils.StringUtils.trim;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.logging.Logger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.xgmtk.lore.Lore;
import org.xgmtk.lore.parser.LoreBaseListener;
import org.xgmtk.lore.parser.LoreLexer;
import org.xgmtk.lore.parser.LoreParser;
import org.xgmtk.lore.types.HTML;
import org.xgmtk.lore.types.JID;
import org.xgmtk.lore.types.Location;
import org.xgmtk.lore.types.XML;

public class ASTBuilder extends LoreBaseListener {
	public static final String DEFAULT_ENCODING = "UTF-8";
	public static final int HEADER_SCAN_LINES_FOR_FIND_ENCODING = 100;

	public static void main(String[] args){
		if(args.length == 0 || Arrays.stream(args).anyMatch(s -> (s.equals("-h") || s.equals("-help")))){
			System.err.println("[USAGE]This command takes only 1 argument. It is a file path to parse.");
		}
		ASTBuilder builder = null;
		try {
			builder = new ASTBuilder(Paths.get(args[0]).toFile().toURI().toURL(), Logger.getGlobal());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		AST ast = builder.getTree();
		PrintVisitor.printTree(ast, System.out, false);
		System.exit(0);
	}
	
	protected static void printContext(ParserRuleContext ctx) {
		System.err.println("(Context object id: "+ctx+", line: "+ctx.start.getLine()+", \""+ctx.getText()+"\", child count: "+ctx.getChildCount()+"){");
		for(int i = 0; i < ctx.getChildCount(); ++i){
			ParseTree ptree = ctx.getChild(i);
			System.err.println("\t\""+ptree.getText()+"\"(has: "+ptree.getChildCount()+")");
		}
		System.err.println("}");
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param ctx
	 * @param string
	 * @return
	 */
	protected static int indexOf(ParserRuleContext ctx, String string) {
		for(int i = 0; i < ctx.getChildCount(); ++i){
			if(Objects.equals(ctx.getChild(i).getText(), string)){
				return i;
			}
		}
		return -1;
	}

	private static LoreParser getParser(URL source, String encoding) throws FileNotFoundException,
			IOException {
		InputStream in = source.openStream();
		InputStreamReader rd = new InputStreamReader(in, encoding);
		
		System.err.println("["+LoreParser.class.getSimpleName()+"] File: \""+source+"\", Encoding: \""+rd.getEncoding()+"\"");
		ANTLRInputStream ain = new ANTLRInputStream(rd);

		LoreLexer lexer = new LoreLexer(ain);
		TokenStream tstream = new BufferedTokenStream(lexer);
		LoreParser parser = new LoreParser(tstream);
		return parser;
	}
	
	private URL src;
	private LoreParser parser;
	private AST tree;
		
	private List<AST> children;
	private Stack<List<AST>> childrenStack;
	private Logger logger;
	
	public ASTBuilder(URL source, Logger logger) throws IOException{
		this(source, findEncodeInfo(source, HEADER_SCAN_LINES_FOR_FIND_ENCODING, DEFAULT_ENCODING), logger);
	}

	public ASTBuilder(URL source, String encoding, Logger logger) throws IOException{
		super();
		this.logger = logger;
		src = source;
		parser = getParser(source, encoding);
		parser.addParseListener(this);
		this.tree = null;
		
		this.children = null;
		this.childrenStack = new Stack<>();
		
		parser.lore();
	}
	
	protected void error(ParserRuleContext ctx, String msg) {
		logger.severe(Lore.errorMessageFormat(src, ctx.start.getLine(), msg));
	}

	/**
	 * This method should call at the begin of the enter*() method of the listener.
	 * Because the method pushes a children list of the parent node into stack.
	 * 
	 * @return
	 */
	protected List<AST> newChildrenList(){
		if(this.children != null){//This condition is expected to be true at the root node.
			this.childrenStack.push(this.children);
		}
		this.children = new ArrayList<>();
		return getChildrenList();
	}
	
	protected int getChildrenCount() {
		return this.getChildrenList().size();
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	protected List<AST> getChildrenList() {
		return this.children;
	}

	/**
	 * This method should call at the end of exit*() method of the listener.
	 * Because the method pops a children list of parent node from stack.
	 * 
	 * @param node
	 */
	protected void result(AST node){
		this.children = this.childrenStack.pop();
		this.getChildrenList().add(node);
	}
	
	public AST getTree() {
		return this.tree;
	}
	
	protected void nonterminalNodeAsResult(ParserRuleContext ctx, NodeType type) {
		AST n = node(type, loc(src, ctx.start.getLine()));
		n.getMdifiableChildren().addAll(this.getChildrenList());
		this.result(n);
	}

	protected void idNodeAsResult(ParserRuleContext ctx, String idString) {
		this.result(id(idString, loc(src, ctx.getStart().getLine())));
	}

	protected NodeType selectNonterminalSymbol(ParserRuleContext ctx, String symbolString, final NodeType[] symbols) {
		for(NodeType type:symbols){
			if(type.getSymbolString().equals(symbolString)){
				return type;
			}
		}
		throw new IllegalStateException("Unexpected internal error: The method could not find a suitable Node Type.");
	}

	protected AST buildOperatorTree(ParserRuleContext ctx,
			final NodeType[] ops) {
//		printContext(ctx);
		List<AST> cs = this.getChildrenList();
//		System.err.println("ParseTree: \""+ctx.getText()+"\"");
//		System.err.println("AST Children: "+cs.size());
//		System.err.println("ParseTree Children: "+ctx.getChildCount());
		AST left = cs.get(0);
		int ci = 1;
		for(int i = 1 ; i < ctx.getChildCount(); i+=2){
			AST right = cs.get(ci++);
			NodeType t = selectNonterminalSymbol(ctx, ctx.getChild(i).getText(), ops);
			left = node(t, loc(src, ctx.getStart().getLine()), left, right);
		}
		return left;
	}

	@Override
	public void enterLore(@NotNull LoreParser.LoreContext ctx) {
		this.newChildrenList();
		this.tree = node(NodeType.ROOT, loc(src, 0));
	}
	
	@Override
	public void exitLore(@NotNull LoreParser.LoreContext ctx) {
		this.tree.getMdifiableChildren().addAll(this.getChildrenList());
	}


	@Override
	public void enterDocinfo(@NotNull LoreParser.DocinfoContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitDocinfo(@NotNull LoreParser.DocinfoContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.DOCINFO);
	}
	
	@Override
	public void enterEncoding(@NotNull LoreParser.EncodingContext ctx) {
		this.newChildrenList();
	}
	
	@Override
	public void exitEncoding(@NotNull LoreParser.EncodingContext ctx) {
//		AST n = node(NodeType.ENCODING, loc(src, ctx.start.getLine()));
//		//printContext(ctx);
//		ParseTree child2 = ctx.getChild(2);
//		String encName = trim(child2.getText(), "\"", "\"");
//		n.getMdifiableChildren().add(lit(encName, loc(src, ctx.start.getLine())));
//		this.result(n);
		this.nonterminalNodeAsResult(ctx, NodeType.ENCODING);
	}

	@Override
	public void enterVersion(@NotNull LoreParser.VersionContext ctx) {
		this.newChildrenList();
	}
	
	@Override
	public void exitVersion(@NotNull LoreParser.VersionContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.VERSION);
	}

	@Override
	public void enterDescription(@NotNull LoreParser.DescriptionContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitDescription(@NotNull LoreParser.DescriptionContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.DESC);
	}

	@Override
	public void enterAuthor(@NotNull LoreParser.AuthorContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitAuthor(@NotNull LoreParser.AuthorContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.AUTHOR);
	}

	@Override
	public void enterHistory(@NotNull LoreParser.HistoryContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitHistory(@NotNull LoreParser.HistoryContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.HISTORY);
	}

	
	@Override
	public void enterImport_other(@NotNull LoreParser.Import_otherContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitImport_other(@NotNull LoreParser.Import_otherContext ctx) {
//		System.err.println("** Author");
//		printContext(ctx);
		this.nonterminalNodeAsResult(ctx, NodeType.IMPORT);
	}

	@Override
	public void enterSection(@NotNull LoreParser.SectionContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitSection(@NotNull LoreParser.SectionContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.SECTION);
	}

	@Override
	public void enterPrivate_section_element(@NotNull LoreParser.Private_section_elementContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitPrivate_section_element(@NotNull LoreParser.Private_section_elementContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.PRIVATE);
	}

	
	//ID, QNAME
	@Override
	public void enterQName(@NotNull LoreParser.QNameContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitQName(@NotNull LoreParser.QNameContext ctx) {
		List<AST> cs = this.getChildrenList();
		AST left = cs.get(0);
		for(int i = 1; i < cs.size(); ++i){
			AST right = cs.get(i);
			left = node(NodeType.QNAME, loc(src, ctx.getStart().getLine()), left, right);
		}
		this.result(left);
	}

	/*
	 * Type definitions
	 */
	
	@Override
	public void enterEnum_def(@NotNull LoreParser.Enum_defContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitEnum_def(@NotNull LoreParser.Enum_defContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.ENUM_DEF);
	}

	@Override
	public void enterEnum_elem(@NotNull LoreParser.Enum_elemContext ctx) {
		this.newChildrenList();		
	}
	
	@Override
	public void exitEnum_elem(@NotNull LoreParser.Enum_elemContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.ENUM_VAL);
	}
	
	@Override
	public void enterEnum_field(@NotNull LoreParser.Enum_fieldContext ctx) {
		this.newChildrenList();		
	}

	@Override
	public void exitEnum_field(@NotNull LoreParser.Enum_fieldContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.VAR);		
	}

	@Override
	public void enterUnit_def(@NotNull LoreParser.Unit_defContext ctx) {
		this.newChildrenList();				
	}

	@Override
	public void exitUnit_def(@NotNull LoreParser.Unit_defContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.UNIT_DEF);		
	}
	
	@Override
	public void enterForm_def(@NotNull LoreParser.Form_defContext ctx) {
		this.newChildrenList();				
	}

	@Override
	public void exitForm_def(@NotNull LoreParser.Form_defContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.FORM_DEF);		
	}
	
	@Override
	public void enterForm_cont_def(@NotNull LoreParser.Form_cont_defContext ctx) {
		this.newChildrenList();				
	}

	@Override
	public void exitForm_cont_def(@NotNull LoreParser.Form_cont_defContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.CONT);		
	}

	@Override
	public void enterPrivate_member_def(@NotNull LoreParser.Private_member_defContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitPrivate_member_def(@NotNull LoreParser.Private_member_defContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.PRIVATE);		
	}
	
	@Override
	public void enterMember_initializer(@NotNull LoreParser.Member_initializerContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitMember_initializer(@NotNull LoreParser.Member_initializerContext ctx) {
		if(ctx.getText().startsWith("override")){
			this.nonterminalNodeAsResult(ctx, NodeType.OVERRIDE);
		}else{
			this.result(this.getChildrenList().get(0));
		}
	}
	
	@Override
	public void enterType_spec(@NotNull LoreParser.Type_specContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitType_spec(@NotNull LoreParser.Type_specContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.TYPE_SPEC);
	}

	@Override
	public void enterLambda_type_full(@NotNull LoreParser.Lambda_type_fullContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitLambda_type_full(@NotNull LoreParser.Lambda_type_fullContext ctx) {
		List<AST> cs = this.getChildrenList();
//		printContext(ctx);
//		System.err.println("cs.size(): "+cs.size());
		AST type = cs.get(1);
		AST params = cs.get(0);
		this.result(node(NodeType.LAMBDA_TYPE, loc(src, ctx.getStart().getLine()), type, params));
	}

	@Override
	public void enterLambda_type_no_param(@NotNull LoreParser.Lambda_type_no_paramContext ctx) {
		this.newChildrenList();	
	}
	
	@Override
	public void exitLambda_type_no_param(@NotNull LoreParser.Lambda_type_no_paramContext ctx) {
		List<AST> cs = this.getChildrenList();
		AST type = cs.get(0);
		AST params = node(NodeType.PARAMS, loc(src, ctx.getStart().getLine()));
		this.result(node(NodeType.LAMBDA_TYPE, loc(src, ctx.getStart().getLine()), type, params));
	}

	@Override
	public void enterLambda_type_no_return(@NotNull LoreParser.Lambda_type_no_returnContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitLambda_type_no_return(@NotNull LoreParser.Lambda_type_no_returnContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.LAMBDA_TYPE);
	}

	@Override
	public void enterLambda_type_no_param_no_return(@NotNull LoreParser.Lambda_type_no_param_no_returnContext ctx) {
		this.newChildrenList();	
	}
	
	@Override
	public void exitLambda_type_no_param_no_return(@NotNull LoreParser.Lambda_type_no_param_no_returnContext ctx) {
		AST params = node(NodeType.PARAMS, loc(src, ctx.getStart().getLine()));
		this.result(node(NodeType.LAMBDA_TYPE, loc(src, ctx.getStart().getLine()), params));
	}
	
	@Override
	public void enterLambda_type_parameters(@NotNull LoreParser.Lambda_type_parametersContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitLambda_type_parameters(@NotNull LoreParser.Lambda_type_parametersContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.PARAMS);
	}
	
	@Override
	public void enterList_type(@NotNull LoreParser.List_typeContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitList_type(@NotNull LoreParser.List_typeContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.LIST_TYPE);
	}
	
	@Override
	public void enterUnit_type(@NotNull LoreParser.Unit_typeContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitUnit_type(@NotNull LoreParser.Unit_typeContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.UNIT_TYPE);
	}

	
	@Override
	public void enterRange_type(@NotNull LoreParser.Range_typeContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitRange_type(@NotNull LoreParser.Range_typeContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.RANGE_TYPE);
	}
	
	@Override
	public void enterArithmetic_type(@NotNull LoreParser.Arithmetic_typeContext ctx) {
		this.newChildrenList();
	}

	@Override public void exitArithmetic_type(@NotNull LoreParser.Arithmetic_typeContext ctx) {
		idNodeAsResult(ctx, ctx.getChild(0).getText());
	}
	
	@Override
	public void enterTextual_type(@NotNull LoreParser.Textual_typeContext ctx) {
		this.newChildrenList();
	}

	@Override public void exitTextual_type(@NotNull LoreParser.Textual_typeContext ctx) {
		idNodeAsResult(ctx, ctx.getChild(0).getText());
	}

	@Override
	public void enterTrpg_type(@NotNull LoreParser.Trpg_typeContext ctx) {
		this.newChildrenList();
	}

	@Override public void exitTrpg_type(@NotNull LoreParser.Trpg_typeContext ctx) {
		idNodeAsResult(ctx, ctx.getChild(0).getText());
	}

	/*
	 *  function / rule / accessor / alter(非 Javadoc)
	 */
	
	@Override
	public void enterRule_def(@NotNull LoreParser.Rule_defContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitRule_def(@NotNull LoreParser.Rule_defContext ctx) {
		List<AST> cs = this.getChildrenList();
		AST name = cs.get(0);
		AST block = cs.get(cs.size()-1);
		AST paramsNode = node(NodeType.PARAMS, loc(src, ctx.getStart().getLine()));
		if(cs.size() > 2){
			paramsNode.getMdifiableChildren().addAll(cs.subList(1, cs.size()-1));
		}
		this.result(node(NodeType.RULE, loc(src, ctx.getStart().getLine()), name, paramsNode, block));
	}

	@Override
	public void enterFunction_def(@NotNull LoreParser.Function_defContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitFunction_def(@NotNull LoreParser.Function_defContext ctx) {
		List<AST> cs = this.getChildrenList();
		AST name = cs.get(0);
		AST type = cs.get(cs.size()-2);
		AST block = cs.get(cs.size()-1);
		AST returnType = node(NodeType.TYPE_SPEC, loc(src, ctx.getStart().getLine()), name, type);
		AST paramsNode = node(NodeType.PARAMS, loc(src, ctx.getStart().getLine()));
//		printContext(ctx);
//		int ix = 0;
//		for(AST n :cs){
//			System.err.println("*** ["+(ix++)+" / "+cs.size()+"]");
//			PrintVisitor.printTree(n, System.err, false);
//			System.err.println("***");
//		}
		if(cs.size() > 3){//This function definition has parameters.
			paramsNode.getMdifiableChildren().addAll(cs.subList(1, cs.size()-2));
		};
		this.result(node(NodeType.FUNCTION, loc(src, ctx.getStart().getLine()), returnType, paramsNode, block));
	}

	@Override
	public void enterAccessor_def(@NotNull LoreParser.Accessor_defContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitAccessor_def(@NotNull LoreParser.Accessor_defContext ctx) {
		List<AST> cs = this.getChildrenList();
		AST name = cs.get(0);
		AST type = cs.get(cs.size()-2);
		AST block = cs.get(cs.size()-1);
		AST returnType = node(NodeType.TYPE_SPEC, loc(src, ctx.getStart().getLine()), name, type);
		AST paramsNode = node(NodeType.PARAMS, loc(src, ctx.getStart().getLine()));
		if(cs.size() > 3){//This function definition has parameters.
			paramsNode.getMdifiableChildren().addAll(cs.subList(1, cs.size()-2));
		}
		this.result(node(NodeType.ACCESSOR, loc(src, ctx.getStart().getLine()), returnType, paramsNode, block));
	}
	
	@Override
	public void enterAlter_def(@NotNull LoreParser.Alter_defContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitAlter_def(@NotNull LoreParser.Alter_defContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.ALTER);
	}
	
	@Override public void enterBlock(@NotNull LoreParser.BlockContext ctx) {
		this.newChildrenList();	
	}

	@Override public void exitBlock(@NotNull LoreParser.BlockContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.BODY);
	}

	/*
	 * Statements
	 * 
	 */
	
	@Override
	public void enterResult_statement(@NotNull LoreParser.Result_statementContext ctx) {
		this.newChildrenList();	
	}
	
	@Override
	public void exitResult_statement(@NotNull LoreParser.Result_statementContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.RESULT);
	}
	
	@Override
	public void enterVar_def(@NotNull LoreParser.Var_defContext ctx) {
		this.newChildrenList();	
	}
	
	@Override
	public void exitVar_def(@NotNull LoreParser.Var_defContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.VAR);
	}
	
	@Override
	public void enterField_modify(@NotNull LoreParser.Field_modifyContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitField_modify(@NotNull LoreParser.Field_modifyContext ctx) {
		List<AST> cs = this.getChildrenList();
		//AST self = cs.get(0);
		AST name = cs.get(1);
		AST exp = cs.get(2);
		this.result(node(NodeType.MODIFY, loc(src, ctx.getStart().getLine()), name, exp));
	}
	
	@Override
	public void enterSelf(@NotNull LoreParser.SelfContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitSelf(@NotNull LoreParser.SelfContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.SELF);
	}
	
	/*
	 * Expression
	 */
	
	@Override
	public void enterSelect_expr(@NotNull LoreParser.Select_exprContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitSelect_expr(@NotNull LoreParser.Select_exprContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.SELECT);
	}
	
	@Override
	public void enterCase_block(@NotNull LoreParser.Case_blockContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitCase_block(@NotNull LoreParser.Case_blockContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.CASE);
	}

	@Override
	public void enterAs_block(@NotNull LoreParser.As_blockContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitAs_block(@NotNull LoreParser.As_blockContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.AS);
	}

	@Override
	public void enterDefault_block(@NotNull LoreParser.Default_blockContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitDefault_block(@NotNull LoreParser.Default_blockContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.DEFAULT);
	}

	@Override
	public void enterRange(@NotNull LoreParser.RangeContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitRange(@NotNull LoreParser.RangeContext ctx) {
		String opStr = ctx.getChild(1).getText();
//		printContext(ctx);
//		System.err.println("AST children list size: "+this.getChildrenList().size());
		final NodeType[] ops = {NodeType.RANGE_OP_EE, NodeType.RANGE_OP_LE, NodeType.RANGE_OP_EL, NodeType.RANGE_OP_LL };
		NodeType op = selectNonterminalSymbol(ctx, opStr, ops);
		this.nonterminalNodeAsResult(ctx, op);
	}

	@Override
	public void enterCond_term(@NotNull LoreParser.Cond_termContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitCond_term(@NotNull LoreParser.Cond_termContext ctx) {
		if(ctx.getChildCount() < 2){
			this.result(this.getChildrenList().get(0));
		}else{
			String opStr = ctx.getChild(1).getText();
			final NodeType[] ops = {NodeType.AND, NodeType.OR };
			this.nonterminalNodeAsResult(ctx, selectNonterminalSymbol(ctx, opStr, ops));
		}
	}
	
	@Override
	public void enterRelation(@NotNull LoreParser.RelationContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitRelation(@NotNull LoreParser.RelationContext ctx) {
		String opStr = ctx.getChild(1).getText();
		final NodeType[] ops = {NodeType.EQ, NodeType.NEQ, NodeType.GE, NodeType.GT, NodeType.LE, NodeType.LT};
		this.nonterminalNodeAsResult(ctx, selectNonterminalSymbol(ctx, opStr, ops));
	}
	
	@Override
	public void enterCond_monomial(@NotNull LoreParser.Cond_monomialContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitCond_monomial(@NotNull LoreParser.Cond_monomialContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.NOT);
	}

	
	@Override public void enterTerms(@NotNull LoreParser.TermsContext ctx) {
		this.newChildrenList();	
	}
	
	@Override public void exitTerms(@NotNull LoreParser.TermsContext ctx) {
//		printContext(ctx);
		final NodeType[] ops = {NodeType.PLUS, NodeType.MINUS};
		this.result(buildOperatorTree(ctx, ops));
	}

	
	@Override public void enterTerm(@NotNull LoreParser.TermContext ctx) {
		this.newChildrenList();	
	}
	
	@Override public void exitTerm(@NotNull LoreParser.TermContext ctx) {
//		printContext(ctx);
		final NodeType[] ops = {NodeType.MULT, NodeType.DIV, NodeType.MOD};
		this.result(buildOperatorTree(ctx, ops));
	}
	
	@Override
	public void enterFactor(@NotNull LoreParser.FactorContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitFactor(@NotNull LoreParser.FactorContext ctx) {
		if(ctx.getChildCount() < 2){
			this.result(this.getChildrenList().get(0));
		}else{
			this.nonterminalNodeAsResult(ctx, NodeType.NEGATE);
		}
	}

	@Override
	public void enterUnit_monomial(@NotNull LoreParser.Unit_monomialContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitUnit_monomial(@NotNull LoreParser.Unit_monomialContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.UNIT_VAL);
	}
	
	@Override
	public void enterDice_monomial(@NotNull LoreParser.Dice_monomialContext ctx) {
		this.newChildrenList();	
	}

	// This method works in conjunction with exitDiceKind().
	@Override
	public void exitDice_monomial(@NotNull LoreParser.Dice_monomialContext ctx) {
		if(this.getChildrenCount() < 2){
			AST dice = this.getChildrenList().get(0);
			dice.getMdifiableChildren().add(0, lit(1, loc(src, ctx.getStart().getLine())));
			this.result(dice);
		}else{
			AST dice = this.getChildrenList().get(1);
			AST factor = this.getChildrenList().get(0);
			dice.getMdifiableChildren().add(0, factor);
			this.result(dice);
		}
	}
	
	@Override
	public void enterMonomial(@NotNull LoreParser.MonomialContext ctx) {
		this.newChildrenList();	
	}

	// This method works in conjunction with exitMember_access().
	@Override
	public void exitMonomial(@NotNull LoreParser.MonomialContext ctx) {
		List<AST> cs = this.getChildrenList();
//		System.err.println("=== AST Children: "+cs.size());
//		printContext(ctx);
		AST left = cs.get(0);
		for(int i = 1; i < cs.size(); ++i){
			AST right = cs.get(i);
//			System.err.print("i: ["+i+"], ");
//			System.err.print("left: \""+left.symbol.getSymbolString()+"\", ");
//			System.err.println("right: \""+right.symbol.getSymbolString()+"\"");
			if(NodeType.CALL.equals(right.symbol)){
				AST mname = right.getChildren().get(0);
				right.getMdifiableChildren().remove(0);
				AST qname = node(NodeType.QNAME, mname.locator, left, mname);
//				System.err.println("**** QNAME");
//				PrintVisitor.printTree(qname, System.err, false);
//				System.err.println("****");
//				System.err.println("mname: \""+mname.symbol.getSymbolString()+"\"");
				right.getMdifiableChildren().add(0, qname);
				left = right;
//				System.err.println("**** CALL");
//				PrintVisitor.printTree(left, System.err, false);
//				System.err.println("****");
			}else{
				left = node(NodeType.QNAME, right.locator, left, right);
//				System.err.println("**** QNAME");
//				PrintVisitor.printTree(left, System.err, false);
//				System.err.println("****");
			}
		}
//		System.err.print("result: \""+left.symbol.getSymbolString()+"\", ");
//		System.err.println("===");
//		System.err.println();
		this.result(left);
	}
	
	@Override
	public void enterMember_access(@NotNull LoreParser.Member_accessContext ctx) {
		this.newChildrenList();	
	}

	// This method works in conjunction with exitMonomial().
	@Override
	public void exitMember_access(@NotNull LoreParser.Member_accessContext ctx) {
		if(this.getChildrenCount()>1){
			AST call = node(NodeType.CALL, loc(src, ctx.getStart().getLine()));
			call.getMdifiableChildren().addAll(this.getChildrenList());
			this.result(call);
		}else{
			this.result(this.getChildrenList().get(0));
		}
	}
	
	@Override
	public void enterSimpleCall(@NotNull LoreParser.SimpleCallContext ctx) {
		this.newChildrenList();	
	}

	@Override public void exitSimpleCall(@NotNull LoreParser.SimpleCallContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.CALL);
	}

	@Override
	public void enterList_construct(@NotNull LoreParser.List_constructContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitList_construct(@NotNull LoreParser.List_constructContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.LIST_VAL);
	}

	
	@Override
	public void enterForm_construct(@NotNull LoreParser.Form_constructContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitForm_construct(@NotNull LoreParser.Form_constructContext ctx) {
		//printContext(ctx);
		this.nonterminalNodeAsResult(ctx, NodeType.FORM_VAL);
	}
	
	@Override
	public void enterForm_contents(@NotNull LoreParser.Form_contentsContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitForm_contents(@NotNull LoreParser.Form_contentsContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.CONT);
	}
	
	@Override
	public void enterLambda_full(@NotNull LoreParser.Lambda_fullContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitLambda_full(@NotNull LoreParser.Lambda_fullContext ctx) {
		List<AST> cs = this.getChildrenList();
		AST type = cs.get(1);
		AST params = cs.get(0);
		AST block = cs.get(2);
		this.result(node(NodeType.LAMBDA, loc(src, ctx.getStart().getLine()), type, params, block));
	}
	
	@Override
	public void enterLambda_no_param(@NotNull LoreParser.Lambda_no_paramContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitLambda_no_param(@NotNull LoreParser.Lambda_no_paramContext ctx) {
		List<AST> cs = this.getChildrenList();
		AST type = cs.get(0);
		AST params = node(NodeType.PARAMS, loc(src, ctx.getStart().getLine()));
		AST block = cs.get(1);
		this.result(node(NodeType.LAMBDA, loc(src, ctx.getStart().getLine()), type, params, block));
	}

	@Override
	public void enterLambda_no_return(@NotNull LoreParser.Lambda_no_returnContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitLambda_no_return(@NotNull LoreParser.Lambda_no_returnContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.LAMBDA);
	}
	
	@Override
	public void enterLambda_no_param_no_return(@NotNull LoreParser.Lambda_no_param_no_returnContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitLambda_no_param_no_return(@NotNull LoreParser.Lambda_no_param_no_returnContext ctx) {
		List<AST> cs = this.getChildrenList();
		AST params = node(NodeType.PARAMS, loc(src, ctx.getStart().getLine()));
		AST block = cs.get(0);
		this.result(node(NodeType.LAMBDA, loc(src, ctx.getStart().getLine()), params, block));
	}
	
	@Override
	public void enterLambda_parameters(@NotNull LoreParser.Lambda_parametersContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitLambda_parameters(@NotNull LoreParser.Lambda_parametersContext ctx) {
		this.nonterminalNodeAsResult(ctx, NodeType.PARAMS);
	}
	
	@Override
	public void enterLambda_block(@NotNull LoreParser.Lambda_blockContext ctx) {
		this.newChildrenList();	
	}

	@Override
	public void exitLambda_block(@NotNull LoreParser.Lambda_blockContext ctx) {
		List<AST> cs = this.getChildrenList();
		if(NodeType.BODY.equals(cs.get(0).symbol)){// child is BODY node.
			this.result(cs.get(0));
		}else{// child is expression node.
			AST exp = cs.get(0);
			AST result = node(NodeType.RESULT, loc(src, ctx.getStart().getLine()), exp);
			AST body = node(NodeType.BODY, loc(src, ctx.getStart().getLine()), result);
			this.result(body);
		}
	}

	/*
	 * Literals
	 */
	
	@Override
	public void enterHtml(@NotNull LoreParser.HtmlContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitHtml(@NotNull LoreParser.HtmlContext ctx) {
		Object v = ((Literal<?>)this.getChildrenList().get(0)).value;
		String content = (String)v;
		HTML html = HTML.create(content, loc(src, ctx.start.getLine()), logger);
		AST n = lit(html, loc(src, ctx.start.getLine()));
		this.result(n);
	}

	@Override
	public void enterXml(@NotNull LoreParser.XmlContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitXml(@NotNull LoreParser.XmlContext ctx) {
		Object v = ((Literal<?>)this.getChildrenList().get(0)).value;
		String content = (String)v;
		XML xml = XML.create(content, loc(src, ctx.start.getLine()), logger);
		AST n = lit(xml, loc(src, ctx.start.getLine()));
		this.result(n);
	}

	@Override
	public void enterUrl(@NotNull LoreParser.UrlContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitUrl(@NotNull LoreParser.UrlContext ctx) {
		Object v = ((Literal<?>)this.getChildrenList().get(0)).value;
		URL url = null;
		try{
			url = Lore.getURL((String)v, src);
		}catch(IllegalArgumentException e){
			error(ctx, e.getMessage());
			url = Locator.NOWHERE.file;
		}
		AST n = lit(url, loc(src, ctx.start.getLine()));
		this.result(n);
	}

	@Override
	public void enterDate(@NotNull LoreParser.DateContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitDate(@NotNull LoreParser.DateContext ctx) {
		Object v = ((Literal<?>)this.getChildrenList().get(0)).value;
		String content = (String)v;
		OffsetDateTime date = null;
		try{
			date = OffsetDateTime.parse(content);
		}catch (DateTimeParseException e){
			error(ctx, e.getMessage());
			date = OffsetDateTime.MAX;
		}
		AST n = lit(date, loc(src, ctx.start.getLine()));
		this.result(n);
	}

	@Override
	public void enterJid(@NotNull LoreParser.JidContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitJid(@NotNull LoreParser.JidContext ctx) {
		Object v = ((Literal<?>)this.getChildrenList().get(0)).value;
		String content = (String)v;
		JID jid = JID.NOBODY;
		try{
		jid = new JID(content);
		}catch(JID.SyntaxException e){
			this.error(ctx, e.getMessage());
		}
		AST n = lit(jid, loc(src, ctx.start.getLine()));
		this.result(n);
	}

	@Override
	public void enterLoc(@NotNull LoreParser.LocContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitLoc(@NotNull LoreParser.LocContext ctx) {
		Object v = ((Literal<?>)this.getChildrenList().get(0)).value;
		String content = (String)v;
		Location loc = Location.NOWHERE;
		try{
			loc = Location.parse(content);
		}catch(Location.SyntaxException e){
			this.error(ctx, e.getMessage());
		}
		AST n = lit(loc, loc(src, ctx.start.getLine()));
		this.result(n);
	}

	@Override
	public void enterStringLiteral(@NotNull LoreParser.StringLiteralContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitStringLiteral(@NotNull LoreParser.StringLiteralContext ctx) {
//		System.err.println("** StringLiteral");
//		printContext(ctx);
		ParseTree child0 = ctx.getChild(0);
		String text = child0.getText();
		String begin = null;
		String end = null;
		if(text.startsWith("\"")){
			begin = "\"";
			end = begin;
		}else if(text.startsWith("'")){
			begin = "'";
			end = begin;
		}else{
			StringBuilder sb = new StringBuilder();
			int eqs = text.indexOf("[", 1) - 1;
			for(int i = 0; i < eqs; ++i){
				sb.append("=");
			}
			begin = "["+sb.toString()+"[";
			end = "]"+sb.toString()+"]";
		}

		String str = trim(text, begin, end);
		AST n = lit(str, loc(src, ctx.start.getLine()));
		this.result(n);
	}
	
	@Override
	public void enterShortStringLiteral(@NotNull LoreParser.ShortStringLiteralContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitShortStringLiteral(@NotNull LoreParser.ShortStringLiteralContext ctx) {
//		System.err.println("** StringLiteral");
//		printContext(ctx);
		ParseTree child0 = ctx.getChild(0);
		String text = child0.getText();
		String begin = null;
		String end = null;
		if(text.startsWith("\"")){
			begin = "\"";
			end = begin;
		}else if(text.startsWith("'")){
			begin = "'";
			end = begin;
		}
		String str = trim(text, begin, end);
		AST n = lit(str, loc(src, ctx.start.getLine()));
		this.result(n);
	}

	@Override
	public void enterIntegral(@NotNull LoreParser.IntegralContext ctx) {
		this.newChildrenList();
	}

	@Override
	public void exitIntegral(@NotNull LoreParser.IntegralContext ctx) {
//		System.err.println("** Integral number");
//		printContext(ctx);
		ParseTree child0 = ctx.getChild(0);
		String text = child0.getText();
		try{
			int i = 0;
			i = parseIntegral(text);
			this.result(lit(i, loc(src, ctx.start.getLine())));
		} catch(NumberFormatException e1){
			try{
				long l = parseLongIntegral(text);
				this.result(lit(l, loc(src, ctx.start.getLine())));
			} catch(NumberFormatException e2){
				error(ctx, e2.getMessage());
				this.result(lit(0, loc(src, ctx.start.getLine())));
			}
		}
	}

	private int parseIntegral(String text) throws NumberFormatException {
		int i = 0;
		if(text.startsWith("0x") || text.startsWith("0X")){
			i = Integer.parseInt(text.substring(2), 16);
		}else{
			i = Integer.parseInt(text, 10);
		}
		return i;
	}
	
	private long parseLongIntegral(String text) throws NumberFormatException {
		long i = 0;
		if(text.startsWith("0x") || text.startsWith("0X")){
			i = Long.parseLong(text.substring(2), 16);
		}else{
			i = Long.parseLong(text, 10);
		}
		return i;
	}

	@Override
	public void enterReal(@NotNull LoreParser.RealContext ctx) {
		//System.err.println("entterReal() stack size: "+this.childrenStack.size());
		this.newChildrenList();
		//System.err.println("newChildrenList() stack size: "+this.childrenStack.size());
	}

	@Override
	public void exitReal(@NotNull LoreParser.RealContext ctx) {
		//System.err.println("** Real number");
		//printContext(ctx);
		//System.err.println("exitReal() stack size: "+this.childrenStack.size());
		ParseTree child0 = ctx.getChild(0);
		String text = child0.getText();
		double r = Double.NaN;
		try{
			r = Double.valueOf(text);
			this.result(lit(r, loc(src, ctx.start.getLine())));
		} catch(NumberFormatException e){
			error(ctx, e.getMessage());			
			this.result(lit(r, loc(src, ctx.start.getLine())));
		}
	}

	@Override
	public void enterDiceKind(@NotNull LoreParser.DiceKindContext ctx) {
		this.newChildrenList();		
	}
	
	// This method works in conjunction with exitDice_monomial().
	@Override
	public void exitDiceKind(@NotNull LoreParser.DiceKindContext ctx) {
//		System.err.println("** Dice kind");
//		printContext(ctx);
		String text = ctx.getChild(0).getText();
		int k = 6;
		if(text.length() > 1){
			k = Integer.MAX_VALUE;
			try{
				k = Integer.parseInt(text.substring(1));
			}catch(NumberFormatException e){
				this.error(ctx, "Dice kind is invalid.("+e.getMessage()+")");
			}
		}
		Literal<Integer> kind = lit(k, loc(src, ctx.start.getLine()));
		this.result(node(NodeType.DICE, loc(src, ctx.start.getLine()), kind));
	}

	@Override
	public void enterUnitName(@NotNull LoreParser.UnitNameContext ctx) {
		this.newChildrenList();		
	}

	@Override
	public void exitUnitName(@NotNull LoreParser.UnitNameContext ctx) {
//		System.err.println("** Unit name");
//		printContext(ctx);
		String unitName = ctx.getChild(0).getText();
		this.result(id(unitName , loc(src, ctx.start.getLine())));
	}

	@Override
	public void enterSimpleName(@NotNull LoreParser.SimpleNameContext ctx) {
		this.newChildrenList();		
	}

	@Override
	public void exitSimpleName(@NotNull LoreParser.SimpleNameContext ctx) {
//		System.err.println("** Unit name");
//		printContext(ctx);
		String name = ctx.getChild(0).getText();
		this.result(id(name , loc(src, ctx.start.getLine())));
	}

}
