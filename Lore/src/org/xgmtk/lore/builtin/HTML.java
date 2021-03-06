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
package org.xgmtk.lore.builtin;

import java.util.Objects;
import java.util.logging.Logger;

import org.xgmtk.lore.ast.Locator;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class HTML extends StringContainer {
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param content
	 * @param loc
	 * @param logger
	 * @return
	 */
	public static HTML create(String content, Locator loc, Logger logger) {
		return new HTML(content, loc, logger);
	}
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param content
	 * @param baseLocator
	 * @param logger
	 */
	public HTML(String content, Locator baseLocator, Logger logger) {
		super(content, baseLocator, logger);
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof HTML)){
			return false;
		}
		HTML content = (HTML)o;
		return this.getContent().equals(content.getContent());
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.getContent());
	}
	
	@Override
	public String toString(){
		return this.getContent();
	}
}
