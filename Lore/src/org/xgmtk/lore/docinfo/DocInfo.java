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
import java.util.Optional;

import org.xgmtk.lore.Lore;
import org.xgmtk.lore.types.StringContainer;
import org.xgmtk.lore.utils.StringUtils;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class DocInfo {
	private URL src;
	private URL version;
	private String encoding;
	private String title;
	private StringContainer desc;
	private List<Author> authors;
	private List<History> histories;

	/**
	 * TODO write JavaDoc comment.
	 * @param src 
	 */
	public DocInfo(URL src) {
		super();
		this.src = src;
		this.version = Lore.DEFAULT_VERSION;
		this.encoding = Lore.DEFAULT_ENCODING;
		this.title = null;
		this.desc = null;
		this.authors = new ArrayList<>();
		this.histories = new ArrayList<>();
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof DocInfo)){
			return false;
		}
		DocInfo a = (DocInfo)o;
		return this.src.equals(a.src)
				&& this.version.equals(a.version)
				&& this.encoding.equals(a.encoding)
				&& this.title.equals(a.title)
				&& this.desc.equals(a.desc)
				&& this.authors.equals(a.authors)
				&& this.histories.equals(a.histories);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.src, 
				this.version, this.encoding, 
				this.title, this.desc, 
				this.authors, this.histories);
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("/* source: ").append(src.toString()).append(" */").append("\n");
		sb.append("docinfo{ version = \"").append(version.toString())
			.append("\":url, encoding = \"").append(encoding).append("\"}").append("\n");
		sb.append("desc(\"").append(StringUtils.escape(title)).append("\"){[===[").append(desc.toString()).append("]===]}").append("\n");
		this.authors.stream().forEach(a->sb.append(a.toString()).append("\n"));
		this.histories.stream().forEach(h->sb.append(h.toString()).append("\n"));
		return sb.toString();
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public URL getSource(){
		return this.src;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param version
	 */
	public void setVersion(URL version){
		Objects.requireNonNull(version);
		this.version = version;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public URL getVersion(){
		return this.version;
	}

	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param encoding
	 */
	public void setEncoding(String encoding){
		Objects.requireNonNull(encoding);
		this.encoding = encoding;
	}

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public String getEncoding(){
		return this.encoding;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param title
	 */
	public void setTitle(String title){
		Objects.requireNonNull(title);
		this.title = title;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public Optional<String> getTitle(){
		return Optional.ofNullable(this.title);
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param desc
	 */
	public void setDescription(StringContainer desc){
		Objects.requireNonNull(desc);
		this.desc = desc;
	}
	
	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @return
	 */
	public Optional<StringContainer> getDescription(){
		return Optional.ofNullable(this.desc);
	}

	public void addAutohr(Author author) {
		this.authors.add(author);
	}
	
	public List<Author> getAutohrs(){
		return this.authors;
	}
	
	public void addHistory(History history) {
		this.histories.add(history);
	}
	
	public List<History> getHistories(){
		return this.histories;
	}
}
