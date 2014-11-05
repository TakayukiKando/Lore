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

import static org.xgmtk.lore.symbols.FormDef.formDef;
import static org.xgmtk.lore.symbols.GlobalScope.globalScope;
import static org.xgmtk.lore.symbols.Section.section;
import static org.xgmtk.lore.symbols.VariableSymbol.var;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.xgmtk.lore.Lore;
import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.ID;
import org.xgmtk.lore.ast.Literal;
import org.xgmtk.lore.ast.Locator;
import org.xgmtk.lore.symbols.PrintVisitor;
import org.xgmtk.lore.symbols.Scope.AlreadyDefinedException;

public class ScopeBuilder{
	protected class DefinitionVisitor extends DefaultASTVisitor{
		private Scope current;
		private boolean currentPrivacy;
		
		public DefinitionVisitor(Scope root) {
			this.current = root;
		}

		@Override
		public void enter(AST node) {
			switch(node.symbol){
			case SECTION:
				processSection(node);
				break;
			case FORM_DEF:
				processFormDef(node);
				break;
			case VAR:
				processVar(node);
				break;
			case PRIVATE:
				this.currentPrivacy = true;
				break;
			default:
				//ignore this node.
				break;
			}
		}

		private void processSection(AST node) {
			NameVisitor nmv = new NameVisitor();
			nmv.visitTo(node.getChildren().get(0));
			for(ID idSym : nmv.ids){
				Optional<Symbol> r = this.current.resolve(idSym.id);
				if(r.isPresent()){
					Symbol sym = r.get();
					if(sym instanceof Scope || this.currentPrivacy != sym.isPrivate()){
						this.current = (Scope)sym;
					}else{
						Locator loc = node.locator;
						String msg = Lore.errorMessageFormat(loc.file, loc.line, "Specified section name is already defined as no section name.");
						logger.severe(msg);
					}
				}else{
					try {
						Section sec = section(idSym.id, this.currentPrivacy);
						this.currentPrivacy = false;
						this.current.define(sec);
						this.current = sec;
					} catch (AlreadyDefinedException e) {
						throw new IllegalStateException("Unexpected internal error.", e);
					}
				}
				this.currentPrivacy = false;
			}
		}

		private void processFormDef(AST node) {
			NameVisitor nmv = new NameVisitor();
			nmv.visitTo(node.getChildren().get(0));
			String id = nmv.ids.get(0).id;
			try {
				this.current.define(formDef(id));
			} catch (AlreadyDefinedException e) {
				Locator loc = node.locator;
				String msg = Lore.errorMessageFormat(loc.file, loc.line, "Specified variable name \""+id+"\" is already defined.");
				logger.severe(msg);
			}
		}

		private void processVar(AST node) {
			NameVisitor nmv = new NameVisitor();
			nmv.visitTo(node.getChildren().get(0));
			String id = nmv.ids.get(0).id;
			try {
				this.current.define(var(id));
			} catch (AlreadyDefinedException e) {
				Locator loc = node.locator;
				String msg = Lore.errorMessageFormat(loc.file, loc.line, "Specified variable name \""+id+"\" is already defined.");
				logger.severe(msg);
			}
		}

		@Override
		public void exit(AST node) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void enter(ID node) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void exit(ID node) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public <T> void enter(Literal<T> node) {
			//Do nothing.
		}

		@Override
		public <T> void exit(Literal<T> node) {
			//Do nothing.
		}

	}
	protected static class ImportVisitor extends DefaultASTVisitor{
		public URI uri = null;
		
		@Override
		public <T> void exit(Literal<T> node) {
			T v = node.value;
			if(v instanceof URI){
				this.uri = (URI)v;
			}
		}
	}
	
	protected static class NameVisitor extends DefaultASTVisitor{
		public List<ID> ids = new ArrayList<>();
		
		@Override
		public void exit(ID node) {
			ids.add(node);
		}
	}
	
	public static void main(String[] args){
		if(args.length == 0 || Arrays.stream(args).anyMatch(s -> (s.equals("-h") || s.equals("-help")))){
			System.err.println("[USAGE]This command takes only 1 argument. It is a file path to start parse.");
		}
		ScopeBuilder builder = null;
		try {
			builder = new ScopeBuilder(Logger.getGlobal(), Paths.get(args[0]));
			builder.build();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		Scope scope = builder.getRoot();
		PrintVisitor.printScopeTree(scope, System.out);
		System.exit(0);
	}


	
	private Logger logger;
	private GlobalScope root;

	public ScopeBuilder(Logger logger, Path baseSrc) throws IOException {
		this.logger = logger;
		try {
			this.root = globalScope();
		} catch (AlreadyDefinedException e) {
			throw new IllegalStateException("Unexpected internal error.", e);
		}
	}
	
	public Scope getRoot() {
		return this.root;
	}


	public void build() throws IOException{
	}
}
