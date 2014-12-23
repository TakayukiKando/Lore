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

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.xgmtk.lore.symbols.builtin.BuiltinTypes;



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
	public static final String ANONYMOUS_TYPES = "$AnonymousTypes";

	public static String createAnonymousTypeName(int n) {
		return "AnonType"+Integer.toHexString(n);
	}

	
	private final AtomicInteger anonymousTypeCounter;

	/**
	 * TODO write JavaDoc comment.
	 */
	public GlobalScope(){
		super(ROOT_SCOPE_NAME, Access.PUBLIC);
		this.anonymousTypeCounter = new AtomicInteger(0);
		try{
			BuiltinTypes.defineAll(this);
			this.define(new Section(ANONYMOUS_TYPES));
			//this.defineAll(ParametricType.Constructor.values());
		}catch (AlreadyDefinedSymbolException e){
			throw new IllegalStateException("Unexpected internal error.", e);
		}
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public String createAnonymousTypeName() {
		return GlobalScope.createAnonymousTypeName(this.anonymousTypeCounter.getAndIncrement());
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param definition
	 * @throws AlreadyDefinedSymbolException
	 */
	public void addAnonymousType(FormDef definition) throws AlreadyDefinedSymbolException{
		Section anons = getAnonymousTypesSection();
		anons.define(definition);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public Section getAnonymousTypesSection() {
		Optional<Symbol> oSym = this.resolve(ANONYMOUS_TYPES);
		if(!oSym.isPresent()){
			throw new IllegalStateException("Unexpected internal error: "+ANONYMOUS_TYPES+" section is not defined.");
		}
		Symbol symAnons = oSym.get();
		if(!(symAnons instanceof Section)){
			throw new IllegalStateException("Unexpected internal error: "+ANONYMOUS_TYPES+" symbol is not a Section.");
		}
		Section anons = (Section)symAnons;
		return anons;
	}
}
