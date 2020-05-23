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
public class ImagenesTiempo {
    
    private String id;
    private Integer duracion;
    private ArrayList<Pintados> auxiliar = new ArrayList<>();

    public ArrayList<Pintados> getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(ArrayList<Pintados> auxiliar) {
        this.auxiliar = auxiliar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    
}
