package org.xgmtk.lore.types.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.xgmtk.lore.types.JID;
import org.xgmtk.lore.types.JID.SyntaxException;

public class TestJID {
	@Test
	public void test() throws SyntaxException{
		JID chihiro0 = new JID("chihiro@xmpp.xgmtk.org");
		JID chihiro1 = new JID("chihiro@xmpp.xgmtk.org");
		JID chihir = new JID("chihir@xmpp.xgmtk.org");
		
		assertThat(chihiro0, is(chihiro0));
		assertThat(chihiro1, is(chihiro0));
		assertThat(chihir, not(is(chihiro0)));
		assertThat(chihiro1.hashCode(), is(chihiro0.hashCode()));
		assertThat(chihir.hashCode(), not(is(chihiro0.hashCode())));
		assertThat(chihiro1.toString(), is(chihiro0.toString()));
		assertThat(chihir.toString(), not(is(chihiro0.toString())));
	}
}
