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

import java.util.Arrays;
import java.util.Optional;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class Section extends ScopedSymbol {
	/**
	 * TODO write JavaDoc comment.
	 * @param name
	 * @param isPrivate 
	 */
	public Section(String name, Access access) {
		super(name, access);
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * @param name
	 */
	public Section(String name) {
		this(name, Access.PUBLIC);
	}
	
	@Override
	protected final Optional<Symbol> resolveFromOuter(int depth, String...names) {
		if(names.length < 1){
			throw new IllegalArgumentException("At least 1 identifier is required.");
		}
		Optional<Symbol> sym = resolveLocal(names[0]);
		
		if(!sym.isPresent()){
			return sym;
		}
		
		Symbol symbol = sym.get();

		if(symbol.getAccess().equals(Access.PRIVATE) && depth > 0){
			return Optional.empty();
		}
		
		if(names.length == 1){
			return sym;
		}

		if(!(symbol instanceof Scope)){
			return Optional.empty();
		}
		
		Scope nested = (Scope)symbol;
		String[] sub = Arrays.asList(names).subList(1, names.length).toArray(new String[0]);
		return nested.resolveFromOuter(depth + 1, sub);
	}
}
