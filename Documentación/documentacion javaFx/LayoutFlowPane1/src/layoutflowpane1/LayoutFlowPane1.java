/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package layoutflowpane1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Leocarlos 
 */
public class LayoutFlowPane1 extends Application {
    
    @Override
    public void start(Stage objStage){
        
        Button bn[] = new Button[15];
        
        // creamos el nodo raiz
        // este tipo de Layout se puede comparar como una matriz.
        FlowPane root = new FlowPane();
        //propiedades relevantes del flowpane
        // cambiar la orientacion del Layaout
        root.setOrientation(Orientation.VERTICAL);
        // hacer una separacion tanto como horizontal como vertical
        root.setHgap(10);
        root.setVgap(10);
        
        for(int i=0;i<bn.length;i++){
            // incializamos
            bn[i] = new Button("Boton "+i);
            // agregamos
            root.getChildren().add(bn[i]);
        }
       
        Scene scene = new Scene(root, 300, 250);
        
        objStage.setTitle("Ejemplo Flowpane");
        objStage.setScene(scene);
        objStage.show();
   
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
