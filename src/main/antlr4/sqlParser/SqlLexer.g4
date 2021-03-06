grammar SqlLexer;


onesql:stmt;



stmt:
     create_statement |
     insert_statement |
     update_statement |
     delete_statement |
     select_statement ;

create_statement : CREATE TABLE FIRST_CHAR CURVES_LEFT  column_and_type CURVES_RIGHT ;
insert_statement : INSERT INTO FIRST_CHAR VALUES CURVES_LEFT (ident COMMA?)+ CURVES_RIGHT  ;
update_statement : UPDATE FIRST_CHAR SET ident EQUAL ident (WHERE ident EQUAL ident) ;
delete_statement : DELETE FROM FIRST_CHAR WHERE ident EQUAL ident ;
select_statement : SELECT item_list FROM FIRST_CHAR filter_list?;
datatype: INT|FLOAT|DATE| (VARCHAR CURVES_LEFT ident CURVES_RIGHT);
column_and_type: (ident datatype COMMA?)+ ;
item_list: (ident COMMA?)* | STAR;
filter_list: WHERE ident (GREATER|EQUAL|LESS)  ident;
ident:FIRST_NUMBER|FIRST_CHAR;

CREATE: C R E A T E ;
TABLE: T A B L E;
INSERT: I N S E R T;
INTO: I N T O;
VALUES: V A L U E S ;
FROM: F R O M;
WHERE: W H E R E;
UPDATE: U P D A T E ;
SET: S E T;
DELETE: D E L E T E;
SELECT: S E L E C T;
INT:  I N T;
FLOAT: F L O A T;
DATE: D A T E;
VARCHAR: V A R C H A R;
FIRST_NUMBER: DIGIT ([a-zA-Z]|DIGIT)*;
FIRST_CHAR: [a-zA-Z]([a-zA-Z]|DIGIT)* ;//TODO
NUMBER: DIGIT+;
DIGIT: [0-9];
EQUAL: '=';
CURVES_LEFT: '(';
CURVES_RIGHT: ')';
COMMA: ',';
SEMICOLON: ';';
STAR: '*';
GREATER: '>';
LESS: '<';
NEWLINE: '\r'? '\n';
WS  : [ \t]+ -> skip;

//fragment代表只能为词法服务,而不能为语法服务
fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];