package org.xgmtk.lore.builtin.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.logging.Logger;

import org.junit.Test;
import org.xgmtk.lore.Lore;
import org.xgmtk.lore.ast.Locator;
import org.xgmtk.lore.builtin.SimpleString;

public class TestSimpleString {
	@Test
	public void test() {
		Locator loc = new Locator(Lore.DEFAULT_VERSION, 0);
		Logger global = Logger.getGlobal();
		SimpleString chihiro0 = new SimpleString("chihiro@xmpp.xgmtk.org", loc, global);
		SimpleString chihiro1 = new SimpleString("chihiro@xmpp.xgmtk.org", loc, global);
		SimpleString chihir = new SimpleString("chihir@xmpp.xgmtk.org", loc, global);
		
		assertThat(chihiro0, is(chihiro0));
		assertThat(chihiro1, is(chihiro0));
		assertThat(chihir, not(is(chihiro0)));
		assertThat(chihiro1.hashCode(), is(chihiro0.hashCode()));
		assertThat(chihir.hashCode(), not(is(chihiro0.hashCode())));
		assertThat(chihiro1.toString(), is(chihiro0.toString()));
		assertThat(chihir.toString(), not(is(chihiro0.toString())));
	}
}
