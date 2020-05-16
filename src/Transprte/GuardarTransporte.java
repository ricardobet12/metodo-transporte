/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transprte;

import Persistencia.EscribirLeer;
import java.io.File;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Mipc
 */
public class GuardarTransporte  implements Serializable {
    public String[][] coefeciente;
    public String metodo;
    boolean artificialFila; 
    boolean artificialCol;

    public GuardarTransporte(String metodo, boolean artificialFila, boolean artificialCol) {
        this.metodo = metodo;
        this.artificialFila = artificialFila;
        this.artificialCol = artificialCol;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public boolean isArtificialFila() {
        return artificialFila;
    }

    public void setArtificialFila(boolean artificialFila) {
        this.artificialFila = artificialFila;
    }

    public boolean isArtificialCol() {
        return artificialCol;
    }

    public void setArtificialCol(boolean artificialCol) {
        this.artificialCol = artificialCol;
    }
    
    
    public void strarDatosTabla(JTable table){
        int fila= table.getRowCount();
        int columna = table.getColumnCount();        
        coefeciente = new String[fila][columna];        
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                coefeciente[i][j] =""+ table.getValueAt(i,j);
            }
        }
    }
    public void guardarArchivo(String ruta, String nom, GuardarTransporte g) {
        int op = 0;
        if (!ruta.substring(ruta.length() - 4, ruta.length()).equalsIgnoreCase(".tpt")) {
            ruta = ruta + ".tpt";
        }
        File f = new File(ruta);
        if (f.exists()) {
            op = JOptionPane.showConfirmDialog(null, nom + " Ya existe \n¿Desea reemplazarlo?","Guardar",JOptionPane.WARNING_MESSAGE);
        }
        if (op == 0) {
            EscribirLeer archivo = new EscribirLeer();
            archivo.escribirFichero(ruta, g);
           
        }

    }
}
