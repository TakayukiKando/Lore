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

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import org.xgmtk.lore.symbols.FormDef;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 * 
 */
public class UnitType extends FormDef {
	private String baseTypeName;
	private Number factor;
	private NumberType factorType;
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param unitName
	 * @param baseTypeName this argument is able to be null.
	 * @param factorType
	 */
	protected UnitType(String unitName, String baseTypeName, Number factor) {
		super(unitName);
		Objects.nonNull(factor);
		this.baseTypeName = baseTypeName;
		this.factor = factor;
		this.factorType = UnitBaseType.getType(factor);
		this.setParentTypeQName(Arrays.asList(this.baseTypeName == null ? UnitBaseType.getTypeName(this.factorType): this.baseTypeName));
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param unitName
	 * @param baseTypeName
	 * @param factorType
	 */
	public UnitType(String unitName, Double factor, String baseTypeName) {
		this(unitName, baseTypeName, (Number)factor);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param unitName
	 * @param factorType
	 */
	public UnitType(String unitName, Double factor) {
		this(unitName, null, (Number)factor);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param unitName
	 * @param baseTypeName
	 * @param factorType
	 */
	public UnitType(String unitName, Long factor, String baseTypeName) {
		this(unitName, baseTypeName, (Number)factor);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param unitName
	 * @param factorType
	 */
	public UnitType(String unitName, Long factor) {
		this(unitName, null, (Number)factor);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public Optional<String> getBaseTypeName(){
		return Optional.ofNullable(this.baseTypeName);
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public NumberType getFactorType(){
		return this.factorType;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public Number getFactor(){
		return this.factor;
	}
}
