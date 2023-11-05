/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import clases.*;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
/**
 *
 * @author Leocarlos
 */
public class controller_vista1 implements Initializable {
    
    Lista_Vehiculos obj = new Lista_Vehiculos();
    
    @FXML
    private TableView<Vehiculo> tabla;

    @FXML
    private TableColumn col_n_placa;

    @FXML
    private TableColumn col_tipo_vehiculo;

    @FXML
    private TableColumn col_fecha_hora_ingreso;

    @FXML
    private TableColumn col_fecha_hora_salida;

    @FXML
    private MenuItem menuItem_salir;

    @FXML
    private MenuItem MenuItemAgregar;
    
    @FXML
    private MenuItem menuItem_mostrar_datos;
   
    @FXML
    private MenuItem menuItem_ord_valor_pagar;

    @FXML
    private MenuItem menuItem_tiempo_estacionamiento;
    
    @FXML
    private MenuItem menuItem_ord_tipo_placa;

    @FXML
    void event_mostrar_datos(ActionEvent event) {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo");
        obj.setMostrar_datos_v_pagar(placa);
    }
    
     @FXML
    void event_ord_t_p(ActionEvent event) {
        obj.ordenamiento_tipo_placa();
        obj.setLLenarTableView(tabla, col_n_placa, col_tipo_vehiculo, col_fecha_hora_ingreso, col_fecha_hora_salida);
    }
    
       @FXML
    void event_ord_tiempo_estacionamiento(ActionEvent event) {
        
        obj.ordenamiento_tiempo_estacionamiento();
        obj.setLLenarTableView(tabla, col_n_placa, col_tipo_vehiculo, col_fecha_hora_ingreso, col_fecha_hora_salida);
    }
    
    @FXML
    void event_ord_valor_pagar(ActionEvent event) {
        
        obj.setOrdenarV_valorPagar();
        obj.setLLenarTableView(tabla, col_n_placa, col_tipo_vehiculo, col_fecha_hora_ingreso, col_fecha_hora_salida);
    }

    @FXML
    void event_Salir(ActionEvent event) {
        
        Platform.exit();
    }

    @FXML
    void event_agregar(ActionEvent event) {
       
         boolean estado=false;
        do{
            for(int i=0;i<obj.lista.length;i++){
                
                String placa = JOptionPane.showInputDialog(" Ingrese la placa del vehiculo "+(i+1));
                
                // con esto podemos mostrar un menu de opciones con JOptionPane para que le usuario pueda seleccionar el tipo de vehiculo
                String[] opciones = {Vehiculo.tipo_vehiculo.AUTOMOVIL.toString(), Vehiculo.tipo_vehiculo.MOTOCICLETA.toString(), Vehiculo.tipo_vehiculo.CAMIONETA.toString()};
                int opcion = JOptionPane.showOptionDialog(
                        null,
                        "Selecciona un tipo de vehiculo:",
                        "Vehiculo: "+(i+1),
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );

                Vehiculo.tipo_vehiculo valorSeleccionado = null;
                
                switch(opcion){
                    
                    case 0: valorSeleccionado = Vehiculo.tipo_vehiculo.AUTOMOVIL;
                    break;
                    case 1: valorSeleccionado = Vehiculo.tipo_vehiculo.MOTOCICLETA;
                    break;
                    case 2: valorSeleccionado = Vehiculo.tipo_vehiculo.CAMIONETA;
                }
                
                LocalDateTime fecha_hora_ingreso = LocalDateTime.parse(
                        JOptionPane.showInputDialog(
                                "Ingrese fecha y hora de entrada del vehiculo de la siguiente forma: yyyy-MM-ddTHH:mm:ss para el vehiculo: "+(i+1)));
                
                 LocalDateTime fecha_hora_salida = LocalDateTime.parse(
                        JOptionPane.showInputDialog(
                                "Ingrese fecha y hora de salida del vehiculo de la siguiente forma: yyyy-MM-ddTHH:mm:ss: "+(i+1)));
                 
                 if(valorSeleccionado != null)
                 estado=obj.setAgregarV(placa, valorSeleccionado.toString(), fecha_hora_ingreso, fecha_hora_salida, i);
            }
        }while(estado==false);
        
        obj.setLLenarTableView(tabla, col_n_placa, col_tipo_vehiculo, col_fecha_hora_ingreso, col_fecha_hora_salida);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    
    
}
