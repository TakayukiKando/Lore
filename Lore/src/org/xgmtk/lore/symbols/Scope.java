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

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Stack;
import java.util.logging.Logger;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public abstract class Scope implements Iterable<Scope> {
	public static Scope build(Path src, Logger logger) throws IOException {
		ScopeBuilder builder = new ScopeBuilder(logger, src);
		builder.build();
		return builder.getRoot();
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @author kando
	 *
	 */
	public static class AlreadyDefinedException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @author kando
	 *
	 */
	public static class ScopeIterator implements Iterator<Scope>{
		private static class Record{
			public final Scope tree;
			public int subtreeIndex;
			
			public Record(Scope tree){
				super();
				this.tree = tree;
				this.subtreeIndex = 0;
			}
		}
		
		private Stack<Record> stack;
		private Record current;
		private boolean first;
		private boolean last;
	
		private ScopeIterator(Scope root){
			this.stack = new Stack<>();
			this.current = new Record(root);
		}
		
		@Override
		public boolean hasNext() {
			return this.current != null;
		}
	
		private final boolean hasNextChild() {
			return current.subtreeIndex < current.tree.getSubScopes().size();
		}
	
		@Override
		public Scope next() {
			Scope r = current.tree;
			this.first = (current.subtreeIndex == 0);
			this.last = (current.subtreeIndex == current.tree.getSubScopes().size());
			if(hasNextChild()){
				Record rec = new Record(current.tree.getSubScopes().get(current.subtreeIndex));
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
			throw new UnsupportedOperationException("A node of Scope Tree should not be removed.");
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

	private Scope nestScope;
	private final Map<String, Symbol> table;
	private final List<Scope> subScopes;

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 */
	protected Scope(){
		this.nestScope = null;
		this.table = new HashMap<>();
		this.subScopes = new ArrayList<>();
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param scopedSymbol
	 */
	protected final void setParent(Scope scopedSymbol) {
		this.nestScope = scopedSymbol;
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return nullable. null, if this scope is root of tree.
	 */
	public final Optional<Scope> getParent(){
		return Optional.ofNullable(this.nestScope);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return unmodifiable.
	 */
	public final List<Scope> getSubScopes() {
		return Collections.unmodifiableList(this.subScopes);
	}

	@Override
	public final ScopeIterator iterator() {
		return new ScopeIterator(this);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public int definitions() {
		return this.table.size();
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param symbols
	 * @throws AlreadyDefinedException
	 */
	public final void defineAll(Symbol...symbols) throws AlreadyDefinedException{
		for(Symbol s : symbols){
			this.define(s);
		}
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param symbol
	 * @throws AlreadyDefinedException
	 */
	public final void define(Symbol symbol) throws AlreadyDefinedException{
		Objects.requireNonNull(symbol, "A symbol should not be null.");
		if(isDefined(symbol)){
			throw new AlreadyDefinedException();
		}
		this.table.put(symbol.getName(), symbol);
		if(symbol instanceof Scope){
			this.put((Scope)symbol);
		}
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param scope
	 * @throws AlreadyDefinedException
	 */
	public final void put(Scope scope) throws AlreadyDefinedException{
		Objects.requireNonNull(scope, "A scope should not be null.");
		if(this.subScopes.contains(scope)){
			throw new AlreadyDefinedException();
		}
		this.subScopes.add(scope);
		scope.setParent(this);
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param symbol
	 * @return
	 */
	public final boolean isDefined(Symbol symbol) {
		return this.table.containsKey(symbol.getName());
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @return nullable. null, if the specified symbol is not found in this scope.
	 */
	public Optional<Symbol> resolveLocal(String name){
		return Optional.ofNullable(this.table.get(name));
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @return
	 */
	public Optional<Symbol> resolve(String name){
		Optional<Symbol> s = this.resolveLocal(name);
		if(!s.isPresent()){
			 Optional<Scope> parent = this.getParent();
			if(parent.isPresent()){
				return parent.get().resolve(name);
			}
		}
		return s;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param names
	 * @return
	 */
	public final Optional<Symbol> resolveFromOuter(String...names){
		return resolveFromOuter(0, names);
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param depth
	 * @param names
	 * @return
	 */
	protected abstract Optional<Symbol> resolveFromOuter(int depth, String...names);
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return unmodifiable.
	 */
	public final Map<String,Symbol> getSymbolTable(){
		return Collections.unmodifiableMap(this.table);
	}

	void enter(ScopeTreeVisitor astVisitor) {
		astVisitor.enter(this);
	}

	void exit(ScopeTreeVisitor astVisitor) {
		astVisitor.exit(this);
	}
}
