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
public class OpAritmeticasWhile {
    
    private Object dato;
    private String tipo;        //SI EL TIPO ES STRING BUSCAR EN LA TABLA, SI ES INT DE UNA SUMAR
    private String operacion;
    private Boolean enPintar;

    public OpAritmeticasWhile(Object dato, String operacion, String tipo) {
        this.dato = dato;
        this.operacion = operacion;
        this.tipo = tipo;
    }

    public Boolean getEnPintar() {
        return enPintar;
    }

    public void setEnPintar(Boolean enPintar) {
        this.enPintar = enPintar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
    
}
