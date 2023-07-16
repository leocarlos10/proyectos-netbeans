/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginjavafx;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Leocarlos
 * programa terminado.
 */
public class misUsuarios {

    List<Usuario> lista = new ArrayList<>();

    public void setUsurio(TextField u, TextField pass, TextField nom) {

        lista.add(new Usuario(u.getText(), pass.getText(), nom.getText()));
    }
    
    public void guardarinfo(String inf){
        
        try{
        FileWriter guardar = new FileWriter("C:/Users/USUARIO/Desktop/texto/infoUsuarios.txt",true);
        guardar.write(inf);
        guardar.close();
        lista.clear();
        
        }catch(IOException e){
            
            JOptionPane.showMessageDialog(null, e);
        }   
    }
    
    public void mostrarUsuariosG(TextArea tabla){
        try{
            //guardamos la ruta del archivo
        File archivo = new File("C:/Users/USUARIO/Desktop/texto/infoUsuarios.txt");
        // abrimos la ruta
        FileReader leer = new FileReader(archivo);
        int c=0;
        String inf="";
        /*
        en este bucle y con la ayuda de la variable c 
        vamos a ir capturando en ese variable el codigo correspondiente 
        a cada letra para posteriormente ir acumulando en la variable inf
        letra por letra hasta guardar todo lo escrito en el fichero.
        */
        while(c!=-1){
            
            c=leer.read();
            inf+= String.valueOf((char)c);
        }
        // le mandamos el texto a la tabla
        tabla.setText(inf);
        // cerramos el flujo.
        leer.close();
        
        }catch(IOException e){
            
            JOptionPane.showMessageDialog(null, " En este momento no se ecnuentran usuarios registrados");
        }     
    }
    
     public void eliminarusuariosG(){
        
        File ruta = new File("C:/Users/USUARIO/Desktop/texto/infoUsuarios.txt");
        
        if(ruta.delete()){
            
            JOptionPane.showMessageDialog(null, "Los usuarios fueron borrados correctamente");
        } else{
           JOptionPane.showMessageDialog(null, "El archivo no se pudo borrar");
        }
    }

    public void mostrar(TextArea area) {

        String info = "";

        for (int i = 0; i < lista.size(); i++) {

            info += lista.get(i).mostrar();
        }
        area.setText(info);
    }
    
     public String  mostrar() {

        String info = "";

        for (int i = 0; i < lista.size(); i++) {

            info += lista.get(i).mostrar();
        }
        return info;
    }
}
