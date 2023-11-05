/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Leocarlos
 */
public class Lista_Empleado {
    
    public nodo_Empleado cab;
    
    public Lista_Empleado(){cab = null;}
    
    public void setCab(nodo_Empleado cab) {
        this.cab = cab;
    }
    
    public nodo_Empleado getBuscarId(String id){
        
        nodo_Empleado p;
        if(cab==null){
            
            return null;
        }else{
            p=cab;
            while(p!=null){
                if(p.getId().equals(id))
                    return p;
                else
                    p=p.sig;
            }
            return null;
        }
    }
    
    public nodo_Empleado getCrearNodo(
            TextField text_nombre,
            TextField text_apellido,
            TextField text_id,
            TextField text_trabajo,
            TextField text_sueldo){
        
        nodo_Empleado buscar = getBuscarId(text_id.getText());
        nodo_Empleado info=null;
        
        if(buscar!=null){
            JOptionPane.showMessageDialog(null, 
                    "Id repetido, Por favor intente nuevamente", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            text_id.setText("");
            text_id.requestFocus();
        }else{
            
            try{
                // creamos el nodo.
                info = new nodo_Empleado(
                        text_nombre.getText(),
                        text_apellido.getText(),
                        text_id.getText(),
                        text_trabajo.getText(),
                        Float.parseFloat(text_sueldo.getText())
                );
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
        return info;
    }
    
    // para poder agregar el nodo en la ultima posicion de la lista necesito saber cual es el ultimo nodo de la lista.
    public nodo_Empleado getUltimo(){
        
        nodo_Empleado p;
        if(cab==null){
            
            return null;
        }else{
            
            p=cab;
            while(p.sig!=null){
                p=p.sig;
            }
            return p;
        }
    }
    
    // metedo para agregar al final de la lista
    public void agregarFinal(
            TextField text_nombre,
            TextField text_apellido,
            TextField text_id,
            TextField text_trabajo,
            TextField text_sueldo
    ){
        
        // creamos el nodo
        nodo_Empleado info = getCrearNodo(
                text_nombre, 
                text_apellido, 
                text_id, 
                text_trabajo, 
                text_sueldo);
        
        if(info!=null){
            
            if(cab== null){
                cab=info;
                JOptionPane.showMessageDialog(null, "nodo agregado al final de la lista, Lista estaba vacia");
                // limpiamos los textfield
                text_nombre.setText("");
                text_apellido.setText("");
                text_id.setText("");
                text_trabajo.setText("");
                text_sueldo.setText("");
                text_nombre.requestFocus();
            }else{
                
                nodo_Empleado ultimo = getUltimo();
                ultimo.sig =info;
                JOptionPane.showMessageDialog(null, "nodo agregado al final de la lista");
                // limpiamos los textfield
                text_nombre.setText("");
                text_apellido.setText("");
                text_id.setText("");
                text_trabajo.setText("");
                text_sueldo.setText("");
                text_nombre.requestFocus();
            }
        }
    }
    
    public void getBuscarEmpleado(String id){
        
      nodo_Empleado p=getBuscarId(id);
      if(p!=null)
          p.mostrar();
    }
    
}
