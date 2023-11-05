/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Leocarlos
 * ejemplo de como trabajar javafx con el metodo vista controlador.
 */
public class controlador implements Initializable {
    
   /*
    
    Documentacion
    
   esto se utiliza para poder obtener el evento y saber de donde viene
   Object ev = (nombre del evento).getSource();
   
   luego unos condicionales para compara los campo de texto
   if(ev.equals(nombre de los textField)){
        dentro va la validacion del campo
   }
   */
   /* 
   ------------------------------
   con esto validamos los campos.
   -------------------------------
   con esto nos aseguramos de que solo se ingresen letras y espacios
    !Character.isLetter(event.getCharacter().charAt(0)) && !event.getCharacter().equals(" ")
   con este nos aseguramos de que solo sean numeros
   !Character.isDigit(event.getCharacter().charAt(0)) 
   con este permitimos el ingreso de alfanumericos numeros y letras
    !Character.isDigit(event.getCharacter().charAt(0)) && !Character.isLetter(event.getCharacter().charAt(0))  
   para un campo de tipo passwordfield 
   se puede verificar cuantos caracteres debe tener la clave 
   
   if(nombre.getText().length() > 7){
        
        nameEvent.cosume();
   }
   ------------------------
   consume(); metodo que nos ayuda a parar un evento
   */
     @FXML
   private TextField texto,mostrar;
     
     @FXML
    private void evento4(KeyEvent event) {

        if (!Character.isLetter(event.getCharacter().charAt(0)) && !event.getCharacter().equals(" ")) {
            event.consume();
        }
    }
   
   @FXML
   private Button agregar,Limpiar;
   
   @FXML
   private void evento1(ActionEvent event){
       
       String text = texto.getText();
       mostrar.setText(text);
   }
    @FXML
   private void eventoLimpiar(ActionEvent e){
       
       mostrar.setText("");
       texto.setText("");
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        texto.setPromptText("ingrese un texto");
        agregar.setCursor(Cursor.HAND);
        Limpiar.setCursor(Cursor.HAND);
        
    }    
    
}
