/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionEditorGrafico;

import InterfazEditorGrafico.PanelGrafico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import pollitos.Colores;
import pollitos.Lienzos;
import pollitos.Pintados;
import pollitos.Tiempos;

/**
 *
 * @author luisGonzalez
 */
public class CreacionObjetosLNZ {

    public void crearLienzos(ArrayList<Lienzos> misLienzos, ArrayList<Colores> listColores, ArrayList<Tiempos> listTiempos, JTabbedPane panelGrafico, ArrayList<Pintados> listPintados) {
        for (int i = 0; i < misLienzos.size(); i++) {
            ArrayList<Pintados> misPintados = new ArrayList<>();
            String nombreLienzo = misLienzos.get(i).getIdentificador();
            Colores miColor = buscarColoresLienzo(nombreLienzo, listColores);
            Tiempos miTiempo = buscarTiemposLienzo(nombreLienzo, listTiempos);
            clasificarMisCuadrosPintar(nombreLienzo, listPintados, misPintados);
            if (miColor != null && miTiempo != null) {
                PanelGrafico panel = new PanelGrafico(misLienzos.get(i), miTiempo, miColor, misPintados, listPintados);
                panelGrafico.addTab(misLienzos.get(i).getNombre(), panel);
                panelGrafico.setTabComponentAt(panelGrafico.getTabCount() - 1, crearCabecera(misLienzos.get(i).getNombre(), panelGrafico));
            } else {
                System.out.println("no se encontro el lienzo en alguno de los archivos :(");
            }
        }
    }

    public Colores buscarColoresLienzo(String nombreLienzo, ArrayList<Colores> listColores) {
        Colores colorLienzo = null;
        for (int i = 0; i < listColores.size(); i++) {
            String nombreColor = listColores.get(i).getNombreLienzo();
            if (nombreLienzo.equals(nombreColor)) {
                colorLienzo = listColores.get(i);
                break;
            }
        }
        return colorLienzo;
    }

    public Tiempos buscarTiemposLienzo(String nombreLienzo, ArrayList<Tiempos> listTiempos) {
        Tiempos tiempoLienzo = null;
        for (int i = 0; i < listTiempos.size(); i++) {
            String nombreTiempo = listTiempos.get(i).getNombreLienzo();
            if (nombreLienzo.equals(nombreTiempo)) {
                tiempoLienzo = listTiempos.get(i);
                break;
            }
        }
        return tiempoLienzo;
    }
    
    public void clasificarMisCuadrosPintar(String nombreLienzo, ArrayList<Pintados> listPintados, ArrayList<Pintados> misPintados){
        for (int i = 0; i < listPintados.size(); i++) {
            if(listPintados.get(i).getFunciono()){
                if(listPintados.get(i).getNombreLienzo().equals(nombreLienzo)){
                    misPintados.add(listPintados.get(i));
                }
            }
        }
    }

    public JPanel crearCabecera(String texto, JTabbedPane panelTexto) {
        final String titulo = texto;
        JPanel pnlTab = new JPanel();
        pnlTab.setLayout(new BoxLayout(pnlTab, BoxLayout.LINE_AXIS));
        pnlTab.setOpaque(false);
        JButton btnCerrar = new JButton("x");
        btnCerrar.setPreferredSize(new java.awt.Dimension(10, 10));
        JLabel lblTitulo = new JLabel(texto + "    ");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setOpaque(false);
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i;
                for (i = 0; i <= panelTexto.getTabCount() - 1; i++) {
                    if (titulo.equals(panelTexto.getTitleAt(i))) {
                        break;
                    }
                }
                panelTexto.removeTabAt(i);
            }
        });
        pnlTab.add(lblTitulo);
        pnlTab.add(btnCerrar);
        return pnlTab;
    }

}
