/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package layoutgridpane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Leocarlos
 * 
 * documentacion sobre el LayaoutGridPane.
 */
public class LayoutGridPane extends Application {
    
    private Operaciones oper;
    
    // metodos para darle dimensiones a los botones
    /*
    public void addPrefDimensionButton(Button btn,int ancho,int alto){
        
        btn.setPrefWidth(ancho);
        btn.setPrefHeight(alto);
    }
    
    // esto es para que ocupen todo el espacio de Layaout
    public void addMaxDimensionButton(Button btn){
        
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setMaxHeight(Double.MAX_VALUE);
    }
    */
    
   // metodo para la creacion de la ventana.
    @Override
    public void start(Stage objStage){
        
         GridPane gridPane = new GridPane();
         gridPane.setAlignment(Pos.CENTER);
         gridPane.setHgap(5);
         gridPane.setVgap(5);
         TextField textoperaciones = new TextField();
          
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
        
        gridPane.add(textoperaciones, 0, 0,4,1);
        
        // documentacion
        
        /*
        una manera de agregar un nodo individualmente en una fila y 
        columna especifica seria por medio de 
        setColumnIndex(nodo,colum);
        setRowIndex(node,fila);
        los metodos getRowspan y getcolspan 
        son para agregar cuantas columnas quieres que ocupe el nodo en la pantalla
        */
        // Fila 0
        // con setConstrainsts podemos hacer que el campo de texto ocupe varias celdas de una fila y columna respectiva.
        
        //Fila 1
        /*
        GridPane.setConstraints(b7,0,1);
        GridPane.setConstraints(b8,1,1);
        GridPane.setConstraints(b9,2,1);
        GridPane.setConstraints(bsuma,3,1);
        
        // Fila 2
        GridPane.setConstraints(b4,0,2);
        GridPane.setConstraints(b5,1,2);
        GridPane.setConstraints(b6,2,2);
        GridPane.setConstraints(bresta,3,2);
        //Fila 3
        GridPane.setConstraints(b1,0,3);
        GridPane.setConstraints(b2,1,3);
        GridPane.setConstraints(b3,2,3);
        GridPane.setConstraints(bmult,3,3);
        //Fila 4
        GridPane.setConstraints(b_borrar,0,4);
        GridPane.setConstraints(b0,1,4);
        GridPane.setConstraints(bigual,2,4);
        GridPane.setConstraints(bdiv,3,4);
        
        //dimensiones predefinidas y maxima NODOS HIJOS
        textoperaciones.setMaxHeight(Double.MAX_VALUE);
        textoperaciones.setMaxWidth(Double.MAX_VALUE);
        textoperaciones.setPrefHeight(35);
        
        addPrefDimensionButton(b0,55,35);
        addPrefDimensionButton(b1,55,35);
        addPrefDimensionButton(b2,55,35);
        addPrefDimensionButton(b3,55,35);
        addPrefDimensionButton(b4,55,35);
        addPrefDimensionButton(b5,55,35);
        addPrefDimensionButton(b6,55,35);
        addPrefDimensionButton(b7,55,35);
        addPrefDimensionButton(b8,55,35);
        addPrefDimensionButton(b9,55,35);
        addPrefDimensionButton(bsuma,55,35);
        addPrefDimensionButton(bresta,55,35);
        addPrefDimensionButton(bmult,55,35);
        addPrefDimensionButton(bdiv,55,35);
        addPrefDimensionButton(b_borrar,55,35);
        addPrefDimensionButton(bigual,55,35);
        
        // tomo los nodos de la col 0 y le aplico el metodo que redimensiona siempre
        GridPane.setVgrow(textoperaciones,Priority.ALWAYS);
        GridPane.setVgrow(b7,Priority.ALWAYS);
        GridPane.setVgrow(b4,Priority.ALWAYS);
        GridPane.setVgrow(b1,Priority.ALWAYS);
        GridPane.setVgrow(b_borrar,Priority.ALWAYS);
        
        GridPane.setHgrow(b7, Priority.ALWAYS);
        GridPane.setHgrow(b8, Priority.ALWAYS);
        GridPane.setHgrow(b9, Priority.ALWAYS);
        GridPane.setHgrow(bsuma, Priority.ALWAYS);
        
        // le agregamos la dimension max a los botones para expandir los nodos atraves de las celdas
        addMaxDimensionButton(b0);
        addMaxDimensionButton(b1);
        addMaxDimensionButton(b2);
        addMaxDimensionButton(b3);
        addMaxDimensionButton(b4);
        addMaxDimensionButton(b5);
        addMaxDimensionButton(b6);
        addMaxDimensionButton(b7);
        addMaxDimensionButton(b8);
        addMaxDimensionButton(b9);
        addMaxDimensionButton(bsuma);
        addMaxDimensionButton(bresta);
        addMaxDimensionButton(bmult);
        addMaxDimensionButton(bdiv);
        addMaxDimensionButton(b_borrar);
        addMaxDimensionButton(bigual);
        
        
        
        // centramos el nodo
        gridpane.setAlignment(Pos.CENTER);
        // aplicamos espacios a las celdas de manera Horizontal y vertical
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        // agregamos los nodos botones a el nodo gridpane
        gridpane.getChildren().addAll(b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,
                bsuma,bresta,bmult,bdiv,
                b_borrar,bigual,textoperaciones);
        
        // separacion para que no este tan pegado a las esquinas de las ventanas.
        StackPane.setMargin(gridpane, new Insets(10));
        // nodo raiz
        */
        oper = new Operaciones();
        // eventos 
        for (Button btn : buttons) {

            btn.setOnAction((ActionEvent e) -> {
                oper.onButtonClick(btn.getText(), textoperaciones);
            });
        }
        StackPane root = new StackPane(gridPane);
       
        //creamos la escene es decir la ventana
        Scene scene = new Scene(root,300,250);
        
        objStage.setTitle("Ejemeplo LayoutGridPane");
        // con esto hacemos que cuando ejecutemos a ventana se muestre
        objStage.setScene(scene);
        objStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
