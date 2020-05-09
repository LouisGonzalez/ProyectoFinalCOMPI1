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
public class Tiempos {
    
    private String nombreLienzo;
    private String lienzoInicio;
    private String lienzoFin;
    private ArrayList<ImagenesTiempo> transiciones;

    public String getNombreLienzo() {
        return nombreLienzo;
    }

    public void setNombreLienzo(String nombreLienzo) {
        this.nombreLienzo = nombreLienzo;
    }

    public String getLienzoInicio() {
        return lienzoInicio;
    }

    public void setLienzoInicio(String lienzoInicio) {
        this.lienzoInicio = lienzoInicio;
    }

    public String getLienzoFin() {
        return lienzoFin;
    }

    public void setLienzoFin(String lienzoFin) {
        this.lienzoFin = lienzoFin;
    }

    public ArrayList<ImagenesTiempo> getTransiciones() {
        return transiciones;
    }

    public void setTransiciones(ArrayList<ImagenesTiempo> transiciones) {
        this.transiciones = transiciones;
    }
       
}
