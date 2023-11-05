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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class controller_vista2 implements Initializable {
    
     Stage stage;
     
     public void setStage(Stage stage){
         
         this.stage=stage;
     }
     
    @FXML
    private TextField text_nombre;

    @FXML
    void event_guardar(ActionEvent event) {
        try{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vista1.fxml"));
         Parent root = loader.load();
         // primero obtengo el controlador y despues creo la escena
         controller_vista1 controller = loader.getController();
         Scene scene = new Scene(root);
         // luego mando los datos con la ayuda del controller
         controller.init(text_nombre.getText());
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
