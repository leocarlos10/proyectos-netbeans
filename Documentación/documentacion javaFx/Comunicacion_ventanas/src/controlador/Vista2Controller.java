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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 *
 * @author leocarlos
 */
public class Vista2Controller implements Initializable {
    
    private controller_vista1 controller1;
    private Stage stage;
    
    @FXML
    private Label label_name;
    
    @FXML
    private Button btn_volver;

    @FXML
    void event_volver(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vista1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            this.stage.setScene(scene); 
            
        }catch(Exception e){
            
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void init(String text, Stage stage, controller_vista1 controller_vista1) {
        label_name.setText(text);
        this.controller1=controller_vista1;
        this.stage=stage;
    }
    
}
