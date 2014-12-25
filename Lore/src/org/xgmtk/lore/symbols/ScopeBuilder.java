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
package org.xgmtk.lore.symbols;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Logger;

import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.ASTException;
import org.xgmtk.lore.ast.ID;
import org.xgmtk.lore.ast.Literal;
import org.xgmtk.lore.ast.Locator;
import org.xgmtk.lore.ast.NonTerminalSymbol;
import org.xgmtk.lore.ast.loader.Loader;
import org.xgmtk.lore.ast.scanner.ASTScannerEventType;
import org.xgmtk.lore.ast.scanner.PartialASTScanner;
import org.xgmtk.lore.ast.scanner.QNameScanner;
import org.xgmtk.lore.ast.scanner.UnexpectedLiteralTypeException;
import org.xgmtk.lore.symbols.Scope.AlreadyDefinedSymbolException;
import org.xgmtk.lore.symbols.builtin.UnitType;

public class ScopeBuilder extends Loader{
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @author kando
	 *
	 */
	public static class AlreadyDefinedException extends ASTException {

		public AlreadyDefinedException(Locator locator, String message,
				Throwable t) {
			super(locator, message, t);
		}

		public AlreadyDefinedException(Locator locator, String message) {
			super(locator, message);
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		if(args.length == 0 || Arrays.stream(args).anyMatch(s -> (s.equals("-h") || s.equals("-help")))){
			System.err.println("[USAGE]This command takes only 1 argument. It is a file path to start parse.");
		}
		ScopeBuilder builder = null;
		try {
			builder = new ScopeBuilder(Logger.getGlobal());
			builder.build(Paths.get(args[0]).toUri().toURL());
		} catch (IOException | UnexpectedLiteralTypeException e) {
			e.printStackTrace();
			System.exit(1);
		}
		Scope scope = builder.getScopeRoot();
		scope.dump(System.out);
		System.out.flush();
		System.exit(0);
	}

	
	private GlobalScope root;
	private Scope current;
	private Access access;
	
	private final PartialASTScanner privateScanner = (context, node)->{
		context.require(NonTerminalSymbol.PRIVATE, ASTScannerEventType.START);
		context.nextNode();
		this.access = Access.PRIVATE;
		context.skip(node);
	};

	private final PartialASTScanner sectionScanner = (context, node)->{
		context.require(NonTerminalSymbol.SECTION, ASTScannerEventType.START);
		Access accessOfThis = access;
		access = Access.PUBLIC;
		AST qNameNode = context.nextNode();
		QNameScanner qNameScanner = new QNameScanner();
		context.delegate(qNameNode, qNameScanner);
		
		Scope save = current;
		for(ID idSym : qNameScanner.getIDs()){
			Optional<Symbol> r = current.resolve(idSym.id);
			if(r.isPresent()){
				Symbol sym = r.get();
				if(!(sym instanceof Section)){
					throw new AlreadyDefinedException(idSym.locator, "Expected symbol is a section but is a "+sym.getClass().getSimpleName()+".");
				}
				if(!sym.getAccess().equals(accessOfThis)){
					throw new AlreadyDefinedException(idSym.locator, "Already defined section is "+sym.getAccess().getDesc()+", but "+accessOfThis.getDesc()+" is specified.");
				}
				this.current = (Scope)sym;
			}else{
				Section sec = new Section(idSym.id, accessOfThis);
				try {
					current.define(sec);
				} catch (AlreadyDefinedSymbolException e) {
					throw new AlreadyDefinedException(idSym.locator, "Already defined.", e);
				}
				current = sec;
			}
		}
		context.skip(node);
		current = save;
	};
	
	private final PartialASTScanner formDefScanner = (context, node)->{
		context.require(NonTerminalSymbol.FORM_DEF, ASTScannerEventType.START);
		Access accessOfThis = access;
		access = Access.PUBLIC;
		context.nextNode();
		ID formName = context.getID();
		
		Scope save = this.current;
		FormDef formDef = new FormDef(formName.id, accessOfThis);
		try {
			current.define(formDef);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(formName.locator, "Already defined.", e);
		}
		current = formDef;

		context.nextNode();
		if(!context.isNode(NonTerminalSymbol.CONT, ASTScannerEventType.START)){
			QNameScanner qNameScanner = new QNameScanner();
			context.delegate(context.lastNode(), qNameScanner);
			formDef.setParentTypeQNameIds(qNameScanner.ids);
		}

		context.skip(node);
		current = save;
	};
	
	private final PartialASTScanner typeSpecScanner = (context, node)->{
		context.require(NonTerminalSymbol.TYPE_SPEC, ASTScannerEventType.START);
		Access accessOfThis = access;
		access = Access.PUBLIC;
		context.nextNode();
		ID varName = context.getID();
		
		VariableSymbol varDef = new VariableSymbol(varName.id, accessOfThis);
		try {
			current.define(varDef);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(varName.locator, "variable "+varDef.getDescription()+" is already defined in "+current.getScopeDescription()+".", e);
		}

		context.skip(node);
	};
	
	private final PartialASTScanner varDefScanner = (context, node)->{
		context.require(NonTerminalSymbol.VAR, ASTScannerEventType.START);
		Access accessOfThis = access;
		access = Access.PUBLIC;
		context.nextNode();
		ID varName = context.getID();
		
		VariableSymbol varDef = new VariableSymbol(varName.id, accessOfThis);
		try {
			current.define(varDef);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(varName.locator, "variable "+varDef.getDescription()+" is already defined in "+current.getScopeDescription()+".", e);
		}

		context.skip(node);
	};
	
	private final PartialASTScanner accessorScanner = (context, node)->{
		context.require(NonTerminalSymbol.ACCESSOR, ASTScannerEventType.START);
		context.nextNode();
		
		Access accessOfThis = access;
		access = Access.PUBLIC;

		context.require(NonTerminalSymbol.TYPE_SPEC, ASTScannerEventType.START);
		context.nextNode();

		ID funName = context.getID();
		
		Scope save = this.current;
		ProcScope proc = new ProcScope(funName.id, accessOfThis, ProcStyle.ACCESSOR);
		try {
			current.define(proc);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
		}
		current = proc;

		context.skip(node);
		current = save;
	};
	
	private final PartialASTScanner functionScanner = (context, node)->{
		context.require(NonTerminalSymbol.FUNCTION, ASTScannerEventType.START);
		context.nextNode();
		
		Access accessOfThis = access;
		access = Access.PUBLIC;
		
		context.require(NonTerminalSymbol.TYPE_SPEC, ASTScannerEventType.START);
		context.nextNode();

		ID funName = context.getID();
		
		Scope save = this.current;
		ProcScope proc = new ProcScope(funName.id, accessOfThis, ProcStyle.FUNCTION);
		try {
			current.define(proc);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
		}
		current = proc;

		context.skip(node);
		current = save;
	};
	
	private final PartialASTScanner modifierScanner = (context, node)->{
		context.require(NonTerminalSymbol.ALTER, ASTScannerEventType.START);
		context.nextNode();
		
		Access accessOfThis = access;
		access = Access.PUBLIC;

		ID funName = context.getID();
		
		Scope save = this.current;
		ProcScope proc = new ProcScope(funName.id, accessOfThis, ProcStyle.ALTER);
		try {
			current.define(proc);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
		}
		current = proc;

		context.skip(node);
		current = save;
	};
	
	private final PartialASTScanner ruleScanner = (context, node)->{
		context.require(NonTerminalSymbol.RULE, ASTScannerEventType.START);
		context.nextNode();
		
		Access accessOfThis = access;
		access = Access.PUBLIC;

		ID funName = context.getID();
		
		Scope save = this.current;
		ProcScope proc = new ProcScope(funName.id, accessOfThis, ProcStyle.RULE);
		try {
			current.define(proc);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
		}
		current = proc;

		context.skip(node);
		current = save;
	};
	
	private final PartialASTScanner bodyScanner = (context, node)->{
		context.require(NonTerminalSymbol.BODY, ASTScannerEventType.START);
		context.nextNode();
		
		Scope save = this.current;
		BaseScope body = new BaseScope();
		try {
			current.put(body);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
		}
		current = body;

		context.skip(node);
		current = save;
	};
	private final PartialASTScanner lambdaScanner = (context, node)->{
		context.require(NonTerminalSymbol.LAMBDA, ASTScannerEventType.START);
		context.nextNode();
		ProcStyle procStyle = ProcStyle.RULE;
		if(context.isNode(NonTerminalSymbol.TYPE_SPEC, ASTScannerEventType.START)){
			procStyle = ProcStyle.FUNCTION;
			context.skip(context.lastNode());
		}
		
		Scope save = this.current;
		LambdaScope proc = new LambdaScope(procStyle);
		try {
			current.put(proc);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
		}
		current = proc;

		context.skip(node);
		current = save;
	};
	private PartialASTScanner formValScanner = (context, node)->{
		context.require(NonTerminalSymbol.FORM_VAL, ASTScannerEventType.START);
		context.nextNode();
		context.require(NonTerminalSymbol.CONT, ASTScannerEventType.START);
		AST cnode = context.lastNode();
		context.nextNode();
		
		Scope save = this.current;
		FormValContent formValCont = new FormValContent();
		try {
			current.put(formValCont);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
		}
		current = formValCont;

		context.skip(cnode);
		current = save;
		
		context.nextNode();
		if(!context.isNode(NonTerminalSymbol.FORM_VAL, ASTScannerEventType.END)){
			QNameScanner qNameScanner = new QNameScanner();
			context.delegate(context.lastNode(), qNameScanner);
			formValCont.setParentTypeQNameIds(qNameScanner.ids);
		}
		
		try{
			FormDef formDef = formValCont.createAnonymousTypeDefinition(root.createAnonymousTypeName());
			getScopeRoot().addAnonymousType(formDef);
		}catch(AlreadyDefinedSymbolException e){
			throw new IllegalStateException("Unexpected internal error.", e);
		}
		context.skip(node);
	};
	
	private final PartialASTScanner unitDefScanner = (context, node)->{
		context.require(NonTerminalSymbol.UNIT_DEF, ASTScannerEventType.START);
		context.nextNode();
		ID unitId = context.getID();
		String unitName = unitId.id;
		context.nextNode();
		Literal<?> factor = context.getLiteral();
		context.nextNode();
		String baseUnitName = null;
		if(context.isIDStart()){
			ID baseUnitId = context.getID();
			baseUnitName = baseUnitId.id;
		}
		UnitType unitType = null;
		if(factor.value instanceof Long){
			unitType = new UnitType(unitName, (Long)factor.value, baseUnitName);
		}else if(factor.value instanceof Double){
			unitType = new UnitType(unitName, (Double)factor.value, baseUnitName);
		}else{
			throw new UnexpectedLiteralTypeException(factor.locator, factor.value.getClass(), Long.class, Double.class);
		}
		try{
			getScopeRoot().define(unitType);
		}catch(AlreadyDefinedSymbolException e){
			throw new AlreadyDefinedException(node.locator, "Already defined unit.", e);
		}
		context.skip(node);
	};
	
	private PartialASTScanner enumDefScanner = (context, node)->{
		context.require(NonTerminalSymbol.ENUM_DEF, ASTScannerEventType.START);
		Access accessOfThis = access;
		access = Access.PUBLIC;
		context.nextNode();
		ID enumName = context.getID();
		
		Scope save = this.current;
		EnumDef enumDef = new EnumDef(enumName.id, accessOfThis);
		try {
			current.define(enumDef);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(enumName.locator, "Already defined.", e);
		}
		current = enumDef;

		context.nextNode();
		if(!context.isNode(NonTerminalSymbol.ENUM_VAL, ASTScannerEventType.START)){
			QNameScanner qNameScanner = new QNameScanner();
			context.delegate(context.lastNode(), qNameScanner);
			enumDef.setParentTypeQNameIds(qNameScanner.ids);
		}

		context.skip(node);
		current = save;

		enumDef.getSymbolTable().values().stream().forEach(s->((Typed)s).setType(enumDef));
//		System.err.println(enumDef.getDescription());
//		enumDef.getSymbolTable().values().stream().forEach(s->System.err.println("\t"+s.getDescription()));
		Scope scope = (Scope)enumDef.getSymbolTable().values().iterator().next();
		scope.getSymbolTable().values().stream().forEach(s->{
			try{
				enumDef.define(new VariableSymbol(s.getName(), Access.PUBLIC));
			}catch(AlreadyDefinedSymbolException e){
				throw new IllegalStateException("Unexpected internal error.", e);
			}
		});
	};
	
	private PartialASTScanner enumValScanner = (context, node)->{
		context.require(NonTerminalSymbol.ENUM_VAL, ASTScannerEventType.START);
		context.nextNode();
		ID enumName = context.getID();

		Scope save = this.current;
		EnumValContent enumValCont = new EnumValContent(enumName.id);
		try {
			current.define(enumValCont);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
		}
		current = enumValCont;

		context.skip(node);
		current = save;
	};
	
	private PartialASTScanner caseBlockScanner = (context, node)->{
		context.require(NonTerminalSymbol.CASE, ASTScannerEventType.START);
		context.nextNode();
		/* processed by bodyScanner */
//		Scope save = this.current;
//		Scope caseBlock = new BaseScope();
//		try {
//			current.put(caseBlock);
//		} catch (AlreadyDefinedSymbolException e) {
//			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
//		}
//		current = caseBlock;
//
		context.skip(node);
//		current = save;
	};
	
	private PartialASTScanner asBlockScanner = (context, node)->{
		context.require(NonTerminalSymbol.AS, ASTScannerEventType.START);
		context.nextNode();
		Scope save = this.current;
		Scope asBlockParam = new BaseScope();
		try {
			current.put(asBlockParam);
		} catch (AlreadyDefinedSymbolException e) {
			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
		}
		current = asBlockParam;
		context.delegate(context.lastNode(), typeSpecScanner);
		context.nextNode();

		/* processed by bodyScanner */
//		context.require(NonTerminalSymbol.BODY, ASTScannerEventType.START);
//		context.nextNode();
//		Scope asBlock = new BaseScope();
//		try {
//			current.put(asBlock);
//		} catch (AlreadyDefinedSymbolException e) {
//			throw new AlreadyDefinedException(node.locator, "Already defined.", e);
//		}
//		current = asBlock;
//
		context.skip(node);
		current = save;
	};
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param logger
	 */
	public ScopeBuilder(Logger logger) {
		super(logger);
		this.root = new GlobalScope();
		
		this.current = this.root;
		this.access = Access.PUBLIC;
		
		this.getScanner().putPartialScanner(NonTerminalSymbol.SECTION, this.sectionScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.PRIVATE, this.privateScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.FORM_DEF, this.formDefScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.TYPE_SPEC, this.typeSpecScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.VAR, this.varDefScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.ACCESSOR, this.accessorScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.FUNCTION, this.functionScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.ALTER, this.modifierScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.RULE, this.ruleScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.BODY, this.bodyScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.LAMBDA, this.lambdaScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.FORM_VAL, this.formValScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.UNIT_DEF, this.unitDefScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.ENUM_DEF, this.enumDefScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.ENUM_VAL, this.enumValScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.CASE, this.caseBlockScanner);
		this.getScanner().putPartialScanner(NonTerminalSymbol.AS, this.asBlockScanner);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public GlobalScope getScopeRoot() {
		return this.root;
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param source
	 * @return
	 * @throws UnexpectedLiteralTypeException
	 * @throws IOException
	 */
	public Scope build(URL source) throws UnexpectedLiteralTypeException, IOException {
		this.load(source);
		return this.getScopeRoot();
	}
}
