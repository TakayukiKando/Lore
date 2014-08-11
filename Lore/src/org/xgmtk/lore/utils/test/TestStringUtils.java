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
package org.xgmtk.lore.utils.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.xgmtk.lore.utils.StringUtils;

public class TestStringUtils {
	@Test
	public void testTrim(){
		String expected = "string 0";
		String t0 = "\""+expected+"\"";
		String actual0 = StringUtils.trim(t0, "\"", "\"");
		
		assertThat(actual0 , is(expected));
		
		String t1 = "begin "+expected+" end";
		String actual1 = StringUtils.trim(t1, "begin ", " end");
		
		assertThat(actual1 , is(expected));
	}
	
	@Test
	public void testTabs(){
		assertThat(StringUtils.tabs(0), is(""));
		assertThat(StringUtils.tabs(3), is("\t\t\t"));
	}
}
