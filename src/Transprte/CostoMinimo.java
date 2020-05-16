/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transprte;

import static Guis.GuiTransporte.datos;
import javax.swing.JTable;


/**
 *
 * @author Usuario
 */
public class CostoMinimo {
  private int fila = datos.length;
  private int columna = datos[0].length;
  private int filaMenor;
  private int columnaMenor;
 
    
    public boolean costoMinimo(JTable tableSolucion){
        busquedaCostoMenor();
        if(filaMenor>=0 && columnaMenor>=0){
             double demanda = Double.parseDouble(""+tableSolucion.getValueAt(tableSolucion.getRowCount()-1, columnaMenor+1));
             double oferta = Double.parseDouble(""+tableSolucion.getValueAt(filaMenor+1, tableSolucion.getColumnCount()-1));
             if(demanda==oferta){          
                   tableSolucion.setValueAt(0,tableSolucion.getRowCount()-1, columnaMenor+1);
                   tableSolucion.setValueAt(0,filaMenor+1, tableSolucion.getColumnCount()-1);
                   datos[filaMenor][columnaMenor].setCantidad(demanda);          
                   sellarOferta();
                   sellarDemanda();
             }
             else if(demanda > oferta){ 
                    demanda = demanda - oferta;
                    tableSolucion.setValueAt(0,filaMenor+1, tableSolucion.getColumnCount()-1);
                    tableSolucion.setValueAt(demanda,tableSolucion.getRowCount()-1, columnaMenor+1);
                    datos[filaMenor][columnaMenor].setCantidad(oferta);
                    sellarOferta();    
              }            
              else if(oferta > demanda){
                    oferta = oferta - demanda;
                    tableSolucion.setValueAt(0,tableSolucion.getRowCount()-1, columnaMenor+1);
                    tableSolucion.setValueAt(oferta,filaMenor+1, tableSolucion.getColumnCount()-1);
                    datos[filaMenor][columnaMenor].setCantidad(demanda);
                    sellarDemanda();
              }
              return false;
        }            
        else return true;
    }    
    
    public void sellarDemanda(){
        for (int i = 0; i < fila; i++) {
            datos[i][columnaMenor].setLleno(true);
        }
    }
    public void sellarOferta(){
        for (int i = 0; i < columna; i++) {
            datos[filaMenor][i].setLleno(true);
        }
    }  
    
    public void busquedaCostoMenor(){
        filaMenor=-1;
        columnaMenor =-1;
        double precio,temporal = Double.MAX_VALUE;        
        for (int i = 0; i <fila; i++) {            
            for (int j = 0; j <columna; j++) {
                 if(!datos[i][j].getPrecio().equals("-")){
                     precio=Double.parseDouble(datos[i][j].getPrecio());               
                     if(temporal>precio && !datos[i][j].isLleno()){
                         filaMenor=i;
                         columnaMenor=j;
                         temporal=precio;
                     }
                 }
            }
        
        }
        
    }   
//    public double menor(){
//        for (int i = 0; i < fila; i++) {
//            for (int j = 0; j < columna; j++) {
//                if(!datos[i][j].isLleno() && !datos[i][j].getPrecio().equals("-") ){
//                    filaMenor=i;
//                    columnaMenor=j;
//                    return Double.parseDouble(datos[i][j].getPrecio());
//                    
//                }
//            }
//        }
//      return -1.0D;
//    }    
      
}
