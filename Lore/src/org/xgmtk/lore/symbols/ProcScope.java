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

public class ProcScope extends ScopedSymbol implements Typed {
	private final ProcStyle procStyle;
	private Type type;
	
	public ProcScope(String name, Access access, ProcStyle procType) {
		super(name, access);
		this.procStyle = procType;
		this.type = Type.NOT_DEFINED;
	}
	
	public final ProcStyle getProcStyle(){
		return this.procStyle;
	}
	
	public final boolean hasReturnValue(){
		return this.getProcStyle().hasReturnValue;
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
