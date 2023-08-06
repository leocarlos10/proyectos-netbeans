/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Leocarlos.
 */
public class controller1 implements Initializable {
    
    misUsuarios users;
    
    @FXML
    private TextField textuser;
    
    @FXML 
    private PasswordField password;
    
    @FXML 
    private Button btningresar;
    
    // verificacion de campos de texto.
    @FXML
    private void eventKey(KeyEvent event){
        
        Object ev = event.getSource();
        
        if(ev.equals(textuser)){
            
            if(event.getCharacter().equals(" ")){
                
                event.consume();
            }
            
        }else if(ev.equals(password)){
            
            if(event.getCharacter().equals(" ")){
                
                event.consume();
            }
        }
    }
    
    // evento del boton ingresar.
    @FXML
    private void ActionEvent(ActionEvent event){
        
        Object ev = event.getSource();
        
        // esta parte de aqui no es necesaria esto es para cuando tenemos varios botones con el mismo nombre de evento.
        if(ev.equals(btningresar)){
            
            // en este condicional verificamos si los campos de textos no estan vacios.
            if(!textuser.getText().isEmpty() && !password.getText().isEmpty()){
                users = new misUsuarios();
                String user = textuser.getText();
                String pass = password.getText();
               boolean estado = users.Verf_user(user, pass);
               
               // si encuentra el usuario y contraseña ingresa de lo contrario 
               // muestra una pantalla de error.
               if(estado == true){
                  loadStage("/view/viewBienvenida.fxml", event);
               }else{
                   
                   JOptionPane.showMessageDialog(null, " Contraseña Incorrecta ",
                           "Error",
                           JOptionPane.ERROR_MESSAGE);
                   
                   password.setText("");
                   password .requestFocus();
               }
            }else{
                
                JOptionPane.showMessageDialog(null, " por favor revise los datos de ingreso ", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                textuser.setText("");
                password.setText("");
                textuser.requestFocus();
            }
        }
    }
    
    
    // evento para crear una nueva cuenta
    @FXML
    private void eventoCrearC(ActionEvent event){
        
        loadStage("/view/CrearCuenta.fxml", event);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btningresar.setCursor(Cursor.HAND);
    } 
    
    
    // metodo para cambiar de scene.
    public void loadStage(String url, Event event) {
        try{
            
            // obtenemos el evento, para luego obtener la scene y la ventana anterior
            Stage stage = (Stage)((Node) (event.getSource())).getScene().getWindow();
            /*
            esta es de la forma larga
            ---------------------------
            obtenemos el evento de origen
            Object evento = event.getSource();
            casteamos el evento a tipo node
            Node sourceNode = (Node) evento;
            obtenemos la scene
            Scene oldscene = sourceNode.getScene();
            para luego obtener la ventana
            Window window = oldscene.getWindow();
            por ultimo cambiar de ventana o esto ya depende de el gusto cerrar la ventana.
            Stage stage = (Stage) window;
            */
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
            /*
            // esto es por si queremos cerrar la ventana anterior
            y trabajar en una nueva
            Stage newstage = new Stage();
            newstage.setScene(scene);
            newstage.show();
            */
            
        }catch(IOException e){
            
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
     }
}
