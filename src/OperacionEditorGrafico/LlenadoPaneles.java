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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import pollitos.Colores;
import pollitos.Lienzos;
import pollitos.Tiempos;

/**
 *
 * @author luisGonzalez
 */
public class LlenadoPaneles {

    public JLabel panelColores;
    private JLabel[][] tableroColor;
    private int i, j;

    public LlenadoPaneles(JLabel panelColores, JLabel[][] tableroColor) {
        this.panelColores = panelColores;
        this.tableroColor = tableroColor;
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

    public void asignacionColores(Colores misColores) {
        int filas = misColores.getListColores().size();
        int columnas = 1;
        tableroColor = new JLabel[filas][columnas];
        panelColores.setLayout(new GridLayout(filas, columnas));
        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas; j++) {
                JLabel matriz = new JLabel();
              
                matriz.setOpaque(true);
                matriz.setBackground(Color.white);
                matriz.setBorder(new LineBorder(Color.black));
                tableroColor[i][j] = matriz;
                tableroColor[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent event) {
                       System.out.println("hola q hace");
                    }
                });
                panelColores.add(tableroColor[i][j]);
                panelColores.validate();
                panelColores.repaint();
            }
        }
      
    }

}
