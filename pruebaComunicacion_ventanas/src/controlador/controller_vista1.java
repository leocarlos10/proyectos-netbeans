/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Leocarlos
 */
public class controller_vista1 implements Initializable {
    
     Stage stage;
     
     public void setStage(Stage stage){
         
         this.stage=stage;
     }
     
    @FXML
    private Label label_info;

    @FXML
    void event_ingresar_datos(ActionEvent event) {
        
        try{
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vista2.fxml"));
        Parent root = loader.load();
        controller_vista2 controller2 = loader.getController();
        Scene scene = new Scene(root);
        // seteamos el stage
        controller2.setStage(stage);
        stage.setScene(scene);
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void init(String text){
        label_info.setText(text);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
