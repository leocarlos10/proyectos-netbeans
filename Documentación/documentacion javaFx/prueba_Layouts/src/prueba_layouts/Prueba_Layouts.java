/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba_layouts;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Leocarlos
 */
public class Prueba_Layouts extends Application {
    
    @Override
    public void start(Stage objStage){
        // creacion de los nodos
        Button b1 = new Button("boton 1");
        Button b2 = new Button("boton 2");
        Button b3 = new Button("boton 3");
        Button b4 = new Button("boton 4");
        Button b5 = new Button("boton 5");
        
        // nodo raiz en el cual van a ir todos los nodos restantes
        BorderPane root = new BorderPane();
        
        // ubica en el medio 
        root.setCenter( b1);
        // expansion de botones para que ocupe todo el espacio.
        b1.setMaxWidth(Double.MAX_VALUE);
        b1.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(b1, new Insets(5,5,5,5));
        // ubica arriba
        root.setTop(b2);
        b2.setMaxWidth(Double.MAX_VALUE);
        b2.setMaxHeight(Double.MAX_VALUE);
        // ubica abajo
        root.setBottom(b3);
        b3.setMaxWidth(Double.MAX_VALUE);
        b3.setMaxHeight(Double.MAX_VALUE);
        // ubica a la izquierda 
        root.setLeft(b4);
        b4.setMaxWidth(Double.MAX_VALUE);
        b4.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(b4, new Insets(5,0,5,0));
        // ubica a la derecha
        root.setRight(b5);
        b5.setMaxWidth(Double.MAX_VALUE);
        b5.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(b5, new Insets(5,0,5,0));
        
        Scene scene = new Scene(root, 300, 250);
        
        objStage.setTitle(" prueba de layouts");
        objStage.setScene(scene);
        objStage.show();
    }

    
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
