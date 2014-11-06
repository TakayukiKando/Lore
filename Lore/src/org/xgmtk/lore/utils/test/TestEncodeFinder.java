package org.xgmtk.lore.utils.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xgmtk.lore.utils.EncodeFinder;

public class TestEncodeFinder {
	private static Path wdir;
	private static Path dir;
	
	@BeforeClass
	public static void setupStatic(){
		wdir = Paths.get(System.getProperty("user.dir"));
		dir = wdir.resolve(Paths.get("sample", "forParser"));
	}

	@Test
	public void testFindEncodeInfoDefault() throws IOException{
		String actualEnc = EncodeFinder.findEncodeInfo(dir.resolve("expressions.lore").toUri().toURL(), 100, "US-ASCII");
		assertThat(actualEnc, is("US-ASCII"));
	}
	
	@Test
	public void testFindEncodeInfo() throws IOException{
		String actualEnc = EncodeFinder.findEncodeInfo(dir.getParent().resolve("HelloWorld.lore").toUri().toURL(), 100, "US-ASCII");
		assertThat(actualEnc, not(is("UTF-8")));
	}
}
