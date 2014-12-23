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
package org.xgmtk.lore.ast.test;

import java.util.List;
import java.util.Objects;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.xgmtk.lore.ast.AST;

/**
 * 
 * @author kando
 *
 */
public class ASTMatchers {
	public static class ASTMatcher extends BaseMatcher<AST>{
		private AST expected;
		private boolean isIgnoreSrcLocator;
		private String failureMessage;
		
		public ASTMatcher(AST expected, boolean isIgnoreSrcLocator){
			this.expected = expected;
			this.isIgnoreSrcLocator = isIgnoreSrcLocator;
			this.failureMessage = null;
		}
		
		public boolean testEquality(AST expected, Object actual, boolean ignoreSrcLocator){
			if(expected == null && actual == null){
				return true;
			}
			if(expected == null){
				this.failureMessage = "Expectd is null, but actual is not null.";
				return false;
			}
			if(actual == null){
				this.failureMessage = "Expectd is not null, but actual is null.";
				return false;
			}
			if(!(actual instanceof AST)){
				this.failureMessage = "Actual is not AST.";
				return false;
			}
			AST target = (AST)actual;
			if(!expected.symbol.equals(target.symbol)){
				this.failureMessage = "Expected node name is \""+expected.symbol+"\" but Actual node name is \""+target.symbol+"\".";
				return false;
			}
			if(!ignoreSrcLocator){
				if(!Objects.equals(expected.locator, target.locator)){
					this.failureMessage = "Expected node(\""+expected.symbol+"\") locator is "+expected.locator+" but Actual node(\""+target.symbol+"\") locator is "+target.locator+".";
					return false;
				}
			}
			if(!Objects.equals(expected.getType(), target.getType())){
				this.failureMessage = "Expected node(\""+expected.symbol+"\") type is \""+expected.getType()+"\" but Actual node(\""+target.symbol+"\") type is \""+target.getType()+"\".";
				return false;
			}
			try{
				AST.testExtendedPartEquality(expected, target);
			}catch(Exception e){
				this.failureMessage = e.getMessage();
				return false;
			}
			List<AST> expectedChildren = expected.getChildren();
			List<AST> actualChildren = target.getChildren();
			if(expectedChildren.size() != actualChildren.size()){
				this.failureMessage = "Expected node(\""+expected.symbol+"\") has "+expectedChildren.size()+" children but Actual node(\""+target.symbol+"\") has "+actualChildren.size()+" children.";
				return false;
			}
			for(int i = 0; i < expectedChildren.size(); ++i){
				if(!testEquality(expectedChildren.get(i), actualChildren.get(i), ignoreSrcLocator)){
					this.failureMessage = "\""+target.symbol+"\"("+target.locator+")["+i+"]::"+this.failureMessage;
					return false;
				}
			}
			return true;	
		}

		@Override
		public boolean matches(Object actual) {
			return testEquality(this.expected, actual, this.isIgnoreSrcLocator);
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("Detailed message: "+this.failureMessage+")");
		}
		
	}
	
	public static Matcher<AST> equalASTWithoutLocator(AST expected){
		return new ASTMatcher(expected, true);
	}

	public static Matcher<AST> equalAST(AST expected){
		return new ASTMatcher(expected, false);
	}
}
