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
public class CuadrosPintar {
    
    private String idColor;
    private String idImagen;
    private Boolean enWhile;
    private Integer noIf;
    private Object[] rangoX = new Object[2];
    private Object[] rangoY = new Object[2];
    private ArrayList<OpAritmeticasWhile> opX;
    private ArrayList<OpAritmeticasWhile> opY;

    public CuadrosPintar(String idColor, String idImagen) {
        this.idColor = idColor;
        this.idImagen = idImagen;
    }

    public ArrayList<OpAritmeticasWhile> getOpX() {
        return opX;
        
    }

    public void setOpX(ArrayList<OpAritmeticasWhile> opX) {
        this.opX = opX;
    }

    public ArrayList<OpAritmeticasWhile> getOpY() {
        return opY;
    }

    public void setOpY(ArrayList<OpAritmeticasWhile> opY) {
        this.opY = opY;
    }

    public Boolean getEnWhile() {
        return enWhile;
    }

    public void setEnWhile(Boolean enWhile) {
        this.enWhile = enWhile;
    }

    public Integer getNoIf() {
        return noIf;
    }

    public void setNoIf(Integer noIf) {
        this.noIf = noIf;
    }

    public Object[] getRangoX() {
        return rangoX;
    }

    public void setRangoX(Object[] rangoX) {
        this.rangoX = rangoX;
    }

    public Object[] getRangoY() {
        return rangoY;
    }

    public void setRangoY(Object[] rangoY) {
        this.rangoY = rangoY;
    }

    public void setRangoY(Integer[] rangoY) {
        this.rangoY = rangoY;
    }
    
    public String getIdColor() {
        return idColor;
    }

    public void setIdColor(String idColor) {
        this.idColor = idColor;
    }

    public String getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(String idImagen) {
        this.idImagen = idImagen;
    }

}
