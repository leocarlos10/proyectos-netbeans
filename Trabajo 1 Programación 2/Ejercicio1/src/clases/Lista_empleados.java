/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Lista_empleados {
    
    
     public Empleado[] lista;
  
   public Lista_empleados(){
        
        int tam=Integer.parseInt(JOptionPane.showInputDialog("Cuantos empleados desea ingresar ?"));
        
        lista = new Empleado[tam];
        
        // creo la lista vacia
        for(int i=0;i<tam;i++){
            lista[i] = new Empleado(0,"","",0,0,0,0,null);
        }
    }
    
    public int getBuscarCod(int cod){
        
       
        for(Empleado i:lista){
            
            if(i.getId_empleado()==cod){
                
                return i.getId_empleado();
            }
        }
        return -1;
    }
    
    public boolean setAgregarEmpleado(
            int id,
            String nombre,
            String genero,
            int horas_Trab,
            float salario_B,
            int estrato,
            float hrs_extra,
            LocalDate text_fecha_vin,
            int i
    ){
        boolean band=false;
        if(getBuscarCod(id) != -1){
            
            JOptionPane.showMessageDialog(null, "ERROR id repetido, Por favor intente nuevamente.","ERROR",JOptionPane.ERROR_MESSAGE);
            
        }else{
            try{
                
                lista[i] = new Empleado(
                        id,
                        nombre,
                        genero,
                        horas_Trab,
                        salario_B,
                        estrato,
                        hrs_extra,
                        text_fecha_vin);
                band=true;
               
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(null, "Error"+e,"Error",JOptionPane.ERROR_MESSAGE);
                band=false;
            }
        }
        return band;
    }
    
    // metodo encargado de llenar los datos en el tableview
    public void setLLenarTableView(
            TableView tabla,
            TableColumn col_id_empleado,
            TableColumn col_nombres,
            TableColumn col_genero,
            TableColumn col_salarioB,
            TableColumn col_estrato,
            TableColumn col_hora_extra,
            TableColumn col_fecha_vin) {

        // creamos el modelo 
        ObservableList<Empleado> modelo = FXCollections.observableArrayList();

        // creamos las columnas con sus respectivos atributos.
        col_id_empleado.setCellValueFactory(new PropertyValueFactory<>("id_empleado"));
        col_nombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        col_salarioB.setCellValueFactory(new PropertyValueFactory<>("salario_B"));
        col_estrato.setCellValueFactory(new PropertyValueFactory<>("estrato"));
        col_hora_extra.setCellValueFactory(new PropertyValueFactory<>("horasExtra"));
        col_fecha_vin.setCellValueFactory(new PropertyValueFactory<>("fecha_vin"));

        for (Empleado i : lista) {

            modelo.add(i);
        }
        tabla.setItems(modelo);
    }
    
    // busca el id de un empleado y muestra su información
    public void info_empleado(int id){
        
        for(Empleado i:lista){
            
            if(i.getId_empleado()==id){
                
                JOptionPane.showMessageDialog(null, i.getNeto_Pagar(),"Informacion empleado",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void setOrd_salario_neto(int inicio, int fin) {
        if (inicio < fin) {
            float pivote = lista[fin].getSalario_B();
            int i = inicio - 1;
            for (int j = inicio; j < fin; j++) {
                if (lista[j].getSalario_B() > pivote) {
                    i++;
                    swap(i, j);
                }
            }
            i++;
            swap(i, fin);
            setOrd_salario_neto(inicio, i - 1);
            setOrd_salario_neto(i + 1, fin);
        }
    }
    
    //Método de intercambio para QuickSort
    public void swap(int i, int j) {
        Empleado temp = lista[i];
        lista[i] = lista[j];
        lista[j] = temp;
    }
    
    
     public void setOrdenamiento_Alfabeticamente(){
            
        int i_min;
        Empleado temp;
        for(int i= 0; i < lista.length; i++){
            i_min=i;
            // este bucle va a buscar el elemento menor lexicograficamente.
            for(int j= i+1; j < lista.length; j++){ 
                /*
                 compareTO devuelve <0 si la cadena que llama al metodo es primero lexicograficamnte.
                devuleve ==0 ,entonces las cadenas son lexicograficamente equivalentes 
                devuelve >0 , entonces el parametro pasado al metodo compareTO es lexicograficamente el primero. 
                */
                if(lista[j].getNombre().compareTo(lista[i_min].getNombre()) < 0){
                    
                    i_min=j;
                }
            }
            temp = lista[i];
            lista[i] = lista[i_min];
            lista[i_min] = temp;
        }
    }
     
      public void setOrd_Estrato(){
            
        int salto,i;   
        Empleado temp;
        boolean cambio;
        
        for(salto= lista.length/2 ;salto != 0; salto/=2){
            cambio=true;
            while(cambio){
                cambio=false;
                for(i= salto;i < lista.length; i++){
                    
                    if(lista[i-salto].getEstrato() > lista[i].getEstrato()){
                        
                        temp= lista[i];
                        lista[i]=lista[i-salto];
                        lista[i-salto]=temp;
                        cambio=true;
                     }
                } 
            }
        }
    }
}
