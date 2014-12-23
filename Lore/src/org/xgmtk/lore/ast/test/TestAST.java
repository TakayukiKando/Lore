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
package org.xgmtk.lore.ast.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.xgmtk.lore.ast.test.ASTMatchers.equalAST;

import java.util.Iterator;
import java.util.Optional;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.ASTNodes;
import org.xgmtk.lore.ast.ASTVisitor;
import org.xgmtk.lore.ast.ID;
import org.xgmtk.lore.ast.Literal;
import org.xgmtk.lore.ast.NonTerminalSymbol;
import org.xgmtk.lore.ast.Locator;
import org.xgmtk.lore.builtin.SimpleString;

/**
 * 
 * @author kando
 *
 */
public class TestAST {
	private static int leafCount;
	private static AST abcd;
	private static AST abcd2;
	private static AST abcde;

	private static AST node(String name, AST... subtrees){
		Optional<NonTerminalSymbol> ot = NonTerminalSymbol.getSymbol(name);
		if(!ot.isPresent()){
			if(subtrees.length != 0){
				throw new IllegalArgumentException("ID and Literal should not have children.");
			}
			if((leafCount++)%2 == 0){
				//System.err.println("create ID node \""+name+"\"");
				return ASTNodes.id(name, Locator.NOWHERE);
			}
			//System.err.println("create Literal node \""+name+"\"");
			return ASTNodes.lit(new SimpleString(name, Locator.NOWHERE, Logger.getGlobal()), Locator.NOWHERE);
		}
		//System.err.println("create normal AST node \""+name+"\"");
		return ASTNodes.node(ot.get(), Locator.NOWHERE, subtrees);
	}
	
	@BeforeClass
	static public void setupStatics(){
		leafCount = 0;
		abcd = node("/", 
				node("a"), 
				node("+", 
						node("*", 
								node("b"), 
								node("c")
						), 
						node("d")
				)
		);
		
		leafCount = 0;
		abcd2 = node("/", 
				node("a"), 
				node("+", 
						node("*", 
								node("b"), 
								node("c")
						), 
						node("d")
				)
		);
		
		leafCount = 0;
		abcde = node("/", 
				node("a"), 
				node("+", 
						node("*", 
								node("b"), 
								node("c")
						), 
						node("d"),
						node("e")
				)
		);
	}
	
	@Test
	public void testEquals(){
		assertThat(abcd, equalAST(abcd2));
		assertThat(abcd2, equalAST(abcd));
		assertThat(abcd, equalAST(abcd));
			
		assertThat(abcd, not(equalAST(abcde)));
		assertThat(abcde, not(equalAST(abcd)));
		assertThat(abcd, not(equalAST(null)));
	}

	@Test
	public void testIterator(){
		Iterator<AST> it = abcd.iterator();
		StringBuilder log = new StringBuilder();
		while(it.hasNext()){
			AST t = it.next();
			if(t instanceof ID){
				log.append(((ID)t).id).append(";");
			}else if(t instanceof Literal){
				log.append(((Literal<?>)t).value.toString()).append(";");
			}else{
				log.append(t.symbol.getSymbolString()).append(";");
			}
		}
		String expectedLog = "/;a;/;+;*;b;*;c;*;+;d;+;/;";

		assertThat(log.toString(), is(expectedLog));
	}
	
	@Test
	public void testClone(){
		AST clone = abcd.clone();
//		System.err.println("abcd:");
//		PrintVisitor.printTree(abcd, System.err, false);
//		System.err.println("abcd clone:");
//		PrintVisitor.printTree(clone, System.err, false);
		assertThat(clone, equalAST(abcd));
		Iterator<AST> itExpected = abcd.iterator();
		Iterator<AST> itClone = clone.iterator();
		while(itExpected.hasNext()){
			AST expectedNode = itExpected.next();
			AST cloneNode = itClone.next();
			assertThat(cloneNode, not(sameInstance(expectedNode)));
		}
	}
	
	@Test
	public void testVisitor(){
		final StringBuilder log = new StringBuilder();
		
		ASTVisitor visitor = new ASTVisitor(){

			@Override
			public void enter(AST node) {
				log.append(node.symbol.getSymbolString()).append("(");
			}

			@Override
			public void exit(AST node) {
				log.append(")");
			}

			@Override
			public void enter(ID node) {
				log.append(node.id).append("(");
			}

			@Override
			public void exit(ID node) {
				exit((AST)node);
			}

			@Override
			public <T> void enter(Literal<T> node) {
				log.append(node.value.toString()).append("(");
			}

			@Override
			public <T> void exit(Literal<T> node) {
				exit((AST)node);
			}
			
		};
		visitor.visitTo(abcd);
		
		String expectedLog = "/(a()+(*(b()c())d()))";

		assertThat(log.toString(), is(expectedLog));
	}
	
	@Test
	public void testGetLocation(){
		for(AST node : abcd){
			assertThat(node.locator, sameInstance(Locator.NOWHERE));
		}
	}
}
