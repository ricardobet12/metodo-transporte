/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Asignacion;

import static Guis.GuiAsignacion.datosAsignacio;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Mipc
 */
public class ColorFilasAsignacionSolucion  extends  DefaultTableCellRenderer{
  private JLabel componete;
    int i=0;
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componete =  (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        
        if(column==0){
            componete.setBackground(new Color(255,86,86));
        }
        
        else if(row!=0 && column !=0) componete.setBackground(Color.white);
        if(row==0) componete.setBackground(new Color(102,204,255));
        if(row >0 && row<table.getRowCount()-1 && column>0 && column < table.getColumnCount()-1){
            if(datosAsignacio[row-1][column-1].isRayado()){
                componete.setBackground(new Color(253,253,178));
            }
            if(datosAsignacio[row-1][column-1].isDobleRayado()){
                componete.setBackground(Color.YELLOW);
            }
              
        }
        if(row > 0 && row < table.getRowCount()-1   && column>0 && column<table.getColumnCount()-1) {
            if(datosAsignacio[row-1][column-1].isColorea()){
               componete.setBackground(new Color(255,204,204)); 
        }
        }
        
        if(isSelected) componete.setBackground(new Color(223,211,231));   
        
      return componete;
     }

}