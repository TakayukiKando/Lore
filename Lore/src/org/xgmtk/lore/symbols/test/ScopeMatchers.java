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
package org.xgmtk.lore.symbols.test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.xgmtk.lore.symbols.Scope;
import org.xgmtk.lore.symbols.Scope.ScopeIterator;
import org.xgmtk.lore.symbols.Symbol;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class ScopeMatchers {

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param expectedTree
	 * @return
	 */
	public static Matcher<Scope> equalScope(Scope expectedTree) {
		return new ScopeMatcher(expectedTree);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @author kando
	 *
	 */
	public static class ScopeMatcher extends BaseMatcher<Scope>{
		
		private Scope expected;
		private String failureMessage;

		public ScopeMatcher(Scope expected){
			this.expected = expected;
			this.failureMessage = null;
		}

		@Override
		public boolean matches(Object actual) {
			return testEquality(this.expected, actual);
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("Detailed message: "+this.failureMessage+")");
		}
		
		public boolean testEquality(Scope expected, Object actual){
			if(expected == actual){
				return true;
			}
			if(expected == null && actual != null){
				this.failureMessage = "Expectd is null, but actual is not null.";
				return false;
			}
			if(actual == null && expected != null){
				this.failureMessage = "Expectd is not null, but actual is null.";
				return false;
			}
			if(!(actual instanceof Scope)){
				this.failureMessage = "Actual is not Scope.";
				return false;
			}
			Scope target = (Scope)actual;
			
			ScopeIterator eit = expected.iterator();
			ScopeIterator ait = target.iterator();
			
			return testEquality(eit, ait);
		}

		private boolean testEquality(ScopeIterator eit, ScopeIterator ait) {
			while(eit.hasNext()){
				Scope e = eit.next();
				if(!ait.hasNext()){
					this.failureMessage = "expected node \""+e.toString()+"\" is not found.";
					return false;
				}
				Scope a = ait.next();
				if(!testEqualityNode(e, a)){
					this.failureMessage = "expected node "+e.toString()+" and actual node \""+a.toString()+"\" is not equal.(" + this.failureMessage+")";
					return false;
				}
			}if(ait.hasNext()){
				this.failureMessage = "actual node \""+ait.next().toString()+"\" is extraneous";
				return false;
			}
			return true;
		}

		private boolean testEqualityNode(Scope expected, Scope actual) {
			if(expected == actual){
				return true;
			}
			if(expected == null && actual != null){
				this.failureMessage = "Expectd is null, but actual is not null.";
				return false;
			}
			if(actual == null && expected != null){
				this.failureMessage = "Expectd is not null, but actual is null.";
				return false;
			}
			
			Class<? extends Scope> classE = expected.getClass();
			Class<? extends Scope> classA = actual.getClass();
			if(!Objects.equals(classE, classA)){
				this.failureMessage = "Classes of Scopes[expected: \""+classE.getName()+"\", actual: \""+classA.getName()+"\"] are not match.";
				return false;
			}
			if(expected instanceof Symbol){
				Symbol symE = (Symbol)expected;
				Symbol symA = (Symbol)actual;
				if(!testEqualitySymbol(symE, symA)){
					return false;
				}
			}
			if(expected.definitions() != actual.definitions()){
				this.failureMessage = "Size of tables[expected: "+expected.definitions()+", actual: "+actual.definitions()+"] are not match.";
			}
			Map<String, Symbol> aTab = actual.getSymbolTable();
			for(Entry<String, Symbol> eEnt : expected.getSymbolTable().entrySet()){
				if(!testEqualitySymbol(eEnt.getValue(), aTab.get(eEnt.getKey()))){
					this.failureMessage = this.failureMessage+"(for expected \""+eEnt.getKey()+"\")";
					return false;
				}
			}
			return true;
		}

		private boolean testEqualitySymbol(Symbol symE, Symbol symA) {
			if(symE == symA){
				return true;
			}
			if(symE == null && symA != null){
				this.failureMessage = "Expectd is null, but actual is not null.";
				return false;
			}
			if(symA == null && symE != null){
				this.failureMessage = "Expectd is not null, but actual is null.";
				return false;
			}
			Class<? extends Symbol> classE = symE.getClass();
			Class<? extends Symbol> classA = symA.getClass();
			if(!Objects.equals(classE, classA)){
				this.failureMessage = "Classes of symbols[expected: \""+classE.getName()+"\", actual: \""+classA.getName()+"\"] are not match.";
				return false;
			}
			if(!Objects.equals(symE.getName(), symA.getName())){
				this.failureMessage = "Symbol name[expected: \""+symE.getName()+"\", actual: \""+symA.getName()+"\"] are not match.";
				return false;
			}
			if(symE.isPrivate() != symA.isPrivate()){
				this.failureMessage = "Symbol privacy[expected: \""+symE.isPrivate()+"\"(\""+symE.getName()+"\"), actual: \""+symA.isPrivate()+"\"(\""+symA.getName()+"\")] are not match.";
				return false;
			}
			return true;
		}

	}
}
