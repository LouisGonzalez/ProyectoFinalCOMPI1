package gramaticaTMP;
import java_cup.runtime.Symbol;

%%
%public 
%class AnalizadorLexico4
%cup
%cupdebug
%line
%column

/*Identificadores*/
Letra = [a-zA-Z]
Letra2 = [A-Z]
Numero = [0123456789]
EspacioBajo = [_]
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
    ","                                                                 {return symbol(sym.COMA);}
    {Espacio}*                                                           {/*Ignore*/}
    ":"                                                                 {return symbol(sym.DOS_PUNTOS);}
    "\""                                                                {return symbol(sym.COMILLAS);}
    "{"                                                                 {return symbol(sym.LLAVE_A);}
    "}"                                                                 {return symbol(sym.LLAVE_B);}
    "["                                                                 {return symbol(sym.AGRUPACION_A);}
    "]"                                                                 {return symbol(sym.AGRUPACION_B);}
    "TIEMPOS"                                                           {return symbol(sym.TIEMPOS);}
    "inicio"                                                            {return symbol(sym.inicio);}
    "fin"                                                               {return symbol(sym.fin);}
    "imagenes"                                                          {return symbol(sym.imagenes);}
    "id"                                                                {return symbol(sym.id);}
    "duracion"                                                          {return symbol(sym.duracion);}
    ("(-"{Numero}+")") | {Numero}+                                      {return symbol(sym.NUMERO, new Integer(yytext()));}
    ({Letra}|{EspacioBajo})({Letra}|{EspacioBajo}|{Numero})*            {return symbol(sym.ID, new String(yytext()));}        
    .                                                                   {}
}