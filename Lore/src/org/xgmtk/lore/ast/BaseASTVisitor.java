package org.xgmtk.lore.ast;

public abstract class BaseASTVisitor extends ASTVisitor {

	protected BaseASTVisitor() {super();}

	@Override
	public void enter(AST node) {;}

	@Override
	public void exit(AST node) {;}

	@Override
	public void enter(ID node) {;}

	@Override
	public void exit(ID node) {;}

	@Override
	public <T> void enter(Literal<T> node) {;}

	@Override
	public <T> void exit(Literal<T> node) {;}
}
