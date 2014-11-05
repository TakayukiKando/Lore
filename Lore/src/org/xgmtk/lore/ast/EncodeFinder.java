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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class EncodeFinder {

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param source
	 * @param scanLines
	 * @param defaultEncode
	 * @return
	 * @throws IOException
	 */
	public static String findEncodeInfo(URL source, int scanLines, String defaultEncode) throws IOException {
//		System.err.println("source: \""+source.toString()+"\"");
		try(BufferedReader rd = new BufferedReader(new InputStreamReader(source.openStream()));){
			String enc = null;
			search: for(int i = 0; i < scanLines; ++i){
				String line = rd.readLine();
				if(line == null){
					break search;
				}
				if(!line.startsWith("docinfo")){
					continue;
				}
				String[] tokens = line.split("(\\s)*");
				for(int j = 0; j < tokens.length; ++j){
					if(tokens[j].equals("encoding")
							&& j < tokens.length - 2
							&& tokens[j+1].equals("=")){
								enc = tokens[j+1];
								break search;
					}
				}
			}
			if(enc == null){
				return defaultEncode;
			}
			if(Charset.isSupported(enc)){
				throw new IOException("Unsupported encoding \""+enc+"\".");
			}
			return enc;
		}
	}

}
