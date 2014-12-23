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
package org.xgmtk.lore.builtin.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.xgmtk.lore.builtin.Location;
import org.xgmtk.lore.builtin.Location.SyntaxException;

/**
 * 
 * @author kando
 *
 */
public class TestLocation {
	@Test
	public void testParseRoot() throws SyntaxException{
		Location abc = Location.parse("/");
		assertThat(abc.isAbsolute(), is(true));
		assertThat(abc.hasCoordinate(), is(false));
		try{
			abc.getCoordinateString();
			fail();
		}catch(NoSuchElementException e){
			//expected.
		}
		assertThat(abc.getPath().size(), is(0));
		assertThat(abc.toString(), is("/"));
	}
	
	public void testParseRootWithCoordinate() throws SyntaxException{
		Location abc = Location.parse("/[0]");
		assertThat(abc.isAbsolute(), is(true));
		assertThat(abc.hasCoordinate(), is(true));
		assertThat(abc.getCoordinateString(), is("0"));
		assertThat(abc.getPath().size(), is(0));
		assertThat(abc.toString(), is("/[0]"));
	}
	
	@Test
	public void testParseSingleNodeRelative() throws SyntaxException{
		Location abc = Location.parse("single");
		assertThat(abc.isAbsolute(), is(false));
		assertThat(abc.hasCoordinate(), is(false));
		try{
			abc.getCoordinateString();
			fail();
		}catch(NoSuchElementException e){
			//expected.
		}
		assertThat(abc.getPath(), is(Arrays.asList("single")));
		assertThat(abc.toString(), is("single"));
	}

	@Test
	public void testParseSingleNodeAbsolute() throws SyntaxException{
		Location abc = Location.parse("/single");
		assertThat(abc.isAbsolute(), is(true));
		assertThat(abc.hasCoordinate(), is(false));
		try{
			abc.getCoordinateString();
			fail();
		}catch(NoSuchElementException e){
			//expected.
		}
		assertThat(abc.getPath(), is(Arrays.asList("single")));
		assertThat(abc.toString(), is("/single"));
	}
	
	@Test
	public void testParseRelative() throws SyntaxException{
		Location abc = Location.parse("aaa/bbb/ccc");
		assertThat(abc.isAbsolute(), is(false));
		assertThat(abc.hasCoordinate(), is(false));
		try{
			abc.getCoordinateString();
			fail();
		}catch(NoSuchElementException e){
			//expected.
		}
		assertThat(abc.getPath(), is(Arrays.asList("aaa", "bbb", "ccc")));
		assertThat(abc.toString(), is("aaa/bbb/ccc"));
	}
	
	@Test
	public void testParseAbsolute() throws SyntaxException{
		Location abc = Location.parse("/aaa/bbb/ccc");
		assertThat(abc.isAbsolute(), is(true));
		assertThat(abc.hasCoordinate(), is(false));
		try{
			abc.getCoordinateString();
			fail();
		}catch(NoSuchElementException e){
			//expected.
		}
		assertThat(abc.getPath(), is(Arrays.asList("aaa", "bbb", "ccc")));
		assertThat(abc.toString(), is("/aaa/bbb/ccc"));
	}
	
	@Test
	public void testParseRelativeWithCoordinate() throws SyntaxException{
		Location abc = Location.parse("aaa/bbb/ccc[dd,ee]");
		assertThat(abc.isAbsolute(), is(false));
		assertThat(abc.hasCoordinate(), is(true));
		assertThat(abc.getCoordinateString(), is("dd,ee"));
		assertThat(abc.getPath(), is(Arrays.asList("aaa", "bbb", "ccc")));
		assertThat(abc.toString(), is("aaa/bbb/ccc[dd,ee]"));
	}
	
	@Test
	public void testParseAbsoluteWithCoordinate() throws SyntaxException{
		Location abc = Location.parse("/aaa/bbb/ccc[dd,ee]");
		assertThat(abc.isAbsolute(), is(true));
		assertThat(abc.hasCoordinate(), is(true));
		assertThat(abc.getCoordinateString(), is("dd,ee"));
		assertThat(abc.getPath(), is(Arrays.asList("aaa", "bbb", "ccc")));
		assertThat(abc.toString(), is("/aaa/bbb/ccc[dd,ee]"));
	}
	
	@Test(expected=SyntaxException.class)
	public void testInvalid0() throws SyntaxException{
		Location.parse("/aaa/bbb[1] /ccc[dd, ee]");
	}
	
	@Test(expected=SyntaxException.class)
	public void testInvalid1() throws SyntaxException{
		Location.parse("/aaa/bbb/ccc[d[d, ee]");
	}
	
	@Test(expected=SyntaxException.class)
	public void testInvalid2() throws SyntaxException{
		Location.parse("/aaa/bbb/ccc[dd, e]e]");
	}
	
	@Test(expected=SyntaxException.class)
	public void testInvalid3() throws SyntaxException{
		Location.parse("/aaa/bbb/ccc[dd,ee]ff");
	}
	
	@Test(expected=SyntaxException.class)
	public void testInvalid4() throws SyntaxException{
		Location.parse("/aaa/bbb/ccc[dd,ee ");
	}
	
	@Test(expected=SyntaxException.class)
	public void testInvalid5() throws SyntaxException{
		Location.parse("/aaa/bbb/ccc[dd, ee]");
	}
	
	@Test(expected=SyntaxException.class)
	public void testInvalid6() throws SyntaxException{
		Location.parse("/aaa/bbb /ccc[dd,ee]");
	}
	
	@Test(expected=SyntaxException.class)
	public void testInvalid7() throws SyntaxException{
		Location.parse(" aaa/bbb/ccc[dd,ee]");
	}
	
	private Location[] locations(String...strings) throws SyntaxException{
		Location[] locs = new Location[strings.length];
		for(int i = 0; i < locs.length; ++i){
			locs[i] = Location.parse(strings[i]);
		}
		return locs;
	}

	@Test
	public void testEquality() throws SyntaxException{
		String[] samples = {"/aaa/bbb/ccc[dd,ee]","aaa/bbb/ccc[dd,ee]","/aaa/bbb/ccc","aaa/bbb/ccc", "/", "single", "/single"};
		Location[] locs0 = locations(samples);
		Location[] locs1 = locations(samples);
		for(int i =0; i < locs0.length; ++i){
			for(int j =0; j < locs1.length; ++j){
				//System.err.println("locs0["+i+"] = \""+locs0[i]+"\"");
				//System.err.println("locs1["+j+"] = \""+locs1[j]+"\"");
				assertThat(locs0[i].equals(locs1[j]), is(i==j));
				if(i==j){
					assertThat(locs0[i].hashCode(), is(locs1[j].hashCode()));
				}
			}
		}
	}
}
