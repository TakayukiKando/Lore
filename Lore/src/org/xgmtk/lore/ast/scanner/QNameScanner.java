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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.ASTException;
import org.xgmtk.lore.ast.ID;
import org.xgmtk.lore.ast.NonTerminalSymbol;

public class QNameScanner implements PartialASTScanner {
	public List<ID> ids;
	
	public QNameScanner(){
		this.ids = new ArrayList<>();
	}
	
	@Override
	public void matched(ASTScannerContext context, AST node)
			throws ASTException {
		for(;;){
			if(context.isNode(NonTerminalSymbol.QNAME, ASTScannerEventType.START)){
				context.next();
				ids.add(context.getID());
				context.next();
			}else if(context.isIDStart()){
				ids.add(context.getID());
				break;
			}else{
				//Error case, this requirement is not be satisfied.
				context.require(NonTerminalSymbol.QNAME, ASTScannerEventType.START);
			}
		}
		context.skip(node);
	}

	public List<ID> getIDs() {
		return Collections.unmodifiableList(this.ids);
	}

}
