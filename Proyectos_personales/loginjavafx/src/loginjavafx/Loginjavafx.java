/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginjavafx;


import loginjavafx.models.com.misUsuarios;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import loginjavafx.models.com.Usuario;
import loginjavafx.models.com.dao.usuarioDAO;


/**
 *
 * @author Leocarlos
 * primer crud con java terminado implementando javafx y poo 
 * ademas de implementar ficheros. para guardar los datos
 * y que no se pierdan al terminar el programa.
 * 
 * modificacion del 2/agosto/2023 
 * al fin logramos agregarle bases de datos al programa.
 * 
 * Proyecto finalizado.
 */
public class Loginjavafx extends Application {
    // creamos una variable de tipo misUsuarios para poder comunicarnos
    
     misUsuarios user = new misUsuarios();
     TextArea inf;
     usuarioDAO dao = new usuarioDAO();
     
    @Override
    public void start(Stage objStage){
        
         // abro contenedor izquierdo
        VBox containerleft = new VBox();
       
        ImageView logo;
        InputStream input;
        input = getClass().getResourceAsStream("/image/logo.jpg");
        Image imagen = new Image(input);
        logo = new ImageView(imagen);
        
        Label ingreso = new Label("Ingrese un Usuario");
        
        // abro contenedor de login
        VBox login = new VBox();
        Label labelnom = new Label("Nombre");
        labelnom.setMaxWidth(150);

        Label labeluser = new Label("Usuario");
        labeluser.setMaxWidth(150);

        Label labelpass = new Label("password");
        labelpass.setMaxWidth(150);

        TextField textnombre = new TextField();
        textnombre.setMaxWidth(150);
        textnombre.setPromptText("Ingrese el nombre");

        TextField textuser = new TextField();
        textuser.setMaxWidth(150);
        textuser.setPromptText("Ingrese el usuario");

        PasswordField password = new PasswordField();
        password.setMaxWidth(150);
        password.setPromptText("ingrese la contraseña");
        
        Button btnlogin = new Button("ingresar");
        // cambiando la anchura del boton
        btnlogin.setMaxWidth(341);
        // esto es para que cuando se ponga el cursor encima del boton el crusor cambie a una mano
        btnlogin.setCursor(Cursor.HAND);
        btnlogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

               user.setUsurio(textuser, password, textnombre);
               user.setTextA(inf);
               textnombre.setText("");
               textuser.setText("");
               password.setText("");
               textnombre.requestFocus();
               
            }
        });
        
        
        Button btnguardar = new Button("guardar usuarios");
        btnguardar.setMaxWidth(341);
        btnguardar.setCursor(Cursor.HAND);
        // creamos el evento 
        btnguardar.setOnAction((v) -> {
            boolean band=false;
            for(int i=0;i<user.lista.size();i++){
                 band = dao.agregar(user.getUser(i));
            }
            if(band!=true){
                JOptionPane.showMessageDialog(null, "Error al guardar los usuarios");
            }else{
                JOptionPane.showMessageDialog(null, "Los usuarios se guardaron correctamente");
            } 
        });
        
        // cierro contenedor de login
        login.getChildren().addAll(labelnom,textnombre,labeluser,textuser,labelpass,password,btnlogin, btnguardar);
        login.setAlignment(Pos.CENTER);
        // le damos margenes a los componentes del login.
        VBox.setMargin(labelnom, new Insets(10, 0, 0, 0));
        VBox.setMargin(login, new Insets(10, 0, 0, 0));
        VBox.setMargin(login, new Insets(10, 0, 0, 0));
        VBox.setMargin(login, new Insets(10, 0, 0, 0));
        VBox.setMargin(login, new Insets(10, 0, 0, 0));
        VBox.setMargin(login, new Insets(10, 0, 0, 0));
        VBox.setMargin(btnlogin, new Insets(10, 0, 0, 0));
        VBox.setMargin(btnguardar, new Insets(10, 0, 0, 0));
        // utilizamos este layout para agregar nodos uno debajo de otro como este ejemplo
        // cierro contenedor izquierdo.
        containerleft.getChildren().addAll(logo,ingreso,login);
        //metodo para centrar los nodos
        containerleft.setAlignment(Pos.CENTER);
        // le damos un ancho a este contenedor
        containerleft.setPrefWidth(250);
        // le damos margenes de izquierda y derecha a el contenedor de login.
        VBox.setMargin(login, new Insets(0, 60, 0, 60));
        
        
        // contenedor derecho
        VBox containerRigth = new VBox();
        
        Button limpiar = new Button("Limpiar tabla");
        limpiar.setCursor(Cursor.HAND);
        limpiar.setPrefWidth(150);
        // nuevafomra de hacer los eventos de los botones.
        limpiar.setOnAction((e)->{inf.setText("");});
        VBox.setMargin(limpiar, new Insets(10, 0, 0, 0));
        
        Button mostrarU = new Button("mostrar usuarios guardados");
        mostrarU.setCursor(Cursor.HAND);
        mostrarU.setPrefWidth(170);
        // nuevafomra de hacer los eventos de los botones.
        
        mostrarU.setOnAction((e)->{
            user.setuser(dao.listar());
            user.setTextA_DB(inf);
        });
        
        VBox.setMargin(mostrarU, new Insets(10, 0, 0, 0));
        
        Button btneliminar = new Button("Eliminar usuario");
        btneliminar.setCursor(Cursor.HAND);
        btneliminar.setPrefWidth(170);
        //evento
        
        btneliminar.setOnAction((a)->{
           
            Usuario u = user.getUser();
            dao.eliminarUser(u);
            // por ulitmo actualizamos la lista.
             user.setTextA_DB(inf);
        });
        VBox.setMargin(btneliminar, new Insets(10, 0, 0, 0));
        
        
        StackPane contenedor = new StackPane();
        Label label1 = new Label("Datos de los usuarios");
        inf = new TextArea();
        inf.setPrefWidth(300);
        inf.setPrefHeight(200);
        inf.setEditable(false);
        contenedor.getChildren().add(inf);
        containerRigth.getChildren().addAll(label1,contenedor,limpiar,mostrarU,btneliminar);
        containerRigth.setMargin(contenedor, new Insets(0, 30, 0, 30));
        containerRigth.setAlignment(Pos.CENTER);
        
        
        HBox root = new HBox();
        root.getChildren().addAll(containerleft,containerRigth);
        // esto se le agrega para que cuando el usuario amplie la pantalla los nodos tambien se amplien.
        HBox.setHgrow(containerleft,Priority.ALWAYS);
        HBox.setHgrow(containerRigth, Priority.ALWAYS);
        Scene scene = new Scene(root, 630, 440);

        objStage.setTitle("Proyecto 1");
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
