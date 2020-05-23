/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramaticaPNT;

import java.util.ArrayList;
import pollitos.Objeto;
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

    public boolean verificarId(String id, ArrayList<ValoresPNT> listValores) {
        boolean yaExiste = false;
        for (int i = 0; i < listValores.size(); i++) {
            if (listValores.get(i).getId().equals(id)) {
                yaExiste = true;
                break;
            }
        }
        return yaExiste;
    }

    public void agregarDato(ArrayList<ValoresPNT> listValores, ValoresPNT valor) {
        if (!verificarId(valor.getId(), listValores)) {
            listValores.add(valor);
        } else {
            System.out.println("un mensaje");
        }
    }

    //verifica si un id ya ha sido asignado antes
    public Object verificarUnValor(String id, ArrayList<ValoresPNT> listValores, String tipo2, Integer linea, Integer columna) {
        Object aDevolver = null;
        for (int i = 0; i < listValores.size(); i++) {
            if (listValores.get(i).getId().equals(id)) {
                String tipo = listValores.get(i).getTipo();
                if (tipo.equals(tipo2)) {
                    if (tipo.equals("String")) {
                        if (listValores.get(i).getValorCadena() != null) {
                            aDevolver = listValores.get(i).getValorCadena();
                            break;
                        }
                    } else if (tipo.equals("Integer")) {
                        if (listValores.get(i).getValorEntero() != null) {
                            aDevolver = listValores.get(i).getValorEntero();
                            break;
                        }
                    } else if (tipo.equals("Boolean")) {
                        if (listValores.get(i).getValorBoolean() != null) {
                            aDevolver = listValores.get(i).getValorBoolean();
                            break;
                        }
                    }
                }

            }
        }
        if(aDevolver  == null){
            SintaxPNT.totalErrores += "Variable: "+id+" no existe dentro del archivo PNT. Linea: "+linea+" Columna: "+columna+".\n";
        }
        return aDevolver;
    }

    public Objeto devolverUnObjeto(String id, ArrayList<ValoresPNT> listValores) {
        Objeto enviado = null;
        Object aDevolver = null;
        for (int i = 0; i < listValores.size(); i++) {
            if (listValores.get(i).getId().equals(id)) {
                String tipo = listValores.get(i).getTipo();
                if (tipo.equals("String")) {
                    if (listValores.get(i).getValorCadena() != null) {
                        aDevolver = listValores.get(i).getValorCadena();
                        enviado = new Objeto(aDevolver, "String");
                        break;
                    }
                } else if (tipo.equals("Integer")) {
                    if (listValores.get(i).getValorEntero() != null) {
                        aDevolver = listValores.get(i).getValorEntero();
                        enviado = new Objeto(aDevolver, "Integer");
                        break;
                    }
                } else if (tipo.equals("Boolean")) {
                    if (listValores.get(i).getValorBoolean() != null) {
                        aDevolver = listValores.get(i).getValorBoolean();
                        enviado = new Objeto(aDevolver, "Boolean");
                        break;
                    }
                }

            }
        }
        return enviado;
    }

    public Boolean comprobarCondicionTipo1(Objeto objeto1, Integer tipo, Objeto objeto2) {
        Boolean aDevolver = null;
        if (objeto1 != null && objeto2 != null) {
            if (objeto1.getObjeto() != null && objeto2.getObjeto() != null) {
                switch (tipo) {
                    case 1:

                        aDevolver = objeto1.getObjeto().toString().equals(objeto2.getObjeto().toString());
                        
                        break;
                    case 2:
                        if (objeto1.getTipo().equals("Integer") && objeto2.getTipo().equals("Integer")) {
                            aDevolver = (Integer) objeto1.getObjeto() < (Integer) objeto2.getObjeto();
                        }
                        break;
                    case 3:
                        if (objeto1.getTipo().equals("Integer") && objeto2.getTipo().equals("Integer")) {
                            aDevolver = (Integer) objeto1.getObjeto() > (Integer) objeto2.getObjeto();
                        }
                        break;
                    case 4:
                        if (objeto1.getTipo().equals("Integer") && objeto2.getTipo().equals("Integer")) {
                            aDevolver = (Integer) objeto1.getObjeto() <= (Integer) objeto2.getObjeto();
                        }
                        break;
                    case 5:
                        if (objeto1.getTipo().equals("Integer") && objeto2.getTipo().equals("Integer")) {
                            aDevolver = (Integer) objeto1.getObjeto() >= (Integer) objeto2.getObjeto();
                        }
                        break;
                    case 6:
                        aDevolver = !objeto1.getObjeto().toString().equals(objeto2.getObjeto().toString());
                        break;
                    default:

                        break;
                }
            } else {
                System.out.println("Un objeto es nulo");
            }
        } else {
            System.out.println("Un objeto es nulo");
            
        }

        return aDevolver;
    }

    public Boolean comprobarCondicionTipo2(String id, ArrayList<ValoresPNT> listValores) {
        Boolean aDevolver = null;
        for (int i = 0; i < listValores.size(); i++) {
            if (listValores.get(i).getId().equals(id)) {
                if (listValores.get(i).getTipo().equals("Boolean")) {
                    aDevolver = listValores.get(i).getValorBoolean();
                }
            }
        }
        return aDevolver;
    }
    
    public void modificarValor(String id, ArrayList<ValoresPNT> listValores, String tipo, Object nuevoValor){
        boolean encontrado = false;
        for (int i = 0; i < listValores.size(); i++) {
            if(listValores.get(i).getId().equals(id)){
                if(tipo.equals(listValores.get(i).getTipo())){
                    if(tipo.equals("String")){
                        listValores.get(i).setValorCadena(nuevoValor.toString());
                        encontrado = true;
                        break;
                    } else if(tipo.equals("Integer")){
                        listValores.get(i).setValorEntero((Integer) nuevoValor);
                        encontrado = true;
                        break;
                    } else if(tipo.equals("Boolean")){
                        listValores.get(i).setValorBoolean((Boolean) nuevoValor);
                        encontrado = true;
                        break;
                    }
                }
            }
        }
        if(!encontrado){
            System.out.println("este valor no se encuentra en la tabla de simbolos");
        }
    }

}
