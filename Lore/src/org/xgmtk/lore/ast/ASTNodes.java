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
package org.xgmtk.lore.ast;

import org.xgmtk.lore.symbols.builtin.BuiltinTypes;

/**
 * 
 * @author kando
 *
 */
public class ASTNodes {
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @param location
	 * @param subtrees
	 * @return
	 */
	public static AST node(NonTerminalSymbol symbol, Locator location, AST...subtrees){
		AST ast = new AST(symbol, location, subtrees);
		return ast;
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param value
	 * @param location
	 * @return
	 */
	public static ID id(String id, Locator location){
		return new ID(id, location);
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param value
	 * @param location
	 * @return
	 */
	public static <T> Literal<T> lit(T value, Locator location){
		Literal<T> literal = new Literal<T>(value, location);
		literal.setType(BuiltinTypes.findBuiltinType(value.getClass()).get());
		return literal;
	}
}
