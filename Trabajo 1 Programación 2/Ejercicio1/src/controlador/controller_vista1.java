/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import clases.Empleado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.MenuItem;
import clases.Lista_empleados;
import java.time.LocalDate;

import javax.swing.JOptionPane;

/**
 *
 * @author Leocarlos.
 */
public class controller_vista1 implements Initializable {
    
   Lista_empleados obj= new Lista_empleados();

    @FXML
    private TableView<Empleado> tabla;

    @FXML
    private TableColumn col_id_empleado;

    @FXML
    private TableColumn col_nombres;

    @FXML
    private TableColumn col_genero;

    @FXML
    private TableColumn col_salarioB;

    @FXML
    private TableColumn col_estrato;

    @FXML
    private TableColumn col_hora_extra;

    @FXML
    private TableColumn col_fecha_vin;

    @FXML
    private MenuItem menuitem_salir;

    @FXML
    private MenuItem menuitem_agregar;
   
    @FXML
    private MenuItem menuItem_info_empleado;

    @FXML
    private MenuItem menuItem_ord_salario;

    @FXML
    private MenuItem menuItem_ord_infoEmpleadosAZ;

    @FXML
    private MenuItem menuItem_ord_infoEmpleados_Estrato;


    @FXML
    void event_guardar(ActionEvent event) {
        
         boolean estado=false;
        do{
            for(int i=0;i<obj.lista.length;i++){

                int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empleado "+(i+1)));
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado "+(i+1));
                String genero = JOptionPane.showInputDialog("Ingrese el genero del empleado "+(i+1));
                int horas_Trab = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la horas Trabajadas del empleado "+(i+1)));
                float salario_B =Float.parseFloat(JOptionPane.showInputDialog("ingrese el salario Basico del empleado "+(i+1)));
                int estrato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el estrato del empleado "+(i+1)));
                float hrs_extra = Float.parseFloat(JOptionPane.showInputDialog("Ingrese las horas extra del empleado "+(i+1)));
                LocalDate fecha_vin = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de vinculación del empleado "+(i+1)));
                estado=obj.setAgregarEmpleado(id, nombre, genero, horas_Trab, salario_B, estrato, hrs_extra, fecha_vin, i);
            }
        }while(estado==false);
        
        obj.setLLenarTableView(tabla, col_id_empleado, col_nombres, col_genero, col_salarioB, col_estrato, col_hora_extra, col_fecha_vin);
    }
    
     @FXML
    void event_infoEmpleado(ActionEvent event) {
        
        int id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empleado a buscar"));
        obj.info_empleado(id);
    }
    
     @FXML
    void event_ord_salario(ActionEvent event) {
        
        obj.setOrd_salario_neto(0, obj.lista.length-1);
        obj.setLLenarTableView(tabla, col_id_empleado, col_nombres, col_genero, col_salarioB, col_estrato, col_hora_extra, col_fecha_vin);
    }
    
     @FXML
    void event_ord_AZ(ActionEvent event) {
        
        obj.setOrdenamiento_Alfabeticamente();
        obj.setLLenarTableView(tabla, col_id_empleado, col_nombres, col_genero, col_salarioB, col_estrato, col_hora_extra, col_fecha_vin);
    }
    
     @FXML
    void event_ord_estrato(ActionEvent event) {
        
        obj.setOrd_Estrato();
        obj.setLLenarTableView(tabla, col_id_empleado, col_nombres, col_genero, col_salarioB, col_estrato, col_hora_extra, col_fecha_vin);
    }

    @FXML
    void event_cerrar(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
