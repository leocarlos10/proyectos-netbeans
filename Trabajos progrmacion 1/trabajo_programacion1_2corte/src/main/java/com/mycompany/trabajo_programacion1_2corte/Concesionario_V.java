
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
        
        v= new Vehiculo[1];
        
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
        if(getPosmatri(jtfmatri.getText()) != -1){ // si el metodo retorna -1: no lo enconro /i(numero):poscision de la matricula repetida.
        
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
    
    
    public int setBusqueda_Marca(String marca){
       // con el metodo de busqueda secuencial buscamos la marca y mostramos los datos.
       for(int i=0;i<v.length;i++){
           
           if(v[i].getMarca().equalsIgnoreCase(marca))
                return i;
       }
       // si no encuentra la marca simplemente retorna -1.
       return -1;
    }
    
    // para utilizar la busqueda binaria el vector debe estar ordenado.
    public int getBusqueda_Bi(String matricula){
        
        int inicio=0;
        int fin=v.length-1;
        int pos;
        
        while(inicio <= fin){
            
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
            
        int i_min; // posible menor
        Vehiculo temp; // variable para hacer el intercambio
        for(int i= 0; i < v.length; i++){
            i_min=i;// inicializo el menor en la posición 0
            // este bucle va a buscar el elemento menor lexicograficamente.
            for(int j= i+1; j < v.length; j++){ 
                /*
                 compareTO devuelve <0 si la cadena que llama al metodo es primero lexicograficamnte.
                devuleve ==0 ,entonces las cadenas son lexicograficamente equivalentes 
                devuelve >0 , entonces el parametro pasado al metodo compareTO es lexicograficamente el primero. 
                */
                if(v[j].matricula.compareTo(v[i_min].matricula) < 0){
                    
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
    
    // ordenamiento por marca descendentemente
    public void setOrdenamiento_shell(){
            
        int salto,i;   
        Vehiculo temp;
        boolean cambio;
        
        for(salto= v.length/2 ;salto != 0; salto/=2){
            cambio=true;
            while(cambio){
                cambio=false;
                for(i= salto;i < v.length; i++){
                    
                    if(v[i-salto].getMarca().compareTo(v[i].getMarca())<0){
                        
                        temp= new Vehiculo(
                                v[i].getMatricula(),
                                v[i].getMarca(),
                                v[i].getModelo(),
                                v[i].getPrecio(),
                                v[i].getEstado()
                        );
                        
                        v[i].setMatricula(v[i-salto].getMatricula());
                        v[i].setMarca(v[i-salto].getMarca());
                        v[i].setModelo(v[i-salto].getModelo());
                        v[i].setPrecio(v[i-salto].getPrecio());
                        v[i].setEstado(v[i-salto].getEstado());
                         
                        v[i-salto].setMatricula(temp.getMatricula());
                        v[i-salto].setMarca(temp.getMarca());
                        v[i-salto].setModelo(temp.getModelo());
                        v[i-salto].setPrecio(temp.getPrecio());
                        v[i-salto].setEstado(temp.getEstado());
                        
                        cambio=true;
                     }
                } 
            }
        }
    }
    
    public void setquicksort(int inicio,int fin){
        
        if(inicio < fin){
            float pivote = v[fin].getPrecio();
            int i= inicio-1;
            for(int j= inicio; j < fin ; j++){
                if(v[j].getPrecio() > pivote){
                    i++;
                    intercambio(i,j);
                }
            }
            i++;
            intercambio(i,fin);
            setquicksort(inicio,i-1);
            setquicksort(i+1,fin);
        }
    }
    
   
    public void intercambio(int i, int j){
        
        Vehiculo temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
    
    
    public void registrarFilaJTable( DefaultTableModel modelo,int posvec,int fila ){
        // con el metodo setValue agregamos los datos en la tabla ya que la tabla es una matriz 
        // utilizamos el parametro postab para movernos entre filas 1-2-3
        
        modelo.setValueAt(v[posvec].matricula, fila, 0);
        modelo.setValueAt(v[posvec].marca, fila, 1);
        modelo.setValueAt(v[posvec].modelo, fila, 2);
        modelo.setValueAt(v[posvec].precio, fila, 3);
        modelo.setValueAt(v[posvec].estado, fila, 4);
    
    }
    
    // este metodo resive el JTable 
    
    public void setllenarJTable(JTable tabla){
        
        int posvec=0;// pos del vector para ir cargando los datos e el vector 
        int postab=0; // pos del JTable para ir cargando los datos en el JTable
        
     
        DefaultTableModel modelo = new DefaultTableModel(); // instanciamos un nuevo modelo para la tabla
        
        // agregagos las columnas que tendra la nueva tabla.
        modelo.addColumn("matricula");
        modelo.addColumn("marca");
        modelo.addColumn("modelo");
        modelo.addColumn("precio");
        modelo.addColumn("estado");
        
        // mientras la posicion del vector sea menor la tamaño sigue agregando.
        while(posvec<v.length){
            
            modelo.addRow(new Object[]{"","","","",""}); // creamos una nueva fila en el JTable para poder agregar los datos.
            // llamamos al modelo y con el metodo addRow instanciamos un nuevo objet
            // aqui llamamos a el metodo que registra los datos en la fila y le pasamos por parametro el modelo, la posicion del vector, y la pos en la tabla.
            registrarFilaJTable(modelo,posvec,postab);
            // aumentamos las posiciones en 1 para que en la proxia vuelta de bucle agregue los datos en una nueva fila 
            posvec++;
            postab++;
        }
        
        tabla.setModel(modelo);
    }
}
