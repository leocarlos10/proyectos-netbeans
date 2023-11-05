/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Leocarlos
 */
public class Lista_Vehiculos {
    
    public Vehiculo lista[];
  
    public Lista_Vehiculos(){
        
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Cuantos vehiculos desea ingresar ?"));
        
        lista = new Vehiculo[tam];
        // incializamos la lista 
        for(int i=0;i<lista.length;i++){
            
            lista[i]= new Vehiculo("",null,null,null);
        }
    }
    
    
    public int getBuscarPlaca(String p){
        
        for(int i=0;i<lista.length;i++){
            
            if(lista[i].getN_placa().equals(p))
                return i;
        }
        
        return -1;
    }
    
    
    public boolean setAgregarV(
            String placa,
            String tipo,
            LocalDateTime fecha_hora_ingreso,
            LocalDateTime fecha_hora_salida,
            int i
    ){
        boolean band=false;
        
        if(getBuscarPlaca(placa) != -1){
            
            JOptionPane.showMessageDialog(null, " Placa repetida por favor ingrese nuevamenete","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            try{
            lista[i]= new Vehiculo(placa,tipo,fecha_hora_ingreso,fecha_hora_salida);
            band=true;
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(null, "ERROR"+e);
                band=false;
            }
        }
        return band;
    }
    
    public void setLLenarTableView(
            TableView tabla,
            TableColumn  col_n_placa,
            TableColumn  col_tipo_vehiculo,
            TableColumn  col_fecha_hora_ingreso,
            TableColumn  col_fecha_hora_salida
    ) {

        // creamos el modelo 
        ObservableList<Vehiculo> modelo = FXCollections.observableArrayList();

        // creamos las columnas con sus respectivos atributos.
        col_n_placa.setCellValueFactory(new PropertyValueFactory<>("n_placa"));
        col_tipo_vehiculo.setCellValueFactory(new PropertyValueFactory<>("t_vehiculo"));
        col_fecha_hora_ingreso.setCellValueFactory(new PropertyValueFactory<>("fecha_hora_ingreso"));
        col_fecha_hora_salida.setCellValueFactory(new PropertyValueFactory<>("fecha_hora_salida"));

        for (Vehiculo i:lista) {

            modelo.add(i);
        }
        tabla.setItems(modelo);
    }
    
    public void setMostrar_datos_v_pagar(String n_P){
        
        for(int i=0;i<lista.length;i++){
            if(lista[i].getN_placa().equals(n_P)){
                
                lista[i].setMostrar_datos(lista[i]);
            }
        }
    }
    
    // ordenamiento burbuja
     public void setOrdenarV_valorPagar(){
        
         int i, j;
        Vehiculo temp = new Vehiculo("","",null,null);
        for (i = 0; i <=(lista.length-1); i++) {
            for (j = 0; j <= (lista.length - i)-2; j++) {
                if (lista[j].getValor_pagar(lista[j]) > lista[i + 1].getValor_pagar(lista[j + 1])) {
                    // si el el valor a pagar del vehiculo en el ue voy
                    // es mayor al vehiculo siguiente
                    // realizo el cambio.
                    temp = lista[j + 1];
                    lista[j + 1] = lista[j];
                    lista[j] = temp;

                }
            }
        }
    }
     
     // ordenamiento por inserccion
     public void ordenamiento_tiempo_estacionamiento(){
         
         int pos=0;
         Vehiculo aux= new Vehiculo("","",null,null);
         
         for(int i=0;i<lista.length;i++){
             
             pos=i;
             aux=lista[i];
             
             while((pos>0) && (lista[pos-1].getTiempo_estacionamiento(aux)>lista[pos].getTiempo_estacionamiento(aux))){
                 
                 lista[pos]=lista[pos-1];
                 pos--;
             }
             
             lista[pos]=aux;
         }
     }
     
     // con este metodo ordenamos las ascendentemente las placas
     public void ordenamiento_tipo_placa(){
         

         Vehiculo temp = new Vehiculo("", "", null, null);

         for (int i = 0; i < (lista.length - 1); i++) {
             int minIndex = i;

             for (int j = i + 1; j < lista.length; j++) {
                 
                 // ordenamos la lista respecto a las placas
                 if (lista[j].getN_placa().compareTo(lista[minIndex].getN_placa()) > 0) {
                     minIndex = j;
                 }
             }

            temp=lista[i];
            lista[i]=lista[minIndex];
            lista[minIndex]=temp;
            
         }
     }
}
