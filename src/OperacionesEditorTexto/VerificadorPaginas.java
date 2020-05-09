/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperacionesEditorTexto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author luisGonzalez
 */
public class VerificadorPaginas {

    //verifica si ya hay algun archivo con esta extension
    public void verificarExtensiones(JTabbedPane panelTexto, String titulo, JPanel panel) {
        boolean encontrado = false;
        String[] extensiones = titulo.split("\\.");
        String extension = extensiones[extensiones.length - 1];
        if (panelTexto.getTabCount() > 0) {
            for (int i = 0; i < panelTexto.getTabCount(); i++) {
                String[] extensiones2 = panelTexto.getTitleAt(i).split("\\.");
                String extension2 = extensiones2[extensiones2.length - 1];
                if (extension.equals(extension2)) {
                    System.out.println("IGUALES");
                    panelTexto.removeTabAt(i);
                    panelTexto.addTab(titulo, panel);
                    panelTexto.setTabComponentAt(i, crearCabecera(titulo, panelTexto));
                    encontrado = true;
                    break;
                }
            }
        }
        if (encontrado == false) {
            panelTexto.addTab(titulo, panel);
            panelTexto.setTabComponentAt(panelTexto.getTabCount() - 1, crearCabecera(titulo, panelTexto));
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
