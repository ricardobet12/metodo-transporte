/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Asignacion;

import static Guis.GuiAsignacion.datosAsignacio;
import javax.swing.JTable;

/**
 *
 * @author Mipc
 */
public class Asignacion {
    private int filaCerosManor;
    private int columnaCerosManor;
    private boolean ganoFila=true;
    private double Menor;
    private int cantifadaR;
    private int filaAsiganar , columnaAsignar;
    
    public Asignacion(){
        
    }
   public void inicirBusqueda(JTable tabla){  
       cantifadaR =0;
       while(faltaSintachar(tabla)){
           cantidadCeroMayor(tabla);
           tachar(tabla);
       }
       System.out.println("Canti r"+cantifadaR);
   }
   public void tachar(JTable tabla){
        int fila = datosAsignacio.length;
        int columna =datosAsignacio[0].length;
        if(ganoFila&& filaCerosManor>0){
             for (int col = 0; col < columna; col++) {
                if(datosAsignacio[filaCerosManor-1][col].isRayado()){
                    datosAsignacio[filaCerosManor-1][col].setDobleRayado(true);
                }
                else{
                   datosAsignacio[filaCerosManor-1][col].setRayado(true);
                }
            }
             cantifadaR++;
        }
        else if(columnaCerosManor>0){
            for (int fil = 0; fil < fila; fil++) {
                if(datosAsignacio[fil][columnaCerosManor-1].isRayado()){
                    datosAsignacio[fil][columnaCerosManor-1].setDobleRayado(true);
                }
                else{
                   datosAsignacio[fil][columnaCerosManor-1].setRayado(true);
                }
            }
            
          cantifadaR++;  
        }
    }
    
    public void cantidadCeroMayor(JTable tabla){
       int fila = tabla.getRowCount();
       int columna = tabla.getColumnCount();
       int cantiFil=0 , cantiCol=0, cantiTotal=0;
       double valor;
       filaCerosManor=0;
       columnaCerosManor=0;
        for (int fil = 1; fil < fila-1; fil++) {// busca por fila
            cantiFil=0;
            for (int col = 1; col < columna-1; col++) {
                valor = Double.parseDouble(""+tabla.getValueAt(fil ,col));
                if(valor==0D && !datosAsignacio[fil-1][col-1].isRayado()){                    
                    cantiFil++;
                }
            }
            if(cantiFil>cantiTotal){
                filaCerosManor=fil;
                ganoFila = true;
                cantiTotal= cantiFil;
            }
        }        
        for (int co = 1; co < columna-1; co++) {// busca por columna 
            cantiCol=0;
            for (int fil = 1; fil < fila-1; fil++) {
                valor = Double.parseDouble(""+tabla.getValueAt(fil ,co));
                if(valor==0D && !datosAsignacio[fil-1][co-1].isRayado()){                    
                    cantiCol++;
                }
            }
            if(cantiCol>cantiTotal){
                columnaCerosManor=co;
                ganoFila = false;
                cantiTotal= cantiCol;
            }
        }          
    }
    public void buscarMenorFila(JTable tabla){
        int fila = tabla.getRowCount();
        int columna = tabla.getColumnCount();
        double auxMenor , menor;
        for (int i = 1; i < fila-1; i++) {
            auxMenor = Double.MAX_VALUE;
            for (int j = 1; j < columna-1; j++) {
                menor = Double.parseDouble(""+tabla.getValueAt(i, j));
                if(menor<auxMenor){
                    auxMenor = menor;
                }
            }
            tabla.setValueAt(""+auxMenor, i, columna-1);
        }
    }
    public void buscarMenorcolumna(JTable tabla){
        int fila = tabla.getRowCount();
        int columna = tabla.getColumnCount();
        double auxMenor , menor;
        for (int col = 1; col < columna-1; col++) {
            auxMenor = Double.MAX_VALUE;
            for (int fil = 1; fil < fila-1; fil++) {
                menor = Double.parseDouble(""+tabla.getValueAt(fil, col));
                if(menor<auxMenor){
                    auxMenor = menor;
                }
            }
            tabla.setValueAt(""+auxMenor, fila-1, col);
        }
    }
    public void restarMenorFila(JTable tabla){
        int fila = tabla.getRowCount();
        int columna = tabla.getColumnCount();
        double menor, tem; 
        for (int fil = 1; fil < fila-1; fil++) {
            menor = Double.parseDouble(""+tabla.getValueAt(fil, columna-1));
            for (int col = 1; col < columna-1; col++) {
                tem = Double.parseDouble(""+tabla.getValueAt(fil, col));
                tabla.setValueAt(tem-menor, fil, col);                
            }
        }
    }
    public void restarMenorColuma(JTable tabla){
        int fila = tabla.getRowCount();
        int columna = tabla.getColumnCount();
        double menor, tem; 
        for (int col = 1; col < columna-1; col++) {
            menor = Double.parseDouble(""+tabla.getValueAt(fila-1, col));
            for (int fil = 1; fil < fila-1; fil++) {
                tem = Double.parseDouble(""+tabla.getValueAt(fil, col));
                tabla.setValueAt(tem-menor, fil, col);                
            }
        }
    }
    public boolean faltaSintachar(JTable tabla){
        int fila = tabla.getRowCount();
        int columna = tabla.getColumnCount();
        for (int fil = 1; fil < fila-1; fil++) {
            for (int col = 1; col < columna-1; col++) {
                if(!datosAsignacio[fil-1][col-1].isRayado()&& Double.parseDouble(""+tabla.getValueAt(fil ,col))== 0D){
                    return true;
                }
            }
        }
        return false;
    }
//    public boolean fin(JTable tabla){
//        int cantiLineas=0;
//        
//        int fila = datosAsignacio.length;
//        int columna =datosAsignacio[0].length;
//        boolean  todosRayados;
//        for (int fil = 0; fil < fila; fil++) {
//            todosRayados = true;
//            for (int col = 0; col < columna; col++) {
//                if(!datosAsignacio[fil][col].isRayado()){
//                  todosRayados=false;
//                  break;
//                }
//            }
//            if(todosRayados)cantiLineas++;
//        }
//        
//        for (int col = 0; col < columna; col++) {
//            todosRayados = true;
//            for (int fil = 0; fil < fila; fil++) {
//                if(!datosAsignacio[fil][col].isRayado()){
//                  todosRayados=false;
//                  break;
//                }
//            }
//            if(todosRayados)cantiLineas++;
//        }
//        System.out.println("Cantidad "+cantiLineas);
//        if(cantiLineas>=tabla.getRowCount())return true;
//        return false;
//    }
    public void quitarRayas(){
        int fila = datosAsignacio.length;
        int columna =datosAsignacio[0].length;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                datosAsignacio[i][j].setDobleRayado(false);
                datosAsignacio[i][j].setRayado(false);
            }            
        }
    }
    public void buscarMenorTabla(JTable tabla){
        Menor = Double.MAX_VALUE;
        double tem;
        int fila = tabla.getRowCount();
        int columna = tabla.getColumnCount();
        for (int fil = 1; fil < fila-1; fil++) {
            for (int col = 1; col < columna-1; col++) {
                if(!datosAsignacio[fil-1][col-1].isRayado()){
                    tem = Double.parseDouble(""+tabla.getValueAt(fil,col));
                    if(tem<Menor){
                        Menor= tem;
                    }
                }                
            }
        }
    }    
    public void sumarMenor(JTable tabla){        
        double tem;
        int fila = tabla.getRowCount();
        int columna = tabla.getColumnCount();
        for (int fil = 1; fil < fila-1; fil++) {
            for (int col = 1; col < columna-1; col++) {
                tem = Double.parseDouble(""+tabla.getValueAt(fil,col));
                if(datosAsignacio[fil-1][col-1].isDobleRayado()){                    
                    tabla.setValueAt(""+(tem+Menor), fil, col);
                } 
                else if(!datosAsignacio[fil-1][col-1].isRayado()){
                     tabla.setValueAt(""+(tem-Menor), fil, col);
                }
            }
        }        
    }

    public int getCantifadaR() {
        return cantifadaR;
    }   
   
    public void buscarSoloCeroFila(JTable tablaSolucion){
        int fila = tablaSolucion.getRowCount();
        int columna =  tablaSolucion.getColumnCount();
        int canti = 0;
        double dato ;
        for (int fi = 1; fi < fila-1; fi++) {
            canti=0;
            filaAsiganar = fi;
            for (int co = 1; co < columna-1; co++) {
                if(!datosAsignacio[fi-1][co-1].isAsignado() && !String.valueOf(tablaSolucion.getValueAt(fi, co)).equalsIgnoreCase(" ")){
                    dato = Double.parseDouble(""+tablaSolucion.getValueAt(fi, co));
                    if(dato == 0D) {
                        canti++; 
                        columnaAsignar = co;                        
                    }                  
                }
            }
            if(canti == 1){
                eliminarAlternativaFila(filaAsiganar, tablaSolucion);
                eliminarAlternativaColumna(columnaAsignar, tablaSolucion);
            }
        }
        if(!todosAsiganos())buscarSoloCeroColumna(tablaSolucion);
    }
    public void buscarSoloCeroColumna(JTable tablaSolucion){
        int fila = tablaSolucion.getRowCount();
        int columna =  tablaSolucion.getColumnCount();
        int canti = 0;
        double dato ;
        for (int c = 1; c < columna-1; c++) {
            canti=0;
            columnaAsignar = c;
            for (int f = 1; f < fila-1; f++) {
                if(!datosAsignacio[f-1][c-1].isAsignado() && !String.valueOf(tablaSolucion.getValueAt(f,c)).equalsIgnoreCase(" ")){
                    dato = Double.parseDouble(""+tablaSolucion.getValueAt(f, c));
                    if(dato == 0D) {
                        canti++; 
                       filaAsiganar = f;                        
                    }                  
                }
            }
            if(canti == 1){
                 eliminarAlternativaColumna(columnaAsignar, tablaSolucion);
                 eliminarAlternativaFila(filaAsiganar, tablaSolucion);               
            }
        }
        if(!todosAsiganos()) elegirUno(tablaSolucion);
    }
    public void eliminarAlternativaFila(int fil, JTable tablaSolucion){
       int columna =  tablaSolucion.getColumnCount();
        
        for (int c = 1; c < columna-1; c++) {
            if(c != columnaAsignar)
                tablaSolucion.setValueAt(" ", fil, c); 
            else datosAsignacio[fil-1][c-1].setColorea(true);
            datosAsignacio[fil-1][c-1].setAsignado(true);
        }
    }
    public void eliminarAlternativaColumna(int col, JTable tablaSolucion){
        int fila = tablaSolucion.getRowCount();        
        for (int f = 1; f < fila-1; f++) {
            if(f != filaAsiganar)
                tablaSolucion.setValueAt(" ", f, col); 
            else datosAsignacio[f-1][col-1].setColorea(true);
            datosAsignacio[f-1][col-1].setAsignado(true);
        }
    }
    public boolean todosAsiganos(){
       int fila = datosAsignacio.length;
       int columna =datosAsignacio[0].length; 
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if(!datosAsignacio[i][j].isAsignado()){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void elegirUno(JTable tablaSolucion){
        int fila = tablaSolucion.getRowCount();
        int columna =  tablaSolucion.getColumnCount();
        double dato;
        for (int i = 1; i < fila-1; i++) {
            for (int j = 1; j < columna-1; j++) {
                if(!datosAsignacio[i-1][j-1].isAsignado() && !String.valueOf(tablaSolucion.getValueAt(i,j)).equalsIgnoreCase(" ")){
                    dato = Double.parseDouble(""+tablaSolucion.getValueAt(i, j));
                    if(dato == 0D) {
                        filaAsiganar = i;
                        columnaAsignar = j;
                        eliminarAlternativaFila(filaAsiganar, tablaSolucion);
                        eliminarAlternativaColumna(columnaAsignar, tablaSolucion);
                        buscarSoloCeroFila(tablaSolucion);
                        return;
                    }                  
                }
            }
        }
        
    }
}
