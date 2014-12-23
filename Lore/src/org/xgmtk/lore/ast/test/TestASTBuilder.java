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
package org.xgmtk.lore.ast.test;

//import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.xgmtk.lore.ast.ASTNodes.id;
import static org.xgmtk.lore.ast.ASTNodes.lit;
import static org.xgmtk.lore.ast.ASTNodes.node;
import static org.xgmtk.lore.ast.Locator.loc;
import static org.xgmtk.lore.ast.test.ASTMatchers.equalAST;
import static org.xgmtk.lore.ast.test.ASTMatchers.equalASTWithoutLocator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.xgmtk.lore.ast.AST;
import org.xgmtk.lore.ast.NonTerminalSymbol;
import org.xgmtk.lore.ast.Locator;
import org.xgmtk.lore.ast.PrintVisitor;
import org.xgmtk.lore.builtin.Location;
import org.xgmtk.lore.builtin.SimpleString;

import static org.xgmtk.lore.ast.NonTerminalSymbol.*;

/**
 * Use antlr-4.1-complete.jar
 * 
 * @author kando
 *
 */
public class TestASTBuilder {
	private static final String NEWLINE = "\r\n";
	private static Path wdir;
	private static Path dir;
	private static final String clsName = TestASTBuilder.class.getSimpleName();
	
	@BeforeClass
	public static void setupStatic(){
		wdir = Paths.get(System.getProperty("user.dir"));
		dir = wdir.resolve(Paths.get("sample", "forParser"));
	}

	@Rule
	public TestName name = new TestName();
	
	private Logger logger;
	

	@Before
	public void setup() throws FileNotFoundException{
		String methodName = name.getMethodName();
		this.logger = Logger.getLogger(clsName+"_"+methodName+"_log");
	}
	
	public void dumpTree(String name, AST tree, boolean ignoreLocator) throws FileNotFoundException {
		PrintStream prn = new PrintStream(new FileOutputStream(dir.resolve(clsName+"."+name+".txt").toFile()));
		dumpTree(name, tree, prn, ignoreLocator);
		prn.close();
	}

	public void dumpTree(String name, AST tree, PrintStream prn, boolean ignoreLocator) {
		prn.println("*** "+name);
		PrintVisitor.printTree(tree, prn, ignoreLocator);
		prn.flush();
	}

	public void testExactly(AST expectedTree, URL src) throws IOException{
		AST actualTree = AST.build(src, this.logger);
//		String methodName = name.getMethodName();
//		dumpTree(methodName+".expected", expectedTree, false);
//		dumpTree(methodName+".actual", actualTree, false);
		assertThat(actualTree, equalAST(expectedTree));
	}

	public void testIgnoreLocator(AST expectedTree, URL src) throws IOException{
		AST actualTree = AST.build(src, this.logger);
//		String methodName = name.getMethodName();
//		dumpTree(methodName+".expected", expectedTree, true);
//		dumpTree(methodName+".actual", actualTree, true);
		assertThat(actualTree, equalASTWithoutLocator(expectedTree));
	}
	
	private static AST nd(NonTerminalSymbol symbol, AST... subtrees){
		return node(symbol, Locator.NOWHERE, subtrees);
	}
	
	private static AST nd(String symbol, AST... subtrees){
		Optional<NonTerminalSymbol> oFoundSymbol = NonTerminalSymbol.getSymbol(symbol);
		if(!oFoundSymbol.isPresent()){
			if(subtrees.length != 0){
				throw new IllegalArgumentException("ID node\""+symbol+"\" should not have children.");
			}
			return id(symbol, Locator.NOWHERE);
		}
		return nd(oFoundSymbol.get(), subtrees);
	}
	
	private <T> AST lt(T value){
		if(value instanceof String){
			return lit(new SimpleString((String)value,Locator.NOWHERE, logger), Locator.NOWHERE);
		}else if(value instanceof Integer){
			return lit(((Integer)value).longValue(), Locator.NOWHERE);
		}
		return lit(value, Locator.NOWHERE);
	}
	
	private <T> AST lt(T value, Locator loc){
		if(value instanceof String){
			return lit(new SimpleString((String)value,loc, logger), Locator.NOWHERE);
		}else if(value instanceof Integer){
			return lit(((Integer)value).longValue(), loc);
		}
		return lit(value, loc);
	}
	
	@Test
		public void testFuncall() throws IOException{
			URL srcPath = dir.resolve("funcall.lore").toUri().toURL();
			
			AST expectedTree = nd(ROOT,
//			desc("関数呼び出し"){[=[関数呼び出しの結果を格納する変数宣言構文のサンプル。
//			パーサーのテスト用。
//			]=]}
			nd(DESC, lt("関数呼び出し"), lt("関数呼び出しの結果を格納する変数宣言構文のサンプル。"+NEWLINE+"パーサーのテスト用。"+NEWLINE)),
			
//			import "types":url;
			nd(IMPORT, lt(dir.resolve("types.lore").toUri().toURL())),
			
//			period_hour0 = query("何時間寝ますか？");
			nd(VAR, nd("period_hour0"), nd(CALL, nd("query"), lt("何時間寝ますか？"))),
			
//			period_hour_form = query({
//				message = "数字で時間を入力してください。";
//				hour = unit[hour].input((1,...,12));
//			});
			nd(VAR, nd("period_hour_form"), 
				nd(CALL, nd("query"), nd(FORM_VAL, nd(CONT,
					nd(VAR, nd("message"), lt("数字で時間を入力してください。")),
					nd(VAR, nd("hour"), nd(CALL, 
						nd(QNAME, nd(UNIT_TYPE, nd("[hour]")), nd("input")), 
						nd(",...,", lt(1), lt(12))))
				)))
			),
			
//			period_hour1 = query("何時間寝ますか？",
//						{
//							message = "数字で時間を入力してください。";
//							hour = unit[hour].input((1,...,12));
//						}).hour;
			nd(VAR, nd("period_hour1"), nd(QNAME, nd(CALL, nd("query"), lt("何時間寝ますか？"), nd(FORM_VAL, nd(CONT,
					nd(VAR, nd("message"), lt("数字で時間を入力してください。")),
					nd(VAR, nd("hour"), nd(CALL, nd(QNAME, nd(UNIT_TYPE, nd("[hour]")), nd("input")), nd(",...,", lt(1), lt(12))))
				))), nd("hour"))),

//			period_hour2 = pc.query("何時間寝ますか？",
//						{
//							message = "数字で時間を入力してください。";
//							hour = unit[hour].input((1,...,12));
//						}).hour;
			nd(VAR, nd("period_hour2"), nd(QNAME, nd(CALL, nd(QNAME, nd("pc"), nd("query")), lt("何時間寝ますか？"), 
					nd(FORM_VAL, nd(CONT,
						nd(VAR, nd("message"), lt("数字で時間を入力してください。")),
						nd(VAR, nd("hour"), nd(CALL, nd(QNAME, nd(UNIT_TYPE, nd("[hour]")), nd("input")), nd(",...,", lt(1), lt(12))))
					))
				), nd("hour"))),

//			struct_0= fun({key="a"; value=1;},{key="b"; value=2;});
			nd(VAR, nd("struct_0"), nd(CALL, nd("fun"), 
				nd(FORM_VAL, nd(CONT,
					nd(VAR, nd("key"), lt("a")),
					nd(VAR, nd("value"), lt(1))
				)),
				nd(FORM_VAL, nd(CONT,
					nd(VAR, nd("key"), lt("b")),
					nd(VAR, nd("value"), lt(2))
				))
			)),
//			struct_1= A.fun({key="a"; value=1;}:T,{key="b"; value=2;}:T);
			nd(VAR, nd("struct_1"), nd(CALL, nd(QNAME, nd("A"), nd("fun")), 
				nd(FORM_VAL, nd(CONT,
					nd(VAR, nd("key"), lt("a")),
					nd(VAR, nd("value"), lt(1))
				), nd("T")),
				nd(FORM_VAL, nd(CONT,
					nd(VAR, nd("key"), lt("b")),
					nd(VAR, nd("value"), lt(2))
				),nd("T"))
			)),
//			struct_list_0= fun({{key="a"; value=1;},{key="b"; value=2;}});
			nd(VAR, nd("struct_list_0"), nd(CALL, nd("fun"), nd(LIST_VAL, 
				nd(FORM_VAL, nd(CONT,  
					nd(VAR, nd("key"), lt("a")),
					nd(VAR, nd("value"), lt(1))
				)),
				nd(FORM_VAL, nd(CONT, 
					nd(VAR, nd("key"), lt("b")),
					nd(VAR, nd("value"), lt(2))
				))
			))),
//			struct_list_1= A.fun({{key="a"; value=1;},{key="b"; value=2;}});
			nd(VAR, nd("struct_list_1"), nd(CALL, nd(QNAME, nd("A"), nd("fun")), nd(LIST_VAL, 
				nd(FORM_VAL, nd(CONT, 
					nd(VAR, nd("key"), lt("a")),
					nd(VAR, nd("value"), lt(1))
				)),
				nd(FORM_VAL, nd(CONT, 
					nd(VAR, nd("key"), lt("b")),
					nd(VAR, nd("value"), lt(2))
				))
			))),
						
//			vInt0= A.fun(1);
			nd(VAR, nd("vInt0"), nd(CALL, nd(QNAME, nd("A"), nd("fun")), lt(1))),
//			vInt1= fun(3*-2+1);
			nd(VAR, nd("vInt1"), nd(CALL, nd("fun"), nd("+", nd("*", lt(3), nd(NEGATE, lt(2))), lt(1)))),
//			vInt2= A.fun((vInt0+vInt1)%2);
			nd(VAR, nd("vInt2"), nd(CALL, nd(QNAME, nd("A"), nd("fun")), nd("%", nd("+", nd("vInt0"), nd("vInt1")), lt(2)))),
//			vInt3= fun(Math.abs(vInt1));
			nd(VAR, nd("vInt3"), nd(CALL, nd("fun"), nd(CALL, nd(QNAME, nd("Math"), nd("abs")), nd("vInt1")))),
//			vInt3= A.fun(Math.abs(vInt1));
			nd(VAR, nd("vInt4"), nd(CALL, nd(QNAME, nd("A"), nd("fun")), nd(CALL, nd(QNAME, nd("Math"), nd("abs")), nd("vInt1")))),

//			vFloat0=fun(1.0);
			nd(VAR, nd("vFloat0"), nd(CALL, nd("fun"), lt(1.0))),
//			vFloat1=fun(3.1415 * -2.E-5 + 1.0E10, vFloat0+vFloat3)/2.0;
			nd(VAR, nd("vFloat1"), nd("/", nd(CALL, nd("fun"), nd("+", nd("*", lt(3.1415), nd(NEGATE, lt(2.E-5))), lt(1.0E10)), nd("+", nd("vFloat0"), nd("vFloat3"))), lt(2.0))),
//			vFloat3=Math.cos(1.0);
			nd(VAR, nd("vFloat3"), nd(CALL, nd(QNAME, nd("Math"), nd("cos")), lt(1.0))),

//			range0_5=fun((0,...,5));
			nd(VAR, nd("range0_5"), nd(CALL, nd("fun"), nd(",...,", lt(0), lt(5)))),
//			range_1_0_2_5=fun((-1.0<...,2.5));
			nd(VAR, nd("range_1_0_2_5"), nd(CALL, nd("fun"), nd("<...,", nd(NEGATE, lt(1.0)), lt(2.5)))),
//			range1_10=fun((0,...<10),(-1.0E-6<...<3.0E10),(vInt0<...<vFloat3));
			nd(VAR, nd("range1_10"), nd(CALL, nd("fun"),  
				nd(",...<", lt(0), lt(10)), 
				nd("<...<", nd(NEGATE, lt(1.0E-6)), lt(3.0E10)), 
				nd("<...<", nd("vInt0"), nd("vFloat3"))
			)),
			
//			bool_in_range0_5=A.fun(vInt0.in(0,...,5));
			nd(VAR, nd("bool_in_range0_5"), nd(CALL, nd(QNAME, nd("A"), nd("fun")), 
					nd(CALL, nd(QNAME, nd("vInt0"), nd("in")), nd(",...,", lt(0), lt(5)))
			)),
			
//			i=0;
			nd(VAR, nd("i"), lt(0)),
//			list0= fun({i+1, 1+1, 1*3, 4});
			nd(VAR, nd("list0"), nd(CALL, nd("fun"), nd(LIST_VAL, 
				nd("+", nd("i"), lt(1)),
				nd("+", lt(1), lt(1)),
				nd("*", lt(1), lt(3)),
				lt(4)
			))),
//			list0= A.fun({i+1, 1+1, 1*3, 4});
			nd(VAR, nd("list0"), nd(CALL, nd(QNAME, nd("A"), nd("fun")), nd(LIST_VAL, 
				nd("+", nd("i"), lt(1)),
				nd("+", lt(1), lt(1)),
				nd("*", lt(1), lt(3)),
				lt(4)
			))),
//			list_access=list0.get(i+1);
			nd(VAR, nd("list_access"), nd(CALL, nd(QNAME, nd("list0"), nd("get")), nd("+", nd("i"), lt(1)))),
			
//			boole_key_a_length_positive = fun(expressions.sample.struct_list_0(0).key.length > 0);
			nd(VAR, nd("boole_key_a_length_positive"), nd(CALL, nd("fun"), 
				nd(">", 
					nd(QNAME, nd(QNAME, 
						nd(CALL,  nd(QNAME, nd(QNAME, nd("expressions"),nd("sample")),nd("struct_list_0")), lt(0)), 
					nd("key")), nd("length")), 
				lt(0))
			)),

//			dice0 = fun(-3D6+2, d6-2);
			nd(VAR, nd("dice0"), nd(CALL, nd("fun"), 
				nd("+", nd(NEGATE, nd(DICE, lt(3), lt(6))), lt(2)),
				nd("-", nd(DICE, lt(1), lt(6)), lt(2))
			)),
//			dice2 = A.fun(4d8, 4d);
			nd(VAR, nd("dice2"), nd(CALL, nd(QNAME, nd("A"), nd("fun")), 
				nd(DICE, lt(4), lt(8)),
				nd(DICE, lt(4), lt(6))
			)),
			
//			unit0 = fun(3[m]+(0.5*3)[km], 9.8[m/s^2]);
			nd(VAR, nd("unit0"), nd(CALL, nd("fun"), 
				nd("+", nd(UNIT_VAL, lt(3), nd("[m]")), nd(UNIT_VAL, nd("*", lt(0.5), lt(3)), nd("[km]"))),
				nd(UNIT_VAL, lt(9.8), nd("[m/s^2]"))
			))
			);
			
			testIgnoreLocator(expectedTree, srcPath);
		}
	
	@Test
	public void testQuerycall() throws IOException{
		URL srcPath = dir.resolve("querycall.lore").toUri().toURL();

		AST expectedTree = nd(ROOT, 
//			desc("関数呼び出し"){[=[関数呼び出しの結果を格納する変数宣言構文のサンプル。
//			パーサーのテスト用。
//			]=]}
			nd(DESC, lt("関数呼び出し"), lt("関数呼び出しの結果を格納する変数宣言構文のサンプル。"+NEWLINE+"パーサーのテスト用。"+NEWLINE)),

//			import "types.lore":url;
			nd(IMPORT, lt(dir.resolve("types.lore").toUri().toURL())),
		
//			period_hour0 = query("何時間寝ますか？");
			nd(VAR, nd("period_hour0"), nd(CALL, nd("query"), lt("何時間寝ますか？"))),
		
//			message0 = {
//					message = "数字で時間を入力してください。";
//				};
			nd(VAR, nd("message0"), nd(FORM_VAL, nd(CONT, nd(VAR, nd("message"), lt("数字で時間を入力してください。"))))),

//			hour = unit[hour].input((1,...,12));
			nd(VAR, nd("hour"), nd(CALL, nd(QNAME, nd(UNIT_TYPE, nd("[hour]")), nd("input")), nd(",...,", lt(1), lt(12)))),

//			message1 = {
//					message = "数字で時間を入力してください。";
//					hour = 1.0;
//				};
			nd(VAR, nd("message1"), nd(FORM_VAL, nd(CONT, 
				nd(VAR, nd("message"), lt("数字で時間を入力してください。")),
				nd(VAR, nd("hour"), lt(1.0))
				))),

//			message2 = {
//					message = "数字で時間を入力してください。";
//					hour = unit[hour].input((1,...,12));
//				};
			nd(VAR, nd("message2"), nd(FORM_VAL, nd(CONT, 
				nd(VAR, nd("message"), lt("数字で時間を入力してください。")),
				nd(VAR, nd("hour"), nd(CALL, nd(QNAME, nd(UNIT_TYPE, nd("[hour]")), nd("input")), nd(",...,", lt(1), lt(12))))
				))),

//			period_hour1 = query({
//					message = "数字で時間を入力してください。";
//					hour = unit[hour].input((1,...,12));
//				}).hour;
			nd(VAR, nd("period_hour1"), nd(QNAME, nd(CALL, nd("query"), nd(FORM_VAL, nd(CONT, 
				nd(VAR, nd("message"), lt("数字で時間を入力してください。")),
				nd(VAR, nd("hour"), nd(CALL, nd(QNAME, nd(UNIT_TYPE, nd("[hour]")), nd("input")), nd(",...,", lt(1), lt(12))))
				))), nd("hour"))),

//			period_hour2 = query("何時間寝ますか？",
//						{
//							message = "数字で時間を入力してください。";
//							hour = unit[hour].input((1,...,12));
//						}).hour;
			nd(VAR, nd("period_hour2"),  nd(QNAME, nd(CALL, nd("query"),lt("何時間寝ますか？"), nd(FORM_VAL, nd(CONT, 
				nd(VAR, nd("message"), lt("数字で時間を入力してください。")),
				nd(VAR, nd("hour"), nd(CALL, nd(QNAME, nd(UNIT_TYPE, nd("[hour]")), nd("input")), nd(",...,", lt(1), lt(12))))
				))), nd("hour"))),
						
//			period_hour3 = pc.query("何時間寝ますか？",
//						{
//							message = "数字で時間を入力してください。";
//							hour = unit[hour].input((1,...,12));
//						}).hour;
			nd(VAR, nd("period_hour3"), nd(QNAME, nd(CALL, nd(QNAME, nd("pc"), nd("query")), lt("何時間寝ますか？"), nd(FORM_VAL, nd(CONT, 
				nd(VAR, nd("message"), lt("数字で時間を入力してください。")),
				nd(VAR, nd("hour"), nd(CALL, nd(QNAME, nd(UNIT_TYPE, nd("[hour]")), nd("input")), nd(",...,", lt(1), lt(12))))
				))),nd("hour")))
		);
		
		testIgnoreLocator(expectedTree, srcPath);
	}

	@Test
	public void testExpressions() throws IOException{
		URL srcPath = dir.resolve("expressions.lore").toUri().toURL();
		
		AST expectedTree = nd(ROOT,
//			desc("変数宣言"){[=[変数宣言構文のサンプル。
//			パーサーのテスト用。
//			]=]}
			nd(DESC, lt("変数宣言"), lt("変数宣言構文のサンプル。"+NEWLINE+"パーサーのテスト用。"+NEWLINE)),
			
//			import "types.lore":url;
			nd(IMPORT, lt(dir.resolve("types.lore").toUri().toURL())),
			
//			vInt0= 1;
			nd(VAR, nd("vInt0"), lt(1)),
//			vInt1= 3*-2+1;
			nd(VAR, nd("vInt1"), nd("+", nd("*", lt(3), nd(NEGATE, lt(2))), lt(1))),
//			vInt2=(vInt0+vInt1)%2;
			nd(VAR, nd("vInt2"), nd("%", nd("+", nd("vInt0"), nd("vInt1")), lt(2))),
//			vInt3=Math.abs(vInt1);
			nd(VAR, nd("vInt3"), nd(CALL, nd(QNAME, nd("Math"), nd("abs")), nd("vInt1"))),
			
//			vFloat0=1.0;
			nd(VAR, nd("vFloat0"), lt(1.0)),
//			vFloat1=3.1415 * -2.E-5 + 1.0E10;
			nd(VAR, nd("vFloat1"), nd("+", nd("*", lt(3.1415), nd(NEGATE, lt(2.E-5))), lt(1.0E10))),
//			vFloat2=(vFloat0+vFloat1)/2.0;
			nd(VAR, nd("vFloat2"), nd("/", nd("+", nd("vFloat0"), nd("vFloat1")), lt(2.0))),
//			vFloat3=Math.cos(1.0);
			nd(VAR, nd("vFloat3"), nd(CALL, nd(QNAME, nd("Math"), nd("cos")), lt(1.0))),

//			range0_5=0,...,5;
			nd(VAR, nd("range0_5"), nd(",...,", lt(0), lt(5))),
//			range_1_0_2_5=-1.0<...,2.5;
			nd(VAR, nd("range_1_0_2_5"), nd("<...,", nd(NEGATE, lt(1.0)), lt(2.5))),
//			range1_10=0,...<10;
			nd(VAR, nd("range1_10"), nd(",...<", lt(0), lt(10))),
//			range1_0_3_0=-1.0E-6<...<3.0E10;
			nd(VAR, nd("range1_0_3_0"), nd("<...<", nd(NEGATE, lt(1.0E-6)), lt(3.0E10))),
//			rangeI0_F3=vInt0<...<vFloat3;
			nd(VAR, nd("rangeI0_F3"), nd("<...<", nd("vInt0"), nd("vFloat3"))),
			
//			unit0=0[km];
			nd(VAR, nd("unit0"), nd(UNIT_VAL, lt(0), nd("[km]"))),
//			range0=0[km],...,1[km];
			nd(VAR, nd("range0"), nd(",...,", nd(UNIT_VAL, lt(0), nd("[km]")), nd(UNIT_VAL, lt(1), nd("[km]")))),
			
//			bool_in_range0_5=vInt0.in(0,...,5);
			nd(VAR, nd("bool_in_range0_5"), nd(CALL, nd(QNAME, nd("vInt0"), nd("in")), nd(",...,", lt(0), lt(5)))),
			
//			i=0;
			nd(VAR, nd("i"), lt(0)),
//			list0= {i+1, 1+1, 1*3, 4};
			nd(VAR, nd("list0"), nd(LIST_VAL, nd("+", nd("i"), lt(1)), nd("+", lt(1), lt(1)), nd("*", lt(1), lt(3)), lt(4))),
//			list_access=list0.get(i+1);
			nd(VAR, nd("list_access"), nd(CALL, nd(QNAME, nd("list0"), nd("get")), nd("+", nd("i"), lt(1)))),
			
//			section expressions {
//				section sample {
//					struct_list_0= {{key="a"; value=1;},{key="b"; value=2;}};
//					struct_list_1= {{key="a"; value=1;}:Pair,{key="b"; value=2;}:Pair};
//				}
//			}
			nd(SECTION,nd("expressions"), nd(SECTION, nd("sample"), 
				nd(VAR, nd("struct_list_0"), nd(LIST_VAL, 
					nd(FORM_VAL, nd(CONT, 
						nd(VAR, nd("key"), lt("a")), nd(VAR, nd("value"), lt(1)))),
					nd(FORM_VAL, nd(CONT, 
						nd(VAR, nd("key"), lt("b")), nd(VAR, nd("value"), lt(2)))))),
				nd(VAR, nd("struct_list_1"), nd(LIST_VAL, 
					nd(FORM_VAL, nd(CONT, 
						nd(VAR, nd("key"), lt("a")), nd(VAR, nd("value"), lt(1))), nd("Pair")),
					nd(FORM_VAL, nd(CONT,  
						nd(VAR, nd("key"), lt("b")), nd(VAR, nd("value"), lt(2))), nd("Pair"))))
			)),
			
//			boole_key_a_length_positive = expressions.sample.struct_list_0(0).key.length > 0;
			nd(VAR, nd("boole_key_a_length_positive"), nd(">", 
					nd(QNAME, 
						nd(QNAME,
							nd(CALL, 
								nd(QNAME, nd(QNAME, nd("expressions"), nd("sample")), nd("struct_list_0")), 
								lt(0)), 
							nd("key")), 
						nd("length")), 
					lt(0))),
								
//			dice0 = -3D6+2;
			nd(VAR, nd("dice0"), nd("+", nd(NEGATE, nd(DICE, lt(3), lt(6))), lt(2))),
//			dice1 = d6-2;
			nd(VAR, nd("dice1"), nd("-", nd(DICE, lt(1), lt(6)), lt(2))),
//			dice2 = 4d8;
			nd(VAR, nd("dice2"), nd(DICE, lt(4),lt(8))),
//			dice3 = 4d;
			nd(VAR, nd("dice3"), nd(DICE, lt(4),lt(6))),
			
//			unit1 = 3[m]+(0.5*3)[km];
			nd(VAR, nd("unit1"), nd("+", nd(UNIT_VAL, lt(3), nd("[m]")), nd(UNIT_VAL, nd("*", lt(0.5), lt(3)),nd("[km]")))),
//			unit2 = 9.8[m/s^2];
			nd(VAR, nd("unit2"), nd(UNIT_VAL, lt(9.8), nd("[m/s^2]"))),
			
//			input0 = integer.input;
			nd(VAR, nd("input0"), nd(QNAME, nd("integer"), nd("input"))),
//			input1 = list<real>.input(4);//length
			nd(VAR, nd("input1"), nd(CALL, nd(QNAME, nd(LIST_TYPE, nd("real")), nd("input")), lt(4))),
//			input2 = range<integer>.input;
			nd(VAR, nd("input2"), nd(QNAME, nd(RANGE_TYPE, nd("integer")), nd("input"))),
//			input3 = Actor.input;
			nd(VAR, nd("input3"), nd(QNAME, nd("Actor"), nd("input"))),
//			input4 = unit[m].input(6);//default
			nd(VAR, nd("input4"), nd(CALL, nd(QNAME, nd(UNIT_TYPE, nd("[m]")), nd("input")), lt(6))),
//			input5 = unit[m].input((1,...,12),6);//range and default
			nd(VAR, nd("input5"),  nd(CALL, nd(QNAME, nd(UNIT_TYPE, nd("[m]")), nd("input")), 
					nd(",...,", lt(1), lt(12)),lt(6)))
		);
		
		testIgnoreLocator(expectedTree, srcPath);
	}
	
	@Test
	public void testTypes() throws IOException, Location.SyntaxException{
		URL srcPath = dir.resolve("types.lore").toUri().toURL();
		
		AST expectedTree = nd(ROOT,
//		desc("型宣言"){[=[型宣言構文のサンプル。
//		パーサーのテスト用。
//		]=]}
		nd(DESC, lt("型宣言"), lt("型宣言構文のサンプル。"+NEWLINE+"パーサーのテスト用。"+NEWLINE)),
			
//		section types {
		nd(SECTION, nd("types"),
				
//			[m]=1.0;
			nd(UNIT_DEF, nd("[m]"), lt(1.0)),
//			[km]=1000[m];
			nd(UNIT_DEF, nd("[km]"), lt(1000), nd("[m]")),
//			[m/s^2]=1.0;
			nd(UNIT_DEF, nd("[m/s^2]"), lt(1.0)),
			
//			enum Action{
//				search{caption="探す";}
//				move{caption="移動する";}
//				sleep{caption="寝る";}
//			}
			nd(ENUM_DEF, nd("Action"), 
				nd(ENUM_VAL, nd("search"), nd(VAR, nd("caption"), lt("探す"))),
				nd(ENUM_VAL, nd("move"), nd(VAR, nd("caption"), lt("移動する"))),
				nd(ENUM_VAL, nd("sleep"), nd(VAR, nd("caption"), lt("寝る")))
			),


//			function mean(elements : list<real>): real{
//				total = elements.sum;
//				result = total / elements.length;
//			}
			nd(FUNCTION, nd(TYPE_SPEC, nd("mean"), nd("real")), nd(PARAMS, nd(TYPE_SPEC, nd("elements"), nd(LIST_TYPE, nd("real")))), 
				nd(BODY,
					nd(VAR, nd("total"), nd(QNAME, nd("elements"), nd("sum"))),
					nd(RESULT, nd("/", nd("total"), nd(QNAME, nd("elements"), nd("length"))))
				)
			),

//			rule sleepAction(pc : Actor){
			nd(RULE, nd("sleepAction"), nd(PARAMS, nd(TYPE_SPEC, nd("pc"), nd("Actor"))), nd(BODY,
			
//				period_hour=pc.query("何時間寝ますか？",
//					{
//						message = "数字で時間を入力してください。";
//						hour = unit [hour].input((1,...,12));
//					}).hour;
				nd(VAR, nd("period_hour"), nd(QNAME, nd(CALL, nd(QNAME, nd("pc"), nd("query")), 
					lt("何時間寝ますか？"),
					nd(FORM_VAL, nd(CONT, 
						nd(VAR, nd("message"), lt("数字で時間を入力してください。")),
						nd(VAR, nd("hour"), nd(CALL, nd(QNAME, nd(UNIT_TYPE, nd("[hour]")), nd("input")), nd(",...,", lt(1), lt(12))))
					))
				), nd("hour"))),

//				period = ceil(period_hour, 1[R]);
				nd(VAR, nd("period"), nd(CALL, nd("ceil"), nd("period_hour"), nd(UNIT_VAL, lt(1), nd("[R]")))),

//				schedule.add({
//					ticks=schedule.current+period;
//					priority=0;
//					
//					rule handle{
//						pc.choice;
//					}
//				}:Event);
				nd(CALL, nd(QNAME, nd("schedule"), nd("add")), 
						nd(FORM_VAL, nd(CONT, 
							nd(VAR, nd("ticks"), nd("+", nd(QNAME, nd("schedule"), nd("current")), nd("period"))),
							nd(VAR, nd("priority"), lt(0)),
							nd(RULE, nd("handle"), nd(PARAMS), nd(BODY, //Override
								nd(QNAME, nd("pc"), nd("choice"))
							))
						), nd("Event"))
					)

//			}
			))/* rule sleepAction */,

//			form HP{
//				current : integer;
//				hp_range : range<integer>;
//
//				live : boolean{
//					result = !hp_range.match(current);
//				}
//
//				alter damage(damages : list<integer>){
//					current = current - damages.sum;
//				} 
//			}
			nd(FORM_DEF, nd("HP"), nd(CONT, 
				nd(TYPE_SPEC, nd("current"), nd("integer")),
				nd(TYPE_SPEC, nd("hp_range"), nd(RANGE_TYPE, nd("integer"))),
				nd(ACCESSOR, nd(TYPE_SPEC, nd("live"), nd("boolean")), nd(PARAMS), nd(BODY, 
					nd(RESULT, nd("!", nd(CALL, nd(QNAME, nd("hp_range"), nd("match")), nd("current"))))
				)),
				nd(ALTER, nd("damage"), nd(TYPE_SPEC, nd("damages"), nd(LIST_TYPE, nd("integer"))), nd(BODY,
					nd(MODIFY, nd("current"), nd("-", nd("current"), nd(QNAME, nd("damages"), nd("sum"))))
				))
			)),

			
//			form SampleActor extends Actor{
//				location = "/[0]":loc;
//				mobility = 3.0[m/R];
//				image = "no_image.jpg":url;
//				description : url;
//				hp : HP;
//				items : list<Item>;
//
//				enum MobilityMode{
//					run{factor=2.0;}
//					walk{factor=1.0;}
//					crawl{factor=0.5;}
//				}
//
//				speed(mode : MobilityMode) : unit[m/s]{
//					result = mobility * mode.factor;
//				}
//			}
			nd(FORM_DEF, nd("SampleActor"), nd("Actor"), nd(CONT, 
				nd(VAR, nd("location"), lt(Location.parse("/[0]"))),
				nd(VAR, nd("mobility"), nd(UNIT_VAL, lt(3.0), nd("[m/R]"))),
				nd(VAR, nd("image"), lt(dir.resolve("no_image.jpg").toUri().toURL())),
				nd(TYPE_SPEC, nd("description"), nd("url")),
				nd(TYPE_SPEC, nd("hp"), nd("HP")),
				nd(TYPE_SPEC, nd("items"), nd(LIST_TYPE, nd("Item"))),
				nd(ENUM_DEF, nd("MobilityMode"),
					nd(ENUM_VAL, nd("run"), nd(VAR, nd("factor"), lt(2.0))),
					nd(ENUM_VAL, nd("walk"), nd(VAR, nd("factor"), lt(1.0))),
					nd(ENUM_VAL, nd("crawl"), nd(VAR, nd("factor"), lt(0.5)))
				),
				nd(ACCESSOR, nd(TYPE_SPEC, nd("speed"), nd(UNIT_TYPE, nd("[m/s]"))), 
					nd(PARAMS,
						nd(TYPE_SPEC, nd("mode"), nd("MobilityMode"))
					),
					nd(BODY,
						nd(RESULT, nd("*", nd("mobility"), nd(QNAME, nd("mode"), nd("factor"))))
					)
				)
			)),
//
//			private rule addItem(pc : SampleActor, item : Item){
//				pc.items.add(item);
//			}
			nd(PRIVATE, nd(RULE, nd("addItem"), nd(PARAMS, nd(TYPE_SPEC, nd("pc"), nd("SampleActor")), nd(TYPE_SPEC, nd("item"), nd("Item"))),
				nd(BODY, 
					nd(CALL, nd(QNAME, nd(QNAME, nd("pc"), nd("items")), nd("add")), nd("item"))
				)
			)),

//			form Sample {
			nd(FORM_DEF, nd("Sample"), nd(CONT, 
//				private cstr = "constant string";
				nd(PRIVATE, nd(VAR, nd("cstr"), lt("constant string"))),
				
//				private form Inner{
//					link : Sample;
//					linkInner : Inner;
//				}
				nd(PRIVATE, nd(FORM_DEF, nd("Inner"), nd(CONT, 
					nd(TYPE_SPEC, nd("link"), nd("Sample")),
					nd(TYPE_SPEC, nd("linkInner"), nd("Inner"))
				))),
				
//				private inner : Inner;
				nd(PRIVATE, nd(TYPE_SPEC, nd("inner"), nd("Inner"))),
				
//				anyonimous = {
//					key = "sample";
//					value = 1.0;
//				};
				nd(VAR, nd("anyonimous"), nd(FORM_VAL,nd(CONT, 
					nd(VAR, nd("key"), lt("sample")),
					nd(VAR, nd("value"), lt(1.0))
				))),

//				explicit : anyonimous.type;
				nd(TYPE_SPEC, nd("explicit"), nd(QNAME, nd("anyonimous"), nd("type"))),
				
//				anyonimouses = {
//					{
//						key = "sample1";
//						value = 1.0;
//					},
//					{
//						key = "sample2";
//						value = 2.0;
//					}
//				};
				nd(VAR, nd("anyonimouses"), nd(LIST_VAL,
					nd(FORM_VAL, nd(CONT, 
						nd(VAR, nd("key"), lt("sample1")),
						nd(VAR, nd("value"), lt(1.0))
					)),
					nd(FORM_VAL, nd(CONT, 
						nd(VAR, nd("key"), lt("sample2")),
						nd(VAR, nd("value"), lt(2.0))
					))
				)),
				
//				explicits : list<anyonimous.type>;
				nd(TYPE_SPEC, nd("explicits"), nd(LIST_TYPE, nd(QNAME, nd("anyonimous"), nd("type"))))
//			}
			))//form Sample
//		}
		)//section types
		);
		
		testIgnoreLocator(expectedTree, srcPath);
	}

	@Test
	public void testLambda() throws IOException{
			URL srcPath = dir.resolve("lambda.lore").toUri().toURL();
			
			AST expectedTree = nd(ROOT, 
//				desc("関数値"){[=[関数値のサンプル。
//				パーサーのテスト用。
//				]=]}
				nd(DESC, lt("関数値"), lt("関数値のサンプル。"+NEWLINE+"パーサーのテスト用。"+NEWLINE)),
					
//				import "types.lore":url;
				nd(IMPORT, lt(dir.resolve("types.lore").toUri().toURL())),
				
//				[enc]=1.0;
				nd(UNIT_DEF, nd("[enc]"), lt(1.0)),

//				form ItemSet{
				nd(FORM_DEF, nd("ItemSet"), nd(CONT, 
//					items : list<Item>;
					nd(TYPE_SPEC, nd("items"), nd(LIST_TYPE, nd("Item"))),
//					encCalc : @<(list<Item>) -> unit[enc]>;
					nd(TYPE_SPEC, nd("encCalc"), nd(LAMBDA_TYPE, nd(UNIT_TYPE, nd("[enc]")), nd(PARAMS, nd(LIST_TYPE, nd("Item"))))),
//					enc -> unit[enc]{result = encCalc(items);}
					nd(ACCESSOR, nd(TYPE_SPEC, nd("enc"), nd(UNIT_TYPE, nd("[enc]"))), nd(PARAMS), nd(BODY,
						nd(RESULT, nd(CALL, nd("encCalc"), nd("items")))
					)),
//	
//					find (name : string) -> Item{
//						items.find1st(@(it : Item) -> boolean{result = it.name == name;});
//					}
					nd(ACCESSOR, nd(TYPE_SPEC, nd("find"), nd("Item")), nd(PARAMS, nd(TYPE_SPEC, nd("name"), nd("string"))), nd(BODY, 
						nd(CALL, nd(QNAME, nd("items"), nd("find1st")), 
							nd(LAMBDA, nd("boolean"), nd(PARAMS, nd(TYPE_SPEC, nd("it"), nd("Item"))), nd(BODY,
								nd(RESULT, nd("==", nd(QNAME, nd("it"), nd("name")), nd("name")))
							))
						)
					))
//				}
				)),
				
//				form LambdaSample{
				nd(FORM_DEF, nd("LambdaSample"), nd(CONT, 
//					l0 : @<real: real>;
					nd(TYPE_SPEC, nd("l0"), nd(LAMBDA_TYPE, nd("real"), nd(PARAMS, nd("real")))),
//					l1 : @<(real, real): real>;
					nd(TYPE_SPEC, nd("l1"), nd(LAMBDA_TYPE, nd("real"), nd(PARAMS, nd("real"), nd("real")))),
//					//l2 : @< (): real>;
					//nd(TYPE_SPEC, nd("l2"), nd(LAMBDA_TYPE, nd("real"), nd(PARAMS))),
//					l3 : @<: real>;
					nd(TYPE_SPEC, nd("l3"), nd(LAMBDA_TYPE, nd("real"), nd(PARAMS))),
//					l4 : @<(real, real)>;
					nd(TYPE_SPEC, nd("l4"), nd(LAMBDA_TYPE, nd(PARAMS, nd("real"), nd("real")))),
//					l5 : @<real>;
					nd(TYPE_SPEC, nd("l5"), nd(LAMBDA_TYPE, nd(PARAMS, nd("real")))),
//					l6 : @<>;
					nd(TYPE_SPEC, nd("l6"), nd(LAMBDA_TYPE, nd(PARAMS)))
//				}
				)),
				
				nd(VAR, nd("lambda0"), nd(LAMBDA, nd("real"), 
						nd(PARAMS, nd(TYPE_SPEC, nd("x"), nd("real"))), 
						nd(BODY, nd(RESULT, nd("*", nd("x"), nd("x")))))),
				
//				v = {
				nd(VAR, nd("vLambdas"), nd(FORM_VAL, nd(CONT, 
//					l0 = @ x:real:real x*x;
					nd(VAR, nd("l0"), nd(LAMBDA, nd("real"), 
							nd(PARAMS, nd(TYPE_SPEC, nd("x"), nd("real"))), 
							nd(BODY, nd(RESULT, nd("*", nd("x"), nd("x")))))),
//					l1 = @(a:real, b:real):real {result=a*b;};
					nd(VAR, nd("l1"), nd(LAMBDA, nd("real"), 
							nd(PARAMS, nd(TYPE_SPEC, nd("a"), nd("real")), nd(TYPE_SPEC, nd("b"), nd("real"))), 
							nd(BODY, nd(RESULT, nd("*", nd("a"), nd("b")))))),
//					//l2 = @ (): real {result = 1.0;};
//					nd(VAR, nd("l2"), nd(LAMBDA, nd("real"), 
//							nd(PARAMS), 
//							nd(BODY, nd(VAR, nd("result"), lt(1.0)))))),
//					l3 = @ : real 1.0;
					nd(VAR, nd("l3"), nd(LAMBDA, nd("real"), 
							nd(PARAMS), 
							nd(BODY, nd(RESULT, lt(1.0))))),
//					l4 = @(a:real, b:real){message(a+b);};
					nd(VAR, nd("l4"), nd(LAMBDA, 
							nd(PARAMS, nd(TYPE_SPEC, nd("a"), nd("real")), nd(TYPE_SPEC, nd("b"), nd("real"))), 
							nd(BODY, 
								nd(VAR, nd("c"), nd("+", nd("a"), nd("b"))),
								nd(CALL, nd("message"), nd("c"))
							))),
//					l5 = @ x:real {message(x);};
					nd(VAR, nd("l5"), nd(LAMBDA, 
							nd(PARAMS, nd(TYPE_SPEC, nd("x"), nd("real"))), 
							nd(BODY, nd(CALL, nd("message"), nd("x"))))),
//					l6 = @{main;};
					nd(VAR, nd("l6"), nd(LAMBDA,
							nd(PARAMS),
							nd(BODY, nd("main"))
							))
//				}: LambdaSample;
				), nd("LambdaSample")))
			);
			
			testIgnoreLocator(expectedTree, srcPath);
	}

	@Test
	public void testSelect() throws IOException{
		URL srcPath = dir.resolve("select.lore").toUri().toURL();
		
		AST expectedTree = nd(ROOT ,
//			desc("分岐"){[=[分岐のサンプル。
//			パーサーのテスト用。
//			]=]}
			nd(DESC, lt("分岐"), lt("分岐のサンプル。"+NEWLINE+"パーサーのテスト用。"+NEWLINE)),
			
//			import "types.lore":url;
			nd(IMPORT, lt(dir.resolve("types.lore").toUri().toURL())),
			
//			[enc]=1.0;
			nd(UNIT_DEF, nd("[enc]"), lt(1.0)),

//			enum Hands { _1H; _2H; Sheild;}
			nd(ENUM_DEF, 
				nd("Hands"), 
				nd(ENUM_VAL, nd("_1H")), 
				nd(ENUM_VAL, nd("_2H")), 
				nd(ENUM_VAL, nd("Sheild"))
			),

//			function selection(items: list<Item>, name: string): Hands{
			nd(FUNCTION, nd(TYPE_SPEC, nd("selection0"), nd("Hands")),
				nd(PARAMS,
				nd(TYPE_SPEC, nd("items"), nd(LIST_TYPE, nd("Item"))), nd(TYPE_SPEC, nd("name"), nd("string"))
				),
				nd(BODY,
//					result = select(items.get(0).name){
//						case ("dagger"){
//							a = Hands._1H;
//							result = a;
//						}
//						case ("claymore"){
//							a = Hands._2H;
//							result = a;
//						}
//						default {
//							a = Hands.Sheild;
//							result = a;
//						}
//					};
					nd(RESULT,nd(SELECT, nd(QNAME, nd(CALL, nd(QNAME, nd("items"), nd("get")), lt(0)), nd("name")),
						nd(CASE, lt("dagger"), nd(BODY, 
							nd(VAR, nd("a"), nd(QNAME, nd("Hands"), nd("_1H"))),
							nd(RESULT, nd("a"))
						)),
						nd(CASE, lt("claymore"), nd(BODY, 
							nd(VAR, nd("a"), nd(QNAME, nd("Hands"), nd("_2H"))),
							nd(RESULT, nd("a"))
						)),
						nd(DEFAULT, nd(BODY, 
							nd(VAR, nd("a"), nd(QNAME, nd("Hands"), nd("Sheild"))),
							nd(RESULT, nd("a"))
						))
					))
				)
//			}
			),//function selection
//
//			rule selection(owner : Actor, items: list<Item>, name: string){
			nd(RULE, nd("selection1"), nd(PARAMS,
					nd(TYPE_SPEC, nd("owner"), nd("Actor")), 
					nd(TYPE_SPEC, nd("items"), nd(LIST_TYPE, nd("Item"))),
					nd(TYPE_SPEC, nd("name"), nd("string"))),nd(BODY, 
//				select(items.get(0).name){
//					case ("dagger"){
//						owner.message(Hands._1H);
//					}
//					case ("claymore"){
//						owner.message(Hands._2H);
//					}
//					default {
//						owner.message(Hands.Sheild);
//					}
//				}
					nd(SELECT, nd(QNAME, nd(CALL, nd(QNAME, nd("items"), nd("get")), lt(0)), nd("name")),
						nd(CASE, lt("dagger"), nd(BODY, 
							nd(VAR, nd("msg"), nd(QNAME, nd("Hands"), nd("_1H"))),
							nd(CALL, nd(QNAME, nd("owner"), nd("message")), nd("msg"))
						)),
						nd(CASE, lt("claymore"), nd(BODY, 
							nd(VAR, nd("msg"), nd(QNAME, nd("Hands"), nd("_2H"))),
							nd(CALL, nd(QNAME, nd("owner"), nd("message")), nd("msg"))
						)),
						nd(DEFAULT, nd(BODY, 
							nd(VAR, nd("msg"), nd(QNAME, nd("Hands"), nd("Sheild"))),
							nd(CALL, nd(QNAME, nd("owner"), nd("message")), nd("msg"))
						))
					)
//			}
			)),
//
//			form SampleActor extends Actor{
			nd(FORM_DEF, nd("SampleActor"), nd("Actor"), nd(CONT, 
//				items: list<Item>;
				nd(TYPE_SPEC, nd("items"), nd(LIST_TYPE, nd("Item"))),

//				get0Name : string{
//					result = select(items.get(0)){
//						as (x : Dagger){
//							result = x.type.name;
//						}
//						as (x : Claymore){
//							result = x.type.name;
//						}
//						default {
//							result = "unknown";
//						}
//					};
//				}
				nd(ACCESSOR, nd(TYPE_SPEC, nd("get0Name"), nd("string")), nd(PARAMS), nd(BODY,
					nd(RESULT, nd(SELECT, nd(CALL, nd(QNAME, nd("items"), nd("get")), lt(0)),
						nd(AS, nd(TYPE_SPEC, nd("x"), nd("Dagger")), nd(BODY,
							nd(VAR, nd("y"), nd("x")),
							nd(RESULT, nd(QNAME, nd(QNAME, nd("y"), nd("type")), nd("name")))
						)),
						nd(AS, nd(TYPE_SPEC, nd("x"), nd("Claymore")), nd(BODY,
							nd(VAR, nd("y"), nd("x")),
							nd(RESULT, nd(QNAME, nd(QNAME, nd("y"), nd("type")), nd("name")))
						)),
						nd(DEFAULT, nd(BODY,
							nd(VAR, nd("x"), lt("unknown")),
							nd(RESULT, nd("x"))
						))
					))
				)),
//
//				alter selection(owners : list<Actor>){
				nd(ALTER, nd("selection"), nd(TYPE_SPEC, nd("owners"), nd(LIST_TYPE, nd("Actor"))), nd(BODY,
//					owners.forEach(@(owner : Actor, index : integer){
					nd(CALL, nd(QNAME, nd("owners"), nd("forEach")), nd(LAMBDA, nd(PARAMS,
							nd(TYPE_SPEC, nd("owner"), nd("Actor")),
							nd(TYPE_SPEC, nd("index"), nd("integer"))),
						nd(BODY,
//						select(items.get(index)){
//							as (x : Dagger){
//								owner.message(x.type.name);
//								owner.equip(x);
//							}
//							as (x : Claymore){
//								owner.message(x.type.name);
//								owner.equip(x);
//							}
//							default {
//								owner.message("unknown");
//							}
//						}
						nd(SELECT, nd(CALL, nd(QNAME, nd("items"), nd("get")), nd("index")),
							nd(AS, nd(TYPE_SPEC, nd("x"), nd("Dagger")), nd(BODY,
								nd(VAR, nd("y"), nd("x")),
								nd(CALL, nd(QNAME, nd("owner"), nd("message")), nd(QNAME, nd(QNAME, nd("y"), nd("type")), nd("name"))),
								nd(CALL, nd(QNAME, nd("owner"), nd("equip")), nd("y"))
							)),
							nd(AS, nd(TYPE_SPEC, nd("x"), nd("Claymore")), nd(BODY,
								nd(VAR, nd("y"), nd("x")),
								nd(CALL, nd(QNAME, nd("owner"), nd("message")), nd(QNAME, nd(QNAME, nd("y"), nd("type")), nd("name"))),
								nd(CALL, nd(QNAME, nd("owner"), nd("equip")), nd("y"))
							)),
							nd(DEFAULT, nd(BODY,
								nd(VAR, nd("x"), lt("unknown")),
								nd(CALL, nd(QNAME, nd("owner"), nd("message")), nd("x"))
							))
						)
//					});
					))//@
//				}
				)//owners.forEach()
//			}
			))))//selection
		);
		
		testIgnoreLocator(expectedTree, srcPath);
	}

	@Test
	public void testHelloWorldWithLineNumber()throws IOException {
		URL src = dir.getParent().resolve("HelloWorld.lore").toUri().toURL();
		
		AST expectedTree =
			node(ROOT, loc(src, 0), 
					
//			docinfo{encoding="UTF-8", version="http://xgmtk.org/lore/1.0":url}
			node(DOCINFO, loc(src, 1),
				node(ENCODING, loc(src, 1),
					lt("UTF-8", loc(src, 1))),
				node(VERSION, loc(src, 1),
					lt(new URL("http://xgmtk.org/lore/1.0"), loc(src, 1)))),

//			desc("Hello World"){[=["Hello World"
//			Hello Worldを表示するだけのサンプル。
//			]=]}
			node(DESC, loc(src, 2),
				lt("Hello World", loc(src, 2)),
				lt("\"Hello World\""+NEWLINE+"Hello Worldを表示するだけのサンプル。"+NEWLINE, loc(src, 2))),
				
//			author("椎路 ちひろ"){'mailto:develop@xgmtk.org':url}
			node(AUTHOR, loc(src, 3),
				lt("椎路 ちひろ", loc(src, 3)),
				lt(new URL("mailto:develop@xgmtk.org"), loc(src, 3))),

//			import "basic.lore":url;
			node(IMPORT, loc(src, 6),
				lt(dir.getParent().resolve("basic.lore").toUri().toURL(), loc(src, 6))),

//			section hello.world{
			node(SECTION, loc(src, 8),
				node(QNAME, loc(src, 8), 
					id("hello", loc(src, 8)),
					id("world", loc(src, 8))),

//				first = {
//					ticks = 0;
//					priority = 0;
//					handler=@{main;};
//				}:Event;
				node(VAR,loc(src, 13), 
					id("first", loc(src, 13)),
					node(FORM_VAL, loc(src, 13), 
						node(CONT,loc(src, 13),
							node(VAR, loc(src, 14), 
								id("ticks", loc(src, 14)),
								lt(0, loc(src, 14))),
							node(VAR, loc(src, 15), 
								id("priority", loc(src, 15)),
								lt(0, loc(src, 15))),
							node(VAR, loc(src, 16), 
									id("handler", loc(src, 16)),
									node(LAMBDA, loc(src, 16),
										node(PARAMS, loc(src, 16)),
										node(BODY, loc(src, 16), 
											id("main", loc(src, 16)))))
						),
						id("Event", loc(src, 17)))),
						
//				rule main{
//					GM.message("Hello world!");
//				}
				node(RULE, loc(src, 23),
					id("main", loc(src, 23)),
					node(PARAMS, loc(src, 23)),
					node(BODY, loc(src, 23), 
						node(CALL, loc(src, 25),
						node(QNAME, loc(src, 25), id("GM", loc(src, 25)), id("message",loc(src, 25))),
						lt("Hello world!", loc(src, 25))))
					)
				
			)//section
			
			);//root
		
		/*
		 * TODO correct the line number handling.
		 */
		testIgnoreLocator(expectedTree, src);
//		testExactly(expectedTree, srcPath);
	}
}
