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
package org.xgmtk.lore.symbols.builtin;

import org.xgmtk.lore.symbols.Access;
import org.xgmtk.lore.symbols.FormDef;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class BuiltinType extends FormDef {
	
	private final Class<?> valueClass;

	public BuiltinType(String name, Class<?> valueClass) {
		super(name, Access.PUBLIC);
		this.valueClass = valueClass;
	}
	
	public final Class<?> getValueClass(){
		return this.valueClass;
	}
}
