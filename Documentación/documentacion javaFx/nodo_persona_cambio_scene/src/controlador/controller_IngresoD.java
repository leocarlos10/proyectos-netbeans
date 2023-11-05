/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import logica.Lista_Empleado;
/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class controller_IngresoD implements Initializable {
    
    Stage stage;
    Lista_Empleado obj = new Lista_Empleado();
    
    public void setStage(Stage stage){
        
        this.stage=stage;
    } 
    
     @FXML
    private TextField text_nombre;

    @FXML
    private TextField text_apellido;

    @FXML
    private TextField text_id;

    @FXML
    private TextField text_trabajo;

    @FXML
    private TextField text_sueldo;

    @FXML
    void event_agregar(ActionEvent event) {
        
        obj.agregarFinal(
                text_nombre, 
                text_apellido, 
                text_id, 
                text_trabajo, 
                text_sueldo);
        
    }
    
     @FXML
    void event_saludo(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "hola");
    }

    @FXML
    void event_volver(ActionEvent event) {
        
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vista1.fxml"));
        Parent root = loader.load();
        controller_vista1 controller = loader.getController();
        Scene scene = new Scene(root);
        controller.setllenarTableView(obj.cab);
        stage.setScene(scene);
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
