/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logica.*;

/**
 *
 * @author USUARIO
 */
public class controller_vista1 implements Initializable {

    Stage stage;
    Lista_Empleado obj = new Lista_Empleado();
    
    public void setStage(Stage stage1) {

        this.stage = stage1;
    }

    @FXML
    private TableView<nodo_Empleado> tabla;

    @FXML
    private TableColumn col_nombre;

    @FXML
    private TableColumn col_apellido;

    @FXML
    private TableColumn col_id;

    @FXML
    private TableColumn col_trab;

    @FXML
    private TableColumn col_sueldo;

    @FXML
    void event_agregar_empleado(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vista_ingreso_datos.fxml"));
            Parent root = loader.load();
            controller_IngresoD controller = loader.getController();
            Scene scene = new Scene(root);
            controller.setStage(stage);
            stage.setScene(scene);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @FXML
    void event_buscar_empleado(ActionEvent event) {
        String id = JOptionPane.showInputDialog("Ingrese el id del empleado a buscar");
        obj.getBuscarEmpleado(id);
    }

    @FXML
    void event_salir(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setllenarTableView(nodo_Empleado cab) {

        nodo_Empleado p;
        // con esto nos aseguramos de que los elementos puedan ser accedidos por los metodos de la clase lista.
        // ojo esto es importante para poder utilizar otro tipo de funciones en la clase lista_empleado
        obj.setCab(cab);
        // creamos el modelo
        ObservableList<nodo_Empleado> lista = FXCollections.observableArrayList();

        // cargamos los valores de los atributos al tableview
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_trab.setCellValueFactory(new PropertyValueFactory<>("trabajo"));
        col_sueldo.setCellValueFactory(new PropertyValueFactory<>("sueldo"));

        if (cab != null) {

            p = cab;
            while (p != null) {
                lista.add(p);
                p = p.sig;
            }

            tabla.setItems(lista);
        } else {

            JOptionPane.showMessageDialog(null, "Lista vacia, por favor agregue elemetos");
        }
    }
}
