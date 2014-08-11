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

import static org.xgmtk.lore.utils.StringUtils.tabs;

import java.io.PrintStream;

/**
 * 
 * @author kando
 *
 */
public class PrintVisitor extends ASTVisitor{
	private int depth;
	private PrintStream out;
	private boolean ignoreLocator;

	public PrintVisitor(PrintStream out, boolean ignoreLocator){
		this.out = out;
		this.depth = 0;
		this.ignoreLocator = ignoreLocator;
	}
	
	@Override
	public void enter(AST node) {
//		System.err.println("node id: "+node+", node type: "+node.symbol.toString()+", node class: \""+node.getClass().getName()+"\"");
		String tabs = tabs(depth);
		out.print(tabs);
		out.println("{");
		++depth;
		tabs = tabs(depth);
		out.println(tabs+"node class: \""+node.getClass().getName()+"\"");
		out.println(tabs+"node type: "+node.symbol.toString());
		if(!this.ignoreLocator){
			out.println(tabs+"locator: ("+node.locator+")");
		}
	}

	@Override
	public void exit(AST node) {
		--depth;
		out.println(tabs(depth)+"}");
	}

	public static void printTree(AST tree, final PrintStream out, boolean ignoreLocator) {
		ASTVisitor printer = new PrintVisitor(out, ignoreLocator);
		
		printer.visitTo(tree);
	}

	@Override
	public void enter(ID node) {
		enter((AST)node);
		out.println(tabs(depth)+"id: \""+node.id+"\"");
	}

	@Override
	public void exit(ID node) {
		exit((AST)node);
	}

	@Override
	public <T> void enter(Literal<T> node) {
		enter((AST)node);
		String tabs = tabs(depth);
		out.println(tabs+"literal type: \""+node.value.getClass().getName()+"\"");
		out.println(tabs+"literal value: \""+node.value.toString()+"\"");
	}

	@Override
	public <T> void exit(Literal<T> node) {
		exit((AST)node);
	}
	
}