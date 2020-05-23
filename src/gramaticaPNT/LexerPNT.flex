package gramaticaPNT;
import java_cup.runtime.Symbol;

%%
%public
%class AnalizadorLexico3
%cup
%cupdebug
%line
%column

/*Identificadores*/

Letra = [a-zA-Z]
Numero = [0123456789]
EspacioBajo = [_]
Menor = [-]
Salto = \r|\n|\r\n
Espacio = {Salto} | [\t\f]
Espacio2 = [ \t\f]

%{

    private Symbol symbol(int tipo){
        return new Symbol(tipo, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int tipo, Object value){
        return new Symbol(tipo, yyline+1, yycolumn+1, value);
    }

%}

%%

<YYINITIAL>{
    ","                                                             {return symbol(sym.COMA);} 
    "//"                                                            {return symbol(sym.COMENTARIO_A);}
    ";"                                                             {return symbol(sym.PUNTO_COMA);}
    "\""                                                            {return symbol(sym.COMILLAS);}
    ".."                                                            {return symbol(sym.RANGO);}
    "=="                                                            {return symbol(sym.DOBLE_IGUAL);}
    "="                                                             {return symbol(sym.IGUAL);}
    "<"                                                             {return symbol(sym.MENOR);}
    ">"                                                             {return symbol(sym.MAYOR);}
    "<="                                                            {return symbol(sym.MENOR_IGUAL);}
    ">="                                                            {return symbol(sym.MAYOR_IGUAL);}
    "<>"                                                            {return symbol(sym.DIFERENCIA);}
    "{"                                                             {return symbol(sym.LLAVE_A);}
    "}"                                                             {return symbol(sym.LLAVE_B);}
    "("                                                             {return symbol(sym.PARENTESIS_A);}
    ")"                                                             {return symbol(sym.PARENTESIS_B);}
    "["                                                             {return symbol(sym.AGRUPACION_A);}
    "]"                                                             {return symbol(sym.AGRUPACION_B);}
    "+"                                                             {return symbol(sym.MAS);}
    "-"                                                             {return symbol(sym.MENOS);}
    "*"                                                             {return symbol(sym.POR);}
    "/"                                                             {return symbol(sym.DIV);}
    "/*"                                                            {return symbol(sym.COMENTARIO_B_A);}
    "*/"                                                            {return symbol(sym.COMENTARIO_B_B);}
    "VARS"                                                          {return symbol(sym.VARS);}
    "int"                                                           {return symbol(sym.INT);}
    "String"                                                        {return symbol(sym.STRING);}
    "boolean"                                                       {return symbol(sym.BOOLEAN);}
    "true"                                                          {return symbol(sym.TRUE);}
    "false"                                                         {return symbol(sym.FALSE);}
    "INSTRUCCIONES"                                                 {return symbol(sym.INSTRUCCIONES);}
    "PINTAR"                                                        {return symbol(sym.PINTAR);}
    "AND"                                                           {return symbol(sym.AND);}
    "OR"                                                            {return symbol(sym.OR);}
    "if"                                                            {return symbol(sym.IF);}
    "else"                                                          {return symbol(sym.ELSE);}
    "while"                                                         {return symbol(sym.WHILE);}
    "-"{Numero}+ | {Numero}+                                             {return symbol(sym.NUMERO, new Integer(yytext()));}
    ({Letra}|{EspacioBajo})({Letra}|{EspacioBajo}|{Numero})*             {return symbol(sym.ID, new String(yytext()));} 
    {Espacio}*                                                           {/*Ignore*/}
    .                                                                    {}
}

