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

import org.xgmtk.lore.Lore;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class LoreASTException extends Exception {

	/**
	 * TODO write JavaDoc comment.
	 */
	private static final long serialVersionUID = 1L;
	
	private Locator locator;

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param locator
	 * @param message
	 */
	public LoreASTException(Locator locator, String message) {
		super(Lore.errorMessageFormat(locator.file, locator.line, message));
		this.locator = locator;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 *
	 * @param locator
	 * @param message
	 * @param t
	 */
	public LoreASTException(Locator locator, String message, Throwable t) {
		super(message, t);
		this.locator = locator;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public Locator getLocator(){
		return this.locator;
	}
}
