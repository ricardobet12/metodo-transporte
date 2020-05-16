/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transprte; 

import static Guis.GuiTransporte.datos;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mipc
 */
public class EsquinaNO {
   private int EsquinaFila=0;
   private int esquinaColumna=0; 
   private double demandaTotal , ofertaTotal;    
   private int fila = datos.length;
   private int columna = datos[0].length;
   
    public EsquinaNO() {
        
    }  
    public boolean noroeste(JTable tableSolucion,  DefaultTableModel modeloSolucion){
        calcularDemandaOfretTotal(tableSolucion, 0, 0);
        if(demandaTotal == ofertaTotal){
            if(esquinaColumna < columna || EsquinaFila < fila){
                double demanda = Double.parseDouble(""+tableSolucion.getValueAt(tableSolucion.getRowCount()-1, esquinaColumna+1));
                double oferta = Double.parseDouble(""+tableSolucion.getValueAt(EsquinaFila+1, tableSolucion.getColumnCount()-1));
                if(demanda == oferta){
                    tableSolucion.setValueAt(0,tableSolucion.getRowCount()-1, esquinaColumna+1);
                    tableSolucion.setValueAt(0,EsquinaFila+1, tableSolucion.getColumnCount()-1);
                    datos[EsquinaFila][esquinaColumna].setCantidad(demanda);
                    sellarDemanda(tableSolucion);
                    sellarOferta(tableSolucion);
                    esquinaColumna++;
                    EsquinaFila++;
                }
                else if(demanda > oferta){ 
                    demanda = demanda - oferta;
                    tableSolucion.setValueAt(0,EsquinaFila+1, tableSolucion.getColumnCount()-1);
                    tableSolucion.setValueAt(demanda,tableSolucion.getRowCount()-1, esquinaColumna+1);
                    datos[EsquinaFila][esquinaColumna].setCantidad(oferta);
                    sellarOferta(tableSolucion);
                    EsquinaFila++;
                }
                else if(oferta > demanda){
                    oferta = oferta - demanda;
                    tableSolucion.setValueAt(0,tableSolucion.getRowCount()-1, esquinaColumna+1);
                    tableSolucion.setValueAt(oferta,EsquinaFila+1, tableSolucion.getColumnCount()-1);
                    datos[EsquinaFila][esquinaColumna].setCantidad(demanda);
                    sellarDemanda(tableSolucion);
                    esquinaColumna++;
                }
                return false;
            }
            else return   true;
        }        
        else{
            JOptionPane.showMessageDialog(null,"La oferta no satisface la demanda ");
            return  false;
        }
    }
    public void sellarDemanda(JTable tableSolucion){
        for (int i = 0; i < fila; i++) {
            datos[i][esquinaColumna].setLleno(true);
        }
    }
    public void sellarOferta(JTable tableSolucion){
        for (int i = 0; i < columna; i++) {
            datos[EsquinaFila][i].setLleno(true);
        }
    }    
    public void calcularDemandaOfretTotal(JTable tableSolucion, int extraf, int extraC){
        demandaTotal=0;
        ofertaTotal=0;
        try{
        for (int i = 1; i < tableSolucion.getColumnCount()-1-extraC; i++) {
            demandaTotal = demandaTotal+ Double.parseDouble(""+tableSolucion.getValueAt(tableSolucion.getRowCount()-1-extraf, i));
        }
        for (int i = 1; i < tableSolucion.getRowCount()-1-extraf; i++) {
            ofertaTotal = ofertaTotal+ Double.parseDouble(""+tableSolucion.getValueAt(i,tableSolucion.getColumnCount()-1-extraC));
        }
        tableSolucion.setValueAt(""+demandaTotal+" | "+ofertaTotal, tableSolucion.getRowCount()-1-extraf, tableSolucion.getColumnCount()-1-extraC);
        }catch(Exception r){System.out.println("Error castin Esquina noroeste calcularDemandaOfretTotal");}
  }
}
