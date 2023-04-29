
package com.mycompany.trabajo_programacion1_2corte;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leo
 */
public class Concesionario_V {
    
    Vehiculo v[];
    
    public Concesionario_V() { 
        
        v= new Vehiculo[2];
        
        for(int i=0;i<v.length;i++){
        
            v[i]= new Vehiculo("","","","",false);
        }
    }
    
    public Concesionario_V(JTextField tam) {    
        
        v = new Vehiculo[Integer.parseInt(tam.getText())];
        for(int i=0;i<v.length;i++){
            
            v[i]= new Vehiculo("","","","",false);
        
        }
    }
    // este metodo busca si la matricula que ha insgresado el usuario esta repetida;
    int getPosmatri(String matri){ 
    
        for(int i=0;i<v.length;i++){
            
            if(v[i].matricula.equalsIgnoreCase(matri)){
                
                return i;
                
            }
        }
        return -1;
    }
    // metodo encargado de agregar los datos al al vector de objetos.
    public boolean setaddinfo(     
            JTextField jtfmatri,
            JTextField jtfmarc,
            JTextField jtfmod,
            JTextField jtfpre,
            boolean est,
            int i  
    ){
        if(getPosmatri(jtfmatri.getText())!=-1){ // si el metodo retorna -1: no lo enconro /i(numero):poscision de la matricula repetida.
        
            JOptionPane.showMessageDialog(null," la matricula ya se encuentra registrada intente nuevamente");
            jtfmatri.setText("");
            jtfmatri.requestFocus();
            return false;
        } else{
            
            v[i].matricula=jtfmatri.getText();
            v[i].marca=jtfmarc.getText();
            v[i].modelo=jtfmod.getText();
            v[i].precio=jtfpre.getText();
            v[i].estado=est;
            jtfmatri.requestFocus();
            return true;
        }
    }
    
    
    public void setBusqueda_Marca(String marca){
       // con el metodo de busqueda secuencial buscamos la marca y mostramos los datos.
       boolean band=false; // hacemos uso de una bandera.
       
       int i=0,pos=0;
       while(i<v.length && band==false){
           
           if(v[i].marca.equalsIgnoreCase(marca)){
               
               band=true;
               pos=i;
           }
           i++;
       }
       
       if(band!=false){
           
           v[pos].mostrar();
       
       } else{
           
           JOptionPane.showMessageDialog(null," El vehiculo no ha sido encontrado.");
       
       }
    }
    
    
    public void registrarFilaJTable( DefaultTableModel modelo,int posvec,int fila ){
        
        modelo.setValueAt(v[posvec].matricula, fila, 0);
        modelo.setValueAt(v[posvec].marca, fila, 1);
        modelo.setValueAt(v[posvec].modelo, fila, 2);
        modelo.setValueAt(v[posvec].precio, fila, 3);
        modelo.setValueAt(v[posvec].estado, fila, 4);
    
    }
    
    
    public void llenarJTable(JTable tabla){
        
        int posvec=0;  
        int postab=0;
        
     
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("matricula");
        modelo.addColumn("marca");
        modelo.addColumn("modelo");
        modelo.addColumn("precio");
        modelo.addColumn("estado");
        
        while(posvec<v.length){
            
            modelo.addRow(new Object[]{"","","","",""});
            registrarFilaJTable(modelo,posvec,postab);
            posvec++;
            postab++;
        }
        
        tabla.setModel(modelo);
    }
}
