/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package confx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author moises
 */
public class  Confx extends Application{

    /**
     * @param args the command line arguments
     */
    @Override
    public void start(Stage stage ) throws Exception   {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml" ));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
            
    public static void main(String[] args) {
       launch(args);
    }
    
}
