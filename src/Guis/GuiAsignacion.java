/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Guis; 

import Asignacion.Asignacion;
import Asignacion.ColorFilasAsignacionSolucion;
import Asignacion.DatosAsignacion;
import CrearTablas.crearTablaAsignacio;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mipc
 */

public class GuiAsignacion extends javax.swing.JFrame {
int tarea= 2;
int operador=2;
Asignacion asignar = new Asignacion();
public static DatosAsignacion[][] datosAsignacio;
ColorFilasAsignacionSolucion colorCedas = new ColorFilasAsignacionSolucion();
DefaultTableModel modeloSolucion;
boolean parte1= true; 

    /**
     * Creates new form Asignacion
     */
    public GuiAsignacion() {
        initComponents();
        jtSolucion.setRowHeight(25);
        jtRestricciones.setRowHeight(25);
        jtSolucion.setDefaultRenderer(Object.class,colorCedas);
        new crearTablaAsignacio().crearTablaRestricciones(tarea, operador, jtRestricciones, 0);
        jFrame1.setBounds(this.getX()+(this.getWidth()/2)-(jFrame1.getWidth()/2), (this.getHeight()/2)-(jFrame1.getHeight()/2), jFrame1.getWidth(), jFrame1.getHeight());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRestricciones = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        info2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jspTareas = new javax.swing.JSpinner();
        jspOperadores = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtSolucion = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        jFrame1.setTitle("Coeficientes");
        jFrame1.setMinimumSize(new java.awt.Dimension(680, 610));
        jFrame1.getContentPane().setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Coeficientes del Problema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel3.setLayout(null);

        jtRestricciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtRestricciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Origen 1", null, null, null},
                {"Origen 2", null, null, null},
                {"Demanda", null, null, null}
            },
            new String [] {
                "", "Destino 1", "Destino 2", "Oferta"
            }
        ));
        jtRestricciones.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtRestricciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtRestriccionesFocusGained(evt);
            }
        });
        jtRestricciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtRestriccionesMousePressed(evt);
            }
        });
        jtRestricciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtRestriccionesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtRestricciones);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(16, 30, 610, 350);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/writing62.png"))); // NOI18N
        jButton2.setText("Terminar ");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(447, 390, 180, 40);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBox1MousePressed(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox1);
        jCheckBox1.setBounds(16, 398, 20, 31);

        info2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        info2.setOpaque(true);
        jPanel3.add(info2);
        info2.setBounds(138, 402, 290, 22);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator3);
        jSeparator3.setBounds(130, 402, 12, 20);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator4);
        jSeparator4.setBounds(432, 402, 12, 20);

        jFrame1.getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 118, 680, 450);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.setLayout(null);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(null);

        jspTareas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jspTareas.setModel(new javax.swing.SpinnerNumberModel(2, 1, 400, 1));
        jspTareas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jspTareasStateChanged(evt);
            }
        });
        jPanel5.add(jspTareas);
        jspTareas.setBounds(110, 40, 80, 28);

        jspOperadores.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jspOperadores.setModel(new javax.swing.SpinnerNumberModel(2, 2, 350, 1));
        jPanel5.add(jspOperadores);
        jspOperadores.setBounds(110, 10, 80, 28);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);
        jButton3.setBounds(210, 40, 60, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tareas");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(10, 40, 110, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Operadores");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(10, 10, 130, 30);

        jPanel8.add(jPanel5);
        jPanel5.setBounds(20, 10, 590, 80);

        jFrame1.getContentPane().add(jPanel8);
        jPanel8.setBounds(10, 10, 650, 100);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asignación");
        setResizable(false);
        getContentPane().setLayout(null);

        jtSolucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtSolucion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtSolucion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtSolucion.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jtSolucionAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(jtSolucion);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 20, 790, 450);

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pen67.png"))); // NOI18N
        jButton1.setText("Coeficientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1);
        jButton1.setBounds(20, 10, 230, 50);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play109.png"))); // NOI18N
        jButton4.setText("Resolver P a P");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton4);
        jButton4.setBounds(530, 10, 240, 50);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logotype171.png"))); // NOI18N
        jButton5.setText("Resolver");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton5);
        jButton5.setBounds(340, 10, 160, 50);

        getContentPane().add(jPanel7);
        jPanel7.setBounds(10, 480, 790, 70);

        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 560, 450, 20);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Solución"));
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Operador", "Tarea", "Costo"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 30, 240, 320);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Z = ");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 380, 30, 20);

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setText("0.0");
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField1.setOpaque(true);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(80, 374, 160, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(810, 20, 260, 450);

        jMenu1.setText("File");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jMenuItem1.setText("Inicio");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator2);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1093, 655));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jFrame1.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(asignar.getCantifadaR()==datosAsignacio.length){
            asignar.buscarSoloCeroFila(jtSolucion);
            solucion();
        }
        if(parte1){
            asignar.buscarMenorFila(jtSolucion);    
            asignar.restarMenorFila(jtSolucion);
            asignar.buscarMenorcolumna(jtSolucion); 
            asignar.restarMenorColuma(jtSolucion);
            asignar.inicirBusqueda(jtSolucion);
            parte1= false;
            
        }
        else if(!parte1) {
            quitarFilaMenorColumna();
            if(asignar.getCantifadaR()<datosAsignacio.length){         
                asignar.buscarMenorTabla(jtSolucion);
                asignar.sumarMenor(jtSolucion);
                asignar.quitarRayas();
                asignar.inicirBusqueda(jtSolucion);
            }
            else{
                mostarSolucionT();
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
            }
        } 
        
     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      while(true){
         if(asignar.getCantifadaR()==datosAsignacio.length){
            asignar.buscarSoloCeroFila(jtSolucion);
            solucion();
        }
        if(parte1){
            asignar.buscarMenorFila(jtSolucion);    
            asignar.restarMenorFila(jtSolucion);
            asignar.buscarMenorcolumna(jtSolucion); 
            asignar.restarMenorColuma(jtSolucion);
            asignar.inicirBusqueda(jtSolucion);
            parte1= false;
            
        }
        else if(!parte1) {
            quitarFilaMenorColumna();
            if(asignar.getCantifadaR()<datosAsignacio.length){         
                asignar.buscarMenorTabla(jtSolucion);
                asignar.sumarMenor(jtSolucion);
                asignar.quitarRayas();
                asignar.inicirBusqueda(jtSolucion);
            }
            else{
                mostarSolucionT();
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
                break;
            }
        } 
         
      }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jtRestriccionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtRestriccionesFocusGained

    }//GEN-LAST:event_jtRestriccionesFocusGained

    private void jtRestriccionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtRestriccionesMousePressed
        info2.setText("");
       info2.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jtRestriccionesMousePressed

    private void jtRestriccionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtRestriccionesKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '-' && c != 'E' && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_jtRestriccionesKeyTyped

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        info2.setText(" Procesando…");
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!valiodarDatos()){
            info2.setText("Datos Incorrectos...");
            info2.setBackground(new Color(255,204,204));
        }
        else if(tarea==operador){
            new crearTablaAsignacio().CrearTablaSolucion(jtRestricciones, jtSolucion); 
            asignar = new Asignacion();
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jFrame1.setVisible(false);
            modeloSolucion = (DefaultTableModel) jtSolucion.getModel();
            asignar.buscarMenorFila(jtSolucion); 
            asignar.buscarMenorcolumna(jtSolucion); 
            parte1 = true;
        }
        else{
            info2.setText("Sistema no Equilibrado...");
            info2.setBackground(new Color(255,204,204));
        }
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MousePressed
        info2.setText(" Procesando…"); // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1MousePressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jspTareasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jspTareasStateChanged
      
    }//GEN-LAST:event_jspTareasStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       tarea = Integer.parseInt(""+jspTareas.getValue());
       operador = Integer.parseInt(""+jspOperadores.getValue());
       new crearTablaAsignacio().crearTablaRestricciones(tarea, operador, jtRestricciones, 0); 
       info2.setText("");
       info2.setBackground(new Color(240,240,240));
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtSolucionAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jtSolucionAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jtSolucionAncestorAdded

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     new GuiInicio().setVisible(true);
     this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    public void quitarFilaMenorColumna(){
        int fiI = jtSolucion.getRowCount();
        int coI = jtSolucion.getColumnCount();
        for (int i = 1; i < fiI; i++) {
            jtSolucion.setValueAt(" ",i, coI-1);
        }
        for (int i = 1; i < coI; i++) {
            jtSolucion.setValueAt(" ",fiI-1, i);
        }
    }
    public void solucion(){
        for (int i = 0; i < datosAsignacio.length; i++) {
            for (int j = 0; j < datosAsignacio[i].length; j++) {
                if(datosAsignacio[i][j].isColorea()){
                    jtSolucion.setValueAt(""+datosAsignacio[i][j].getCosto(), i+1, j+1);
                }
                datosAsignacio[i][j].setDobleRayado(false);
                  datosAsignacio[i][j].setRayado(false);                
            }
        }
    }
    public void mostarSolucionT(){
        double total=0;
        Object[] cabeza = {"Perador", "Tarea","Costo"};
        DefaultTableModel mode = new DefaultTableModel(cabeza,0){
            public boolean isCellEditable(int row, int column) {
                    return false;
            }
        };
        jTable1.setModel(mode);
        String row[] = new String[3];
        for (int i = 0; i < datosAsignacio.length; i++) {
            for (int j = 0; j < datosAsignacio[0].length; j++) {
                if(datosAsignacio[i][j].isColorea()){
                    row[0]=""+(i+1);
                    row[1]=""+(j+1);
                    row[2]=datosAsignacio[i][j].getCosto();
                    mode.addRow(row);
                    total = total + Double.parseDouble(""+datosAsignacio[i][j].getCosto());
                }
            }
            
        }
        jTextField1.setText(" "+total);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiAsignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiAsignacion().setVisible(true);
            }
        });
    }
    public boolean valiodarDatos(){
        for (int i = 1; i < jtRestricciones.getRowCount(); i++) {
            for (int j = 1; j < jtRestricciones.getColumnCount(); j++) {
                try{
                    double d = Double.parseDouble(""+jtRestricciones.getValueAt(i, j));
                }catch(Exception  ex){
                    return  false;
                }
            }
            
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel info2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTextField1;
    private javax.swing.JSpinner jspOperadores;
    private javax.swing.JSpinner jspTareas;
    private javax.swing.JTable jtRestricciones;
    private javax.swing.JTable jtSolucion;
    // End of variables declaration//GEN-END:variables
}
