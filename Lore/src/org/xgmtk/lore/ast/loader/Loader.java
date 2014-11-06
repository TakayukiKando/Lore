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
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.Literal;
import org.xgmtk.lore.ast.NodeType;
import org.xgmtk.lore.ast.PrintVisitor;
import org.xgmtk.lore.ast.scanner.ASTScanner;
import org.xgmtk.lore.ast.scanner.ASTScannerEventType;
import org.xgmtk.lore.ast.scanner.UnexpectedLiteralType;
import org.xgmtk.lore.ast.scanner.UnexpectedNodeException;
import org.xgmtk.lore.docinfo.Author;
import org.xgmtk.lore.docinfo.DocInfo;
import org.xgmtk.lore.docinfo.History;
import org.xgmtk.lore.types.HTML;
import org.xgmtk.lore.types.JID;
import org.xgmtk.lore.types.SimpleString;
import org.xgmtk.lore.types.StringContainer;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class Loader{
	public static void main(String[] args){
		if(args.length < 1 || Arrays.stream(args).anyMatch(s -> (s.equals("-h") || s.equals("-help")))){
			System.err.println("[USAGE]This command takes only 1 or 2 argument.");
			System.err.println("\tA required argument is the main file of parsing.");
			System.err.println("\tThis command parses it and all files which are imported from it.");
			System.err.println("\tOther optional flag is \"-ast\". Show AST, if it is specified.");
		}
		boolean showAST = Arrays.stream(args).anyMatch(s -> (s.equals("-ast")));
		String fname = Arrays.stream(args).filter(s -> !(s.equals("-ast"))).findAny().get();
		
		final Loader loader = new Loader(Logger.getGlobal());
		
		try {
			loader.load(Paths.get(fname).toFile().toURI().toURL());
		} catch (IOException | UnexpectedLiteralType e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		loader.getDocInfos().keySet().stream().forEach(k->{
			System.out.println("---- Document information ----");
			System.out.println(loader.getDocInfo(k).toString());
			if(showAST){
				System.out.println("---- Abstract Syntax Tree ----");
				PrintVisitor.printTree(loader.getAST(k), System.out, false);
			}
			System.out.println();
			});
		
		System.exit(0);
	}

	
	private Queue<URL> queue;
	private Map<URL, DocInfo> infos;
	private Map<URL, AST> asts;
	private Logger logger;
	private ASTScanner scanner;

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param logger
	 */
	public Loader(Logger logger) {
		this.logger = logger;
		this.queue = new LinkedList<>();
		
		this.infos = new HashMap<>();
		this.asts = new HashMap<>();
		
		this.scanner = new ASTScanner(logger);
		
		// version
		this.scanner.putPartialScanner(NodeType.VERSION, (context, node)->{
			context.require(NodeType.VERSION, ASTScannerEventType.START);
			context.next();
			URL version = context.getLiteral(URL.class);
			DocInfo info = infos.get(node.locator.file);
			info.setVersion(version);
			context.skip(node);
		});
		
		// encoding
		this.scanner.putPartialScanner(NodeType.ENCODING, (context, node)->{
			context.require(NodeType.ENCODING, ASTScannerEventType.START);
			context.next();
			String encoding = context.getLiteral(String.class);
			DocInfo info = infos.get(node.locator.file);
			info.setEncoding(encoding);
			context.skip(node);
		});
		
		// desc (description)
		this.scanner.putPartialScanner(NodeType.DESC, (context, node)->{
			context.require(NodeType.DESC, ASTScannerEventType.START);
			context.next();
			String title = context.getLiteral(String.class);
			DocInfo info = infos.get(node.locator.file);
			info.setTitle(title);
			context.next();
			if(context.isLiteralStart()){
				Literal<?> descLit = context.getLiteral();
				StringContainer desc = null;
				if(descLit.value instanceof String){
					desc = SimpleString.create((String)descLit.value, descLit.locator, logger);
				}else if(descLit.value instanceof HTML){
					desc = (HTML)descLit.value;
				}else{
					throw new UnexpectedLiteralType(descLit.locator, descLit.value.getClass(), String.class, HTML.class);
				}
				info.setDescription(desc);
			}
			context.skip(node);
		});
		
		//authors
		this.scanner.putPartialScanner(NodeType.AUTHOR, (context, node)->{
			context.require(NodeType.AUTHOR, ASTScannerEventType.START);
			context.next();
			String name = context.getLiteral(String.class);
			DocInfo info = infos.get(node.locator.file);
			Author author = new Author(name);
			context.next();
			while(context.isLiteralStart()){
				Literal<?> contactLit = context.getLiteral();
				if(contactLit.value instanceof JID){
					author.addContact((JID)contactLit.value);
				}else if(contactLit.value instanceof URL){
					author.addContact((URL)contactLit.value);
				}else{
					throw new UnexpectedLiteralType(contactLit.locator, contactLit.value.getClass(), JID.class, URL.class);
				}
				context.next();
			}
			info.addAutohr(author);
			context.skip(node);
		});
		
		//histories
		this.scanner.putPartialScanner(NodeType.HISTORY, (context, node)->{
			context.require(NodeType.HISTORY, ASTScannerEventType.START);
			context.next();
			OffsetDateTime date = context.getLiteral(OffsetDateTime.class);
			context.next();
			String reviser = context.getLiteral(String.class);
			context.next();
			String desc = context.getLiteral(String.class);
			DocInfo info = infos.get(node.locator.file);
			History history = new History(date, reviser, desc);
			info.addHistory(history);
			context.skip(node);
		});
		
		//import
		this.scanner.putPartialScanner(NodeType.IMPORT, (context, node)->{
			context.require(NodeType.IMPORT, ASTScannerEventType.START);
			context.next();
			addSource(context.getLiteral(URL.class));
			context.ｌeaveNode(node);
		});
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param newURL
	 */
	protected void addSource(URL newURL) {
		this.queue.add(newURL);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	protected URL nextSource() {
		return this.queue.poll();
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	protected ASTScanner getScanner(){
		return this.scanner;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
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
			this.infos.put(src, new DocInfo(src));
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
	public Map<URL,AST> getASTs(){
		return Collections.unmodifiableMap(this.asts);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param basicLore
	 * @return
	 */
	public AST getAST(URL basicLore) {
		return this.asts.get(basicLore);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public Map<URL,DocInfo> getDocInfos() {
		return Collections.unmodifiableMap(this.infos);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param basicLore
	 * @return
	 */
	public DocInfo getDocInfo(URL basicLore) {
		return this.infos.get(basicLore);
	}
}
