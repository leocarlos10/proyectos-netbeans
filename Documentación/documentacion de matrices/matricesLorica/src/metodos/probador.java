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
public class probador {
    public static void main(String args[]){
        misDatos lasVentas=new misDatos();
        int numV, numM;
        int op;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
            "Menú Principal \n"+
            "1. Llenar matriz ventas \n"+
            "2. Mostrar matriz ventas \n"+
            "3. Total de ventas y promedio de un vendedor \n"+
            "4. Total de ventas y promedio de un mes \n"+        
            "5. Ventas por vendedor \n"+
            "6. Ventas por mes \n"+        
            "7. Mejor vendedor \n"+   
            "8. Salir \n"+
            "Entre su opción: ?"
            ));
            
            switch(op){
                case 1:
                    lasVentas.setLlenarMatriz();
                break;
                case 2:
                    lasVentas.getSeeMatriz();
                break;
                case 3:
                    numV=Integer.parseInt(JOptionPane.showInputDialog(
                    "Entre vendedor a consultar: "));
                    JOptionPane.showMessageDialog(null, 
                    "La suma de ventas del vendedor es: "
                    +lasVentas.getSumaVendedor(numV)+"\n"+
                    "El promedio de ventas del vendedor es: "+
                    +lasVentas.getPromedioVendedor(numV)+"\n"
                    );
                break;
                case 4:
                    numM=Integer.parseInt(JOptionPane.showInputDialog(
                    "Entre mes a consultar: "));
                    JOptionPane.showMessageDialog(null, 
                    "La suma de ventas del mes es: "
                    +lasVentas.getSumaMes(numM)+"\n"+
                    "El promedio de ventas del mes es: "+
                    +lasVentas.getPromedioMes(numM)+"\n"
                    );
                break;
                case 5:
                    lasVentas.getMostrarVector(
                    lasVentas.getVentasxVendedor());
                break;
                case 6:
                    lasVentas.getMostrarVector(
                    lasVentas.getVentasxMes());
                break;
                case 7:
                    lasVentas.getMejorVendedor();
                break;
                case 8:
                    JOptionPane.showMessageDialog(null,
                    "Adios!");
                break;
                default:
                    JOptionPane.showMessageDialog(null,
                    "Opción invalida!");
            }
            
        }while(op!=8);
        System.exit(0);
    }
}
