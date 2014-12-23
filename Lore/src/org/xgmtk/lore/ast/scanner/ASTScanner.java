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

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.ASTException;
import org.xgmtk.lore.ast.NonTerminalSymbol;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class ASTScanner {
	private final Map<NonTerminalSymbol, PartialASTScanner> table;
	private ASTScannerContext context;
	private Logger logger;
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param logger
	 */
	public ASTScanner(Logger logger){
		super();
		this.logger = logger;
		this.table = new HashMap<>();
		this.context = new ASTScannerContext(this.table, this.logger);
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param symbol
	 * @param scanner
	 * @return
	 */
	public PartialASTScanner putPartialScanner(NonTerminalSymbol symbol, PartialASTScanner scanner){
		return this.table.put(symbol, scanner);
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param root
	 * @throws ASTException 
	 */
	public void scan(AST root) throws ASTException {
		this.context.startScan(root);
	}
}
