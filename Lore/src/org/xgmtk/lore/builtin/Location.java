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
package org.xgmtk.lore.builtin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class Location {
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @author kando
	 *
	 */
	public static class SyntaxException extends Exception {

		/**
		 * TODO write JavaDoc comment.
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

	public static final Location ROOT = new Location(true, Optional.empty(), new String[0]);
	public static final Location NOWHERE = new Location(true, Optional.of("__NOWHERE__"), new String[0]);

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param locationPathString
	 * @return
	 * @throws SyntaxException It throws, if the given string is invalid.
	 */
	public static Location parse(String locationPathString) throws SyntaxException{
		Objects.nonNull(locationPathString);
		
		if(locationPathString.matches(".*[\\h\\v].*")){
			throw new SyntaxException("Location path should not include white space character.");
		}
		
		if(locationPathString.equals("/")){
			return Location.ROOT;
		}
		
		boolean absolute = locationPathString.startsWith("/");
		String[] nodeNames = locationPathString.split("/");
		
		if(absolute){
			nodeNames = Arrays.copyOfRange(nodeNames, 1, nodeNames.length);
		}
		
		for(int i = 0; i < nodeNames.length - 1; ++i){
			if(nodeNames[i].indexOf("[") != -1 || nodeNames[i].indexOf("]") != -1){
				throw new SyntaxException("A coordinate element should be appeared in the only right most node.");
			}
		}
		int startBracketIx = nodeNames[nodeNames.length - 1].indexOf("[");
		Optional<String> coordinate = Optional.empty();
		if(startBracketIx != -1){
			int endBracketIx = nodeNames[nodeNames.length - 1].lastIndexOf("]");
			if(endBracketIx == -1){
				throw new SyntaxException("A coordinate element should have closing bracket \"]\".");
			}
			if(endBracketIx != nodeNames[nodeNames.length - 1].length() - 1){
				throw new SyntaxException("No string should be found after a vcoordinate element.");
			}
			try{
				coordinate = Optional.of(nodeNames[nodeNames.length - 1].substring(startBracketIx+1, endBracketIx));
				nodeNames[nodeNames.length - 1] = nodeNames[nodeNames.length - 1].substring(0, startBracketIx);
			}catch (IndexOutOfBoundsException e){
				throw new IllegalStateException("Unexpected internal error.", e);
			}
			if(coordinate.get().contains("[") || coordinate.get().contains("]")){
				throw new SyntaxException("A coordinate element should not have brackets in brackets.");
			}
		}

		return new Location(absolute, coordinate, nodeNames);
	}

	private final boolean absolute;
	private final Optional<String> coordinate;
	private final String[] path;
	
	protected Location(boolean absolute, Optional<String> coordinate, String...path) {
		this.absolute = absolute;
		this.coordinate = coordinate;
		this.path = path;
	}
	
	public Location(Location loc){
		this(loc.absolute, loc.coordinate, (String[])loc.path.clone());
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return true, if the location is absolute.
	 */
	public boolean isAbsolute(){
		return this.absolute;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return false, if the location has no coordination element.
	 */
	public boolean hasCoordinate(){
		return this.coordinate.isPresent();
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 * @throws NoSuchElementException This location has no coordination element.
	 */
	public String getCoordinateString() throws NoSuchElementException{
		return this.coordinate.get();
	}
	
	/**
	 * This returns unmodifiable list of path elements.
	 * 
	 * @return
	 */
	public List<String> getPath(){
		return Collections.unmodifiableList(Arrays.asList(this.path));
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Location)){
			return false;
		}
		Location loc = (Location)o;
		if(this.absolute != loc.absolute){
			//System.err.println(this.absolute+"!="+loc.absolute);
			return false;
		}
		if(!this.coordinate.equals(loc.coordinate)){
			//System.err.println("\""+this.coordinate+"\" != \""+loc.coordinate+"\"");
			return false;
		}
		if(!Arrays.equals(this.path, loc.path)){
			//System.err.println("\""+this.path+"\" != \""+loc.path+"\"");
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode(){
		int h = Boolean.hashCode(this.absolute);
		h += Arrays.hashCode(this.path);
		h += Objects.hashCode(this.coordinate);
		return h;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if(this.isAbsolute()){
			sb.append("/");
		}
		if(this.path.length > 0){
			sb.append(this.path[0]);
		}
		for(int i = 1; i < this.path.length; ++i){
			sb.append("/").append(this.path[i]);
		}
		if(this.hasCoordinate()){
			sb.append("[").append(getCoordinateString()).append("]");
		}
		return sb.toString();
	}
}
