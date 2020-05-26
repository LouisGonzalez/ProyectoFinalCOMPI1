/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionEditorGrafico;

import java.util.ArrayList;
import pollitos.Colores;
import pollitos.Lienzos;
import pollitos.Pintados;
import pollitos.Tiempos;

/**
 *
 * @author luisGonzalez
 */
public class NuevosArchivos {

    public String creacionArchivoCLRS(ArrayList<Colores> listColores) {
        String texto = "";
        texto += "{\n";
        texto += "\tCOLORES:{\n";
        for (int i = 0; i < listColores.size(); i++) {
            texto += "\t\t" + listColores.get(i).getNombreLienzo() + ":{\n";
            for (int j = 0; j < listColores.get(i).getListColores().size(); j++) {
                texto += "\t\t\t" + listColores.get(i).getListColores().get(j).getIdColor() + ":{\n";

                if (listColores.get(i).getListColores().get(j).getColorHex() != null) {
                    texto += "\t\t\t\tHEX: " + listColores.get(i).getListColores().get(j).getColorHex() + "\n";
                } else {
                    texto += "\t\t\t\tRed: " + listColores.get(i).getListColores().get(j).getRojo() + ",\n";
                    texto += "\t\t\t\tBlue: " + listColores.get(i).getListColores().get(j).getAzul() + ",\n";
                    texto += "\t\t\t\tGreen: " + listColores.get(i).getListColores().get(j).getVerde() + "\n";

                }
                if (j == listColores.get(i).getListColores().size() - 1) {
                    texto += "\t\t\t}\n";
                } else {
                    texto += "\t\t\t},\n";
                }
            }
            if (i == listColores.size() - 1) {
                texto += "\t\t}\n";
            } else {
                texto += "\t\t},\n";
            }
        }
        texto += "\t}\n";
        texto += "}";
        return texto;
    }

    public String creacionArchivoPNT(ArrayList<Pintados> listPintados, ArrayList<Lienzos> listLienzos) {
        String texto = "";
        texto += "VARS [\n";
        texto += "]\n";
        for (int i = 0; i < listLienzos.size(); i++) {
            texto += "INSTRUCCIONES(" + listLienzos.get(i).getIdentificador() + ") [\n";
            for (int j = 0; j < listPintados.size(); j++) {
                if (listPintados.get(j).getFunciono()) {
                    if (listPintados.get(j).getNombreLienzo().equals(listLienzos.get(i).getIdentificador())) {
                        texto += "\tPINTAR(\"" + listPintados.get(j).getIdColor() + "\",\"" + listPintados.get(j).getIdImagen() + "\"," + listPintados.get(j).getPosX() + "," + listPintados.get(j).getPosY() + ");\n";
                    }
                }
            }
            texto += "]\n";
        }
        return texto;
    }

    public String creacionArchivoTMP(ArrayList<Lienzos> listLienzos, ArrayList<Tiempos> listTiempos) {
        String texto = "";
        texto += "{\n";
        texto += "\tTIEMPOS:{\n";
        for (int i = 0; i < listLienzos.size(); i++) {
            texto += "\t\t" + listLienzos.get(i).getIdentificador() + ":{\n";
            Tiempos aUsar = buscarTiempo(listTiempos, listLienzos.get(i).getIdentificador());
            texto += "\t\t\tinicio:\"" + aUsar.getLienzoInicio() + "\",\n";
            texto += "\t\t\tfin:\"" + aUsar.getLienzoFin() + "\",\n";
            texto += "\t\t\timagenes:[\n";
            for (int j = 0; j < aUsar.getTransiciones().size(); j++) {
                texto += "\t\t\t{\n";
                texto += "\t\t\t\tid:\"" + aUsar.getTransiciones().get(j).getId() + "\",\n";
                texto += "\t\t\t\tduracion:" + aUsar.getTransiciones().get(j).getDuracion() + "\n";
                if (j == aUsar.getTransiciones().size() - 1) {
                    texto += "\t\t\t}\n";
                } else {
                    texto += "\t\t\t},\n";
                }
            }
            texto += "\t\t\t]\n";
            if (i == listLienzos.size() - 1) {
                texto += "\t\t}\n";
            } else {
                texto += "\t\t},\n";
            }
        }
        texto += "\t}\n";
        texto += "}";
        return texto;
    }

    public String creacionArchivoLNZ(ArrayList<Lienzos> listLienzos) {
        String texto = "";
        texto += "{\n";
        texto += "\tLIENZOS:{\n";
        for (int i = 0; i < listLienzos.size(); i++) {
            texto += "\t\t" + listLienzos.get(i).getIdentificador() + ":{\n";
            texto += "\t\t\tnombre:\"" + listLienzos.get(i).getNombre() + "\",\n";
            texto += "\t\t\ttipo:\"" + listLienzos.get(i).getTipo() + "\",\n";
            texto += "\t\t\tFondo:{\n";
            if (listLienzos.get(i).getMisColores().getColorHex() != null) {
                texto += "\t\t\t\tHEX: " + listLienzos.get(i).getMisColores().getColorHex() + "\n";
            } else {
                texto += "\t\t\t\tRed: " + listLienzos.get(i).getMisColores().getRojo() + ",\n";
                texto += "\t\t\t\tBlue: " + listLienzos.get(i).getMisColores().getAzul() + ",\n";
                texto += "\t\t\t\tGreen: " + listLienzos.get(i).getMisColores().getVerde() + "\n";
            }
            texto += "\t\t\t},\n";
            texto += "\t\t\tsize:{\n";
            texto += "\t\t\t\tcuadro: " + listLienzos.get(i).getMisDimensiones().getDimensionCuadros() + ",\n";
            texto += "\t\t\t\tdimension_x: " + listLienzos.get(i).getMisDimensiones().getCuadrosX() + ",\n";
            texto += "\t\t\t\tdimension_y: " + listLienzos.get(i).getMisDimensiones().getCuadrosY() + "\n";
            texto += "\t\t\t}\n";
            if (i == listLienzos.size() - 1) {
                texto += "\t\t}\n";
            } else {
                texto += "\t\t},\n";
            }
        }
        texto += "\t}\n";
        texto += "}";
        return texto;
    }

    public Tiempos buscarTiempo(ArrayList<Tiempos> listTiempos, String id) {
        Tiempos aDevolver = null;
        for (int i = 0; i < listTiempos.size(); i++) {
            if (listTiempos.get(i).getNombreLienzo().equals(id)) {
                aDevolver = listTiempos.get(i);
                break;
            }
        }
        return aDevolver;
    }
}
