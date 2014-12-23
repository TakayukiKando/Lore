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
public class EnumValContent extends ScopedSymbol implements Typed {

	private Type type;

	public EnumValContent(String name) {
		this(name, Access.PUBLIC);
	}
	
	public EnumValContent(String name, Access access) {
		super(name, access);
		this.type = Type.NOT_DEFINED;
	}

	@Override
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Type getType() {
		return this.type;
	}
}
