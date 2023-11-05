/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class miProbador {
    public static void main(String args[]){
        int op, posMRAM;
        miVector lstPC=null; 
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
            "Menú Principal \n"+
            "1. Crear y llenar vector \n"+
            "2. Mostrar vector \n"+
            "3. Buscar por idComputador \n"+
            "4. Ordenar por id (Burbuja) \n"+
            "5. Ordenar por marca (Shell) \n"+
            "6. Ordenar por cSSD (Selección) \n"+        
            "7. Mostrar PC con mayor RAM \n"+
            "8. ordenamiento quick \n"+
            "9. salir \n"+
            "Entre su opción: ?"        
            ));
            
            switch(op){
                case 1:
                    lstPC = new miVector();
                    lstPC.setLlenar();
                break;
                case 2:
                    lstPC.getMostrarAll();
                break;
                case 3:
                    lstPC.getMostrarPC();
                break;
                case 4:
                    lstPC.setBurbuja();
                    lstPC.getMostrarAll();
                break;
                case 5:
                    lstPC.setShell();
                    lstPC.getMostrarAll();
                break;
                case 6:
                    lstPC.setSeleccion();
                    lstPC.getMostrarAll();
                break;
                case 7:
                    posMRAM = lstPC.getPosMayorRAM();
                    lstPC.getMostrarPos(posMRAM);
                break;
                case 8:
                 
                break;
                case 9:
                       JOptionPane.showMessageDialog(null, 
                    "Adios!!!");
                break;
                default:
                    JOptionPane.showMessageDialog(null, 
                    "Opción invalida!!");
            }
            
        }while(op!=9);
        System.exit(0);
    }
}
