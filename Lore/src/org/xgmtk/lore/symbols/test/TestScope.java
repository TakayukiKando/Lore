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
import static org.xgmtk.lore.symbols.GlobalScope.globalScope;
import static org.xgmtk.lore.symbols.PrintVisitor.printScopeTree;
import static org.xgmtk.lore.symbols.Section.section;
import static org.xgmtk.lore.symbols.ScopedSymbol.scopedSymbol;
import static org.xgmtk.lore.symbols.VariableSymbol.var;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;
import org.xgmtk.lore.symbols.BaseScope;
import org.xgmtk.lore.symbols.PrimitiveTypeSymbol;
import org.xgmtk.lore.symbols.Scope;
import org.xgmtk.lore.symbols.Symbol;
import org.xgmtk.lore.symbols.Scope.AlreadyDefinedException;
import org.xgmtk.lore.symbols.ScopedSymbol;
import org.xgmtk.lore.symbols.TypeConstructorSymbol;

public class TestScope {
	private static final String NEWLINE;
	static{
		NEWLINE = System.getProperties().getProperty("line.separator");
	}
	
	@Test
	public void testSimpleResolve() throws AlreadyDefinedException{
		Scope s = baseScope(var("a"),var("b"));
		assertThat(s.resolveLocal("a").get().getName(),is("a"));
		assertThat(s.resolveLocal("b").get().getName(),is("b"));
		assertThat(s.resolveLocal("c").isPresent(), is(false));
		
		assertThat(s.resolve("a").get().getName(),is("a"));
		assertThat(s.resolve("b").get().getName(),is("b"));
		assertThat(s.resolve("c").isPresent(), is(false));
	}
	
	@Test
	public void testNestedResolve() throws AlreadyDefinedException{
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
	public void testNestedScopedSymbolResolve() throws AlreadyDefinedException{
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
		}catch(AlreadyDefinedException e){
			//expected.
		}
	}
	
	@Test
	public void testSectionAndGlobal() throws AlreadyDefinedException{
		Scope g = globalScope(var("a"));
		ScopedSymbol s0 = section("s", var("b"), var("a"));
		g.define(s0);
		ScopedSymbol s1 = section("s", var("c"), var("d", true));
		ScopedSymbol sec = section("sec", true, var("c"), var("d", true));
		s0.define(s1);
		s0.define(sec);
		
		for(Symbol s : PrimitiveTypeSymbol.values()){
			assertThat(s1.resolve(s.getName()).get(), sameInstance(s));
		}
		for(Symbol s : TypeConstructorSymbol.values()){
			assertThat(s1.resolve(s.getName()).get(), sameInstance(s));
		}
		
		assertThat(g.resolveFromOuter("s", "s", "c").get().getName(), is("c"));
		assertThat(s0.resolveFromOuter("sec", "c").get().getName(), is("c"));
		assertThat(s0.resolveFromOuter("sec", "d").isPresent(), is(false));
		assertThat(g.resolveFromOuter("s", "sec", "c").isPresent(), is(false));
		assertThat(g.resolveFromOuter("s", "s", "d").isPresent(), is(false));
		assertThat(g.resolveFromOuter("s", "b", "c").isPresent(), is(false));
		try{
			g.resolveFromOuter();
			fail();
		}catch(IllegalArgumentException e){
			//expected.
		}
		
		try{
			ScopedSymbol sMulti = section("s", var("b"), var("a"));
			g.define(sMulti);
			fail();
		}catch(AlreadyDefinedException e){
			//expected
		}
	}
	
	@Test
	public void testPrint() throws AlreadyDefinedException{
		Scope g = globalScope(var("a"));
		ScopedSymbol s0 = section("s", var("b"), var("a"));
		g.define(s0);
		ScopedSymbol s1 = section("s", var("c"), var("d", true));
		ScopedSymbol sec = section("sec", true, var("c"), var("d", true));
		s0.define(s1);
		s0.define(sec);
		
		String expected = 
			"{\"$root\""+NEWLINE+
			"  [\"a\", public, \"VariableSymbol\"]"+NEWLINE+
			"  [\"dice\", public, \"PrimitiveTypeSymbol\"]"+NEWLINE+
			"  [\"html\", public, \"PrimitiveTypeSymbol\"]"+NEWLINE+
			"  [\"integer\", public, \"PrimitiveTypeSymbol\"]"+NEWLINE+
			"  [\"list\", public, \"TypeConstructorSymbol\"]"+NEWLINE+
			"  [\"locator\", public, \"PrimitiveTypeSymbol\"]"+NEWLINE+
			"  [\"range\", public, \"TypeConstructorSymbol\"]"+NEWLINE+
			"  [\"real\", public, \"PrimitiveTypeSymbol\"]"+NEWLINE+
			"  [\"s\", public, \"Section\"]"+NEWLINE+
			"  [\"string\", public, \"PrimitiveTypeSymbol\"]"+NEWLINE+
			"  [\"unit\", public, \"TypeConstructorSymbol\"]"+NEWLINE+
			"  [\"url\", public, \"PrimitiveTypeSymbol\"]"+NEWLINE+
			"  [\"xml\", public, \"PrimitiveTypeSymbol\"]"+NEWLINE+
			"  {\"s\""+NEWLINE+
			"    [\"a\", public, \"VariableSymbol\"]"+NEWLINE+
			"    [\"b\", public, \"VariableSymbol\"]"+NEWLINE+
			"    [\"s\", public, \"Section\"]"+NEWLINE+
			"    [\"sec\", private, \"Section\"]"+NEWLINE+
			"    {\"s\""+NEWLINE+
			"      [\"c\", public, \"VariableSymbol\"]"+NEWLINE+
			"      [\"d\", private, \"VariableSymbol\"]"+NEWLINE+
			"    }"+NEWLINE+
			"    {\"sec\""+NEWLINE+
			"      [\"c\", public, \"VariableSymbol\"]"+NEWLINE+
			"      [\"d\", private, \"VariableSymbol\"]"+NEWLINE+
			"    }"+NEWLINE+
			"  }"+NEWLINE+
			"}"+NEWLINE;
		
		//PrintStream prn = System.err;
		StringWriter sw = new StringWriter();
		PrintWriter prn = new PrintWriter(sw);
		printScopeTree(g, prn);
		
		assertThat(sw.toString(), is(expected));
		
	}
}
