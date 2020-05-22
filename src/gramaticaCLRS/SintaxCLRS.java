
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu May 21 22:52:21 CST 2020
//----------------------------------------------------

package gramaticaCLRS;

import pollitos.*;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import InterfazEditorTexto.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu May 21 22:52:21 CST 2020
  */
public class SintaxCLRS extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public SintaxCLRS() {super();}

  /** Constructor which sets the default scanner. */
  public SintaxCLRS(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SintaxCLRS(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\021\000\002\002\004\000\002\002\011\000\002\006" +
    "\010\000\002\006\004\000\002\011\010\000\002\011\010" +
    "\000\002\003\006\000\002\003\006\000\002\003\006\000" +
    "\002\003\004\000\002\005\005\000\002\007\004\000\002" +
    "\007\002\000\002\010\004\000\002\010\002\000\002\004" +
    "\004\000\002\004\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\004\011\005\001\002\000\004\002\064\001" +
    "\002\000\004\004\006\001\002\000\004\013\007\001\002" +
    "\000\004\011\010\001\002\000\006\003\013\015\012\001" +
    "\002\000\004\012\062\001\002\000\004\013\017\001\002" +
    "\000\006\012\ufff5\017\014\001\002\000\006\003\013\015" +
    "\012\001\002\000\004\012\ufffe\001\002\000\004\012\ufff6" +
    "\001\002\000\004\011\020\001\002\000\004\015\021\001" +
    "\002\000\004\013\025\001\002\000\004\012\023\001\002" +
    "\000\006\012\ufff5\017\014\001\002\000\004\012\uffff\001" +
    "\002\000\004\011\026\001\002\000\014\003\030\005\027" +
    "\006\032\007\034\010\031\001\002\000\004\013\057\001" +
    "\002\000\006\012\ufff1\017\044\001\002\000\004\013\054" +
    "\001\002\000\004\013\051\001\002\000\004\012\047\001" +
    "\002\000\004\013\042\001\002\000\004\012\036\001\002" +
    "\000\006\012\ufff3\017\037\001\002\000\004\015\021\001" +
    "\002\000\004\012\ufffd\001\002\000\004\012\ufff4\001\002" +
    "\000\004\014\043\001\002\000\006\012\ufff1\017\044\001" +
    "\002\000\012\003\030\005\027\006\032\007\034\001\002" +
    "\000\004\012\ufffa\001\002\000\004\012\ufff2\001\002\000" +
    "\006\012\ufff3\017\037\001\002\000\004\012\ufffc\001\002" +
    "\000\004\014\052\001\002\000\006\012\ufff1\017\044\001" +
    "\002\000\004\012\ufffb\001\002\000\004\016\055\001\002" +
    "\000\004\012\ufff7\001\002\000\004\012\ufff8\001\002\000" +
    "\004\014\060\001\002\000\006\012\ufff1\017\044\001\002" +
    "\000\004\012\ufff9\001\002\000\004\012\063\001\002\000" +
    "\004\002\000\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\004\002\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\006\010\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\007\014\001\001\000\004\006\015\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\011" +
    "\021\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\007\023\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\003\034\005\032\001\001\000\002\001\001\000\004" +
    "\004\055\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\010\037\001\001\000\004\011\040\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\004\044" +
    "\001\001\000\004\003\045\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\010\047\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\004\052\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\004\060\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SintaxCLRS$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SintaxCLRS$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SintaxCLRS$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    
    public ArrayList<Colores> listColores;
    public static String totalErrores = "";
    public Boolean todoCorrecto = true;

    public SintaxCLRS(AnalizadorLexico lex, ArrayList<Colores> listColores){
        super(lex);
        this.listColores = listColores;
    }

    public void setAccion(String tipo, String mensaje, String accion){
        System.out.println(tipo + " " + mensaje);
    }

    public void syntax_error(Symbol s){
        //setAccion("ERROR", "Error sintaxis columna: "+s.right+" fila: "+s.left,"");
        if(totalErrores.equals("")){
            totalErrores = "ERROR: Error sintaxis. Linea: "+s.left+" Columna: "+s.right+".\n";
        } else {
            totalErrores += "ERROR: Error sintaxis. Linea: "+s.left+" Columna: "+s.right+".\n";
        
        } 
    }

    public void traspasarDatosArreglo(ArrayList<Colores> listColores, ArrayList<Colores> listTemporal){
        for(int i = 0; i < listTemporal.size(); i++){
            listColores.add(listTemporal.get(i));
        }
    }


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$SintaxCLRS$actions {
  private final SintaxCLRS parser;

  /** Constructor */
  CUP$SintaxCLRS$actions(SintaxCLRS parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$SintaxCLRS$do_action(
    int                        CUP$SintaxCLRS$act_num,
    java_cup.runtime.lr_parser CUP$SintaxCLRS$parser,
    java.util.Stack            CUP$SintaxCLRS$stack,
    int                        CUP$SintaxCLRS$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SintaxCLRS$result;

      /* select the action based on the action number */
      switch (CUP$SintaxCLRS$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // COMA3 ::= 
            {
              LienzoColor RESULT =null;
		 LienzoColor colores = new LienzoColor(); RESULT=colores; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("COMA3",2, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // COMA3 ::= COMA d 
            {
              LienzoColor RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		LienzoColor a = (LienzoColor)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		 RESULT=a; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("COMA3",2, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // COMA2 ::= 
            {
              ArrayList<LienzoColor> RESULT =null;
		 ArrayList<LienzoColor> listColores = new ArrayList<>(); RESULT=listColores; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("COMA2",6, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // COMA2 ::= COMA c 
            {
              ArrayList<LienzoColor> RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		ArrayList<LienzoColor> e = (ArrayList<LienzoColor>)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		 RESULT=e; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("COMA2",6, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // COMA1 ::= 
            {
              ArrayList<Colores> RESULT =null;
		 ArrayList<Colores> coloresLienzos = new ArrayList<>(); RESULT=coloresLienzos; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("COMA1",5, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // COMA1 ::= COMA b 
            {
              ArrayList<Colores> RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		ArrayList<Colores> e = (ArrayList<Colores>)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		 RESULT=e; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("COMA1",5, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // e ::= HEX DOS_PUNTOS codigoHex 
            {
              LienzoColor RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		 LienzoColor colores = new LienzoColor(); colores.setColorHex(e.toString()); RESULT=colores; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("e",3, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // d ::= error COMA3 
            {
              LienzoColor RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		LienzoColor a = (LienzoColor)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		 parser.totalErrores += "\tAtributo COLORES definido de forma incorrecta.\n"; RESULT=a; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("d",1, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // d ::= Green DOS_PUNTOS NUMERO COMA3 
            {
              LienzoColor RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		LienzoColor b = (LienzoColor)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		 if(b.getVerde()==null){ b.setVerde((Integer) e); } else { parser.totalErrores += "Ya existe un atributo color verde. Linea: "+eleft+".\n";  parser.todoCorrecto = false; }  RESULT=b;  
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("d",1, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-3)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // d ::= Blue DOS_PUNTOS NUMERO COMA3 
            {
              LienzoColor RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		LienzoColor b = (LienzoColor)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		 if(b.getAzul()==null){ b.setAzul((Integer) e); } else { parser.totalErrores += "Ya existe un atributo color azul. Linea:"+eleft+".\n"; parser.todoCorrecto = false; }  RESULT=b; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("d",1, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-3)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // d ::= Red DOS_PUNTOS NUMERO COMA3 
            {
              LienzoColor RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		LienzoColor b = (LienzoColor)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		 if(b.getRojo()==null){ b.setRojo((Integer) e); } else { parser.totalErrores += "Ya existe un atributo color rojo. Linea:"+eleft+".\n"; parser.todoCorrecto = false; } RESULT=b; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("d",1, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-3)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // c ::= ID DOS_PUNTOS LLAVE_A e LLAVE_B COMA2 
            {
              ArrayList<LienzoColor> RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).right;
		LienzoColor a = (LienzoColor)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		ArrayList<LienzoColor> b = (ArrayList<LienzoColor>)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		 if(a.getColorHex()==null){ parser.totalErrores += "Falta llenar atributo Hexadecimal.\n"; parser.todoCorrecto = false; } else { a.setIdColor(e.toString()); b.add(a); } RESULT=b; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("c",7, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // c ::= ID DOS_PUNTOS LLAVE_A d LLAVE_B COMA2 
            {
              ArrayList<LienzoColor> RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).right;
		LienzoColor a = (LienzoColor)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		ArrayList<LienzoColor> b = (ArrayList<LienzoColor>)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		  if(a.getRojo()==null || a.getAzul() == null || a.getVerde()==null){ parser.totalErrores += "Falta un atributo RGB en la estructura de "+e.toString()+". Linea: "+aleft+" Columna: "+aright+"\n"; parser.todoCorrecto = false;  } else { a.setIdColor(e.toString()); b.add(a); } RESULT=b; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("c",7, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // b ::= error COMA1 
            {
              ArrayList<Colores> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		ArrayList<Colores> a = (ArrayList<Colores>)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		 parser.totalErrores += "Atributo principal mal definido.\n"; RESULT=a; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("b",4, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // b ::= ID DOS_PUNTOS LLAVE_A c LLAVE_B COMA1 
            {
              ArrayList<Colores> RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).right;
		ArrayList<LienzoColor> a = (ArrayList<LienzoColor>)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()).right;
		ArrayList<Colores> c = (ArrayList<Colores>)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.peek()).value;
		  Colores color = new Colores(); color.setNombreLienzo(e.toString()); color.setListColores(a); c.add(color); RESULT=c; 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("b",4, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-5)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // a ::= LLAVE_A COLORES DOS_PUNTOS LLAVE_A b LLAVE_B LLAVE_B 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).right;
		ArrayList<Colores> a = (ArrayList<Colores>)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-2)).value;
		 if(parser.todoCorrecto){ parser.traspasarDatosArreglo(parser.listColores, a); } else { parser.totalErrores += "Debido a multiples errores, no se puede continuar el proceso.\n"; } if(!parser.totalErrores.equals("")){ InterfazTexto.bandejaErrores += "ERRORES .CLRS:\n"; InterfazTexto.bandejaErrores += parser.totalErrores;  InterfazTexto.bandejaErrores += "--------------------------------------------------------\n"; parser.totalErrores = "";  } 
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("a",0, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-6)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          return CUP$SintaxCLRS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= a EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)).value;
		RESULT = start_val;
              CUP$SintaxCLRS$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.elementAt(CUP$SintaxCLRS$top-1)), ((java_cup.runtime.Symbol)CUP$SintaxCLRS$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SintaxCLRS$parser.done_parsing();
          return CUP$SintaxCLRS$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

