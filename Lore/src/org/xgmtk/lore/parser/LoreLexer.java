// Generated from C:\Users\kando\git\Lore\Lore\src\org\xgmtk\lore\parser\Lore.g4 by ANTLR 4.1
package org.xgmtk.lore.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LoreLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'default'", "'private'", "'encoding'", "'alter'", "'!='", "'reviser'", 
		"'{'", "'='", "'rule'", "'unit'", "'version'", "'html'", "'override'", 
		"'number'", "'('", "'section'", "'url'", "',...,'", "','", "'loc'", "'range'", 
		"'>='", "',...<'", "'<'", "'desc'", "'date'", "'@'", "'xml'", "'function'", 
		"'+'", "'form'", "'/'", "'jid'", "'as'", "'integer'", "';'", "'list'", 
		"'extends'", "'author'", "'}'", "'enum'", "'<='", "'()'", "'&'", "'dice'", 
		"'*'", "'.'", "'case'", "'->'", "'result'", "'<...<'", "':'", "'history'", 
		"'=='", "'|'", "'select'", "'>'", "'!'", "'string'", "'%'", "'docinfo'", 
		"'<...,'", "'self'", "')'", "'-'", "'import'", "'real'", "DICE", "UNIT_NAME", 
		"NAME", "NORMALSTRING", "CHARSTRING", "LONGSTRING", "INT", "HEX", "FLOAT", 
		"HEX_FLOAT", "COMMENT", "LINE_COMMENT", "WS", "NEWLINE"
	};
	public static final String[] ruleNames = {
		"T__66", "T__65", "T__64", "T__63", "T__62", "T__61", "T__60", "T__59", 
		"T__58", "T__57", "T__56", "T__55", "T__54", "T__53", "T__52", "T__51", 
		"T__50", "T__49", "T__48", "T__47", "T__46", "T__45", "T__44", "T__43", 
		"T__42", "T__41", "T__40", "T__39", "T__38", "T__37", "T__36", "T__35", 
		"T__34", "T__33", "T__32", "T__31", "T__30", "T__29", "T__28", "T__27", 
		"T__26", "T__25", "T__24", "T__23", "T__22", "T__21", "T__20", "T__19", 
		"T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", 
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "DICE", "UNIT_NAME", "NAME", "NORMALSTRING", "CHARSTRING", 
		"LONGSTRING", "NESTED_STR", "INT", "HEX", "FLOAT", "HEX_FLOAT", "ExponentPart", 
		"HexExponentPart", "EscapeSequence", "DecimalEscape", "HexEscape", "Digit", 
		"HexDigit", "COMMENT", "LINE_COMMENT", "WS", "NEWLINE"
	};


	public LoreLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lore.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 85: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 86: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 87: WS_action((RuleContext)_localctx, actionIndex); break;

		case 88: NEWLINE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = HIDDEN;  break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: skip();  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2S\u02f5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3!\3!"+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3*"+
		"\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\67\3\67\3\67\38\38\39\39\39\39\39\39\39\3:\3:\3;\3;\3<\3<\3<\3"+
		"<\3<\3<\3<\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3@\3@\3@\3"+
		"@\3@\3A\3A\3B\3B\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3E\3E\5E\u01f2\n"+
		"E\3F\3F\6F\u01f6\nF\rF\16F\u01f7\3F\3F\3F\7F\u01fd\nF\fF\16F\u0200\13"+
		"F\5F\u0202\nF\3F\3F\6F\u0206\nF\rF\16F\u0207\3F\3F\3F\7F\u020d\nF\fF\16"+
		"F\u0210\13F\5F\u0212\nF\5F\u0214\nF\3F\3F\3G\3G\7G\u021a\nG\fG\16G\u021d"+
		"\13G\3H\3H\3H\7H\u0222\nH\fH\16H\u0225\13H\3H\3H\3I\3I\3I\7I\u022c\nI"+
		"\fI\16I\u022f\13I\3I\3I\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\7K\u023d\nK\fK\16"+
		"K\u0240\13K\3K\5K\u0243\nK\3L\6L\u0246\nL\rL\16L\u0247\3M\3M\3M\6M\u024d"+
		"\nM\rM\16M\u024e\3N\6N\u0252\nN\rN\16N\u0253\3N\3N\7N\u0258\nN\fN\16N"+
		"\u025b\13N\3N\5N\u025e\nN\3N\3N\6N\u0262\nN\rN\16N\u0263\3N\5N\u0267\n"+
		"N\3N\6N\u026a\nN\rN\16N\u026b\3N\3N\5N\u0270\nN\3O\3O\3O\6O\u0275\nO\r"+
		"O\16O\u0276\3O\3O\7O\u027b\nO\fO\16O\u027e\13O\3O\5O\u0281\nO\3O\3O\3"+
		"O\3O\6O\u0287\nO\rO\16O\u0288\3O\5O\u028c\nO\3O\3O\3O\6O\u0291\nO\rO\16"+
		"O\u0292\3O\3O\5O\u0297\nO\3P\3P\5P\u029b\nP\3P\6P\u029e\nP\rP\16P\u029f"+
		"\3Q\3Q\5Q\u02a4\nQ\3Q\6Q\u02a7\nQ\rQ\16Q\u02a8\3R\3R\3R\3R\5R\u02af\n"+
		"R\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\5S\u02bc\nS\3T\3T\3T\3T\3T\3U\3U\3"+
		"V\3V\3W\3W\3W\3W\7W\u02cb\nW\fW\16W\u02ce\13W\3W\3W\3W\3W\3W\3X\3X\3X"+
		"\3X\7X\u02d9\nX\fX\16X\u02dc\13X\5X\u02de\nX\3X\7X\u02e1\nX\fX\16X\u02e4"+
		"\13X\3X\3X\3Y\6Y\u02e9\nY\rY\16Y\u02ea\3Y\3Y\3Z\5Z\u02f0\nZ\3Z\3Z\3Z\3"+
		"Z\4\u023e\u02cc[\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23"+
		"\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1"+
		"\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1"+
		";\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1["+
		"/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s;\1u<"+
		"\1w=\1y>\1{?\1}@\1\177A\1\u0081B\1\u0083C\1\u0085D\1\u0087E\1\u0089F\1"+
		"\u008bG\1\u008dH\1\u008fI\1\u0091J\1\u0093K\1\u0095\2\1\u0097L\1\u0099"+
		"M\1\u009bN\1\u009dO\1\u009f\2\1\u00a1\2\1\u00a3\2\1\u00a5\2\1\u00a7\2"+
		"\1\u00a9\2\1\u00ab\2\1\u00adP\2\u00afQ\3\u00b1R\4\u00b3S\5\3\2\22\4\2"+
		"FFff\5\2C\\aac|\3\2\63;\3\2\62;\6\2\62;C\\aac|\4\2$$^^\4\2))^^\4\2ZZz"+
		"z\4\2GGgg\4\2--//\4\2RRrr\f\2$$))^^cdhhppttvvxx||\3\2\62\64\5\2\62;CH"+
		"ch\4\2\f\f\17\17\5\2\13\13\16\16\"\"\u031b\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s"+
		"\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2"+
		"\2\2\u009d\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3"+
		"\3\2\2\2\3\u00b5\3\2\2\2\5\u00bd\3\2\2\2\7\u00c5\3\2\2\2\t\u00ce\3\2\2"+
		"\2\13\u00d4\3\2\2\2\r\u00d7\3\2\2\2\17\u00df\3\2\2\2\21\u00e1\3\2\2\2"+
		"\23\u00e3\3\2\2\2\25\u00e8\3\2\2\2\27\u00ed\3\2\2\2\31\u00f5\3\2\2\2\33"+
		"\u00fa\3\2\2\2\35\u0103\3\2\2\2\37\u010a\3\2\2\2!\u010c\3\2\2\2#\u0114"+
		"\3\2\2\2%\u0118\3\2\2\2\'\u011e\3\2\2\2)\u0120\3\2\2\2+\u0124\3\2\2\2"+
		"-\u012a\3\2\2\2/\u012d\3\2\2\2\61\u0133\3\2\2\2\63\u0135\3\2\2\2\65\u013a"+
		"\3\2\2\2\67\u013f\3\2\2\29\u0141\3\2\2\2;\u0145\3\2\2\2=\u014e\3\2\2\2"+
		"?\u0150\3\2\2\2A\u0155\3\2\2\2C\u0157\3\2\2\2E\u015b\3\2\2\2G\u015e\3"+
		"\2\2\2I\u0166\3\2\2\2K\u0168\3\2\2\2M\u016d\3\2\2\2O\u0175\3\2\2\2Q\u017c"+
		"\3\2\2\2S\u017e\3\2\2\2U\u0183\3\2\2\2W\u0186\3\2\2\2Y\u0189\3\2\2\2["+
		"\u018b\3\2\2\2]\u0190\3\2\2\2_\u0192\3\2\2\2a\u0194\3\2\2\2c\u0199\3\2"+
		"\2\2e\u019c\3\2\2\2g\u01a3\3\2\2\2i\u01a9\3\2\2\2k\u01ab\3\2\2\2m\u01b3"+
		"\3\2\2\2o\u01b6\3\2\2\2q\u01b8\3\2\2\2s\u01bf\3\2\2\2u\u01c1\3\2\2\2w"+
		"\u01c3\3\2\2\2y\u01ca\3\2\2\2{\u01cc\3\2\2\2}\u01d4\3\2\2\2\177\u01da"+
		"\3\2\2\2\u0081\u01df\3\2\2\2\u0083\u01e1\3\2\2\2\u0085\u01e3\3\2\2\2\u0087"+
		"\u01ea\3\2\2\2\u0089\u01ef\3\2\2\2\u008b\u01f3\3\2\2\2\u008d\u0217\3\2"+
		"\2\2\u008f\u021e\3\2\2\2\u0091\u0228\3\2\2\2\u0093\u0232\3\2\2\2\u0095"+
		"\u0242\3\2\2\2\u0097\u0245\3\2\2\2\u0099\u0249\3\2\2\2\u009b\u026f\3\2"+
		"\2\2\u009d\u0296\3\2\2\2\u009f\u0298\3\2\2\2\u00a1\u02a1\3\2\2\2\u00a3"+
		"\u02ae\3\2\2\2\u00a5\u02bb\3\2\2\2\u00a7\u02bd\3\2\2\2\u00a9\u02c2\3\2"+
		"\2\2\u00ab\u02c4\3\2\2\2\u00ad\u02c6\3\2\2\2\u00af\u02d4\3\2\2\2\u00b1"+
		"\u02e8\3\2\2\2\u00b3\u02ef\3\2\2\2\u00b5\u00b6\7f\2\2\u00b6\u00b7\7g\2"+
		"\2\u00b7\u00b8\7h\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bb"+
		"\7n\2\2\u00bb\u00bc\7v\2\2\u00bc\4\3\2\2\2\u00bd\u00be\7r\2\2\u00be\u00bf"+
		"\7t\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7x\2\2\u00c1\u00c2\7c\2\2\u00c2"+
		"\u00c3\7v\2\2\u00c3\u00c4\7g\2\2\u00c4\6\3\2\2\2\u00c5\u00c6\7g\2\2\u00c6"+
		"\u00c7\7p\2\2\u00c7\u00c8\7e\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7f\2\2"+
		"\u00ca\u00cb\7k\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7i\2\2\u00cd\b\3\2"+
		"\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2"+
		"\7g\2\2\u00d2\u00d3\7t\2\2\u00d3\n\3\2\2\2\u00d4\u00d5\7#\2\2\u00d5\u00d6"+
		"\7?\2\2\u00d6\f\3\2\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da"+
		"\7x\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7g\2\2\u00dd"+
		"\u00de\7t\2\2\u00de\16\3\2\2\2\u00df\u00e0\7}\2\2\u00e0\20\3\2\2\2\u00e1"+
		"\u00e2\7?\2\2\u00e2\22\3\2\2\2\u00e3\u00e4\7t\2\2\u00e4\u00e5\7w\2\2\u00e5"+
		"\u00e6\7n\2\2\u00e6\u00e7\7g\2\2\u00e7\24\3\2\2\2\u00e8\u00e9\7w\2\2\u00e9"+
		"\u00ea\7p\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec\7v\2\2\u00ec\26\3\2\2\2\u00ed"+
		"\u00ee\7x\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0\7t\2\2\u00f0\u00f1\7u\2\2"+
		"\u00f1\u00f2\7k\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4\7p\2\2\u00f4\30\3\2"+
		"\2\2\u00f5\u00f6\7j\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\7o\2\2\u00f8\u00f9"+
		"\7n\2\2\u00f9\32\3\2\2\2\u00fa\u00fb\7q\2\2\u00fb\u00fc\7x\2\2\u00fc\u00fd"+
		"\7g\2\2\u00fd\u00fe\7t\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7k\2\2\u0100"+
		"\u0101\7f\2\2\u0101\u0102\7g\2\2\u0102\34\3\2\2\2\u0103\u0104\7p\2\2\u0104"+
		"\u0105\7w\2\2\u0105\u0106\7o\2\2\u0106\u0107\7d\2\2\u0107\u0108\7g\2\2"+
		"\u0108\u0109\7t\2\2\u0109\36\3\2\2\2\u010a\u010b\7*\2\2\u010b \3\2\2\2"+
		"\u010c\u010d\7u\2\2\u010d\u010e\7g\2\2\u010e\u010f\7e\2\2\u010f\u0110"+
		"\7v\2\2\u0110\u0111\7k\2\2\u0111\u0112\7q\2\2\u0112\u0113\7p\2\2\u0113"+
		"\"\3\2\2\2\u0114\u0115\7w\2\2\u0115\u0116\7t\2\2\u0116\u0117\7n\2\2\u0117"+
		"$\3\2\2\2\u0118\u0119\7.\2\2\u0119\u011a\7\60\2\2\u011a\u011b\7\60\2\2"+
		"\u011b\u011c\7\60\2\2\u011c\u011d\7.\2\2\u011d&\3\2\2\2\u011e\u011f\7"+
		".\2\2\u011f(\3\2\2\2\u0120\u0121\7n\2\2\u0121\u0122\7q\2\2\u0122\u0123"+
		"\7e\2\2\u0123*\3\2\2\2\u0124\u0125\7t\2\2\u0125\u0126\7c\2\2\u0126\u0127"+
		"\7p\2\2\u0127\u0128\7i\2\2\u0128\u0129\7g\2\2\u0129,\3\2\2\2\u012a\u012b"+
		"\7@\2\2\u012b\u012c\7?\2\2\u012c.\3\2\2\2\u012d\u012e\7.\2\2\u012e\u012f"+
		"\7\60\2\2\u012f\u0130\7\60\2\2\u0130\u0131\7\60\2\2\u0131\u0132\7>\2\2"+
		"\u0132\60\3\2\2\2\u0133\u0134\7>\2\2\u0134\62\3\2\2\2\u0135\u0136\7f\2"+
		"\2\u0136\u0137\7g\2\2\u0137\u0138\7u\2\2\u0138\u0139\7e\2\2\u0139\64\3"+
		"\2\2\2\u013a\u013b\7f\2\2\u013b\u013c\7c\2\2\u013c\u013d\7v\2\2\u013d"+
		"\u013e\7g\2\2\u013e\66\3\2\2\2\u013f\u0140\7B\2\2\u01408\3\2\2\2\u0141"+
		"\u0142\7z\2\2\u0142\u0143\7o\2\2\u0143\u0144\7n\2\2\u0144:\3\2\2\2\u0145"+
		"\u0146\7h\2\2\u0146\u0147\7w\2\2\u0147\u0148\7p\2\2\u0148\u0149\7e\2\2"+
		"\u0149\u014a\7v\2\2\u014a\u014b\7k\2\2\u014b\u014c\7q\2\2\u014c\u014d"+
		"\7p\2\2\u014d<\3\2\2\2\u014e\u014f\7-\2\2\u014f>\3\2\2\2\u0150\u0151\7"+
		"h\2\2\u0151\u0152\7q\2\2\u0152\u0153\7t\2\2\u0153\u0154\7o\2\2\u0154@"+
		"\3\2\2\2\u0155\u0156\7\61\2\2\u0156B\3\2\2\2\u0157\u0158\7l\2\2\u0158"+
		"\u0159\7k\2\2\u0159\u015a\7f\2\2\u015aD\3\2\2\2\u015b\u015c\7c\2\2\u015c"+
		"\u015d\7u\2\2\u015dF\3\2\2\2\u015e\u015f\7k\2\2\u015f\u0160\7p\2\2\u0160"+
		"\u0161\7v\2\2\u0161\u0162\7g\2\2\u0162\u0163\7i\2\2\u0163\u0164\7g\2\2"+
		"\u0164\u0165\7t\2\2\u0165H\3\2\2\2\u0166\u0167\7=\2\2\u0167J\3\2\2\2\u0168"+
		"\u0169\7n\2\2\u0169\u016a\7k\2\2\u016a\u016b\7u\2\2\u016b\u016c\7v\2\2"+
		"\u016cL\3\2\2\2\u016d\u016e\7g\2\2\u016e\u016f\7z\2\2\u016f\u0170\7v\2"+
		"\2\u0170\u0171\7g\2\2\u0171\u0172\7p\2\2\u0172\u0173\7f\2\2\u0173\u0174"+
		"\7u\2\2\u0174N\3\2\2\2\u0175\u0176\7c\2\2\u0176\u0177\7w\2\2\u0177\u0178"+
		"\7v\2\2\u0178\u0179\7j\2\2\u0179\u017a\7q\2\2\u017a\u017b\7t\2\2\u017b"+
		"P\3\2\2\2\u017c\u017d\7\177\2\2\u017dR\3\2\2\2\u017e\u017f\7g\2\2\u017f"+
		"\u0180\7p\2\2\u0180\u0181\7w\2\2\u0181\u0182\7o\2\2\u0182T\3\2\2\2\u0183"+
		"\u0184\7>\2\2\u0184\u0185\7?\2\2\u0185V\3\2\2\2\u0186\u0187\7*\2\2\u0187"+
		"\u0188\7+\2\2\u0188X\3\2\2\2\u0189\u018a\7(\2\2\u018aZ\3\2\2\2\u018b\u018c"+
		"\7f\2\2\u018c\u018d\7k\2\2\u018d\u018e\7e\2\2\u018e\u018f\7g\2\2\u018f"+
		"\\\3\2\2\2\u0190\u0191\7,\2\2\u0191^\3\2\2\2\u0192\u0193\7\60\2\2\u0193"+
		"`\3\2\2\2\u0194\u0195\7e\2\2\u0195\u0196\7c\2\2\u0196\u0197\7u\2\2\u0197"+
		"\u0198\7g\2\2\u0198b\3\2\2\2\u0199\u019a\7/\2\2\u019a\u019b\7@\2\2\u019b"+
		"d\3\2\2\2\u019c\u019d\7t\2\2\u019d\u019e\7g\2\2\u019e\u019f\7u\2\2\u019f"+
		"\u01a0\7w\2\2\u01a0\u01a1\7n\2\2\u01a1\u01a2\7v\2\2\u01a2f\3\2\2\2\u01a3"+
		"\u01a4\7>\2\2\u01a4\u01a5\7\60\2\2\u01a5\u01a6\7\60\2\2\u01a6\u01a7\7"+
		"\60\2\2\u01a7\u01a8\7>\2\2\u01a8h\3\2\2\2\u01a9\u01aa\7<\2\2\u01aaj\3"+
		"\2\2\2\u01ab\u01ac\7j\2\2\u01ac\u01ad\7k\2\2\u01ad\u01ae\7u\2\2\u01ae"+
		"\u01af\7v\2\2\u01af\u01b0\7q\2\2\u01b0\u01b1\7t\2\2\u01b1\u01b2\7{\2\2"+
		"\u01b2l\3\2\2\2\u01b3\u01b4\7?\2\2\u01b4\u01b5\7?\2\2\u01b5n\3\2\2\2\u01b6"+
		"\u01b7\7~\2\2\u01b7p\3\2\2\2\u01b8\u01b9\7u\2\2\u01b9\u01ba\7g\2\2\u01ba"+
		"\u01bb\7n\2\2\u01bb\u01bc\7g\2\2\u01bc\u01bd\7e\2\2\u01bd\u01be\7v\2\2"+
		"\u01ber\3\2\2\2\u01bf\u01c0\7@\2\2\u01c0t\3\2\2\2\u01c1\u01c2\7#\2\2\u01c2"+
		"v\3\2\2\2\u01c3\u01c4\7u\2\2\u01c4\u01c5\7v\2\2\u01c5\u01c6\7t\2\2\u01c6"+
		"\u01c7\7k\2\2\u01c7\u01c8\7p\2\2\u01c8\u01c9\7i\2\2\u01c9x\3\2\2\2\u01ca"+
		"\u01cb\7\'\2\2\u01cbz\3\2\2\2\u01cc\u01cd\7f\2\2\u01cd\u01ce\7q\2\2\u01ce"+
		"\u01cf\7e\2\2\u01cf\u01d0\7k\2\2\u01d0\u01d1\7p\2\2\u01d1\u01d2\7h\2\2"+
		"\u01d2\u01d3\7q\2\2\u01d3|\3\2\2\2\u01d4\u01d5\7>\2\2\u01d5\u01d6\7\60"+
		"\2\2\u01d6\u01d7\7\60\2\2\u01d7\u01d8\7\60\2\2\u01d8\u01d9\7.\2\2\u01d9"+
		"~\3\2\2\2\u01da\u01db\7u\2\2\u01db\u01dc\7g\2\2\u01dc\u01dd\7n\2\2\u01dd"+
		"\u01de\7h\2\2\u01de\u0080\3\2\2\2\u01df\u01e0\7+\2\2\u01e0\u0082\3\2\2"+
		"\2\u01e1\u01e2\7/\2\2\u01e2\u0084\3\2\2\2\u01e3\u01e4\7k\2\2\u01e4\u01e5"+
		"\7o\2\2\u01e5\u01e6\7r\2\2\u01e6\u01e7\7q\2\2\u01e7\u01e8\7t\2\2\u01e8"+
		"\u01e9\7v\2\2\u01e9\u0086\3\2\2\2\u01ea\u01eb\7t\2\2\u01eb\u01ec\7g\2"+
		"\2\u01ec\u01ed\7c\2\2\u01ed\u01ee\7n\2\2\u01ee\u0088\3\2\2\2\u01ef\u01f1"+
		"\t\2\2\2\u01f0\u01f2\5\u0097L\2\u01f1\u01f0\3\2\2\2\u01f1\u01f2\3\2\2"+
		"\2\u01f2\u008a\3\2\2\2\u01f3\u01f5\7]\2\2\u01f4\u01f6\t\3\2\2\u01f5\u01f4"+
		"\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"\u0201\3\2\2\2\u01f9\u01fa\7`\2\2\u01fa\u01fe\t\4\2\2\u01fb\u01fd\t\5"+
		"\2\2\u01fc\u01fb\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe"+
		"\u01ff\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u01f9\3\2"+
		"\2\2\u0201\u0202\3\2\2\2\u0202\u0213\3\2\2\2\u0203\u0205\7\61\2\2\u0204"+
		"\u0206\t\3\2\2\u0205\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0205\3\2"+
		"\2\2\u0207\u0208\3\2\2\2\u0208\u0211\3\2\2\2\u0209\u020a\7`\2\2\u020a"+
		"\u020e\t\4\2\2\u020b\u020d\t\5\2\2\u020c\u020b\3\2\2\2\u020d\u0210\3\2"+
		"\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0212\3\2\2\2\u0210"+
		"\u020e\3\2\2\2\u0211\u0209\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0214\3\2"+
		"\2\2\u0213\u0203\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0215\3\2\2\2\u0215"+
		"\u0216\7_\2\2\u0216\u008c\3\2\2\2\u0217\u021b\t\3\2\2\u0218\u021a\t\6"+
		"\2\2\u0219\u0218\3\2\2\2\u021a\u021d\3\2\2\2\u021b\u0219\3\2\2\2\u021b"+
		"\u021c\3\2\2\2\u021c\u008e\3\2\2\2\u021d\u021b\3\2\2\2\u021e\u0223\7$"+
		"\2\2\u021f\u0222\5\u00a3R\2\u0220\u0222\n\7\2\2\u0221\u021f\3\2\2\2\u0221"+
		"\u0220\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2\2\u0223\u0224\3\2"+
		"\2\2\u0224\u0226\3\2\2\2\u0225\u0223\3\2\2\2\u0226\u0227\7$\2\2\u0227"+
		"\u0090\3\2\2\2\u0228\u022d\7)\2\2\u0229\u022c\5\u00a3R\2\u022a\u022c\n"+
		"\b\2\2\u022b\u0229\3\2\2\2\u022b\u022a\3\2\2\2\u022c\u022f\3\2\2\2\u022d"+
		"\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0230\3\2\2\2\u022f\u022d\3\2"+
		"\2\2\u0230\u0231\7)\2\2\u0231\u0092\3\2\2\2\u0232\u0233\7]\2\2\u0233\u0234"+
		"\5\u0095K\2\u0234\u0235\7_\2\2\u0235\u0094\3\2\2\2\u0236\u0237\7?\2\2"+
		"\u0237\u0238\5\u0095K\2\u0238\u0239\7?\2\2\u0239\u0243\3\2\2\2\u023a\u023e"+
		"\7]\2\2\u023b\u023d\13\2\2\2\u023c\u023b\3\2\2\2\u023d\u0240\3\2\2\2\u023e"+
		"\u023f\3\2\2\2\u023e\u023c\3\2\2\2\u023f\u0241\3\2\2\2\u0240\u023e\3\2"+
		"\2\2\u0241\u0243\7_\2\2\u0242\u0236\3\2\2\2\u0242\u023a\3\2\2\2\u0243"+
		"\u0096\3\2\2\2\u0244\u0246\5\u00a9U\2\u0245\u0244\3\2\2\2\u0246\u0247"+
		"\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0098\3\2\2\2\u0249"+
		"\u024a\7\62\2\2\u024a\u024c\t\t\2\2\u024b\u024d\5\u00abV\2\u024c\u024b"+
		"\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024f"+
		"\u009a\3\2\2\2\u0250\u0252\5\u00a9U\2\u0251\u0250\3\2\2\2\u0252\u0253"+
		"\3\2\2\2\u0253\u0251\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0255\3\2\2\2\u0255"+
		"\u0259\7\60\2\2\u0256\u0258\5\u00a9U\2\u0257\u0256\3\2\2\2\u0258\u025b"+
		"\3\2\2\2\u0259\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025d\3\2\2\2\u025b"+
		"\u0259\3\2\2\2\u025c\u025e\5\u009fP\2\u025d\u025c\3\2\2\2\u025d\u025e"+
		"\3\2\2\2\u025e\u0270\3\2\2\2\u025f\u0261\7\60\2\2\u0260\u0262\5\u00a9"+
		"U\2\u0261\u0260\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0261\3\2\2\2\u0263"+
		"\u0264\3\2\2\2\u0264\u0266\3\2\2\2\u0265\u0267\5\u009fP\2\u0266\u0265"+
		"\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0270\3\2\2\2\u0268\u026a\5\u00a9U"+
		"\2\u0269\u0268\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u0269\3\2\2\2\u026b\u026c"+
		"\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u026e\5\u009fP\2\u026e\u0270\3\2\2"+
		"\2\u026f\u0251\3\2\2\2\u026f\u025f\3\2\2\2\u026f\u0269\3\2\2\2\u0270\u009c"+
		"\3\2\2\2\u0271\u0272\7\62\2\2\u0272\u0274\t\t\2\2\u0273\u0275\5\u00ab"+
		"V\2\u0274\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0274\3\2\2\2\u0276"+
		"\u0277\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u027c\7\60\2\2\u0279\u027b\5"+
		"\u00abV\2\u027a\u0279\3\2\2\2\u027b\u027e\3\2\2\2\u027c\u027a\3\2\2\2"+
		"\u027c\u027d\3\2\2\2\u027d\u0280\3\2\2\2\u027e\u027c\3\2\2\2\u027f\u0281"+
		"\5\u00a1Q\2\u0280\u027f\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0297\3\2\2"+
		"\2\u0282\u0283\7\62\2\2\u0283\u0284\t\t\2\2\u0284\u0286\7\60\2\2\u0285"+
		"\u0287\5\u00abV\2\u0286\u0285\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0286"+
		"\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028b\3\2\2\2\u028a\u028c\5\u00a1Q"+
		"\2\u028b\u028a\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u0297\3\2\2\2\u028d\u028e"+
		"\7\62\2\2\u028e\u0290\t\t\2\2\u028f\u0291\5\u00abV\2\u0290\u028f\3\2\2"+
		"\2\u0291\u0292\3\2\2\2\u0292\u0290\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294"+
		"\3\2\2\2\u0294\u0295\5\u00a1Q\2\u0295\u0297\3\2\2\2\u0296\u0271\3\2\2"+
		"\2\u0296\u0282\3\2\2\2\u0296\u028d\3\2\2\2\u0297\u009e\3\2\2\2\u0298\u029a"+
		"\t\n\2\2\u0299\u029b\t\13\2\2\u029a\u0299\3\2\2\2\u029a\u029b\3\2\2\2"+
		"\u029b\u029d\3\2\2\2\u029c\u029e\5\u00a9U\2\u029d\u029c\3\2\2\2\u029e"+
		"\u029f\3\2\2\2\u029f\u029d\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u00a0\3\2"+
		"\2\2\u02a1\u02a3\t\f\2\2\u02a2\u02a4\t\13\2\2\u02a3\u02a2\3\2\2\2\u02a3"+
		"\u02a4\3\2\2\2\u02a4\u02a6\3\2\2\2\u02a5\u02a7\5\u00a9U\2\u02a6\u02a5"+
		"\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9"+
		"\u00a2\3\2\2\2\u02aa\u02ab\7^\2\2\u02ab\u02af\t\r\2\2\u02ac\u02af\5\u00a5"+
		"S\2\u02ad\u02af\5\u00a7T\2\u02ae\u02aa\3\2\2\2\u02ae\u02ac\3\2\2\2\u02ae"+
		"\u02ad\3\2\2\2\u02af\u00a4\3\2\2\2\u02b0\u02b1\7^\2\2\u02b1\u02bc\5\u00a9"+
		"U\2\u02b2\u02b3\7^\2\2\u02b3\u02b4\5\u00a9U\2\u02b4\u02b5\5\u00a9U\2\u02b5"+
		"\u02bc\3\2\2\2\u02b6\u02b7\7^\2\2\u02b7\u02b8\t\16\2\2\u02b8\u02b9\5\u00a9"+
		"U\2\u02b9\u02ba\5\u00a9U\2\u02ba\u02bc\3\2\2\2\u02bb\u02b0\3\2\2\2\u02bb"+
		"\u02b2\3\2\2\2\u02bb\u02b6\3\2\2\2\u02bc\u00a6\3\2\2\2\u02bd\u02be\7^"+
		"\2\2\u02be\u02bf\7z\2\2\u02bf\u02c0\5\u00abV\2\u02c0\u02c1\5\u00abV\2"+
		"\u02c1\u00a8\3\2\2\2\u02c2\u02c3\t\5\2\2\u02c3\u00aa\3\2\2\2\u02c4\u02c5"+
		"\t\17\2\2\u02c5\u00ac\3\2\2\2\u02c6\u02c7\7\61\2\2\u02c7\u02c8\7,\2\2"+
		"\u02c8\u02cc\3\2\2\2\u02c9\u02cb\13\2\2\2\u02ca\u02c9\3\2\2\2\u02cb\u02ce"+
		"\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cd\u02cf\3\2\2\2\u02ce"+
		"\u02cc\3\2\2\2\u02cf\u02d0\7,\2\2\u02d0\u02d1\7\61\2\2\u02d1\u02d2\3\2"+
		"\2\2\u02d2\u02d3\bW\2\2\u02d3\u00ae\3\2\2\2\u02d4\u02d5\7\61\2\2\u02d5"+
		"\u02d6\7\61\2\2\u02d6\u02dd\3\2\2\2\u02d7\u02d9\n\20\2\2\u02d8\u02d7\3"+
		"\2\2\2\u02d9\u02dc\3\2\2\2\u02da\u02d8\3\2\2\2\u02da\u02db\3\2\2\2\u02db"+
		"\u02de\3\2\2\2\u02dc\u02da\3\2\2\2\u02dd\u02da\3\2\2\2\u02dd\u02de\3\2"+
		"\2\2\u02de\u02e2\3\2\2\2\u02df\u02e1\5\u00b3Z\2\u02e0\u02df\3\2\2\2\u02e1"+
		"\u02e4\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e5\3\2"+
		"\2\2\u02e4\u02e2\3\2\2\2\u02e5\u02e6\bX\3\2\u02e6\u00b0\3\2\2\2\u02e7"+
		"\u02e9\t\21\2\2\u02e8\u02e7\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02e8\3"+
		"\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02ed\bY\4\2\u02ed"+
		"\u00b2\3\2\2\2\u02ee\u02f0\7\17\2\2\u02ef\u02ee\3\2\2\2\u02ef\u02f0\3"+
		"\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02f2\7\f\2\2\u02f2\u02f3\3\2\2\2\u02f3"+
		"\u02f4\bZ\5\2\u02f4\u00b4\3\2\2\2.\2\u01f1\u01f7\u01fe\u0201\u0207\u020e"+
		"\u0211\u0213\u021b\u0221\u0223\u022b\u022d\u023e\u0242\u0247\u024e\u0253"+
		"\u0259\u025d\u0263\u0266\u026b\u026f\u0276\u027c\u0280\u0288\u028b\u0292"+
		"\u0296\u029a\u029f\u02a3\u02a8\u02ae\u02bb\u02cc\u02da\u02dd\u02e2\u02ea"+
		"\u02ef";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}