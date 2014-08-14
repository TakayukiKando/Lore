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

public abstract class ScopeTreeVisitor {
	public final void visitTo(Scope root) {
		Scope.ScopeIterator it = root.iterator();
		while(it.hasNext()){
			Scope t = it.next();
//			System.err.print(t.name);
			if(it.firstVisited()){
//				System.err.print(" (first: true)");
				t.enter(this);
			}
			if(it.lastVisited()){
//				System.err.print(" (last: true)");
				t.exit(this);
			}
//			System.err.println(";");
		}
	}

	public abstract void enter(BaseScope scope);
	public abstract void exit(BaseScope scope);
	public abstract void enter(GlobalScope scope);
	public abstract void exit(GlobalScope scope);
	public abstract void enter(Scope scope);
	public abstract void exit(Scope scope);
	public abstract void enter(ScopedSymbol scope);
	public abstract void exit(ScopedSymbol scope);
	public abstract void enter(Section scope);
	public abstract void exit(Section scope);
	public abstract void enter(FormDef scope);
	public abstract void exit(FormDef scope);
}
