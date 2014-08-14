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

import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.ASTVisitor;
import org.xgmtk.lore.ast.ID;
import org.xgmtk.lore.ast.Literal;

public class DefaultASTVisitor extends ASTVisitor{

	@Override
	public void enter(AST node) {
		// ignore
	}

	@Override
	public void exit(AST node) {
		// ignore
	}

	@Override
	public void enter(ID node) {
		// ignore
	}

	@Override
	public void exit(ID node) {
		// ignore
	}

	@Override
	public <T> void enter(Literal<T> node) {
		// ignore
	}

	@Override
	public <T> void exit(Literal<T> node) {
		// ignore
	}
	
}