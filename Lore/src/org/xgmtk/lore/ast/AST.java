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


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.logging.Logger;


/**
 * 
 * @author kando
 *
 */
public class AST implements Iterable<AST>, Cloneable{
	public static AST build(URL src, String encoding, Logger logger) throws IOException{
		ASTBuilder builder = new ASTBuilder(src, encoding, logger);
		return builder.getTree();
	}
	
	public static AST build(URL src, Logger logger) throws IOException {
		ASTBuilder builder = new ASTBuilder(src, logger);
		return builder.getTree();
	}

	/**
	 * This iterator visits tree nodes in depth first manner.
	 * Note: A non-leaf node would be visited in two or more times.
	 * 
	 * @author kando
	 *
	 */
	public static class DepthFirstIterator implements Iterator<AST>{
		private static class Record{
			public final AST tree;
			public int subtreeIndex;
			
			public Record(AST tree){
				super();
				this.tree = tree;
				this.subtreeIndex = 0;
			}
		}
		
		private Stack<Record> stack;
		private Record current;
		private boolean first;
		private boolean last;

		private DepthFirstIterator(AST root){
			this.stack = new Stack<>();
			this.current = new Record(root);
		}
		
		@Override
		public boolean hasNext() {
			return this.current != null;
		}

		private final boolean hasNextChild() {
			return current.subtreeIndex < current.tree.subtrees.size();
		}

		@Override
		public AST next() {
			AST r = current.tree;
			this.first = (current.subtreeIndex == 0);
			this.last = (current.subtreeIndex == current.tree.subtrees.size());
			if(hasNextChild()){
				Record rec = new Record(current.tree.subtrees.get(current.subtreeIndex));
				++current.subtreeIndex;
				stack.push(current);
				current = rec;
			}else{
				if(stack.isEmpty()){
					this.current = null;
				}else{
					current = stack.pop();
				}
			}
			return r;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("A node of AbstractSyntaxTree should not be removed.");
		}

		/**
		 * This node, which is returned from the last invocation of the method, is the first time visited?
		 * @return
		 */
		public boolean firstVisited() {
			return this.first;
		}

		/**
		 * This node, which is returned from the last invocation of the method, will be visited no more?
		 * @return
		 */
		public boolean lastVisited() {
			return this.last;
		}
	}

	public static void testExtendedPartEquality(AST a, AST b) throws Exception{
		a.testExtendedPartEquality(b);
	}

	protected void testExtendedPartEquality(AST tb) throws Exception {
		//default
	}

	/**
	 * The name of the root node of this tree.
	 */
	public final NodeType symbol;
	

	public final Locator locator;


	/**
	 * The list of subtrees of this tree.
	 */
	private final List<AST> subtrees;

	/**
	 * Initializer.
	 *  
	 * @param symbol
	 * @param subtrees
	 */
	public AST(NodeType symbol, Locator location, AST...subtrees){
		Objects.requireNonNull(symbol);
		Objects.requireNonNull(location);
		this.locator = location;
		this.symbol = symbol;
		List<AST> trees = new ArrayList<>();
		for(AST t : subtrees){
			Objects.requireNonNull(t);
			trees.add(t);
		}
		this.subtrees = trees;
	}
	
	@Override
	public AST clone(){
		return new AST(this.symbol, this.locator, cloneChildren());
	}

	protected AST[] cloneChildren() {
		AST[] subtrees = new AST[this.subtrees.size()];
		int i = 0;
		for(AST n : this.subtrees){
			subtrees[i++] = n.clone();
		}
		return subtrees;
	}

	@Override
	public DepthFirstIterator iterator(){
		return new DepthFirstIterator(this);
	}

	/**
	 * Returns unmodifiable children list.
	 * 
	 * @return
	 */
	public List<AST> getMdifiableChildren() {
		return this.subtrees;
	}
	
	/**
	 * Returns modifiable children list.
	 * 
	 * @return
	 */
	public List<AST> getChildren() {
		return Collections.unmodifiableList(this.subtrees);
	}

	void enter(ASTVisitor astVisitor) {
		astVisitor.enter(this);
	}

	void exit(ASTVisitor astVisitor) {
		astVisitor.exit(this);
	}
}
