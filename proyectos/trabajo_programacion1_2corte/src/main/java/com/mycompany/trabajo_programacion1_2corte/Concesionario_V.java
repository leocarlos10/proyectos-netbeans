
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
        
            v[i]= new Vehiculo("","","",0,false);
        }
    }
    
    
    public Concesionario_V(JTextField tam) {    
        
        v = new Vehiculo[Integer.parseInt(tam.getText())];
        for(int i=0;i<v.length;i++){
            
            v[i]= new Vehiculo("","","",0,false);
        
        }
    }
    
    // este metodo busca si la matricula que ha ingresado el usuario esta repetida;
    int getPosmatri(String matri){ 
    
        for(int i=0;i<v.length;i++){
            
            if(v[i].matricula.equalsIgnoreCase(matri)){
                // si la encuentra returna la posicion.
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
            v[i].precio=Float.parseFloat(jtfpre.getText());
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
    
    public int getBusqueda_Bi(String matricula){
        
        int inicio=0;
        int fin=v.length-1;
        int pos;
        
        while(inicio<=fin){
            
            pos=((inicio+fin)/2);
            if(v[pos].matricula.equals(matricula)){
                
                return pos;
            } else if(v[pos].matricula.compareTo(matricula)<0){
                
                inicio=pos+1;
            } else{
                
                fin=pos-1;
            }
        }
        // si no lo encuentra returna -1
        return -1;
    }
    
    
    public void setOrdenamiento_seleccion(){
            
        int i_min;
        Vehiculo temp;
        for(int i=0;i<v.length;i++){
            i_min=i;
            // este bucle va a buscar el elemento menor lexicograficamente.
            for(int j=i+1;j<v.length;j++){ 
                /*
                 compareTO devuelve <0 si la cadena que llama al metodo es primero lexicograficamnte.
                devuleve ==0 ,entonces las cadenas son lexicograficamente equivalentes 
                devuelve >0 , entonces el parametro pasado al metodo compareTO es lexicograficamente el primero. 
                */
                if(v[j].matricula.compareTo(v[i_min].matricula)<0){
                    
                    i_min=j;
                }
            }
                // hacemos el intercambio
                // primero copio el objeto que esta en la posicion 1
                temp= new Vehiculo(
                        
                        v[i].getMatricula(),
                        v[i].getMarca(),
                        v[i].getModelo(),
                        v[i].getPrecio(),
                        v[i].getEstado()
                );
                
                // intercambio el objeto alfabeticamente menor con el objeto de la primera posicion
                v[i].setMatricula(v[i_min].getMatricula());
                v[i].setMarca(v[i_min].getMarca());
                v[i].setModelo(v[i_min].getModelo());
                v[i].setPrecio(v[i_min].getPrecio());
                v[i].setEstado(v[i_min].getEstado());
                
                // por ultimo lo que esta en temp lo agrego a i_min
                 v[i_min].setMatricula(temp.getMatricula());
                v[i_min].setMarca(temp.getMarca());
                v[i_min].setModelo(temp.getModelo());
                v[i_min].setPrecio(temp.getPrecio());
                v[i_min].setEstado(temp.getEstado());
            
        }
    }
    
    
    public void registrarFilaJTable( DefaultTableModel modelo,int posvec,int fila ){
        
        modelo.setValueAt(v[posvec].matricula, fila, 0);
        modelo.setValueAt(v[posvec].marca, fila, 1);
        modelo.setValueAt(v[posvec].modelo, fila, 2);
        modelo.setValueAt(v[posvec].precio, fila, 3);
        modelo.setValueAt(v[posvec].estado, fila, 4);
    
    }
    
    
    public void setllenarJTable(JTable tabla){
        
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
