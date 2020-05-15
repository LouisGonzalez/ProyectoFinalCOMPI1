/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazEditorTexto;

import InterfazEditorGrafico.InterfazGrafico;
import OperacionesEditorTexto.Guardado;
import OperacionesEditorTexto.VerificadorPaginas;
import gramaticaCLRS.AnalizadorLexico;
import gramaticaCLRS.SintaxCLRS;
import gramaticaLNZ.AnalizadorLexico2;
import gramaticaLNZ.SintaxLNZ;
import gramaticaPNT.AnalizadorLexico3;
import gramaticaPNT.SintaxPNT;
import gramaticaTMP.AnalizadorLexico4;
import gramaticaTMP.SintaxTMP;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import pollitos.Colores;
import pollitos.Lienzos;
import pollitos.Tiempos;

/**
 *
 * @author luisGonzalez
 */
public class InterfazTexto extends javax.swing.JFrame {

    private final VerificadorPaginas verificador = new VerificadorPaginas();
    private final Guardado guardado = new Guardado();
    public static String[] textos = new String[4];
    private String[] paths = new String[4];
    private ArrayList<Lienzos> listLienzos;
    private ArrayList<Colores> listColores;
    private ArrayList<Tiempos> listTiempos;

    /**
     * Creates new form InterfazTexto
     */
    public InterfazTexto() {
        initComponents();
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

        panelTexto = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtErrores = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        archivoNuevo = new javax.swing.JMenuItem();
        archivoAbrir = new javax.swing.JMenuItem();
        archivoGuardar = new javax.swing.JMenuItem();
        archivoSalir = new javax.swing.JMenuItem();
        opcAnalizar = new javax.swing.JMenu();
        btnAnalizador = new javax.swing.JMenuItem();
        menuGenerar = new javax.swing.JMenu();
        btnGrafico = new javax.swing.JMenuItem();
        btnGenerar = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtErrores.setColumns(20);
        txtErrores.setRows(5);
        jScrollPane1.setViewportView(txtErrores);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        menuArchivo.setText("Archivo");

        archivoNuevo.setText("Nuevo");
        archivoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoNuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(archivoNuevo);

        archivoAbrir.setText("Abrir");
        archivoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(archivoAbrir);

        archivoGuardar.setText("Guardar");
        archivoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(archivoGuardar);

        archivoSalir.setText("Salir");
        archivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(archivoSalir);

        jMenuBar1.add(menuArchivo);

        opcAnalizar.setText("Analisis");

        btnAnalizador.setText("Analizar archivos");
        btnAnalizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizadorActionPerformed(evt);
            }
        });
        opcAnalizar.add(btnAnalizador);

        jMenuBar1.add(opcAnalizar);

        menuGenerar.setText("Generar");

        btnGrafico.setText("Editor grafico");
        btnGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficoActionPerformed(evt);
            }
        });
        menuGenerar.add(btnGrafico);

        btnGenerar.setText("Generar");
        menuGenerar.add(btnGenerar);

        jMenuBar1.add(menuGenerar);

        menuAyuda.setText("Ayuda");
        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addComponent(panelTexto))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void archivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoSalirActionPerformed
        JOptionPane.showMessageDialog(null, "Vuelva pronto");
        this.dispose();
    }//GEN-LAST:event_archivoSalirActionPerformed

    private void archivoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoAbrirActionPerformed
        File archivo;
        JFileChooser chooser = new JFileChooser();
        String path = "";
        String seleccion = "Porfavor seleccione el archivo";
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle(seleccion);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
            archivo = new File(chooser.getSelectedFile().getAbsolutePath());
            path = chooser.getSelectedFile().toString();
            limpiarTexto(path, textos);
            limpiarTexto(path, paths);
            asignacionPaths(path);
            if (archivo.toString().endsWith(".lnz") || archivo.toString().endsWith(".clrs") || archivo.toString().endsWith(".tmp") || archivo.toString().endsWith(".pnt")) {
                String texto = new String();
                FileReader reader = null;
                BufferedReader buffer = null;
                try {
                    reader = new FileReader(archivo.toString());
                    buffer = new BufferedReader(reader);
                    while (buffer.ready()) {
                        if (path.endsWith(".clrs")) {
                            textos[0] += buffer.readLine() + "\n";
                        } else if (path.endsWith(".lnz")) {
                            textos[1] += buffer.readLine() + "\n";
                        } else if (path.endsWith(".tmp")) {
                            textos[2] += buffer.readLine() + "\n";
                        } else if (path.endsWith(".pnt")) {
                            textos[3] += buffer.readLine() + "\n";
                        }

                    }
                    abrirPanel(archivo.getName(), textos, path);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(InterfazTexto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(InterfazTexto.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Archivo no compatible.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hubo ninguna seleccion");
        }

    }//GEN-LAST:event_archivoAbrirActionPerformed

    private void archivoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoNuevoActionPerformed
        NuevoArchivo nuevo = new NuevoArchivo(this, false, panelTexto);
        nuevo.setVisible(true);

    }//GEN-LAST:event_archivoNuevoActionPerformed

    private void archivoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoGuardarActionPerformed
        JOptionPane.showMessageDialog(null, "hola");
        for (int i = 0; i < paths.length; i++) {
            if (paths[i] != null) {
                if (!paths[i].equals("")) {
                    guardado.guardarArchivo(textos[i], paths[i]);
                }
            }
        }
    }//GEN-LAST:event_archivoGuardarActionPerformed

    private void btnGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficoActionPerformed
      InterfazGrafico grafico = new InterfazGrafico(null, true, listLienzos, listColores, listTiempos);
        grafico.setVisible(true);
    }//GEN-LAST:event_btnGraficoActionPerformed

    private void btnAnalizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizadorActionPerformed
        listLienzos = new ArrayList<>();
        listColores = new ArrayList<>();
        listTiempos = new ArrayList<>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i] != null) {
                if (!paths[i].equals("")) {
                    if (paths[i].endsWith(".pnt")) {
                        AnalizadorLexico3 lexer3 = new AnalizadorLexico3(new StringReader(textos[i]));
                        try {
                            new SintaxPNT(lexer3).parse();
                        } catch (Exception ex) {
                            
                            Logger.getLogger(PanelTexto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (paths[i].endsWith(".clrs")) {
                        AnalizadorLexico lexer = new AnalizadorLexico(new StringReader(textos[i]));
                        try {
                            new SintaxCLRS(lexer, listColores).parse();
                        } catch (Exception ex) {
                            System.out.println(".CLRS");
                            Logger.getLogger(PanelTexto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (paths[i].endsWith(".lnz")) {
                        AnalizadorLexico2 lexer2 = new AnalizadorLexico2(new StringReader(textos[i]));
                        try {
                            new SintaxLNZ(lexer2, listLienzos).parse();
                        } catch (Exception ex) {
                            System.out.println(".LNZ");
                            Logger.getLogger(PanelTexto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (paths[i].endsWith(".tmp")) {
                        AnalizadorLexico4 lexer4 = new AnalizadorLexico4(new StringReader(textos[i]));
                        try {
                            new SintaxTMP(lexer4, listTiempos).parse();
                        } catch (Exception ex) {
                            System.out.println(".TMP");
                            Logger.getLogger(PanelTexto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_btnAnalizadorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void abrirPanel(String titulo, String[] texto, String path) {
        PanelTexto panel;
        try {
            panel = new PanelTexto(texto, path);
            verificador.verificarExtensiones(panelTexto, titulo, panel);
        } catch (Exception ex) {
            Logger.getLogger(InterfazTexto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limpiarTexto(String path, String[] textos) {
        if (path.endsWith(".clrs")) {
            textos[0] = "";
        } else if (path.endsWith(".lnz")) {
            textos[1] = "";
        } else if (path.endsWith(".tmp")) {
            textos[2] = "";
        } else if (path.endsWith(".pnt")) {
            textos[3] = "";
        }
    }

    private void asignacionPaths(String path) {
        if (path.endsWith(".clrs")) {
            paths[0] = path;
        } else if (path.endsWith(".lnz")) {
            paths[1] = path;
        } else if (path.endsWith(".tmp")) {
            paths[2] = path;
        } else if (path.endsWith(".pnt")) {
            paths[3] = path;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem archivoAbrir;
    private javax.swing.JMenuItem archivoGuardar;
    private javax.swing.JMenuItem archivoNuevo;
    private javax.swing.JMenuItem archivoSalir;
    private javax.swing.JMenuItem btnAnalizador;
    private javax.swing.JMenuItem btnGenerar;
    private javax.swing.JMenuItem btnGrafico;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuGenerar;
    private javax.swing.JMenu opcAnalizar;
    private javax.swing.JTabbedPane panelTexto;
    private javax.swing.JTextArea txtErrores;
    // End of variables declaration//GEN-END:variables
}
