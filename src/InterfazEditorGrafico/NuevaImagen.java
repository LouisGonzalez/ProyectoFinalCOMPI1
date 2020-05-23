/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazEditorGrafico;

import OperacionEditorGrafico.LlenadoPaneles;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import pollitos.ImagenesTiempo;
import pollitos.Tiempos;

/**
 *
 * @author luisGonzalez
 */
public class NuevaImagen extends javax.swing.JDialog {

    private Tiempos misTiempos;
    private LlenadoPaneles paneles;
    private JComboBox comboImg;
    
    /**
     * Creates new form NuevaImagen
     */
    public NuevaImagen(java.awt.Frame parent, boolean modal, Tiempos misTiempos, LlenadoPaneles paneles, JComboBox comboImg) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.misTiempos = misTiempos;
        this.paneles = paneles;
        this.comboImg = comboImg;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        btnNombre = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        spnDuracion = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnNombre.setText("Crear");
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(spnDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNombre)
                    .addComponent(spnDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        if(txtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debes llenar todos los parametros.");
        } else if((Integer) spnDuracion.getValue() <= 0) {
            JOptionPane.showMessageDialog(null, "La duracion de la imagen debe ser mayor a 0");
        } else {
            ImagenesTiempo imagen = new ImagenesTiempo();
            imagen.setId(txtNombre.getText());
            imagen.setDuracion((Integer) spnDuracion.getValue());
            misTiempos.getTransiciones().add(imagen);
            paneles.llenadoPanel2(misTiempos, comboImg);
            this.dispose();
        }
    }//GEN-LAST:event_btnNombreActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNombre;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JSpinner spnDuracion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
