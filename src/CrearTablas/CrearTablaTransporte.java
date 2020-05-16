/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CrearTablas;

import Transprte.Datos;
import static Guis.GuiTransporte.datos;
import static Guis.GuiTransporte.modeloRestricciones;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mipc
 */
public class CrearTablaTransporte {

    public CrearTablaTransporte() {
    }     
    public void crearTablaRestricciones(int destino, int  origen, JTable jtRestricciones, int des) {
        Object cabeza[] = new String[destino + 2+des];
        cabeza[0] = (" ");
        cabeza[destino+1+des] = ("Oferta");
        for (int i = 1; i <= destino+des; i++) {
            cabeza[i] = ("Destino " +i );
        }
        modeloRestricciones = new DefaultTableModel(cabeza, 0) {
            public boolean isCellEditable(int row, int column) {                
                if (column == 0 || (row == jtRestricciones.getRowCount()-1 && column== jtRestricciones.getColumnCount()-1)) {
                    return false;
                }                
                return true;
            }
        };
        jtRestricciones.setModel(modeloRestricciones);
        String fila[] = new String[destino + 2+des];
        for (int i = 0; i <origen ; i++) {
                fila[0] = new String("Origen " + (i+1));
                modeloRestricciones.addRow(fila);                
        }
        fila[0] = new String("Demanda" );
        modeloRestricciones.addRow(fila);            
        }
     public void CrearTablaSolucion(JTable jtRestriciones, JTable jtSolucion,int extraRow, int extaColumn){
         int row = jtRestriciones.getRowCount();
         int column = jtRestriciones.getColumnCount();
         extraerDatos(jtRestriciones);
         // creamos la cabecera  de la tabla
         Object cabeza[] = new String[column+extaColumn];          
         for (int i = 0;i <(column +extaColumn); i++) 
            cabeza[i] = ("<>");           
             
         // creamos el modelos de la tabla. todas sus celdas no seran editables
        DefaultTableModel modelosSolucion = new DefaultTableModel(cabeza, 0) {
           public boolean isCellEditable(int row, int column) {                   
               return false;
           }
         };
         //agregamos el modelos de la tabla
         jtSolucion.setModel(modelosSolucion);         
         /// agregramos las filas de la tabla
         String origen[];
         for (int fila = 0; fila < row+1+extraRow; fila++) {
               origen= new String[column+extaColumn];
               if(fila>0 && fila < row){
                   origen[0]=""+fila;
               }
               modelosSolucion.addRow(origen);           
         }
         for (int i = 0; i < modelosSolucion.getColumnCount(); i++) {
             jtSolucion.getColumnModel().getColumn(i).setPreferredWidth(70);
         }
         // agregamos la Oferta
         String tem;
         for (int fil = 0; fil < row-1; fil++) {
             tem = ""+modeloRestricciones.getValueAt(fil, column-1);
            modelosSolucion.setValueAt(tem, fil+1, column-1);
         }           
         //creamos Demandas
         for (int col = 1; col < column-1; col++) {
              tem = ""+modeloRestricciones.getValueAt(row-1, col);
              modelosSolucion.setValueAt(tem, modelosSolucion.getRowCount()-1-extaColumn, col);
              modelosSolucion.setValueAt(col, 0, col);
         }
         modelosSolucion.setValueAt("Demanda", row, 0);
         modelosSolucion.setValueAt("Oferta ↓", 0, column-1);
         if(extaColumn>0) modelosSolucion.setValueAt("Penaliza.", 0, column);
         if(extraRow>0)modelosSolucion.setValueAt("Penaliza.", row+1, 0);
     }
     private void  extraerDatos(JTable jtRestriciones){
         int row = jtRestriciones.getRowCount();
         int column = jtRestriciones.getColumnCount();
         datos = new Datos[row-1][column-2];
         for (int i = 0; i < row-1; i++) {
             for (int j = 0; j < column-2; j++) {                 
                  datos[i][j] = new Datos(0, ""+jtRestriciones.getValueAt(i, j+1), false);
             }
         }
     }
    
}
