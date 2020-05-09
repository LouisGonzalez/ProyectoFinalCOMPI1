/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesEditorTexto;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisGonzalez
 */
public class Guardado {
    
    public void guardarArchivo(String texto, String path){
        File archivo = new File(path);
        if(archivo.exists()){
            archivo.delete();
            guardarArchivo(texto, path);
        } else {
            try {
                archivo.createNewFile();
                FileWriter writer = new FileWriter(archivo);
                BufferedWriter buffer = new BufferedWriter(writer);
                buffer.write(texto);
                buffer.close();
            } catch (IOException ex) {
                Logger.getLogger(Guardado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
