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

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class PrintVisitor extends ScopeTreeVisitor{
	private static final String INDENT = "  ";

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param scope
	 * @param prn
	 */
	public static void printScopeTree(Scope scope, PrintStream prn) {
		printScopeTree(scope, new PrintWriter(new OutputStreamWriter(prn)));
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param scope
	 * @param prn
	 */
	public static void printScopeTree(Scope scope, PrintWriter prn) {
		ScopeTreeVisitor printer = new PrintVisitor(prn);
		printer.visitTo(scope);
	}
	
	private int depth;
	private PrintWriter out;
	
	private String indent(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.depth; ++i){
			sb.append(INDENT);
		}
		return sb.toString();
	}

	private void printSymbol(Scope scope) {
		String indent = indent()+INDENT;
		List<String> list = new ArrayList<>(scope.getSymbolTable().keySet());
		Collections.sort(list);
		for(String k : list){
			Symbol sym = scope.resolveLocal(k).get();
			out.println(indent+sym);
		}
	}

	public void openScopePrint(Scope scope) {
		out.print(indent()+"{");
		if(scope instanceof Symbol){
			out.print("\""+((Symbol)scope).getName()+"\"");
		}
		out.println();
		printSymbol(scope);
		++this.depth;
	}

	public void closeScopePrint() {
		--this.depth;
		out.println(indent()+"}");
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param out
	 */
	public PrintVisitor(PrintWriter out){
		this.out = out;
		this.depth = 0;
	}

	@Override
	public void enter(BaseScope scope) {
		openScopePrint(scope);
	}

	@Override
	public void exit(BaseScope scope) {
		closeScopePrint();
	}

	@Override
	public void enter(GlobalScope scope) {
		openScopePrint(scope);
	}

	@Override
	public void exit(GlobalScope scope) {
		closeScopePrint();
	}

	@Override
	public void enter(Scope scope) {
		openScopePrint(scope);
	}

	@Override
	public void exit(Scope scope) {
		closeScopePrint();
	}

	@Override
	public void enter(ScopedSymbol scope) {
		openScopePrint(scope);
	}

	@Override
	public void exit(ScopedSymbol scope) {
		closeScopePrint();
	}

	@Override
	public void enter(Section scope) {
		openScopePrint(scope);
	}

	@Override
	public void exit(Section scope) {
		closeScopePrint();
	}

	@Override
	public void enter(FormDef scope) {
		openScopePrint(scope);
	}

	@Override
	public void exit(FormDef scope) {
		closeScopePrint();
	}
}
