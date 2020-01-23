
grammar XQuery;

/* Parser rules: */
/* The start rule ap (absolute path), parsing begins here */
/*
(absolute path) ap -> doc(fileName)/rp
                    | doc(fileName)//rp
*/
ap: 'doc' LPAREN FILENAME RPAREN SLASH SLASH? rp ;

/*
(relative path) rp -> tagName|∗|.|..|text()|@attName
                | (rp) | rp1/rp2 | rp1//rp2 | rp[f] | rp1,rp2
*/
rp:
TAGNAME
| '*'
| '.'
| '..'
| 'text()'
| '@' ATTRINAME
| LPAREN rp RPAREN
| rp SLASH SLASH? rp
| rp '[' filter ']'
| rp ',' rp
;

/*
(pathfilter)     f -> rp|rp1 = rp2 |rp1 eq rp2 |rp1 ==rp2 |rp1 is rp2
                    | (f) |f1 andf2 |f1 or f2 | not f
*/
filter:
rp '|' rp
| rp '=' rp
| rp EQ rp
| rp '==' rp
| rp IS rp
| LPAREN filter RPAREN
| filter AND filter
| filter OR filter
| NOT filter
;

/* Lexer rules: */
TAGNAME:
( 'a' .. 'z'
| 'A' .. 'Z'
| '0' .. '9'
| DASH
| UNDERSCORE
)+        // one or more
;

ATTRINAME: TAGNAME ;
LPAREN: '(' ;
RPAREN: ')' ;
SLASH: '/' ;

FILENAME:
'"'
('.'
| 'a' .. 'z'
| 'A' .. 'Z'
| '0' .. '9'
| DASH
| UNDERSCORE
| SLASH
)+        // one or more
'"'
;

DASH: '-' ;
UNDERSCORE: '_' ;
EQ: 'eq' ;
IS: 'is' ;
AND: 'and' ;
OR: 'or' ;
NOT: 'not' ;