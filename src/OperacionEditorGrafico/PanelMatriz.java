/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionEditorGrafico;

import InterfazEditorGrafico.PanelGrafico;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import pollitos.Lienzos;

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

    public void crearTablero(Lienzos miLienzo, JCheckBox borrador) {
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
                        } else {
                            if (PanelGrafico.color != null) {
                                String[] colores = PanelGrafico.color.split("\\,");
                                if (colores.length > 1) {
                                    tableroPrincipal[posY][posX].setBackground(new Color(Integer.parseInt(colores[0]), Integer.parseInt(colores[1]), Integer.parseInt(colores[2])));
                                } else {
                                    tableroPrincipal[posY][posX].setBackground(new Color(Integer.parseInt(colores[0])));
                                }
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

    public int conversionHex(String colorHex) {
        String nuevo = colorHex.substring(1);
        return Integer.parseInt(nuevo, 16);
    }

}
