/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollitos;

/**
 *
 * @author luisGonzalez
 */
public class Lienzos {
    
    private String identificador;
    private String nombre;
    private String tipo;
    private LienzoColor misColores;
    private LienzoSize misDimensiones;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LienzoColor getMisColores() {
        return misColores;
    }

    public void setMisColores(LienzoColor misColores) {
        this.misColores = misColores;
    }

    public LienzoSize getMisDimensiones() {
        return misDimensiones;
    }

    public void setMisDimensiones(LienzoSize misDimensiones) {
        this.misDimensiones = misDimensiones;
    }
    
    
}
