/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros2;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Leocarlos
 * obs
 * para que no tengas errores ala hora de que el programa busque el archivo en tu computadora 
 * copia la ruta y modificala
 * 
 * 2obs
 * utiliza la clase File primero para agregar la ruta del archivo y luego pasarsela a el FileReader.
 * 
 */
public class Ficheros2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try{
            
            File archivo = new File("C:/Users/USUARIO/Desktop/texto/ejemplo2.txt");
            // aqui estamos abriendo el flujo para que el programa busque la ruta
            FileReader leer = new FileReader(archivo);
            // con esto evitamos que se coma la primera letra del fichero 
            int c = 0;
            
            while(c!=-1){
                
                c= leer.read();
                System.out.print((char)c);
            }
            
            // con esto hacemos que el flujo termine
            leer.close();
        }catch(IOException e){
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
