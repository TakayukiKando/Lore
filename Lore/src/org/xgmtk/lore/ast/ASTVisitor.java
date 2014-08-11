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

import org.xgmtk.lore.ast.AST.DepthFirstIterator;

public abstract class ASTVisitor {
	
	public final void visitTo(AST root) {
		DepthFirstIterator it = root.iterator();
		while(it.hasNext()){
			AST t = it.next();
//			System.err.print(t.name);
			if(it.firstVisited()){
//				System.err.print(" (first: true)");
				t.enter(this);
			}
			if(it.lastVisited()){
//				System.err.print(" (last: true)");
				t.exit(this);
			}
//			System.err.println(";");
		}
	}

	
	/**
	 * This is called when entering a tree node.
	 * @param node
	 */
	public abstract void enter(AST node);

	/**
	 * This is called when exiting a tree node.
	 * @param node
	 */
	public abstract void exit(AST node);
	/**
	 * This is called when entering a tree node.
	 * @param node
	 */
	public abstract void enter(ID node);

	/**
	 * This is called when exiting a tree node.
	 * @param node
	 */
	public abstract void exit(ID node);
	/**
	 * This is called when entering a tree node.
	 * @param node
	 */
	public abstract <T> void enter(Literal<T> node);

	/**
	 * This is called when exiting a tree node.
	 * @param node
	 */
	public abstract <T> void exit(Literal<T> node);
}