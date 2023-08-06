/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class controller3 implements Initializable {
    
    controller1 obj;
    
    @FXML
    private Button btnvolver;
    
    @FXML
    private void eventoVolver(ActionEvent event){
        obj = new controller1();
        obj.loadStage("/view/viewlogin.fxml", event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      btnvolver.setCursor(Cursor.HAND);
    }
    
    /*
    private void loadStage(String url, Event event) {
        try{
            
            // obtenemos el evento, para luego obtener la scene y la ventana anterior
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
           
            
        }catch(IOException e){
            
            JOptionPane.showMessageDialog(null, e,"Error al cambiar de scene",
                    JOptionPane.ERROR_MESSAGE);
            
        }
     }
*/
}
