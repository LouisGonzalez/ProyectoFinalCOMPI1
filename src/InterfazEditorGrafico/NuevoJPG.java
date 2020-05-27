/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazEditorGrafico;

import OperacionEditorGrafico.Animaciones;
import OperacionEditorGrafico.PanelMatriz;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import pollitos.Colores;
import pollitos.Lienzos;
import pollitos.Pintados;
import pollitos.Tiempos;

/**
 *
 * @author luisGonzalez
 */
public class NuevoJPG extends javax.swing.JDialog {

    private String path;
    private JLabel panelMatriz;
    private Tiempos misTiempos;
    private Lienzos miLienzo;
    private PanelMatriz principal;
    private ArrayList<Pintados> misPintados;
    private ArrayList<Pintados> listPintados;
    private Colores misColores;
    private JCheckBox borrador;

    /**
     * Creates new form NuevoJPG
     */
    public NuevoJPG(java.awt.Frame parent, boolean modal, JLabel panelMatriz, Tiempos misTiempos, Lienzos miLienzo, PanelMatriz principal, ArrayList<Pintados> misPintados, Colores misColores, ArrayList<Pintados> listPintados, JCheckBox borrador) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.panelMatriz = panelMatriz;
        this.misTiempos = misTiempos;
        this.miLienzo = miLienzo;
        this.principal = principal;
        this.misPintados = misPintados;
        this.listPintados = listPintados;
        this.misColores = misColores;
        this.borrador = borrador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPath = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnPath = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnGuardar.setText("Guardar imagenes");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnPath.setText("Selecciona un path");
        btnPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPath, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnPath, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtPath.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para guardar las imagenes debes seleccionar un path");
        } else {
            Animaciones animacion = new Animaciones();
            animacion.crearPNG(txtPath.getText(), panelMatriz, misTiempos, miLienzo, principal, misPintados, misColores, listPintados, borrador);
            JOptionPane.showMessageDialog(null, "Imagenes creadas en la ruta indicada.");
            this.dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPathActionPerformed
        JFileChooser chooser = new JFileChooser();
        String seleccion = "Selecciona un directorio";
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle(seleccion);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
            path = chooser.getSelectedFile().toString();
            txtPath.setText(path);
        }

    }//GEN-LAST:event_btnPathActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPath;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
