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
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.xgmtk.lore.ast.scanner.UnexpectedLiteralTypeException;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public abstract class Scope {
	private static final String INDENT = "  ";

	public static Scope build(URL src, Logger logger) throws IOException, UnexpectedLiteralTypeException {
		ScopeBuilder builder = new ScopeBuilder(logger);
		return builder.build(src);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @author kando
	 *
	 */
	public static class AlreadyDefinedSymbolException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public AlreadyDefinedSymbolException(String duplicatedName){
			super("\""+duplicatedName+"\" is already defined.");
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
		this.table = new LinkedHashMap<>();
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
	public final void defineAll(Symbol...symbols) throws AlreadyDefinedSymbolException{
		for(Symbol s : symbols){
			this.define(s);
		}
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param symbol
	 * @throws AlreadyDefinedSymbolException
	 */
	public final void defineWithoutPutScope(Symbol symbol)
			throws AlreadyDefinedSymbolException {
		Objects.requireNonNull(symbol, "A symbol should not be null.");
		if(isDefined(symbol)){
			throw new AlreadyDefinedSymbolException(symbol.getName());
		}
		this.table.put(symbol.getName(), symbol);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param symbol
	 * @throws AlreadyDefinedException
	 */
	public final void define(Symbol symbol) throws AlreadyDefinedSymbolException{
		defineWithoutPutScope(symbol);
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
	public final void put(Scope scope) throws AlreadyDefinedSymbolException{
		Objects.requireNonNull(scope, "A scope should not be null.");
		if(this.subScopes.contains(scope)){
			throw new AlreadyDefinedSymbolException("(no named scope)");
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
	
	private static String indent(int depth){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < depth; ++i){
			sb.append(INDENT);
		}
		return sb.toString();
	}
	
	private final void printSymbols(PrintWriter out, int depth) {
		String indent = indent(depth);
		List<String> list = new ArrayList<>(this.getSymbolTable().keySet());
//		Collections.sort(list);
		for(String k : list){
			Symbol sym = this.resolveLocal(k).get();
			out.println(indent+sym.getDescription());
		}
	}

	private final void dump(PrintWriter out, int depth){
		//out.print("<indent="+depth+">");
		String indent = indent(depth);
		out.print(indent);
		if(this instanceof Symbol){
			out.print(((Symbol)this).getDescription());
		}
		out.println("{");
		out.println(indent+"//Symbols");
		printSymbols(out, depth+1);
		out.println(indent+"//Sub-scopes");
		for(Scope scope: this.getSubScopes()){
			scope.dump(out, depth+1);
		}
		out.println(indent+"}");
		out.flush();
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param out
	 */
	public final void dump(PrintWriter out){
		//out.println("dump(PrintWriter out)");
		dump(out, 0);
		out.flush();
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param out
	 */
	public final void dump(PrintStream out){
		//out.println("dump(PrintStream out)");
		dump(new PrintWriter(new OutputStreamWriter(out)), 0);
		out.flush();
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public String getScopeDescription() {
		String description = this.getParent().isPresent()? this.getParent().get().getScopeDescription(): "[This scope is root]";
		return "[class: \""+this.getClass().getSimpleName()+"\", parent: "+description+"]";
	}
}
