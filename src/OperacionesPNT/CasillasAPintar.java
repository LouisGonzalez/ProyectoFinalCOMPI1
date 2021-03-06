/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesPNT;

import gramaticaPNT.TablaSimbolos;
import java.util.ArrayList;
import pollitos.CuadrosPintar;
import pollitos.OpAritmeticasWhile;
import pollitos.Pintados;
import pollitos.ValoresPNT;

/**
 *
 * @author luisGonzalez
 */
public class CasillasAPintar {

    public void determinarCasillas(CuadrosPintar lista, ArrayList<ValoresPNT> listValores, ArrayList<Pintados> listPintados, TablaSimbolos tabla, String idLienzo, Integer linea, Integer columna) {

        Integer[] valorVarx = new Integer[2];
        Integer[] valorVary = new Integer[2];
        if (lista.getOpX() != null) {

            valorVarx[0] = calcularOperacion(lista.getOpX(), tabla, listValores, linea, columna);
        } else {
            valorVarx[0] = verificarValor(lista.getRangoX()[0], listValores);
            if (lista.getRangoX()[1] != null) {
                valorVarx[1] = verificarValor(lista.getRangoX()[1], listValores);
            }

        }
        if (lista.getOpY() != null) {
            valorVary[0] = calcularOperacion(lista.getOpY(), tabla, listValores, linea, columna);
        } else {
            valorVary[0] = verificarValor(lista.getRangoY()[0], listValores);
            if (lista.getRangoY()[1] != null) {
                valorVary[1] = verificarValor(lista.getRangoY()[1], listValores);
            }

        }
        if (valorVarx[0] != null && valorVary[0] != null) {

            if (lista.getRangoX()[1] != null && lista.getRangoY()[1] != null) {
                for (int i = valorVarx[0]; i <= valorVarx[1]; i++) {
                    for (int j = valorVary[0]; j <= valorVary[1]; j++) {
                        Pintados pintado = new Pintados(i, j, lista.getIdColor(), lista.getIdImagen(), idLienzo);
                        listPintados.add(pintado);
                    }
                }
            } else if (lista.getRangoX()[1] != null && lista.getRangoY()[1] == null) {
                for (int i = valorVarx[0]; i <= valorVarx[1]; i++) {
                    Pintados pintado = new Pintados(i, valorVary[0], lista.getIdColor(), lista.getIdImagen(), idLienzo);
                    listPintados.add(pintado);
                }
            } else if (lista.getRangoX()[1] == null && lista.getRangoY()[1] != null) {
                for (int i = valorVary[0]; i <= valorVary[1]; i++) {
                    Pintados pintado = new Pintados(valorVarx[0], i, lista.getIdColor(), lista.getIdImagen(), idLienzo);
                    listPintados.add(pintado);
                }
            } else if (lista.getRangoX()[1] == null && lista.getRangoY()[1] == null) {
                Pintados pintado = new Pintados(valorVarx[0], valorVary[0], lista.getIdColor(), lista.getIdImagen(), idLienzo);
                listPintados.add(pintado);
            }
        }
    }

    public Integer verificarValor(Object pos, ArrayList<ValoresPNT> listValores) {
        Integer valor = null;
        if (isNumeric(pos.toString())) {
            valor = (Integer) pos;
        } else {
            for (int i = 0; i < listValores.size(); i++) {
                if (listValores.get(i).getId().equals(pos.toString())) {
                    valor = listValores.get(i).getValorEntero();
                }
            }
        }
        return valor;
    }

    public Integer calcularOperacion(ArrayList<OpAritmeticasWhile> listOp, TablaSimbolos tabla, ArrayList<ValoresPNT> listValores, Integer linea, Integer columna) {
        Integer suma = 0;
        CondicionesLogicas cond = new CondicionesLogicas();
        if (listOp.size() == 1) {
            if (listOp.get(0).getTipo().equals("String")) {
                if (listOp.get(0).getDato() != null) {
                    suma = (Integer) tabla.verificarUnValor(listOp.get(0).getDato().toString(), listValores, "Integer", linea, columna);
                } else {
                    suma = null;
                }
            } else {
                suma = (Integer) listOp.get(0).getDato();
            }
        } else {
            /*  for (int i = 0; i < listOp.size() - 1; i++) {
                if (i == 0) {
                    Integer nodo1 = null;
                    Integer nodo2 = null;
                    if (listOp.get(i).getTipo().equals("String")) {
                        nodo1 = (Integer) tabla.verificarUnValor(listOp.get(i).getDato().toString(), listValores, "Integer", linea, columna);
                        if (listOp.get(i + 1).getTipo().equals("String")) {
                            nodo2 = (Integer) tabla.verificarUnValor(listOp.get(i + 1).getDato().toString(), listValores, "Integer", linea, columna);
                        } else {
                            nodo2 = (Integer) listOp.get(i + 1).getDato();
                        }
                    } else {
                        nodo1 = (Integer) listOp.get(i).getDato();
                        if (listOp.get(i + 1).getTipo().equals("String")) {
                            nodo2 = (Integer) tabla.verificarUnValor(listOp.get(i + 1).getDato().toString(), listValores, "Integer", linea, columna);
                        } else {
                            nodo2 = (Integer) listOp.get(i + 1).getDato();
                        }
                    }
                    suma = cond.devolverResultado(listOp.get(i + 1), nodo1, nodo2, suma);
                } else {
                    Integer nodo = null;
                    if (listOp.get(i + 1).getTipo().equals("String")) {
                        nodo = (Integer) tabla.verificarUnValor(listOp.get(i + 1).getDato().toString(), listValores, "Integer", linea, columna);
                    } else {
                        nodo = (Integer) listOp.get(i + 1).getDato();
                    }
                    suma = cond.devolverResultado(listOp.get(i + 1), suma, nodo, suma);
                }
            }*/

            for (int i = 0; i < listOp.size(); i++) {
            }

            ArrayList<OpAritmeticasWhile> listAux = new ArrayList<>();
            for (int i = 0; i < listOp.size(); i++) {
                listAux.add(listOp.get(i));
            }
            suma = cond.calculoValorVariable(listAux, tabla, listValores, linea, columna);

        }
        return suma;
    }

    private boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
