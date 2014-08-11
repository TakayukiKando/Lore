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
    : 'encoding' '=' shortStringLiteral
    ;

version
    : 'version' '=' url
    ;

description
    : 'desc' '(' shortStringLiteral ')' '{' ( stringLiteral | html )? '}'
    ;

author
    : 'author' '(' shortStringLiteral ')' '{' ((jid|url) (',' (jid|url)*)?) '}'
    ;

history
    : 'history' '(' date ')' '{' 'reviser' '=' shortStringLiteral ',' 'desc' '=' stringLiteral '}'
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
    : simpleName ('.' simpleName )*
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
    : 'enum' simpleName (extends_from)?'{' enum_elem+ '}'
    ;

extends_from
    : 'extends' qName
    ;

enum_elem
    : simpleName (( '{' enum_field (enum_field)* '}' )|';')
    ;

enum_field
    : simpleName '=' expression ';'
    ;

unit_def
    : unitName '=' ( integral | real ) (unitName)? ';'
    ;

form_def
    : 'form' simpleName (extends_from)? form_cont_def
    ;

form_cont_def
    : '{' (private_member_def | member_def)* '}'
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
    : ('override')? initializer
    ;
    
initializer
    : var_def
    | accessor_def
    | alter_def
    | rule_def
    | function_def
    ;

field_decl
    : type_spec ';'
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
    : lambda_type_full
    | lambda_type_no_param
    | lambda_type_no_return
    | lambda_type_no_param_no_return
    ;
lambda_type_full
    : '@' '<' lambda_type_parameters '->' type_expr '>'
    ;

lambda_type_no_param
    : '@' '<' '->' type_expr '>'
    ;

lambda_type_no_return
    : '@' '<'lambda_type_parameters '>'
    ;

lambda_type_no_param_no_return
    : '@' '<' '>'
    ;

lambda_type_parameters
    : '(' (type_expr (',' type_expr)*)? ')'
    | type_expr
    ;

list_type
    : 'list' '<'type_expr'>'
    ;

unit_type
    :'unit' unitName
    ;

range_type
    : 'range''<'arithmetic_type'>'
    ;

builtin_type
    : arithmetic_type
    | textual_type
    | trpg_type
    ;
    
textual_type
    : 'string'
    | 'url'
    | 'jid'
    | 'html'
    | 'xml'
    | 'date'
    ;

trpg_type
    : 'loc'
    | 'dice'
    ;

arithmetic_type
    : 'number'
    | 'integer'
    | 'real'
    ;

// function / rule / accessor / alter
rule_def
    : 'rule' simpleName (parameters)? block 
    ;

function_def
    : 'function' simpleName (parameters)? '->' type_expr block
    ;

accessor_def
    : simpleName (parameters)? '->' type_expr block
    ;

alter_def
    : 'alter' simpleName '(' type_spec ')' block
    ;

parameters
    : ('('type_spec (',' type_spec)*')')
    | '()'
    ;

type_spec
    :simpleName ':' type_expr
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
    : simpleName '=' expression ';'
    ;

//field modification.
//This syntax is only permitted to use in the "alter" type method.
field_modify
    : self '.' simpleName '=' expression ';'
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
    : 'as' '(' type_spec ')' block
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
    : factor (('*' | '/' | '%') factor)*
    ;

factor
    : ( '-' )? post_op
    ;

post_op
    : monomial
    | unit_monomial
    | dice_monomial
    ;

unit_monomial
    : monomial unitName
    ;

dice_monomial
    : monomial diceKind
    | diceKind
    ;

monomial
    : atom ( member_access )*
    ;

member_access
    : '.' simpleName (args)?
    ;

args
    : '(' expression (',' expression )* ')'
    ;

atom
    : self
    | qName
    | simpleCall
    | literal
    | '(' expression ')'
    | list_construct
    | form_construct
    | builtin_type_expr
    ;
    
self
    : 'self'
    ;

simpleCall
    : qName args
    ;

list_construct
    : '{' expression (',' expression)* '}'
    ;

form_construct
    : form_contents (':' qName)?
    ;

form_contents
    : '{' (member_initializer)+ '}'
    ;

lambda
    : lambda_full
    | lambda_no_param
    | lambda_no_return
    | lambda_no_param_no_return
    ;

lambda_full
    : '@' lambda_parameters '->' type_expr lambda_block
    ;

lambda_no_param
    : '@' ('(' ')' )? '->' type_expr lambda_block
    ;

lambda_no_return
    : '@' lambda_parameters lambda_block
    ;

lambda_no_param_no_return
    : '@' ('(' ')' )? lambda_block
    ;

lambda_parameters
    : '(' type_spec (',' type_spec)* ')'
    | type_spec
    ;

lambda_block
    : block
    | expression
    ;

//literals
literal
    : integral
    | real
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
    : shortStringLiteral ':' 'url'
    ;

date
    : shortStringLiteral ':' 'date'
    ;


jid
    : shortStringLiteral ':' 'jid'
    ;

loc
    : shortStringLiteral ':' 'loc'
    ;

stringLiteral
    : NORMALSTRING | CHARSTRING | LONGSTRING
    ;

shortStringLiteral
    : NORMALSTRING | CHARSTRING
    ;

integral
    : INT
    | HEX
    ;

real
    : FLOAT
    | HEX_FLOAT
    ;

diceKind
    : DICE
    ;

unitName
    : UNIT_NAME
    ;

simpleName
    : NAME
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
    : ('/*' .*? '*/')-> channel(HIDDEN)
    ;
    
LINE_COMMENT
//  : '//' '['? (~('['|'\n'|'\r') ~('\n'|'\r')*)? ('\n'|'\r')* -> channel(HIDDEN)
    : ('//' (~('\r' | '\n')*)? (NEWLINE)*) -> channel(HIDDEN)
    ;
    
WS
    : [ \t\u000C]+ -> skip
    ;
    
NEWLINE
    : '\r'? '\n' -> skip
    ;
