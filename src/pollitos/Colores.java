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
    private boolean existe = false;

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

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
