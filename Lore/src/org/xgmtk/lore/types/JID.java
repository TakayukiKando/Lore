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
package org.xgmtk.lore.types;

import java.util.Objects;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class JID {
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @author kando
	 *
	 */
	public static class SyntaxException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		/**
		 * TODO write JavaDoc comment.
		 * 
		 * @param msg
		 */
		public SyntaxException(String msg){
			super (msg);
		}
	}

	/**
	 * TODO write JavaDoc comment.
	 */
	public static final JID NOBODY;
	
	static{
		JID id = null;
		try {
			id = new JID("nobody@nohost.xgmtk.org");
		} catch (SyntaxException e) {
			//Should not caught.
			throw new IllegalStateException("Unexpected internal error.", e);
		}
		NOBODY = id;
	}

	/**
	 * TODO write JavaDoc comment.
	 */
	public final String jid;

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param jid
	 * @throws SyntaxException
	 */
	public JID(String jid) throws SyntaxException{
		checkFormat(jid);
		this.jid = jid;
	}

	private final void checkFormat(String jid) throws SyntaxException{
		Objects.nonNull(jid);
		// TODO check format.
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof JID)){
			return false;
		}
		JID j = (JID)o;
		return this.jid.equals(j.jid);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.jid);
	}
	
	@Override
	public String toString(){
		return this.jid;
	}
}
