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
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.xgmtk.lore.ast.ID;
import org.xgmtk.lore.ast.Type;

public class FormValContent extends BaseScope implements Typed {

	private List<String> parentTypeQName;
	private Type type;
	
	public FormValContent(){
		super();
		this.parentTypeQName = Arrays.asList(FormDef.ROOT_TYPE);
		this.type = Type.NOT_DEFINED;
	}
	
	@Override
	public void setType(Type type){
		this.type = type;
	}

	@Override
	public Type getType(){
		return this.type;
	}

	public void setParentTypeQNameIds(List<ID> parentTypeQName) {
		this.setParentTypeQName(parentTypeQName.stream().map(id->id.id).collect(Collectors.toList()));
	}
	
	public void setParentTypeQName(List<String> parentTypeQName) {
		this.parentTypeQName = parentTypeQName;
	}

	public List<String> getParentTypeQName(){
		return Collections.unmodifiableList(this.parentTypeQName);
	}

	public FormDef createAnonymousTypeDefinition(String typeName) {
		FormDef formDef = new FormDef(typeName);
		for(Entry<String, Symbol> ent : this.getSymbolTable().entrySet()){
			try {
				formDef.defineWithoutPutScope(ent.getValue());
			} catch (AlreadyDefinedSymbolException e) {
				throw new IllegalStateException("Unexpected internal error.", e);
			}
		}
		for(Scope scope : this.getSubScopes()){
			try {
				formDef.put(scope);
			} catch (AlreadyDefinedSymbolException e) {
				throw new IllegalStateException("Unexpected internal error.", e);
			}
		}
		formDef.setParentTypeQName(this.getParentTypeQName());
		this.setType(formDef);
		return formDef;
	}
}

