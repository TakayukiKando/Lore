package org.xgmtk.lore.types.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.logging.Logger;

import org.junit.Test;
import org.xgmtk.lore.Lore;
import org.xgmtk.lore.ast.Locator;
import org.xgmtk.lore.types.SimpleString;

public class TestSimpleString {
	@Test
	public void test() {
		Locator loc = new Locator(Lore.DEFAULT_VERSION, 0);
		Logger global = Logger.getGlobal();
		SimpleString chihiro0 = SimpleString.create("chihiro@xmpp.xgmtk.org", loc, global);
		SimpleString chihiro1 = SimpleString.create("chihiro@xmpp.xgmtk.org", loc, global);
		SimpleString chihir = SimpleString.create("chihir@xmpp.xgmtk.org", loc, global);
		
		assertThat(chihiro0, is(chihiro0));
		assertThat(chihiro1, is(chihiro0));
		assertThat(chihir, not(is(chihiro0)));
		assertThat(chihiro1.hashCode(), is(chihiro0.hashCode()));
		assertThat(chihir.hashCode(), not(is(chihiro0.hashCode())));
		assertThat(chihiro1.toString(), is(chihiro0.toString()));
		assertThat(chihir.toString(), not(is(chihiro0.toString())));
	}
}
