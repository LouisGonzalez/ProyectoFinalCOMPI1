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
public class While {

    private ArrayList<CuadrosPintar> listPorPintar = new ArrayList<>();
    private CondicionalIf condicional;
    private ArrayList<Operacion> listOp = new ArrayList<>();
    private ArrayList<CondicionWhile> miCondicional = new ArrayList<>();

    public ArrayList<CondicionWhile> getMiCondicional() {
        return miCondicional;
    }

    public void setMiCondicional(ArrayList<CondicionWhile> miCondicional) {
        this.miCondicional = miCondicional;
    }
    
    public ArrayList<Operacion> getListOp() {
        return listOp;
    }

    public void setListOp(ArrayList<Operacion> listOp) {
        this.listOp = listOp;
    }

    public ArrayList<CuadrosPintar> getListPorPintar() {
        return listPorPintar;
    }

    public void setListPorPintar(ArrayList<CuadrosPintar> listPorPintar) {
        this.listPorPintar = listPorPintar;
    }

    public CondicionalIf getCondicional() {
        return condicional;
    }

    public void setCondicional(CondicionalIf condicional) {
        this.condicional = condicional;
    }

}
