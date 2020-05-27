/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionEditorGrafico;

import Animaciones.CreacionGifs;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import pollitos.Colores;
import pollitos.ImagenesTiempo;
import pollitos.Lienzos;
import pollitos.Pintados;
import pollitos.Tiempos;

/**
 *
 * @author luisGonzalez
 */
public class Animaciones {
    
    public void crearGif(String path, String nombre, JLabel panelMatriz, Tiempos misTiempos, Lienzos miLienzo, PanelMatriz principal, ArrayList<Pintados> misPintados, Colores misColores, ArrayList<Pintados> listPintados, JCheckBox borrador){
        CreacionGifs gif = new CreacionGifs();
        File file = new File(path+"/"+nombre+".gif");
        try {
            file.createNewFile();
            FileOutputStream os = new FileOutputStream(file);
            gif.start(os);
            gif.setSize(panelMatriz.getWidth(), panelMatriz.getHeight());
            gif.setRepeat(50);
            gif.setQuality(30);
            String inicio = misTiempos.getLienzoInicio();   
            ImagenesTiempo imgInicio = encontrarDuracion(misTiempos, inicio);
            String fin = misTiempos.getLienzoFin();
            ImagenesTiempo imgFin = encontrarDuracion(misTiempos, fin);
            
            BufferedImage imageInicio = new BufferedImage(panelMatriz.getWidth(), panelMatriz.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d1 = imageInicio.createGraphics();
            g2d1.fillRect(0, 0, panelMatriz.getWidth(), panelMatriz.getHeight());
            principal.crearTablero2(miLienzo, borrador, misPintados, misColores, imgInicio, listPintados, g2d1);
            g2d1.dispose();
            gif.setDelay(imgInicio.getDuracion());
            gif.addFrame(imageInicio);
            for (int i = 0; i < misTiempos.getTransiciones().size(); i++) {
                if(!misTiempos.getTransiciones().get(i).getId().equals(inicio) && !misTiempos.getTransiciones().get(i).equals(fin)){
                    BufferedImage image = new BufferedImage(panelMatriz.getWidth(), panelMatriz.getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2d = image.createGraphics();
                    g2d.fillRect(0, 0, panelMatriz.getWidth(), panelMatriz.getHeight());
                    principal.crearTablero2(miLienzo, borrador, misPintados, misColores, misTiempos.getTransiciones().get(i), listPintados, g2d);
                    g2d.dispose();
                    gif.setDelay(misTiempos.getTransiciones().get(i).getDuracion());
                    gif.addFrame(image);
                }
            }
            
            BufferedImage imageFin = new BufferedImage(panelMatriz.getWidth(), panelMatriz.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d2 = imageFin.createGraphics();
            g2d2.fillRect(0, 0, panelMatriz.getWidth(), panelMatriz.getHeight());
            principal.crearTablero2(miLienzo, borrador, misPintados, misColores, imgFin, listPintados, g2d2);
            g2d2.dispose();
            gif.setDelay(imgFin.getDuracion());
            gif.addFrame(imageFin);
            gif.finish();
            os.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Animaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ImagenesTiempo encontrarDuracion(Tiempos misTiempos, String id){
        ImagenesTiempo aDevolver = null;
        for (int i = 0; i < misTiempos.getTransiciones().size(); i++) {
            if(misTiempos.getTransiciones().get(i).getId().equals(id)){
                aDevolver = misTiempos.getTransiciones().get(i);
                break;
            }
        }
        return aDevolver;
    }
    
    public void crearPNG(String path, JLabel panelMatriz, Tiempos misTiempos, Lienzos miLienzo, PanelMatriz principal, ArrayList<Pintados> misPintados, Colores misColores, ArrayList<Pintados> listPintados, JCheckBox borrador){
        for (int i = 0; i < misTiempos.getTransiciones().size(); i++) {
            BufferedImage image = new BufferedImage(panelMatriz.getWidth(), panelMatriz.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            g2d.fillRect(0, 0, panelMatriz.getWidth(), panelMatriz.getHeight());
            principal.crearTablero2(miLienzo, borrador, misPintados, misColores, misTiempos.getTransiciones().get(i), listPintados, g2d);
            g2d.dispose();
            try {
                ImageIO.write(image, "jpg", new File(path+"/image"+i+".jpg"));
            } catch (IOException ex) {
                Logger.getLogger(Animaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
