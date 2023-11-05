

package com.mycompany.main_alquiler_autos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * reto 2  alquiler de autos. 
 */
public class Main_alquiler_autos {
    
    static List<Alquiler> alquiler = new ArrayList<>();
    
    public static void carga_objetos( int i){
   
        String nombre=JOptionPane.showInputDialog("Digite el nombre del cliente "+(i+1));
        String cedula=JOptionPane.showInputDialog("Digite la cedula del cliente "+(i+1));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad del cliente "+(i+1)));
          
         Cliente cliente = new Cliente(cedula,nombre,edad); // instanciacion del objeto cliente. 
         
           boolean band1=false;
       String placa; int Dias_ult_mantenimiento;   boolean tiene_seguro;
         
        do{
             placa=JOptionPane.showInputDialog("Digite la placa del auto"+(i+1));
            
             Dias_ult_mantenimiento=Integer.parseInt(JOptionPane.showInputDialog(
                                                                                       "Automovil"+(i+1)+"\n"+
                                                                               """
                                                                                    Digite el numero de dias que tiene el automovil desde 
                                                                                    el ultimo mantenimiento.
                                                                                    """));
             tiene_seguro=Boolean.parseBoolean(JOptionPane.showInputDialog(  
                                                                                     "Automovil"+(i+1)+"\n"+
                                                                               """
                                                                                  digite true:en caso de que el auto tenga seguro
                                                                                  digite false: en caso de que no tenga seguro.
                                                                                  """));
          
           
            if(Dias_ult_mantenimiento>0 && (tiene_seguro==true || tiene_seguro==false)){
                band1=true;
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Porfavor digite los datos correctamente");
            }
            
           }while(band1==false); // mientras los datos no esten correctos el bucle se va a seguir repitiendo.
            
           Auto auto = new Auto(placa,Dias_ult_mantenimiento,tiene_seguro);// instanciacion del objeto auto.  
           
           int horas_alquiler=Integer.parseInt(JOptionPane.showInputDialog("digite las horas acumuladas de sus alquileres anteriores en los ultimos 30 dias"));
           
           alquiler.add(new Alquiler(cliente,auto,horas_alquiler)); // aqui guardo los objetos en la lista dinamica de objetos y asi poder verificar si aplican a descuento o no.
    
    }
    
    

    public static void main(String[] args) {
        
       
         int i=0; String x="";
         do{
             carga_objetos(i);
             i++;
             
         x=JOptionPane.showInputDialog("""
                                              Desea seguir alquilando autos ?
                                              digite s:para continuar.
                                              digite n:para finalizar.
                                              """);
         }while(x.equalsIgnoreCase("s"));
         
         
         for(int j=0;j<alquiler.size();j++){
         
            JOptionPane.showMessageDialog(null, alquiler.get(j).mostrar(alquiler));
         }
       
     
        }
      
    }

