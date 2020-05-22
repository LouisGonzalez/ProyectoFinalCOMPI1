/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesPNT;

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

    //AGREGAR EN TRAYECTORIA CADA CONDICION QUE SE LLEGUE A CUMPLIR O NO, ASI EN LA SIGUIENTE ITERACION DEL FOR SE COMPARA
    //CON LA ULTIMA AGREGADA DE TRAYECTORIA
    public Boolean verificar(ArrayList<TipoEncadenamiento> booleanos) {
        trayectoria = new ArrayList<>();
        Boolean verificador = null;
        if (!booleanos.isEmpty()) {
            if (booleanos.size() == 1) {
                verificador = booleanos.get(booleanos.size() - 1).getValor();
            } else {
                for (int i = booleanos.size() - 2; i == 0; i--) {
                    if (i < booleanos.size() - 2) {
                        if (booleanos.get(i).getValor() == null) {
                            verificador = null;
                            break;
                        } else {
                            if (booleanos.get(i).getEncadenamiento().equals("AND")) {
                                if (!booleanos.get(i).getValor() || !trayectoria.get(trayectoria.size() - 1)) {
                                    trayectoria.add(false);
                                    verificador = false;
                                } else {
                                    trayectoria.add(true);
                                    verificador = true;
                                }
                            } else if (booleanos.get(i).getEncadenamiento().equals("OR")) {
                                if (!booleanos.get(i).getValor() || trayectoria.get(trayectoria.size() - 1)) {
                                    trayectoria.add(true);
                                    verificador = true;
                                } else {
                                    trayectoria.add(false);
                                    verificador = false;
                                }
                            }
                        }
                    } else if (i == booleanos.size() - 2) {
                        if (booleanos.get(i).getValor() == null || booleanos.get(i + 1) == null) {
                            verificador = null;
                            break;
                        } else {
                            if (booleanos.get(i).getEncadenamiento().equals("AND")) {
                                if (!booleanos.get(i).getValor() || !booleanos.get(i + 1).getValor()) {
                                    trayectoria.add(false);
                                    verificador = false;
                                } else {
                                    trayectoria.add(true);
                                    verificador = true;
                                }
                            } else if (booleanos.get(i).getEncadenamiento().equals("OR")) {
                                if (!booleanos.get(i).getValor() || booleanos.get(i + 1).getValor()) {
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
        System.out.println(verificador + "    verificador");
        return verificador;
    }

    public Boolean verificar2(ArrayList<TipoEncadenamiento> booleanos) {
        trayectoria = new ArrayList<>();
        Boolean verificador = null;
        if (!booleanos.isEmpty()) {
            for (int i = 0; i < booleanos.size(); i++) {
                System.out.println(booleanos.get(i).getEncadenamiento() + "         YYY");
            }
            if (booleanos.size() == 1) {
                verificador = booleanos.get(booleanos.size() - 1).getValor();
            } else {
                for (int i = 1; i < booleanos.size(); i++) {
                    if (i > 1) {
                        if (booleanos.get(i).getValor() == null) {
                            verificador = null;
                            break;
                        } else {
                            if (booleanos.get(i).getEncadenamiento().equals("AND")) {
                                if (!booleanos.get(i).getValor() || !trayectoria.get(trayectoria.size() - 1)) {
                                    trayectoria.add(false);
                                    verificador = false;
                                } else {
                                    trayectoria.add(true);
                                    verificador = true;
                                }
                            } else if (booleanos.get(i).getEncadenamiento().equals("OR")) {
                                if (!booleanos.get(i).getValor() || trayectoria.get(trayectoria.size() - 1)) {
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
                                if (!booleanos.get(i).getValor() || !booleanos.get(i - 1).getValor()) {
                                    trayectoria.add(false);
                                    verificador = false;
                                } else {
                                    trayectoria.add(true);
                                    verificador = true;
                                }
                            } else if (booleanos.get(i).getEncadenamiento().equals("OR")) {
                                if (!booleanos.get(i).getValor() || booleanos.get(i - 1).getValor()) {
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
        System.out.println(verificador + "    verificador2");
        return verificador;
    }

    public void repetirCiclo(ArrayList<TipoEncadenamiento> a, While ciclo, ArrayList<ValoresPNT> listValores, ArrayList<Pintados> listPintados, String idLienzo) {

        ArrayList<TipoEncadenamiento> listAux = new ArrayList<>();
        TablaSimbolos tabla = new TablaSimbolos();

        listAux = devolverArreglo(ciclo, tabla, listValores);

        while (!verificar2(listAux)) {
            System.out.println("ENTRO MI BROTHER");
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
                                                nodo1 = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j).getDato().toString(), listValores, "Integer");
                                                if (ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getTipo().equals("String")) {
                                                    nodo2 = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato().toString(), listValores, "Integer");
                                                } else {
                                                    nodo2 = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato();
                                                }
                                            } else {
                                                nodo1 = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j).getDato();
                                                if (ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getTipo().equals("String")) {
                                                    nodo2 = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato().toString(), listValores, "Integer");
                                                } else {
                                                    nodo2 = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato();
                                                }
                                            }
                                            suma = devolverResultado(ciclo.getListOp().get(i).getMiOperacion().get(j + 1), nodo1, nodo2, suma);
                                            tabla.modificarValor(ciclo.getListOp().get(i).getIdCambio(), listValores, "Integer", suma);

                                        } else {
                                            Integer nodo = null;
                                            if (ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getTipo().equals("String")) {
                                                nodo = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato().toString(), listValores, "Integer");
                                            } else {
                                                nodo = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato();
                                            }
                                            suma = devolverResultado(ciclo.getListOp().get(i).getMiOperacion().get(j + 1), suma, nodo, suma);
                                            tabla.modificarValor(ciclo.getListOp().get(i).getIdCambio(), listValores, "Integer", suma);
                                        }
                                    }
                                }

                            }

                        }
                    }
                }

            } else {
                for (int i = 0; i < ciclo.getListOp().size(); i++) {
                    int suma = 0;

                    for (int j = 0; j < ciclo.getListOp().get(i).getMiOperacion().size() - 1; j++) {
                        System.out.println(ciclo.getListPorPintar().size() + "  total cuadros");
                        System.out.println(ciclo.getListPorPintar().get(0).getOpX().get(0).getDato() + "  xxx");
                        System.out.println(ciclo.getListPorPintar().get(0).getOpY().get(0).getDato() + "     yyy");
                        //AQUI NO SE SABE MYY BIEN SI ES I O J DEPENDIENDO COMO SE EJECUTE SE DECIDI
                        if (i == 0) {
                            Integer nodo1 = null;
                            Integer nodo2 = null;
                            if (ciclo.getListOp().get(i).getMiOperacion().get(j).getTipo().equals("String")) {
                                nodo1 = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j).getDato().toString(), listValores, "Integer");
                                if (ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getTipo().equals("String")) {
                                    nodo2 = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato().toString(), listValores, "Integer");
                                } else {
                                    nodo2 = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato();
                                }
                            } else {
                                nodo1 = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j).getDato();
                                if (ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getTipo().equals("String")) {
                                    nodo2 = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato().toString(), listValores, "Integer");
                                } else {
                                    nodo2 = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato();
                                }
                            }
                            suma = devolverResultado(ciclo.getListOp().get(i).getMiOperacion().get(j + 1), nodo1, nodo2, suma);
                            System.out.println(suma);
                            tabla.modificarValor(ciclo.getListOp().get(i).getIdCambio(), listValores, "Integer", suma);
                            agregarPintadosWhile(ciclo, listValores, listPintados, tabla, idLienzo);

                        } else {
                            Integer nodo = null;
                            if (ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getTipo().equals("String")) {
                                nodo = (Integer) tabla.verificarUnValor(ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato().toString(), listValores, "Integer");
                            } else {
                                nodo = (Integer) ciclo.getListOp().get(i).getMiOperacion().get(j + 1).getDato();
                            }
                            suma = devolverResultado(ciclo.getListOp().get(i).getMiOperacion().get(j + 1), suma, nodo, suma);
                            System.out.println(suma);
                            tabla.modificarValor(ciclo.getListOp().get(i).getIdCambio(), listValores, "Integer", suma);
                            agregarPintadosWhile(ciclo, listValores, listPintados, tabla, idLienzo);

                        }

                    }

                }
            }
            listAux = devolverArreglo(ciclo, tabla, listValores);
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
                Boolean valor = tabla.comprobarCondicionTipo1(nuevo, (Integer) ciclo.getMiCondicional().get(i).getRelacional(), nuevo2);
                System.out.println(valor + "    soy el valor ;D");
                String cadena = ciclo.getMiCondicional().get(i).getCadena();
                TipoEncadenamiento tipo = new TipoEncadenamiento(cadena, valor);
                listAux.add(tipo);
            } else if (ciclo.getMiCondicional().get(i).getTipo().equals("Tipo2")) {
                //FFALTA COMPROBAR AQI SI EN UN IF O UN WHILE VIENE SOLAMENTE UN TRUE O; FALSE

                Boolean valor = tabla.comprobarCondicionTipo2(ciclo.getMiCondicional().get(i).getDato1().toString(), listValores);
                System.out.println(valor + "    soy el valor tipo2 :D");
                String cadena = ciclo.getMiCondicional().get(i).getCadena();
                TipoEncadenamiento tipo = new TipoEncadenamiento(cadena, valor);
                listAux.add(tipo);
            }

        }
        return listAux;
    }

    public void agregarPintadosWhile(While ciclo, ArrayList<ValoresPNT> listValores, ArrayList<Pintados> listPintados, TablaSimbolos tabla, String idLienzo) {
        CasillasAPintar casillas = new CasillasAPintar();
        for (int i = 0; i < ciclo.getListPorPintar().size(); i++) {
            casillas.determinarCasillas(ciclo.getListPorPintar().get(i), listValores, listPintados, tabla, idLienzo);
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

    private boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
