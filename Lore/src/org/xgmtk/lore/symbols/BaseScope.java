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

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class BaseScope extends Scope{
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param symbols
	 * @return
	 * @throws AlreadyDefinedException
	 */
	public static BaseScope baseScope(Symbol...symbols) throws AlreadyDefinedException {
		BaseScope baseScope = new BaseScope();
		baseScope.defineAll(symbols);
		return baseScope;
	}

	@Override
	protected Optional<Symbol> resolveFromOuter(int depth, String...name) {
		return Optional.empty();
	}
	
	void enter(ScopeTreeVisitor astVisitor) {
		astVisitor.enter(this);
	}

	void exit(ScopeTreeVisitor astVisitor) {
		astVisitor.exit(this);
	}

}
