/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transprte;


import static Guis.GuiTransporte.datos;
import static Guis.GuiTransporte.extraColumn;
import static Guis.GuiTransporte.extraRow;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import static Guis.GuiTransporte.repetidosNumeros;

/**
 *
 * @author Mipc
 */
public class RssFeedCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer{
   
   private JLabel componet;
   
   

    public RssFeedCellRenderer() {
       
    }
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componet =   (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
         componet.setIcon(null);
          
         if(repetidosNumeros!=null && String.valueOf(table.getValueAt(row, column)).equalsIgnoreCase(repetidosNumeros)){
            componet.setBackground(new Color(252,147,147)); 
            return componet;
         }
         if((row ==0 && column < table.getColumnCount()-1-extraColumn ) ||
                 column ==0 && row < table.getRowCount()-1-extraRow){                 
                componet.setBackground(Color.GREEN);
                componet.setHorizontalAlignment(javax.swing.JTextField.CENTER );
                if(row ==0 && column==0)  componet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OD.png")));
                     componet.setFont(new java.awt.Font("Tahoma", 1, 18));
            return componet; 
            
        }
         else if(row ==table.getRowCount()-1-extraRow && column < table.getColumnCount()-1-extraColumn){
             componet.setBackground(new Color(159,237,249));
             componet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
             
//             componet.setFont(new java.awt.Font("Tahoma", 1, 18));
             return componet;
        }
         else if(column == table.getColumnCount()-1-extraColumn && row <table.getRowCount()-1){
              componet.setBackground(Color.CYAN);
              componet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
//             componet.setFont(new java.awt.Font("Tahoma", 1, 18)); 
             return componet;
        }
         else if(column == table.getColumnCount()-1-extraColumn && row== table.getRowCount()-1-extraColumn)
         {
             return componet;
         }
         if(extraColumn>0 && (column == table.getColumnCount()-1 || row== table.getRowCount()-1)){
              componet.setBackground(new Color(211,211,255));
              return componet;
         }
         if(extraRow>0 && (column == table.getColumnCount()-1 || row== table.getRowCount()-1))
             return componet;
         
         
        
        
         JPanel panel = crearpanel(row, column,table);         
        if (isSelected) {
//          panel.setBackground(Color.PINK);    
            panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,204)));
        }
        return panel;
       
  }  
  
  private JPanel crearpanel(int row, int column, JTable table){    
        
           JPanel panel = new JPanel();
           JLabel labelCantidad = new JLabel("");
           JLabel labelPrecio = new JLabel("");
        
        if(column > 0 && row > 0 && row < (table.getRowCount()-1-extraRow )&& column <(table.getColumnCount()-1-extraColumn)){
           
           
            
             labelPrecio.setText(""+datos[row-1][column-1].getPrecio());
//             
            
            panel.setLayout(null);
            panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
            
            panel.add(labelCantidad);
            panel.add(labelPrecio);
            panel.setBackground(Color.WHITE);  

            labelPrecio.setBounds(3, 3, 64, 22);
            labelCantidad.setBounds(3, 25, 64, 22);
            labelCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    //        labelCantidad.setOpaque(true);
            labelPrecio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            labelPrecio.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    //        labelPrecio.setOpaque(true);
             if(datos[row-1][column-1].getCantidad()>0){
                labelCantidad.setText(""+datos[row-1][column-1].getCantidad());
               panel.setBackground(new Color(253,137,160));
            }
            if(datos[row-1][column-1].isLleno() && datos[row-1][column-1].getCantidad()<=0 || datos[row-1][column-1].getPrecio().equals("-")){
                panel.setBackground(new Color(253,253,160));
            }
         
            
//            System.out.println(""+datos[row-1][column-1].getLabelCantidad());
      }
       
            

    
    
    return panel;
  }
}
