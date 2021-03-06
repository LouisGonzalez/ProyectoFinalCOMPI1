/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazEditorGrafico;

import OperacionEditorGrafico.CreacionObjetosLNZ;
import OperacionEditorGrafico.NuevosArchivos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pollitos.*;

/**
 *
 * @author luisGonzalez
 */
public class InterfazGrafico extends javax.swing.JDialog {

    private ArrayList<Lienzos> listLienzos;
    private ArrayList<Colores> listColores;
    private ArrayList<Tiempos> listTiempos;
    private CreacionObjetosLNZ creacion = new CreacionObjetosLNZ();
    private ArrayList<Pintados> listPintados;
    private final NuevosArchivos nuevos = new NuevosArchivos();
    
    /**
     * Creates new form InterfazGrafico
     */
    public InterfazGrafico(java.awt.Frame parent, boolean modal, ArrayList<Lienzos> listLienzos, ArrayList<Colores> listColores, ArrayList<Tiempos> listTiempos, ArrayList<Pintados> listPintados) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.listLienzos = listLienzos;
        this.listColores = listColores;
        this.listTiempos = listTiempos;
        this.listPintados = listPintados;
        creacion.crearLienzos(listLienzos, listColores, listTiempos, panelGrafico, listPintados);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGrafico = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jMenu1.setText("File");

        jMenuItem1.setText("Guardar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenu3.setText("Generar GIF");
        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       
        
        
        
        GuardarArchivos guardar = new GuardarArchivos(null, true, nuevos.creacionArchivoLNZ(listLienzos), nuevos.creacionArchivoCLRS(listColores), nuevos.creacionArchivoPNT(listPintados, listLienzos), nuevos.creacionArchivoTMP(listLienzos, listTiempos));
        guardar.setVisible(true);
        System.out.println(nuevos.creacionArchivoCLRS(listColores));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.println(nuevos.creacionArchivoPNT(listPintados, listLienzos));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.println(nuevos.creacionArchivoTMP(listLienzos, listTiempos));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(nuevos.creacionArchivoLNZ(listLienzos));
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane panelGrafico;
    // End of variables declaration//GEN-END:variables
}
