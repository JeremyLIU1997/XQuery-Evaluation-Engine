
grammar XQuery;

/* Parser rules: */
/* The start rule xq (xquery), parsing begins here */

/*
XQ → Var | StringConstant | ap
| (XQ1) | XQ1, XQ2 | XQ1/rp| XQ1//rp
| ⟨tagName⟩{X Q1 }⟨/tagName⟩
| forClause letClause whereClause returnClause | letClause XQ1
*/
xq:
  VAR                   # xq_var
| STRING                # xq_str
| ap                    # xq_ap
| '(' xq ')'            # xq_paren
| xq ',' xq             # xq_comma
| xq DOUBLESLASH rp     # xq_double_slash_rp
| xq SLASH rp           # xq_slash_rp
| '<' NAMESTRING '>' '{' xq '}' '<' SLASH NAMESTRING '>'   # xq_constructor   // NAMESTRING here denotes TAGNAME
| forClause letClause whereClause returnClause             # xq_FLWR
| letClause             # xq_let
;

/* forClause → for Var1 in XQ1,Var2 in XQ2,...,Varn in XQn */
forClause:
FOR VAR IN xq (',' FOR VAR IN xq)*
;

/* letClause → ε | letVarn+1 :=XQn+1,...,Varn+k :=XQn+k */
letClause:
             // can be empty
| LET VAR '=' xq (',' LET VAR '=' xq)*
;

/* whereClause → ε | where Cond */
whereClause:
             // can be empty
| WHERE condition
;

/* returnClause → return XQ1 */
returnClause:
RETURN xq
;

/*
Cond → XQ1 = XQ2 | XQ1 eq XQ2 | XQ1==XQ2 | XQ1 is XQ2
| empty(X Q1 )
| some Var1 in XQ1,...,Varn in XQn satisfies Cond
| (Cond1) | Cond1 and Cond2 | Cond1 or Cond2 | not Cond1
*/
condition:
  xq '=' xq             # cond_eq
| xq EQ xq              # cond_eq
| xq '==' xq            # cond_is
| xq IS xq              # cond_is
| EMPTY '(' xq ')'      # cond_empty
| SOME VAR IN xq (',' VAR IN xq)* SATISFIES condition       # cond_some
| LPAREN condition RPAREN   # cond_paren
| condition AND condition   # cond_and
| condition OR condition    # cond_or
| NOT condition             # cond_not
;


/*
(absolute path) ap -> doc(fileName)/rp
                    | doc(fileName)//rp
*/

ap:
    'doc' LPAREN FILENAME RPAREN DOUBLESLASH rp     # ap_double_slash
|   'doc' LPAREN FILENAME RPAREN SLASH rp           # ap_slash
;

/*
(relative path) rp -> tagName|∗|.|..|text()|@attName
                | (rp) | rp1/rp2 | rp1//rp2 | rp[f] | rp1,rp2
*/
rp:
NAMESTRING          # rp_tag // NAMESTRING here is meant to represent tag name
| '*'               # rp_anyTag
| '.'               # rp_self
| '..'              # rp_parent
| 'text()'          # rp_text
| '@' NAMESTRING    # rp_att // NAMESTRING here is meant to represent attribute name
| LPAREN rp RPAREN  # rp_paren
| rp '[' filter ']' # rp_filter
| rp DOUBLESLASH rp # rp_double_slash
| rp SLASH rp       # rp_slash // should I use slash? here or start another alternative?
| rp ',' rp         # rp_comma
;

/*
(pathfilter)     f -> rp | rp1 = rp2 | rp1 eq rp2 | rp1 == rp2 | rp1 is rp2
                    | (f) | f1 andf2 | f1 or f2 | not f
*/
filter:
rp                  # f_rp
| rp '=' rp         # f_eq
| rp EQ rp          # f_eq
| rp '==' rp        # f_is
| rp IS rp          # f_is
| LPAREN filter RPAREN  # f_paren
| filter AND filter     # f_and
| filter OR filter      # f_or
| NOT filter            # f_not
;

/* Lexer rules: */

/* be sure to put this part before tagname/namestring and stuff
 * otherwise the parser may match to tagname/namestring
 * before keywords like 'and' and 'or'.
*/
EQ: 'eq' ;
IS: 'is' ;
AND: 'and' ;
OR: 'or' ;
NOT: 'not' ;

IN: 'in' ;
FOR: 'for' ;
LET: 'let' ;
WHERE: 'where' ;
EMPTY: 'empty' ;
SOME: 'some' ;
SATISFIES: 'satisfies' ;
RETURN: 'return' ;

UNDERSCORE: '_' ;
VAR: '$' NAMESTRING ;

NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace


NAMESTRING:
( 'a' .. 'z'
| 'A' .. 'Z'
| '0' .. '9'
| UNDERSCORE
)+        // one or more
;

STRING:
'"' [a-zA-Z0-9,:;./_=()&^%$#@!~`\\|?<>]* '"'
;

LPAREN: '(' ;
RPAREN: ')' ;
DOUBLESLASH: '//' ;
SLASH: '/' ;

FILENAME: '"' [a-zA-Z0-9./_]* '"';
