grammar XQuery;

prog:
xquery EOF
;


xquery: var                                                     #xqueryVariable
        |Stringconstant                                         #xqueryStringConstant
        |ap                                                  #xqueryAbsolutePath
        |'('xquery')'                                           #priorityXquery
        |xquery','xquery                                        #twoXquery
        |xquery'/'rp                                            #xqueryRpChildren
        |xquery'//'rp                                           #xqueryRpAll
        |'<'tagName'>' '{'xquery'}''<''/'tagName'>'                #xqueryTagName
        | forclause (letclause)? (whereclause)? returnclause    #xqueryForClause
        | letclause xquery                                      #xqueryLetClause
        ;


var :'$' tagName;

forclause: 'for' var 'in' xquery (',' var 'in' xquery)*;

letclause: 'let' var ':=' xquery (',' var ':=' xquery)*;

whereclause: 'where' condition ;

returnclause: 'return'  xquery ;



condition: xquery '=' xquery                                                    #conditionEqual
            | xquery 'eq' xquery                                                     #conditionEqual
            | xquery '==' xquery                                                     #conditionSame
            | xquery 'is' xquery                                                     #conditionSame
            | 'empty''(' xquery ')'                                                    #conditionIsEmpty
            |  'some' var 'in' xquery (',' var 'in' xquery)* 'satisfies' condition   #conditionSome
            | '(' condition ')'                                                      #conditionPriority
            |   condition  'and'  condition                                              #conditionAnd
            |   condition 'or'  condition                                        #conditionOr
            | 'not' condition                                                       #conditionNot
            ;



query : ap                                  #AbsolutePath
    | rp                                    #RelativePath
    | f                                     #Filter
;



rp : rp'/'rp                                # RpChildren
    | tagName                               # RpTag
    | '*'                                   # RpAllChildren
    | '.'                                   # RpCurrent
    | '..'                                  # RpParent
    | 'text()'                              # RpText
    | '@'attName                            # RpAttribute
    | '('rp')'                              # RpFirst
    |  rp'//'rp                             # RpAll
    | rp'['f']'                             # RpFilter
    | rp','rp                               # RpTwo
    ;
//rp : rp '/' rp | 'a';

f : rp                                      # FilterRp
    | rp '=' rp          EOF                   # FilterEqual
    | rp 'eq' rp                            # FilterEqual
    | rp '==' rp                            # FilterIs
    | rp 'is' rp                            # FilterIs
    | '('f')'                               # FilterFirst
    | f ' and ' f                             # FilterAnd
    | f 'or' f                              # FilterOr
    | 'not' f                               # FilterNot
;
ap : 'doc("' fileName '")' '/'rp              # ApChildren
    | 'doc("' fileName '")' '//'rp            # ApAll
;
fileName : ID '.'* ID ;

tagName : ID;

attName : ID;


ID:('a'..'z'|'A'..'Z'|'0'..'9'|'-'|'_')+;
Stringconstant:'"'+[a-zA-Z0-9,.!?;' "-]+'"';
INT:'0'..'9'+;
//NEWLINE:'\r'?'\n'->skip;
WS:[ \t\r\n]+ -> skip;





