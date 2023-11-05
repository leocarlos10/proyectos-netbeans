/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import controlador.Vista2Controller;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class controller_vista1 implements Initializable {
    
    Stage stage;
    
    public void setStage(Stage stage){
        
        this.stage=stage;
        
    }
    
     @FXML
    private TextField text_nombre;

    @FXML
    private Button btn_guardar;

    @FXML
    void event_guardar(ActionEvent event) {
        
        try{
            // obtengo la ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vista2.fxml"));
            // cargo los componentes
            Parent root = loader.load();
            // obtengo el controlador de la ventana 2
            Vista2Controller controller = loader.getController();
            // cargo la escena
            Scene scene = new Scene(root);
            // envio de datos por el parametro init(datos a mostrar(textfield,listas,estructuras de datos),el stage(capturado),this(este controlador)))
            controller.init(text_nombre.getText(), stage, this);
            // mostramos la escena.
            this.stage.setScene(scene);
         
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
        }
       
        
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
