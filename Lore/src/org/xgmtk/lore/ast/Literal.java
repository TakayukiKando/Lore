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

public class Literal<T> extends AST {
	public final T value;
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param value
	 * @param location
	 * @param subtrees
	 */
	public Literal(T value, Locator location){
		super(NonTerminalSymbol.LITERAL, location);
		Objects.requireNonNull(value, "A value should not be null.");
		this.value = value;
	}
	
	@Override
	protected void testExtendedPartEquality(AST tb) throws Exception {
		if(!(tb instanceof Literal)){
			throw new Exception("Expected node type is \""+this.getClass().getSimpleName()+"\", but Actual node type is \""+tb.getClass().getSimpleName()+"\".");
		}
		Literal<?> d = (Literal<?>)tb;
		if(!Objects.equals(value, d.value)){
			throw new Exception("Expected node has \""+value+"\", but Actual node has \""+d.value+"\".");
		}
	}
	
	@Override
	public Literal<T> clone() {
		Literal<T> literal = new Literal<T>(this.value, this.locator);
		literal.setType(this.getType());
		return literal;
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