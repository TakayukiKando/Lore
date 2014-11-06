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
package org.xgmtk.lore;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Constants and Utilities.
 * 
 * @author kando
 *
 */
public class Lore {

	/**
	 * TODO write JavaDoc comment.
	 */
	public static final String PROJECT_DOMAIN_NAME = "www.lore.xgmtk.org";

	/**
	 * TODO write JavaDoc comment.
	 */
	public static final URL DEFAULT_VERSION;
	
	static{
		try {
			DEFAULT_VERSION = new URL("http://xgmtk.org/lore/1.0");
		} catch (MalformedURLException e) {
			throw new IllegalStateException("Unexpected internal error.", e);
		}
	}
	
	/**
	 * TODO write JavaDoc comment.
	 */
	public static final String DEFAULT_ENCODING = "UTF-8";
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param src
	 * @param line
	 * @param msg
	 * @return
	 */
	public static String errorMessageFormat(URL src, int line, String msg) {
		return "[ "+src.toString()+" : "+line+" ]"+msg;
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param urlCandidate
	 * @param currentDocumentPath
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static URL getURL(String urlCandidate, URL currentDocumentPath) throws IllegalArgumentException {
		URL url;
		try {
			url = new URL(urlCandidate);
		} catch (MalformedURLException e0) {
			Path basePath = null;
			boolean isFileProtocol = currentDocumentPath.getProtocol().equals("file");
			if(isFileProtocol){
				basePath = (new File(currentDocumentPath.getPath())).toPath();
			}else{
				basePath = Paths.get(currentDocumentPath.getPath());
			}
			
			Path path = basePath.getParent().resolve(urlCandidate).normalize();
			
			if(isFileProtocol){
				try {
					return path.toUri().toURL();
				} catch (MalformedURLException e1) {
					throw new IllegalArgumentException("URL syntax error for a value \""+urlCandidate+"\": [as an absolute URL: "+e0.getMessage()+"] and [as a relative file path: "+e1.getMessage()+"]");
				}
			}
			Iterator<Path> it = path.iterator();
			StringBuilder sb = new StringBuilder("/");
			sb.append(it.next().toString());
			while(it.hasNext()){
				sb.append("/").append(it.next().toString());
			}
			try {
				url = new URL(currentDocumentPath.getProtocol(), currentDocumentPath.getHost(), sb.toString());
			} catch (MalformedURLException e1) {
				throw new IllegalArgumentException("URL syntax error for a value \""+urlCandidate+"\": [as an absolute URL: "+e0.getMessage()+"] and [as a relative path: "+e1.getMessage()+"]");
			}
		}
		return url;
	}

}
