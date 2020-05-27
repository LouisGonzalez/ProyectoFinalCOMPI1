/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesPNT;

import gramaticaPNT.SintaxPNT;
import gramaticaPNT.TablaSimbolos;
import java.util.ArrayList;
import java.util.Objects;
import pollitos.Objeto;
import pollitos.OpAritmeticasWhile;
import pollitos.Pintados;
import pollitos.TipoEncadenamiento;
import pollitos.ValoresPNT;
import pollitos.While;

/**
 *
 * @author luisGonzalez
 */
public class CondicionesLogicas {

    private ArrayList<Boolean> trayectoria;

    public Boolean verificar2(ArrayList<TipoEncadenamiento> booleanos) {
        trayectoria = new ArrayList<>();
        Boolean verificador = null;
        if (!booleanos.isEmpty()) {
            if (booleanos.size() == 1) {
                verificador = booleanos.get(booleanos.size() - 1).getValor();
            } else {
                for (int i = 0; i < booleanos.size(); i++) {
                    if (i > 1) {
                        if (booleanos.get(i).getValor() == null) {
                            verificador = null;
                            break;
                        } else {
                            if (booleanos.get(i).getEncadenamiento().equals("AND")) {
                                if (booleanos.get(i).getValor() && trayectoria.get(trayectoria.size() - 1)) {
                                    trayectoria.add(true);
                                    verificador = true;
                                } else {
                                    trayectoria.add(false);
                                    verificador = false;
                                }
                            } else if (booleanos.get(i).getEncadenamiento().equals("OR")) {
                                if (booleanos.get(i).getValor() || trayectoria.get(trayectoria.size() - 1)) {
                                    trayectoria.add(true);
                                    verificador = true;
                                } else {
                                    trayectoria.add(false);
                                    verificador = false;
                                }
                            }
                        }
                    } else if (i == 1) {
                        if (booleanos.get(i).getValor() == null || booleanos.get(i - 1) == null) {
                            verificador = null;
                            break;
                        } else {

                            if (booleanos.get(i).getEncadenamiento().equals("AND")) {
                                if (booleanos.get(i).getValor() && booleanos.get(i - 1).getValor()) {
                                    trayectoria.add(true);
                                    verificador = true;
                                } else {
                                    trayectoria.add(false);
                                    verificador = false;
                                }
                            } else if (booleanos.get(i).getEncadenamiento().equals("OR")) {
                                if (booleanos.get(i).getValor() || booleanos.get(i - 1).getValor()) {
                                    trayectoria.add(true);
                                    verificador = true;
                                } else {
                                    trayectoria.add(false);
                                    verificador = false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return verificador;
    }

    public void repetirCiclo(ArrayList<TipoEncadenamiento> a, While ciclo, ArrayList<ValoresPNT> listValores, ArrayList<Pintados> listPintados, String idLienzo, Integer linea, Integer columna) {
        int contador = 0;
        ArrayList<TipoEncadenamiento> listAux = new ArrayList<>();
        TablaSimbolos tabla = new TablaSimbolos();
        listAux = devolverArreglo(ciclo, tabla, listValores);
        if (verificar2(listAux) == null) {
            SintaxPNT.totalErrores += "El ciclo no ha podido inicializarse debido a un valor. Linea: " + linea + " Columna: " + columna + ".\n";
        } else {
            while (verificar2(listAux)) {
                if (ciclo.getCondicional() != null) {
                    Boolean cicloIf = verificar2(ciclo.getCondicional().getCondicion());
                    Integer noIf = ciclo.getCondicional().getNoIf();
                    if (cicloIf != null) {
                        if (cicloIf) {
                            for (int i = 0; i < ciclo.getListOp().size(); i++) {
                                int suma = 0;
                                for (int j = 0; j < ciclo.getListOp().get(i).getMiOperacion().size() - 1; j++) {
                                    if (ciclo.getListOp().get(i).getNoIf() != null) {
                                        if (Objects.equals(ciclo.getListOp().get(i).getNoIf(), noIf)) {
                                            if (i == 0) {
                                                Integer nodo1 = null;
                                                Integer nodo2 = null;
                                                if (ciclo.getListOp().get(i).getMiOperacion().get(j).getTipo().equals("String")) {
                                                    nodo1 = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j).getDato().toString(), listValores, "Integer", linea, columna);
                                                    if (ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getTipo().equals("String")) {
                                                        nodo2 = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato().toString(), listValores, "Integer", linea, columna);
                                                    } else {
                                                        nodo2 = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato();
                                                    }
                                                } else {
                                                    nodo1 = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j).getDato();
                                                    if (ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getTipo().equals("String")) {
                                                        nodo2 = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato().toString(), listValores, "Integer", linea, columna);
                                                    } else {
                                                        nodo2 = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato();
                                                    }
                                                }
                                                suma = devolverResultado(ciclo.getListOp().get(i).getMiOperacion().get(j + 1), nodo1, nodo2, suma);
                                                tabla.modificarValor(ciclo.getListOp().get(i).getIdCambio(), listValores, "Integer", suma, null, null);
                                            } else {
                                                Integer nodo = null;
                                                if (ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getTipo().equals("String")) {
                                                    nodo = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato().toString(), listValores, "Integer", linea, columna);
                                                } else {
                                                    nodo = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato();
                                                }
                                                suma = devolverResultado(ciclo.getListOp().get(i).getMiOperacion().get(j + 1), suma, nodo, suma);
                                                tabla.modificarValor(ciclo.getListOp().get(i).getIdCambio(), listValores, "Integer", suma, null, null);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < ciclo.getListOp().size(); i++) {
                        ArrayList<OpAritmeticasWhile> listAux2 = new ArrayList<>();
                        for (int j = 0; j < ciclo.getListOp().get(i).getMiOperacion().size(); j++) {
                            listAux2.add(ciclo.getListOp().get(i).getMiOperacion().get(j));
                        }
                        Integer suma = calculoValorVariable(listAux2, tabla, listValores, linea, columna);
                        if (suma != null) {
                            if (contador == 0) {
                                agregarPintadosWhile(ciclo, listValores, listPintados, tabla, idLienzo, linea, columna);
                            }
                            tabla.modificarValor(ciclo.getListOp().get(i).getIdCambio(), listValores, "Integer", suma, null, null);
                        }
                    }
                }
                agregarPintadosWhile(ciclo, listValores, listPintados, tabla, idLienzo, linea, columna);

                listAux = devolverArreglo(ciclo, tabla, listValores);
                contador++;
            }
        }
    }

    public ArrayList<TipoEncadenamiento> devolverArreglo(While ciclo, TablaSimbolos tabla, ArrayList<ValoresPNT> listValores) {
        ArrayList<TipoEncadenamiento> listAux = new ArrayList<>();
        for (int i = 0; i < ciclo.getMiCondicional().size(); i++) {

            if (ciclo.getMiCondicional().get(i).getTipo().equals("Tipo1")) {
                Objeto nuevo = null;
                Objeto nuevo2 = null;
                if (isNumeric(ciclo.getMiCondicional().get(i).getDato2().toString())) {
                    nuevo = new Objeto(ciclo.getMiCondicional().get(i).getDato2(), "Integer");
                    if (isNumeric(ciclo.getMiCondicional().get(i).getDato1().toString())) {
                        nuevo2 = new Objeto(ciclo.getMiCondicional().get(i).getDato1(), "Integer");
                    } else {
                        nuevo2 = tabla.devolverUnObjeto(ciclo.getMiCondicional().get(i).getDato1().toString(), listValores);
                    }

                } else {
                    nuevo = tabla.devolverUnObjeto(ciclo.getMiCondicional().get(i).getDato2().toString(), listValores);
                    if (isNumeric(ciclo.getMiCondicional().get(i).getDato1().toString())) {
                        nuevo2 = new Objeto(ciclo.getMiCondicional().get(i).getDato1(), "Integer");
                    } else {
                        nuevo2 = tabla.devolverUnObjeto(ciclo.getMiCondicional().get(i).getDato1().toString(), listValores);
                    }
                }
                Boolean valor = tabla.comprobarCondicionTipo1(nuevo2, (Integer) ciclo.getMiCondicional().get(i).getRelacional(), nuevo);
                String cadena = ciclo.getMiCondicional().get(i).getCadena();
                TipoEncadenamiento tipo = new TipoEncadenamiento(cadena, valor);
                listAux.add(tipo);
            } else if (ciclo.getMiCondicional().get(i).getTipo().equals("Tipo2")) {
                Boolean valor = tabla.comprobarCondicionTipo2(ciclo.getMiCondicional().get(i).getDato1().toString(), listValores);
                String cadena = ciclo.getMiCondicional().get(i).getCadena();
                TipoEncadenamiento tipo = new TipoEncadenamiento(cadena, valor);
                listAux.add(tipo);
            } else if (ciclo.getMiCondicional().get(i).getTipo().equals("Tipo3")) {
                Boolean valor = Boolean.valueOf(ciclo.getMiCondicional().get(i).getDato1().toString());
                String cadena = ciclo.getMiCondicional().get(i).getCadena();
                TipoEncadenamiento tipo = new TipoEncadenamiento(cadena, valor);
                listAux.add(tipo);
            }
        }
        return listAux;
    }

    public void agregarPintadosWhile(While ciclo, ArrayList<ValoresPNT> listValores, ArrayList<Pintados> listPintados, TablaSimbolos tabla, String idLienzo, Integer linea, Integer columna) {
        CasillasAPintar casillas = new CasillasAPintar();
        for (int i = 0; i < ciclo.getListPorPintar().size(); i++) {
            casillas.determinarCasillas(ciclo.getListPorPintar().get(i), listValores, listPintados, tabla, idLienzo, linea, columna);
        }
    }

    public Integer devolverResultado(OpAritmeticasWhile op, Integer valor1, Integer valor2, Integer total) {
        if (op.getOperacion().equals("SUMA")) {
            total = valor1 + valor2;
        } else if (op.getOperacion().equals("MULT")) {
            total = valor1 * valor2;
        } else if (op.getOperacion().equals("DIV")) {
            total = valor1 / valor2;
        }
        return total;
    }

    public Integer calculoValorVariable(ArrayList<OpAritmeticasWhile> listOp, TablaSimbolos tabla, ArrayList<ValoresPNT> listValores, Integer linea, Integer columna) {
        if (listOp.size() > 1) {
            int nodoARemover = 0;
            Boolean aRemover = false;
            for (int i = 1; i < listOp.size(); i++) {
                if (listOp.get(i).getOperacion().equals("MULT")) {
                    Integer nodo1 = null, nodo2 = null;
                    if (listOp.get(i).getTipo().equals("String")) {
                        nodo1 = (Integer) tabla.verificarUnValor(listOp.get(i).getDato().toString(), listValores, "Integer", linea, columna);
                        if (listOp.get(i - 1).getTipo().equals("String")) {
                            nodo2 = (Integer) tabla.verificarUnValor(listOp.get(i - 1).toString(), listValores, "Integer", linea, columna);
                        } else {
                            nodo2 = (Integer) listOp.get(i - 1).getDato();
                        }
                    } else {
                        nodo1 = (Integer) listOp.get(i).getDato();
                        if (listOp.get(i - 1).getTipo().equals("String")) {
                            nodo2 = (Integer) tabla.verificarUnValor(listOp.get(i - 1).toString(), listValores, "Integer", linea, columna);
                        } else {
                            nodo2 = (Integer) listOp.get(i - 1).getDato();
                        }
                    }
                    if (nodo1 != null && nodo2 != null) {
                        Integer nuevoValor = nodo2 * nodo1;
                        String operacion = listOp.get(i - 1).getOperacion();
                        OpAritmeticasWhile nuevo = new OpAritmeticasWhile(nuevoValor, operacion, "Integer");
                        listOp.set(i, nuevo);
                        nodoARemover = i - 1;
                        aRemover = true;
                        break;
                    } else {
                        aRemover = null;
                        break;
                    }
                } else if (listOp.get(i).getOperacion().equals("DIV")) {
                    Integer nodo1 = null, nodo2 = null;
                    if (listOp.get(i).getTipo().equals("String")) {
                        nodo1 = (Integer) tabla.verificarUnValor(listOp.get(i).getDato().toString(), listValores, "Integer", linea, columna);
                        if (listOp.get(i - 1).getTipo().equals("String")) {
                            nodo2 = (Integer) tabla.verificarUnValor(listOp.get(i - 1).toString(), listValores, "Integer", linea, columna);
                        } else {
                            nodo2 = (Integer) listOp.get(i - 1).getDato();
                        }
                    } else {
                        nodo1 = (Integer) listOp.get(i).getDato();
                        if (listOp.get(i - 1).getTipo().equals("String")) {
                            nodo2 = (Integer) tabla.verificarUnValor(listOp.get(i).getDato().toString(), listValores, "Integer", linea, columna);
                        } else {
                            nodo2 = (Integer) listOp.get(i - 1).getDato();
                        }
                    }
                    if (nodo1 != null && nodo2 != null) {
                        Integer nuevoValor = nodo2 / nodo1;
                        String operacion = listOp.get(i - 1).getOperacion();
                        OpAritmeticasWhile nuevo = new OpAritmeticasWhile(nuevoValor, operacion, "Integer");
                        listOp.set(i, nuevo);
                        nodoARemover = i - 1;
                        aRemover = true;
                        break;
                    } else {
                        aRemover = null;
                        break;
                    }
                }
            }
            if (aRemover != null) {
                if (aRemover) {
                    listOp.remove(nodoARemover);
                    calculoValorVariable(listOp, tabla, listValores, linea, columna);
                } else {
                    segundaRondaVariable(listOp, tabla, listValores, linea, columna);
                }
            } else {
                return null;
            }
        }
        if (listOp.get(0).getTipo().equals("Integer")) {
            return (Integer) listOp.get(0).getDato();
        } else {
            return null;
        }

    }

    public void segundaRondaVariable(ArrayList<OpAritmeticasWhile> listOp, TablaSimbolos tabla, ArrayList<ValoresPNT> listValores, Integer linea, Integer columna) {
        if (listOp.size() > 1) {
            Boolean aRemover = false;
            Integer nodoARemover = null;
            for (int i = 1; i < listOp.size(); i++) {
                if (listOp.get(i).getOperacion().equals("SUMA")) {
                    Integer nodo1 = null, nodo2 = null;
                    if (listOp.get(i).getTipo().equals("String")) {
                        nodo1 = (Integer) tabla.verificarUnValor(listOp.get(i).getDato().toString(), listValores, "Integer", linea, columna);
                        if (listOp.get(i - 1).getTipo().equals("String")) {
                            nodo2 = (Integer) tabla.verificarUnValor(listOp.get(i - 1).getDato().toString(), listValores, "Integer", linea, columna);
                        } else {
                            nodo2 = (Integer) listOp.get(i - 1).getDato();
                        }
                    } else {
                        nodo1 = (Integer) listOp.get(i).getDato();
                        if (listOp.get(i - 1).getTipo().equals("String")) {
                            nodo2 = (Integer) tabla.verificarUnValor(listOp.get(i - 1).getDato().toString(), listValores, "Integer", linea, columna);
                        } else {
                            nodo2 = (Integer) listOp.get(i - 1).getDato();
                        }
                    }

                    if (nodo1 != null && nodo2 != null) {
                        Integer nuevoValor = nodo2 + nodo1;
                        String operacion = listOp.get(i - 1).getOperacion();
                        OpAritmeticasWhile nuevo = new OpAritmeticasWhile(nuevoValor, operacion, "Integer");
                        listOp.set(i, nuevo);
                        aRemover = true;
                        nodoARemover = i - 1;
                        break;
                    } else {
                        aRemover = null;
                        break;
                    }

                } else if (listOp.get(i).getOperacion().equals("RESTA")) {
                    Integer nodo1 = null, nodo2 = null;
                    if (listOp.get(i).getTipo().equals("String")) {
                        nodo1 = (Integer) tabla.verificarUnValor(listOp.get(1).getDato().toString(), listValores, "Integer", linea, columna);
                        if (listOp.get(i - 1).getTipo().equals("String")) {
                            nodo2 = (Integer) tabla.verificarUnValor(listOp.get(i - 1).getDato().toString(), listValores, "Integer", linea, columna);
                        } else {
                            nodo2 = (Integer) listOp.get(i - 1).getDato();
                        }
                    } else {
                        nodo1 = (Integer) listOp.get(i).getDato();
                        if (listOp.get(i - 1).getTipo().equals("String")) {
                            nodo2 = (Integer) tabla.verificarUnValor(listOp.get(i - 1).getDato().toString(), listValores, "Integer", linea, columna);
                        } else {
                            nodo2 = (Integer) listOp.get(i - 1).getDato();
                        }
                    }
                    if (nodo1 != null && nodo2 != null) {
                        Integer nuevoValor = nodo2 - nodo1;
                        String operacion = listOp.get(i - 1).getOperacion();
                        OpAritmeticasWhile nuevo = new OpAritmeticasWhile(nuevoValor, operacion, "Integer");
                        listOp.set(i, nuevo);
                        aRemover = true;
                        nodoARemover = i - 1;
                        break;
                    } else {
                        aRemover = null;
                        break;
                    }
                }
            }
            if (aRemover != null) {
                if (aRemover) {
                   
                    listOp.remove(0);
                    segundaRondaVariable(listOp, tabla, listValores, linea, columna);
                }
            }
        }
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
