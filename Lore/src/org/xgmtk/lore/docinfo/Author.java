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
package org.xgmtk.lore.docinfo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.xgmtk.lore.types.JID;
import org.xgmtk.lore.utils.StringUtils;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class Author {

	private String name;
	private List<JID> jids;
	private List<URL> urls;
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 */
	public Author(String name) {
		super();
		this.setName(name);
		this.jids = new ArrayList<>();
		this.urls = new ArrayList<>();
	}
		
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Author)){
			return false;
		}
		Author a = (Author)o;
		return this.name.equals(a.name)
				&& this.jids.equals(a.jids)
				&& this.urls.equals(a.urls);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.name, this.jids, this.urls);
	}
	
	@Override
	public String toString(){
		Stream<String> jidStream = this.jids.stream().map(j->"\""+j+"\":jid");
		Stream<String> urlStream = this.urls.stream().map(u->"\""+u+"\":url");
		String s = Stream.concat(jidStream, urlStream).collect(Collectors.joining(", "));
		return "author (\""+StringUtils.escape(name)+"\") {"+s+"}";
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param name
	 */
	public final void setName(String name) {
		Objects.requireNonNull(name);
		this.name = name;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public final String getName(){
		return this.name;
	}

	public void addContact(URL contact) {
		this.urls.add(contact);
	}

	public void addContact(JID contact) {
		this.jids.add(contact);
	}
	
	public List<JID> getJIDContacts(){
		return this.jids;
	}
	
	public List<URL> getURLContacts(){
		return this.urls;
	}
}
