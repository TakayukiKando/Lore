package org.xgmtk.lore.ast.scanner;

import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.NodeType;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class UnexpectedNodeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param expectedNodeClass
	 * @param expectedType
	 * @param actualNodeClass
	 * @param actualType
	 */
	public UnexpectedNodeException(Class<? extends AST> expectedNodeClass, ASTScannerEventType expectedType, 
			Class<? extends AST> actualNodeClass, ASTScannerEventType actualType){
		super("Expected event is [class: \""+expectedNodeClass.getSimpleName()+"\", type: "+expectedType+" ] but actual event is [class: \""+actualNodeClass.getSimpleName()+"\", type: "+actualType+" ]");
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param expectedNode
	 * @param actualNode
	 */
	public UnexpectedNodeException(AST expectedNode, AST actualNode) {
		super("Expected AST node is [class: \""+expectedNode.getClass().getSimpleName()+"\", symbol: "+expectedNode.symbol+" ] but actual AST node is [class: \""+actualNode.getClass().getSimpleName()+"\", symbol: "+actualNode.symbol+" ]");
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param expectedNodeClass
	 * @param expectedType
	 * @param expectedSymbol
	 * @param actualNodeClass
	 * @param actualType
	 * @param actualSymbol
	 */
	public UnexpectedNodeException(Class<AST> expectedNodeClass, ASTScannerEventType expectedType, NodeType expectedSymbol, 
			Class<? extends AST> actualNodeClass, ASTScannerEventType actualType, NodeType actualSymbol) {
		super("Expected AST node is [class: \""+expectedNodeClass.getSimpleName()+"\", type: "+expectedType+", symbol: "+expectedSymbol+" ] but actual AST node is [class: \""+actualNodeClass.getSimpleName()+"\", type: "+actualType+", symbol: "+actualSymbol+" ]");
	}
}