/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package proyectocalculadora;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
se puede mejorar pero por el momento la voy a dejar asi 
la siguiente que haga va hacer para calcular incertidumbres.
por el momento proyecto finalizado.
*/


public class ProyectoCalculadora extends Application {
    // Atributos
    private TextField display;
    private Operaciones oper;
   
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        
        // Crear el campo de texto para el display
        display = new TextField();
        display.setEditable(false);
        display.setPrefWidth(150);
        
        // Agregar los botones a la calculadora
        Button [] buttons = {
                new Button("7"), new Button("8"), new Button("9"),new Button("/"),
                new Button("4"), new Button("5"), new Button("6"), new Button("*"),
                new Button("1"), new Button("2"), new Button("3"), new Button("-"),
                new Button("0"),new Button("c") ,new Button("="), new Button("+")
        };

        int row = 0;
        int col = 0;
        for (Button buttonLabel : buttons) {
         
            buttonLabel.setPrefHeight(35);
            buttonLabel.setPrefWidth(55);
            buttonLabel.setMaxHeight(Double.MAX_VALUE);
            buttonLabel.setMaxWidth(Double.MAX_VALUE);
            gridPane.add(buttonLabel, col, row+1);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }
        
         // Agregar el display a la primera fila del GridPane
        gridPane.add(display, 0, 0, 4, 1); 
        
        // control de eventos.
        oper = new Operaciones();
        for(Button btn: buttons){
            
            btn.setOnAction((ActionEvent e) -> {
               oper.onButtonClick(btn.getText(),display);
            });
        }
        
        
        StackPane root = new StackPane(gridPane);
        StackPane.setMargin(root,new Insets(10));
        // Crear la escena y mostrarla
        Scene scene = new Scene(root,300,250);
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
           
    
           
        
    



