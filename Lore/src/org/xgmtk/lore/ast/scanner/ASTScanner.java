package org.xgmtk.lore.ast.scanner;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.NodeType;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class ASTScanner {
	private final Map<NodeType, PartialASTScanner> table;
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
	 * @param visitor
	 * @return
	 */
	public PartialASTScanner putPartialScanner(NodeType symbol, PartialASTScanner visitor){
		return this.table.put(symbol, visitor);
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param root
	 * @throws UnexpectedNodeException
	 */
	public void scan(AST root) throws UnexpectedNodeException{
		this.context.startScan(root);
	}
}
