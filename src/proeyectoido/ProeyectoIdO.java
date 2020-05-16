/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proeyectoido;

import Guis.GuiAsignacion;
import Guis.GuiInicio;
import Guis.GuiSimplex;
import Guis.GuiTransporte;

/**
 *
 * @author Mipc
 */
public class ProeyectoIdO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Princial1().setVisible(true); 
//                new Principal2().setVisible(true);
                  //new  GuiAsignacion().setVisible(true);
                  new GuiInicio().setVisible(true);
            }
        });
    }
    
}
