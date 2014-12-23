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

import org.xgmtk.lore.ast.Type;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class VariableSymbol implements Symbol, Typed {
	private final String name;
	private final Access access;
	private Type type;
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @param access
	 */
	public VariableSymbol(String name, Access access) {
		this.name = name;
		this.access = access;
		this.type = Type.NOT_DEFINED;
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 */
	public VariableSymbol(String name) {
		this(name, Access.PUBLIC);
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public Access getAccess() {
		return this.access;
	}

	@Override
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public String toString(){
		return getDescription();
	}
}