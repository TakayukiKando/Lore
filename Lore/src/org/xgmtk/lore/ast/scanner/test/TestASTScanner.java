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
package org.xgmtk.lore.ast.scanner.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.ASTException;
import org.xgmtk.lore.ast.NonTerminalSymbol;
import org.xgmtk.lore.ast.scanner.ASTScanner;
import org.xgmtk.lore.ast.scanner.ASTScannerEventType;
import org.xgmtk.lore.ast.scanner.UnexpectedNodeException;
import org.xgmtk.lore.utils.SystemErrorHandler;

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
		this.logger.addHandler(new SystemErrorHandler());
		this.logger.setLevel(Level.ALL);
		this.src = dir.resolve("lambda.lore");
		this.ast = AST.build(this.src.toUri().toURL(), this.logger);
		this.scanner = new ASTScanner(this.logger);
	}
	
	@Test
	public void testVisitImport() throws MalformedURLException, ASTException{
		final List<URL> literals = new ArrayList<>();
//		PrintVisitor.printTree(this.ast, 
//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
		this.scanner.putPartialScanner(NonTerminalSymbol.IMPORT, (context, node)->{
			context.require(NonTerminalSymbol.IMPORT, ASTScannerEventType.START);
			context.next();
			if(context.isIDStart()){
				fail();
			}
			if(!context.isLiteralStart()){
				fail();
			}
			literals.add(context.getLiteral(URL.class));
			context.ｌeaveNode(node);
		});
		
		this.scanner.scan(ast);
		
		assertThat(literals, is(Arrays.asList(dir.resolve("types.lore").toUri().toURL())));
	}
	
	@Test
		public void testVisitImportAndRequireErrorNodeSymbolAndEventType() throws ASTException {
	//		PrintVisitor.printTree(this.ast, 
	//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
			this.scanner.putPartialScanner(NonTerminalSymbol.IMPORT, (context, node)->{
				if(context.isIDStart()){
					fail();
				}
				if(context.isLiteralStart()){
					fail();
				}
				context.require(NonTerminalSymbol.AUTHOR, ASTScannerEventType.END);
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
	public void testVisitImportAndRequireErrorNodeSymbol() throws ASTException{
//		PrintVisitor.printTree(this.ast, 
//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
		this.scanner.putPartialScanner(NonTerminalSymbol.IMPORT, (context, node)->{
			context.require(NonTerminalSymbol.AUTHOR, ASTScannerEventType.START);
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
	public void testVisitImportAndRequireErrorEventType() throws ASTException{
//		PrintVisitor.printTree(this.ast, 
//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
		this.scanner.putPartialScanner(NonTerminalSymbol.IMPORT, (context, node)->{
			context.require(NonTerminalSymbol.IMPORT, ASTScannerEventType.END);
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
	public void testVisitFormAndTypeSpec() throws ASTException{
		final List<String> formDefIds = new ArrayList<>();
		final List<String> typeSpecIds = new ArrayList<>();
//		PrintVisitor.printTree(this.ast, 
//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
		this.scanner.putPartialScanner(NonTerminalSymbol.FORM_DEF, (context, node)->{
			context.require(NonTerminalSymbol.FORM_DEF, ASTScannerEventType.START);
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
		this.scanner.putPartialScanner(NonTerminalSymbol.TYPE_SPEC, (context, node)->{
			context.require(NonTerminalSymbol.TYPE_SPEC, ASTScannerEventType.START);
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
	public void testVisitFormAndeDelegateTypeSpec() throws ASTException{
		final List<String> formDefIds = new ArrayList<>();
		final List<String> formTypeSpecIds = new ArrayList<>();
		final List<String> argTypeSpecIds = new ArrayList<>();
//		PrintVisitor.printTree(this.ast, 
//				new PrintWriter(new FileOutputStream(dir.resolve("lambda.lore.ast.txt").toFile())), true);
		this.scanner.putPartialScanner(NonTerminalSymbol.FORM_DEF, (context, node)->{
			context.require(NonTerminalSymbol.FORM_DEF, ASTScannerEventType.START);
			context.next();
			if(!context.isIDStart()){
				fail();
			}
			if(context.isLiteralStart()){
				fail();
			}
			formDefIds.add(context.getID().id);
			context.next();
			context.require(NonTerminalSymbol.CONT, ASTScannerEventType.START);
			for(;;){
				context.next();
				if(!context.isNode(NonTerminalSymbol.TYPE_SPEC, ASTScannerEventType.START)){
					break;
				}
				context.delegate(context.lastNode(), (cx, n)->{
					cx.require(NonTerminalSymbol.TYPE_SPEC, ASTScannerEventType.START);
					cx.next();
					formTypeSpecIds.add(cx.getID().id);
					cx.skip(n);
				});
			}
			context.skip(node);
		});
		this.scanner.putPartialScanner(NonTerminalSymbol.TYPE_SPEC, (context, node)->{
			context.require(NonTerminalSymbol.TYPE_SPEC, ASTScannerEventType.START);
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

