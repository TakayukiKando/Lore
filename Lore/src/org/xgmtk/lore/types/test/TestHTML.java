package org.xgmtk.lore.types.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.logging.Logger;

import org.junit.Test;
import org.xgmtk.lore.Lore;
import org.xgmtk.lore.ast.Locator;
import org.xgmtk.lore.types.HTML;

public class TestHTML {
	@Test
	public void test() {
		Locator loc = new Locator(Lore.DEFAULT_VERSION, 0);
		Logger global = Logger.getGlobal();
		HTML chihiro0 = HTML.create("<html><head><title>title</title></head><body><p>chihiro</p></body></html>", loc, global);
		HTML chihiro1 = HTML.create("<html><head><title>title</title></head><body><p>chihiro</p></body></html>", loc, global);
		HTML chihir = HTML.create("<html><head><title>title</title></head><body><p>chihir</p></body></html>", loc, global);
		
		assertThat(chihiro0, is(chihiro0));
		assertThat(chihiro1, is(chihiro0));
		assertThat(chihir, not(is(chihiro0)));
		assertThat(chihiro1.hashCode(), is(chihiro0.hashCode()));
		assertThat(chihir.hashCode(), not(is(chihiro0.hashCode())));
		assertThat(chihiro1.toString(), is(chihiro0.toString()));
		assertThat(chihir.toString(), not(is(chihiro0.toString())));
	}
}
