/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginjavafx;


import java.io.InputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 *
 * @author Leocarlos
 */
public class Loginjavafx extends Application {
    // creamos una variable de tipo misUsuarios para poder comunicarnos
    
    misUsuarios misuser=new misUsuarios();
    
    @Override
    public void start(Stage objStage){
        // creacion de nodos
        ImageView logo;
        InputStream input;
        input = getClass().getResourceAsStream(/i)
        Label user = new Label(" usuario");
        // tamaño de fuente es decir el tamaño de la letra
        user.setFont(new Font(15));
        Label password = new Label(" contraseña");
        password.setFont(new Font(15));

        TextField textUser = new TextField();
        textUser.setMaxWidth(150);
        PasswordField textpass = new PasswordField();
        // le cambiamos el tamano de anchura
        textpass.setMaxWidth(150);

        Button btnlogin = new Button("Entrar");
        // cambiando la anchura del boton
        btnlogin.setMaxWidth(150);
        // esto es para que cuando se ponga el cursor encima del boton el crusor cambie a una mano
        btnlogin.setCursor(Cursor.HAND);
        btnlogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                misuser.setUsurio(textUser, textpass);
                textUser.setText("");
                textpass.setText("");
                textUser.requestFocus();
            }
        });
        Button btninf = new Button("Mostrar info");
        btninf.setMaxWidth(150);
        btninf.setCursor(Cursor.HAND);
        // creamos el evento 
        btninf.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                misuser.mostrar();
            }
        });
        // creacion del nodo raiz
        // utilizamos este layout para agregar nodos uno debajo de otro como este ejemplo
        VBox root = new VBox();

        root.getChildren().addAll(, user, textUser, password, textpass, btnlogin, btninf);
        //metodo para centrar los nodos
        root.setAlignment(Pos.CENTER);
        VBox.setMargin(user, new Insets(10, 0, 0, 0));
        VBox.setMargin(password, new Insets(10, 0, 0, 0));
        VBox.setMargin(btnlogin, new Insets(10, 0, 0, 0));
        VBox.setMargin(btninf, new Insets(10, 0, 0, 0));
        Scene scene = new Scene(root, 300, 300);

        objStage.setTitle(" prueba layouts 2");
        objStage.setScene(scene);
        objStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
