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
        mVentas miData=null;
        int vend, mes, pos;
        
        int op;
        
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
            "Menú Principal \n"+
            "1. Crear y cargar matriz de ventas. \n"+
            "2. Mostrar ventas. \n"+
            "3. Mostrar ventas de un vendedor. \n"+
            "4. Mostrar ventas de un mes. \n"+
            "5. Determinar el mejor vendedor del año. \n"+
            "6. Determinar el mejor mes de ventas. \n"+        
            "7. Salir. \n"+
            "Entre su opción: ?"        
            ));
            
            switch(op){
                case 1:
                    miData = new mVentas();
                    miData.setLlenar();
                break;
                case 2:
                    if(miData==null)
                        JOptionPane.showMessageDialog(null, 
                        "La matriz no tiene registrado los datos!!");
                    else
                        miData.getMostrarV();
                break;
                case 3:
                    if(miData==null)
                        JOptionPane.showMessageDialog(null, 
                        "La matriz no tiene registrado los datos!!");
                    else{
                        vend=Integer.parseInt(JOptionPane.showInputDialog(
                        "Entre la posición del vendedor a consultar: "));
                        if((vend>=0)&&(vend<miData.nv)){
                            miData.getVentasdeUNVendedor(vend);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, 
                            "Esta posición del vendedor es invalida!");
                        }
                    }
                break;
                case 4:
                    if(miData==null)
                        JOptionPane.showMessageDialog(null, 
                        "La matriz no tiene registrado los datos!!");
                    else{
                        mes=Integer.parseInt(JOptionPane.showInputDialog(
                        "Entre la posición del mes a consultar: "));
                        if((mes>=0)&&(mes<miData.nm)){
                            miData.getVentasdeUNMes(mes);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, 
                            "Esta posición del mes es invalida!");
                        }
                    }
                break;
                case 5:
                    if(miData==null)
                        JOptionPane.showMessageDialog(null, 
                        "La matriz no tiene registrado los datos!!");
                    else{
                        pos=miData.getMejorVendorA();
                        JOptionPane.showMessageDialog(null, 
                        "El mejor vendedor del año es: "+pos
                        +". Sus ventas fueron: "+miData.getVentasVendedor(pos));
                    }
                break;
                case 6:
                    if(miData==null)
                        JOptionPane.showMessageDialog(null, 
                        "La matriz no tiene registrado los datos!!");
                    else{
                        pos=miData.getMejorMesV();
                        JOptionPane.showMessageDialog(null, 
                        "El mejor mes de ventas del año es: "+pos
                        +". Sus ventas fueron: "+miData.getVentasMes(pos));
                    }
                break;
                case 7:                    
                    JOptionPane.showMessageDialog(null, 
                    "Adios!!!");
                break;
                default:
                    JOptionPane.showMessageDialog(null, 
                    "Error!: Opción invalida, intente"
                    + " nuevamente.");                                    
            }
            
        }while(op!=7);
        
        System.exit(0);
    }
}
