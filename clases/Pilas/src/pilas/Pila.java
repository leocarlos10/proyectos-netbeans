/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;
import javax.swing.JOptionPane;
/**
 *
 * @author Leocarlos
 */
public class Pila {
    
    nodo tope;
    
    // creamos la pila vacia
    Pila(){ tope = null;}
    
    public nodo getBuscarID(String id){
        
        if(tope == null){
            return null;
        }else{
            
            nodo p=tope;
            /*
            se utiliza un do while para recorrer la pila 
            primero intenta verificar el id y luego verifica si es diferente de tope
            */
            do{
                if(p.idTiq.equals(id))
                    return p;
                else
                    p=p.sig;
            }while(p!=tope);
            
            return null;
        }
    }  
    
    // metodo que devuelve el tamano de la lista
    public int getLongLista(){
        
        int cont=0;
        nodo p=null;
         
        if(tope == null)
            return 0;
        else{
            p =tope;
            do{
                cont++;
                p=p.sig;
            }while(p!=tope);
        }
        return cont;
    }
    
    public nodo getBase(){
        
        if(tope == null){
            
            return null;
        }else{
            
            nodo p=tope;
            // va a recorrer la pila mientras que el sig sea diferente de tope, cundo p.sig = tope quiere decir que esta en la base de la pila.
            while(p.sig!=tope)
                p=p.sig;
            
            return p;
        }
    }
    
    // metodo que crea un nodo de la pila
    public nodo getCrearNodo(){
        
        String id,ciu;
        float valor;
        nodo p=null,info=null;
        
        try{
            do{
                id=JOptionPane.showInputDialog("Entre el id");
                p=getBuscarID(id);
                if(p!=null){

                    JOptionPane.showMessageDialog(null, "Id repetido, Por favor intente nuevamente");
                }
            }while(p!=null);
            
            ciu=JOptionPane.showInputDialog("Entre el id");
            valor=Float.parseFloat(JOptionPane.showInputDialog("Entre el costo del tiquete"));
            info = new nodo(id,ciu,valor);
            return info;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error"+e+"El nodo no fue creado");
            return null;
        }
    }
    
    // metodo que agrega un nodo a la pila
    public void setPush(){
        
        nodo info=getCrearNodo();
        
        if(info !=null){
            // si la lista esta vacia
            if(tope==null){
                // agrego el nodo creado al tope de la pila
               tope=info;
               // y hago que el apuntador del tope apunte a tope
               tope.sig=tope;
               JOptionPane.showMessageDialog(null, "Elemento agregado la pila, estaba vacia");
            }else{
               // si la lista tiene elemetos primero obtenemos la base
               nodo base= getBase();
               // luego hacemos enlazamos el info al tope
               info.sig=tope;
               // luego hacemos que la base apunte al nuevo tope que en este caso es info
               base.sig = info;
               // por ultimo actualizamos el tope 
               tope=info;
               JOptionPane.showMessageDialog(null, "Elemento agregado a la pila");
            }
        }else{
            
            JOptionPane.showMessageDialog(null, "Error al crear el nodo, intente nuevamente");
        }
    }
    
    public void setPop(){
        
        if(tope==null){
            
            JOptionPane.showMessageDialog(null, "La pila esta vacia");
        }else{
            
            if(tope.sig == null){
                
                tope = null;
                 JOptionPane.showMessageDialog(null, "Elemento atendido, pila quedo vacia");
            }else{
                
                nodo u=getBase();
                nodo p=tope;
                // cambiamos el tope al nodo siguiente
                tope=tope.sig;
                // hacemos que la base apunte al nuevo tope
                u.sig = tope;
                //luego hacemos que a el nodo p(nodo a eliminar) su apuntador sea null asi de desenlaza de la lista
                p.sig=null;
                // por ultimo eliminamos el nodo
                p=null;
                JOptionPane.showMessageDialog(null, "Elemento atendido");
            }
        }
    }
}
