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
public class Colores {
    
    private String nombreLienzo;
    private ArrayList<LienzoColor> listColores;

    public String getNombreLienzo() {
        return nombreLienzo;
    }

    public void setNombreLienzo(String nombreLienzo) {
        this.nombreLienzo = nombreLienzo;
    }

    public ArrayList<LienzoColor> getListColores() {
        return listColores;
    }

    public void setListColores(ArrayList<LienzoColor> listColores) {
        this.listColores = listColores;
    }
    
}
