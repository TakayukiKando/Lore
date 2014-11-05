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
package org.xgmtk.lore.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xgmtk.lore.Lore;

public class TestLoreURLHandling {
	private static final String HTTP = "http";
	private static final String URL_BASE_STR = HTTP+"://"+Lore.PROJECT_DOMAIN_NAME+"/";
	private static URL URL_BASE1;
	private static URL URL_BASE2;
	
	@BeforeClass
	public static void setupClass(){
		try {
			URL_BASE1 = new URL(URL_BASE_STR+"base.lore");
			URL_BASE2 = new URL(URL_BASE_STR+"dir/base.lore");
		} catch (MalformedURLException e) {
			fail();
		}
	}

	@Test
	public void testPlainURL() throws IllegalArgumentException, MalformedURLException{
		String otherURLStr = URL_BASE_STR+"other.lore";
		assertThat(Lore.getURL(otherURLStr, URL_BASE1), is(new URL(otherURLStr)));
	}
	
	@Test
	public void testRelativePath1() throws IllegalArgumentException, MalformedURLException{
		String other = "other.lore";
		String otherURLStr = URL_BASE_STR+other;
		assertThat(Lore.getURL(other, URL_BASE1), is(new URL(otherURLStr)));
	}
	
	@Test
	public void testRelativePath2() throws IllegalArgumentException, MalformedURLException{
		String other = "other.lore";
		String otherURLStr = URL_BASE_STR+"dir/"+other;
		assertThat(Lore.getURL(other, URL_BASE2), is(new URL(otherURLStr)));
	}
	
	@Test
	public void testRelativePath3() throws IllegalArgumentException, MalformedURLException{
		String other = "other.lore";
		String otherURLStr = URL_BASE_STR+other;
		assertThat(Lore.getURL("../"+other, URL_BASE2), is(new URL(otherURLStr)));
	}
	
	@Test
	public void testRelativePath4() throws IllegalArgumentException, MalformedURLException{
		String other = "dir2/other.lore";
		String otherURLStr = URL_BASE_STR+"dir/"+other;
		assertThat(Lore.getURL("./"+other, URL_BASE2), is(new URL(otherURLStr)));
	}
	
	@Test
	public void testPlainFilePath() throws IllegalArgumentException, MalformedURLException{
		String base = "base.lore";
		String other = "other.lore";
		assertThat(Lore.getURL(Paths.get(other).toUri().toURL().toString(), Paths.get(base).toUri().toURL()), is(Paths.get(other).toUri().toURL()));
	}
	
	@Test
	public void testRelativeFilePath() throws IllegalArgumentException, MalformedURLException{
		String base = "base.lore";
		String other = "other.lore";
		assertThat(Lore.getURL(other, Paths.get(base).toUri().toURL()), is(Paths.get(other).toUri().toURL()));
	}
}
