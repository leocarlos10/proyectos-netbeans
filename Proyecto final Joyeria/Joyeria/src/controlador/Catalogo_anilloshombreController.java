/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Catalogo_anilloshombreController implements Initializable {
    
   Stage stage;
   
   public void SetStage(Stage stage){
       this.stage=stage;
   }
     
    @FXML
    void event_volverPrincipal(MouseEvent event) {

      try{
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/principal.fxml"));
          Parent root = loader.load();
          Scene scene = new Scene(root);
          stage.setScene(scene);
          // luego devuelve el stage(la ventana raiz).
          controller_principal controller = loader.getController();
          controller.setStage(stage);
      }catch(Exception e){System.out.println("Error "+e);}
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
