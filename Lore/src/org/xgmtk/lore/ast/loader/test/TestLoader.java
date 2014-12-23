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
package org.xgmtk.lore.ast.loader.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.xgmtk.lore.ast.Locator;
import org.xgmtk.lore.ast.loader.Loader;
import org.xgmtk.lore.ast.scanner.UnexpectedLiteralTypeException;
import org.xgmtk.lore.ast.scanner.test.TestASTScanner;
import org.xgmtk.lore.builtin.JID;
import org.xgmtk.lore.builtin.SimpleString;
import org.xgmtk.lore.builtin.JID.SyntaxException;
import org.xgmtk.lore.docinfo.Author;
import org.xgmtk.lore.docinfo.DocInfo;
import org.xgmtk.lore.docinfo.History;
import org.xgmtk.lore.utils.SystemErrorHandler;

public class TestLoader {
	private static Path wdir;
	private static Path forParserDir;
	private static Path sampleDir;
	private static URL basicLore;
	private static URL funcallLore;
	private static URL typesLore;
	
	private static final String clsName = TestASTScanner.class.getSimpleName();
	
	@BeforeClass
	public static void setupStatic() throws MalformedURLException{
		wdir = Paths.get(System.getProperty("user.dir"));
		forParserDir = wdir.resolve(Paths.get("sample", "forParser"));
		funcallLore = forParserDir.resolve("funcall.lore").toUri().toURL();
		typesLore = forParserDir.resolve("types.lore").toUri().toURL();
		sampleDir = wdir.resolve(Paths.get("sample"));
		basicLore = sampleDir.resolve("basic.lore").toUri().toURL();
	}

	@Rule
	public TestName name = new TestName();
	
	private String methodName;
	private Logger logger;

	@Before
	public void setup() throws IOException{
		this.methodName = name.getMethodName();
		this.logger = Logger.getLogger(clsName+"_"+this.methodName+"_log");
		this.logger.addHandler(new SystemErrorHandler());
		this.logger.setLevel(Level.ALL);
	}
	
	@Test
	public void testLoadDocInfo_BasicLore() throws UnexpectedLiteralTypeException, IOException, SyntaxException{
		DocInfo expectedDocInfo = new DocInfo(basicLore);
		expectedDocInfo.setVersion(new URL("http://xgmtk.org/lore/1.0"));
		expectedDocInfo.setEncoding("UTF-8");
		expectedDocInfo.setTitle("基本型");
		expectedDocInfo.setDescription(new SimpleString("共通する基本型の定義。\r\n", new Locator(basicLore, 1), logger));
		Author authorX = new Author("XGMTK.org");
		authorX.addContact(new URL("mailto:develop@xgmtk.org"));
		expectedDocInfo.addAutohr(authorX);
		Author authorC = new Author("椎路 ちひろ");
		authorC.addContact(new URL("mailto:develop@xgmtk.org"));
		authorC.addContact(new JID("chihiro@xmpp.xgmtk.org"));
		expectedDocInfo.addAutohr(authorC);
		expectedDocInfo.addHistory(new History(OffsetDateTime.parse("2013-07-15T00:00:00+09:00"), "椎路 ちひろ", "作成"));
		expectedDocInfo.addHistory(new History(OffsetDateTime.parse("2013-11-05T00:00:00+09:00"), "椎路 ちひろ", "改訂"));
		expectedDocInfo.addHistory(new History(OffsetDateTime.parse("2013-12-25T00:00:00+09:00"), "椎路 ちひろ", "改訂"));

		assertThat(expectedDocInfo, is(expectedDocInfo));

		Loader loader = new Loader(this.logger);
		loader.load(basicLore);
		
//		System.err.println();
//		System.err.println("*** expected:");
//		System.err.println(expectedDocInfo.toString());
//
//		System.err.println();
//		System.err.println("*** actual:");
//		loader.getDocInfos().values().stream().forEach(e->System.err.println(e.toString()));
		
		assertThat(loader.getDocInfo(basicLore).getSource(), is(expectedDocInfo.getSource()));
		assertThat(loader.getDocInfo(basicLore).getVersion(), is(expectedDocInfo.getVersion()));
		assertThat(loader.getDocInfo(basicLore).getEncoding(), is(expectedDocInfo.getEncoding()));
		assertThat(loader.getDocInfo(basicLore).getTitle(), is(expectedDocInfo.getTitle()));
		assertThat(loader.getDocInfo(basicLore).getDescription(), is(expectedDocInfo.getDescription()));
		assertThat(loader.getDocInfo(basicLore).getAutohrs(), is(expectedDocInfo.getAutohrs()));
		assertThat(loader.getDocInfo(basicLore).getHistories(), is(expectedDocInfo.getHistories()));
		
		assertThat(loader.getDocInfo(basicLore), is(expectedDocInfo));
		
		Map<URL,DocInfo> expectedInfos = new HashMap<>();
		expectedInfos.put(expectedDocInfo.getSource(), expectedDocInfo);
		assertThat(loader.getDocInfos(), is(expectedInfos));
	}
	@Test
	public void testLoadDocInfos_Funcall() throws UnexpectedLiteralTypeException, IOException, SyntaxException{
		Map<URL,DocInfo> expectedInfos = new HashMap<>();
		
		DocInfo expectedDocInfoF = new DocInfo(funcallLore);
		expectedDocInfoF.setTitle("関数呼び出し");
		expectedDocInfoF.setDescription(new SimpleString("関数呼び出しの結果を格納する変数宣言構文のサンプル。\r\nパーサーのテスト用。\r\n", new Locator(basicLore, 1), logger));
		expectedInfos.put(expectedDocInfoF.getSource(), expectedDocInfoF);

		DocInfo expectedDocInfoT = new DocInfo(typesLore);
		expectedDocInfoT.setTitle("型宣言");
		expectedDocInfoT.setDescription(new SimpleString("型宣言構文のサンプル。\r\nパーサーのテスト用。\r\n", new Locator(basicLore, 1), logger));
		expectedInfos.put(expectedDocInfoT.getSource(), expectedDocInfoT);

		Loader loader = new Loader(this.logger);
		loader.load(funcallLore);
		
//		System.err.println();
//		System.err.println("*** expected:");
//		System.err.println(expectedDocInfoF.toString());
//
//		System.err.println();
//		System.err.println("*** actual:");
//		loader.getDocInfos().values().stream().forEach(e->{System.err.println(e.toString());});

		assertThat(loader.getDocInfos(), is(expectedInfos));
	}
}
