package gramaticaCLRS;
import java_cup.runtime.Symbol;

%%
%public
%class AnalizadorLexico
%cup
%cupdebug
%line 
%column

/*Identificadores*/
Letra = [a-zA-Z]
Letra2 = [A-Z]
Numero = [0123456789]
EspacioBajo = [_]
Coma = [,]
Hashtag = [#]
Salto = \r|\n|\r\n
Espacio = {Salto} | [\t\f]

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
    ","                                                                     {return symbol(sym.COMA);}
    {Espacio}*                                                               {/*Ignore*/}
    ":"                                                                     {return symbol(sym.DOS_PUNTOS);}
    "{"                                                                     {return symbol(sym.LLAVE_A);}
    "}"                                                                     {return symbol(sym.LLAVE_B);}
    "COLORES"                                                               {return symbol(sym.COLORES);}
    "Red"                                                                   {return symbol(sym.Red);}
    "Blue"                                                                  {return symbol(sym.Blue);}
    "Green"                                                                 {return symbol(sym.Green);}
    "HEX"                                                                   {return symbol(sym.HEX);}
    ("(-"{Numero}+")") | {Numero}+                                          {return symbol(sym.NUMERO, new Integer(yytext()));}
    ({Letra}|{EspacioBajo})({Letra}|{EspacioBajo}|{Numero})*                {return symbol(sym.ID, new String(yytext()));}
    ({Hashtag})({Letra}|{Numero})*                                         {return symbol(sym.codigoHex, new String(yytext()));}       
    .                                                                       {}
}