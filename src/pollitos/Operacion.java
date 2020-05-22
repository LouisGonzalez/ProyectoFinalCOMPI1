/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollitos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class Operacion {

    private String idCambio;
    private Integer noIf;

    private ArrayList<OpAritmeticasWhile> miOperacion = new ArrayList<>();

    public Operacion(String idCambio) {
        this.idCambio = idCambio;
    }

    public Integer getNoIf() {
        return noIf;
    }

    public void setNoIf(Integer noIf) {
        this.noIf = noIf;
    }

    public String getIdCambio() {
        return idCambio;
    }

    public void setIdCambio(String idCambio) {
        this.idCambio = idCambio;
    }

    public ArrayList<OpAritmeticasWhile> getMiOperacion() {
        return miOperacion;
    }

    public void setMiOperacion(ArrayList<OpAritmeticasWhile> miOperacion) {
        this.miOperacion = miOperacion;
    }

}
