/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package metodos;
/**
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
 * @author Leocarlos
 * 
 * obs los tres primeros metodos que hay que hacer son 
 * -el metodo que busca un codigo en la lista - este nos ayudaria a no guardar empleados con 
 * codigos repetidos 
 * - el metodo crear nodo - metodo encargado de instanciar el nodo para posteriormente agregarlo a la lista.
 * 
 * - el metodo getUltimo - este metodo es primordial para el agregar ya que para agregar al final debemos saber
 * cual es el nodo ubicado al final de la lista.
 * 
 * - metodo setagregar al inicio o al final - metodos encargados de agregar nodos en los extremos de la lista.
 * 
 
public class Lista_Empleado {
    
    // cabeza del nodo.
    nodo cab;
    
    // inicializamos la cabeza en null;
    public Lista_Empleado(){ cab = null; }
    
    // metodo encargado de buscar codigos repetidos
    public nodo getBucarCod(String codi){
        
        if(cab == null){
            return null;
        }else{   
           nodo p=cab;
            // con un bucle while empezamos a recorrer la lista
            while(p!=null){
                // si es igual
                if((p.getCod()).equals( codi)){
                    // retorna el nodo
                    return p;
                }else{
                    // dlc avanza en la lista
                    p=p.sig;
                }
            } 
            // si al salir del bucle while no lo encontro retorna null
            return null;
        }
    }
    
    // metodo encargado de crear los nodos.
    
    public nodo getCrearNodo(
            TextField textcod,
            TextField textnoms,
            TextField textNHorasT,
            TextField textVHoraT,
            TextField textNHorasE
    ){
        // lo primero que hago es verificar que el empleado no tenga codigo repetido
        nodo buscar = getBucarCod(textcod.getText());
        nodo info= null;
        try{
            
            if(buscar!=null){
                JOptionPane.showMessageDialog(null,
                        "Error: Este codigo ya se encuentra "
                                + "registrado. Por favor Reemplazar codigo");
                textcod.setText("");
                textcod.requestFocus();
                return null;
            } else{
                
                // por el contrario instanciamos el nodo
                 info = new nodo(textcod.getText(),
                        textnoms.getText(),
                        Double.parseDouble(textNHorasT.getText()),
                        Double.parseDouble(textVHoraT.getText()),
                        Double.parseDouble(textNHorasE.getText()));
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
            return null;
        } 
        
        // para luego retornarlo.
        return info;
    }
    
    public nodo getUltimo(){
        
        if(cab == null){
            
            return null;
        }else{
            
            // nodo auxiliar para recorrer la lista
            nodo p=cab;
            // ahora con un while recorro la lista buscando el nodo el cual su apuntador sea = null
            // ya que ese sera el ultimo
            while(p.sig!=null){ // mientras el puntero no sea nulo no se rompe
                
                //mientres no se cumpla va a seguir avanznado en la lista
                p=p.sig;
            }
            return p;
        }
    }
    
    public void setAgregarIncio(
             TextField textcod,
            TextField textnoms,
            TextField textNHorasT,
            TextField textVHoraT,
            TextField textNHorasE
    ){
        
         nodo info = getCrearNodo(
               textcod,
               textnoms,
               textNHorasT,
               textVHoraT,
               textNHorasE);
         
         if(info != null){
             
             if(cab == null){
                 
                 cab = info;
                 JOptionPane.showConfirmDialog(null, "Elemento agregado, Lista estaba vacia");
             }else{
                 
                 info.sig=cab;
                 cab=info;
             }
         }
        
    }
    
   public void setAgregarFinal(
            TextField textcod,
            TextField textnoms,
            TextField textNHorasT,
            TextField textVHoraT,
            TextField textNHorasE
   ){
       
       // para agregar primero creamos el nodo nota aqui solo es pasar los Textfield ya que en el crear nodo es que se instancia.
       nodo info = getCrearNodo(
               textcod,
               textnoms,
               textNHorasT,
               textVHoraT,
               textNHorasE);
       
       // verificamos si el nodo info se creo correctamente
       if(info !=null){
           // verificamos si el nodo a agregar va a ser el primero es decir cab == null
           if(cab == null){
               
               cab = info;
               JOptionPane.showMessageDialog(null, " Elemento agregado, Lista estaba vacia");
           } else{
               
               // dlc es decir la lista contiene elementos buscamos el ultimo de la lista
               nodo ultimo = getUltimo();
               // hacemos que apunte a info
               ultimo.sig = info;
               JOptionPane.showMessageDialog(null, "Elemento agregado al final de la lista.");
           }
       }else{
           
           JOptionPane.showMessageDialog(null, 
                   "El nodo no pudo ser creado correctamente. Por favor intente nuevamente",
                   "ERROR",
                   JOptionPane.ERROR_MESSAGE);
       }
   }
   
   // metodo para sabar si la lista se encuentra vacia.
   public boolean getVacia(){
       
       /*
       si la condicion se cumple retorna true, si la condicion no se cumple retorna false.
       
       return cab ==null;
   }
   
   // metodo que retorna el tamaño de la lista
   public int getLongList(){
       
       int cont =0;
       nodo p=null;
       
       if(cab == null){
           return 0;
       } else{
           
           p=cab;
           while(p!=null){
               // primero cuenta 
               cont++;
               // luego avanza
               p=p.sig;
           }
           return cont;
       }
   }
   
   // metodo encargado de agregar los nodos a la tableview
   public void setllenarTableview( TableView tabla,
            TableColumn col_codigo,
            TableColumn col_nombres,
            TableColumn col_hrs_Trab,
            TableColumn col_valor_horaTrab,
            TableColumn col_hora_extra){
       
       nodo p =null;
       //creamos la lista modelo.
       ObservableList lista =  FXCollections.observableArrayList();
       // creamos las columnas
       col_codigo.setCellValueFactory(new PropertyValueFactory("cod"));
       col_nombres.setCellValueFactory(new PropertyValueFactory("noms"));
       col_hrs_Trab.setCellValueFactory(new PropertyValueFactory("nHorasT"));
       col_valor_horaTrab.setCellValueFactory(new PropertyValueFactory("valorHora"));
       col_hora_extra.setCellValueFactory(new PropertyValueFactory("nHorasE"));

        
        // recorremos la lista de nodos para ir agregandolos al modelo(ObservableList lista =  FXCollections.observableArrayList();)

            p=cab;
            while(p!=null){
                
                lista.add(p);
                p=p.sig;
            }
            // agregamos el modelo a la tabla.
            tabla.setItems(lista);
        
   }
   
   public void setEliminar(String cod){
       
       
   
   }
}
*/