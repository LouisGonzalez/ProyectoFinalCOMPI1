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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import pollitos.Colores;
import pollitos.Tiempos;

/**
 *
 * @author luisGonzalez
 */
public class LlenadoPaneles {

    public JLabel panelColores, panelNombreColor;
    private JLabel[][] tableroColor;
    private JLabel[][] tableroNombreColor;
    private int i, j, x, y;

    public LlenadoPaneles(JLabel panelColores, JLabel[][] tableroColor, JLabel[][] tableroNombreColor, JLabel panelNombreColor) {
        this.panelColores = panelColores;
        this.tableroColor = tableroColor;
        this.tableroNombreColor = tableroNombreColor;
        this.panelNombreColor = panelNombreColor;
    }

    public void llenadoPanel1(Tiempos misTiempos, JTextField numImagenes, JTextField txtInicio, JTextField txtFin) {
        int contadorImagenes = misTiempos.getTransiciones().size();
        String inicio = misTiempos.getLienzoInicio();
        String fin = misTiempos.getLienzoFin();
        numImagenes.setText(Integer.toString(contadorImagenes));
        txtInicio.setText(inicio);
        txtFin.setText(fin);
    }

    public void llenadoPanel2(Tiempos misTiempos, JComboBox comboImg) {
        for (int i = 0; i < misTiempos.getTransiciones().size(); i++) {
            String idImagen = misTiempos.getTransiciones().get(i).getId();
            comboImg.addItem(idImagen);
        }
    }

    public void cambioDuracion(Tiempos misTiempos, String idImagen, JTextField txtDuracion) {
        for (int i = 0; i < misTiempos.getTransiciones().size(); i++) {
            if (misTiempos.getTransiciones().get(i).getId().equals(idImagen)) {
                txtDuracion.setText(Integer.toString(misTiempos.getTransiciones().get(i).getDuracion()));
                break;
            }
        }
    }

    public void asignacionColores(Colores misColores, JLabel lblSeleccionado) {
        int filas = misColores.getListColores().size();
        int columnas = 1;
        tableroColor = new JLabel[filas][columnas];
        panelColores.setLayout(new GridLayout(filas, columnas));
        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas; j++) {
                JLabel matriz = new JLabel();
                int posX = j;
                int posY = i;
                matriz.setOpaque(true);
                matriz.setBackground(Color.white);
                matriz.setBorder(new LineBorder(Color.black));

                if (misColores.getListColores().get(i).getColorHex() == null) {
                    int rojo = misColores.getListColores().get(i).getRojo();
                    int azul = misColores.getListColores().get(i).getAzul();
                    int verde = misColores.getListColores().get(i).getVerde();
                    matriz.setBackground(new Color(rojo, verde, azul));
                } else {
                    int color = conversionHex(misColores.getListColores().get(i).getColorHex());
                    matriz.setBackground(new Color(color));
                }

                tableroColor[i][j] = matriz;
                tableroColor[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent event) {
                        System.out.println(posY + "     :D");
                        if (misColores.getListColores().get(posY).getColorHex() == null) {
                            int rojo = misColores.getListColores().get(posY).getRojo();
                            int azul = misColores.getListColores().get(posY).getAzul();
                            int verde = misColores.getListColores().get(posY).getVerde();
                            System.out.println(rojo + " " + verde + "  "+ azul);
                            lblSeleccionado.setOpaque(true);
                            lblSeleccionado.setBackground(new Color(rojo, verde, azul));
                            PanelGrafico.color = Integer.toString(rojo)+","+Integer.toString(verde)+","+Integer.toString(azul);
                            System.out.println(PanelGrafico.color);
                        } else {
                            int color = conversionHex(misColores.getListColores().get(posY).getColorHex());
                            System.out.println(misColores.getListColores().get(posY).getColorHex());
                            lblSeleccionado.setOpaque(true);
                            lblSeleccionado.setBackground(new Color(color));
                            PanelGrafico.color = Integer.toString(color);
                            System.out.println(PanelGrafico.color);
                        }
                    }
                });
                panelColores.add(tableroColor[i][j]);
                panelColores.validate();
                panelColores.repaint();
            }
        }
    }

    public int conversionHex(String colorHex) {
        String nuevo = colorHex.substring(1);
        return Integer.parseInt(nuevo, 16);
    }

    public void asignacionNombresColores(Colores misColores) {
        int filas = misColores.getListColores().size();
        int columnas = 1;
        tableroNombreColor = new JLabel[filas][columnas];
        panelNombreColor.setLayout(new GridLayout(filas, columnas));
        for (x = 0; x < filas; x++) {
            for (y = 0; y < columnas; y++) {
                JLabel matriz = new JLabel();
                matriz.setOpaque(true);
                matriz.setText(misColores.getListColores().get(x).getIdColor());
                tableroNombreColor[x][y] = matriz;
                tableroNombreColor[x][y].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent event) {
                        System.out.println("fujnciono");
                    }
                });
                panelNombreColor.add(tableroNombreColor[x][y]);
                panelNombreColor.validate();
                panelNombreColor.repaint();
            }
        }

    }

}
