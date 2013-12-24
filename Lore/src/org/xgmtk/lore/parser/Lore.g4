/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

grammar Lore;
lore 
    : header section_element*
    ;

//header part

header
    : docinfo? description? author* history* import_other*
    ;

docinfo
    : 'docinfo' '{' ((encoding (',' version)?)|(version (',' encoding)?)) '}'
    ;

encoding
    : 'encoding' '=' NORMALSTRING
    ;

version
    : 'version' '=' url
    ;

description
    : 'desc' '(' stringLiteral ')' '{' ( stringLiteral | html )? '}'
    ;

author
    : 'author' '(' NORMALSTRING ')' '{' ((jid|url) (',' (jid|url)*)?) '}'
    ;

history
    : 'history' '(' date ')' '{' 'reviser' '=' NORMALSTRING ',' 'desc' '=' stringLiteral '}'
    ;

import_other
    : 'import' url ';'
    ;

//body part

section
    : 'section' qName '{' (private_section_element | section_element)* '}'
    ;

private_section_element
    :'private' section_element
    ;

section_element
    : section
    | definition
    ;

qName
    : NAME ('.' NAME)*
    ;

//definition

definition
    : type_def
    | var_def
    | function_def
    | rule_def
    ;

//type definitions

type_def
    : enum_def | unit_def | form_def
    ;

enum_def
    : 'enum' NAME ('extends' qName)?'{' enum_elem+ '}'
    ;

enum_elem
    : NAME (( '{' enum_field (enum_field)* '}' )|';')
    ;

enum_field
    : NAME '=' expression ';'
    ;

unit_def
    : UNIT_NAME '=' number (UNIT_NAME)? ';'
    ;

form_def
    : 'form' NAME ('extends' qName)?'{' (private_member_def | member_def)* '}'
    ;

private_member_def
    : 'private' member_def
    ;

member_def
    : field_decl
    | type_def
    | member_initializer
    ;

member_initializer
    : constant_var_def
    | var_def
    | ('override')? accessor_def
    | ('override')? alter_def
    | ('override')? rule_def
    |  function_def
    ;

constant_var_def
    :'constant' var_def
    ;

field_decl
    : NAME ':' type_expr ';'
    ;

type_expr
    : qName
    | builtin_type_expr
    ;

builtin_type_expr
    : builtin_type
    | list_type
    | unit_type
    | range_type
    | lambda_type
    ;

lambda_type
    : '@' '<'( '(' type_expr ( ',' type_expr )* ')' )? (':' type_expr)? '>'
    ;

list_type
    : 'list' '<'(type_expr| ('?' ('extends' (qName | builtin_type))?) )'>'
    ;

unit_type
    :'unit' UNIT_NAME
    ;

range_type
    : 'range''<'arithmetic_type'>'
    ;

builtin_type
    : arithmetic_type
    | 'string'
    | 'url'
    | 'jid'
    | 'html'
    | 'xml'
    | 'date'
    | 'loc'
    | 'dice'
    ;
arithmetic_type
    : 'number'
    | 'integer'
    | 'real'
    ;

// function / rule / accessor / alter
rule_def
    : 'rule' NAME (parameters)? block 
    ;

function_def
    : 'function' NAME (parameters)?':'type_expr block
    ;

accessor_def
    : NAME (parameters)?':'type_expr block
    ;

alter_def
    : 'alter' NAME '(' NAME ':' list_type ')' block
    ;

parameters
    : ('('NAME ':' type_expr (',' NAME ':' type_expr)*')')
    ;

block
    : '{' statement* '}' 
    ;

statement
    : var_def
    | field_modify
    | function_def
    | type_def
    | procedure_apply
    | select_statement
    | result_statement
    ;
    
procedure_apply
    //This statement is permitted in rule/alter only.
    //Check it in type check phase.
    : monomial ';'
    //| (('(' expression ')' | NAME | builtin_type_expr)( member_access )+) ';'
    ;

select_statement
     : select_expr
     ;

result_statement
    //Check existence of return value in type check phase.
    : 'result' '=' (expression)? ';'
    ;

//variable

var_def
    : NAME '=' expression ';'
    ;

//field modification.
//This syntax is only permitted to use in the "alter" type method.
field_modify
    : ('self' '.')? NAME ':=' expression ';'
    ;

//expressions
expression
    : terms
    | range
    | condition
    | select_expr
    | lambda
    ;

select_expr
    : 'select' '(' expression ')' '{' ( case_block+ | as_block+ )default_block? '}'
    ;

//In this syntax, qName should be an enum's value.
case_block
    : 'case' '(' (literal | qName) ')' block
    ;

as_block
    : 'as' '(' NAME ':' type_expr ')' block
    ;
default_block
    : 'default' block
    ;

range
    : terms(',...,' | '<...,'  | ',...<' | '<...<')terms
    ;

condition
    : cond_term ( ('&' | '|') cond_term )?
    ;

cond_term
    : cond_monomial | relation | '(' condition ')'
    ;

relation
    : terms ('==' | '!=' | '<' | '>' | '<=' | '>=') terms
    ;

cond_monomial
    : '!'? monomial
    ;

terms
    : term ( ( '+' | '-' ) term)*
    ;

term
    : factor (('*' | '/' | '%' | 'D') factor)*
    ;

factor
    : ( '-' )? post_op
    ;

post_op
    : (monomial (UNIT_NAME | DICE)? | DICE)
    ;

monomial
    : atom ( member_access )*
    ;

member_access
    : '.' NAME (args)?
    ;

args
    : '(' expression (',' expression )* ')'
    ;

atom
    : 'self'
    | NAME
    | NAME args
    | literal
    | '(' expression ')'
    | list_construct
    | struct_construct
    | builtin_type_expr
    ;

list_construct
    : '{' expression (',' expression)* '}'
    ;

struct_construct
    : '{' (member_initializer)+ '}' (':' qName)?
    ;

lambda
    : '@' (parameters)?(':' type_expr)? block
    ;

//literals
literal
    : number
    | stringLiteral
    | html
    | xml
    | url
    | jid
    | date
    | loc
    ;

html
    : stringLiteral ':' 'html'
    ;

xml
    : stringLiteral ':' 'xml'
    ;

url
    : stringLiteral ':' 'url'
    ;

date
    : stringLiteral ':' 'date'
    ;


jid
    : stringLiteral ':' 'jid'
    ;

loc
    : stringLiteral ':' 'loc'
    ;

stringLiteral
    : NORMALSTRING | CHARSTRING | LONGSTRING
    ;

number
    : INT | HEX | FLOAT | HEX_FLOAT
    ;

// LEXER

DICE
    : ('d'|'D') INT?
    ;

UNIT_NAME
    : '[' [a-zA-Z_]+ ('^'[1-9][0-9]*)?('/' [a-zA-Z_]+ ('^'[1-9][0-9]*)?)?']'
    ;

NAME
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

NORMALSTRING
    : '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

CHARSTRING
    : '\'' ( EscapeSequence | ~('\''|'\\') )* '\''
    ;

LONGSTRING
    : '[' NESTED_STR ']'
    ;

fragment
NESTED_STR
    : '=' NESTED_STR '='
    | '[' .*? ']'
    ;

INT
    : Digit+
    ;

HEX
    : '0' [xX] HexDigit+
    ;

FLOAT
    : Digit+ '.' Digit* ExponentPart?
    | '.' Digit+ ExponentPart?
    | Digit+ ExponentPart
    ;

HEX_FLOAT
    : '0' [xX] HexDigit+ '.' HexDigit* HexExponentPart?
    | '0' [xX] '.' HexDigit+ HexExponentPart?
    | '0' [xX] HexDigit+ HexExponentPart
    ;

fragment
ExponentPart
    : [eE] [+-]? Digit+
    ;

fragment
HexExponentPart
    : [pP] [+-]? Digit+
    ;

fragment
EscapeSequence
    : '\\' [abfnrtvz"'\\]
    | DecimalEscape
    | HexEscape
    ;
    
fragment
DecimalEscape
    : '\\' Digit
    | '\\' Digit Digit
    | '\\' [0-2] Digit Digit
    ;
    
fragment
HexEscape
    : '\\' 'x' HexDigit HexDigit
    ;

fragment
Digit
    : [0-9]
    ;

fragment
HexDigit
    : [0-9a-fA-F]
    ;

COMMENT
    : '/*' .*? '*/'-> channel(HIDDEN)
    ;
    
LINE_COMMENT
    : '//' '['? (~('['|'\n'|'\r') ~('\n'|'\r')*)? ('\n'|'\r')* -> channel(HIDDEN)
    ;
    
WS
    : [ \t\u000C]+ -> skip
    ;
    
NEWLINE
    : '\r'? '\n' -> skip
    ;
