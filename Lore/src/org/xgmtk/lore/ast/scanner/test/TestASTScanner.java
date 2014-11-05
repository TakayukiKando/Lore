package org.xgmtk.lore.ast.scanner.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.Literal;
import org.xgmtk.lore.ast.NodeType;
import org.xgmtk.lore.ast.scanner.ASTScanner;
import org.xgmtk.lore.ast.scanner.ASTScannerEventType;
import org.xgmtk.lore.ast.scanner.UnexpectedNodeException;

public class TestASTScanner {
	private static Path wdir;
	private static Path dir;
	private static final String clsName = TestASTScanner.class.getSimpleName();
	
	@BeforeClass
	public static void setupStatic(){
		wdir = Paths.get(System.getProperty("user.dir"));
		dir = wdir.resolve(Paths.get("sample", "forParser"));
	}

	@Rule
	public TestName name = new TestName();
	
	private String methodName;
	private Logger logger;
	private Path src;
	private AST ast;
	private ASTScanner scanner;

	@Before
	public void setup() throws IOException{
		this.methodName = name.getMethodName();
		this.logger = Logger.getLogger(clsName+"_"+this.methodName+"_log");
		this.logger.addHandler(new Handler(){
			@Override
			public void publish(LogRecord record) {
				System.err.println(record.getMessage());
			}

			@Override
			public void flush() {
				System.err.flush();
			}

			@Override
			public void close() throws SecurityException {
				//System.err.close();
			}
		});
		this.logger.setLevel(Level.ALL);
		this.src = dir.resolve("lambda.lore");
		this.ast = AST.build(this.src, this.logger);
		this.scanner = new ASTScanner(this.logger);
	}
	
	@Test
	public void testVisitImport() throws URISyntaxException, UnexpectedNodeException{
		final List<Literal<?>> literals = new ArrayList<>();
//		PrintVisitor.printTree(this.ast, 
//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
		this.scanner.putPartialScanner(NodeType.IMPORT, (context, node)->{
			context.require(NodeType.IMPORT, ASTScannerEventType.START);
			context.next();
			if(context.isIDStart()){
				fail();
			}
			if(!context.isLiteralStart()){
				fail();
			}
			literals.add(context.getLiteral());
			context.ｌeaveNode(node);
		});
		
		this.scanner.scan(ast);
		
		assertThat(literals.size(), is(1));
		assertThat(literals.get(0).value instanceof URI, is(true));
		assertThat(((URI)literals.get(0).value), is(new URI("types.lore")));
	}
	
	@Test
		public void testVisitImportAndRequireErrorNodeSymbolAndEventType(){
	//		PrintVisitor.printTree(this.ast, 
	//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
			this.scanner.putPartialScanner(NodeType.IMPORT, (context, node)->{
				if(context.isIDStart()){
					fail();
				}
				if(context.isLiteralStart()){
					fail();
				}
				context.require(NodeType.AUTHOR, ASTScannerEventType.END);
				context.skip(node);
			});
			
			try {
				this.scanner.scan(ast);
				fail();
			} catch (UnexpectedNodeException e) {
				// expected;
			}
		}

	@Test
	public void testVisitImportAndRequireErrorNodeSymbol(){
//		PrintVisitor.printTree(this.ast, 
//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
		this.scanner.putPartialScanner(NodeType.IMPORT, (context, node)->{
			context.require(NodeType.AUTHOR, ASTScannerEventType.START);
			context.skip(node);
		});
		
		try {
			this.scanner.scan(ast);
			fail();
		} catch (UnexpectedNodeException e) {
			// expected;
		}
	}
	
	@Test
	public void testVisitImportAndRequireErrorEventType(){
//		PrintVisitor.printTree(this.ast, 
//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
		this.scanner.putPartialScanner(NodeType.IMPORT, (context, node)->{
			context.require(NodeType.IMPORT, ASTScannerEventType.END);
			context.skip(node);
		});
		
		try {
			this.scanner.scan(ast);
			fail();
		} catch (UnexpectedNodeException e) {
			// expected;
		}
	}
	
	@Test
	public void testVisitFormAndTypeSpec() throws URISyntaxException, UnexpectedNodeException{
		final List<String> formDefIds = new ArrayList<>();
		final List<String> typeSpecIds = new ArrayList<>();
//		PrintVisitor.printTree(this.ast, 
//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
		this.scanner.putPartialScanner(NodeType.FORM_DEF, (context, node)->{
			context.require(NodeType.FORM_DEF, ASTScannerEventType.START);
			context.next();
			if(!context.isIDStart()){
				fail();
			}
			if(context.isLiteralStart()){
				fail();
			}
			formDefIds.add(context.getID().id);
			context.skip(node);
		});
		this.scanner.putPartialScanner(NodeType.TYPE_SPEC, (context, node)->{
			context.require(NodeType.TYPE_SPEC, ASTScannerEventType.START);
			context.next();
			if(!context.isIDStart()){
				fail();
			}
			if(context.isLiteralStart()){
				fail();
			}
			typeSpecIds.add(context.getID().id);
			context.skip(node);
		});
		
		this.scanner.scan(ast);
		
		assertThat(formDefIds, is(Arrays.asList("ItemSet", "LambdaSample")));
//		System.err.println("typeSpecIds:");
//		System.err.print("\t");
//		typeSpecIds.stream().forEach(e->System.err.print("\""+e+"\", "));
//		System.err.println();
		assertThat(typeSpecIds, is(Arrays.asList("items", "encCalc", "enc", "find", "name", "it", "l0", "l1", "l3", "l4", "l5", "l6", "x", "x", "a", "b", "a", "b", "x")));
	}
	@Test
	public void testVisitFormAndeDelegateTypeSpec() throws URISyntaxException, UnexpectedNodeException{
		final List<String> formDefIds = new ArrayList<>();
		final List<String> formTypeSpecIds = new ArrayList<>();
		final List<String> argTypeSpecIds = new ArrayList<>();
//		PrintVisitor.printTree(this.ast, 
//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
		this.scanner.putPartialScanner(NodeType.FORM_DEF, (context, node)->{
			context.require(NodeType.FORM_DEF, ASTScannerEventType.START);
			context.next();
			if(!context.isIDStart()){
				fail();
			}
			if(context.isLiteralStart()){
				fail();
			}
			formDefIds.add(context.getID().id);
			context.next();
			context.require(NodeType.CONT, ASTScannerEventType.START);
			for(;;){
				context.next();
				if(!context.isNode(NodeType.TYPE_SPEC, ASTScannerEventType.START)){
					break;
				}
				context.delegate(context.lastNode(), (cx, n)->{
					cx.require(NodeType.TYPE_SPEC, ASTScannerEventType.START);
					cx.next();
					formTypeSpecIds.add(cx.getID().id);
					cx.skip(n);
				});
			}
			context.skip(node);
		});
		this.scanner.putPartialScanner(NodeType.TYPE_SPEC, (context, node)->{
			context.require(NodeType.TYPE_SPEC, ASTScannerEventType.START);
			context.next();
			if(!context.isIDStart()){
				fail();
			}
			if(context.isLiteralStart()){
				fail();
			}
			argTypeSpecIds.add(context.getID().id);
			context.skip(node);
		});
		
		this.scanner.scan(ast);
		
		assertThat(formDefIds, is(Arrays.asList("ItemSet", "LambdaSample")));
//		System.err.println("formTypeSpecIds:");
//		System.err.print("\t");
//		formTypeSpecIds.stream().forEach(e->System.err.print("\""+e+"\", "));
//		System.err.println();
//		System.err.println("argTypeSpecIds:");
//		System.err.print("\t");
//		argTypeSpecIds.stream().forEach(e->System.err.print("\""+e+"\", "));
//		System.err.println();
		assertThat(formTypeSpecIds, is(Arrays.asList("items", "encCalc", "l0", "l1", "l3", "l4", "l5", "l6")));
		assertThat(argTypeSpecIds, is(Arrays.asList("enc", "find", "name", "it", "x", "x", "a", "b", "a", "b", "x")));
	}
}

