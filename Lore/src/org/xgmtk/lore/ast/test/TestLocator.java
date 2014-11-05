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
package org.xgmtk.lore.ast.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.xgmtk.lore.Lore;
import org.xgmtk.lore.ast.Locator;

public class TestLocator {
	private static final String HTTP_URL_HEAD = "http://"+Lore.PROJECT_DOMAIN_NAME+"/";

	@Test
	public void testEquality() throws MalformedURLException{
		Locator loc0 = new Locator(new URL(HTTP_URL_HEAD), 25);
		Locator loc0_dash = new Locator(new URL(HTTP_URL_HEAD), 25);
		Locator loc1 = new Locator(new URL(HTTP_URL_HEAD+"where"), 25);
		Locator loc2 = new Locator(new URL(HTTP_URL_HEAD), 26);
		Locator loc3 = new Locator(new URL(HTTP_URL_HEAD+"where"), 26);
		
		assertThat(loc0_dash, is(loc0));
		assertThat(loc1, not(is(loc0)));
		assertThat(loc2, not(is(loc0)));
		assertThat(loc3, not(is(loc0)));

		assertThat(loc0_dash.hashCode(), is(loc0.hashCode()));
		assertThat(loc1.hashCode(), not(is(loc0.hashCode())));
		assertThat(loc2.hashCode(), not(is(loc0.hashCode())));
		assertThat(loc3.hashCode(), not(is(loc0.hashCode())));

		assertThat(loc0, not(is(Locator.NOWHERE)));
		assertThat(loc0_dash, not(is(Locator.NOWHERE)));
		assertThat(loc1, not(is(Locator.NOWHERE)));
		assertThat(loc2, not(is(Locator.NOWHERE)));
		assertThat(loc3, not(is(Locator.NOWHERE)));
	}
}
