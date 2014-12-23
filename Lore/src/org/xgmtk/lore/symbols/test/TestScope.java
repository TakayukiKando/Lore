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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.xgmtk.lore.symbols.BaseScope.baseScope;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xgmtk.lore.symbols.Access;
import org.xgmtk.lore.symbols.BaseScope;
import org.xgmtk.lore.symbols.GlobalScope;
import org.xgmtk.lore.symbols.Scope;
import org.xgmtk.lore.symbols.Scope.AlreadyDefinedSymbolException;
import org.xgmtk.lore.symbols.Section;
import org.xgmtk.lore.symbols.Symbol;
import org.xgmtk.lore.symbols.ScopedSymbol;
import org.xgmtk.lore.symbols.VariableSymbol;
import org.xgmtk.lore.symbols.builtin.BuiltinTypes;

public class TestScope {
	private static Path wdir;
	private static Path dir;
	private static final String clsName = TestScope.class.getSimpleName();
	
	@BeforeClass
	public static void setupStatic(){
		wdir = Paths.get(System.getProperty("user.dir"));
		dir = wdir.resolve(Paths.get("test", clsName));
	}
	
	private static final String NEWLINE;
	static{
		NEWLINE = System.getProperties().getProperty("line.separator");
	}
	
	private static Symbol var(String string, Access access) {
		return new VariableSymbol(string, access);
	}

	private static Symbol var(String string) {
		return new VariableSymbol(string);
	}

	private static ScopedSymbol scopedSymbol(String string, Symbol...vars) throws AlreadyDefinedSymbolException {
		ScopedSymbol s = new ScopedSymbol(string);
		s.defineAll(vars);
		return s;
	}

	private static Scope globalScope(Symbol...vars) throws AlreadyDefinedSymbolException {
		ScopedSymbol s = new GlobalScope();
		s.defineAll(vars);
		return s;
	}

	private static Section section(String string, Access access, Symbol...vars) throws AlreadyDefinedSymbolException {
		Section s = new Section(string, access);
		s.defineAll(vars);
		return s;
	}

	private static Section section(String string, Symbol...vars) throws AlreadyDefinedSymbolException {
		Section s = new Section(string);
		s.defineAll(vars);
		return s;
	}

	public static void dump(Scope actual, Path pathToOutput) throws IOException {
		try(PrintWriter out = new PrintWriter(new FileWriter(pathToOutput.toFile()))){
			actual.dump(out);
			out.flush();
		}
	}

	@Test
	public void testSimpleResolve() throws AlreadyDefinedSymbolException{
		Scope s = baseScope(var("a"),var("b"));
		assertThat(s.resolveLocal("a").get().getName(),is("a"));
		assertThat(s.resolveLocal("b").get().getName(),is("b"));
		assertThat(s.resolveLocal("c").isPresent(), is(false));
		
		assertThat(s.resolve("a").get().getName(),is("a"));
		assertThat(s.resolve("b").get().getName(),is("b"));
		assertThat(s.resolve("c").isPresent(), is(false));
	}
	
	@Test
	public void testNestedResolve() throws AlreadyDefinedSymbolException{
		Scope root = baseScope(var("a"));
		BaseScope s0 = baseScope(var("b"), var("a"));
		root.put(s0);
		Scope s1 = baseScope(var("c"));
		s0.put(s1);
		assertThat(s1.resolveLocal("a").isPresent(), is(false));
		assertThat(s1.resolveLocal("b").isPresent(), is(false));
		assertThat(s1.resolveLocal("c").get().getName(),is("c"));
		
		assertThat(s1.resolve("a").get().getName(),is("a"));
		assertThat(s1.resolve("b").get().getName(),is("b"));
		assertThat(s1.resolve("c").get().getName(),is("c"));
		assertThat(s0.resolve("a").get(), not(sameInstance(root.resolve("a").get())));
		assertThat(s0.resolve("a").get(), sameInstance(s1.resolve("a").get()));
	}
	
	@Test
	public void testNestedScopedSymbolResolve() throws AlreadyDefinedSymbolException{
		ScopedSymbol root = scopedSymbol("s", var("a"));
		ScopedSymbol s0 = scopedSymbol("s", var("b"), var("a"));
		root.define(s0);
		ScopedSymbol s1 = scopedSymbol("s", var("c"));
		s0.define(s1);
		assertThat(s1.resolveLocal("a").isPresent(), is(false));
		assertThat(s1.resolveLocal("b").isPresent(), is(false));
		assertThat(s1.resolveLocal("c").get().getName(),is("c"));
		
		assertThat(s1.resolve("a").get().getName(),is("a"));
		assertThat(s1.resolve("b").get().getName(),is("b"));
		assertThat(s1.resolve("c").get().getName(),is("c"));
		assertThat(s0.resolve("a").get(), not(sameInstance(root.resolve("a").get())));
		assertThat(s0.resolve("a").get(), sameInstance(s1.resolve("a").get()));
		assertThat(s0.resolve("s").get(), not(sameInstance(root.resolve("s").get())));
		assertThat(root.resolve("s").get(), sameInstance(s0));
		assertThat(s0.resolve("s").get(), sameInstance(s1));
		
		try{
			ScopedSymbol sMulti = scopedSymbol("s", var("b"), var("a"));
			root.define(sMulti);
			fail();
		}catch(AlreadyDefinedSymbolException e){
			//expected.
		}
	}
	
	@Test
	public void testSectionAndGlobal() throws AlreadyDefinedSymbolException{
		Scope actual = globalScope(var("a"));
		ScopedSymbol s0 = section("s", var("b"), var("a"));
		actual.define(s0);
		ScopedSymbol s1 = section("s", var("c"), var("d", Access.PRIVATE));
		ScopedSymbol sec = section("sec", Access.PRIVATE, var("c"), var("d", Access.PRIVATE));
		s0.define(s1);
		s0.define(sec);
		
		for(Symbol s : BuiltinTypes.allSymbols()){
			assertThat(s1.resolve(s.getName()).get(), sameInstance(s));
		}
//		for(Symbol s : ParametricType.Constructor.values()){
//			assertThat(s1.resolve(s.getName()).get(), sameInstance(s));
//		}
		
		assertThat(actual.resolveFromOuter("s", "s", "c").get().getName(), is("c"));
		assertThat(s0.resolveFromOuter("sec", "c").get().getName(), is("c"));
		assertThat(s0.resolveFromOuter("sec", "d").isPresent(), is(false));
		assertThat(actual.resolveFromOuter("s", "sec", "c").isPresent(), is(false));
		assertThat(actual.resolveFromOuter("s", "s", "d").isPresent(), is(false));
		assertThat(actual.resolveFromOuter("s", "b", "c").isPresent(), is(false));
		try{
			actual.resolveFromOuter();
			fail();
		}catch(IllegalArgumentException e){
			//expected.
		}
		
		try{
			ScopedSymbol sMulti = section("s", var("b"), var("a"));
			actual.define(sMulti);
			fail();
		}catch(AlreadyDefinedSymbolException e){
			//expected
		}
	}
	
	@Test
	public void testPrint() throws AlreadyDefinedSymbolException, IOException{
		Scope actual = globalScope(var("a"));
		ScopedSymbol s0 = section("s", var("b"), var("a"));
		actual.define(s0);
		ScopedSymbol s1 = section("s", var("c"), var("d", Access.PRIVATE));
		ScopedSymbol sec = section("sec", Access.PRIVATE, var("c"), var("d", Access.PRIVATE));
		s0.define(s1);
		s0.define(sec);
		
		String expected = null;
		try(BufferedReader rd = new BufferedReader(new FileReader(dir.resolve("expected_scope_tree.txt").toFile()))){
			expected = rd.lines().map(s->s+NEWLINE).collect(Collectors.joining());
		}
		
		//PrintStream prn = System.err;
		StringWriter sw = new StringWriter();
		PrintWriter prn = new PrintWriter(sw);
		actual.dump(prn);
		
		dump(actual, dir.resolve("actual_scope_tree.txt"));

		assertThat(sw.toString(), is(expected));
		
	}
}
