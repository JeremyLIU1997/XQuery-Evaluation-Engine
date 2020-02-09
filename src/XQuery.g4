
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
  var                   # xq_var
| stringconst           # xq_str
| ap                    # xq_ap
| '(' xq ')'            # xq_paren
| xq ',' xq             # xq_comma
| xq DOUBLESLASH rp     # xq_double_slash_rp
| xq SLASH rp           # xq_slash_rp
| '<' tagname '>' '{' xq '}' '<' SLASH tagname '>'   # xq_constructor
| forClause letClause? whereClause? returnClause     # xq_FLWR
| letClause             # xq_let
;

stringconst:
  STRING
| FILENAME
;

var: '$' tagname;

/* forClause → for Var1 in XQ1,Var2 in XQ2,...,Varn in XQn */
forClause:
FOR var IN xq (',' FOR var IN xq)*
;

/* letClause → ε | letVarn+1 :=XQn+1,...,Varn+k :=XQn+k */
letClause:
LET var ':=' xq (',' LET var ':=' xq)*
;

/* whereClause → ε | where Cond */
whereClause:
WHERE condition
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
| SOME var IN xq (',' var IN xq)* SATISFIES condition       # cond_some
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
    'doc' LPAREN filename RPAREN DOUBLESLASH rp     # ap_double_slash
|   'doc' LPAREN filename RPAREN SLASH rp           # ap_slash
;

/*
(relative path) rp -> tagName|∗|.|..|text()|@attName
                | (rp) | rp1/rp2 | rp1//rp2 | rp[f] | rp1,rp2
*/
rp:
tagname             # rp_tag
| '*'               # rp_anyTag
| '.'               # rp_self
| '..'              # rp_parent
| 'text()'          # rp_text
| '@' attriname     # rp_att
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

filename: FILENAME ;
tagname: NAMESTRING ;
attriname: NAMESTRING ;

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

//NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t\n]+ -> skip ; // toss out whitespace

FILENAME: '"' [a-zA-Z0-9./_]* '"' ;
STRING: '"' [a-zA-Z0-9./_,:;=()&^%$#@!~`\\|?<>]* '"' ;
NAMESTRING: [a-zA-Z0-9_]+ ;

DOUBLESLASH: '//' ;
SLASH: '/' ;

LPAREN: '(' ;
RPAREN: ')' ;

