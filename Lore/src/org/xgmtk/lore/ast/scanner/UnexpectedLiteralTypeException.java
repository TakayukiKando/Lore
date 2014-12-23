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
package org.xgmtk.lore.ast.scanner;

import java.util.Arrays;

import org.xgmtk.lore.ast.Locator;
import org.xgmtk.lore.ast.ASTException;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class UnexpectedLiteralTypeException extends ASTException {

	/**
	 * TODO write JavaDoc comment.
	 */
	private static final long serialVersionUID = 1L;

	@SafeVarargs
	public UnexpectedLiteralTypeException(Locator locator, Class<? extends Object> actual, Class<? extends Object>... expecteds) {
		super(locator, "Expected literal type(s) is(are) "+
				Arrays.stream(expecteds, 0, expecteds.length)
				.map(cls->"\""+cls.getName()+"\"")
				.reduce("", (a,b)->String.join(", ", a, b))+
				" but \""+actual.getName()+"\".");
	}
	
}
