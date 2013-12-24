// Generated from C:\Users\kando\git\Lore\Lore\src\org\xgmtk\lore\parser\Lore.g4 by ANTLR 4.1
package org.xgmtk.lore.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LoreParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__68=1, T__67=2, T__66=3, T__65=4, T__64=5, T__63=6, T__62=7, T__61=8, 
		T__60=9, T__59=10, T__58=11, T__57=12, T__56=13, T__55=14, T__54=15, T__53=16, 
		T__52=17, T__51=18, T__50=19, T__49=20, T__48=21, T__47=22, T__46=23, 
		T__45=24, T__44=25, T__43=26, T__42=27, T__41=28, T__40=29, T__39=30, 
		T__38=31, T__37=32, T__36=33, T__35=34, T__34=35, T__33=36, T__32=37, 
		T__31=38, T__30=39, T__29=40, T__28=41, T__27=42, T__26=43, T__25=44, 
		T__24=45, T__23=46, T__22=47, T__21=48, T__20=49, T__19=50, T__18=51, 
		T__17=52, T__16=53, T__15=54, T__14=55, T__13=56, T__12=57, T__11=58, 
		T__10=59, T__9=60, T__8=61, T__7=62, T__6=63, T__5=64, T__4=65, T__3=66, 
		T__2=67, T__1=68, T__0=69, DICE=70, UNIT_NAME=71, NAME=72, NORMALSTRING=73, 
		CHARSTRING=74, LONGSTRING=75, INT=76, HEX=77, FLOAT=78, HEX_FLOAT=79, 
		COMMENT=80, LINE_COMMENT=81, WS=82, NEWLINE=83;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'self'", "'result'", "'*'", "'<'", "'!='", "'<='", 
		"'range'", "'override'", "'}'", "'url'", "'case'", "'dice'", "'encoding'", 
		"'%'", "')'", "'D'", "'@'", "'unit'", "'='", "'html'", "'desc'", "'reviser'", 
		"'docinfo'", "',...,'", "'version'", "'|'", "'!'", "'real'", "'enum'", 
		"'alter'", "'form'", "'select'", "'default'", "','", "'-'", "'('", "':'", 
		"'jid'", "'<...<'", "'private'", "'?'", "'as'", "'{'", "'section'", "'extends'", 
		"'rule'", "'date'", "'import'", "'function'", "'.'", "'constant'", "'+'", 
		"'list'", "'loc'", "';'", "'history'", "'number'", "'xml'", "'>'", "':='", 
		"'integer'", "',...<'", "'string'", "'author'", "'=='", "'/'", "'>='", 
		"'<...,'", "DICE", "UNIT_NAME", "NAME", "NORMALSTRING", "CHARSTRING", 
		"LONGSTRING", "INT", "HEX", "FLOAT", "HEX_FLOAT", "COMMENT", "LINE_COMMENT", 
		"WS", "NEWLINE"
	};
	public static final int
		RULE_lore = 0, RULE_header = 1, RULE_docinfo = 2, RULE_encoding = 3, RULE_version = 4, 
		RULE_description = 5, RULE_author = 6, RULE_history = 7, RULE_import_other = 8, 
		RULE_section = 9, RULE_private_section_element = 10, RULE_section_element = 11, 
		RULE_qName = 12, RULE_definition = 13, RULE_type_def = 14, RULE_enum_def = 15, 
		RULE_enum_elem = 16, RULE_enum_field = 17, RULE_unit_def = 18, RULE_form_def = 19, 
		RULE_private_member_def = 20, RULE_member_def = 21, RULE_member_initializer = 22, 
		RULE_constant_var_def = 23, RULE_field_decl = 24, RULE_type_expr = 25, 
		RULE_builtin_type_expr = 26, RULE_lambda_type = 27, RULE_list_type = 28, 
		RULE_unit_type = 29, RULE_range_type = 30, RULE_builtin_type = 31, RULE_arithmetic_type = 32, 
		RULE_rule_def = 33, RULE_function_def = 34, RULE_accessor_def = 35, RULE_alter_def = 36, 
		RULE_parameters = 37, RULE_block = 38, RULE_statement = 39, RULE_procedure_apply = 40, 
		RULE_select_statement = 41, RULE_result_statement = 42, RULE_var_def = 43, 
		RULE_field_modify = 44, RULE_expression = 45, RULE_select_expr = 46, RULE_case_block = 47, 
		RULE_as_block = 48, RULE_default_block = 49, RULE_range = 50, RULE_condition = 51, 
		RULE_cond_term = 52, RULE_relation = 53, RULE_cond_monomial = 54, RULE_terms = 55, 
		RULE_term = 56, RULE_factor = 57, RULE_post_op = 58, RULE_monomial = 59, 
		RULE_member_access = 60, RULE_args = 61, RULE_atom = 62, RULE_list_construct = 63, 
		RULE_struct_construct = 64, RULE_lambda = 65, RULE_literal = 66, RULE_html = 67, 
		RULE_xml = 68, RULE_url = 69, RULE_date = 70, RULE_jid = 71, RULE_loc = 72, 
		RULE_stringLiteral = 73, RULE_number = 74;
	public static final String[] ruleNames = {
		"lore", "header", "docinfo", "encoding", "version", "description", "author", 
		"history", "import_other", "section", "private_section_element", "section_element", 
		"qName", "definition", "type_def", "enum_def", "enum_elem", "enum_field", 
		"unit_def", "form_def", "private_member_def", "member_def", "member_initializer", 
		"constant_var_def", "field_decl", "type_expr", "builtin_type_expr", "lambda_type", 
		"list_type", "unit_type", "range_type", "builtin_type", "arithmetic_type", 
		"rule_def", "function_def", "accessor_def", "alter_def", "parameters", 
		"block", "statement", "procedure_apply", "select_statement", "result_statement", 
		"var_def", "field_modify", "expression", "select_expr", "case_block", 
		"as_block", "default_block", "range", "condition", "cond_term", "relation", 
		"cond_monomial", "terms", "term", "factor", "post_op", "monomial", "member_access", 
		"args", "atom", "list_construct", "struct_construct", "lambda", "literal", 
		"html", "xml", "url", "date", "jid", "loc", "stringLiteral", "number"
	};

	@Override
	public String getGrammarFileName() { return "Lore.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public LoreParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LoreContext extends ParserRuleContext {
		public List<Section_elementContext> section_element() {
			return getRuleContexts(Section_elementContext.class);
		}
		public Section_elementContext section_element(int i) {
			return getRuleContext(Section_elementContext.class,i);
		}
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public LoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoreContext lore() throws RecognitionException {
		LoreContext _localctx = new LoreContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lore);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); header();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (30 - 30)) | (1L << (32 - 30)) | (1L << (45 - 30)) | (1L << (47 - 30)) | (1L << (50 - 30)) | (1L << (UNIT_NAME - 30)) | (1L << (NAME - 30)))) != 0)) {
				{
				{
				setState(151); section_element();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public List<Import_otherContext> import_other() {
			return getRuleContexts(Import_otherContext.class);
		}
		public DocinfoContext docinfo() {
			return getRuleContext(DocinfoContext.class,0);
		}
		public HistoryContext history(int i) {
			return getRuleContext(HistoryContext.class,i);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public Import_otherContext import_other(int i) {
			return getRuleContext(Import_otherContext.class,i);
		}
		public List<AuthorContext> author() {
			return getRuleContexts(AuthorContext.class);
		}
		public List<HistoryContext> history() {
			return getRuleContexts(HistoryContext.class);
		}
		public AuthorContext author(int i) {
			return getRuleContext(AuthorContext.class,i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if (_la==24) {
				{
				setState(157); docinfo();
				}
			}

			setState(161);
			_la = _input.LA(1);
			if (_la==22) {
				{
				setState(160); description();
				}
			}

			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==65) {
				{
				{
				setState(163); author();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==57) {
				{
				{
				setState(169); history();
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==49) {
				{
				{
				setState(175); import_other();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DocinfoContext extends ParserRuleContext {
		public VersionContext version() {
			return getRuleContext(VersionContext.class,0);
		}
		public EncodingContext encoding() {
			return getRuleContext(EncodingContext.class,0);
		}
		public DocinfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_docinfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterDocinfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitDocinfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitDocinfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocinfoContext docinfo() throws RecognitionException {
		DocinfoContext _localctx = new DocinfoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_docinfo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(24);
			setState(182); match(44);
			setState(193);
			switch (_input.LA(1)) {
			case 14:
				{
				{
				setState(183); encoding();
				setState(186);
				_la = _input.LA(1);
				if (_la==35) {
					{
					setState(184); match(35);
					setState(185); version();
					}
				}

				}
				}
				break;
			case 26:
				{
				{
				setState(188); version();
				setState(191);
				_la = _input.LA(1);
				if (_la==35) {
					{
					setState(189); match(35);
					setState(190); encoding();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(195); match(10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EncodingContext extends ParserRuleContext {
		public TerminalNode NORMALSTRING() { return getToken(LoreParser.NORMALSTRING, 0); }
		public EncodingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_encoding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterEncoding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitEncoding(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitEncoding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EncodingContext encoding() throws RecognitionException {
		EncodingContext _localctx = new EncodingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_encoding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(14);
			setState(198); match(20);
			setState(199); match(NORMALSTRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VersionContext extends ParserRuleContext {
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public VersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_version; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterVersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitVersion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitVersion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VersionContext version() throws RecognitionException {
		VersionContext _localctx = new VersionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_version);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); match(26);
			setState(202); match(20);
			setState(203); url();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral(int i) {
			return getRuleContext(StringLiteralContext.class,i);
		}
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public List<StringLiteralContext> stringLiteral() {
			return getRuleContexts(StringLiteralContext.class);
		}
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205); match(22);
			setState(206); match(37);
			setState(207); stringLiteral();
			setState(208); match(16);
			setState(209); match(44);
			setState(212);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(210); stringLiteral();
				}
				break;

			case 2:
				{
				setState(211); html();
				}
				break;
			}
			setState(214); match(10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AuthorContext extends ParserRuleContext {
		public List<UrlContext> url() {
			return getRuleContexts(UrlContext.class);
		}
		public JidContext jid(int i) {
			return getRuleContext(JidContext.class,i);
		}
		public UrlContext url(int i) {
			return getRuleContext(UrlContext.class,i);
		}
		public List<JidContext> jid() {
			return getRuleContexts(JidContext.class);
		}
		public TerminalNode NORMALSTRING() { return getToken(LoreParser.NORMALSTRING, 0); }
		public AuthorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_author; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterAuthor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitAuthor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitAuthor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AuthorContext author() throws RecognitionException {
		AuthorContext _localctx = new AuthorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_author);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(65);
			setState(217); match(37);
			setState(218); match(NORMALSTRING);
			setState(219); match(16);
			setState(220); match(44);
			{
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(221); jid();
				}
				break;

			case 2:
				{
				setState(222); url();
				}
				break;
			}
			setState(233);
			_la = _input.LA(1);
			if (_la==35) {
				{
				setState(225); match(35);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (NORMALSTRING - 73)) | (1L << (CHARSTRING - 73)) | (1L << (LONGSTRING - 73)))) != 0)) {
					{
					setState(228);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						setState(226); jid();
						}
						break;

					case 2:
						{
						setState(227); url();
						}
						break;
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
			setState(235); match(10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HistoryContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public TerminalNode NORMALSTRING() { return getToken(LoreParser.NORMALSTRING, 0); }
		public HistoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_history; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterHistory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitHistory(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitHistory(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HistoryContext history() throws RecognitionException {
		HistoryContext _localctx = new HistoryContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_history);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(57);
			setState(238); match(37);
			setState(239); date();
			setState(240); match(16);
			setState(241); match(44);
			setState(242); match(23);
			setState(243); match(20);
			setState(244); match(NORMALSTRING);
			setState(245); match(35);
			setState(246); match(22);
			setState(247); match(20);
			setState(248); stringLiteral();
			setState(249); match(10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Import_otherContext extends ParserRuleContext {
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public Import_otherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_other; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterImport_other(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitImport_other(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitImport_other(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_otherContext import_other() throws RecognitionException {
		Import_otherContext _localctx = new Import_otherContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_import_other);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(49);
			setState(252); url();
			setState(253); match(56);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SectionContext extends ParserRuleContext {
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public List<Section_elementContext> section_element() {
			return getRuleContexts(Section_elementContext.class);
		}
		public Private_section_elementContext private_section_element(int i) {
			return getRuleContext(Private_section_elementContext.class,i);
		}
		public Section_elementContext section_element(int i) {
			return getRuleContext(Section_elementContext.class,i);
		}
		public List<Private_section_elementContext> private_section_element() {
			return getRuleContexts(Private_section_elementContext.class);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255); match(45);
			setState(256); qName();
			setState(257); match(44);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (30 - 30)) | (1L << (32 - 30)) | (1L << (41 - 30)) | (1L << (45 - 30)) | (1L << (47 - 30)) | (1L << (50 - 30)) | (1L << (UNIT_NAME - 30)) | (1L << (NAME - 30)))) != 0)) {
				{
				setState(260);
				switch (_input.LA(1)) {
				case 41:
					{
					setState(258); private_section_element();
					}
					break;
				case 30:
				case 32:
				case 45:
				case 47:
				case 50:
				case UNIT_NAME:
				case NAME:
					{
					setState(259); section_element();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265); match(10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Private_section_elementContext extends ParserRuleContext {
		public Section_elementContext section_element() {
			return getRuleContext(Section_elementContext.class,0);
		}
		public Private_section_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_private_section_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterPrivate_section_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitPrivate_section_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitPrivate_section_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Private_section_elementContext private_section_element() throws RecognitionException {
		Private_section_elementContext _localctx = new Private_section_elementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_private_section_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); match(41);
			setState(268); section_element();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Section_elementContext extends ParserRuleContext {
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public Section_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterSection_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitSection_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitSection_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Section_elementContext section_element() throws RecognitionException {
		Section_elementContext _localctx = new Section_elementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_section_element);
		try {
			setState(272);
			switch (_input.LA(1)) {
			case 45:
				enterOuterAlt(_localctx, 1);
				{
				setState(270); section();
				}
				break;
			case 30:
			case 32:
			case 47:
			case 50:
			case UNIT_NAME:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(271); definition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QNameContext extends ParserRuleContext {
		public TerminalNode NAME(int i) {
			return getToken(LoreParser.NAME, i);
		}
		public List<TerminalNode> NAME() { return getTokens(LoreParser.NAME); }
		public QNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterQName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitQName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitQName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QNameContext qName() throws RecognitionException {
		QNameContext _localctx = new QNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_qName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274); match(NAME);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(275); match(51);
					setState(276); match(NAME);
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public Rule_defContext rule_def() {
			return getRuleContext(Rule_defContext.class,0);
		}
		public Type_defContext type_def() {
			return getRuleContext(Type_defContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_definition);
		try {
			setState(286);
			switch (_input.LA(1)) {
			case 30:
			case 32:
			case UNIT_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(282); type_def();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(283); var_def();
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 3);
				{
				setState(284); function_def();
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 4);
				{
				setState(285); rule_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_defContext extends ParserRuleContext {
		public Form_defContext form_def() {
			return getRuleContext(Form_defContext.class,0);
		}
		public Enum_defContext enum_def() {
			return getRuleContext(Enum_defContext.class,0);
		}
		public Unit_defContext unit_def() {
			return getRuleContext(Unit_defContext.class,0);
		}
		public Type_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterType_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitType_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitType_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_defContext type_def() throws RecognitionException {
		Type_defContext _localctx = new Type_defContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type_def);
		try {
			setState(291);
			switch (_input.LA(1)) {
			case 30:
				enterOuterAlt(_localctx, 1);
				{
				setState(288); enum_def();
				}
				break;
			case UNIT_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(289); unit_def();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 3);
				{
				setState(290); form_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Enum_defContext extends ParserRuleContext {
		public List<Enum_elemContext> enum_elem() {
			return getRuleContexts(Enum_elemContext.class);
		}
		public Enum_elemContext enum_elem(int i) {
			return getRuleContext(Enum_elemContext.class,i);
		}
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public Enum_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterEnum_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitEnum_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitEnum_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enum_defContext enum_def() throws RecognitionException {
		Enum_defContext _localctx = new Enum_defContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_enum_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); match(30);
			setState(294); match(NAME);
			setState(297);
			_la = _input.LA(1);
			if (_la==46) {
				{
				setState(295); match(46);
				setState(296); qName();
				}
			}

			setState(299); match(44);
			setState(301); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(300); enum_elem();
				}
				}
				setState(303); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
			setState(305); match(10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Enum_elemContext extends ParserRuleContext {
		public Enum_fieldContext enum_field() {
			return getRuleContext(Enum_fieldContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public Enum_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_elem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterEnum_elem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitEnum_elem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitEnum_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enum_elemContext enum_elem() throws RecognitionException {
		Enum_elemContext _localctx = new Enum_elemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_enum_elem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); match(NAME);
			setState(319);
			switch (_input.LA(1)) {
			case 44:
				{
				{
				setState(308); match(44);
				setState(309); enum_field();
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(310); enum_field();
					}
					}
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(316); match(10);
				}
				}
				break;
			case 56:
				{
				setState(318); match(56);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Enum_fieldContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public Enum_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterEnum_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitEnum_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitEnum_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enum_fieldContext enum_field() throws RecognitionException {
		Enum_fieldContext _localctx = new Enum_fieldContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_enum_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321); match(NAME);
			setState(322); match(20);
			setState(323); expression();
			setState(324); match(56);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unit_defContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public List<TerminalNode> UNIT_NAME() { return getTokens(LoreParser.UNIT_NAME); }
		public TerminalNode UNIT_NAME(int i) {
			return getToken(LoreParser.UNIT_NAME, i);
		}
		public Unit_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterUnit_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitUnit_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitUnit_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unit_defContext unit_def() throws RecognitionException {
		Unit_defContext _localctx = new Unit_defContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_unit_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); match(UNIT_NAME);
			setState(327); match(20);
			setState(328); number();
			setState(330);
			_la = _input.LA(1);
			if (_la==UNIT_NAME) {
				{
				setState(329); match(UNIT_NAME);
				}
			}

			setState(332); match(56);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Form_defContext extends ParserRuleContext {
		public List<Member_defContext> member_def() {
			return getRuleContexts(Member_defContext.class);
		}
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public Member_defContext member_def(int i) {
			return getRuleContext(Member_defContext.class,i);
		}
		public Private_member_defContext private_member_def(int i) {
			return getRuleContext(Private_member_defContext.class,i);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public List<Private_member_defContext> private_member_def() {
			return getRuleContexts(Private_member_defContext.class);
		}
		public Form_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterForm_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitForm_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitForm_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Form_defContext form_def() throws RecognitionException {
		Form_defContext _localctx = new Form_defContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_form_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334); match(32);
			setState(335); match(NAME);
			setState(338);
			_la = _input.LA(1);
			if (_la==46) {
				{
				setState(336); match(46);
				setState(337); qName();
				}
			}

			setState(340); match(44);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (30 - 9)) | (1L << (31 - 9)) | (1L << (32 - 9)) | (1L << (41 - 9)) | (1L << (47 - 9)) | (1L << (50 - 9)) | (1L << (52 - 9)) | (1L << (UNIT_NAME - 9)) | (1L << (NAME - 9)))) != 0)) {
				{
				setState(343);
				switch (_input.LA(1)) {
				case 41:
					{
					setState(341); private_member_def();
					}
					break;
				case 9:
				case 30:
				case 31:
				case 32:
				case 47:
				case 50:
				case 52:
				case UNIT_NAME:
				case NAME:
					{
					setState(342); member_def();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(348); match(10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Private_member_defContext extends ParserRuleContext {
		public Member_defContext member_def() {
			return getRuleContext(Member_defContext.class,0);
		}
		public Private_member_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_private_member_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterPrivate_member_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitPrivate_member_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitPrivate_member_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Private_member_defContext private_member_def() throws RecognitionException {
		Private_member_defContext _localctx = new Private_member_defContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_private_member_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350); match(41);
			setState(351); member_def();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_defContext extends ParserRuleContext {
		public Member_initializerContext member_initializer() {
			return getRuleContext(Member_initializerContext.class,0);
		}
		public Field_declContext field_decl() {
			return getRuleContext(Field_declContext.class,0);
		}
		public Type_defContext type_def() {
			return getRuleContext(Type_defContext.class,0);
		}
		public Member_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterMember_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitMember_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitMember_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_defContext member_def() throws RecognitionException {
		Member_defContext _localctx = new Member_defContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_member_def);
		try {
			setState(356);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(353); field_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(354); type_def();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(355); member_initializer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_initializerContext extends ParserRuleContext {
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public Alter_defContext alter_def() {
			return getRuleContext(Alter_defContext.class,0);
		}
		public Accessor_defContext accessor_def() {
			return getRuleContext(Accessor_defContext.class,0);
		}
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public Rule_defContext rule_def() {
			return getRuleContext(Rule_defContext.class,0);
		}
		public Constant_var_defContext constant_var_def() {
			return getRuleContext(Constant_var_defContext.class,0);
		}
		public Member_initializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterMember_initializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitMember_initializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitMember_initializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_initializerContext member_initializer() throws RecognitionException {
		Member_initializerContext _localctx = new Member_initializerContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_member_initializer);
		int _la;
		try {
			setState(373);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(358); constant_var_def();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(359); var_def();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(361);
				_la = _input.LA(1);
				if (_la==9) {
					{
					setState(360); match(9);
					}
				}

				setState(363); accessor_def();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(365);
				_la = _input.LA(1);
				if (_la==9) {
					{
					setState(364); match(9);
					}
				}

				setState(367); alter_def();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(369);
				_la = _input.LA(1);
				if (_la==9) {
					{
					setState(368); match(9);
					}
				}

				setState(371); rule_def();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(372); function_def();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constant_var_defContext extends ParserRuleContext {
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public Constant_var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_var_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterConstant_var_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitConstant_var_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitConstant_var_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant_var_defContext constant_var_def() throws RecognitionException {
		Constant_var_defContext _localctx = new Constant_var_defContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constant_var_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375); match(52);
			setState(376); var_def();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_declContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public Field_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterField_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitField_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitField_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_declContext field_decl() throws RecognitionException {
		Field_declContext _localctx = new Field_declContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_field_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378); match(NAME);
			setState(379); match(38);
			setState(380); type_expr();
			setState(381); match(56);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_exprContext extends ParserRuleContext {
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public Builtin_type_exprContext builtin_type_expr() {
			return getRuleContext(Builtin_type_exprContext.class,0);
		}
		public Type_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterType_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitType_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitType_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_exprContext type_expr() throws RecognitionException {
		Type_exprContext _localctx = new Type_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_type_expr);
		try {
			setState(385);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(383); qName();
				}
				break;
			case 8:
			case 11:
			case 13:
			case 18:
			case 19:
			case 21:
			case 29:
			case 39:
			case 48:
			case 54:
			case 55:
			case 58:
			case 59:
			case 62:
			case 64:
				enterOuterAlt(_localctx, 2);
				{
				setState(384); builtin_type_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Builtin_type_exprContext extends ParserRuleContext {
		public Builtin_typeContext builtin_type() {
			return getRuleContext(Builtin_typeContext.class,0);
		}
		public Unit_typeContext unit_type() {
			return getRuleContext(Unit_typeContext.class,0);
		}
		public List_typeContext list_type() {
			return getRuleContext(List_typeContext.class,0);
		}
		public Lambda_typeContext lambda_type() {
			return getRuleContext(Lambda_typeContext.class,0);
		}
		public Range_typeContext range_type() {
			return getRuleContext(Range_typeContext.class,0);
		}
		public Builtin_type_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_type_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterBuiltin_type_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitBuiltin_type_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitBuiltin_type_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Builtin_type_exprContext builtin_type_expr() throws RecognitionException {
		Builtin_type_exprContext _localctx = new Builtin_type_exprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_builtin_type_expr);
		try {
			setState(392);
			switch (_input.LA(1)) {
			case 11:
			case 13:
			case 21:
			case 29:
			case 39:
			case 48:
			case 55:
			case 58:
			case 59:
			case 62:
			case 64:
				enterOuterAlt(_localctx, 1);
				{
				setState(387); builtin_type();
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 2);
				{
				setState(388); list_type();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 3);
				{
				setState(389); unit_type();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 4);
				{
				setState(390); range_type();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 5);
				{
				setState(391); lambda_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lambda_typeContext extends ParserRuleContext {
		public List<Type_exprContext> type_expr() {
			return getRuleContexts(Type_exprContext.class);
		}
		public Type_exprContext type_expr(int i) {
			return getRuleContext(Type_exprContext.class,i);
		}
		public Lambda_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_typeContext lambda_type() throws RecognitionException {
		Lambda_typeContext _localctx = new Lambda_typeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_lambda_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394); match(18);
			setState(395); match(5);
			setState(407);
			_la = _input.LA(1);
			if (_la==37) {
				{
				setState(396); match(37);
				setState(397); type_expr();
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==35) {
					{
					{
					setState(398); match(35);
					setState(399); type_expr();
					}
					}
					setState(404);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(405); match(16);
				}
			}

			setState(411);
			_la = _input.LA(1);
			if (_la==38) {
				{
				setState(409); match(38);
				setState(410); type_expr();
				}
			}

			setState(413); match(60);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_typeContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public Builtin_typeContext builtin_type() {
			return getRuleContext(Builtin_typeContext.class,0);
		}
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public List_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterList_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitList_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitList_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_typeContext list_type() throws RecognitionException {
		List_typeContext _localctx = new List_typeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_list_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415); match(54);
			setState(416); match(5);
			setState(426);
			switch (_input.LA(1)) {
			case 8:
			case 11:
			case 13:
			case 18:
			case 19:
			case 21:
			case 29:
			case 39:
			case 48:
			case 54:
			case 55:
			case 58:
			case 59:
			case 62:
			case 64:
			case NAME:
				{
				setState(417); type_expr();
				}
				break;
			case 42:
				{
				{
				setState(418); match(42);
				setState(424);
				_la = _input.LA(1);
				if (_la==46) {
					{
					setState(419); match(46);
					setState(422);
					switch (_input.LA(1)) {
					case NAME:
						{
						setState(420); qName();
						}
						break;
					case 11:
					case 13:
					case 21:
					case 29:
					case 39:
					case 48:
					case 55:
					case 58:
					case 59:
					case 62:
					case 64:
						{
						setState(421); builtin_type();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(428); match(60);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unit_typeContext extends ParserRuleContext {
		public TerminalNode UNIT_NAME() { return getToken(LoreParser.UNIT_NAME, 0); }
		public Unit_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterUnit_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitUnit_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitUnit_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unit_typeContext unit_type() throws RecognitionException {
		Unit_typeContext _localctx = new Unit_typeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unit_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430); match(19);
			setState(431); match(UNIT_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Range_typeContext extends ParserRuleContext {
		public Arithmetic_typeContext arithmetic_type() {
			return getRuleContext(Arithmetic_typeContext.class,0);
		}
		public Range_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterRange_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitRange_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitRange_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Range_typeContext range_type() throws RecognitionException {
		Range_typeContext _localctx = new Range_typeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_range_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433); match(8);
			setState(434); match(5);
			setState(435); arithmetic_type();
			setState(436); match(60);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Builtin_typeContext extends ParserRuleContext {
		public Arithmetic_typeContext arithmetic_type() {
			return getRuleContext(Arithmetic_typeContext.class,0);
		}
		public Builtin_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterBuiltin_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitBuiltin_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitBuiltin_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Builtin_typeContext builtin_type() throws RecognitionException {
		Builtin_typeContext _localctx = new Builtin_typeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_builtin_type);
		try {
			setState(447);
			switch (_input.LA(1)) {
			case 29:
			case 58:
			case 62:
				enterOuterAlt(_localctx, 1);
				{
				setState(438); arithmetic_type();
				}
				break;
			case 64:
				enterOuterAlt(_localctx, 2);
				{
				setState(439); match(64);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 3);
				{
				setState(440); match(11);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 4);
				{
				setState(441); match(39);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 5);
				{
				setState(442); match(21);
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 6);
				{
				setState(443); match(59);
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 7);
				{
				setState(444); match(48);
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 8);
				{
				setState(445); match(55);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 9);
				{
				setState(446); match(13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arithmetic_typeContext extends ParserRuleContext {
		public Arithmetic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterArithmetic_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitArithmetic_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitArithmetic_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithmetic_typeContext arithmetic_type() throws RecognitionException {
		Arithmetic_typeContext _localctx = new Arithmetic_typeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_arithmetic_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 29) | (1L << 58) | (1L << 62))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rule_defContext extends ParserRuleContext {
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Rule_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterRule_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitRule_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitRule_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule_defContext rule_def() throws RecognitionException {
		Rule_defContext _localctx = new Rule_defContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_rule_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451); match(47);
			setState(452); match(NAME);
			setState(454);
			_la = _input.LA(1);
			if (_la==37) {
				{
				setState(453); parameters();
				}
			}

			setState(456); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_defContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Function_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterFunction_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitFunction_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitFunction_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_defContext function_def() throws RecognitionException {
		Function_defContext _localctx = new Function_defContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_function_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458); match(50);
			setState(459); match(NAME);
			setState(461);
			_la = _input.LA(1);
			if (_la==37) {
				{
				setState(460); parameters();
				}
			}

			setState(463); match(38);
			setState(464); type_expr();
			setState(465); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Accessor_defContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Accessor_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessor_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterAccessor_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitAccessor_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitAccessor_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Accessor_defContext accessor_def() throws RecognitionException {
		Accessor_defContext _localctx = new Accessor_defContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_accessor_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467); match(NAME);
			setState(469);
			_la = _input.LA(1);
			if (_la==37) {
				{
				setState(468); parameters();
				}
			}

			setState(471); match(38);
			setState(472); type_expr();
			setState(473); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_defContext extends ParserRuleContext {
		public TerminalNode NAME(int i) {
			return getToken(LoreParser.NAME, i);
		}
		public List_typeContext list_type() {
			return getRuleContext(List_typeContext.class,0);
		}
		public List<TerminalNode> NAME() { return getTokens(LoreParser.NAME); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Alter_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterAlter_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitAlter_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitAlter_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alter_defContext alter_def() throws RecognitionException {
		Alter_defContext _localctx = new Alter_defContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_alter_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475); match(31);
			setState(476); match(NAME);
			setState(477); match(37);
			setState(478); match(NAME);
			setState(479); match(38);
			setState(480); list_type();
			setState(481); match(16);
			setState(482); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<Type_exprContext> type_expr() {
			return getRuleContexts(Type_exprContext.class);
		}
		public TerminalNode NAME(int i) {
			return getToken(LoreParser.NAME, i);
		}
		public Type_exprContext type_expr(int i) {
			return getRuleContext(Type_exprContext.class,i);
		}
		public List<TerminalNode> NAME() { return getTokens(LoreParser.NAME); }
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(484); match(37);
			setState(485); match(NAME);
			setState(486); match(38);
			setState(487); type_expr();
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==35) {
				{
				{
				setState(488); match(35);
				setState(489); match(NAME);
				setState(490); match(38);
				setState(491); type_expr();
				}
				}
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(497); match(16);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499); match(44);
			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 8) | (1L << 11) | (1L << 13) | (1L << 18) | (1L << 19) | (1L << 21) | (1L << 29) | (1L << 30) | (1L << 32) | (1L << 33) | (1L << 37) | (1L << 39) | (1L << 44) | (1L << 48) | (1L << 50) | (1L << 54) | (1L << 55) | (1L << 58) | (1L << 59) | (1L << 62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (UNIT_NAME - 64)) | (1L << (NAME - 64)) | (1L << (NORMALSTRING - 64)) | (1L << (CHARSTRING - 64)) | (1L << (LONGSTRING - 64)) | (1L << (INT - 64)) | (1L << (HEX - 64)) | (1L << (FLOAT - 64)) | (1L << (HEX_FLOAT - 64)))) != 0)) {
				{
				{
				setState(500); statement();
				}
				}
				setState(505);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(506); match(10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Field_modifyContext field_modify() {
			return getRuleContext(Field_modifyContext.class,0);
		}
		public Procedure_applyContext procedure_apply() {
			return getRuleContext(Procedure_applyContext.class,0);
		}
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public Result_statementContext result_statement() {
			return getRuleContext(Result_statementContext.class,0);
		}
		public Select_statementContext select_statement() {
			return getRuleContext(Select_statementContext.class,0);
		}
		public Type_defContext type_def() {
			return getRuleContext(Type_defContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_statement);
		try {
			setState(515);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(508); var_def();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(509); field_modify();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(510); function_def();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(511); type_def();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(512); procedure_apply();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(513); select_statement();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(514); result_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Procedure_applyContext extends ParserRuleContext {
		public MonomialContext monomial() {
			return getRuleContext(MonomialContext.class,0);
		}
		public Procedure_applyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure_apply; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterProcedure_apply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitProcedure_apply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitProcedure_apply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Procedure_applyContext procedure_apply() throws RecognitionException {
		Procedure_applyContext _localctx = new Procedure_applyContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_procedure_apply);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517); monomial();
			setState(518); match(56);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_statementContext extends ParserRuleContext {
		public Select_exprContext select_expr() {
			return getRuleContext(Select_exprContext.class,0);
		}
		public Select_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterSelect_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitSelect_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitSelect_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_statementContext select_statement() throws RecognitionException {
		Select_statementContext _localctx = new Select_statementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_select_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520); select_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Result_statementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Result_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterResult_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitResult_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitResult_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Result_statementContext result_statement() throws RecognitionException {
		Result_statementContext _localctx = new Result_statementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_result_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522); match(3);
			setState(523); match(20);
			setState(525);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 8) | (1L << 11) | (1L << 13) | (1L << 18) | (1L << 19) | (1L << 21) | (1L << 28) | (1L << 29) | (1L << 33) | (1L << 36) | (1L << 37) | (1L << 39) | (1L << 44) | (1L << 48) | (1L << 54) | (1L << 55) | (1L << 58) | (1L << 59) | (1L << 62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (64 - 64)) | (1L << (DICE - 64)) | (1L << (NAME - 64)) | (1L << (NORMALSTRING - 64)) | (1L << (CHARSTRING - 64)) | (1L << (LONGSTRING - 64)) | (1L << (INT - 64)) | (1L << (HEX - 64)) | (1L << (FLOAT - 64)) | (1L << (HEX_FLOAT - 64)))) != 0)) {
				{
				setState(524); expression();
				}
			}

			setState(527); match(56);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_defContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public Var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterVar_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitVar_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitVar_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_defContext var_def() throws RecognitionException {
		Var_defContext _localctx = new Var_defContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_var_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529); match(NAME);
			setState(530); match(20);
			setState(531); expression();
			setState(532); match(56);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_modifyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public Field_modifyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_modify; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterField_modify(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitField_modify(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitField_modify(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_modifyContext field_modify() throws RecognitionException {
		Field_modifyContext _localctx = new Field_modifyContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_field_modify);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			_la = _input.LA(1);
			if (_la==2) {
				{
				setState(534); match(2);
				setState(535); match(51);
				}
			}

			setState(538); match(NAME);
			setState(539); match(61);
			setState(540); expression();
			setState(541); match(56);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Select_exprContext select_expr() {
			return getRuleContext(Select_exprContext.class,0);
		}
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_expression);
		try {
			setState(548);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(543); terms();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(544); range();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(545); condition();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(546); select_expr();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(547); lambda();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_exprContext extends ParserRuleContext {
		public List<As_blockContext> as_block() {
			return getRuleContexts(As_blockContext.class);
		}
		public Default_blockContext default_block() {
			return getRuleContext(Default_blockContext.class,0);
		}
		public As_blockContext as_block(int i) {
			return getRuleContext(As_blockContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Case_blockContext case_block() {
			return getRuleContext(Case_blockContext.class,0);
		}
		public Select_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterSelect_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitSelect_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitSelect_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_exprContext select_expr() throws RecognitionException {
		Select_exprContext _localctx = new Select_exprContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_select_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550); match(33);
			setState(551); match(37);
			setState(552); expression();
			setState(553); match(16);
			setState(554); match(44);
			setState(565);
			switch (_input.LA(1)) {
			case 12:
				{
				setState(556); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(555); case_block();
					}
					}
					setState(558); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==12 );
				}
				break;
			case 43:
				{
				setState(561); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(560); as_block();
					}
					}
					setState(563); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==43 );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(568);
			_la = _input.LA(1);
			if (_la==34) {
				{
				setState(567); default_block();
				}
			}

			setState(570); match(10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_blockContext extends ParserRuleContext {
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Case_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterCase_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitCase_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitCase_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_blockContext case_block() throws RecognitionException {
		Case_blockContext _localctx = new Case_blockContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_case_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572); match(12);
			setState(573); match(37);
			setState(576);
			switch (_input.LA(1)) {
			case NORMALSTRING:
			case CHARSTRING:
			case LONGSTRING:
			case INT:
			case HEX:
			case FLOAT:
			case HEX_FLOAT:
				{
				setState(574); literal();
				}
				break;
			case NAME:
				{
				setState(575); qName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(578); match(16);
			setState(579); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class As_blockContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public As_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterAs_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitAs_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitAs_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final As_blockContext as_block() throws RecognitionException {
		As_blockContext _localctx = new As_blockContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_as_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581); match(43);
			setState(582); match(37);
			setState(583); match(NAME);
			setState(584); match(38);
			setState(585); type_expr();
			setState(586); match(16);
			setState(587); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Default_blockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Default_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterDefault_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitDefault_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitDefault_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Default_blockContext default_block() throws RecognitionException {
		Default_blockContext _localctx = new Default_blockContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_default_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589); match(34);
			setState(590); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeContext extends ParserRuleContext {
		public List<TermsContext> terms() {
			return getRuleContexts(TermsContext.class);
		}
		public TermsContext terms(int i) {
			return getRuleContext(TermsContext.class,i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592); terms();
			setState(593);
			_la = _input.LA(1);
			if ( !(((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (25 - 25)) | (1L << (40 - 25)) | (1L << (63 - 25)) | (1L << (69 - 25)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(594); terms();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public Cond_termContext cond_term(int i) {
			return getRuleContext(Cond_termContext.class,i);
		}
		public List<Cond_termContext> cond_term() {
			return getRuleContexts(Cond_termContext.class);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596); cond_term();
			setState(599);
			_la = _input.LA(1);
			if (_la==1 || _la==27) {
				{
				setState(597);
				_la = _input.LA(1);
				if ( !(_la==1 || _la==27) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(598); cond_term();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond_termContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public Cond_monomialContext cond_monomial() {
			return getRuleContext(Cond_monomialContext.class,0);
		}
		public Cond_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterCond_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitCond_term(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitCond_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cond_termContext cond_term() throws RecognitionException {
		Cond_termContext _localctx = new Cond_termContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_cond_term);
		try {
			setState(607);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(601); cond_monomial();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(602); relation();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(603); match(37);
				setState(604); condition();
				setState(605); match(16);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public List<TermsContext> terms() {
			return getRuleContexts(TermsContext.class);
		}
		public TermsContext terms(int i) {
			return getRuleContext(TermsContext.class,i);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609); terms();
			setState(610);
			_la = _input.LA(1);
			if ( !(((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (5 - 5)) | (1L << (6 - 5)) | (1L << (7 - 5)) | (1L << (60 - 5)) | (1L << (66 - 5)) | (1L << (68 - 5)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(611); terms();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond_monomialContext extends ParserRuleContext {
		public MonomialContext monomial() {
			return getRuleContext(MonomialContext.class,0);
		}
		public Cond_monomialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_monomial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterCond_monomial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitCond_monomial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitCond_monomial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cond_monomialContext cond_monomial() throws RecognitionException {
		Cond_monomialContext _localctx = new Cond_monomialContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_cond_monomial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			_la = _input.LA(1);
			if (_la==28) {
				{
				setState(613); match(28);
				}
			}

			setState(616); monomial();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermsContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitTerms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618); term();
			setState(623);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==36 || _la==53) {
				{
				{
				setState(619);
				_la = _input.LA(1);
				if ( !(_la==36 || _la==53) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(620); term();
				}
				}
				setState(625);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626); factor();
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (4 - 4)) | (1L << (15 - 4)) | (1L << (17 - 4)) | (1L << (67 - 4)))) != 0)) {
				{
				{
				setState(627);
				_la = _input.LA(1);
				if ( !(((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & ((1L << (4 - 4)) | (1L << (15 - 4)) | (1L << (17 - 4)) | (1L << (67 - 4)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(628); factor();
				}
				}
				setState(633);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public Post_opContext post_op() {
			return getRuleContext(Post_opContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			_la = _input.LA(1);
			if (_la==36) {
				{
				setState(634); match(36);
				}
			}

			setState(637); post_op();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Post_opContext extends ParserRuleContext {
		public TerminalNode UNIT_NAME() { return getToken(LoreParser.UNIT_NAME, 0); }
		public TerminalNode DICE() { return getToken(LoreParser.DICE, 0); }
		public MonomialContext monomial() {
			return getRuleContext(MonomialContext.class,0);
		}
		public Post_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_post_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterPost_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitPost_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitPost_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Post_opContext post_op() throws RecognitionException {
		Post_opContext _localctx = new Post_opContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_post_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			switch (_input.LA(1)) {
			case 2:
			case 8:
			case 11:
			case 13:
			case 18:
			case 19:
			case 21:
			case 29:
			case 37:
			case 39:
			case 44:
			case 48:
			case 54:
			case 55:
			case 58:
			case 59:
			case 62:
			case 64:
			case NAME:
			case NORMALSTRING:
			case CHARSTRING:
			case LONGSTRING:
			case INT:
			case HEX:
			case FLOAT:
			case HEX_FLOAT:
				{
				setState(639); monomial();
				setState(641);
				_la = _input.LA(1);
				if (_la==DICE || _la==UNIT_NAME) {
					{
					setState(640);
					_la = _input.LA(1);
					if ( !(_la==DICE || _la==UNIT_NAME) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				}
				break;
			case DICE:
				{
				setState(643); match(DICE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MonomialContext extends ParserRuleContext {
		public List<Member_accessContext> member_access() {
			return getRuleContexts(Member_accessContext.class);
		}
		public Member_accessContext member_access(int i) {
			return getRuleContext(Member_accessContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public MonomialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_monomial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterMonomial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitMonomial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitMonomial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MonomialContext monomial() throws RecognitionException {
		MonomialContext _localctx = new MonomialContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_monomial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646); atom();
			setState(650);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==51) {
				{
				{
				setState(647); member_access();
				}
				}
				setState(652);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_accessContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public Member_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterMember_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitMember_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitMember_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_accessContext member_access() throws RecognitionException {
		Member_accessContext _localctx = new Member_accessContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_member_access);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653); match(51);
			setState(654); match(NAME);
			setState(656);
			_la = _input.LA(1);
			if (_la==37) {
				{
				setState(655); args();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658); match(37);
			setState(659); expression();
			setState(664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==35) {
				{
				{
				setState(660); match(35);
				setState(661); expression();
				}
				}
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(667); match(16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public Struct_constructContext struct_construct() {
			return getRuleContext(Struct_constructContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Builtin_type_exprContext builtin_type_expr() {
			return getRuleContext(Builtin_type_exprContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public List_constructContext list_construct() {
			return getRuleContext(List_constructContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_atom);
		try {
			setState(681);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(669); match(2);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(670); match(NAME);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(671); match(NAME);
				setState(672); args();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(673); literal();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(674); match(37);
				setState(675); expression();
				setState(676); match(16);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(678); list_construct();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(679); struct_construct();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(680); builtin_type_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_constructContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public List_constructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_construct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterList_construct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitList_construct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitList_construct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_constructContext list_construct() throws RecognitionException {
		List_constructContext _localctx = new List_constructContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_list_construct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683); match(44);
			setState(684); expression();
			setState(689);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==35) {
				{
				{
				setState(685); match(35);
				setState(686); expression();
				}
				}
				setState(691);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(692); match(10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_constructContext extends ParserRuleContext {
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public Member_initializerContext member_initializer(int i) {
			return getRuleContext(Member_initializerContext.class,i);
		}
		public List<Member_initializerContext> member_initializer() {
			return getRuleContexts(Member_initializerContext.class);
		}
		public Struct_constructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_construct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterStruct_construct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitStruct_construct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitStruct_construct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_constructContext struct_construct() throws RecognitionException {
		Struct_constructContext _localctx = new Struct_constructContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_struct_construct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694); match(44);
			setState(696); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(695); member_initializer();
				}
				}
				setState(698); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (31 - 9)) | (1L << (47 - 9)) | (1L << (50 - 9)) | (1L << (52 - 9)) | (1L << (NAME - 9)))) != 0) );
			setState(700); match(10);
			setState(703);
			_la = _input.LA(1);
			if (_la==38) {
				{
				setState(701); match(38);
				setState(702); qName();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705); match(18);
			setState(707);
			_la = _input.LA(1);
			if (_la==37) {
				{
				setState(706); parameters();
				}
			}

			setState(711);
			_la = _input.LA(1);
			if (_la==38) {
				{
				setState(709); match(38);
				setState(710); type_expr();
				}
			}

			setState(713); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public XmlContext xml() {
			return getRuleContext(XmlContext.class,0);
		}
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public JidContext jid() {
			return getRuleContext(JidContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_literal);
		try {
			setState(723);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(715); number();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(716); stringLiteral();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(717); html();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(718); xml();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(719); url();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(720); jid();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(721); date();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(722); loc();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HtmlContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public HtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitHtml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitHtml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlContext html() throws RecognitionException {
		HtmlContext _localctx = new HtmlContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_html);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(725); stringLiteral();
			setState(726); match(38);
			setState(727); match(21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XmlContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public XmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterXml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitXml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitXml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlContext xml() throws RecognitionException {
		XmlContext _localctx = new XmlContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_xml);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729); stringLiteral();
			setState(730); match(38);
			setState(731); match(59);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UrlContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public UrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_url; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterUrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitUrl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitUrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UrlContext url() throws RecognitionException {
		UrlContext _localctx = new UrlContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(733); stringLiteral();
			setState(734); match(38);
			setState(735); match(11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DateContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737); stringLiteral();
			setState(738); match(38);
			setState(739); match(48);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JidContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public JidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterJid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitJid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitJid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JidContext jid() throws RecognitionException {
		JidContext _localctx = new JidContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_jid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(741); stringLiteral();
			setState(742); match(38);
			setState(743); match(39);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public LocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocContext loc() throws RecognitionException {
		LocContext _localctx = new LocContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_loc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745); stringLiteral();
			setState(746); match(38);
			setState(747); match(55);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode LONGSTRING() { return getToken(LoreParser.LONGSTRING, 0); }
		public TerminalNode NORMALSTRING() { return getToken(LoreParser.NORMALSTRING, 0); }
		public TerminalNode CHARSTRING() { return getToken(LoreParser.CHARSTRING, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_stringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(749);
			_la = _input.LA(1);
			if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (NORMALSTRING - 73)) | (1L << (CHARSTRING - 73)) | (1L << (LONGSTRING - 73)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(LoreParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(LoreParser.INT, 0); }
		public TerminalNode HEX_FLOAT() { return getToken(LoreParser.HEX_FLOAT, 0); }
		public TerminalNode HEX() { return getToken(LoreParser.HEX, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(751);
			_la = _input.LA(1);
			if ( !(((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (INT - 76)) | (1L << (HEX - 76)) | (1L << (FLOAT - 76)) | (1L << (HEX_FLOAT - 76)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3U\u02f4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\3\2\3\2\7\2\u009b\n\2\f\2\16\2\u009e\13\2\3\3\5"+
		"\3\u00a1\n\3\3\3\5\3\u00a4\n\3\3\3\7\3\u00a7\n\3\f\3\16\3\u00aa\13\3\3"+
		"\3\7\3\u00ad\n\3\f\3\16\3\u00b0\13\3\3\3\7\3\u00b3\n\3\f\3\16\3\u00b6"+
		"\13\3\3\4\3\4\3\4\3\4\3\4\5\4\u00bd\n\4\3\4\3\4\3\4\5\4\u00c2\n\4\5\4"+
		"\u00c4\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7\u00d7\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00e2\n"+
		"\b\3\b\3\b\3\b\7\b\u00e7\n\b\f\b\16\b\u00ea\13\b\5\b\u00ec\n\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\7\13\u0107\n\13\f\13\16\13\u010a\13\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\5\r\u0113\n\r\3\16\3\16\3\16\7\16\u0118\n\16"+
		"\f\16\16\16\u011b\13\16\3\17\3\17\3\17\3\17\5\17\u0121\n\17\3\20\3\20"+
		"\3\20\5\20\u0126\n\20\3\21\3\21\3\21\3\21\5\21\u012c\n\21\3\21\3\21\6"+
		"\21\u0130\n\21\r\21\16\21\u0131\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u013a"+
		"\n\22\f\22\16\22\u013d\13\22\3\22\3\22\3\22\5\22\u0142\n\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u014d\n\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\5\25\u0155\n\25\3\25\3\25\3\25\7\25\u015a\n\25\f\25\16\25\u015d"+
		"\13\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u0167\n\27\3\30\3"+
		"\30\3\30\5\30\u016c\n\30\3\30\3\30\5\30\u0170\n\30\3\30\3\30\5\30\u0174"+
		"\n\30\3\30\3\30\5\30\u0178\n\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\5\33\u0184\n\33\3\34\3\34\3\34\3\34\3\34\5\34\u018b\n\34\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\7\35\u0193\n\35\f\35\16\35\u0196\13\35\3"+
		"\35\3\35\5\35\u019a\n\35\3\35\3\35\5\35\u019e\n\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\5\36\u01a9\n\36\5\36\u01ab\n\36\5\36\u01ad\n"+
		"\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\5!\u01c2\n!\3\"\3\"\3#\3#\3#\5#\u01c9\n#\3#\3#\3$\3$\3$\5$\u01d0\n$"+
		"\3$\3$\3$\3$\3%\3%\5%\u01d8\n%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u01ef\n\'\f\'\16\'\u01f2\13\'\3\'"+
		"\3\'\3(\3(\7(\u01f8\n(\f(\16(\u01fb\13(\3(\3(\3)\3)\3)\3)\3)\3)\3)\5)"+
		"\u0206\n)\3*\3*\3*\3+\3+\3,\3,\3,\5,\u0210\n,\3,\3,\3-\3-\3-\3-\3-\3."+
		"\3.\5.\u021b\n.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\5/\u0227\n/\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\6\60\u022f\n\60\r\60\16\60\u0230\3\60\6\60\u0234\n"+
		"\60\r\60\16\60\u0235\5\60\u0238\n\60\3\60\5\60\u023b\n\60\3\60\3\60\3"+
		"\61\3\61\3\61\3\61\5\61\u0243\n\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65"+
		"\5\65\u025a\n\65\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0262\n\66\3\67\3"+
		"\67\3\67\3\67\38\58\u0269\n8\38\38\39\39\39\79\u0270\n9\f9\169\u0273\13"+
		"9\3:\3:\3:\7:\u0278\n:\f:\16:\u027b\13:\3;\5;\u027e\n;\3;\3;\3<\3<\5<"+
		"\u0284\n<\3<\5<\u0287\n<\3=\3=\7=\u028b\n=\f=\16=\u028e\13=\3>\3>\3>\5"+
		">\u0293\n>\3?\3?\3?\3?\7?\u0299\n?\f?\16?\u029c\13?\3?\3?\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\5@\u02ac\n@\3A\3A\3A\3A\7A\u02b2\nA\fA\16A\u02b5"+
		"\13A\3A\3A\3B\3B\6B\u02bb\nB\rB\16B\u02bc\3B\3B\3B\5B\u02c2\nB\3C\3C\5"+
		"C\u02c6\nC\3C\3C\5C\u02ca\nC\3C\3C\3D\3D\3D\3D\3D\3D\3D\3D\5D\u02d6\n"+
		"D\3E\3E\3E\3E\3F\3F\3F\3F\3G\3G\3G\3G\3H\3H\3H\3H\3I\3I\3I\3I\3J\3J\3"+
		"J\3J\3K\3K\3L\3L\3L\2M\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\2\13\5\2\37\37<<@@\6"+
		"\2\33\33**AAGG\4\2\3\3\35\35\6\2\7\t>>DDFF\4\2&&\67\67\6\2\6\6\21\21\23"+
		"\23EE\3\2HI\3\2KM\3\2NQ\u031a\2\u0098\3\2\2\2\4\u00a0\3\2\2\2\6\u00b7"+
		"\3\2\2\2\b\u00c7\3\2\2\2\n\u00cb\3\2\2\2\f\u00cf\3\2\2\2\16\u00da\3\2"+
		"\2\2\20\u00ef\3\2\2\2\22\u00fd\3\2\2\2\24\u0101\3\2\2\2\26\u010d\3\2\2"+
		"\2\30\u0112\3\2\2\2\32\u0114\3\2\2\2\34\u0120\3\2\2\2\36\u0125\3\2\2\2"+
		" \u0127\3\2\2\2\"\u0135\3\2\2\2$\u0143\3\2\2\2&\u0148\3\2\2\2(\u0150\3"+
		"\2\2\2*\u0160\3\2\2\2,\u0166\3\2\2\2.\u0177\3\2\2\2\60\u0179\3\2\2\2\62"+
		"\u017c\3\2\2\2\64\u0183\3\2\2\2\66\u018a\3\2\2\28\u018c\3\2\2\2:\u01a1"+
		"\3\2\2\2<\u01b0\3\2\2\2>\u01b3\3\2\2\2@\u01c1\3\2\2\2B\u01c3\3\2\2\2D"+
		"\u01c5\3\2\2\2F\u01cc\3\2\2\2H\u01d5\3\2\2\2J\u01dd\3\2\2\2L\u01e6\3\2"+
		"\2\2N\u01f5\3\2\2\2P\u0205\3\2\2\2R\u0207\3\2\2\2T\u020a\3\2\2\2V\u020c"+
		"\3\2\2\2X\u0213\3\2\2\2Z\u021a\3\2\2\2\\\u0226\3\2\2\2^\u0228\3\2\2\2"+
		"`\u023e\3\2\2\2b\u0247\3\2\2\2d\u024f\3\2\2\2f\u0252\3\2\2\2h\u0256\3"+
		"\2\2\2j\u0261\3\2\2\2l\u0263\3\2\2\2n\u0268\3\2\2\2p\u026c\3\2\2\2r\u0274"+
		"\3\2\2\2t\u027d\3\2\2\2v\u0286\3\2\2\2x\u0288\3\2\2\2z\u028f\3\2\2\2|"+
		"\u0294\3\2\2\2~\u02ab\3\2\2\2\u0080\u02ad\3\2\2\2\u0082\u02b8\3\2\2\2"+
		"\u0084\u02c3\3\2\2\2\u0086\u02d5\3\2\2\2\u0088\u02d7\3\2\2\2\u008a\u02db"+
		"\3\2\2\2\u008c\u02df\3\2\2\2\u008e\u02e3\3\2\2\2\u0090\u02e7\3\2\2\2\u0092"+
		"\u02eb\3\2\2\2\u0094\u02ef\3\2\2\2\u0096\u02f1\3\2\2\2\u0098\u009c\5\4"+
		"\3\2\u0099\u009b\5\30\r\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\3\3\2\2\2\u009e\u009c\3\2\2\2"+
		"\u009f\u00a1\5\6\4\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3"+
		"\3\2\2\2\u00a2\u00a4\5\f\7\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a8\3\2\2\2\u00a5\u00a7\5\16\b\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3"+
		"\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ae\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ad\5\20\t\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3"+
		"\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b4\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b3\5\22\n\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3"+
		"\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\5\3\2\2\2\u00b6\u00b4"+
		"\3\2\2\2\u00b7\u00b8\7\32\2\2\u00b8\u00c3\7.\2\2\u00b9\u00bc\5\b\5\2\u00ba"+
		"\u00bb\7%\2\2\u00bb\u00bd\5\n\6\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00c4\3\2\2\2\u00be\u00c1\5\n\6\2\u00bf\u00c0\7%\2\2\u00c0"+
		"\u00c2\5\b\5\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2"+
		"\2\2\u00c3\u00b9\3\2\2\2\u00c3\u00be\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\7\f\2\2\u00c6\7\3\2\2\2\u00c7\u00c8\7\20\2\2\u00c8\u00c9\7\26\2"+
		"\2\u00c9\u00ca\7K\2\2\u00ca\t\3\2\2\2\u00cb\u00cc\7\34\2\2\u00cc\u00cd"+
		"\7\26\2\2\u00cd\u00ce\5\u008cG\2\u00ce\13\3\2\2\2\u00cf\u00d0\7\30\2\2"+
		"\u00d0\u00d1\7\'\2\2\u00d1\u00d2\5\u0094K\2\u00d2\u00d3\7\22\2\2\u00d3"+
		"\u00d6\7.\2\2\u00d4\u00d7\5\u0094K\2\u00d5\u00d7\5\u0088E\2\u00d6\u00d4"+
		"\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d9\7\f\2\2\u00d9\r\3\2\2\2\u00da\u00db\7C\2\2\u00db\u00dc\7\'\2\2"+
		"\u00dc\u00dd\7K\2\2\u00dd\u00de\7\22\2\2\u00de\u00e1\7.\2\2\u00df\u00e2"+
		"\5\u0090I\2\u00e0\u00e2\5\u008cG\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2"+
		"\2\2\u00e2\u00eb\3\2\2\2\u00e3\u00e8\7%\2\2\u00e4\u00e7\5\u0090I\2\u00e5"+
		"\u00e7\5\u008cG\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea"+
		"\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00eb\u00e3\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ee\7\f\2\2\u00ee\17\3\2\2\2\u00ef\u00f0\7;\2\2\u00f0\u00f1"+
		"\7\'\2\2\u00f1\u00f2\5\u008eH\2\u00f2\u00f3\7\22\2\2\u00f3\u00f4\7.\2"+
		"\2\u00f4\u00f5\7\31\2\2\u00f5\u00f6\7\26\2\2\u00f6\u00f7\7K\2\2\u00f7"+
		"\u00f8\7%\2\2\u00f8\u00f9\7\30\2\2\u00f9\u00fa\7\26\2\2\u00fa\u00fb\5"+
		"\u0094K\2\u00fb\u00fc\7\f\2\2\u00fc\21\3\2\2\2\u00fd\u00fe\7\63\2\2\u00fe"+
		"\u00ff\5\u008cG\2\u00ff\u0100\7:\2\2\u0100\23\3\2\2\2\u0101\u0102\7/\2"+
		"\2\u0102\u0103\5\32\16\2\u0103\u0108\7.\2\2\u0104\u0107\5\26\f\2\u0105"+
		"\u0107\5\30\r\2\u0106\u0104\3\2\2\2\u0106\u0105\3\2\2\2\u0107\u010a\3"+
		"\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a"+
		"\u0108\3\2\2\2\u010b\u010c\7\f\2\2\u010c\25\3\2\2\2\u010d\u010e\7+\2\2"+
		"\u010e\u010f\5\30\r\2\u010f\27\3\2\2\2\u0110\u0113\5\24\13\2\u0111\u0113"+
		"\5\34\17\2\u0112\u0110\3\2\2\2\u0112\u0111\3\2\2\2\u0113\31\3\2\2\2\u0114"+
		"\u0119\7J\2\2\u0115\u0116\7\65\2\2\u0116\u0118\7J\2\2\u0117\u0115\3\2"+
		"\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\33\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u0121\5\36\20\2\u011d\u0121\5X-"+
		"\2\u011e\u0121\5F$\2\u011f\u0121\5D#\2\u0120\u011c\3\2\2\2\u0120\u011d"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u011f\3\2\2\2\u0121\35\3\2\2\2\u0122"+
		"\u0126\5 \21\2\u0123\u0126\5&\24\2\u0124\u0126\5(\25\2\u0125\u0122\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u0126\37\3\2\2\2\u0127\u0128"+
		"\7 \2\2\u0128\u012b\7J\2\2\u0129\u012a\7\60\2\2\u012a\u012c\5\32\16\2"+
		"\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012f"+
		"\7.\2\2\u012e\u0130\5\"\22\2\u012f\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\7\f"+
		"\2\2\u0134!\3\2\2\2\u0135\u0141\7J\2\2\u0136\u0137\7.\2\2\u0137\u013b"+
		"\5$\23\2\u0138\u013a\5$\23\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2"+
		"\2\2\u013e\u013f\7\f\2\2\u013f\u0142\3\2\2\2\u0140\u0142\7:\2\2\u0141"+
		"\u0136\3\2\2\2\u0141\u0140\3\2\2\2\u0142#\3\2\2\2\u0143\u0144\7J\2\2\u0144"+
		"\u0145\7\26\2\2\u0145\u0146\5\\/\2\u0146\u0147\7:\2\2\u0147%\3\2\2\2\u0148"+
		"\u0149\7I\2\2\u0149\u014a\7\26\2\2\u014a\u014c\5\u0096L\2\u014b\u014d"+
		"\7I\2\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u014f\7:\2\2\u014f\'\3\2\2\2\u0150\u0151\7\"\2\2\u0151\u0154\7J\2\2\u0152"+
		"\u0153\7\60\2\2\u0153\u0155\5\32\16\2\u0154\u0152\3\2\2\2\u0154\u0155"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u015b\7.\2\2\u0157\u015a\5*\26\2\u0158"+
		"\u015a\5,\27\2\u0159\u0157\3\2\2\2\u0159\u0158\3\2\2\2\u015a\u015d\3\2"+
		"\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d"+
		"\u015b\3\2\2\2\u015e\u015f\7\f\2\2\u015f)\3\2\2\2\u0160\u0161\7+\2\2\u0161"+
		"\u0162\5,\27\2\u0162+\3\2\2\2\u0163\u0167\5\62\32\2\u0164\u0167\5\36\20"+
		"\2\u0165\u0167\5.\30\2\u0166\u0163\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0165"+
		"\3\2\2\2\u0167-\3\2\2\2\u0168\u0178\5\60\31\2\u0169\u0178\5X-\2\u016a"+
		"\u016c\7\13\2\2\u016b\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3"+
		"\2\2\2\u016d\u0178\5H%\2\u016e\u0170\7\13\2\2\u016f\u016e\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0178\5J&\2\u0172\u0174\7\13"+
		"\2\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3\2\2\2\u0175"+
		"\u0178\5D#\2\u0176\u0178\5F$\2\u0177\u0168\3\2\2\2\u0177\u0169\3\2\2\2"+
		"\u0177\u016b\3\2\2\2\u0177\u016f\3\2\2\2\u0177\u0173\3\2\2\2\u0177\u0176"+
		"\3\2\2\2\u0178/\3\2\2\2\u0179\u017a\7\66\2\2\u017a\u017b\5X-\2\u017b\61"+
		"\3\2\2\2\u017c\u017d\7J\2\2\u017d\u017e\7(\2\2\u017e\u017f\5\64\33\2\u017f"+
		"\u0180\7:\2\2\u0180\63\3\2\2\2\u0181\u0184\5\32\16\2\u0182\u0184\5\66"+
		"\34\2\u0183\u0181\3\2\2\2\u0183\u0182\3\2\2\2\u0184\65\3\2\2\2\u0185\u018b"+
		"\5@!\2\u0186\u018b\5:\36\2\u0187\u018b\5<\37\2\u0188\u018b\5> \2\u0189"+
		"\u018b\58\35\2\u018a\u0185\3\2\2\2\u018a\u0186\3\2\2\2\u018a\u0187\3\2"+
		"\2\2\u018a\u0188\3\2\2\2\u018a\u0189\3\2\2\2\u018b\67\3\2\2\2\u018c\u018d"+
		"\7\24\2\2\u018d\u0199\7\7\2\2\u018e\u018f\7\'\2\2\u018f\u0194\5\64\33"+
		"\2\u0190\u0191\7%\2\2\u0191\u0193\5\64\33\2\u0192\u0190\3\2\2\2\u0193"+
		"\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0197\3\2"+
		"\2\2\u0196\u0194\3\2\2\2\u0197\u0198\7\22\2\2\u0198\u019a\3\2\2\2\u0199"+
		"\u018e\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u019c\7("+
		"\2\2\u019c\u019e\5\64\33\2\u019d\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\u01a0\7>\2\2\u01a09\3\2\2\2\u01a1\u01a2\78\2\2\u01a2"+
		"\u01ac\7\7\2\2\u01a3\u01ad\5\64\33\2\u01a4\u01aa\7,\2\2\u01a5\u01a8\7"+
		"\60\2\2\u01a6\u01a9\5\32\16\2\u01a7\u01a9\5@!\2\u01a8\u01a6\3\2\2\2\u01a8"+
		"\u01a7\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u01a5\3\2\2\2\u01aa\u01ab\3\2"+
		"\2\2\u01ab\u01ad\3\2\2\2\u01ac\u01a3\3\2\2\2\u01ac\u01a4\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01af\7>\2\2\u01af;\3\2\2\2\u01b0\u01b1\7\25\2\2"+
		"\u01b1\u01b2\7I\2\2\u01b2=\3\2\2\2\u01b3\u01b4\7\n\2\2\u01b4\u01b5\7\7"+
		"\2\2\u01b5\u01b6\5B\"\2\u01b6\u01b7\7>\2\2\u01b7?\3\2\2\2\u01b8\u01c2"+
		"\5B\"\2\u01b9\u01c2\7B\2\2\u01ba\u01c2\7\r\2\2\u01bb\u01c2\7)\2\2\u01bc"+
		"\u01c2\7\27\2\2\u01bd\u01c2\7=\2\2\u01be\u01c2\7\62\2\2\u01bf\u01c2\7"+
		"9\2\2\u01c0\u01c2\7\17\2\2\u01c1\u01b8\3\2\2\2\u01c1\u01b9\3\2\2\2\u01c1"+
		"\u01ba\3\2\2\2\u01c1\u01bb\3\2\2\2\u01c1\u01bc\3\2\2\2\u01c1\u01bd\3\2"+
		"\2\2\u01c1\u01be\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2"+
		"A\3\2\2\2\u01c3\u01c4\t\2\2\2\u01c4C\3\2\2\2\u01c5\u01c6\7\61\2\2\u01c6"+
		"\u01c8\7J\2\2\u01c7\u01c9\5L\'\2\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2"+
		"\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\5N(\2\u01cbE\3\2\2\2\u01cc\u01cd\7"+
		"\64\2\2\u01cd\u01cf\7J\2\2\u01ce\u01d0\5L\'\2\u01cf\u01ce\3\2\2\2\u01cf"+
		"\u01d0\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\7(\2\2\u01d2\u01d3\5\64"+
		"\33\2\u01d3\u01d4\5N(\2\u01d4G\3\2\2\2\u01d5\u01d7\7J\2\2\u01d6\u01d8"+
		"\5L\'\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01da\7(\2\2\u01da\u01db\5\64\33\2\u01db\u01dc\5N(\2\u01dcI\3\2\2\2\u01dd"+
		"\u01de\7!\2\2\u01de\u01df\7J\2\2\u01df\u01e0\7\'\2\2\u01e0\u01e1\7J\2"+
		"\2\u01e1\u01e2\7(\2\2\u01e2\u01e3\5:\36\2\u01e3\u01e4\7\22\2\2\u01e4\u01e5"+
		"\5N(\2\u01e5K\3\2\2\2\u01e6\u01e7\7\'\2\2\u01e7\u01e8\7J\2\2\u01e8\u01e9"+
		"\7(\2\2\u01e9\u01f0\5\64\33\2\u01ea\u01eb\7%\2\2\u01eb\u01ec\7J\2\2\u01ec"+
		"\u01ed\7(\2\2\u01ed\u01ef\5\64\33\2\u01ee\u01ea\3\2\2\2\u01ef\u01f2\3"+
		"\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f3\3\2\2\2\u01f2"+
		"\u01f0\3\2\2\2\u01f3\u01f4\7\22\2\2\u01f4M\3\2\2\2\u01f5\u01f9\7.\2\2"+
		"\u01f6\u01f8\5P)\2\u01f7\u01f6\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01f7"+
		"\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fc"+
		"\u01fd\7\f\2\2\u01fdO\3\2\2\2\u01fe\u0206\5X-\2\u01ff\u0206\5Z.\2\u0200"+
		"\u0206\5F$\2\u0201\u0206\5\36\20\2\u0202\u0206\5R*\2\u0203\u0206\5T+\2"+
		"\u0204\u0206\5V,\2\u0205\u01fe\3\2\2\2\u0205\u01ff\3\2\2\2\u0205\u0200"+
		"\3\2\2\2\u0205\u0201\3\2\2\2\u0205\u0202\3\2\2\2\u0205\u0203\3\2\2\2\u0205"+
		"\u0204\3\2\2\2\u0206Q\3\2\2\2\u0207\u0208\5x=\2\u0208\u0209\7:\2\2\u0209"+
		"S\3\2\2\2\u020a\u020b\5^\60\2\u020bU\3\2\2\2\u020c\u020d\7\5\2\2\u020d"+
		"\u020f\7\26\2\2\u020e\u0210\5\\/\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2"+
		"\2\2\u0210\u0211\3\2\2\2\u0211\u0212\7:\2\2\u0212W\3\2\2\2\u0213\u0214"+
		"\7J\2\2\u0214\u0215\7\26\2\2\u0215\u0216\5\\/\2\u0216\u0217\7:\2\2\u0217"+
		"Y\3\2\2\2\u0218\u0219\7\4\2\2\u0219\u021b\7\65\2\2\u021a\u0218\3\2\2\2"+
		"\u021a\u021b\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021d\7J\2\2\u021d\u021e"+
		"\7?\2\2\u021e\u021f\5\\/\2\u021f\u0220\7:\2\2\u0220[\3\2\2\2\u0221\u0227"+
		"\5p9\2\u0222\u0227\5f\64\2\u0223\u0227\5h\65\2\u0224\u0227\5^\60\2\u0225"+
		"\u0227\5\u0084C\2\u0226\u0221\3\2\2\2\u0226\u0222\3\2\2\2\u0226\u0223"+
		"\3\2\2\2\u0226\u0224\3\2\2\2\u0226\u0225\3\2\2\2\u0227]\3\2\2\2\u0228"+
		"\u0229\7#\2\2\u0229\u022a\7\'\2\2\u022a\u022b\5\\/\2\u022b\u022c\7\22"+
		"\2\2\u022c\u0237\7.\2\2\u022d\u022f\5`\61\2\u022e\u022d\3\2\2\2\u022f"+
		"\u0230\3\2\2\2\u0230\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0238\3\2"+
		"\2\2\u0232\u0234\5b\62\2\u0233\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235"+
		"\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0238\3\2\2\2\u0237\u022e\3\2"+
		"\2\2\u0237\u0233\3\2\2\2\u0238\u023a\3\2\2\2\u0239\u023b\5d\63\2\u023a"+
		"\u0239\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d\7\f"+
		"\2\2\u023d_\3\2\2\2\u023e\u023f\7\16\2\2\u023f\u0242\7\'\2\2\u0240\u0243"+
		"\5\u0086D\2\u0241\u0243\5\32\16\2\u0242\u0240\3\2\2\2\u0242\u0241\3\2"+
		"\2\2\u0243\u0244\3\2\2\2\u0244\u0245\7\22\2\2\u0245\u0246\5N(\2\u0246"+
		"a\3\2\2\2\u0247\u0248\7-\2\2\u0248\u0249\7\'\2\2\u0249\u024a\7J\2\2\u024a"+
		"\u024b\7(\2\2\u024b\u024c\5\64\33\2\u024c\u024d\7\22\2\2\u024d\u024e\5"+
		"N(\2\u024ec\3\2\2\2\u024f\u0250\7$\2\2\u0250\u0251\5N(\2\u0251e\3\2\2"+
		"\2\u0252\u0253\5p9\2\u0253\u0254\t\3\2\2\u0254\u0255\5p9\2\u0255g\3\2"+
		"\2\2\u0256\u0259\5j\66\2\u0257\u0258\t\4\2\2\u0258\u025a\5j\66\2\u0259"+
		"\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025ai\3\2\2\2\u025b\u0262\5n8\2\u025c"+
		"\u0262\5l\67\2\u025d\u025e\7\'\2\2\u025e\u025f\5h\65\2\u025f\u0260\7\22"+
		"\2\2\u0260\u0262\3\2\2\2\u0261\u025b\3\2\2\2\u0261\u025c\3\2\2\2\u0261"+
		"\u025d\3\2\2\2\u0262k\3\2\2\2\u0263\u0264\5p9\2\u0264\u0265\t\5\2\2\u0265"+
		"\u0266\5p9\2\u0266m\3\2\2\2\u0267\u0269\7\36\2\2\u0268\u0267\3\2\2\2\u0268"+
		"\u0269\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026b\5x=\2\u026bo\3\2\2\2\u026c"+
		"\u0271\5r:\2\u026d\u026e\t\6\2\2\u026e\u0270\5r:\2\u026f\u026d\3\2\2\2"+
		"\u0270\u0273\3\2\2\2\u0271\u026f\3\2\2\2\u0271\u0272\3\2\2\2\u0272q\3"+
		"\2\2\2\u0273\u0271\3\2\2\2\u0274\u0279\5t;\2\u0275\u0276\t\7\2\2\u0276"+
		"\u0278\5t;\2\u0277\u0275\3\2\2\2\u0278\u027b\3\2\2\2\u0279\u0277\3\2\2"+
		"\2\u0279\u027a\3\2\2\2\u027as\3\2\2\2\u027b\u0279\3\2\2\2\u027c\u027e"+
		"\7&\2\2\u027d\u027c\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u027f\3\2\2\2\u027f"+
		"\u0280\5v<\2\u0280u\3\2\2\2\u0281\u0283\5x=\2\u0282\u0284\t\b\2\2\u0283"+
		"\u0282\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0287\3\2\2\2\u0285\u0287\7H"+
		"\2\2\u0286\u0281\3\2\2\2\u0286\u0285\3\2\2\2\u0287w\3\2\2\2\u0288\u028c"+
		"\5~@\2\u0289\u028b\5z>\2\u028a\u0289\3\2\2\2\u028b\u028e\3\2\2\2\u028c"+
		"\u028a\3\2\2\2\u028c\u028d\3\2\2\2\u028dy\3\2\2\2\u028e\u028c\3\2\2\2"+
		"\u028f\u0290\7\65\2\2\u0290\u0292\7J\2\2\u0291\u0293\5|?\2\u0292\u0291"+
		"\3\2\2\2\u0292\u0293\3\2\2\2\u0293{\3\2\2\2\u0294\u0295\7\'\2\2\u0295"+
		"\u029a\5\\/\2\u0296\u0297\7%\2\2\u0297\u0299\5\\/\2\u0298\u0296\3\2\2"+
		"\2\u0299\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029d"+
		"\3\2\2\2\u029c\u029a\3\2\2\2\u029d\u029e\7\22\2\2\u029e}\3\2\2\2\u029f"+
		"\u02ac\7\4\2\2\u02a0\u02ac\7J\2\2\u02a1\u02a2\7J\2\2\u02a2\u02ac\5|?\2"+
		"\u02a3\u02ac\5\u0086D\2\u02a4\u02a5\7\'\2\2\u02a5\u02a6\5\\/\2\u02a6\u02a7"+
		"\7\22\2\2\u02a7\u02ac\3\2\2\2\u02a8\u02ac\5\u0080A\2\u02a9\u02ac\5\u0082"+
		"B\2\u02aa\u02ac\5\66\34\2\u02ab\u029f\3\2\2\2\u02ab\u02a0\3\2\2\2\u02ab"+
		"\u02a1\3\2\2\2\u02ab\u02a3\3\2\2\2\u02ab\u02a4\3\2\2\2\u02ab\u02a8\3\2"+
		"\2\2\u02ab\u02a9\3\2\2\2\u02ab\u02aa\3\2\2\2\u02ac\177\3\2\2\2\u02ad\u02ae"+
		"\7.\2\2\u02ae\u02b3\5\\/\2\u02af\u02b0\7%\2\2\u02b0\u02b2\5\\/\2\u02b1"+
		"\u02af\3\2\2\2\u02b2\u02b5\3\2\2\2\u02b3\u02b1\3\2\2\2\u02b3\u02b4\3\2"+
		"\2\2\u02b4\u02b6\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b6\u02b7\7\f\2\2\u02b7"+
		"\u0081\3\2\2\2\u02b8\u02ba\7.\2\2\u02b9\u02bb\5.\30\2\u02ba\u02b9\3\2"+
		"\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd"+
		"\u02be\3\2\2\2\u02be\u02c1\7\f\2\2\u02bf\u02c0\7(\2\2\u02c0\u02c2\5\32"+
		"\16\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u0083\3\2\2\2\u02c3"+
		"\u02c5\7\24\2\2\u02c4\u02c6\5L\'\2\u02c5\u02c4\3\2\2\2\u02c5\u02c6\3\2"+
		"\2\2\u02c6\u02c9\3\2\2\2\u02c7\u02c8\7(\2\2\u02c8\u02ca\5\64\33\2\u02c9"+
		"\u02c7\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cc\5N"+
		"(\2\u02cc\u0085\3\2\2\2\u02cd\u02d6\5\u0096L\2\u02ce\u02d6\5\u0094K\2"+
		"\u02cf\u02d6\5\u0088E\2\u02d0\u02d6\5\u008aF\2\u02d1\u02d6\5\u008cG\2"+
		"\u02d2\u02d6\5\u0090I\2\u02d3\u02d6\5\u008eH\2\u02d4\u02d6\5\u0092J\2"+
		"\u02d5\u02cd\3\2\2\2\u02d5\u02ce\3\2\2\2\u02d5\u02cf\3\2\2\2\u02d5\u02d0"+
		"\3\2\2\2\u02d5\u02d1\3\2\2\2\u02d5\u02d2\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d5"+
		"\u02d4\3\2\2\2\u02d6\u0087\3\2\2\2\u02d7\u02d8\5\u0094K\2\u02d8\u02d9"+
		"\7(\2\2\u02d9\u02da\7\27\2\2\u02da\u0089\3\2\2\2\u02db\u02dc\5\u0094K"+
		"\2\u02dc\u02dd\7(\2\2\u02dd\u02de\7=\2\2\u02de\u008b\3\2\2\2\u02df\u02e0"+
		"\5\u0094K\2\u02e0\u02e1\7(\2\2\u02e1\u02e2\7\r\2\2\u02e2\u008d\3\2\2\2"+
		"\u02e3\u02e4\5\u0094K\2\u02e4\u02e5\7(\2\2\u02e5\u02e6\7\62\2\2\u02e6"+
		"\u008f\3\2\2\2\u02e7\u02e8\5\u0094K\2\u02e8\u02e9\7(\2\2\u02e9\u02ea\7"+
		")\2\2\u02ea\u0091\3\2\2\2\u02eb\u02ec\5\u0094K\2\u02ec\u02ed\7(\2\2\u02ed"+
		"\u02ee\79\2\2\u02ee\u0093\3\2\2\2\u02ef\u02f0\t\t\2\2\u02f0\u0095\3\2"+
		"\2\2\u02f1\u02f2\t\n\2\2\u02f2\u0097\3\2\2\2L\u009c\u00a0\u00a3\u00a8"+
		"\u00ae\u00b4\u00bc\u00c1\u00c3\u00d6\u00e1\u00e6\u00e8\u00eb\u0106\u0108"+
		"\u0112\u0119\u0120\u0125\u012b\u0131\u013b\u0141\u014c\u0154\u0159\u015b"+
		"\u0166\u016b\u016f\u0173\u0177\u0183\u018a\u0194\u0199\u019d\u01a8\u01aa"+
		"\u01ac\u01c1\u01c8\u01cf\u01d7\u01f0\u01f9\u0205\u020f\u021a\u0226\u0230"+
		"\u0235\u0237\u023a\u0242\u0259\u0261\u0268\u0271\u0279\u027d\u0283\u0286"+
		"\u028c\u0292\u029a\u02ab\u02b3\u02bc\u02c1\u02c5\u02c9\u02d5";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}