/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Leocarlos 
 * este es una forma de leer ficheros utilizando la clase scanner.
 */
public class Ficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombreArchivo = "/infoUsuarios2.txt";
        String rutaArchivo = "C:/Users/USUARIO/Desktop/texto",usuario="",contra="";
        
        try {
            File archivo = new File(rutaArchivo + nombreArchivo);
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
