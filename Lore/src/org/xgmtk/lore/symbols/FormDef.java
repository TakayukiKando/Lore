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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.xgmtk.lore.ast.ID;
import org.xgmtk.lore.ast.Type;

public class FormDef extends Section implements Type {
	public static final String ROOT_TYPE = "object";
	
	private List<String> parentTypeQName;

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @param access 
	 * @return
	 * @throws AlreadyDefinedException
	 */
	public FormDef(String name, Access access) {
		super(name, access);
		this.parentTypeQName = Arrays.asList(FormDef.ROOT_TYPE);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 * @return
	 * @throws AlreadyDefinedException
	 */
	public FormDef(String name) {
		this(name, Access.PUBLIC);
	}
	
	public final void setParentTypeQNameIds(List<ID> parentTypeQName) {
		this.setParentTypeQName(parentTypeQName.stream().map(id->id.id).collect(Collectors.toList()));
	}
	
	public final void setParentTypeQName(List<String> parentTypeQName) {
		this.parentTypeQName = parentTypeQName;
	}

	public final List<String> getParentTypeQName(){
		return Collections.unmodifiableList(this.parentTypeQName);
	}
}
