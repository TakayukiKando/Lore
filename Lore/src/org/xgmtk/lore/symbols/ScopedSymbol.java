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

import java.util.Objects;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class ScopedSymbol extends BaseScope implements Symbol{
	private final String name;
	private final Access access;

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @param isPrivate 
	 * @param srcAST 
	 */
	public ScopedSymbol(String name, Access access){
		Objects.nonNull(name);
		Objects.nonNull(access);
		this.name = name;
		this.access = access;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @param srcAST
	 */
	public ScopedSymbol(String name){
		this(name, Access.PUBLIC);
	}
	
	@Override
	public final String getName() {
		return this.name;
	}

	@Override
	public Access getAccess() {
		return this.access;
	}

	@Override
	public String toString(){
		return getDescription();
	}
	

	@Override
	public String getScopeDescription() {
		String description = this.getParent().isPresent()? this.getParent().get().getScopeDescription(): "[This scope is root]";
		return "["+this.getDescription()+", parent: "+description+"]";
	}
}
