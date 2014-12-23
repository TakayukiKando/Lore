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
package org.xgmtk.lore.ast;

import java.util.Optional;

/**
 * 
 * @author kando
 *
 */
public enum NonTerminalSymbol {
	ROOT("$lore"),
	
	//headers
	DOCINFO("docinfo"),
	ENCODING("encoding"),
	VERSION("version"),
	DESC("desc"),
	AUTHOR("author"),
	HISTORY("history"),

	IMPORT("import"),

	//select
	SELECT("select"),
	AS("as"),
	CASE("case"),
	DEFAULT("default"),

	
	//variable and name
	ID("$id"),
	QNAME("."),
	VAR("="),
	TYPE_SPEC(":"),
	PARAMS("$params"),
	LITERAL("$lit"),
	
	//Arithmetic operators
	PLUS("+"),
	MINUS("-"),
	MULT("*"),
	DIV("/"),
	MOD("%"),
	NEGATE("$negate"),
	
	//Compare operators
	EQ("=="),
	NEQ("!="),
	LT("<"),
	GT(">"),
	LE("<="),
	GE(">="),

	//Logical operators
	NOT("!"),
	AND("&"),
	OR("|"),

	//section
	SECTION("section"),
	
	//enum
	ENUM_DEF("enum"),
	ENUM_VAL("$enum"),
	
	//unit
	UNIT_DEF("$="),
	UNIT_TYPE("unit"),
	UNIT_VAL("$unit"),
	
	//dice
	DICE("D"),
	
	//range
	RANGE_TYPE("range"),
	RANGE_OP_EE(",...,"),
	RANGE_OP_EL(",...<"),
	RANGE_OP_LE("<...,"),
	RANGE_OP_LL("<...<"),

	//list
	LIST_TYPE("list"),
	LIST_VAL("$list"),
	
	//form
	FORM_DEF("form"),
	CONT("$cont"),
	FORM_VAL("$form"),
	PRIVATE("private"),
	OVERRIDE("override"),

	//procedures and functions
	CALL("$call"),
	RULE("rule"),
	FUNCTION("function"),
	ALTER("alter"),
	ACCESSOR("$accessor"),
	LAMBDA("@"),
	LAMBDA_TYPE("@<>"),
	BODY("$body"),
	SELF("self"),
	RESULT("result"),
	MODIFY("$modify");
	
	public final String symbol;
	
	NonTerminalSymbol(String symbol){
		this.symbol = symbol;
	}
	
	public String getSymbolString(){
		return this.symbol;
	}
	
	/**
	 * 
	 * @param symbol
	 * @return The return value is null, if could not found the specified one.
	 */
	public static Optional<NonTerminalSymbol> getSymbol(String symbol){
		for(NonTerminalSymbol sym : NonTerminalSymbol.values()){
			if(sym.getSymbolString().equals(symbol)){
				return Optional.of(sym);
			}
		}
		return Optional.empty();
	}
}
