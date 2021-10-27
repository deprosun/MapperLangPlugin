package com.deprosun.mapperlangplugin.lexer;

import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.deprosun.mapperlangplugin.psi.SimpleTypes.*;
import com.intellij.lexer.FlexLexer;

%%

%{
  public _MapperLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _MapperLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
//these don't work yet idk why. I think CUP doesn't work with IntelliJ stuff
//%column
//%line
//%cup

//User code to add to the lexer class
//%{
//    private String filterClause = "";
//%}

EOL=\R
WHITE_SPACE=\s+

SPACES=[ \t\n\x0B\f\r]+
NUMBER=[0-9]+(\.[0-9]*)?
COMMENT="//".*
ID=[:letter:][a-zA-Z_0-9]*

%states WAITING_FOR_EVALUATED_ID

%%

{WHITE_SPACE}      { return WHITE_SPACE; }

<YYINITIAL> {
    "="                { return EQ; }
    "("                { return LP; }
    ")"                { return RP; }
    "."                { return DOT; }
    "`"                { yybegin(WAITING_FOR_EVALUATED_ID); return TILDE; }
    "TOPIC"            { return TOPIC; }
    "FROM"             { return FROM; }
    "FILTER"           { return FILTER; }
    "MAPPING"          { return MAPPING; }
    "LIST"             { return LIST; }
    "EXPLODE"          { return EXPLODE; }
    "OBJECT"           { return OBJECT; }
    "PK"               { return PK; }
    "FK"               { return FK; }
    "REFERENCE"        { return REFERENCE; }
    "NOT"              { return NOT; }
    "NULL"             { return NULL; }
    //"NUM"              { return NUM; }
    "BROADCAST"        { return BROADCAST; }
    "AS"               { return AS; }
    //"LITERAL"          { return LITERAL; }
    //"LIT"              { return LIT; }
    "STRING"           { return STRING; }
    "INT"              { return INT; }
    "DECIMAL"          { return DECIMAL; }

    {SPACES}           { return SPACES; }
    {NUMBER}           { return NUMBER; }
    {COMMENT}          { return COMMENT; }
    {ID}               { return ID; }

}

<WAITING_FOR_EVALUATED_ID> {
    "("                { return LP; }
    ")"                { return RP; }
    "."                { return DOT; }
    "`"                { yybegin(YYINITIAL); return TILDE; }
    {ID}               { return ID; }
}

[^] { return BAD_CHARACTER; }
