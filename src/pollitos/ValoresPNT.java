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
public class ValoresPNT {
    
    private String tipo;
    private String id;
    private String valorCadena;
    private Integer valorEntero;
    private Boolean valorBoolean;

    public ValoresPNT(String tipo, String id, String valorCadena, Integer valorEntero, Boolean valorBoolean) {
        this.tipo = tipo;
        this.id = id;
        this.valorCadena = valorCadena;
        this.valorEntero = valorEntero;
        this.valorBoolean = valorBoolean;
    }
    
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValorCadena() {
        return valorCadena;
    }

    public void setValorCadena(String valorCadena) {
        this.valorCadena = valorCadena;
    }

    public Integer getValorEntero() {
        return valorEntero;
    }

    public void setValorEntero(Integer valorEntero) {
        this.valorEntero = valorEntero;
    }

    public Boolean getValorBoolean() {
        return valorBoolean;
    }

    public void setValorBoolean(Boolean valorBolean) {
        this.valorBoolean = valorBolean;
    }
    
    
}
