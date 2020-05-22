/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesEditorTexto;

import InterfazEditorTexto.InterfazTexto;
import java.util.ArrayList;
import pollitos.Colores;
import pollitos.ImagenesTiempo;
import pollitos.LienzoColor;
import pollitos.Lienzos;
import pollitos.Pintados;
import pollitos.Tiempos;

/**
 *
 * @author luisGonzalez
 */
public class VerificacionObjetos {

    //Detecta si los lienzos dentro del archivo CLRS existen dentro del archivo LNZ
    public boolean verificarLienzosColores(ArrayList<Lienzos> listLienzos, ArrayList<Colores> listColores) {
        boolean todoCorrecto = true;
        for (int i = 0; i < listColores.size(); i++) {
            for (int j = 0; j < listLienzos.size(); j++) {
                if (listColores.get(i).getNombreLienzo().equals(listLienzos.get(j).getIdentificador())) {
                    listColores.get(i).setExiste(true);
                }
            }
        }

        for (int i = 0; i < listColores.size(); i++) {
            if (!listColores.get(i).isExiste()) {
                InterfazTexto.bandejaErrores += "El lienzo: " + listColores.get(i).getNombreLienzo() + " sentenciado en el archivo CLRS no existe dentro del archivo LNZ.\n";
                todoCorrecto = false;

            }
        }

        return todoCorrecto;
    }

    public boolean verificarLienzosTiempos(ArrayList<Lienzos> listLienzos, ArrayList<Tiempos> listTiempos) {
        boolean todoCorrecto = true;
        for (int i = 0; i < listTiempos.size(); i++) {
            for (int j = 0; j < listLienzos.size(); j++) {
                if (listTiempos.get(i).getNombreLienzo().equals(listLienzos.get(j).getIdentificador())) {
                    listTiempos.get(i).setExiste(true);
                }
            }
        }

        for (int i = 0; i < listTiempos.size(); i++) {
            if (!listTiempos.get(i).isExiste()) {
                InterfazTexto.bandejaErrores += "El lienzo: " + listTiempos.get(i).getNombreLienzo() + " sentenciado en el archivo TMP no existe dentro del archivo LNZ.\n";
                todoCorrecto = false;

            }
        }
        return todoCorrecto;
    }
    
    //MANANA METER ESTE METODO DE ABAJO PARA DEPURAR LOS CUADROS QUE DEBERIAN SER PINTADOS, YA CON ESO SOLO QUEDARIA PINTAR, RECUERDA QUE HAY ALGUNAS CONDICIONES EN EL WHILE QUE AUN NO HAS TERMINADO DE ARREGLAR PARA QUE FUNCIONE AL 100

    public void verificarCuadrosPorPintar(ArrayList<Pintados> listPintados, ArrayList<Lienzos> listLienzos, ArrayList<Tiempos> listTiempos, ArrayList<Colores> listColores) {
        //DEPURACION 1
        for (int i = 0; i < listPintados.size(); i++) {
            for (int j = 0; j < listLienzos.size(); j++) {
                if (listPintados.get(i).getNombreLienzo().equals(listLienzos.get(j).getIdentificador())) {
                    listPintados.get(i).setFunciono(true);
                }
            }
        }
        //DEPURACION 2
        for (int i = 0; i < listPintados.size(); i++) {
            if (listPintados.get(i).getFunciono()) {
                Lienzos aUsar = buscarLienzo(listPintados.get(i).getNombreLienzo(), listLienzos);
                if (listPintados.get(i).getPosX() < 0 || listPintados.get(i).getPosX() >= aUsar.getMisDimensiones().getCuadrosX()){
                    listPintados.get(i).setFunciono(false);
                } 
                if(listPintados.get(i).getPosY() < 0 || listPintados.get(i).getPosY() >= aUsar.getMisDimensiones().getCuadrosY()){
                    listPintados.get(i).setFunciono(false);
                }
            } 
        }
        //DEPURACION 3
        for (int i = 0; i < listPintados.size(); i++) {
            if(listPintados.get(i).getFunciono()){
                Colores aUsar = buscarColores(listPintados.get(i).getNombreLienzo(), listColores);
                if(!buscarColorEspecifico(listPintados.get(i).getIdColor(), aUsar.getListColores())){
                    listPintados.get(i).setFunciono(false);
                }
            }
        }
        //DEPURACION 4
        for (int i = 0; i < listPintados.size(); i++) {
            if(listPintados.get(i).getFunciono()){
                Tiempos aUsar = buscarImagen(listPintados.get(i).getNombreLienzo(), listTiempos);
                if(!buscarImagenEspecifica(listPintados.get(i).getIdImagen(), aUsar.getTransiciones())){
                    listPintados.get(i).setFunciono(false);
                }
            }
        }
        
        
    }

    public Lienzos buscarLienzo(String id, ArrayList<Lienzos> listLienzos) {
        Lienzos aDevolver = null;
        for (int i = 0; i < listLienzos.size(); i++) {
            if (listLienzos.get(i).getIdentificador().equals(id)) {
                aDevolver = listLienzos.get(i);
                break;
            }
        }
        return aDevolver;
    }
    
    public Colores buscarColores(String id, ArrayList<Colores> listColores){
        Colores aDevolver = null;
        for (int i = 0; i < listColores.size(); i++) {
            if(listColores.get(i).getNombreLienzo().equals(id)){
                aDevolver = listColores.get(i);
                break;
            }
        }
        return aDevolver;
    }
    
    public boolean buscarColorEspecifico(String id, ArrayList<LienzoColor> listColores){
        boolean encontrado = false;
        for (int i = 0; i < listColores.size(); i++) {
            if(listColores.get(i).getIdColor().equals(id)){
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    
    public Tiempos buscarImagen(String id, ArrayList<Tiempos> listTiempos){
        Tiempos aDevolver = null;
        for (int i = 0; i < listTiempos.size(); i++) {
            if(listTiempos.get(i).getNombreLienzo().equals(id)){
                aDevolver = listTiempos.get(i);
                break;
            }
        }
        return aDevolver;
    }
    
    public Boolean buscarImagenEspecifica(String id, ArrayList<ImagenesTiempo> listImagenes){
       boolean encontrado = false;
        for (int i = 0; i < listImagenes.size(); i++) {
            if(listImagenes.get(i).getId().equals(id)){
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
}
