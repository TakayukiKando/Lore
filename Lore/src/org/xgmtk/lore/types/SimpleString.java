package org.xgmtk.lore.types;

import java.util.Objects;
import java.util.logging.Logger;

import org.xgmtk.lore.ast.Locator;

public class SimpleString extends StringContainer {
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param content
	 * @param loc
	 * @param logger
	 * @return
	 */
	public static SimpleString create(String content, Locator loc, Logger logger) {
		return new SimpleString(content, loc, logger);
	}

	protected SimpleString(String content, Locator baseLocator, Logger logger) {
		super(content, baseLocator, logger);
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof SimpleString)){
			return false;
		}
		SimpleString content = (SimpleString)o;
		return this.getContent().equals(content.getContent());
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.getContent());
	}
	
	@Override
	public String toString(){
		return this.getContent();
	}
}
