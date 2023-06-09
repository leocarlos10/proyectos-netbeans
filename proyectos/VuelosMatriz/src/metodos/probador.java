/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;
import javax.swing.JOptionPane;
/**
 *
 * @author ruben
 */
public class probador {
    public static void main(String args[]){
        int op;
        matrizV misVuelos=null;
        
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
                "Menú Principal \n"
                + "1. Registrar matriz de vuelos \n"
                + "2. Consultar vuelo \n"
                + "3. Comprar tiquetes de un vuelo \n"
                + "4. Mostrar matriz vuelos \n"
                + "5. Salir \n"
                + "Entre su opción? "
            ));
            
            switch(op){
                case 1:
                    misVuelos = new matrizV();
                break;
                case 2:
                    misVuelos.getObtenerDisponibles();
                break;
                case 3:
                    misVuelos.setCompraTiquetes();
                break;
                case 4:
                    misVuelos.getMostrarTvuelos();
                break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Adios!!");
                break;
                default:
                    JOptionPane.showMessageDialog(null, 
                        "Opción invalida... Intente nuevamente!");
            }
            
        }while(op!=5);
        System.exit(0);
    }
}
