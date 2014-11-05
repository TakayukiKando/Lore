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
package org.xgmtk.lore.ast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.xgmtk.lore.Lore;

public class Locator {
	/**
	 * This locator points to nowhere of source code. 
	 * This is not equal to any locator. 
	 * This should not use except for test.
	 */
	public static final Locator NOWHERE;
	
	static{
		URL url = null;
		try{
			url  = new URL("http://"+Lore.PROJECT_DOMAIN_NAME+"/anywhere");
		}catch(MalformedURLException e){
			throw new IllegalStateException("Unexpected internal error.", e);
		}
		NOWHERE = new Locator(url, -1);
	}
	
	public final URL file;
	public final int line;
	//public final int column;
	
	public Locator(URL file, int line){
		this.file = file;
		this.line = line;
		//this.column = column;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.file, this.line);
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Locator)){
			return false;
		}
		Locator loc = (Locator)o;
		return Objects.equals(this.file, loc.file)
				&& this.line == loc.line;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("\"").append(this.file).append("\" : ").append(this.line);
		return sb.toString();
	}

	public static Locator loc(URL file, int line){
		return new Locator(file, line);
	}
}