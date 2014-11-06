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

import java.time.OffsetDateTime;
import java.util.Objects;

import org.xgmtk.lore.utils.StringUtils;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public class History {
	/**
	 * TODO write JavaDoc comment.
	 */
	public final OffsetDateTime date;
	/**
	 * TODO write JavaDoc comment.
	 */
	public final String reviser;
	/**
	 * TODO write JavaDoc comment.
	 */
	public final String desc;

	/**
	 * TODO write JavaDoc comment.
	 * 
	 * @param date
	 * @param reviser
	 * @param desc
	 */
	public History(OffsetDateTime date, String reviser, String desc) {
		Objects.nonNull(date);
		this.date = date;
		Objects.nonNull(reviser);
		this.reviser = reviser;
		Objects.nonNull(desc);
		this.desc = desc;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof History)){
			return false;
		}
		History h = (History)o;
		return this.date.equals(h.date)
				&& this.reviser.equals(h.reviser)
				&& this.desc.equals(h.desc);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.date, this.reviser, this.desc);
	}
	
	@Override
	public String toString(){
		return "history (\""+date+
				"\":date) { reviser = \""+StringUtils.escape(reviser)+
				"\", desc = \""+StringUtils.escape(desc)+"\" }";
	}
}
