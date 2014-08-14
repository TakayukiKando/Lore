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


/**
 * TODO write JavaDoc comment.
 * 
 * This is the root of scope tree structure.
 * 
 * @author kando
 *
 */
public class GlobalScope extends Section {
	/**
	 * TODO write JavaDoc comment.
	 */
	public static final String ROOT_SCOPE_NAME = "$root";
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param symbols
	 * @return
	 * @throws AlreadyDefinedException
	 */
	public static GlobalScope globalScope(Symbol...symbols) throws AlreadyDefinedException {
		GlobalScope baseScope = new GlobalScope();
		baseScope.defineAll(symbols);
		return baseScope;
	}

	/**
	 * TODO write JavaDoc comment.
	 */
	public GlobalScope(){
		super(ROOT_SCOPE_NAME, false);
		try{
			this.defineAll(PrimitiveTypeSymbol.values());
			this.defineAll(TypeConstructorSymbol.values());
		}catch (AlreadyDefinedException e){
			throw new IllegalStateException("Unexpected internal error.", e);
		}
	}
	
	void enter(ScopeTreeVisitor astVisitor) {
		astVisitor.enter(this);
	}

	void exit(ScopeTreeVisitor astVisitor) {
		astVisitor.exit(this);
	}
}
