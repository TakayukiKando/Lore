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
		T__66=1, T__65=2, T__64=3, T__63=4, T__62=5, T__61=6, T__60=7, T__59=8, 
		T__58=9, T__57=10, T__56=11, T__55=12, T__54=13, T__53=14, T__52=15, T__51=16, 
		T__50=17, T__49=18, T__48=19, T__47=20, T__46=21, T__45=22, T__44=23, 
		T__43=24, T__42=25, T__41=26, T__40=27, T__39=28, T__38=29, T__37=30, 
		T__36=31, T__35=32, T__34=33, T__33=34, T__32=35, T__31=36, T__30=37, 
		T__29=38, T__28=39, T__27=40, T__26=41, T__25=42, T__24=43, T__23=44, 
		T__22=45, T__21=46, T__20=47, T__19=48, T__18=49, T__17=50, T__16=51, 
		T__15=52, T__14=53, T__13=54, T__12=55, T__11=56, T__10=57, T__9=58, T__8=59, 
		T__7=60, T__6=61, T__5=62, T__4=63, T__3=64, T__2=65, T__1=66, T__0=67, 
		DICE=68, UNIT_NAME=69, NAME=70, NORMALSTRING=71, CHARSTRING=72, LONGSTRING=73, 
		INT=74, HEX=75, FLOAT=76, HEX_FLOAT=77, COMMENT=78, LINE_COMMENT=79, WS=80, 
		NEWLINE=81;
	public static final String[] tokenNames = {
		"<INVALID>", "'default'", "'private'", "'encoding'", "'alter'", "'!='", 
		"'reviser'", "'{'", "'='", "'rule'", "'unit'", "'version'", "'html'", 
		"'override'", "'number'", "'('", "'section'", "'url'", "',...,'", "','", 
		"'loc'", "'range'", "'>='", "',...<'", "'<'", "'desc'", "'date'", "'@'", 
		"'xml'", "'function'", "'+'", "'form'", "'/'", "'jid'", "'as'", "'integer'", 
		"';'", "'list'", "'extends'", "'author'", "'}'", "'enum'", "'<='", "'()'", 
		"'&'", "'dice'", "'*'", "'.'", "'case'", "'->'", "'result'", "'<...<'", 
		"':'", "'history'", "'=='", "'|'", "'select'", "'>'", "'!'", "'string'", 
		"'%'", "'docinfo'", "'<...,'", "'self'", "')'", "'-'", "'import'", "'real'", 
		"DICE", "UNIT_NAME", "NAME", "NORMALSTRING", "CHARSTRING", "LONGSTRING", 
		"INT", "HEX", "FLOAT", "HEX_FLOAT", "COMMENT", "LINE_COMMENT", "WS", "NEWLINE"
	};
	public static final int
		RULE_lore = 0, RULE_header = 1, RULE_docinfo = 2, RULE_encoding = 3, RULE_version = 4, 
		RULE_description = 5, RULE_author = 6, RULE_history = 7, RULE_import_other = 8, 
		RULE_section = 9, RULE_private_section_element = 10, RULE_section_element = 11, 
		RULE_qName = 12, RULE_definition = 13, RULE_type_def = 14, RULE_enum_def = 15, 
		RULE_extends_from = 16, RULE_enum_elem = 17, RULE_enum_field = 18, RULE_unit_def = 19, 
		RULE_form_def = 20, RULE_form_cont_def = 21, RULE_private_member_def = 22, 
		RULE_member_def = 23, RULE_member_initializer = 24, RULE_initializer = 25, 
		RULE_field_decl = 26, RULE_type_expr = 27, RULE_builtin_type_expr = 28, 
		RULE_lambda_type = 29, RULE_lambda_type_full = 30, RULE_lambda_type_no_param = 31, 
		RULE_lambda_type_no_return = 32, RULE_lambda_type_no_param_no_return = 33, 
		RULE_lambda_type_parameters = 34, RULE_list_type = 35, RULE_unit_type = 36, 
		RULE_range_type = 37, RULE_builtin_type = 38, RULE_textual_type = 39, 
		RULE_trpg_type = 40, RULE_arithmetic_type = 41, RULE_rule_def = 42, RULE_function_def = 43, 
		RULE_accessor_def = 44, RULE_alter_def = 45, RULE_parameters = 46, RULE_type_spec = 47, 
		RULE_block = 48, RULE_statement = 49, RULE_procedure_apply = 50, RULE_select_statement = 51, 
		RULE_result_statement = 52, RULE_var_def = 53, RULE_field_modify = 54, 
		RULE_expression = 55, RULE_select_expr = 56, RULE_case_block = 57, RULE_as_block = 58, 
		RULE_default_block = 59, RULE_range = 60, RULE_condition = 61, RULE_cond_term = 62, 
		RULE_relation = 63, RULE_cond_monomial = 64, RULE_terms = 65, RULE_term = 66, 
		RULE_factor = 67, RULE_post_op = 68, RULE_unit_monomial = 69, RULE_dice_monomial = 70, 
		RULE_monomial = 71, RULE_member_access = 72, RULE_args = 73, RULE_atom = 74, 
		RULE_self = 75, RULE_simpleCall = 76, RULE_list_construct = 77, RULE_form_construct = 78, 
		RULE_form_contents = 79, RULE_lambda = 80, RULE_lambda_full = 81, RULE_lambda_no_param = 82, 
		RULE_lambda_no_return = 83, RULE_lambda_no_param_no_return = 84, RULE_lambda_parameters = 85, 
		RULE_lambda_block = 86, RULE_literal = 87, RULE_html = 88, RULE_xml = 89, 
		RULE_url = 90, RULE_date = 91, RULE_jid = 92, RULE_loc = 93, RULE_stringLiteral = 94, 
		RULE_shortStringLiteral = 95, RULE_integral = 96, RULE_real = 97, RULE_diceKind = 98, 
		RULE_unitName = 99, RULE_simpleName = 100;
	public static final String[] ruleNames = {
		"lore", "header", "docinfo", "encoding", "version", "description", "author", 
		"history", "import_other", "section", "private_section_element", "section_element", 
		"qName", "definition", "type_def", "enum_def", "extends_from", "enum_elem", 
		"enum_field", "unit_def", "form_def", "form_cont_def", "private_member_def", 
		"member_def", "member_initializer", "initializer", "field_decl", "type_expr", 
		"builtin_type_expr", "lambda_type", "lambda_type_full", "lambda_type_no_param", 
		"lambda_type_no_return", "lambda_type_no_param_no_return", "lambda_type_parameters", 
		"list_type", "unit_type", "range_type", "builtin_type", "textual_type", 
		"trpg_type", "arithmetic_type", "rule_def", "function_def", "accessor_def", 
		"alter_def", "parameters", "type_spec", "block", "statement", "procedure_apply", 
		"select_statement", "result_statement", "var_def", "field_modify", "expression", 
		"select_expr", "case_block", "as_block", "default_block", "range", "condition", 
		"cond_term", "relation", "cond_monomial", "terms", "term", "factor", "post_op", 
		"unit_monomial", "dice_monomial", "monomial", "member_access", "args", 
		"atom", "self", "simpleCall", "list_construct", "form_construct", "form_contents", 
		"lambda", "lambda_full", "lambda_no_param", "lambda_no_return", "lambda_no_param_no_return", 
		"lambda_parameters", "lambda_block", "literal", "html", "xml", "url", 
		"date", "jid", "loc", "stringLiteral", "shortStringLiteral", "integral", 
		"real", "diceKind", "unitName", "simpleName"
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
		public Section_elementContext section_element(int i) {
			return getRuleContext(Section_elementContext.class,i);
		}
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<Section_elementContext> section_element() {
			return getRuleContexts(Section_elementContext.class);
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
			setState(202); header();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (9 - 9)) | (1L << (16 - 9)) | (1L << (29 - 9)) | (1L << (31 - 9)) | (1L << (41 - 9)) | (1L << (UNIT_NAME - 9)) | (1L << (NAME - 9)))) != 0)) {
				{
				{
				setState(203); section_element();
				}
				}
				setState(208);
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
		public List<AuthorContext> author() {
			return getRuleContexts(AuthorContext.class);
		}
		public List<HistoryContext> history() {
			return getRuleContexts(HistoryContext.class);
		}
		public List<Import_otherContext> import_other() {
			return getRuleContexts(Import_otherContext.class);
		}
		public Import_otherContext import_other(int i) {
			return getRuleContext(Import_otherContext.class,i);
		}
		public DocinfoContext docinfo() {
			return getRuleContext(DocinfoContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public HistoryContext history(int i) {
			return getRuleContext(HistoryContext.class,i);
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
			setState(210);
			_la = _input.LA(1);
			if (_la==61) {
				{
				setState(209); docinfo();
				}
			}

			setState(213);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(212); description();
				}
			}

			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==39) {
				{
				{
				setState(215); author();
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==53) {
				{
				{
				setState(221); history();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==66) {
				{
				{
				setState(227); import_other();
				}
				}
				setState(232);
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
			setState(233); match(61);
			setState(234); match(7);
			setState(245);
			switch (_input.LA(1)) {
			case 3:
				{
				{
				setState(235); encoding();
				setState(238);
				_la = _input.LA(1);
				if (_la==19) {
					{
					setState(236); match(19);
					setState(237); version();
					}
				}

				}
				}
				break;
			case 11:
				{
				{
				setState(240); version();
				setState(243);
				_la = _input.LA(1);
				if (_la==19) {
					{
					setState(241); match(19);
					setState(242); encoding();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(247); match(40);
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
		public ShortStringLiteralContext shortStringLiteral() {
			return getRuleContext(ShortStringLiteralContext.class,0);
		}
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
			setState(249); match(3);
			setState(250); match(8);
			setState(251); shortStringLiteral();
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
			setState(253); match(11);
			setState(254); match(8);
			setState(255); url();
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
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public ShortStringLiteralContext shortStringLiteral() {
			return getRuleContext(ShortStringLiteralContext.class,0);
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
			setState(257); match(25);
			setState(258); match(15);
			setState(259); shortStringLiteral();
			setState(260); match(64);
			setState(261); match(7);
			setState(264);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(262); stringLiteral();
				}
				break;

			case 2:
				{
				setState(263); html();
				}
				break;
			}
			setState(266); match(40);
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
		public List<JidContext> jid() {
			return getRuleContexts(JidContext.class);
		}
		public JidContext jid(int i) {
			return getRuleContext(JidContext.class,i);
		}
		public UrlContext url(int i) {
			return getRuleContext(UrlContext.class,i);
		}
		public ShortStringLiteralContext shortStringLiteral() {
			return getRuleContext(ShortStringLiteralContext.class,0);
		}
		public List<UrlContext> url() {
			return getRuleContexts(UrlContext.class);
		}
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
			setState(268); match(39);
			setState(269); match(15);
			setState(270); shortStringLiteral();
			setState(271); match(64);
			setState(272); match(7);
			{
			setState(275);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(273); jid();
				}
				break;

			case 2:
				{
				setState(274); url();
				}
				break;
			}
			setState(285);
			_la = _input.LA(1);
			if (_la==19) {
				{
				setState(277); match(19);
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NORMALSTRING || _la==CHARSTRING) {
					{
					setState(280);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						setState(278); jid();
						}
						break;

					case 2:
						{
						setState(279); url();
						}
						break;
					}
					}
					setState(284);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
			setState(287); match(40);
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
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public ShortStringLiteralContext shortStringLiteral() {
			return getRuleContext(ShortStringLiteralContext.class,0);
		}
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
			setState(289); match(53);
			setState(290); match(15);
			setState(291); date();
			setState(292); match(64);
			setState(293); match(7);
			setState(294); match(6);
			setState(295); match(8);
			setState(296); shortStringLiteral();
			setState(297); match(19);
			setState(298); match(25);
			setState(299); match(8);
			setState(300); stringLiteral();
			setState(301); match(40);
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
			setState(303); match(66);
			setState(304); url();
			setState(305); match(36);
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
		public List<Private_section_elementContext> private_section_element() {
			return getRuleContexts(Private_section_elementContext.class);
		}
		public Section_elementContext section_element(int i) {
			return getRuleContext(Section_elementContext.class,i);
		}
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public Private_section_elementContext private_section_element(int i) {
			return getRuleContext(Private_section_elementContext.class,i);
		}
		public List<Section_elementContext> section_element() {
			return getRuleContexts(Section_elementContext.class);
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
			setState(307); match(16);
			setState(308); qName();
			setState(309); match(7);
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 9) | (1L << 16) | (1L << 29) | (1L << 31) | (1L << 41))) != 0) || _la==UNIT_NAME || _la==NAME) {
				{
				setState(312);
				switch (_input.LA(1)) {
				case 2:
					{
					setState(310); private_section_element();
					}
					break;
				case 9:
				case 16:
				case 29:
				case 31:
				case 41:
				case UNIT_NAME:
				case NAME:
					{
					setState(311); section_element();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317); match(40);
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
			setState(319); match(2);
			setState(320); section_element();
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
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
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
			setState(324);
			switch (_input.LA(1)) {
			case 16:
				enterOuterAlt(_localctx, 1);
				{
				setState(322); section();
				}
				break;
			case 9:
			case 29:
			case 31:
			case 41:
			case UNIT_NAME:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(323); definition();
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
		public List<SimpleNameContext> simpleName() {
			return getRuleContexts(SimpleNameContext.class);
		}
		public SimpleNameContext simpleName(int i) {
			return getRuleContext(SimpleNameContext.class,i);
		}
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
			setState(326); simpleName();
			setState(331);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(327); match(47);
					setState(328); simpleName();
					}
					} 
				}
				setState(333);
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
		public Type_defContext type_def() {
			return getRuleContext(Type_defContext.class,0);
		}
		public Rule_defContext rule_def() {
			return getRuleContext(Rule_defContext.class,0);
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
			setState(338);
			switch (_input.LA(1)) {
			case 31:
			case 41:
			case UNIT_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(334); type_def();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(335); var_def();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 3);
				{
				setState(336); function_def();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 4);
				{
				setState(337); rule_def();
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
		public Unit_defContext unit_def() {
			return getRuleContext(Unit_defContext.class,0);
		}
		public Enum_defContext enum_def() {
			return getRuleContext(Enum_defContext.class,0);
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
			setState(343);
			switch (_input.LA(1)) {
			case 41:
				enterOuterAlt(_localctx, 1);
				{
				setState(340); enum_def();
				}
				break;
			case UNIT_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(341); unit_def();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 3);
				{
				setState(342); form_def();
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
		public Extends_fromContext extends_from() {
			return getRuleContext(Extends_fromContext.class,0);
		}
		public List<Enum_elemContext> enum_elem() {
			return getRuleContexts(Enum_elemContext.class);
		}
		public Enum_elemContext enum_elem(int i) {
			return getRuleContext(Enum_elemContext.class,i);
		}
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
		}
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
			setState(345); match(41);
			setState(346); simpleName();
			setState(348);
			_la = _input.LA(1);
			if (_la==38) {
				{
				setState(347); extends_from();
				}
			}

			setState(350); match(7);
			setState(352); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(351); enum_elem();
				}
				}
				setState(354); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
			setState(356); match(40);
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

	public static class Extends_fromContext extends ParserRuleContext {
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public Extends_fromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extends_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterExtends_from(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitExtends_from(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitExtends_from(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Extends_fromContext extends_from() throws RecognitionException {
		Extends_fromContext _localctx = new Extends_fromContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_extends_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358); match(38);
			setState(359); qName();
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
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
		}
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
		enterRule(_localctx, 34, RULE_enum_elem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361); simpleName();
			setState(373);
			switch (_input.LA(1)) {
			case 7:
				{
				{
				setState(362); match(7);
				setState(363); enum_field();
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(364); enum_field();
					}
					}
					setState(369);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(370); match(40);
				}
				}
				break;
			case 36:
				{
				setState(372); match(36);
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
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
		}
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
		enterRule(_localctx, 36, RULE_enum_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375); simpleName();
			setState(376); match(8);
			setState(377); expression();
			setState(378); match(36);
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
		public IntegralContext integral() {
			return getRuleContext(IntegralContext.class,0);
		}
		public List<UnitNameContext> unitName() {
			return getRuleContexts(UnitNameContext.class);
		}
		public UnitNameContext unitName(int i) {
			return getRuleContext(UnitNameContext.class,i);
		}
		public RealContext real() {
			return getRuleContext(RealContext.class,0);
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
		enterRule(_localctx, 38, RULE_unit_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380); unitName();
			setState(381); match(8);
			setState(384);
			switch (_input.LA(1)) {
			case INT:
			case HEX:
				{
				setState(382); integral();
				}
				break;
			case FLOAT:
			case HEX_FLOAT:
				{
				setState(383); real();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(387);
			_la = _input.LA(1);
			if (_la==UNIT_NAME) {
				{
				setState(386); unitName();
				}
			}

			setState(389); match(36);
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
		public Extends_fromContext extends_from() {
			return getRuleContext(Extends_fromContext.class,0);
		}
		public Form_cont_defContext form_cont_def() {
			return getRuleContext(Form_cont_defContext.class,0);
		}
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
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
		enterRule(_localctx, 40, RULE_form_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391); match(31);
			setState(392); simpleName();
			setState(394);
			_la = _input.LA(1);
			if (_la==38) {
				{
				setState(393); extends_from();
				}
			}

			setState(396); form_cont_def();
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

	public static class Form_cont_defContext extends ParserRuleContext {
		public Private_member_defContext private_member_def(int i) {
			return getRuleContext(Private_member_defContext.class,i);
		}
		public Member_defContext member_def(int i) {
			return getRuleContext(Member_defContext.class,i);
		}
		public List<Private_member_defContext> private_member_def() {
			return getRuleContexts(Private_member_defContext.class);
		}
		public List<Member_defContext> member_def() {
			return getRuleContexts(Member_defContext.class);
		}
		public Form_cont_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form_cont_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterForm_cont_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitForm_cont_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitForm_cont_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Form_cont_defContext form_cont_def() throws RecognitionException {
		Form_cont_defContext _localctx = new Form_cont_defContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_form_cont_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398); match(7);
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 4) | (1L << 9) | (1L << 13) | (1L << 29) | (1L << 31) | (1L << 41))) != 0) || _la==UNIT_NAME || _la==NAME) {
				{
				setState(401);
				switch (_input.LA(1)) {
				case 2:
					{
					setState(399); private_member_def();
					}
					break;
				case 4:
				case 9:
				case 13:
				case 29:
				case 31:
				case 41:
				case UNIT_NAME:
				case NAME:
					{
					setState(400); member_def();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(406); match(40);
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
		enterRule(_localctx, 44, RULE_private_member_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408); match(2);
			setState(409); member_def();
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
		enterRule(_localctx, 46, RULE_member_def);
		try {
			setState(414);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(411); field_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(412); type_def();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(413); member_initializer();
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
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
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
		enterRule(_localctx, 48, RULE_member_initializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_la = _input.LA(1);
			if (_la==13) {
				{
				setState(416); match(13);
				}
			}

			setState(419); initializer();
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

	public static class InitializerContext extends ParserRuleContext {
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public Alter_defContext alter_def() {
			return getRuleContext(Alter_defContext.class,0);
		}
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public Accessor_defContext accessor_def() {
			return getRuleContext(Accessor_defContext.class,0);
		}
		public Rule_defContext rule_def() {
			return getRuleContext(Rule_defContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_initializer);
		try {
			setState(426);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(421); var_def();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(422); accessor_def();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(423); alter_def();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(424); rule_def();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(425); function_def();
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

	public static class Field_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
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
		enterRule(_localctx, 52, RULE_field_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428); type_spec();
			setState(429); match(36);
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
		enterRule(_localctx, 54, RULE_type_expr);
		try {
			setState(433);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(431); qName();
				}
				break;
			case 10:
			case 12:
			case 14:
			case 17:
			case 20:
			case 21:
			case 26:
			case 27:
			case 28:
			case 33:
			case 35:
			case 37:
			case 45:
			case 59:
			case 67:
				enterOuterAlt(_localctx, 2);
				{
				setState(432); builtin_type_expr();
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
		public Lambda_typeContext lambda_type() {
			return getRuleContext(Lambda_typeContext.class,0);
		}
		public Unit_typeContext unit_type() {
			return getRuleContext(Unit_typeContext.class,0);
		}
		public Builtin_typeContext builtin_type() {
			return getRuleContext(Builtin_typeContext.class,0);
		}
		public Range_typeContext range_type() {
			return getRuleContext(Range_typeContext.class,0);
		}
		public List_typeContext list_type() {
			return getRuleContext(List_typeContext.class,0);
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
		enterRule(_localctx, 56, RULE_builtin_type_expr);
		try {
			setState(440);
			switch (_input.LA(1)) {
			case 12:
			case 14:
			case 17:
			case 20:
			case 26:
			case 28:
			case 33:
			case 35:
			case 45:
			case 59:
			case 67:
				enterOuterAlt(_localctx, 1);
				{
				setState(435); builtin_type();
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 2);
				{
				setState(436); list_type();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 3);
				{
				setState(437); unit_type();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 4);
				{
				setState(438); range_type();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 5);
				{
				setState(439); lambda_type();
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
		public Lambda_type_fullContext lambda_type_full() {
			return getRuleContext(Lambda_type_fullContext.class,0);
		}
		public Lambda_type_no_paramContext lambda_type_no_param() {
			return getRuleContext(Lambda_type_no_paramContext.class,0);
		}
		public Lambda_type_no_returnContext lambda_type_no_return() {
			return getRuleContext(Lambda_type_no_returnContext.class,0);
		}
		public Lambda_type_no_param_no_returnContext lambda_type_no_param_no_return() {
			return getRuleContext(Lambda_type_no_param_no_returnContext.class,0);
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
		enterRule(_localctx, 58, RULE_lambda_type);
		try {
			setState(446);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(442); lambda_type_full();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(443); lambda_type_no_param();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(444); lambda_type_no_return();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(445); lambda_type_no_param_no_return();
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

	public static class Lambda_type_fullContext extends ParserRuleContext {
		public Lambda_type_parametersContext lambda_type_parameters() {
			return getRuleContext(Lambda_type_parametersContext.class,0);
		}
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public Lambda_type_fullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_type_full; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_type_full(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_type_full(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_type_full(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_type_fullContext lambda_type_full() throws RecognitionException {
		Lambda_type_fullContext _localctx = new Lambda_type_fullContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_lambda_type_full);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448); match(27);
			setState(449); match(24);
			setState(450); lambda_type_parameters();
			setState(451); match(49);
			setState(452); type_expr();
			setState(453); match(57);
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

	public static class Lambda_type_no_paramContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public Lambda_type_no_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_type_no_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_type_no_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_type_no_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_type_no_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_type_no_paramContext lambda_type_no_param() throws RecognitionException {
		Lambda_type_no_paramContext _localctx = new Lambda_type_no_paramContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_lambda_type_no_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455); match(27);
			setState(456); match(24);
			setState(457); match(49);
			setState(458); type_expr();
			setState(459); match(57);
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

	public static class Lambda_type_no_returnContext extends ParserRuleContext {
		public Lambda_type_parametersContext lambda_type_parameters() {
			return getRuleContext(Lambda_type_parametersContext.class,0);
		}
		public Lambda_type_no_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_type_no_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_type_no_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_type_no_return(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_type_no_return(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_type_no_returnContext lambda_type_no_return() throws RecognitionException {
		Lambda_type_no_returnContext _localctx = new Lambda_type_no_returnContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_lambda_type_no_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461); match(27);
			setState(462); match(24);
			setState(463); lambda_type_parameters();
			setState(464); match(57);
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

	public static class Lambda_type_no_param_no_returnContext extends ParserRuleContext {
		public Lambda_type_no_param_no_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_type_no_param_no_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_type_no_param_no_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_type_no_param_no_return(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_type_no_param_no_return(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_type_no_param_no_returnContext lambda_type_no_param_no_return() throws RecognitionException {
		Lambda_type_no_param_no_returnContext _localctx = new Lambda_type_no_param_no_returnContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_lambda_type_no_param_no_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466); match(27);
			setState(467); match(24);
			setState(468); match(57);
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

	public static class Lambda_type_parametersContext extends ParserRuleContext {
		public List<Type_exprContext> type_expr() {
			return getRuleContexts(Type_exprContext.class);
		}
		public Type_exprContext type_expr(int i) {
			return getRuleContext(Type_exprContext.class,i);
		}
		public Lambda_type_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_type_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_type_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_type_parameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_type_parameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_type_parametersContext lambda_type_parameters() throws RecognitionException {
		Lambda_type_parametersContext _localctx = new Lambda_type_parametersContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_lambda_type_parameters);
		int _la;
		try {
			setState(483);
			switch (_input.LA(1)) {
			case 15:
				enterOuterAlt(_localctx, 1);
				{
				setState(470); match(15);
				setState(479);
				_la = _input.LA(1);
				if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (10 - 10)) | (1L << (12 - 10)) | (1L << (14 - 10)) | (1L << (17 - 10)) | (1L << (20 - 10)) | (1L << (21 - 10)) | (1L << (26 - 10)) | (1L << (27 - 10)) | (1L << (28 - 10)) | (1L << (33 - 10)) | (1L << (35 - 10)) | (1L << (37 - 10)) | (1L << (45 - 10)) | (1L << (59 - 10)) | (1L << (67 - 10)) | (1L << (NAME - 10)))) != 0)) {
					{
					setState(471); type_expr();
					setState(476);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==19) {
						{
						{
						setState(472); match(19);
						setState(473); type_expr();
						}
						}
						setState(478);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(481); match(64);
				}
				break;
			case 10:
			case 12:
			case 14:
			case 17:
			case 20:
			case 21:
			case 26:
			case 27:
			case 28:
			case 33:
			case 35:
			case 37:
			case 45:
			case 59:
			case 67:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(482); type_expr();
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

	public static class List_typeContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
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
		enterRule(_localctx, 70, RULE_list_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485); match(37);
			setState(486); match(24);
			setState(487); type_expr();
			setState(488); match(57);
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
		public UnitNameContext unitName() {
			return getRuleContext(UnitNameContext.class,0);
		}
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
		enterRule(_localctx, 72, RULE_unit_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490); match(10);
			setState(491); unitName();
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
		enterRule(_localctx, 74, RULE_range_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493); match(21);
			setState(494); match(24);
			setState(495); arithmetic_type();
			setState(496); match(57);
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
		public Textual_typeContext textual_type() {
			return getRuleContext(Textual_typeContext.class,0);
		}
		public Arithmetic_typeContext arithmetic_type() {
			return getRuleContext(Arithmetic_typeContext.class,0);
		}
		public Trpg_typeContext trpg_type() {
			return getRuleContext(Trpg_typeContext.class,0);
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
		enterRule(_localctx, 76, RULE_builtin_type);
		try {
			setState(501);
			switch (_input.LA(1)) {
			case 14:
			case 35:
			case 67:
				enterOuterAlt(_localctx, 1);
				{
				setState(498); arithmetic_type();
				}
				break;
			case 12:
			case 17:
			case 26:
			case 28:
			case 33:
			case 59:
				enterOuterAlt(_localctx, 2);
				{
				setState(499); textual_type();
				}
				break;
			case 20:
			case 45:
				enterOuterAlt(_localctx, 3);
				{
				setState(500); trpg_type();
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

	public static class Textual_typeContext extends ParserRuleContext {
		public Textual_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textual_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterTextual_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitTextual_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitTextual_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Textual_typeContext textual_type() throws RecognitionException {
		Textual_typeContext _localctx = new Textual_typeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_textual_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 17) | (1L << 26) | (1L << 28) | (1L << 33) | (1L << 59))) != 0)) ) {
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

	public static class Trpg_typeContext extends ParserRuleContext {
		public Trpg_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trpg_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterTrpg_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitTrpg_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitTrpg_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trpg_typeContext trpg_type() throws RecognitionException {
		Trpg_typeContext _localctx = new Trpg_typeContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_trpg_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			_la = _input.LA(1);
			if ( !(_la==20 || _la==45) ) {
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
		enterRule(_localctx, 82, RULE_arithmetic_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			_la = _input.LA(1);
			if ( !(((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (14 - 14)) | (1L << (35 - 14)) | (1L << (67 - 14)))) != 0)) ) {
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
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
		enterRule(_localctx, 84, RULE_rule_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509); match(9);
			setState(510); simpleName();
			setState(512);
			_la = _input.LA(1);
			if (_la==15 || _la==43) {
				{
				setState(511); parameters();
				}
			}

			setState(514); block();
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
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
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
		enterRule(_localctx, 86, RULE_function_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516); match(29);
			setState(517); simpleName();
			setState(519);
			_la = _input.LA(1);
			if (_la==15 || _la==43) {
				{
				setState(518); parameters();
				}
			}

			setState(521); match(49);
			setState(522); type_expr();
			setState(523); block();
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
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
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
		enterRule(_localctx, 88, RULE_accessor_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525); simpleName();
			setState(527);
			_la = _input.LA(1);
			if (_la==15 || _la==43) {
				{
				setState(526); parameters();
				}
			}

			setState(529); match(49);
			setState(530); type_expr();
			setState(531); block();
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
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
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
		enterRule(_localctx, 90, RULE_alter_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533); match(4);
			setState(534); simpleName();
			setState(535); match(15);
			setState(536); type_spec();
			setState(537); match(64);
			setState(538); block();
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
		public List<Type_specContext> type_spec() {
			return getRuleContexts(Type_specContext.class);
		}
		public Type_specContext type_spec(int i) {
			return getRuleContext(Type_specContext.class,i);
		}
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
		enterRule(_localctx, 92, RULE_parameters);
		int _la;
		try {
			setState(552);
			switch (_input.LA(1)) {
			case 15:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(540); match(15);
				setState(541); type_spec();
				setState(546);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==19) {
					{
					{
					setState(542); match(19);
					setState(543); type_spec();
					}
					}
					setState(548);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(549); match(64);
				}
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 2);
				{
				setState(551); match(43);
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

	public static class Type_specContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
		}
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitType_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitType_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_type_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554); simpleName();
			setState(555); match(52);
			setState(556); type_expr();
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
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
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
		enterRule(_localctx, 96, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558); match(7);
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 17) | (1L << 20) | (1L << 21) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 29) | (1L << 31) | (1L << 33) | (1L << 35) | (1L << 37) | (1L << 41) | (1L << 45) | (1L << 50) | (1L << 56) | (1L << 59) | (1L << 63))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (67 - 67)) | (1L << (UNIT_NAME - 67)) | (1L << (NAME - 67)) | (1L << (NORMALSTRING - 67)) | (1L << (CHARSTRING - 67)) | (1L << (LONGSTRING - 67)) | (1L << (INT - 67)) | (1L << (HEX - 67)) | (1L << (FLOAT - 67)) | (1L << (HEX_FLOAT - 67)))) != 0)) {
				{
				{
				setState(559); statement();
				}
				}
				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(565); match(40);
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
		public Result_statementContext result_statement() {
			return getRuleContext(Result_statementContext.class,0);
		}
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public Select_statementContext select_statement() {
			return getRuleContext(Select_statementContext.class,0);
		}
		public Field_modifyContext field_modify() {
			return getRuleContext(Field_modifyContext.class,0);
		}
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public Type_defContext type_def() {
			return getRuleContext(Type_defContext.class,0);
		}
		public Procedure_applyContext procedure_apply() {
			return getRuleContext(Procedure_applyContext.class,0);
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
		enterRule(_localctx, 98, RULE_statement);
		try {
			setState(574);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(567); var_def();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(568); field_modify();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(569); function_def();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(570); type_def();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(571); procedure_apply();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(572); select_statement();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(573); result_statement();
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
		enterRule(_localctx, 100, RULE_procedure_apply);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576); monomial();
			setState(577); match(36);
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
		enterRule(_localctx, 102, RULE_select_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579); select_expr();
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
		enterRule(_localctx, 104, RULE_result_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581); match(50);
			setState(582); match(8);
			setState(584);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 17) | (1L << 20) | (1L << 21) | (1L << 26) | (1L << 27) | (1L << 28) | (1L << 33) | (1L << 35) | (1L << 37) | (1L << 45) | (1L << 56) | (1L << 58) | (1L << 59) | (1L << 63))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (DICE - 65)) | (1L << (NAME - 65)) | (1L << (NORMALSTRING - 65)) | (1L << (CHARSTRING - 65)) | (1L << (LONGSTRING - 65)) | (1L << (INT - 65)) | (1L << (HEX - 65)) | (1L << (FLOAT - 65)) | (1L << (HEX_FLOAT - 65)))) != 0)) {
				{
				setState(583); expression();
				}
			}

			setState(586); match(36);
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
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
		}
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
		enterRule(_localctx, 106, RULE_var_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588); simpleName();
			setState(589); match(8);
			setState(590); expression();
			setState(591); match(36);
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
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
		}
		public SelfContext self() {
			return getRuleContext(SelfContext.class,0);
		}
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
		enterRule(_localctx, 108, RULE_field_modify);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593); self();
			setState(594); match(47);
			setState(595); simpleName();
			setState(596); match(8);
			setState(597); expression();
			setState(598); match(36);
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
		public Select_exprContext select_expr() {
			return getRuleContext(Select_exprContext.class,0);
		}
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
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
		enterRule(_localctx, 110, RULE_expression);
		try {
			setState(605);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(600); terms();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(601); range();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(602); condition();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(603); select_expr();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(604); lambda();
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
		public Case_blockContext case_block() {
			return getRuleContext(Case_blockContext.class,0);
		}
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
		enterRule(_localctx, 112, RULE_select_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607); match(56);
			setState(608); match(15);
			setState(609); expression();
			setState(610); match(64);
			setState(611); match(7);
			setState(622);
			switch (_input.LA(1)) {
			case 48:
				{
				setState(613); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(612); case_block();
					}
					}
					setState(615); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==48 );
				}
				break;
			case 34:
				{
				setState(618); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(617); as_block();
					}
					}
					setState(620); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==34 );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(625);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(624); default_block();
				}
			}

			setState(627); match(40);
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
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 114, RULE_case_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629); match(48);
			setState(630); match(15);
			setState(633);
			switch (_input.LA(1)) {
			case NORMALSTRING:
			case CHARSTRING:
			case LONGSTRING:
			case INT:
			case HEX:
			case FLOAT:
			case HEX_FLOAT:
				{
				setState(631); literal();
				}
				break;
			case NAME:
				{
				setState(632); qName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(635); match(64);
			setState(636); block();
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
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
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
		enterRule(_localctx, 116, RULE_as_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638); match(34);
			setState(639); match(15);
			setState(640); type_spec();
			setState(641); match(64);
			setState(642); block();
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
		enterRule(_localctx, 118, RULE_default_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644); match(1);
			setState(645); block();
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
		enterRule(_localctx, 120, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647); terms();
			setState(648);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 23) | (1L << 51) | (1L << 62))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(649); terms();
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
		enterRule(_localctx, 122, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651); cond_term();
			setState(654);
			_la = _input.LA(1);
			if (_la==44 || _la==55) {
				{
				setState(652);
				_la = _input.LA(1);
				if ( !(_la==44 || _la==55) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(653); cond_term();
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
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public Cond_monomialContext cond_monomial() {
			return getRuleContext(Cond_monomialContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
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
		enterRule(_localctx, 124, RULE_cond_term);
		try {
			setState(662);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(656); cond_monomial();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(657); relation();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(658); match(15);
				setState(659); condition();
				setState(660); match(64);
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
		enterRule(_localctx, 126, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664); terms();
			setState(665);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 22) | (1L << 24) | (1L << 42) | (1L << 54) | (1L << 57))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(666); terms();
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
		enterRule(_localctx, 128, RULE_cond_monomial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			_la = _input.LA(1);
			if (_la==58) {
				{
				setState(668); match(58);
				}
			}

			setState(671); monomial();
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
		enterRule(_localctx, 130, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673); term();
			setState(678);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==30 || _la==65) {
				{
				{
				setState(674);
				_la = _input.LA(1);
				if ( !(_la==30 || _la==65) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(675); term();
				}
				}
				setState(680);
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
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
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
		enterRule(_localctx, 132, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681); factor();
			setState(686);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 32) | (1L << 46) | (1L << 60))) != 0)) {
				{
				{
				setState(682);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 32) | (1L << 46) | (1L << 60))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(683); factor();
				}
				}
				setState(688);
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
		enterRule(_localctx, 134, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			_la = _input.LA(1);
			if (_la==65) {
				{
				setState(689); match(65);
				}
			}

			setState(692); post_op();
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
		public MonomialContext monomial() {
			return getRuleContext(MonomialContext.class,0);
		}
		public Dice_monomialContext dice_monomial() {
			return getRuleContext(Dice_monomialContext.class,0);
		}
		public Unit_monomialContext unit_monomial() {
			return getRuleContext(Unit_monomialContext.class,0);
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
		enterRule(_localctx, 136, RULE_post_op);
		try {
			setState(697);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(694); monomial();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(695); unit_monomial();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(696); dice_monomial();
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

	public static class Unit_monomialContext extends ParserRuleContext {
		public UnitNameContext unitName() {
			return getRuleContext(UnitNameContext.class,0);
		}
		public MonomialContext monomial() {
			return getRuleContext(MonomialContext.class,0);
		}
		public Unit_monomialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit_monomial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterUnit_monomial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitUnit_monomial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitUnit_monomial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unit_monomialContext unit_monomial() throws RecognitionException {
		Unit_monomialContext _localctx = new Unit_monomialContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_unit_monomial);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699); monomial();
			setState(700); unitName();
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

	public static class Dice_monomialContext extends ParserRuleContext {
		public DiceKindContext diceKind() {
			return getRuleContext(DiceKindContext.class,0);
		}
		public MonomialContext monomial() {
			return getRuleContext(MonomialContext.class,0);
		}
		public Dice_monomialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dice_monomial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterDice_monomial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitDice_monomial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitDice_monomial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dice_monomialContext dice_monomial() throws RecognitionException {
		Dice_monomialContext _localctx = new Dice_monomialContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_dice_monomial);
		try {
			setState(706);
			switch (_input.LA(1)) {
			case 7:
			case 10:
			case 12:
			case 14:
			case 15:
			case 17:
			case 20:
			case 21:
			case 26:
			case 27:
			case 28:
			case 33:
			case 35:
			case 37:
			case 45:
			case 59:
			case 63:
			case 67:
			case NAME:
			case NORMALSTRING:
			case CHARSTRING:
			case LONGSTRING:
			case INT:
			case HEX:
			case FLOAT:
			case HEX_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(702); monomial();
				setState(703); diceKind();
				}
				break;
			case DICE:
				enterOuterAlt(_localctx, 2);
				{
				setState(705); diceKind();
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
		enterRule(_localctx, 142, RULE_monomial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708); atom();
			setState(712);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==47) {
				{
				{
				setState(709); member_access();
				}
				}
				setState(714);
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
		public SimpleNameContext simpleName() {
			return getRuleContext(SimpleNameContext.class,0);
		}
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
		enterRule(_localctx, 144, RULE_member_access);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715); match(47);
			setState(716); simpleName();
			setState(718);
			_la = _input.LA(1);
			if (_la==15) {
				{
				setState(717); args();
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
		enterRule(_localctx, 146, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720); match(15);
			setState(721); expression();
			setState(726);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==19) {
				{
				{
				setState(722); match(19);
				setState(723); expression();
				}
				}
				setState(728);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(729); match(64);
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
		public Form_constructContext form_construct() {
			return getRuleContext(Form_constructContext.class,0);
		}
		public List_constructContext list_construct() {
			return getRuleContext(List_constructContext.class,0);
		}
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public SimpleCallContext simpleCall() {
			return getRuleContext(SimpleCallContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Builtin_type_exprContext builtin_type_expr() {
			return getRuleContext(Builtin_type_exprContext.class,0);
		}
		public SelfContext self() {
			return getRuleContext(SelfContext.class,0);
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
		enterRule(_localctx, 148, RULE_atom);
		try {
			setState(742);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(731); self();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(732); qName();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(733); simpleCall();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(734); literal();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(735); match(15);
				setState(736); expression();
				setState(737); match(64);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(739); list_construct();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(740); form_construct();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(741); builtin_type_expr();
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

	public static class SelfContext extends ParserRuleContext {
		public SelfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_self; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterSelf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitSelf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitSelf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfContext self() throws RecognitionException {
		SelfContext _localctx = new SelfContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_self);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(744); match(63);
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

	public static class SimpleCallContext extends ParserRuleContext {
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public SimpleCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterSimpleCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitSimpleCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitSimpleCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleCallContext simpleCall() throws RecognitionException {
		SimpleCallContext _localctx = new SimpleCallContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_simpleCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746); qName();
			setState(747); args();
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
		enterRule(_localctx, 154, RULE_list_construct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(749); match(7);
			setState(750); expression();
			setState(755);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==19) {
				{
				{
				setState(751); match(19);
				setState(752); expression();
				}
				}
				setState(757);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(758); match(40);
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

	public static class Form_constructContext extends ParserRuleContext {
		public Form_contentsContext form_contents() {
			return getRuleContext(Form_contentsContext.class,0);
		}
		public QNameContext qName() {
			return getRuleContext(QNameContext.class,0);
		}
		public Form_constructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form_construct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterForm_construct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitForm_construct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitForm_construct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Form_constructContext form_construct() throws RecognitionException {
		Form_constructContext _localctx = new Form_constructContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_form_construct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760); form_contents();
			setState(763);
			_la = _input.LA(1);
			if (_la==52) {
				{
				setState(761); match(52);
				setState(762); qName();
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

	public static class Form_contentsContext extends ParserRuleContext {
		public List<Member_initializerContext> member_initializer() {
			return getRuleContexts(Member_initializerContext.class);
		}
		public Member_initializerContext member_initializer(int i) {
			return getRuleContext(Member_initializerContext.class,i);
		}
		public Form_contentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form_contents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterForm_contents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitForm_contents(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitForm_contents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Form_contentsContext form_contents() throws RecognitionException {
		Form_contentsContext _localctx = new Form_contentsContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_form_contents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(765); match(7);
			setState(767); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(766); member_initializer();
				}
				}
				setState(769); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 9) | (1L << 13) | (1L << 29))) != 0) || _la==NAME );
			setState(771); match(40);
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
		public Lambda_fullContext lambda_full() {
			return getRuleContext(Lambda_fullContext.class,0);
		}
		public Lambda_no_param_no_returnContext lambda_no_param_no_return() {
			return getRuleContext(Lambda_no_param_no_returnContext.class,0);
		}
		public Lambda_no_returnContext lambda_no_return() {
			return getRuleContext(Lambda_no_returnContext.class,0);
		}
		public Lambda_no_paramContext lambda_no_param() {
			return getRuleContext(Lambda_no_paramContext.class,0);
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
		enterRule(_localctx, 160, RULE_lambda);
		try {
			setState(777);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(773); lambda_full();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(774); lambda_no_param();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(775); lambda_no_return();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(776); lambda_no_param_no_return();
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

	public static class Lambda_fullContext extends ParserRuleContext {
		public Lambda_parametersContext lambda_parameters() {
			return getRuleContext(Lambda_parametersContext.class,0);
		}
		public Lambda_blockContext lambda_block() {
			return getRuleContext(Lambda_blockContext.class,0);
		}
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public Lambda_fullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_full; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_full(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_full(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_full(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_fullContext lambda_full() throws RecognitionException {
		Lambda_fullContext _localctx = new Lambda_fullContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_lambda_full);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779); match(27);
			setState(780); lambda_parameters();
			setState(781); match(49);
			setState(782); type_expr();
			setState(783); lambda_block();
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

	public static class Lambda_no_paramContext extends ParserRuleContext {
		public Lambda_blockContext lambda_block() {
			return getRuleContext(Lambda_blockContext.class,0);
		}
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public Lambda_no_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_no_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_no_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_no_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_no_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_no_paramContext lambda_no_param() throws RecognitionException {
		Lambda_no_paramContext _localctx = new Lambda_no_paramContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_lambda_no_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(785); match(27);
			setState(788);
			_la = _input.LA(1);
			if (_la==15) {
				{
				setState(786); match(15);
				setState(787); match(64);
				}
			}

			setState(790); match(49);
			setState(791); type_expr();
			setState(792); lambda_block();
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

	public static class Lambda_no_returnContext extends ParserRuleContext {
		public Lambda_parametersContext lambda_parameters() {
			return getRuleContext(Lambda_parametersContext.class,0);
		}
		public Lambda_blockContext lambda_block() {
			return getRuleContext(Lambda_blockContext.class,0);
		}
		public Lambda_no_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_no_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_no_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_no_return(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_no_return(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_no_returnContext lambda_no_return() throws RecognitionException {
		Lambda_no_returnContext _localctx = new Lambda_no_returnContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_lambda_no_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794); match(27);
			setState(795); lambda_parameters();
			setState(796); lambda_block();
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

	public static class Lambda_no_param_no_returnContext extends ParserRuleContext {
		public Lambda_blockContext lambda_block() {
			return getRuleContext(Lambda_blockContext.class,0);
		}
		public Lambda_no_param_no_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_no_param_no_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_no_param_no_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_no_param_no_return(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_no_param_no_return(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_no_param_no_returnContext lambda_no_param_no_return() throws RecognitionException {
		Lambda_no_param_no_returnContext _localctx = new Lambda_no_param_no_returnContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_lambda_no_param_no_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798); match(27);
			setState(801);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(799); match(15);
				setState(800); match(64);
				}
				break;
			}
			setState(803); lambda_block();
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

	public static class Lambda_parametersContext extends ParserRuleContext {
		public List<Type_specContext> type_spec() {
			return getRuleContexts(Type_specContext.class);
		}
		public Type_specContext type_spec(int i) {
			return getRuleContext(Type_specContext.class,i);
		}
		public Lambda_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_parameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_parameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_parametersContext lambda_parameters() throws RecognitionException {
		Lambda_parametersContext _localctx = new Lambda_parametersContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_lambda_parameters);
		int _la;
		try {
			setState(817);
			switch (_input.LA(1)) {
			case 15:
				enterOuterAlt(_localctx, 1);
				{
				setState(805); match(15);
				setState(806); type_spec();
				setState(811);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==19) {
					{
					{
					setState(807); match(19);
					setState(808); type_spec();
					}
					}
					setState(813);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(814); match(64);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(816); type_spec();
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

	public static class Lambda_blockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Lambda_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterLambda_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitLambda_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitLambda_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_blockContext lambda_block() throws RecognitionException {
		Lambda_blockContext _localctx = new Lambda_blockContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_lambda_block);
		try {
			setState(821);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(819); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(820); expression();
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

	public static class LiteralContext extends ParserRuleContext {
		public JidContext jid() {
			return getRuleContext(JidContext.class,0);
		}
		public IntegralContext integral() {
			return getRuleContext(IntegralContext.class,0);
		}
		public RealContext real() {
			return getRuleContext(RealContext.class,0);
		}
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public XmlContext xml() {
			return getRuleContext(XmlContext.class,0);
		}
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
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
		enterRule(_localctx, 174, RULE_literal);
		try {
			setState(832);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(823); integral();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(824); real();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(825); stringLiteral();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(826); html();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(827); xml();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(828); url();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(829); jid();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(830); date();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(831); loc();
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
		enterRule(_localctx, 176, RULE_html);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834); stringLiteral();
			setState(835); match(52);
			setState(836); match(12);
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
		enterRule(_localctx, 178, RULE_xml);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(838); stringLiteral();
			setState(839); match(52);
			setState(840); match(28);
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
		public ShortStringLiteralContext shortStringLiteral() {
			return getRuleContext(ShortStringLiteralContext.class,0);
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
		enterRule(_localctx, 180, RULE_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842); shortStringLiteral();
			setState(843); match(52);
			setState(844); match(17);
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
		public ShortStringLiteralContext shortStringLiteral() {
			return getRuleContext(ShortStringLiteralContext.class,0);
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
		enterRule(_localctx, 182, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(846); shortStringLiteral();
			setState(847); match(52);
			setState(848); match(26);
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
		public ShortStringLiteralContext shortStringLiteral() {
			return getRuleContext(ShortStringLiteralContext.class,0);
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
		enterRule(_localctx, 184, RULE_jid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(850); shortStringLiteral();
			setState(851); match(52);
			setState(852); match(33);
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
		public ShortStringLiteralContext shortStringLiteral() {
			return getRuleContext(ShortStringLiteralContext.class,0);
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
		enterRule(_localctx, 186, RULE_loc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854); shortStringLiteral();
			setState(855); match(52);
			setState(856); match(20);
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
		enterRule(_localctx, 188, RULE_stringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
			_la = _input.LA(1);
			if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (NORMALSTRING - 71)) | (1L << (CHARSTRING - 71)) | (1L << (LONGSTRING - 71)))) != 0)) ) {
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

	public static class ShortStringLiteralContext extends ParserRuleContext {
		public TerminalNode NORMALSTRING() { return getToken(LoreParser.NORMALSTRING, 0); }
		public TerminalNode CHARSTRING() { return getToken(LoreParser.CHARSTRING, 0); }
		public ShortStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterShortStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitShortStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitShortStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortStringLiteralContext shortStringLiteral() throws RecognitionException {
		ShortStringLiteralContext _localctx = new ShortStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_shortStringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			_la = _input.LA(1);
			if ( !(_la==NORMALSTRING || _la==CHARSTRING) ) {
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

	public static class IntegralContext extends ParserRuleContext {
		public TerminalNode HEX() { return getToken(LoreParser.HEX, 0); }
		public TerminalNode INT() { return getToken(LoreParser.INT, 0); }
		public IntegralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterIntegral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitIntegral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitIntegral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegralContext integral() throws RecognitionException {
		IntegralContext _localctx = new IntegralContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_integral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(862);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==HEX) ) {
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

	public static class RealContext extends ParserRuleContext {
		public TerminalNode HEX_FLOAT() { return getToken(LoreParser.HEX_FLOAT, 0); }
		public TerminalNode FLOAT() { return getToken(LoreParser.FLOAT, 0); }
		public RealContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitReal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealContext real() throws RecognitionException {
		RealContext _localctx = new RealContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_real);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(864);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==HEX_FLOAT) ) {
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

	public static class DiceKindContext extends ParserRuleContext {
		public TerminalNode DICE() { return getToken(LoreParser.DICE, 0); }
		public DiceKindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diceKind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterDiceKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitDiceKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitDiceKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DiceKindContext diceKind() throws RecognitionException {
		DiceKindContext _localctx = new DiceKindContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_diceKind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866); match(DICE);
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

	public static class UnitNameContext extends ParserRuleContext {
		public TerminalNode UNIT_NAME() { return getToken(LoreParser.UNIT_NAME, 0); }
		public UnitNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterUnitName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitUnitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitUnitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitNameContext unitName() throws RecognitionException {
		UnitNameContext _localctx = new UnitNameContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_unitName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(868); match(UNIT_NAME);
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

	public static class SimpleNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(LoreParser.NAME, 0); }
		public SimpleNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).enterSimpleName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LoreListener ) ((LoreListener)listener).exitSimpleName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LoreVisitor ) return ((LoreVisitor<? extends T>)visitor).visitSimpleName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleNameContext simpleName() throws RecognitionException {
		SimpleNameContext _localctx = new SimpleNameContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_simpleName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870); match(NAME);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3S\u036b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\3\2\3\2\7\2\u00cf\n\2\f\2\16"+
		"\2\u00d2\13\2\3\3\5\3\u00d5\n\3\3\3\5\3\u00d8\n\3\3\3\7\3\u00db\n\3\f"+
		"\3\16\3\u00de\13\3\3\3\7\3\u00e1\n\3\f\3\16\3\u00e4\13\3\3\3\7\3\u00e7"+
		"\n\3\f\3\16\3\u00ea\13\3\3\4\3\4\3\4\3\4\3\4\5\4\u00f1\n\4\3\4\3\4\3\4"+
		"\5\4\u00f6\n\4\5\4\u00f8\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u010b\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u0116\n\b\3\b\3\b\3\b\7\b\u011b\n\b\f\b\16\b\u011e\13\b\5\b"+
		"\u0120\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\7\13\u013b\n\13\f\13\16"+
		"\13\u013e\13\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\5\r\u0147\n\r\3\16\3\16"+
		"\3\16\7\16\u014c\n\16\f\16\16\16\u014f\13\16\3\17\3\17\3\17\3\17\5\17"+
		"\u0155\n\17\3\20\3\20\3\20\5\20\u015a\n\20\3\21\3\21\3\21\5\21\u015f\n"+
		"\21\3\21\3\21\6\21\u0163\n\21\r\21\16\21\u0164\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\7\23\u0170\n\23\f\23\16\23\u0173\13\23\3\23\3\23"+
		"\3\23\5\23\u0178\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25"+
		"\u0183\n\25\3\25\5\25\u0186\n\25\3\25\3\25\3\26\3\26\3\26\5\26\u018d\n"+
		"\26\3\26\3\26\3\27\3\27\3\27\7\27\u0194\n\27\f\27\16\27\u0197\13\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\5\31\u01a1\n\31\3\32\5\32\u01a4"+
		"\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u01ad\n\33\3\34\3\34\3\34"+
		"\3\35\3\35\5\35\u01b4\n\35\3\36\3\36\3\36\3\36\3\36\5\36\u01bb\n\36\3"+
		"\37\3\37\3\37\3\37\5\37\u01c1\n\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3"+
		"!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\7$\u01dd\n$\f$\16$\u01e0"+
		"\13$\5$\u01e2\n$\3$\3$\5$\u01e6\n$\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\5(\u01f8\n(\3)\3)\3*\3*\3+\3+\3,\3,\3,\5,\u0203\n,\3"+
		",\3,\3-\3-\3-\5-\u020a\n-\3-\3-\3-\3-\3.\3.\5.\u0212\n.\3.\3.\3.\3.\3"+
		"/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\7\60\u0223\n\60\f\60\16\60\u0226"+
		"\13\60\3\60\3\60\3\60\5\60\u022b\n\60\3\61\3\61\3\61\3\61\3\62\3\62\7"+
		"\62\u0233\n\62\f\62\16\62\u0236\13\62\3\62\3\62\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\5\63\u0241\n\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\66"+
		"\5\66\u024b\n\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38"+
		"\38\39\39\39\39\39\59\u0260\n9\3:\3:\3:\3:\3:\3:\6:\u0268\n:\r:\16:\u0269"+
		"\3:\6:\u026d\n:\r:\16:\u026e\5:\u0271\n:\3:\5:\u0274\n:\3:\3:\3;\3;\3"+
		";\3;\5;\u027c\n;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3=\3>\3>\3>\3>\3?\3"+
		"?\3?\5?\u0291\n?\3@\3@\3@\3@\3@\3@\5@\u0299\n@\3A\3A\3A\3A\3B\5B\u02a0"+
		"\nB\3B\3B\3C\3C\3C\7C\u02a7\nC\fC\16C\u02aa\13C\3D\3D\3D\7D\u02af\nD\f"+
		"D\16D\u02b2\13D\3E\5E\u02b5\nE\3E\3E\3F\3F\3F\5F\u02bc\nF\3G\3G\3G\3H"+
		"\3H\3H\3H\5H\u02c5\nH\3I\3I\7I\u02c9\nI\fI\16I\u02cc\13I\3J\3J\3J\5J\u02d1"+
		"\nJ\3K\3K\3K\3K\7K\u02d7\nK\fK\16K\u02da\13K\3K\3K\3L\3L\3L\3L\3L\3L\3"+
		"L\3L\3L\3L\3L\5L\u02e9\nL\3M\3M\3N\3N\3N\3O\3O\3O\3O\7O\u02f4\nO\fO\16"+
		"O\u02f7\13O\3O\3O\3P\3P\3P\5P\u02fe\nP\3Q\3Q\6Q\u0302\nQ\rQ\16Q\u0303"+
		"\3Q\3Q\3R\3R\3R\3R\5R\u030c\nR\3S\3S\3S\3S\3S\3S\3T\3T\3T\5T\u0317\nT"+
		"\3T\3T\3T\3T\3U\3U\3U\3U\3V\3V\3V\5V\u0324\nV\3V\3V\3W\3W\3W\3W\7W\u032c"+
		"\nW\fW\16W\u032f\13W\3W\3W\3W\5W\u0334\nW\3X\3X\5X\u0338\nX\3Y\3Y\3Y\3"+
		"Y\3Y\3Y\3Y\3Y\3Y\5Y\u0343\nY\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3\\\3\\\3\\\3\\\3"+
		"]\3]\3]\3]\3^\3^\3^\3^\3_\3_\3_\3_\3`\3`\3a\3a\3b\3b\3c\3c\3d\3d\3e\3"+
		"e\3f\3f\3f\2g\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8"+
		"\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\2\16\b\2\16\16"+
		"\23\23\34\34\36\36##==\4\2\26\26//\5\2\20\20%%EE\6\2\24\24\31\31\65\65"+
		"@@\4\2..99\b\2\7\7\30\30\32\32,,88;;\4\2  CC\5\2\"\"\60\60>>\3\2IK\3\2"+
		"IJ\3\2LM\3\2NO\u0377\2\u00cc\3\2\2\2\4\u00d4\3\2\2\2\6\u00eb\3\2\2\2\b"+
		"\u00fb\3\2\2\2\n\u00ff\3\2\2\2\f\u0103\3\2\2\2\16\u010e\3\2\2\2\20\u0123"+
		"\3\2\2\2\22\u0131\3\2\2\2\24\u0135\3\2\2\2\26\u0141\3\2\2\2\30\u0146\3"+
		"\2\2\2\32\u0148\3\2\2\2\34\u0154\3\2\2\2\36\u0159\3\2\2\2 \u015b\3\2\2"+
		"\2\"\u0168\3\2\2\2$\u016b\3\2\2\2&\u0179\3\2\2\2(\u017e\3\2\2\2*\u0189"+
		"\3\2\2\2,\u0190\3\2\2\2.\u019a\3\2\2\2\60\u01a0\3\2\2\2\62\u01a3\3\2\2"+
		"\2\64\u01ac\3\2\2\2\66\u01ae\3\2\2\28\u01b3\3\2\2\2:\u01ba\3\2\2\2<\u01c0"+
		"\3\2\2\2>\u01c2\3\2\2\2@\u01c9\3\2\2\2B\u01cf\3\2\2\2D\u01d4\3\2\2\2F"+
		"\u01e5\3\2\2\2H\u01e7\3\2\2\2J\u01ec\3\2\2\2L\u01ef\3\2\2\2N\u01f7\3\2"+
		"\2\2P\u01f9\3\2\2\2R\u01fb\3\2\2\2T\u01fd\3\2\2\2V\u01ff\3\2\2\2X\u0206"+
		"\3\2\2\2Z\u020f\3\2\2\2\\\u0217\3\2\2\2^\u022a\3\2\2\2`\u022c\3\2\2\2"+
		"b\u0230\3\2\2\2d\u0240\3\2\2\2f\u0242\3\2\2\2h\u0245\3\2\2\2j\u0247\3"+
		"\2\2\2l\u024e\3\2\2\2n\u0253\3\2\2\2p\u025f\3\2\2\2r\u0261\3\2\2\2t\u0277"+
		"\3\2\2\2v\u0280\3\2\2\2x\u0286\3\2\2\2z\u0289\3\2\2\2|\u028d\3\2\2\2~"+
		"\u0298\3\2\2\2\u0080\u029a\3\2\2\2\u0082\u029f\3\2\2\2\u0084\u02a3\3\2"+
		"\2\2\u0086\u02ab\3\2\2\2\u0088\u02b4\3\2\2\2\u008a\u02bb\3\2\2\2\u008c"+
		"\u02bd\3\2\2\2\u008e\u02c4\3\2\2\2\u0090\u02c6\3\2\2\2\u0092\u02cd\3\2"+
		"\2\2\u0094\u02d2\3\2\2\2\u0096\u02e8\3\2\2\2\u0098\u02ea\3\2\2\2\u009a"+
		"\u02ec\3\2\2\2\u009c\u02ef\3\2\2\2\u009e\u02fa\3\2\2\2\u00a0\u02ff\3\2"+
		"\2\2\u00a2\u030b\3\2\2\2\u00a4\u030d\3\2\2\2\u00a6\u0313\3\2\2\2\u00a8"+
		"\u031c\3\2\2\2\u00aa\u0320\3\2\2\2\u00ac\u0333\3\2\2\2\u00ae\u0337\3\2"+
		"\2\2\u00b0\u0342\3\2\2\2\u00b2\u0344\3\2\2\2\u00b4\u0348\3\2\2\2\u00b6"+
		"\u034c\3\2\2\2\u00b8\u0350\3\2\2\2\u00ba\u0354\3\2\2\2\u00bc\u0358\3\2"+
		"\2\2\u00be\u035c\3\2\2\2\u00c0\u035e\3\2\2\2\u00c2\u0360\3\2\2\2\u00c4"+
		"\u0362\3\2\2\2\u00c6\u0364\3\2\2\2\u00c8\u0366\3\2\2\2\u00ca\u0368\3\2"+
		"\2\2\u00cc\u00d0\5\4\3\2\u00cd\u00cf\5\30\r\2\u00ce\u00cd\3\2\2\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\3\3\2\2\2"+
		"\u00d2\u00d0\3\2\2\2\u00d3\u00d5\5\6\4\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d8\5\f\7\2\u00d7\u00d6\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00dc\3\2\2\2\u00d9\u00db\5\16\b\2\u00da\u00d9\3"+
		"\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00e2\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e1\5\20\t\2\u00e0\u00df\3"+
		"\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e8\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e7\5\22\n\2\u00e6\u00e5\3"+
		"\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\5\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\7?\2\2\u00ec\u00f7\7\t\2\2"+
		"\u00ed\u00f0\5\b\5\2\u00ee\u00ef\7\25\2\2\u00ef\u00f1\5\n\6\2\u00f0\u00ee"+
		"\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f8\3\2\2\2\u00f2\u00f5\5\n\6\2\u00f3"+
		"\u00f4\7\25\2\2\u00f4\u00f6\5\b\5\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3"+
		"\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00ed\3\2\2\2\u00f7\u00f2\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\u00fa\7*\2\2\u00fa\7\3\2\2\2\u00fb\u00fc\7\5\2\2"+
		"\u00fc\u00fd\7\n\2\2\u00fd\u00fe\5\u00c0a\2\u00fe\t\3\2\2\2\u00ff\u0100"+
		"\7\r\2\2\u0100\u0101\7\n\2\2\u0101\u0102\5\u00b6\\\2\u0102\13\3\2\2\2"+
		"\u0103\u0104\7\33\2\2\u0104\u0105\7\21\2\2\u0105\u0106\5\u00c0a\2\u0106"+
		"\u0107\7B\2\2\u0107\u010a\7\t\2\2\u0108\u010b\5\u00be`\2\u0109\u010b\5"+
		"\u00b2Z\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2"+
		"\u010b\u010c\3\2\2\2\u010c\u010d\7*\2\2\u010d\r\3\2\2\2\u010e\u010f\7"+
		")\2\2\u010f\u0110\7\21\2\2\u0110\u0111\5\u00c0a\2\u0111\u0112\7B\2\2\u0112"+
		"\u0115\7\t\2\2\u0113\u0116\5\u00ba^\2\u0114\u0116\5\u00b6\\\2\u0115\u0113"+
		"\3\2\2\2\u0115\u0114\3\2\2\2\u0116\u011f\3\2\2\2\u0117\u011c\7\25\2\2"+
		"\u0118\u011b\5\u00ba^\2\u0119\u011b\5\u00b6\\\2\u011a\u0118\3\2\2\2\u011a"+
		"\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2"+
		"\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0117\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\7*\2\2\u0122\17\3\2\2\2"+
		"\u0123\u0124\7\67\2\2\u0124\u0125\7\21\2\2\u0125\u0126\5\u00b8]\2\u0126"+
		"\u0127\7B\2\2\u0127\u0128\7\t\2\2\u0128\u0129\7\b\2\2\u0129\u012a\7\n"+
		"\2\2\u012a\u012b\5\u00c0a\2\u012b\u012c\7\25\2\2\u012c\u012d\7\33\2\2"+
		"\u012d\u012e\7\n\2\2\u012e\u012f\5\u00be`\2\u012f\u0130\7*\2\2\u0130\21"+
		"\3\2\2\2\u0131\u0132\7D\2\2\u0132\u0133\5\u00b6\\\2\u0133\u0134\7&\2\2"+
		"\u0134\23\3\2\2\2\u0135\u0136\7\22\2\2\u0136\u0137\5\32\16\2\u0137\u013c"+
		"\7\t\2\2\u0138\u013b\5\26\f\2\u0139\u013b\5\30\r\2\u013a\u0138\3\2\2\2"+
		"\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d"+
		"\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\7*\2\2\u0140"+
		"\25\3\2\2\2\u0141\u0142\7\4\2\2\u0142\u0143\5\30\r\2\u0143\27\3\2\2\2"+
		"\u0144\u0147\5\24\13\2\u0145\u0147\5\34\17\2\u0146\u0144\3\2\2\2\u0146"+
		"\u0145\3\2\2\2\u0147\31\3\2\2\2\u0148\u014d\5\u00caf\2\u0149\u014a\7\61"+
		"\2\2\u014a\u014c\5\u00caf\2\u014b\u0149\3\2\2\2\u014c\u014f\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\33\3\2\2\2\u014f\u014d\3\2\2"+
		"\2\u0150\u0155\5\36\20\2\u0151\u0155\5l\67\2\u0152\u0155\5X-\2\u0153\u0155"+
		"\5V,\2\u0154\u0150\3\2\2\2\u0154\u0151\3\2\2\2\u0154\u0152\3\2\2\2\u0154"+
		"\u0153\3\2\2\2\u0155\35\3\2\2\2\u0156\u015a\5 \21\2\u0157\u015a\5(\25"+
		"\2\u0158\u015a\5*\26\2\u0159\u0156\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u0158"+
		"\3\2\2\2\u015a\37\3\2\2\2\u015b\u015c\7+\2\2\u015c\u015e\5\u00caf\2\u015d"+
		"\u015f\5\"\22\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3"+
		"\2\2\2\u0160\u0162\7\t\2\2\u0161\u0163\5$\23\2\u0162\u0161\3\2\2\2\u0163"+
		"\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\3\2"+
		"\2\2\u0166\u0167\7*\2\2\u0167!\3\2\2\2\u0168\u0169\7(\2\2\u0169\u016a"+
		"\5\32\16\2\u016a#\3\2\2\2\u016b\u0177\5\u00caf\2\u016c\u016d\7\t\2\2\u016d"+
		"\u0171\5&\24\2\u016e\u0170\5&\24\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2"+
		"\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173"+
		"\u0171\3\2\2\2\u0174\u0175\7*\2\2\u0175\u0178\3\2\2\2\u0176\u0178\7&\2"+
		"\2\u0177\u016c\3\2\2\2\u0177\u0176\3\2\2\2\u0178%\3\2\2\2\u0179\u017a"+
		"\5\u00caf\2\u017a\u017b\7\n\2\2\u017b\u017c\5p9\2\u017c\u017d\7&\2\2\u017d"+
		"\'\3\2\2\2\u017e\u017f\5\u00c8e\2\u017f\u0182\7\n\2\2\u0180\u0183\5\u00c2"+
		"b\2\u0181\u0183\5\u00c4c\2\u0182\u0180\3\2\2\2\u0182\u0181\3\2\2\2\u0183"+
		"\u0185\3\2\2\2\u0184\u0186\5\u00c8e\2\u0185\u0184\3\2\2\2\u0185\u0186"+
		"\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\7&\2\2\u0188)\3\2\2\2\u0189\u018a"+
		"\7!\2\2\u018a\u018c\5\u00caf\2\u018b\u018d\5\"\22\2\u018c\u018b\3\2\2"+
		"\2\u018c\u018d\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f\5,\27\2\u018f+"+
		"\3\2\2\2\u0190\u0195\7\t\2\2\u0191\u0194\5.\30\2\u0192\u0194\5\60\31\2"+
		"\u0193\u0191\3\2\2\2\u0193\u0192\3\2\2\2\u0194\u0197\3\2\2\2\u0195\u0193"+
		"\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197\u0195\3\2\2\2\u0198"+
		"\u0199\7*\2\2\u0199-\3\2\2\2\u019a\u019b\7\4\2\2\u019b\u019c\5\60\31\2"+
		"\u019c/\3\2\2\2\u019d\u01a1\5\66\34\2\u019e\u01a1\5\36\20\2\u019f\u01a1"+
		"\5\62\32\2\u01a0\u019d\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u019f\3\2\2\2"+
		"\u01a1\61\3\2\2\2\u01a2\u01a4\7\17\2\2\u01a3\u01a2\3\2\2\2\u01a3\u01a4"+
		"\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\5\64\33\2\u01a6\63\3\2\2\2\u01a7"+
		"\u01ad\5l\67\2\u01a8\u01ad\5Z.\2\u01a9\u01ad\5\\/\2\u01aa\u01ad\5V,\2"+
		"\u01ab\u01ad\5X-\2\u01ac\u01a7\3\2\2\2\u01ac\u01a8\3\2\2\2\u01ac\u01a9"+
		"\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ab\3\2\2\2\u01ad\65\3\2\2\2\u01ae"+
		"\u01af\5`\61\2\u01af\u01b0\7&\2\2\u01b0\67\3\2\2\2\u01b1\u01b4\5\32\16"+
		"\2\u01b2\u01b4\5:\36\2\u01b3\u01b1\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b49"+
		"\3\2\2\2\u01b5\u01bb\5N(\2\u01b6\u01bb\5H%\2\u01b7\u01bb\5J&\2\u01b8\u01bb"+
		"\5L\'\2\u01b9\u01bb\5<\37\2\u01ba\u01b5\3\2\2\2\u01ba\u01b6\3\2\2\2\u01ba"+
		"\u01b7\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01b9\3\2\2\2\u01bb;\3\2\2\2"+
		"\u01bc\u01c1\5> \2\u01bd\u01c1\5@!\2\u01be\u01c1\5B\"\2\u01bf\u01c1\5"+
		"D#\2\u01c0\u01bc\3\2\2\2\u01c0\u01bd\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0"+
		"\u01bf\3\2\2\2\u01c1=\3\2\2\2\u01c2\u01c3\7\35\2\2\u01c3\u01c4\7\32\2"+
		"\2\u01c4\u01c5\5F$\2\u01c5\u01c6\7\63\2\2\u01c6\u01c7\58\35\2\u01c7\u01c8"+
		"\7;\2\2\u01c8?\3\2\2\2\u01c9\u01ca\7\35\2\2\u01ca\u01cb\7\32\2\2\u01cb"+
		"\u01cc\7\63\2\2\u01cc\u01cd\58\35\2\u01cd\u01ce\7;\2\2\u01ceA\3\2\2\2"+
		"\u01cf\u01d0\7\35\2\2\u01d0\u01d1\7\32\2\2\u01d1\u01d2\5F$\2\u01d2\u01d3"+
		"\7;\2\2\u01d3C\3\2\2\2\u01d4\u01d5\7\35\2\2\u01d5\u01d6\7\32\2\2\u01d6"+
		"\u01d7\7;\2\2\u01d7E\3\2\2\2\u01d8\u01e1\7\21\2\2\u01d9\u01de\58\35\2"+
		"\u01da\u01db\7\25\2\2\u01db\u01dd\58\35\2\u01dc\u01da\3\2\2\2\u01dd\u01e0"+
		"\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0"+
		"\u01de\3\2\2\2\u01e1\u01d9\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\3\2"+
		"\2\2\u01e3\u01e6\7B\2\2\u01e4\u01e6\58\35\2\u01e5\u01d8\3\2\2\2\u01e5"+
		"\u01e4\3\2\2\2\u01e6G\3\2\2\2\u01e7\u01e8\7\'\2\2\u01e8\u01e9\7\32\2\2"+
		"\u01e9\u01ea\58\35\2\u01ea\u01eb\7;\2\2\u01ebI\3\2\2\2\u01ec\u01ed\7\f"+
		"\2\2\u01ed\u01ee\5\u00c8e\2\u01eeK\3\2\2\2\u01ef\u01f0\7\27\2\2\u01f0"+
		"\u01f1\7\32\2\2\u01f1\u01f2\5T+\2\u01f2\u01f3\7;\2\2\u01f3M\3\2\2\2\u01f4"+
		"\u01f8\5T+\2\u01f5\u01f8\5P)\2\u01f6\u01f8\5R*\2\u01f7\u01f4\3\2\2\2\u01f7"+
		"\u01f5\3\2\2\2\u01f7\u01f6\3\2\2\2\u01f8O\3\2\2\2\u01f9\u01fa\t\2\2\2"+
		"\u01faQ\3\2\2\2\u01fb\u01fc\t\3\2\2\u01fcS\3\2\2\2\u01fd\u01fe\t\4\2\2"+
		"\u01feU\3\2\2\2\u01ff\u0200\7\13\2\2\u0200\u0202\5\u00caf\2\u0201\u0203"+
		"\5^\60\2\u0202\u0201\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204"+
		"\u0205\5b\62\2\u0205W\3\2\2\2\u0206\u0207\7\37\2\2\u0207\u0209\5\u00ca"+
		"f\2\u0208\u020a\5^\60\2\u0209\u0208\3\2\2\2\u0209\u020a\3\2\2\2\u020a"+
		"\u020b\3\2\2\2\u020b\u020c\7\63\2\2\u020c\u020d\58\35\2\u020d\u020e\5"+
		"b\62\2\u020eY\3\2\2\2\u020f\u0211\5\u00caf\2\u0210\u0212\5^\60\2\u0211"+
		"\u0210\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\7\63"+
		"\2\2\u0214\u0215\58\35\2\u0215\u0216\5b\62\2\u0216[\3\2\2\2\u0217\u0218"+
		"\7\6\2\2\u0218\u0219\5\u00caf\2\u0219\u021a\7\21\2\2\u021a\u021b\5`\61"+
		"\2\u021b\u021c\7B\2\2\u021c\u021d\5b\62\2\u021d]\3\2\2\2\u021e\u021f\7"+
		"\21\2\2\u021f\u0224\5`\61\2\u0220\u0221\7\25\2\2\u0221\u0223\5`\61\2\u0222"+
		"\u0220\3\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2"+
		"\2\2\u0225\u0227\3\2\2\2\u0226\u0224\3\2\2\2\u0227\u0228\7B\2\2\u0228"+
		"\u022b\3\2\2\2\u0229\u022b\7-\2\2\u022a\u021e\3\2\2\2\u022a\u0229\3\2"+
		"\2\2\u022b_\3\2\2\2\u022c\u022d\5\u00caf\2\u022d\u022e\7\66\2\2\u022e"+
		"\u022f\58\35\2\u022fa\3\2\2\2\u0230\u0234\7\t\2\2\u0231\u0233\5d\63\2"+
		"\u0232\u0231\3\2\2\2\u0233\u0236\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0235"+
		"\3\2\2\2\u0235\u0237\3\2\2\2\u0236\u0234\3\2\2\2\u0237\u0238\7*\2\2\u0238"+
		"c\3\2\2\2\u0239\u0241\5l\67\2\u023a\u0241\5n8\2\u023b\u0241\5X-\2\u023c"+
		"\u0241\5\36\20\2\u023d\u0241\5f\64\2\u023e\u0241\5h\65\2\u023f\u0241\5"+
		"j\66\2\u0240\u0239\3\2\2\2\u0240\u023a\3\2\2\2\u0240\u023b\3\2\2\2\u0240"+
		"\u023c\3\2\2\2\u0240\u023d\3\2\2\2\u0240\u023e\3\2\2\2\u0240\u023f\3\2"+
		"\2\2\u0241e\3\2\2\2\u0242\u0243\5\u0090I\2\u0243\u0244\7&\2\2\u0244g\3"+
		"\2\2\2\u0245\u0246\5r:\2\u0246i\3\2\2\2\u0247\u0248\7\64\2\2\u0248\u024a"+
		"\7\n\2\2\u0249\u024b\5p9\2\u024a\u0249\3\2\2\2\u024a\u024b\3\2\2\2\u024b"+
		"\u024c\3\2\2\2\u024c\u024d\7&\2\2\u024dk\3\2\2\2\u024e\u024f\5\u00caf"+
		"\2\u024f\u0250\7\n\2\2\u0250\u0251\5p9\2\u0251\u0252\7&\2\2\u0252m\3\2"+
		"\2\2\u0253\u0254\5\u0098M\2\u0254\u0255\7\61\2\2\u0255\u0256\5\u00caf"+
		"\2\u0256\u0257\7\n\2\2\u0257\u0258\5p9\2\u0258\u0259\7&\2\2\u0259o\3\2"+
		"\2\2\u025a\u0260\5\u0084C\2\u025b\u0260\5z>\2\u025c\u0260\5|?\2\u025d"+
		"\u0260\5r:\2\u025e\u0260\5\u00a2R\2\u025f\u025a\3\2\2\2\u025f\u025b\3"+
		"\2\2\2\u025f\u025c\3\2\2\2\u025f\u025d\3\2\2\2\u025f\u025e\3\2\2\2\u0260"+
		"q\3\2\2\2\u0261\u0262\7:\2\2\u0262\u0263\7\21\2\2\u0263\u0264\5p9\2\u0264"+
		"\u0265\7B\2\2\u0265\u0270\7\t\2\2\u0266\u0268\5t;\2\u0267\u0266\3\2\2"+
		"\2\u0268\u0269\3\2\2\2\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u0271"+
		"\3\2\2\2\u026b\u026d\5v<\2\u026c\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026e"+
		"\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271\3\2\2\2\u0270\u0267\3\2"+
		"\2\2\u0270\u026c\3\2\2\2\u0271\u0273\3\2\2\2\u0272\u0274\5x=\2\u0273\u0272"+
		"\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u0276\7*\2\2\u0276"+
		"s\3\2\2\2\u0277\u0278\7\62\2\2\u0278\u027b\7\21\2\2\u0279\u027c\5\u00b0"+
		"Y\2\u027a\u027c\5\32\16\2\u027b\u0279\3\2\2\2\u027b\u027a\3\2\2\2\u027c"+
		"\u027d\3\2\2\2\u027d\u027e\7B\2\2\u027e\u027f\5b\62\2\u027fu\3\2\2\2\u0280"+
		"\u0281\7$\2\2\u0281\u0282\7\21\2\2\u0282\u0283\5`\61\2\u0283\u0284\7B"+
		"\2\2\u0284\u0285\5b\62\2\u0285w\3\2\2\2\u0286\u0287\7\3\2\2\u0287\u0288"+
		"\5b\62\2\u0288y\3\2\2\2\u0289\u028a\5\u0084C\2\u028a\u028b\t\5\2\2\u028b"+
		"\u028c\5\u0084C\2\u028c{\3\2\2\2\u028d\u0290\5~@\2\u028e\u028f\t\6\2\2"+
		"\u028f\u0291\5~@\2\u0290\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291}\3\2"+
		"\2\2\u0292\u0299\5\u0082B\2\u0293\u0299\5\u0080A\2\u0294\u0295\7\21\2"+
		"\2\u0295\u0296\5|?\2\u0296\u0297\7B\2\2\u0297\u0299\3\2\2\2\u0298\u0292"+
		"\3\2\2\2\u0298\u0293\3\2\2\2\u0298\u0294\3\2\2\2\u0299\177\3\2\2\2\u029a"+
		"\u029b\5\u0084C\2\u029b\u029c\t\7\2\2\u029c\u029d\5\u0084C\2\u029d\u0081"+
		"\3\2\2\2\u029e\u02a0\7<\2\2\u029f\u029e\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0"+
		"\u02a1\3\2\2\2\u02a1\u02a2\5\u0090I\2\u02a2\u0083\3\2\2\2\u02a3\u02a8"+
		"\5\u0086D\2\u02a4\u02a5\t\b\2\2\u02a5\u02a7\5\u0086D\2\u02a6\u02a4\3\2"+
		"\2\2\u02a7\u02aa\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9"+
		"\u0085\3\2\2\2\u02aa\u02a8\3\2\2\2\u02ab\u02b0\5\u0088E\2\u02ac\u02ad"+
		"\t\t\2\2\u02ad\u02af\5\u0088E\2\u02ae\u02ac\3\2\2\2\u02af\u02b2\3\2\2"+
		"\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u0087\3\2\2\2\u02b2\u02b0"+
		"\3\2\2\2\u02b3\u02b5\7C\2\2\u02b4\u02b3\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5"+
		"\u02b6\3\2\2\2\u02b6\u02b7\5\u008aF\2\u02b7\u0089\3\2\2\2\u02b8\u02bc"+
		"\5\u0090I\2\u02b9\u02bc\5\u008cG\2\u02ba\u02bc\5\u008eH\2\u02bb\u02b8"+
		"\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02ba\3\2\2\2\u02bc\u008b\3\2\2\2\u02bd"+
		"\u02be\5\u0090I\2\u02be\u02bf\5\u00c8e\2\u02bf\u008d\3\2\2\2\u02c0\u02c1"+
		"\5\u0090I\2\u02c1\u02c2\5\u00c6d\2\u02c2\u02c5\3\2\2\2\u02c3\u02c5\5\u00c6"+
		"d\2\u02c4\u02c0\3\2\2\2\u02c4\u02c3\3\2\2\2\u02c5\u008f\3\2\2\2\u02c6"+
		"\u02ca\5\u0096L\2\u02c7\u02c9\5\u0092J\2\u02c8\u02c7\3\2\2\2\u02c9\u02cc"+
		"\3\2\2\2\u02ca\u02c8\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u0091\3\2\2\2\u02cc"+
		"\u02ca\3\2\2\2\u02cd\u02ce\7\61\2\2\u02ce\u02d0\5\u00caf\2\u02cf\u02d1"+
		"\5\u0094K\2\u02d0\u02cf\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u0093\3\2\2"+
		"\2\u02d2\u02d3\7\21\2\2\u02d3\u02d8\5p9\2\u02d4\u02d5\7\25\2\2\u02d5\u02d7"+
		"\5p9\2\u02d6\u02d4\3\2\2\2\u02d7\u02da\3\2\2\2\u02d8\u02d6\3\2\2\2\u02d8"+
		"\u02d9\3\2\2\2\u02d9\u02db\3\2\2\2\u02da\u02d8\3\2\2\2\u02db\u02dc\7B"+
		"\2\2\u02dc\u0095\3\2\2\2\u02dd\u02e9\5\u0098M\2\u02de\u02e9\5\32\16\2"+
		"\u02df\u02e9\5\u009aN\2\u02e0\u02e9\5\u00b0Y\2\u02e1\u02e2\7\21\2\2\u02e2"+
		"\u02e3\5p9\2\u02e3\u02e4\7B\2\2\u02e4\u02e9\3\2\2\2\u02e5\u02e9\5\u009c"+
		"O\2\u02e6\u02e9\5\u009eP\2\u02e7\u02e9\5:\36\2\u02e8\u02dd\3\2\2\2\u02e8"+
		"\u02de\3\2\2\2\u02e8\u02df\3\2\2\2\u02e8\u02e0\3\2\2\2\u02e8\u02e1\3\2"+
		"\2\2\u02e8\u02e5\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e7\3\2\2\2\u02e9"+
		"\u0097\3\2\2\2\u02ea\u02eb\7A\2\2\u02eb\u0099\3\2\2\2\u02ec\u02ed\5\32"+
		"\16\2\u02ed\u02ee\5\u0094K\2\u02ee\u009b\3\2\2\2\u02ef\u02f0\7\t\2\2\u02f0"+
		"\u02f5\5p9\2\u02f1\u02f2\7\25\2\2\u02f2\u02f4\5p9\2\u02f3\u02f1\3\2\2"+
		"\2\u02f4\u02f7\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f8"+
		"\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f8\u02f9\7*\2\2\u02f9\u009d\3\2\2\2\u02fa"+
		"\u02fd\5\u00a0Q\2\u02fb\u02fc\7\66\2\2\u02fc\u02fe\5\32\16\2\u02fd\u02fb"+
		"\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u009f\3\2\2\2\u02ff\u0301\7\t\2\2\u0300"+
		"\u0302\5\62\32\2\u0301\u0300\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0301\3"+
		"\2\2\2\u0303\u0304\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0306\7*\2\2\u0306"+
		"\u00a1\3\2\2\2\u0307\u030c\5\u00a4S\2\u0308\u030c\5\u00a6T\2\u0309\u030c"+
		"\5\u00a8U\2\u030a\u030c\5\u00aaV\2\u030b\u0307\3\2\2\2\u030b\u0308\3\2"+
		"\2\2\u030b\u0309\3\2\2\2\u030b\u030a\3\2\2\2\u030c\u00a3\3\2\2\2\u030d"+
		"\u030e\7\35\2\2\u030e\u030f\5\u00acW\2\u030f\u0310\7\63\2\2\u0310\u0311"+
		"\58\35\2\u0311\u0312\5\u00aeX\2\u0312\u00a5\3\2\2\2\u0313\u0316\7\35\2"+
		"\2\u0314\u0315\7\21\2\2\u0315\u0317\7B\2\2\u0316\u0314\3\2\2\2\u0316\u0317"+
		"\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0319\7\63\2\2\u0319\u031a\58\35\2"+
		"\u031a\u031b\5\u00aeX\2\u031b\u00a7\3\2\2\2\u031c\u031d\7\35\2\2\u031d"+
		"\u031e\5\u00acW\2\u031e\u031f\5\u00aeX\2\u031f\u00a9\3\2\2\2\u0320\u0323"+
		"\7\35\2\2\u0321\u0322\7\21\2\2\u0322\u0324\7B\2\2\u0323\u0321\3\2\2\2"+
		"\u0323\u0324\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0326\5\u00aeX\2\u0326"+
		"\u00ab\3\2\2\2\u0327\u0328\7\21\2\2\u0328\u032d\5`\61\2\u0329\u032a\7"+
		"\25\2\2\u032a\u032c\5`\61\2\u032b\u0329\3\2\2\2\u032c\u032f\3\2\2\2\u032d"+
		"\u032b\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u0330\3\2\2\2\u032f\u032d\3\2"+
		"\2\2\u0330\u0331\7B\2\2\u0331\u0334\3\2\2\2\u0332\u0334\5`\61\2\u0333"+
		"\u0327\3\2\2\2\u0333\u0332\3\2\2\2\u0334\u00ad\3\2\2\2\u0335\u0338\5b"+
		"\62\2\u0336\u0338\5p9\2\u0337\u0335\3\2\2\2\u0337\u0336\3\2\2\2\u0338"+
		"\u00af\3\2\2\2\u0339\u0343\5\u00c2b\2\u033a\u0343\5\u00c4c\2\u033b\u0343"+
		"\5\u00be`\2\u033c\u0343\5\u00b2Z\2\u033d\u0343\5\u00b4[\2\u033e\u0343"+
		"\5\u00b6\\\2\u033f\u0343\5\u00ba^\2\u0340\u0343\5\u00b8]\2\u0341\u0343"+
		"\5\u00bc_\2\u0342\u0339\3\2\2\2\u0342\u033a\3\2\2\2\u0342\u033b\3\2\2"+
		"\2\u0342\u033c\3\2\2\2\u0342\u033d\3\2\2\2\u0342\u033e\3\2\2\2\u0342\u033f"+
		"\3\2\2\2\u0342\u0340\3\2\2\2\u0342\u0341\3\2\2\2\u0343\u00b1\3\2\2\2\u0344"+
		"\u0345\5\u00be`\2\u0345\u0346\7\66\2\2\u0346\u0347\7\16\2\2\u0347\u00b3"+
		"\3\2\2\2\u0348\u0349\5\u00be`\2\u0349\u034a\7\66\2\2\u034a\u034b\7\36"+
		"\2\2\u034b\u00b5\3\2\2\2\u034c\u034d\5\u00c0a\2\u034d\u034e\7\66\2\2\u034e"+
		"\u034f\7\23\2\2\u034f\u00b7\3\2\2\2\u0350\u0351\5\u00c0a\2\u0351\u0352"+
		"\7\66\2\2\u0352\u0353\7\34\2\2\u0353\u00b9\3\2\2\2\u0354\u0355\5\u00c0"+
		"a\2\u0355\u0356\7\66\2\2\u0356\u0357\7#\2\2\u0357\u00bb\3\2\2\2\u0358"+
		"\u0359\5\u00c0a\2\u0359\u035a\7\66\2\2\u035a\u035b\7\26\2\2\u035b\u00bd"+
		"\3\2\2\2\u035c\u035d\t\n\2\2\u035d\u00bf\3\2\2\2\u035e\u035f\t\13\2\2"+
		"\u035f\u00c1\3\2\2\2\u0360\u0361\t\f\2\2\u0361\u00c3\3\2\2\2\u0362\u0363"+
		"\t\r\2\2\u0363\u00c5\3\2\2\2\u0364\u0365\7F\2\2\u0365\u00c7\3\2\2\2\u0366"+
		"\u0367\7G\2\2\u0367\u00c9\3\2\2\2\u0368\u0369\7H\2\2\u0369\u00cb\3\2\2"+
		"\2M\u00d0\u00d4\u00d7\u00dc\u00e2\u00e8\u00f0\u00f5\u00f7\u010a\u0115"+
		"\u011a\u011c\u011f\u013a\u013c\u0146\u014d\u0154\u0159\u015e\u0164\u0171"+
		"\u0177\u0182\u0185\u018c\u0193\u0195\u01a0\u01a3\u01ac\u01b3\u01ba\u01c0"+
		"\u01de\u01e1\u01e5\u01f7\u0202\u0209\u0211\u0224\u022a\u0234\u0240\u024a"+
		"\u025f\u0269\u026e\u0270\u0273\u027b\u0290\u0298\u029f\u02a8\u02b0\u02b4"+
		"\u02bb\u02c4\u02ca\u02d0\u02d8\u02e8\u02f5\u02fd\u0303\u030b\u0316\u0323"+
		"\u032d\u0333\u0337\u0342";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}