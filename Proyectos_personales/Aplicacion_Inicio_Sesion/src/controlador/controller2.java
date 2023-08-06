/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author leocarlos
 */
public class controller2 implements Initializable {
    
    misUsuarios users;
    controller1  obj = new controller1();
    
     @FXML
    private TextField textuser2;
    
    @FXML 
    private PasswordField password2;
    
    @FXML 
    private Button btningresar2;
    
    // verificacion de campos de texto.
    @FXML
    private void eventkey2(KeyEvent event){
        
        Object ev = event.getSource();
        
        if(ev.equals(textuser2)){
            
            if(event.getCharacter().equals(" ")){
                
                event.consume();
            }
        }else if(ev.equals(password2)){
            
            if(event.getCharacter().equals(" ")){
                
                event.consume();
            }
        }
    }
    
    @FXML
    private void evento1(ActionEvent event){
        
        Object ev = event.getSource();
        
        if(ev.equals(btningresar2)){
            
            if(!textuser2.getText().isEmpty() && !password2.getText().isEmpty()){
                // instancio la variable
                users = new misUsuarios();
                // agrego el usuario a la lista
                users.setUsurio(textuser2,password2);
                // guardo la info del Usuario en el fichero.
                users.guardarinfo(users.lista.get(0).mostrar());
                // muestro el inicio de sesion principal.
                obj.loadStage("/view/viewlogin.fxml", event);
            }else{
                
                JOptionPane.showMessageDialog(null, " por favor revise los datos de ingreso ", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    @FXML
    private void eventVolver(ActionEvent event){
        obj.loadStage("/view/viewlogin.fxml", event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      btningresar2.setCursor(Cursor.HAND);
    }
    
    /*
    private void loadStage(String url, Event event) {
        try{
            
            // obtenemos el evento, para luego obtener la scene y la ventana anterior
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            /*
            esta es de la forma larga
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
            
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
            /*
            // esto es por si queremos cerrar la ventana anterior
            y trabajar en una nueva
            Stage newstage = new Stage();
            newstage.setScene(scene);
            newstage.show();
            
            
        }catch(IOException e){
            
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
            
        }
     }
*/
    
}
