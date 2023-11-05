/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package layoutshbox;
import java.io.InputStream;
import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//import javax.swing.JOptionPane;
/**
 *
 * @author Leocarlos
 * utilizamso los layouts 
 * HBox para poder colocar nodos horizontalmente 
 * y los VBox para hacer el nodo de la izq y derecha 
 * ademas de hacer el login en un contenedor aparte para mayor organizacion en la pantalla
 */
public class LayoutsHBox extends Application {
    
     @Override
    public void start(Stage objStage){
        
        // contenedor de izquerda
        VBox containerLeft = new VBox();
        // agregar los nodos hijos del contenedor de la izquierda
        // creacion de nodos
        Label titulo = new Label(" Iniciar Sesion");
        // tamaño de fuente es decir el tamaño de la letra
        titulo.setFont(new Font(40));
        
        VBox containerLogin = new VBox();
        // agregamos los nodos del login
        
        Label user = new Label(" usuario");
        user.setFont(new Font(20));
        
        Label password = new Label(" contraseña");
        password.setFont(new Font(20));
        
        TextField textUser = new TextField();
        textUser.setPrefWidth(341); 
        textUser.setPrefHeight(44);
        textUser.setFont(new Font(18));
        // esto es para msotrar un texto infomativo a los TextField
        textUser.setPromptText("Ingrese su usuario");
        
        PasswordField textpass = new PasswordField();
        // le cambiamos el tamano de anchura
        textpass.setPrefWidth(341); // predefinimos una longitud por defecto
        textpass.setPrefHeight(44); // predefinimos una longitud por defecto
        textpass.setFont(new Font(18));
        // esto es para msotrar un texto infomativo a los TextField
        textpass.setPromptText("Ingrese su contaseña");
        
        Button btnlogin = new Button("Entrar");
        btnlogin.setPrefWidth(370); 
        btnlogin.setPrefHeight(44);
        // cambiando la anchura del boton
        btnlogin.setMaxWidth(Double.MAX_VALUE); // maxvalue para que cuando ampliemos la pantalla se acomode
        // esto es para que cuando se ponga el cursor encima del boton el crusor cambie a una mano
        btnlogin.setCursor(Cursor.HAND);
        
        // evento para lso botones
        /*btnlogin.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                
            }
        });
        */
        
        // agregamos los nodos a el contenedor del login
        containerLogin.getChildren().addAll(user,textUser,password,textpass,btnlogin);
        // alineamos 
        containerLogin.setAlignment(Pos.CENTER);
        // le ponemos margenes
        VBox.setMargin(user, new Insets(10, 0, 0, 0));
        VBox.setMargin(password, new Insets(10, 0, 0, 0));
        VBox.setMargin(btnlogin, new Insets(10, 0, 0, 0));
        // agregamos el nodo login y el titulo al nodo de la izquierda
        containerLeft.getChildren().addAll(titulo,containerLogin);
        // aplicamos un tamano de anchura de 422
        containerLeft.setPrefWidth(422);
        // alineamos los nodos
        containerLeft.setAlignment(Pos.CENTER);
        // le damos un margen al contenedor
        VBox.setMargin(containerLogin, new Insets(0, 30, 0, 30));
        
        
        // contenedor de derecha
        VBox containerRigth = new VBox();
        
        // AGREGMOS IMAGEN
        ImageView imageLogo;
        
        // guardamos una imagen
        InputStream inputstream;
        // nota colocar el paquete y el nombre correcto ej logo.jpg
        // guardamos una imagen
        inputstream = getClass().getResourceAsStream("/images/logo.jpg");
        // convertir el input en image
        Image image = new Image(inputstream);
       
        imageLogo = new ImageView(image);
        // agrega la imagen en el contenedor de derecha
        containerRigth.getChildren().add(imageLogo);
        
        // ajustamos las dimensiones tamano del contenedor
        containerRigth.setPrefWidth(200);
        // alineamos los nodos
        containerRigth.setAlignment(Pos.CENTER);
        // le damos un fondo negro con codigo java tambien se puede hacer con css pero es mas adelante
        containerRigth.setBackground(new Background(new BackgroundFill(Color.web("#30373e"),CornerRadii.EMPTY,Insets.EMPTY)));
        
        // creacion del nodo raiz
        // utilizamos este layout para agregar nodos uno debajo de otro como este ejemplo
        HBox root = new HBox();
        root.getChildren().addAll(containerLeft,containerRigth);
        // redimendimendiona la ventana.
        /*
        ALWAYS redimendiona las ventas siempre
        NEVER nunca redimensiona
        SOMTIMES aveces redimensiona
        */
        HBox.setHgrow(containerLeft, Priority.ALWAYS);
        HBox.setHgrow(containerRigth, Priority.ALWAYS);
        
        Scene scene = new Scene(root,854,503);
        
        objStage.setTitle(" prueba layouts 2");
        objStage.setScene(scene);
        objStage.show();
    }
    
    public static void main(String[] args) {
       launch(args);
    }
    
}
