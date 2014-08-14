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

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 
 * @author kando
 *
 */
public class PrintVisitor extends ASTVisitor{
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param scope
	 * @param prn
	 */
	public static void printTree(AST tree, PrintStream prn, boolean ignoreLocator) {
		printTree(tree, new PrintWriter(new OutputStreamWriter(prn)), ignoreLocator);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param scope
	 * @param prn
	 */
	public static void printTree(AST tree, PrintWriter prn, boolean ignoreLocator) {
		ASTVisitor printer = new PrintVisitor(prn, ignoreLocator);
		printer.visitTo(tree);
	}

	private int depth;
	private PrintWriter out;
	private boolean ignoreLocator;

	public PrintVisitor(PrintWriter out, boolean ignoreLocator){
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