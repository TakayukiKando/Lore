package org.xgmtk.lore.ast.scanner;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.ASTVisitor;
import org.xgmtk.lore.ast.ID;
import org.xgmtk.lore.ast.Literal;
import org.xgmtk.lore.ast.NodeType;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class ASTScannerContext{
	protected final static class ASTScanEvent{
			public final AST node;
			public final ASTScannerEventType type;
			
			public ASTScanEvent(AST node, ASTScannerEventType type){
				this.node = node;
				this.type = type;
			}
		}
	
	
	
	private final ASTVisitor visitor;
	
	private final Map<NodeType, PartialASTScanner> table;
	private SynchronousQueue<ASTScannerContext.ASTScanEvent> queue;
	private ASTScannerContext.ASTScanEvent lastEvent;
	private ExecutorService executor;

	private Logger logger;
	
	protected ASTScannerContext(Map<NodeType, PartialASTScanner> table, Logger logger){
		this.logger = logger;
		this.table = table;
		this.queue = new SynchronousQueue<>();
		
		this.visitor = new ASTVisitor(){
			@Override
			public void enter(AST node) {
				processNode(node, ASTScannerEventType.START);
			}
		
			@Override
			public void exit(AST node) {
				processNode(node, ASTScannerEventType.END);
			}
		
			@Override
			public void enter(ID node) {
				processNode(node, ASTScannerEventType.START);
			}
	
			@Override
			public void exit(ID node) {
				processNode(node, ASTScannerEventType.END);
			}
		
			@Override
			public <T> void enter(Literal<T> node) {
				processNode(node, ASTScannerEventType.START);
			}
		
			@Override
			public <T> void exit(Literal<T> node) {
				processNode(node, ASTScannerEventType.END);
			}
		};
		
		this.executor = Executors.newFixedThreadPool(1);
	}
	
	protected void processNode(AST node, ASTScannerEventType t) {
		try {
			queue.put(new ASTScannerContext.ASTScanEvent(node, t));
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Unexpected internal error.", e);
		}
	}

	protected void startScan(AST root) throws UnexpectedNodeException{
		Future<?> f = executor.submit(()->{visitor.visitTo(root);});
		ASTScannerContext.ASTScanEvent ev = this.next();
		this.skip(ev.node);
		try {
			f.get();
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Unexpected internal error.", e);
		} catch (ExecutionException e) {
			logger.log(Level.SEVERE, "Unexpected internal error.", e);
		}
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public ASTScannerContext.ASTScanEvent next() {
		try {
			lastEvent = queue.take();
			return lastEvent;
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	protected AST nextNodeEvent(ASTScannerEventType expectedType) throws UnexpectedNodeException{
		ASTScannerContext.ASTScanEvent event = this.next();
		if(((event.node instanceof Literal<?>)||(event.node instanceof ID))
		&& !event.type.equals(expectedType)){
			throw new UnexpectedNodeException(AST.class, expectedType, event.node.getClass(), event.type);
		}
		return event.node;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param symbol
	 * @param eventType
	 * @return
	 */
	public boolean isNode(NodeType symbol, ASTScannerEventType eventType) {
		return !(lastEvent.node instanceof Literal<?>)
				&& !(lastEvent.node instanceof ID)
				&& lastEvent.type.equals(eventType)
				&& lastEvent.node.symbol.equals(symbol);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public boolean isLiteralStart(){
		return (lastEvent.node instanceof Literal<?>) 
				&& lastEvent.type.equals(ASTScannerEventType.START);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public boolean isIDStart(){
		return (lastEvent.node instanceof ID) 
				&& lastEvent.type.equals(ASTScannerEventType.START);
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param symbol
	 * @param expectedType
	 * @throws UnexpectedNodeException
	 */
	public void require(NodeType symbol, ASTScannerEventType expectedType) throws UnexpectedNodeException{
		if(!isNode(symbol, expectedType)){
			throw new UnexpectedNodeException(AST.class, expectedType, symbol, lastEvent.node.getClass(), lastEvent.type, lastEvent.node.symbol);
		}
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 * @throws UnexpectedNodeException
	 */
	public AST nextNode() throws UnexpectedNodeException{
		return this.nextNodeEvent(ASTScannerEventType.START);
	}
	
	protected ASTScanEvent lastEvent(){
		if(this.lastEvent == null){
			throw new IllegalStateException("Scanning is not started.");
		}
		return this.lastEvent;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public AST lastNode() {
		return this.lastEvent().node;
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public ASTScannerEventType lastEventType() {
		return this.lastEvent().type;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param node
	 * @throws UnexpectedNodeException
	 */
	public void ｌeaveNode(AST node) throws UnexpectedNodeException{
		AST actualNode = this.nextNodeEvent(ASTScannerEventType.END);
		if(actualNode != node){
			throw new UnexpectedNodeException(node, actualNode);
		}
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param rootOfSubtree
	 * @param subPartialNodeListener
	 * @return
	 * @throws UnexpectedNodeException
	 */
	public <T extends PartialASTScanner> T delegate(AST rootOfSubtree, T subPartialNodeListener) throws UnexpectedNodeException{
		subPartialNodeListener.matched(this, rootOfSubtree);
		return subPartialNodeListener;
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param rootOfSubtree
	 * @throws UnexpectedNodeException
	 */
	public void skip(AST rootOfSubtree) throws UnexpectedNodeException{
		for(;;){
			ASTScannerContext.ASTScanEvent ev = this.next();
//			this.logger.log(Level.FINEST, "ASTScannerContext#skipSubtree()"+
//			"[class: " + ev.node.getClass().getSimpleName()+
//			", symbol: "+ev.node.symbol+
//			", Event type: "+ev.type+
//			"]");
			if(ev.node == rootOfSubtree){
				if(!ev.type.equals(ASTScannerEventType.END)){
					throw new UnexpectedNodeException(rootOfSubtree.getClass(), ASTScannerEventType.END, ev.node.getClass(), ev.type);
				}
				return;
			}
			if(!((ev.node instanceof Literal<?>)||(ev.node instanceof ID))
					&& ev.type.equals(ASTScannerEventType.START)){
				PartialASTScanner listner = this.table.get(ev.node.symbol);
				if(listner != null){
//					this.logger.log(Level.FINEST, "\tMatched[symbol: "+ev.node.symbol+"]");
					listner.matched(this, ev.node);
				}
//				this.logger.log(Level.FINEST, "\tNot matched[symbol: "+ev.node.symbol+"]");
			}
		}
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 * @throws UnexpectedNodeException
	 */
	public Literal<?> getLiteral() throws UnexpectedNodeException{
		if(!((lastEvent.node instanceof Literal<?>) 
		&& lastEvent.type.equals(ASTScannerEventType.START))){
			throw new UnexpectedNodeException(Literal.class, ASTScannerEventType.START, lastEvent.node.getClass(), lastEvent.type);
		}
		ASTScannerContext.ASTScanEvent endEvent = this.next();
		if(!((endEvent.node instanceof Literal<?>) 
		&& endEvent.type.equals(ASTScannerEventType.END))){
			throw new UnexpectedNodeException(Literal.class, ASTScannerEventType.END, endEvent.node.getClass(), endEvent.type);
		}
		return (Literal<?>)endEvent.node;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 * @throws UnexpectedNodeException
	 */
	public ID getID() throws UnexpectedNodeException{
		if(!((lastEvent.node instanceof ID) 
		&& lastEvent.type.equals(ASTScannerEventType.START))){
			throw new UnexpectedNodeException(ID.class, ASTScannerEventType.START, lastEvent.node.getClass(), lastEvent.type);
		}
		ASTScannerContext.ASTScanEvent endEvent = this.next();
		if(!((endEvent.node instanceof ID) 
		&& endEvent.type.equals(ASTScannerEventType.END))){
			throw new UnexpectedNodeException(ID.class, ASTScannerEventType.END, endEvent.node.getClass(), endEvent.type);
		}
		return (ID)endEvent.node;
	}
}