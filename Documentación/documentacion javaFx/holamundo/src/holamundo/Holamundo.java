/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holamundo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.*;

/**
 *
 * @author Leocarlos 
 * primer hola mundo en javafx
 */
public class Holamundo extends Application {
    
    @Override
    public void init(){
    // este metedo es el primero en ejecutarse 
    /* 
    *es muy util a la hora de incialiaizar
    procesos
    */
    }

    @Override
    public void start(Stage objStage){
        
       
        Button boton = new Button();
        boton.setText(" mostrar");
        boton.setPrefWidth(90);
        boton.setCursor(Cursor.HAND);
         // forma de darle codigo a un boton
        boton.setOnAction( new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                
                JOptionPane.showMessageDialog(null, " Hola soy leocarlos");       
            }
        });
        
        Button boton2 = new Button("cerrar");
        boton2.setPrefWidth(90);
        boton2.setCursor(Cursor.HAND);
        boton2.setOnAction( new EventHandler<ActionEvent>(){
        
            @Override
            public void handle(ActionEvent event){
                
                Platform.exit();
            }
        });
        
        Label label = new Label("   presentacion");
        label.setPrefWidth(150);
        label.setFont(new Font(20));
        
        VBox root = new VBox();
        
        root.getChildren().add(label);
        root.getChildren().add(boton);
        root.getChildren().add(boton2);
        root.setAlignment(Pos.CENTER);
        VBox.setMargin(label, new Insets(0, 0, 10, 0));
        VBox.setMargin(boton, new Insets(0, 0, 5, 0));
        VBox.setMargin(boton2, new Insets(0, 0, 5, 0));
        // creacion de la escena
        Scene scene = new Scene(root, 300, 250);
        objStage.setTitle(" Prueba con javaFx");
        // mandamos la escene 
        objStage.setScene(scene);
        // msotramos la escena.
        objStage.show();
    }
    
    @Override
    public void stop(){
        
        /*
        este metodo se ejecuta despues de que se cierra a aplicacion
        */
       // JOptionPane.showMessageDialog(null, " Adios");
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
