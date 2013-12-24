package org.xgmtk.lore.ast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.xgmtk.lore.parser.LoreBaseListener;
import org.xgmtk.lore.parser.LoreLexer;
import org.xgmtk.lore.parser.LoreParser;

public class ASTBuilder extends LoreBaseListener {
	public static final String DEFAULT_ENCODING = "UTF-8";

	private static LoreParser getParser(File src, String encoding) throws FileNotFoundException,
			IOException {
		InputStream in = new FileInputStream(src);
		InputStreamReader rd = new InputStreamReader(in, encoding);
		
		System.err.println("Encoding: \""+rd.getEncoding()+"\"");
		ANTLRInputStream ain = new ANTLRInputStream(rd);

		LoreLexer lexer = new LoreLexer(ain);
		TokenStream tstream = new BufferedTokenStream(lexer);
		LoreParser parser = new LoreParser(tstream);
		return parser;
	}

	private LoreParser parser;
	private AST tree;

	public ASTBuilder(File src, String encoding) throws IOException{
		super();
		parser = getParser(src, encoding);
		parser.addParseListener(this);
		this.tree = null;
	}
	
	public AST getTree() {
		return this.tree;
	}

	@Override
	public void enterLiteral(LoreParser.LiteralContext ctx){
		System.err.println("enterLiteral: \""+ctx.getRuleContext().getText()+"\"");
	}
	
	@Override
	public void exitLiteral(LoreParser.LiteralContext ctx) {
		System.err.println("enterLiteral: \""+ctx.getRuleContext().getText()+"\"");
	}

}
