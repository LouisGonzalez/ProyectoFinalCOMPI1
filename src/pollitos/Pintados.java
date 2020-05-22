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
public class Pintados {
    
    private Integer posX;
    private Integer posY;
    private String idColor;
    private String idImagen;
    private String nombreLienzo;
    private Boolean funciono = false;

    public Pintados(Integer posX, Integer posY, String idColor, String idImagen, String nombreLienzo) {
        this.posX = posX;
        this.posY = posY;
        this.idColor = idColor;
        this.idImagen = idImagen;
        this.nombreLienzo = nombreLienzo;
    }

    public Boolean getFunciono() {
        return funciono;
    }

    public void setFunciono(Boolean funciono) {
        this.funciono = funciono;
    }
    
    public String getNombreLienzo() {
        return nombreLienzo;
    }

    public void setNombreLienzo(String nombreLienzo) {
        this.nombreLienzo = nombreLienzo;
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

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }
    
}
