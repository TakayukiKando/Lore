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
 * @author kando
 *
 */
public class ScopedSymbol extends BaseScope implements Symbol{

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @param symbols
	 * @return
	 * @throws AlreadyDefinedException
	 */
	public static ScopedSymbol scopedSymbol(String name, Symbol...symbols) throws AlreadyDefinedException {
		return scopedSymbol(name, false, symbols);
	}
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @param isPrivate
	 * @param symbols
	 * @return
	 * @throws AlreadyDefinedException
	 */
	public static ScopedSymbol scopedSymbol(String name, boolean isPrivate, Symbol...symbols) throws AlreadyDefinedException {
		ScopedSymbol baseScope = new ScopedSymbol(name, isPrivate);
		baseScope.defineAll(symbols);
		return baseScope;
	}

	private final String name;
	private final boolean isPraivate;

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @param isPrivate 
	 */
	public ScopedSymbol(String name, boolean isPrivate){
		this.name = name;
		this.isPraivate = isPrivate;
	}
	
	@Override
	public final String getName() {
		return this.name;
	}

	@Override
	public boolean isPrivate() {
		return this.isPraivate;
	}
	
	void enter(ScopeTreeVisitor astVisitor) {
		astVisitor.enter(this);
	}

	void exit(ScopeTreeVisitor astVisitor) {
		astVisitor.exit(this);
	}

	@Override
	public String toString(){
		return Symbol.getDescription(this);
	}
}
