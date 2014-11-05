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
package org.xgmtk.lore.ast.loader;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.Literal;
import org.xgmtk.lore.ast.NodeType;
import org.xgmtk.lore.ast.scanner.ASTScanner;
import org.xgmtk.lore.ast.scanner.ASTScannerEventType;
import org.xgmtk.lore.ast.scanner.UnexpectedLiteralType;
import org.xgmtk.lore.ast.scanner.UnexpectedNodeException;

public class Loader{
	private Queue<URL> queue;
	private Map<URL, AST> asts;
	private Logger logger;
	private ASTScanner scanner;

	public Loader(Logger logger) {
		this.logger = logger;
		this.queue = new LinkedList<>();
		this.scanner = new ASTScanner(logger);
		
		this.scanner.putPartialScanner(NodeType.IMPORT, (context, node)->{
			context.require(NodeType.IMPORT, ASTScannerEventType.START);
			context.next();
			Literal<?> literal = context.getLiteral();
			if(!(literal.value instanceof URL)){
				throw new UnexpectedLiteralType(literal.locator, literal.value.getClass(), URL.class);
			}
			addSource((URL)literal.value);
			context.ｌeaveNode(node);
		});
	}

	protected void addSource(URL newURL) {
		this.queue.add(newURL);
	}

	protected URL nextSource() {
		return this.queue.poll();
	}
	
	protected ASTScanner getScanner(){
		return this.scanner;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * @param source 
	 * 
	 * @throws IOException
	 * @throws UnexpectedLiteralType 
	 */
	public void load(URL source) throws IOException, UnexpectedLiteralType {
		this.queue.add(source);
		for(;;){
			URL src = this.nextSource();
			if(src == null){
				break;
			}
			if(this.asts.containsKey(src)){
				//Skip.
				continue;
			}
			AST ast = AST.build(src, this.logger);
			this.asts.put(src, ast);
			try {
				this.scanner.scan(ast);
			} catch (UnexpectedNodeException e) {
				String msg = "Invalid AST.";
				this.logger.log(Level.SEVERE, msg, e);
				throw new IllegalStateException(msg, e);
			}
		}
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public Map<URL, AST> getPathAndASTs(){
		return Collections.unmodifiableMap(this.asts);
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public Collection<AST> getASTs(){
		return Collections.unmodifiableCollection(this.asts.values());
	}
}
