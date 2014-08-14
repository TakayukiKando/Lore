package org.xgmtk.lore.symbols;


public class VariableSymbol implements Symbol {

	private final String name;
	private boolean isPrivate;

	public VariableSymbol(String name, boolean isPrivate) {
		this.name = name;
		this.isPrivate = isPrivate;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean isPrivate() {
		return this.isPrivate;
	}


	public static Symbol var(String name, boolean isPrivate) {
		return new VariableSymbol(name, isPrivate);
	}

	public static Symbol var(String name) {
		return var(name, false);
	}

	@Override
	public String toString(){
		return Symbol.getDescription(this);
	}
}