package com.deprosun.mapperlangplugin.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.BAD_CHARACTER; // Pre-defined bad character token.
import static com.intellij.psi.TokenType.WHITE_SPACE; // Pre-defined whitespace character token.
import static com.deprosun.mapperlangplugin.psi.SimpleTypes.*; // Note that is the class which is specified as `elementTypeHolderClass`
// in bnf grammar file. This will contain all other tokens which we will use.

%%

%public
%class MapperLexer // Name of the lexer class which will be generated.
%implements FlexLexer
%function advance
%type IElementType
%unicode

// We define various Lexer rules as regular expressions first.

// If some character sequence is matched to this regex, it will be treated as an IDENTIFIER.
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

NUM=[\d]+

PK=[pP][kK]

FK=[fF][kK]

// If some character sequence is matched to this regex, it will be treated as a WHITE_SPACE.
WHITE_SPACE=[ \t\n\x0B\f\r]+

// Initial state. We can specify mutiple states for more complex grammars. This corresponds to `modes` in ANTLR grammar.
%%
<YYINITIAL> {
  // In here, we match keywords. So if a keyword is found, this returns a token which corresponds to that keyword.
  // These tokens are generated using the `Ballerina.bnf` file and located in the SimpleTypes `class`.
  // These tokens are Parser uses these return values to match token squence to a parser rule.
  "SOURCE"           { return SOURCE_WORD; }
  "MAPPING"          { return MAPPING_WORD; }
  "FROM"             { return FROM_WORD; }
  "Reference"        { return REFERENCE_WORD; }
  "ConcatBy"         { return CONCAT_BY_WORD;}
  "ReferenceType"    { return REFERENCE_TYPE_WORD; }
  "Reference"        { return REFERENCE_WORD; }
  "="                { return EQUAL; }
  "NOT"              { return NOT ;}
  "NULL"             { return NULL ;}
  "["                { return OPEN_SQUARE ;}
  "]"                { return CLOSE_SQUARE ;}
  "("                { return OPEN_PARENTH ;}
  ")"                { return CLOSE_PARENTH ;}
  "."                { return DOT ;}
  ","                { return COMMA ;}

  // In here, we check for character sequences which matches regular expressions which we defined above.
  {PK}               { return PK; }
  {FK}               { return FK; }
  {NUM}              { return NUM; }
  {IDENTIFIER}       { return ID; } // This indicates that a character sequence which matches to the rule
//  {SYMBOL}           { return SYMBOL; }
  {WHITE_SPACE}      { return WHITE_SPACE; } // This indicates that a character sequence which matches to the rule
                                             // whitespace is encountered.
}

// If the character sequence does not match any of the above rules, we return BAD_CHARACTER which indicates that
// there is an error in the character sequence. This is used to highlight errors.
[^] { return BAD_CHARACTER; }