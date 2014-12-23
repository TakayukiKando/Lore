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
package org.xgmtk.lore.symbols.test;

import static org.junit.Assert.assertThat;
import static org.xgmtk.lore.symbols.test.ScopeMatchers.equalScope;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.xgmtk.lore.ast.scanner.UnexpectedLiteralTypeException;
import org.xgmtk.lore.symbols.Access;
import org.xgmtk.lore.symbols.BaseScope;
import org.xgmtk.lore.symbols.EnumDef;
import org.xgmtk.lore.symbols.EnumValContent;
import org.xgmtk.lore.symbols.FormValContent;
import org.xgmtk.lore.symbols.GlobalScope;
import org.xgmtk.lore.symbols.LambdaScope;
import org.xgmtk.lore.symbols.ProcScope;
import org.xgmtk.lore.symbols.ProcStyle;
import org.xgmtk.lore.symbols.Scope;
import org.xgmtk.lore.symbols.Scope.AlreadyDefinedSymbolException;
import org.xgmtk.lore.symbols.FormDef;
import org.xgmtk.lore.symbols.ScopeBuilder;
import org.xgmtk.lore.symbols.Section;
import org.xgmtk.lore.symbols.Symbol;
import org.xgmtk.lore.symbols.VariableSymbol;
import org.xgmtk.lore.symbols.builtin.UnitType;
import org.xgmtk.lore.utils.SystemErrorHandler;

public class TestScopeBuilder {
	private static Path wdir;
	private static Path dir;
	private static Path testdir;
	private static final String clsName = TestScopeBuilder.class.getSimpleName();
	
	@BeforeClass
	public static void setupStatic(){
		wdir = Paths.get(System.getProperty("user.dir"));
		dir = wdir.resolve(Paths.get("sample", "forParser"));
		testdir = wdir.resolve(Paths.get("test", clsName));
	}

	@Rule
	public TestName name = new TestName();
	
	private String methodName;
	private Logger logger;
	private URL src;
	private ScopeBuilder builder;
	private GlobalScope expected;
	
	@Before
	public void setup() throws IOException{
		this.methodName = name.getMethodName();
		this.logger = Logger.getLogger(clsName+"_"+this.methodName+"_log");
		this.logger.addHandler(new SystemErrorHandler());
		this.logger.setLevel(Level.ALL);
		expected = new GlobalScope();
		//dumpTree(methodName+".expected.initial", expected);
	}

	public void dumpTree(String name, Scope scope) throws IOException {
		try(PrintWriter prn = new PrintWriter(new FileWriter(testdir.resolve(clsName+"."+name+".txt").toFile()))){
			dumpTree(name, scope, prn);
		}
		//prn.close();
	}
	
	public void dumpTree(String name, Scope scope, PrintWriter prn) {
		prn.println("*** "+name);
		scope.dump(prn);
		prn.flush();
	}

	public static void define(Scope scope, Symbol symbol){
		try {
			scope.define(symbol);
		} catch (AlreadyDefinedSymbolException e) {
			System.err.println("unexpected error:");
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}
	}

	public static void defVar(Scope scope, String prefix, int begin, int end) {
		IntStream.range(begin, end).forEach(i->define(scope, new VariableSymbol(prefix+i)));
	}
	
	public static void defVar(Scope scope, String...names){
		defVar(scope, Access.PUBLIC, names);
	}
	
	public static void defVar(Scope scope, Access access, String...names) {
		Arrays.stream(names).forEach(name->define(scope, new VariableSymbol(name, access)));
	}

	public static FormDef defForm(Scope scope, Access access, String formName, List<String> baseTypeName) throws AlreadyDefinedSymbolException{
		FormDef formDef = new FormDef(formName, access);
		scope.define(formDef);
		if(baseTypeName != null){
			formDef.setParentTypeQName(baseTypeName);
		}
		return formDef;
	}

	public static FormDef defForm(Scope scope, String formName, List<String> baseTypeName) throws AlreadyDefinedSymbolException{
		return defForm(scope, Access.PUBLIC, formName, baseTypeName);
	}
	
	public void defStructValAndVar(Scope scope, String varName, FormValFiller... fillers) {
		define(scope, new VariableSymbol(varName));
		for(FormValFiller filler : fillers){
			putFormValScope(scope, filler);
		}
	}

	@FunctionalInterface
	public interface FormValFiller{
		/**
		 * 
		 * @param formValScope
		 * @return parentTypeQName, 
		 */
		public List<String> fill(FormValContent formValScope);
	}
	
	public void putFormValScope(Scope scope, FormValFiller filler) {
		try {
			FormValContent valScope = new FormValContent();
			List<String> parentTypeQName = filler.fill(valScope);
			scope.put(valScope);
			FormDef formDef = valScope.createAnonymousTypeDefinition(expected.createAnonymousTypeName());
			if(parentTypeQName !=null){
				formDef.setParentTypeQName(parentTypeQName);
			}
			expected.addAnonymousType(formDef);
		} catch (AlreadyDefinedSymbolException e) {
			throw new IllegalStateException("Unexpected internal error.", e);
		}
		
	}

	public static void defEnum(Scope scope, String enumName, ScopeFiller filler, String... names) {
		EnumDef enumDef = new EnumDef(enumName);
		define(scope, enumDef);
		for(String name : names){
			try {
				EnumValContent enumVal = new EnumValContent(name);
				enumDef.define(enumVal);
				enumVal.setType(enumDef);
				filler.fill(enumVal);
			} catch (AlreadyDefinedSymbolException e) {
				throw new IllegalStateException("Unexpected internal error.", e);
			}
		}
		filler.fill(enumDef);
	}

	@FunctionalInterface
	public interface ScopeFiller{
		/**
		 * 
		 * @param formValScope
		 * @return parentTypeQName, 
		 */
		public void fill(Scope val);
	}
	
	/**
	 * 
	 * @param scope
	 * @param access
	 * @param style
	 * @param funName
	 * @param paramNames
	 * @return Scope of procedure body.
	 * @throws AlreadyDefinedSymbolException
	 */
	public static Scope defProc(Scope scope, Access access, ProcStyle style, String funName, String...paramNames) throws AlreadyDefinedSymbolException {
		ProcScope proc = new ProcScope(funName, access, style);
		scope.define(proc);
		for(String paramName : paramNames){
			proc.define(new VariableSymbol(paramName));
		}
		BaseScope body = new BaseScope();
		proc.put(body);
		return body;
	}
	
	/**
	 * 
	 * @param scope
	 * @param style
	 * @param funName
	 * @param paramNames
	 * @return
	 * @throws AlreadyDefinedSymbolException
	 */
	public static Scope defProc(Scope scope, ProcStyle style, String funName, String...paramNames) throws AlreadyDefinedSymbolException {
		return defProc(scope, Access.PUBLIC, style, funName, paramNames);
	}


	public static void defLambdaAndVar(Scope scope, String varName, ProcStyle procStyle, List<String> params, List<String> localVars) {
		defVar(scope, varName);
		defLambda(scope, procStyle, params, localVars);
	}

	public static Scope defLambda(Scope scope, ProcStyle procStyle, List<String> params, List<String> localVars) {
		try{
			LambdaScope paramsScope = new LambdaScope(procStyle);
			scope.put(paramsScope);
			defVar(paramsScope, params.toArray(new String[0]));
			BaseScope bodyScope = new BaseScope();
			paramsScope.put(bodyScope);
			defVar(bodyScope, localVars.toArray(new String[0]));
			return bodyScope;
		}catch(AlreadyDefinedSymbolException e){
			throw new IllegalStateException("Unexpected internal error.", e);
		}
	}

	
	public <T extends Number> UnitType defUnit(String unitName, T factor, String baseTypeName) throws AlreadyDefinedSymbolException {
		UnitType utype = null;
		if(Long.class.isInstance(factor)){
			utype = new UnitType(unitName, (Long)factor, baseTypeName);
		}else if(Double.class.isInstance(factor)){
			utype = new UnitType(unitName, (Double)factor, baseTypeName);
		}else{
			throw new IllegalArgumentException("Argument \"factor\"'s type should be Long or Double but "+factor.getClass().getName()+".");
		}
		this.expected.define(utype);
		return utype;
	}
	
	public UnitType defUnit(String unitName, Number factor) throws AlreadyDefinedSymbolException {
		return this.defUnit(unitName, factor, null);
	}

	public static Scope defSection(Scope scope, String...namePathElements) throws AlreadyDefinedSymbolException{
		for(String name : namePathElements){
			Section section = new Section(name);
			scope.define(section);
			scope = section;
		}
		return scope;
	}
	
	public static void defType(Scope scope, String...names){
		Arrays.stream(names).forEach(name->define(scope, new VariableSymbol(name)));
	}

	public static Scope defCaseBlock(Scope scope) throws AlreadyDefinedSymbolException {
		return defaultBlock(scope);
	}

	public static Scope defaultBlock(Scope scope)
			throws AlreadyDefinedSymbolException {
		BaseScope block = new BaseScope();
		scope.put(block);
		return block;
	}
	
	public static Scope defAsBlock(Scope scope, String caseParamName) throws AlreadyDefinedSymbolException {
		BaseScope caseParam = new BaseScope();
		defVar(caseParam, caseParamName);
		BaseScope block = new BaseScope();
		caseParam.put(block);
		scope.put(caseParam);
		return block;
	}

	public void testExactly(Scope expectedTree, String src) throws IOException, UnexpectedLiteralTypeException {
		this.src = dir.resolve(src).toUri().toURL();
		this.builder = new ScopeBuilder(this.logger);
		Scope actualTree = null;
		
		try{
			actualTree = this.builder.build(this.src);
		}catch(IllegalStateException e){
			Path scopeTreeLogPath = wdir.resolve(Paths.get("test", "TestScope", clsName+".actual_scope_tree.txt"));
			try(PrintWriter out = new PrintWriter(new FileWriter(scopeTreeLogPath.toFile()))){
				this.builder.getScopeRoot().dump(out);
			}
			throw e;
		}

		dumpTree(methodName+".expected", expectedTree);
		dumpTree(methodName+".actual", actualTree);
		assertThat(actualTree, equalScope(expectedTree));
	}

	public void buildTypesLoreExpectedScope()
			throws AlreadyDefinedSymbolException {
		//imported types.lore
		Scope sectionTypes = defSection(expected, "types");
		
		defUnit("[m]", 1.0);//unit name should register global scope.
		defUnit("[km]", 1000L, "[m]");//unit name should register global scope.
		defUnit("[m/s^2]", 1.0);//unit name should register global scope.
		
		defEnum(sectionTypes, "Action", (v)->defVar(v, "caption"), "search", "move", "sleep");
		
		Scope funMean = defProc(sectionTypes, ProcStyle.FUNCTION, "mean", "elements");
		defVar(funMean, "total"/*, "result"*/);//A result statement is not a variable definition.
		
		Scope ruleSleepAction = defProc(sectionTypes, ProcStyle.RULE, "sleepAction", "pc");
		defStructValAndVar(ruleSleepAction, "period_hour", (formVar)->{
			defVar(formVar, "message", "hour");
			return null;
		});
		defVar(ruleSleepAction, "period");
		putFormValScope(ruleSleepAction, (formVal)->{
			defVar(formVal, "ticks", "priority");
			try {
				defProc(formVal, ProcStyle.RULE, "handle");
			} catch (AlreadyDefinedSymbolException e) {
				throw new IllegalStateException("Unexpected internal error.", e);
			}
			return Arrays.asList("Event");
		});
		
		FormDef formHP = defForm(sectionTypes, "HP", null);
		defVar(formHP, "current", "hp_range");
		defProc(formHP, ProcStyle.ACCESSOR, "live");
		//defVar(accssorLive, "result");//A result statement is not a variable definition.
		defProc(formHP, ProcStyle.ALTER, "damage", "damages");
	
		FormDef formSampleActor = defForm(sectionTypes, "SampleActor", Arrays.asList("Actor"));
		defVar(formSampleActor, "location", "mobility", "image", "description", "hp", "items");
		defEnum(formSampleActor, "MobilityMode", (v)->defVar(v, "factor"), "run", "walk", "crawl");
		defProc(formSampleActor, ProcStyle.ACCESSOR, "speed", "mode");
		//defVar(accssorSpeed, "result");//A result statement is not a variable definition.
		
		defProc(sectionTypes, Access.PRIVATE, ProcStyle.RULE, "addItem", "pc", "item");
		
		FormDef formSample = defForm(sectionTypes, "Sample", null);
		defVar(formSample, Access.PRIVATE, "cstr");
		FormDef formInner = defForm(formSample, Access.PRIVATE, "Inner", null);
		defVar(formInner, "link", "linkInner");
		defVar(formSample, Access.PRIVATE, "inner");
		FormValFiller formValFillerAnnon = (formVal)->{
			defVar(formVal, "key","value");
			return null;
		};
		defStructValAndVar(formSample, "anyonimous", formValFillerAnnon);
		defVar(formSample, "explicit");
		defStructValAndVar(formSample, "anyonimouses", formValFillerAnnon, formValFillerAnnon);
		defVar(formSample, "explicits");
	}

	public void buildExpressionsLoreExpectedScope()
			throws AlreadyDefinedSymbolException {
		//expressions.lore
		defVar(expected, "vInt", 0, 4);
		defVar(expected, "vFloat", 0, 4);
		defVar(expected,"range0_5", "range_1_0_2_5", "range1_10", "range1_0_3_0", "rangeI0_F3");
		defVar(expected, "unit0", "range0", "bool_in_range0_5", "i", "list0", "list_access");
		Scope sectionExp = defSection(expected, "expressions", "sample");
		FormValFiller formValFiller0 = (formVar)->{
			defVar(formVar, "key", "value");
			return null;
		};
		defStructValAndVar(sectionExp, "struct_list_0", formValFiller0, formValFiller0);
		FormValFiller formValFiller1 = (formVar)->{
			defVar(formVar, "key", "value");
			return Arrays.asList("Pair");
		};
		defStructValAndVar(sectionExp, "struct_list_1", formValFiller1, formValFiller1);
		defVar(expected, "boole_key_a_length_positive");
		defVar(expected, "dice", 0, 4);
		defVar(expected, "unit", 1, 3);
		defVar(expected, "input", 0, 6);
		
		buildTypesLoreExpectedScope();
	}

	public void buildLambdaLoreExpectedScope() throws AlreadyDefinedSymbolException {
		defUnit("[enc]", 1.0);
		FormDef formItemSet = defForm(expected, "ItemSet", null);
		defVar(formItemSet, "items", "encCalc");
		defProc(formItemSet, ProcStyle.ACCESSOR, "enc");
		Scope find = defProc(formItemSet, ProcStyle.ACCESSOR, "find", "name");
		defLambda(find, ProcStyle.FUNCTION, Arrays.asList("it"), Arrays.asList());
		
		FormDef formLambdaSample = defForm(expected, "LambdaSample", null);
		defVar(formLambdaSample, "l0", "l1", "l3", "l4", "l5", "l6");

		defLambdaAndVar(expected, "lambda0", ProcStyle.FUNCTION, Arrays.asList("x"), Arrays.asList());
		
		defStructValAndVar(expected, "vLambdas", 
			(formVal)->{
				defLambdaAndVar(formVal, "l0", ProcStyle.FUNCTION, Arrays.asList("x"), Arrays.asList());
				defLambdaAndVar(formVal, "l1", ProcStyle.FUNCTION, Arrays.asList("a", "b"), Arrays.asList());
				defLambdaAndVar(formVal, "l3", ProcStyle.FUNCTION, Arrays.asList(), Arrays.asList());
				defLambdaAndVar(formVal, "l4", ProcStyle.RULE, Arrays.asList("a", "b"), Arrays.asList("c"));
				defLambdaAndVar(formVal, "l5", ProcStyle.RULE, Arrays.asList("x"), Arrays.asList());
				defLambdaAndVar(formVal, "l6", ProcStyle.RULE, Arrays.asList(), Arrays.asList());
				return Arrays.asList("LambdaSample");
			}
		);
		
		buildTypesLoreExpectedScope();		
	}

	public void buildSelectLoreExpectedScope() throws AlreadyDefinedSymbolException {
		defUnit("[enc]", 1.0);
		
		defEnum(expected, "Hands", (scope)->{} , "_1H", "_2H", "Sheild");
		
		Scope funSelection = defProc(expected, ProcStyle.FUNCTION, "selection0", "items", "name");
		defVar(defCaseBlock(funSelection), "a");
		defVar(defCaseBlock(funSelection), "a");
		defVar(defCaseBlock(funSelection), "a");
		
		Scope ruleSelection = defProc(expected, ProcStyle.RULE, "selection1", "owner", "items", "name");
		defVar(defCaseBlock(ruleSelection), "msg");
		defVar(defCaseBlock(ruleSelection), "msg");
		defVar(defCaseBlock(ruleSelection), "msg");
		
		FormDef sampleActorForm = defForm(expected, "SampleActor", Arrays.asList("Actor"));
		
		defVar(sampleActorForm, "items");
		
		Scope get0Name = defProc(sampleActorForm, ProcStyle.ACCESSOR, "get0Name");
		defVar(defAsBlock(get0Name, "x"), "y");
		defVar(defAsBlock(get0Name, "x"), "y");
		defVar(defaultBlock(get0Name), "x");
		
		Scope selection = defProc(sampleActorForm, ProcStyle.ALTER, "selection", "owners");
		Scope inner = defLambda(selection, ProcStyle.RULE, Arrays.asList("owner", "index"), Arrays.asList());
		defVar(defAsBlock(inner, "x"), "y");
		defVar(defAsBlock(inner, "x"), "y");
		defVar(defaultBlock(inner), "x");
		
		buildTypesLoreExpectedScope();
	}

	@Test
	public void testTypesLoreScopes() throws IOException, AlreadyDefinedSymbolException, UnexpectedLiteralTypeException{
		buildTypesLoreExpectedScope();
		testExactly(expected , "types.lore");
	}
	
	@Test
	public void testExpressionsScopes() throws IOException, AlreadyDefinedSymbolException, UnexpectedLiteralTypeException{
		buildExpressionsLoreExpectedScope();
		testExactly(expected , "expressions.lore");
	}
	
	@Test
	public void testLambdaScopes() throws IOException, AlreadyDefinedSymbolException, UnexpectedLiteralTypeException{
		buildLambdaLoreExpectedScope();
		testExactly(expected , "lambda.lore");
	}
	
	@Test
	public void testSelectScopes() throws IOException, AlreadyDefinedSymbolException, UnexpectedLiteralTypeException{
		buildSelectLoreExpectedScope();
		testExactly(expected , "select.lore");
	}
}
