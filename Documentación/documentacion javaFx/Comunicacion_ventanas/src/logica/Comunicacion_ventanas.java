/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package logica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controlador.controller_vista1;
/**
 *
 * @author Leocarlos
 */
public class Comunicacion_ventanas extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vista1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //esta parte es clave necesito obtener desde un principio el controlador de la vista1 para poder mandar el stage al controlador
        controller_vista1 controller = loader.getController();
        // envio del stage a el controller_vista1
        controller.setStage(stage);
        // mostramos el stage.
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
