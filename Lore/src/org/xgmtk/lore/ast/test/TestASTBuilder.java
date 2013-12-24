package org.xgmtk.lore.ast.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.ASTBuilder;

/**
 * Use antlr-4.1-complete.jar
 * 
 * @author kando
 *
 */
public class TestASTBuilder {
	private static Path wdir;
	private static Path dir;

	@BeforeClass
	public static void setupStatic(){
		wdir = Paths.get(System.getProperty("user.dir"));
		dir = wdir.resolve(Paths.get("sample", "forASTBuilder"));
	}
	

	@Test
	public void test() throws IOException{
		File src = new File(dir.toFile(), "simple.lore");
		AST tree = AST.build(src, ASTBuilder.DEFAULT_ENCODING);
	}
}
