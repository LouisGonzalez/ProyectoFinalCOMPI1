/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionEditorGrafico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisGonzalez
 */
public class CreacionNuevosArchivos {
    
    
    public void crearArchivoLNZ(String path, int contador, String texto){
        File file = new File(path+"/archivo"+contador+".lnz");
        if(file.exists()){
            contador++;
            crearArchivoLNZ(path, contador, texto);
        } else {
            try {
                file.createNewFile();
                BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
                buffer.write(texto);
                buffer.close();
            } catch (IOException ex) {
                Logger.getLogger(CreacionNuevosArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void crearArchivoCLRS(String path, int contador, String texto){
        File file = new File(path+"/archivo"+contador+".clrs");
        if(file.exists()){
            contador++;
            crearArchivoCLRS(path, contador, texto);
        } else {
            try {
                file.createNewFile();
                BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
                buffer.write(texto);
                buffer.close();
            } catch (IOException ex) {
                Logger.getLogger(CreacionNuevosArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void crearArchivoPNT(String path, int contador, String texto){
        File file = new File(path+"/archivo"+contador+".pnt");
        if(file.exists()){
            contador++;
            crearArchivoPNT(path, contador, texto);
        } else {
            try {
                file.createNewFile();
                BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
                buffer.write(texto);
                buffer.close();
            } catch (IOException ex) {
                Logger.getLogger(CreacionNuevosArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void crearArchivoTMP(String path, int contador, String texto){
        File file = new File(path+"/archivo"+contador+".tmp");
        if(file.exists()){
            contador++;
            crearArchivoTMP(path, contador, texto); 
        } else {
            try {
                file.createNewFile();
                BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
                buffer.write(texto);
                buffer.close();
            } catch (IOException ex) {
                Logger.getLogger(CreacionNuevosArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
