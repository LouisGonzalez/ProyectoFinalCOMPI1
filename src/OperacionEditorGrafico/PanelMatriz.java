/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionEditorGrafico;

import InterfazEditorGrafico.PanelGrafico;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
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
public class PanelMatriz {

    private JLabel panelMatriz;
    private JLabel[][] tableroPrincipal;

    public PanelMatriz(JLabel panelMatriz, JLabel[][] tableroPrincipal) {
        this.panelMatriz = panelMatriz;
        this.tableroPrincipal = tableroPrincipal;
    }

    public void crearTablero(Lienzos miLienzo, JCheckBox borrador, ArrayList<Pintados> misPintados, Colores misColores, ImagenesTiempo imagen, ArrayList<Pintados> listPintados) {
        panelMatriz.removeAll();
        int filas = miLienzo.getMisDimensiones().getCuadrosY();
        int columnas = miLienzo.getMisDimensiones().getCuadrosX();
        int dimensiones = miLienzo.getMisDimensiones().getDimensionCuadros();
        tableroPrincipal = new JLabel[filas][columnas];
        panelMatriz.setLayout(new GridLayout(filas, columnas));
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int posX = j;
                int posY = i;
                JLabel matriz = new JLabel();
                matriz.setOpaque(true);
                matriz.setBorder(new LineBorder(Color.black));
                matriz.setSize(dimensiones, dimensiones);
                if (miLienzo.getMisColores().getColorHex() == null) {
                    int rojo = miLienzo.getMisColores().getRojo();
                    int verde = miLienzo.getMisColores().getVerde();
                    int azul = miLienzo.getMisColores().getAzul();
                    matriz.setBackground(new Color(rojo, verde, azul));
                } else {
                    int color = conversionHex(miLienzo.getMisColores().getColorHex());
                    matriz.setBackground(new Color(color));
                }
                pintarCuadros(misPintados, j, i, misColores, matriz, imagen.getId());
                tableroPrincipal[i][j] = matriz;
                tableroPrincipal[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent event) {
                        if (borrador.isSelected()) {
                            if (miLienzo.getMisColores().getColorHex() == null) {
                                int rojo = miLienzo.getMisColores().getRojo();
                                int verde = miLienzo.getMisColores().getVerde();
                                int azul = miLienzo.getMisColores().getAzul();
                                tableroPrincipal[posY][posX].setBackground(new Color(rojo, verde, azul));
                            } else {
                                int color = conversionHex(miLienzo.getMisColores().getColorHex());
                                matriz.setBackground(new Color(color));
                            }
                            borrarCasillaArchivo(misPintados, posX, posY, imagen.getId(), listPintados);
                        } else {
                            if (PanelGrafico.color != null) {
                                String[] colores = PanelGrafico.color.split("\\,");
                                if (colores.length > 1) {
                                    tableroPrincipal[posY][posX].setBackground(new Color(Integer.parseInt(colores[0]), Integer.parseInt(colores[1]), Integer.parseInt(colores[2])));
                                } else {
                                    tableroPrincipal[posY][posX].setBackground(new Color(Integer.parseInt(colores[0])));
                                }
                                borrarCasillaArchivo(misPintados, posX, posY, imagen.getId(), listPintados);
                                Pintados pintado = new Pintados(posX, posY, PanelGrafico.nombreColor, imagen.getId(), miLienzo.getIdentificador());
                                pintado.setFunciono(true);
                                misPintados.add(pintado);
                                listPintados.add(pintado);
                            }
                        }
                        //   tableroPrincipal[posY][posX].setBackground(PanelGrafico.color.);
                    }

                });
                panelMatriz.add(tableroPrincipal[i][j]);
                panelMatriz.validate();
                panelMatriz.repaint();

            }
        }
    }

    public void crearTablero2(Lienzos miLienzo, JCheckBox borrador, ArrayList<Pintados> misPintados, Colores misColores, ImagenesTiempo imagen, ArrayList<Pintados> listPintados, Graphics2D grafo) {
        panelMatriz.removeAll();
        int filas = miLienzo.getMisDimensiones().getCuadrosY();
        int columnas = miLienzo.getMisDimensiones().getCuadrosX();
        int dimensiones = miLienzo.getMisDimensiones().getDimensionCuadros();
        tableroPrincipal = new JLabel[filas][columnas];
        panelMatriz.setLayout(new GridLayout(filas, columnas));
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JLabel matriz = new JLabel();
                matriz.setOpaque(true);
                matriz.setBorder(new LineBorder(Color.black));
                matriz.setSize(dimensiones, dimensiones);
                if (miLienzo.getMisColores().getColorHex() == null) {
                    int rojo = miLienzo.getMisColores().getRojo();
                    int verde = miLienzo.getMisColores().getVerde();
                    int azul = miLienzo.getMisColores().getAzul();
                    matriz.setBackground(new Color(rojo, verde, azul));
                } else {
                    int color = conversionHex(miLienzo.getMisColores().getColorHex());
                    matriz.setBackground(new Color(color));
                }
                pintarCuadros(misPintados, j, i, misColores, matriz, imagen.getId());
                tableroPrincipal[i][j] = matriz;
                panelMatriz.add(tableroPrincipal[i][j]);
                panelMatriz.validate();
                panelMatriz.repaint();
                grafo.setColor(tableroPrincipal[i][j].getBackground());
                grafo.fillRect(j*(panelMatriz.getWidth()/columnas), i*(panelMatriz.getHeight()/filas), panelMatriz.getWidth()/columnas, panelMatriz.getHeight()/filas);
            }
        }
        
    }

    public void pintarCuadros(ArrayList<Pintados> misPintados, int x, int y, Colores misColores, JLabel actual, String idImagen) {
        for (int i = 0; i < misPintados.size(); i++) {
            if (y == misPintados.get(i).getPosY() && x == misPintados.get(i).getPosX()) {
                if (misPintados.get(i).getFunciono()) {
                    if (misPintados.get(i).getIdImagen().equals(idImagen)) {
                        LienzoColor aUsar = buscarColor(misColores, misPintados.get(i).getIdColor());
                        if (aUsar.getColorHex() == null) {
                            int rojo = aUsar.getRojo();
                            int azul = aUsar.getAzul();
                            int verde = aUsar.getVerde();
                            actual.setBackground(new Color(rojo, verde, azul));

                        } else {
                            int color = conversionHex(aUsar.getColorHex());
                            actual.setBackground(new Color(color));
                        }
                    }
                }
            }
        }
    }

    public void borrarCasillaArchivo(ArrayList<Pintados> misPintados, int x, int y, String idImagen, ArrayList<Pintados> listPintados) {
        for (int i = 0; i < misPintados.size(); i++) {
            if (misPintados.get(i).getFunciono()) {
                if (y == misPintados.get(i).getPosY() && x == misPintados.get(i).getPosX()) {
                    if (misPintados.get(i).getIdImagen().equals(idImagen)) {
                        misPintados.get(i).setFunciono(false);

                        for (int j = 0; j < listPintados.size(); j++) {
                            if (listPintados.get(j).getPosX() == x && listPintados.get(j).getPosY() == y) {
                                if (listPintados.get(j).getIdImagen().equals(idImagen)) {
                                    listPintados.get(j).setFunciono(false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public LienzoColor buscarColor(Colores misColores, String id) {
        LienzoColor aDevolver = null;
        for (int i = 0; i < misColores.getListColores().size(); i++) {
            if (misColores.getListColores().get(i).getIdColor().equals(id)) {
                aDevolver = misColores.getListColores().get(i);
                break;
            }
        }
        return aDevolver;
    }

    public int conversionHex(String colorHex) {
        String nuevo = colorHex.substring(1);
        return Integer.parseInt(nuevo, 16);
    }

}
