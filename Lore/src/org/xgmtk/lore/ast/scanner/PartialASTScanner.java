package org.xgmtk.lore.ast.scanner;

import org.xgmtk.lore.ast.AST;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
@FunctionalInterface
public interface PartialASTScanner{
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param visitor
	 * @param node
	 * @throws UnexpectedNodeException
	 */
	void matched(ASTScannerContext visitor, AST node) throws UnexpectedNodeException;
}