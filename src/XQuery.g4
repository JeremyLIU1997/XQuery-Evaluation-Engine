
grammar XQuery;

/* Parser rules: */
/* The start rule ap (absolute path), parsing begins here */
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
TAGNAME             # rp_tag
| '*'               # rp_anyTag
| '.'               # rp_self
| '..'              # rp_parent
| 'text()'          # rp_text
| '@' ATTRINAME     # rp_att
| LPAREN rp RPAREN  # rp_paren
| rp DOUBLESLASH rp # rp_double_slash
| rp SLASH rp       # rp_slash // should I use slash? here or start another alternative?
| rp '[' filter ']' # rp_filter
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
TAGNAME: NAMESTRING ;
NAMESTRING:
( 'a' .. 'z'
| 'A' .. 'Z'
| '0' .. '9'
| UNDERSCORE
)+        // one or more
;
ATTRINAME: NAMESTRING ;
LPAREN: '(' ;
RPAREN: ')' ;
DOUBLESLASH: '//' ;
SLASH: '/' ;

FILENAME: '"' [a-zA-Z0-9./_]* '"';

UNDERSCORE: '_' ;
EQ: 'eq' ;
IS: 'is' ;
AND: 'and' ;
OR: 'or' ;
NOT: 'not' ;
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace