/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Leocarlos
 */
public class Login extends Application {
    
    @Override
    public void start(Stage objStage){
        
        // creacion de componentes
        Label login = new Label("Login");
        login.setFont(new Font(30));
        Label user = new Label("Usuario");
        user.setFont(new Font(15));
        Label pass = new Label("Contraseña");
        pass.setFont(new Font(15));
        
        TextField textUser = new TextField();
        textUser.setMaxWidth(150);
        PasswordField textpassword = new PasswordField();
        textpassword.setMaxWidth(150);
        
        Button btnlogin = new Button("Entrar");
        btnlogin.setCursor(Cursor.HAND);
        
        // creacion del nodo raiz
        VBox root = new VBox();
        // agregamos los nodos a el nodo raiz 
        // debemos agregar los nodos en el roden que queremos que se muestren 
        root.getChildren().addAll(login,user,textUser,pass,textpassword,btnlogin);
        root.setAlignment(Pos.CENTER);
        // margenes de los nodos
        VBox.setMargin(login, new Insets(0, 0, 5, 0));
        VBox.setMargin(textUser, new Insets(10, 0, 0, 0));
        VBox.setMargin(textpassword, new Insets(10, 0, 0, 0));
        VBox.setMargin(btnlogin, new Insets(10, 0, 0, 0));
        Scene scene = new Scene(root, 500 , 400);
        objStage.setTitle(" muestra de un login");
        objStage.setScene(scene);
        objStage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
