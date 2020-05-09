package gramaticaLNZ;
import java_cup.runtime.Symbol;

%%
%public
%class AnalizadorLexico2
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
    ","                                                                 {return symbol(sym.COMA);}
    "{"                                                                 {return symbol(sym.LLAVE_A);}
    "}"                                                                 {return symbol(sym.LLAVE_B);}
    ":"                                                                 {return symbol(sym.DOS_PUNTOS);}
    "\""                                                                {return symbol(sym.COMILLAS);}
    "nombre"                                                            {return symbol(sym.nombre);}
    "tipo"                                                              {return symbol(sym.tipo);}
    "Fondo"                                                             {return symbol(sym.Fondo);}
    "size"                                                              {return symbol(sym.size);}
    "Red"                                                               {return symbol(sym.Red);}
    "Blue"                                                              {return symbol(sym.Blue);}
    "Green"                                                             {return symbol(sym.Green);}
    "cuadro"                                                            {return symbol(sym.cuadro);}
    "dimension_x"                                                       {return symbol(sym.dimension_x);}
    "dimension_y"                                                       {return symbol(sym.dimension_y);}
    "png"                                                               {return symbol(sym.png);}
    "gif"                                                               {return symbol(sym.gif);}
    "HEX"                                                               {return symbol(sym.HEX);}
    "LIENZOS"                                                           {return symbol(sym.LIENZOS);}
    ("(-"{Numero}+")") | {Numero}+                                      {return symbol(sym.NUMERO, new Integer(yytext()));}
    ({Letra}|{EspacioBajo})({Letra}|{EspacioBajo}|{Numero})*            {return symbol(sym.ID, new String(yytext()));}
    ({Hashtag})({Letra}|{Numero})*                                      {return symbol(sym.codigoHex, new String(yytext()));}  
    ({Letra}|{EspacioBajo})({Letra}|{EspacioBajo}|{Numero}|{Espacio2})* {return symbol(sym.PALABRA, new String(yytext()));}
    {Espacio}*                                                           {/*Ignore*/}
    .                                                                   {}
}