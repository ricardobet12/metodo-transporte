/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transprte;

import static Guis.GuiTransporte.datos;
import static Guis.GuiTransporte.corte;
import static Guis.GuiTransporte.jDialog1;
import static Guis.GuiTransporte.repetidosNumeros;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Mipc
 */
public class Vogel {    
    private int fila = datos.length;
    private int columna = datos[0].length;
    private int filaMenor1, filaMenor2;// lleva las posiciones de 2 menores de las row 
    private int columnMenor1, columnMenor2;// lleva las posiciones de 2 menores de las column
    private double tem;
    private double mayor;
    private double menor; 
    private boolean buscarPorColumna; 
    private int filaMayor;//
    private int columnaMayor; 
    private ArrayList<String> repetidos ;
    private int filMenor;
    private int colMenor;
    
    
    public Vogel() {
    }
    public void setFilaMayor(int filaMayor) {
        this.filaMayor = filaMayor;
    }

    public void setColumnaMayor(int columnaMayor) {
        this.columnaMayor = columnaMayor;
    }
    public void setBuscarPorColumna(boolean buscarPorColumna) {
        this.buscarPorColumna = buscarPorColumna;
    }

    public int getFilaMayor() {
        return filaMayor;
    }

    public int getColumnaMayor() {
        return columnaMayor;
    }
    
    public boolean calcularVogel(JTable tableSolucion){
        calcularmenoresColumnas(tableSolucion);
        calcularSumaMenoresFilas(tableSolucion);
        buscarMayorFilaColumna(tableSolucion);        
        if(filaMayor >= 0 && columnaMayor >= 0){
            buscarCostoMenor();
            if(!hayRepetidos(tableSolucion)){
                agr(tableSolucion);
            }
            else if(ultimo()) agr(tableSolucion);
            else{
                jDialog1.setVisible(true);
            } 
            return false;
        }
         return true;
    }
    public void buscarCostoMenor(){        
        menor =  Double.MAX_VALUE;
        double aux;
        if(buscarPorColumna){
            for (int i = 0; i < fila; i++) {
                // if(S!="-")
                 if(!datos[i][columnaMayor-1].getPrecio().equals("-")){
                     aux = Double.parseDouble(datos[i][columnaMayor-1].getPrecio());
                     if(aux < menor && !datos[i][columnaMayor-1].isLleno() ) {
                         menor = aux;
                         colMenor = columnaMayor-1;
                         filMenor = i;
                    }
                 }
             }   
         }
         else if(!buscarPorColumna){
              for (int i = 0; i < columna; i++) {
                    if(!datos[filaMayor-1][i].getPrecio().equals("-")){
                          aux = Double.parseDouble(datos[filaMayor-1][i].getPrecio());
                          if(aux < menor && !datos[filaMayor-1][i].isLleno()){
                              menor = aux;
                              colMenor = i;
                              filMenor = filaMayor-1;
                          }
                    }
              } 
        }
   }
    public void agr(JTable tableSolucion){
            double demanda = Double.parseDouble(""+tableSolucion.getValueAt(tableSolucion.getRowCount()-2, colMenor+1));
            double oferta = Double.parseDouble(""+tableSolucion.getValueAt(filMenor+1, tableSolucion.getColumnCount()-2));
            if(demanda==oferta){          
                   tableSolucion.setValueAt(0,tableSolucion.getRowCount()-2, colMenor+1);
                   tableSolucion.setValueAt(0,filMenor+1, tableSolucion.getColumnCount()-2);
                   datos[filMenor][colMenor].setCantidad(demanda);          
                   sellarOferta();
                   sellarDemanda();
             }
             else if(demanda > oferta){ 
                    demanda = demanda - oferta;
                    tableSolucion.setValueAt(0,filMenor+1, tableSolucion.getColumnCount()-2);
                    tableSolucion.setValueAt(demanda,tableSolucion.getRowCount()-2, colMenor+1);
                    datos[filMenor][colMenor].setCantidad(oferta);   
                    sellarOferta();    
              }            
              else if(oferta > demanda){
                    oferta = oferta - demanda;
                    tableSolucion.setValueAt(0,tableSolucion.getRowCount()-2, colMenor+1);
                    tableSolucion.setValueAt(oferta,filMenor+1, tableSolucion.getColumnCount()-2);
                    datos[filMenor][colMenor].setCantidad(demanda);   
                    sellarDemanda();
              }

    }
   public void buscarMayorFilaColumna(JTable t){
       filaMayor = -1;
       columnaMayor = -1;
       mayor = Double.MIN_VALUE*-1;
       repetidos = new ArrayList<>();
       int fi = t.getRowCount();
       int co = t.getColumnCount();
       for (int i = 1; i < fi-2; i++) {
             if(!String.valueOf(t.getValueAt(i, co-1)).equals("-")){                  
                  double  auxMenor = Double.parseDouble(""+t.getValueAt(i, co-1));                  
                  if(auxMenor>mayor){
                       mayor = auxMenor;
                       filaMayor = i;
                       columnaMayor = co-1;
                       buscarPorColumna = false;
                  }                 
             }
       }
       for (int i = 1; i < co-2; i++) {
             if(!String.valueOf(t.getValueAt(fi-1, i)).equals("-")){                  
                  double  auxMayor = Double.parseDouble(""+t.getValueAt(fi-1, i));                  
                  if(auxMayor > mayor){
                       mayor = auxMayor;
                       filaMayor = fi-1;
                       columnaMayor = i;
                       buscarPorColumna = true;
                 }
             }
        }      
    }
   public boolean hayRepetidos(JTable t){       
       repetidos = new ArrayList<>();
       int fi = t.getRowCount();
       int co = t.getColumnCount();
       for (int i = 1; i < fi-2; i++) {
             if(!String.valueOf(t.getValueAt(i, co-1)).equals("-")){                  
                  String  auxMenor = ""+t.getValueAt(i, co-1);
                  if(auxMenor.equalsIgnoreCase(""+t.getValueAt(filaMayor, columnaMayor))){
                      repetidos.add(auxMenor);
                  }
             }
       }
       for (int i = 1; i < co-2; i++) {
             if(!String.valueOf(t.getValueAt(fi-1, i)).equals("-")){                  
                 String  auxMenor =""+t.getValueAt(fi-1, i);
                   if(auxMenor.equalsIgnoreCase(""+t.getValueAt(filaMayor, columnaMayor))){
                      repetidos.add(auxMenor);
                  }
             }
        }
       if(repetidos.size()>1) { 
           repetidosNumeros = repetidos.get(0);
           corte= true;
           return true;
       }
       
       else{
           repetidosNumeros = null;
           return false;
       }
       
   }
    public void calcularSumaMenoresFilas(JTable t){
         for (int fil = 0; fil <fila; fil++) {         
               columnMenor1 = calcularPrimerMenorFila(fil);
               if(columnMenor1<0) t.setValueAt("-", fil+1, t.getColumnCount()-1);
               else{
                   columnMenor2 =calcularSegundoMenorDelaFila(fil);
                   if(columnMenor2>=0) t.setValueAt(Math.abs(Double.parseDouble(datos[fil][columnMenor1].getPrecio())-Double.parseDouble(datos[fil][columnMenor2].getPrecio())), fil+1, t.getColumnCount()-1);
                   else t.setValueAt(datos[fil][columnMenor1].getPrecio(), fil+1, t.getColumnCount()-1);
               }
         }
     }
     public void calcularmenoresColumnas(JTable t){
         for (int column = 0; column <columna; column++) {
                 filaMenor1 = calcularPrimerMenorColumn(column);
                 if(filaMenor1<0) t.setValueAt("-",t.getRowCount()-1, column+1);
                 else{
                     filaMenor2 =calularSegundoMenorColumn(column);
    //                 System.out.println("f "+filaMenor1+"  "+filaMenor2);
    //                 System.out.println("can "+datos[filaMenor1][column].getPrecio());
    //                 System.out.println(""+datos[filaMenor2][column].getPrecio());
                     if(filaMenor2>=0) t.setValueAt(Math.abs(Double.parseDouble(datos[filaMenor1][column].getPrecio())-Double.parseDouble(datos[filaMenor2][column].getPrecio())), t.getRowCount()-1, column+1);
                     else t.setValueAt(datos[filaMenor1][column].getPrecio(), t.getRowCount()-1, column+1);
                 }
         }
     }
     public int calularSegundoMenorColumn(int col){
         double tem = 0;
         int pos = -1;
         for(int i = 0; i < fila; i++) {
             if(i!=filaMenor1){
                    if(!datos[i][col].isLleno() && !datos[i][col].getPrecio().equals("-")){
                          pos = i;
                          tem = Double.parseDouble(datos[i][col].getPrecio());
                    } 
             }
         }
         if(pos<0) return  -1;
         double tem2 = 0;
         for (int i = 0; i < fila; i++){ 
             if(i!=filaMenor1){
                    if(!datos[i][col].isLleno() && !datos[i][col].getPrecio().equals("-") && i!=pos){
                       tem2 = Double.parseDouble(datos[i][col].getPrecio());
                       if(tem>tem2){
                          pos = i;
                          tem = tem2;
                       }
                    } 
              }
         }
       return pos;
    }
    public int calcularPrimerMenorColumn(int col){
         int pos =- 1;
         for (int i = 0; i < fila; i++) {
            if(!datos[i][col].isLleno() && !datos[i][col].getPrecio().equals("-")){
                  pos = i;
                  tem = Double.parseDouble(datos[i][col].getPrecio());;
            } 
         }
         if(pos < 0) return -1;
         double tem2 = 0;
         for (int i = 0; i < fila; i++) {
             if(!datos[i][col].isLleno() && !datos[i][col].getPrecio().equals("-") && i!=pos){
                  tem2 = Double.parseDouble(datos[i][col].getPrecio());
                  if(tem > tem2){
                      pos = i;
                      tem = tem2;
                  }
             } 
         }
         return pos;
 }
  public int calcularSegundoMenorDelaFila(int fil){
     double tem = 0;
     int pos = -1;
     for(int i = 0; i < columna; i++) {
           if(i != columnMenor1){
                if(!datos[fil][i].isLleno() && !datos[fil][i].getPrecio().equals("-")){
                      pos = i;
                      tem = Double.parseDouble(datos[fil][i].getPrecio());
                } 
          }
     }
     if(pos<0) return  -1;
         double tem2 = 0;
         for (int i = 0; i < columna; i++){ 
             if(i!=columnMenor1){
                    if(!datos[fil][i].isLleno() && !datos[fil][i].getPrecio().equals("-") && i!=pos){
                       tem2 = Double.parseDouble(datos[fil][i].getPrecio());
                       if(tem>tem2){
                          pos = i;
                          tem = tem2;
                       }
                   } 
             }
         }
     return pos;         
 }
 
 public int calcularPrimerMenorFila(int fil){    
     int pos =- 1;
     for (int i = 0; i < columna; i++) {
        if(!datos[fil][i].isLleno() && !datos[fil][i].getPrecio().equals("-")){
              pos = i;
              tem = Double.parseDouble(datos[fil][i].getPrecio());;
        } 
     }
     if(pos < 0) return -1;
     double tem2 = 0;
     for (int i = 0; i < columna; i++) {
        if(!datos[fil][i].isLleno() && !datos[fil][i].getPrecio().equals("-") && i!=pos){
              tem2 = Double.parseDouble(datos[fil][i].getPrecio());
              if(tem>tem2){
                  pos = i;
                  tem = tem2;
              }
        } 
     }
     return pos;     
 }
 
 public void sellarDemanda(){
        for (int i = 0; i < fila; i++) {
            datos[i][colMenor].setLleno(true);
        }
 }
 public void sellarOferta(){
        for (int i = 0; i < columna; i++) {
            datos[filMenor][i].setLleno(true);
        }
    }
 public boolean existe(int fila, int col, JTable t){
     String g = ""+t.getValueAt(fila, col);
     for (int i = 0; i < repetidos.size(); i++) {
        if(repetidos.get(i).equalsIgnoreCase(g)) {
            return true;
        }
     }
    return false;
 }
 
 public boolean ultimo(){// consulta si es el ultima fila para evitar que pida decidir por donde analizar
     int canti = 0;
     for (int i = 0; i < fila; i++) {
         for (int j = 0; j < columna; j++) {
             if(!datos[i][j].isLleno()){ 
                if(canti++>1){
                    return false;
                }
             }
         }         
     }    
     repetidosNumeros = null;
     return true;
  }
}
