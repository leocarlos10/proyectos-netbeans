/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase_programacion;
import javax.swing.JOptionPane;
/**
 *
 * @author Leocarlos
 * 
 * clase 2
 * Listas: Estructura de datos - nodo= Elemento {informacion + apuntador}
 * Listas mejor conocidas como listas enlazadas  (NO UTILIZAR VECTORES ESTATICOS, ARRAYLIST) SOLO NODOS.
 * 
 * Estructura
 * class nodo {
 *  
 *      String id;          - Informacion.
 *      String noms;        -
 *      float KmR;          -
 *      nodo sig; - apuntador
 * }
 */
public class Clase_Programacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Lista  list = new Lista();
        int opcion =0;
        do{
            
             opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                 Escoga una opcion 
                                                 1: crear nodo
                                                 2: mostrar nodos
                                                 3: salir
                                                 """));
            
            switch(opcion){

                case 1:
                    list.setAddF();
                    break;
                case 2: 
                    list.getMostrarTds();
                    break;
                case 3: JOptionPane.showMessageDialog(null, "secion terminada.");
                    break;

                default : JOptionPane.showMessageDialog(null, "Error por favor ingrese una opcion valida.");
            }
        }while(opcion != 3);
    }
}