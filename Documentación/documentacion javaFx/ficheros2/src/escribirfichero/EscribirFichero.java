/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package escribirfichero;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author leocarlos
 * conesto estamos listos para crear nuestro proyecto 
 * jeje boy.
 */
public class EscribirFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        escribiendo escribir = new escribiendo();
        escribir.escribir();
    }
    
}
class escribiendo{
    
    
    public void escribir(){
        
        
        try{
        FileWriter escritura = new FileWriter("C:/Users/USUARIO/Desktop/texto/nuevo.txt",true);
        escritura.write(" hola estoy escribiendo en un nuevo fichero por segunda vez");
        escritura.close();
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error "+e);
        }
    }
    // de esta forma podemos borrar un fichero.
    public void eliminarfichero(){
        
        File ruta = new File("C:/Users/USUARIO/Desktop/texto/nuevo.txt");
        
        if(ruta.delete()){
            
            System.out.println("archivo borrado");
        } else{
            System.out.println("el archivo no se pudo borar");
        }
    }
}