/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesPNT;

import java.util.ArrayList;
import pollitos.TipoEncadenamiento;

/**
 *
 * @author luisGonzalez
 */
public class CondicionesLogicas {

    private ArrayList<Boolean> trayectoria = new ArrayList<>();

    //AGREGAR EN TRAYECTORIA CADA CONDICION QUE SE LLEGUE A CUMPLIR O NO, ASI EN LA SIGUIENTE ITERACION DEL FOR SE COMPARA
    //CON LA ULTIMA AGREGADA DE TRAYECTORIA
    public Boolean verificar(ArrayList<TipoEncadenamiento> booleanos) {
        Boolean verificador = true;
        if (!booleanos.isEmpty()) {
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
        return verificador;
    }
}
