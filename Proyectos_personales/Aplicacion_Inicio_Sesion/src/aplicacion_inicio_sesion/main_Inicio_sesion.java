/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion_inicio_sesion;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ConexionDAO.usuarioDAO;
/**
 *
 * @author Leocarlos
 * 
 * modificacion del 6/08/2023
 * logramos agregarle bases de datos a la aplicacion de inicio de sesion.
 */
public class main_Inicio_sesion extends Application {
    
    usuarioDAO dao;
    
    // este metodo es el encargado de realizar la conexion 
    // con la base de datos al momento de que se inicie la aplicacion;
    @Override
    public void init(){
        dao = new usuarioDAO();
        dao.conectar();
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
       Parent root = FXMLLoader.load(getClass().getResource("/view/viewlogin.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Inicio de sesion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}