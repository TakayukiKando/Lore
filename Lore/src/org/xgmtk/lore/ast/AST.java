package org.xgmtk.lore.ast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author kando
 *
 */
public class AST implements Iterable<AST>{
	public static AST build(File src, String encoding) throws IOException{
		ASTBuilder builder = new ASTBuilder(src, encoding);
		return builder.getTree();
	}
	
	public interface Visitor {
		/**
		 * This is called when entering a tree node.
		 * @param node
		 */
		void enter(AST node);
	
		/**
		 * This is called when exiting a tree node.
		 * @param node
		 */
		void exit(AST node);
	
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
	
	/**
	 * The name of the root node of this tree.
	 */
	public final String name;
	
	/**
	 * The list of subtrees of this tree.
	 */
	public final List<AST> subtrees;
	
	/**
	 * Initializer.
	 *  
	 * @param name
	 * @param subtrees
	 */
	public AST(String name, AST...subtrees){
		this.name = name;
		List<AST> trees = new ArrayList<>();
		for(AST t : subtrees){
			trees.add(t);
		}
		this.subtrees = Collections.unmodifiableList(trees);
	}
	
	@Override
	public DepthFirstIterator iterator(){
		return new DepthFirstIterator(this);
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof AST)){
			return false;
		}
		AST t = (AST)o;
		if(!this.name.equals(t.name)){
			return false;
		}
		if(this.subtrees.size() != t.subtrees.size()){
			return false;
		}
		for(int i = 0; i < this.subtrees.size(); ++i){
			if(!this.subtrees.get(i).equals(t.subtrees.get(i))){
				return false;
			}
		}
		return true;	
	}
	
	@Override
	public int hashCode(){
		int h = this.name.hashCode();
		for(AST t: this.subtrees){
			h += t.hashCode();
		}
		return h;
	}

	public void visit(Visitor visitor) {
		DepthFirstIterator it = this.iterator();
		while(it.hasNext()){
			AST t = it.next();
//			System.err.print(t.name);
			if(it.firstVisited()){
//				System.err.print(" (first: true)");
				visitor.enter(t);
			}
			if(it.lastVisited()){
//				System.err.print(" (last: true)");
				visitor.exit(t);
			}
//			System.err.println(";");
		}
	}
}
