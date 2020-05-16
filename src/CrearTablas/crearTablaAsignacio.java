/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CrearTablas;

import Asignacion.DatosAsignacion;
import static Guis.GuiAsignacion.datosAsignacio;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mipc
 */
public class crearTablaAsignacio {
  public void crearTablaRestricciones(int tareas, int  operador, JTable jtRestricciones, int des) {
        Object cabeza[] = new String[tareas + 1+des];
        cabeza[0] = (" ");
        for (int i = 1; i <= tareas+des; i++) {
            cabeza[i] = ("Tarea " +i );
        }
       DefaultTableModel modeloRestricciones = new DefaultTableModel(cabeza, operador) {
            public boolean isCellEditable(int row, int column) {                
                if (column == 0 ) {
                    return false;
                }                
                return true;
            }
        };
        jtRestricciones.setModel(modeloRestricciones);        
        for (int i = 0; i <operador ; i++) {
           modeloRestricciones.setValueAt("Operador "+(i+1),i, 0);                               
        }
  } 
  
  public void CrearTablaSolucion(JTable jtRestriciones, JTable jtSolucion){
         int row = jtRestriciones.getRowCount();
         int column = jtRestriciones.getColumnCount();
         // creamos la cabecera  de la tabla
         Object cabeza[] = new String[column+1];          
         for (int i = 0;i <(column+1); i++) 
            cabeza[i] = ("<>");  
         // creamos el modelos de la tabla. todas sus celdas no seran editables
         DefaultTableModel modelosSolucion = new DefaultTableModel(cabeza, row+2) {
           public boolean isCellEditable(int row, int column) {                   
               return false;
           }
         };
         //agregamos el modelos de la tabla
         jtSolucion.setModel(modelosSolucion);         
         /// agregramos las filas de la tabla
         for (int fila = 1; fila < row+1; fila++) {
               modelosSolucion.setValueAt("Operador "+fila, fila, 0);
         }
         for (int col = 1; col < column; col++) {
               modelosSolucion.setValueAt("Tarea "+col, 0, col);
         }
         for (int i = 1; i < modelosSolucion.getColumnCount()-1; i++) {
             jtSolucion.getColumnModel().getColumn(i).setPreferredWidth(45);
         }
         // agregamos la Oferta                    
         
         modelosSolucion.setValueAt("Menor ↓", 0, column);
         modelosSolucion.setValueAt("Menor →", row+1, 0);
         extraerdatos(jtRestriciones, jtSolucion);         
  }
  public void extraerdatos(JTable jtRestriciones, JTable jtSolucion){
     int row = jtRestriciones.getRowCount();
     int column = jtRestriciones.getColumnCount(); 
     String tem;
      datosAsignacio = new DatosAsignacion[row][column-1];
      for (int fil = 0; fil < row; fil++) {
          for (int col = 1; col < column; col++) {
              tem = ""+jtRestriciones.getValueAt(fil, col);
              jtSolucion.setValueAt(tem, fil+1, col);
              datosAsignacio[fil][col-1] = new DatosAsignacion(tem);
              
          }
      }
  }
  
}
