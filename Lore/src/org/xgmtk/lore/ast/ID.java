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

import java.util.Objects;

public class ID extends AST {
	public final String id;
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param value
	 * @param location
	 * @param subtrees
	 */
	public ID(String id, Locator location){
		super(NodeType.ID, location);
		Objects.requireNonNull(id, "A value should not be null.");
		this.id = id;
	}
	
	@Override
	protected void testExtendedPartEquality(AST tb) throws Exception {
		if(!(tb instanceof ID)){
			throw new Exception("Expected node type is \""+this.getClass().getSimpleName()+"\", but Actual node type is \""+tb.getClass().getSimpleName()+"\".");
		}
		ID d = (ID)tb;
		if(!Objects.equals(id, d.id)){
			throw new Exception("Expected node has \""+id+"\", but Actual node has \""+d.id+"\".");
		}
	}

	@Override
	public ID clone() {
		return new ID(this.id, this.locator);
	}
	
	@Override
	void enter(ASTVisitor astVisitor) {
		astVisitor.enter(this);
	}

	@Override
	void exit(ASTVisitor astVisitor) {
		astVisitor.exit(this);
	}
}