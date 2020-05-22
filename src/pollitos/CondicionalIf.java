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
public class CondicionalIf {
    
    private ArrayList<TipoEncadenamiento> condicion;
    private Integer noIf;

    public Integer getNoIf() {
        return noIf;
    }

    public void setNoIf(Integer noIf) {
        this.noIf = noIf;
    }
    
    public CondicionalIf(ArrayList<TipoEncadenamiento> condicion, Integer noIf) {
        this.condicion = condicion;
        this.noIf = noIf;
    }

    public ArrayList<TipoEncadenamiento> getCondicion() {
        return condicion;
    }

    public void setCondicion(ArrayList<TipoEncadenamiento> condicion) {
        this.condicion = condicion;
    }
  
    
}
