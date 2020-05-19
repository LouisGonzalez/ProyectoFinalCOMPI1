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
public class TipoEncadenamiento {
    
    private String encadenamiento;
    private Boolean valor;

    public TipoEncadenamiento(String encadenamiento, Boolean valor) {
        this.encadenamiento = encadenamiento;
        this.valor = valor;
        
    }

    public String getEncadenamiento() {
        return encadenamiento;
    }

    public void setEncadenamiento(String encadenamiento) {
        this.encadenamiento = encadenamiento;
    }

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }
    
    
    
}
