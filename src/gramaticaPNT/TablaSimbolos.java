/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramaticaPNT;

import java.util.ArrayList;
import pollitos.OperacionesPNT;
import pollitos.ValoresPNT;

/**
 *
 * @author luisGonzalez
 */
public class TablaSimbolos {
    
    int a;
    String b = null;
   
    public ArrayList<ValoresPNT> listValores = new ArrayList<>();
    
    public boolean verificarId(String id, ArrayList<ValoresPNT> listValores){
        boolean yaExiste = false;
        for (int i = 0; i < listValores.size(); i++) {
            if(listValores.get(i).getId().equals(id)){
                yaExiste = true;
                break;
            }
        }
        return yaExiste;
    }
    
    public void agregarDato(ArrayList<ValoresPNT> listValores, ValoresPNT valor){
        if(!verificarId(valor.getId(), listValores)){
            listValores.add(valor);
        } else {
            System.out.println("un mensaje");
        }
    }
    
    //verifica si un id ya ha sido asignado antes
    public Object verificarUnValor(String id, ArrayList<ValoresPNT> lisValores, String tipo2){
        Object aDevolver = null;
        for (int i = 0; i < listValores.size(); i++) {
            if(lisValores.get(i).getId().equals(id)){
                String tipo = listValores.get(i).getTipo();
                
                if(tipo.equals(tipo2)){
                    if(tipo.equals("String")){
                        if(listValores.get(i).getValorCadena() != null){
                            aDevolver = listValores.get(i).getValorCadena();
                        }
                    } else if(tipo.equals("Integer")){
                        if(listValores.get(i).getValorEntero() != null){
                            aDevolver = listValores.get(i).getValorEntero();
                        }
                    } else if(tipo.equals("Boolean")){
                        if(listValores.get(i).getValorBoolean() != null){
                            aDevolver = listValores.get(i).getValorBoolean();
                        }
                    }
                }
            }
        }
        return aDevolver;
    }
    
    public void verificarErrores(ArrayList<OperacionesPNT> listOperaciones){
        boolean error = false;
        for (int i = listOperaciones.size() - 1; i == 0; i--) {
            if(listOperaciones.get(i).getError() != null){
                if(listOperaciones.get(i).getError() == true){
                    error = true;
                    
                    
                    break;
                }
            }
        }
        if(error == false){
           String a = "*";
          
        }
    }
    
    
}
