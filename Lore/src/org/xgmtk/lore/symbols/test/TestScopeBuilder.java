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
package org.xgmtk.lore.symbols.test;

import static org.junit.Assert.assertThat;
import static org.xgmtk.lore.symbols.test.ScopeMatchers.equalScope;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.xgmtk.lore.symbols.PrintVisitor;
import org.xgmtk.lore.symbols.Scope;
import org.xgmtk.lore.symbols.ScopeBuilder;

public class TestScopeBuilder {
	private static Path wdir;
	private static Path dir;
	private static final String clsName = TestScopeBuilder.class.getSimpleName();
	
	@BeforeClass
	public static void setupStatic(){
		wdir = Paths.get(System.getProperty("user.dir"));
		dir = wdir.resolve(Paths.get("sample", "forParser"));
	}

	@Rule
	public TestName name = new TestName();
	
	private Logger logger;
	private String methodName;
	private Path srcPath;
	
	@Before
	public void setup() throws FileNotFoundException{
		this.methodName = name.getMethodName();
		this.logger = Logger.getLogger(clsName+"_"+this.methodName+"_log");
		this.srcPath = dir.resolve("expressions.lore");
	}
	
	public void dumpTree(String name, Scope scope) throws FileNotFoundException {
		PrintStream prn = new PrintStream(new FileOutputStream(dir.resolve(clsName+"."+name+".txt").toFile()));
		dumpTree(name, scope, prn);
		prn.close();
	}
	
	public void dumpTree(String name, Scope scope, PrintStream prn) {
		prn.println("*** "+name);
		PrintVisitor.printScopeTree(scope, prn);
		prn.flush();
	}

	public void testExactly(Scope expectedTree, Path src) throws IOException{
		String methodName = name.getMethodName();
		Scope actualTree = Scope.build(src, this.logger);
		dumpTree(methodName+".expected", expectedTree);
		dumpTree(methodName+".actual", actualTree);
		assertThat(actualTree, equalScope(expectedTree));
	}
	
	@Test
	public void testBuild() throws IOException{
		Scope actualTree = Scope.build(srcPath, this.logger);
		String methodName = name.getMethodName();
		System.err.println("*** TODO: implement: "+ScopeBuilder.class.getName()+"#"+"build()");
		dumpTree(methodName+".actual", actualTree, System.err);
	}

}
