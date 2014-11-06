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
package org.xgmtk.lore.utils;

import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class StringUtils {
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param src
	 * @return
	 */
	public static String escape(String src){
		String[] sp = src.split("\"");
		//Arrays.stream(sp).forEach((s)->System.err.println(s));
		String rst = Arrays.stream(sp).collect(Collectors.joining("\\\""));
		//System.err.println("src: "+src);
		//System.err.println("rst: "+rst);
		return rst;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param text
	 * @param beginMark
	 * @param endMark
	 * @return
	 */
	public static String trim(String text, String beginMark, String endMark) {
		return text.substring(text.indexOf(beginMark)+beginMark.length(), text.lastIndexOf(endMark));
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param depth
	 * @return
	 */
	public static String tabs(int depth) {
		StringBuilder tabs = new StringBuilder();
		for(int i = 0; i < depth; ++i){
			tabs.append("\t");
		}
		return tabs.toString();
	}
}
