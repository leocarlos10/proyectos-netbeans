/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase_programacion;

import javax.swing.JOptionPane;

/**
 *
 * @author Leocarlos
 * clase con los metodos para el manejo de los nodos.
 */
public class Lista {
    
    Nodo cab; // la cabeza de la lista.

    Lista(){cab = null;}
    
    public Nodo getBuscarID(String cod){
        
        Nodo p;
        
        if(cab == null){
            return null;
        }
        else{
            p = cab;
            while(p!= null){
                
                if((p.id).equals(cod)){
                
                    return p;
                } else {
                    
                    p=p.sig;
                }
            }
        }
        return null;
    }
    
    // comprueba si la lista esta vacia.
    public boolean getVacia(){
        
        // si se cumple retorna true si no false
        return cab == null; 
    }
    
    // este metodo devuelve el tamaño de la lista.
    public int getLongLista(){
        
        int cont =0;
        Nodo p;
        
        if(getVacia()){
            
            return 0;
            
        } else {
            
            p=cab;
            while (p!= null){
                cont ++;
                p=p.sig;
            }
        }
        return cont;
    }
    
    // metodo que crea un nuevo nodo.
    public Nodo getCrearNodo(){
        // - Atributos necesarios para crear el nodo-
        String id, noms;
        float KmR;
        // nodos auxiliares.
        Nodo info,B;
        
        // este bucle while se va a seguir repitiendo mientras que el id este repetido
        do{
            // se pide el id
            id = JOptionPane.showInputDialog("Entre el id");
            // y se verifica que no este repetido.
            B = getBuscarID(id);
            if(B!= null)
                JOptionPane.showMessageDialog(null, "Error id ya esxiste por favor intente nuevamente");
        
        }while(B!= null);
        
        // luego va a pedir los atributos restantes
        noms = JOptionPane.showInputDialog("Entre Nombres del Atleta "); 
        KmR= Float.parseFloat(JOptionPane.showInputDialog("Entre los Kilometros"));
        // por ultimo instanciamos nuestro nodo
        info = new Nodo(id,noms,KmR);
        // retornamos el nodo
        return info;
    }
    
    // este metodo obtiene el ultimo nodo de la lista.
    public Nodo getUltimo(){
        
        if(cab==null){
            
            return null;
        } else{
            
            // creamos un nodo auxiliar
            Nodo p=cab;
            /*
            recorremos los nodos cuando el puntero del ultimo nodo sea null 
            significa que ese es el ulitimo nodo de la lista
            */
            while(p.sig!= null){
                
                // par ir avanzando en los nodos.
                p=p.sig;
            }
            return p;
        }
    }
    
    // metodo para agregar un nodo a al final de la lista.
    public void setAddF(){
        
        // creamos el nodo con la ayuda del metodo getCrearNodo(). 
        Nodo info = getCrearNodo();
        
        if(getVacia()){
            
            cab=info;
            JOptionPane.showMessageDialog(null, 
                    "Nodo creado lista estaba vacia.");
        } else{
            // en caso de que halla nodos agregados a la lista
            // debemos crear un nodo auxiliar para poder recorrer la lista.
            // el nodo aux va a obtener el ultimo nodo de la lista.
            Nodo p=getUltimo();
            //ahora debemos hacer que el puntero del ultimo nodo  apunte a info.
            p.sig=info;
            JOptionPane.showMessageDialog(null, 
                    "Nodo agregado al final de la lista..");
        }
    }
    
    // este metodo se encarga de mostrar todos los datos por pantalla.
    public void getMostrarTds(){
        
        if(cab==null){
            
            JOptionPane.showMessageDialog(null, " la lista esta vacia");
        } else {
            
            Nodo p = cab;
            while(p!=null){
                
                p.getMostrarNodo();
                p=p.sig;
            }
        }
    }
    
    // metodo para obtener el nodo anterior a otro nodo.
    // este metodo me va ayadar con el proceso de eliminacion.
    public Nodo getAntes(Nodo p){
        
        // Nodo auxiliar 
        Nodo q;
        
        if(cab==null){
            
            return null;
            
        } else {
            // si la cabeza no esta vacia a q le asignamos cab
            q=cab;
            // luego mientras que el puntero de q sea diferete al nodo pasado por parametro.
            while(q.sig != p){
                // va a avanzar hasta que llegue el penultimo nodo respecto a el parametro.
                q=q.sig;
            }
            // al salir del while retorna q ya que este contiene el nodo anterior
            //respecto al nodo del parametro
            return q;
        }
    }
    
    public void setEliminarID(String cod){
        
        // nodo auxiliar
        Nodo q;
        
        if(cab == null){
            
            JOptionPane.showMessageDialog(null, 
                    "La lista esta vacia !!");
        } else{
           // nodo que contiene el id a eliminar
            Nodo p = getBuscarID(cod);

            if (p == null) {

                JOptionPane.showMessageDialog(null, 
                        "La informacion a eliminar no existe");

            } else if ((p == cab) && (cab.sig == null)) {
                // verificamo el primer caso que es que el id se 
                //encuentra en la cabeza y en la lista solo hay 1 nodo
                // con esto eliminamos el nodo
                cab = null;
                // y mostramos un mensaje 
                JOptionPane.showMessageDialog(null,
                        "Elemento eliminado de la cabecera, "
                        + "lista quedo vacia.");
            } else if ((p == cab) && (cab.sig != null)) {

                // evaluamos el siguiente caso si p esta en cab y la lista tiene mas nodos
                // hacemos que cab se ponga en el nodo sig
                cab = cab.sig;
                // luego rompemos el puntero
                p.sig = null;
                // eliminamos el nodo
                p = null; 
                JOptionPane.showMessageDialog(null, "Eliminado al inicio");
            } else if(p.sig == null){
                
                // evaluamos cuando el nodo con el id correspondiente esta al final de la lista.
                // obtenemos el elemento anterior 
                 q = getAntes(p);
                 // eliminamos el puntero del nodo anterior
                 q.sig = null;
                // eliminamos el nodo con el id
                p=null;
                JOptionPane.showMessageDialog(null, "Eliminado al final");
            } else{
                
                // por ultimo evaluamos la opcion de que este en el medio de la lista
                // obtenemos el nodo anterior a el que vamos a eliminar
                q = getAntes(p);
                // hacemos que el nodo anterior apunte al siguiente del nodo a eliminar
                q.sig = p.sig;
                // por ultimo eliminamos el puntero y el nodo
                p.sig = null;
                p=null;
                JOptionPane.showMessageDialog(null, "Eliminado");
            }
        }
    }
}
