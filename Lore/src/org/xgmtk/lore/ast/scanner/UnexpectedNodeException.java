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
package org.xgmtk.lore.ast.scanner;

import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.Locator;
import org.xgmtk.lore.ast.LoreASTException;
import org.xgmtk.lore.ast.NodeType;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class UnexpectedNodeException extends LoreASTException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param locator
	 * @param expectedNodeClass
	 * @param expectedType
	 * @param actualNodeClass
	 * @param actualType
	 */
	public UnexpectedNodeException(Locator locator, Class<? extends AST> expectedNodeClass, ASTScannerEventType expectedType, 
			AST actualNode, ASTScannerEventType actualType){
		super(locator, "Expected event is [class: \""+expectedNodeClass.getSimpleName()+"\", type: "+expectedType+" ] but actual event is [class: \""+actualNode.getClass().getSimpleName()+"\", symbol: \""+actualNode.symbol+"\", type: "+actualType+" ]");
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param locator
	 * @param expectedNode
	 * @param actualNode
	 */
	public UnexpectedNodeException(Locator locator, AST expectedNode, AST actualNode) {
		super(locator, "Expected AST node is [class: \""+expectedNode.getClass().getSimpleName()+"\", symbol: "+expectedNode.symbol+" ] but actual AST node is [class: \""+actualNode.getClass().getSimpleName()+"\", symbol: "+actualNode.symbol+" ]");
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param locator
	 * @param expectedNodeClass
	 * @param expectedType
	 * @param expectedSymbol
	 * @param actualNodeClass
	 * @param actualType
	 * @param actualSymbol
	 */
	public UnexpectedNodeException(Locator locator, Class<AST> expectedNodeClass, ASTScannerEventType expectedType, NodeType expectedSymbol, 
			Class<? extends AST> actualNodeClass, ASTScannerEventType actualType, NodeType actualSymbol) {
		super(locator, "Expected AST node is [class: \""+expectedNodeClass.getSimpleName()+"\", type: "+expectedType+", symbol: "+expectedSymbol+" ] but actual AST node is [class: \""+actualNodeClass.getSimpleName()+"\", type: "+actualType+", symbol: "+actualSymbol+" ]");
	}
}