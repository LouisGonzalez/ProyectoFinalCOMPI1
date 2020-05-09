/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazEditorTexto;

import OperacionesEditorTexto.VerificadorPaginas;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author luisGonzalez
 */
public class NuevoArchivo extends javax.swing.JDialog {

    private JTabbedPane panelTexto;
    private final VerificadorPaginas verificador = new VerificadorPaginas();

    /**
     * Creates new form NuevoArchivo
     */
    public NuevoArchivo(java.awt.Frame parent, boolean modal, JTabbedPane panelTexto) {
        super(parent, modal);
        initComponents();
        this.panelTexto = panelTexto;
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDirectorio = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDirectorio = new javax.swing.JTextField();
        comboExtension = new javax.swing.JComboBox<>();
        lblExtension = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnDirectorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDirectorio.setText("Directorio:");

        lblNombre.setText("Nombre:");

        txtDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirectorioActionPerformed(evt);
            }
        });

        comboExtension.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".pnt", ".tmp", ".clrs", ".lnz" }));

        lblExtension.setText("Extension");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnDirectorio.setText("...");
        btnDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirectorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDirectorio, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDirectorio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDirectorio)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDirectorio)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblExtension))
                    .addComponent(btnGuardar))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirectorioActionPerformed
        JFileChooser chooser = new JFileChooser();
        String path = "";
        String seleccion = "Selecciona el directorio del archivo";
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle(seleccion);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
            path = chooser.getSelectedFile().toString();
            txtDirectorio.setText(path);
        }
    }//GEN-LAST:event_btnDirectorioActionPerformed

    private void txtDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirectorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirectorioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtDirectorio.getText().equals("") || txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan parametros por llenar");
        } else {
            String nombreArchivo = txtDirectorio.getText() + "/" + txtNombre.getText() + comboExtension.getSelectedItem();
            File archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Ya existe un archivo con este nombre, intenta cambiarlo");
            } else {
                try {
                    archivo.createNewFile();
                    PanelTexto panel;
                    String[] aux = new String[4];
                    try {
                        panel = new PanelTexto(aux, nombreArchivo);
                        verificador.verificarExtensiones(panelTexto, txtNombre.getText() + comboExtension.getSelectedItem(), panel);
                    } catch (Exception ex) {
                        Logger.getLogger(NuevoArchivo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(NuevoArchivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDirectorio;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboExtension;
    private javax.swing.JLabel lblDirectorio;
    private javax.swing.JLabel lblExtension;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtDirectorio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}