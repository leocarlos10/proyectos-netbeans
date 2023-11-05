
package com.mycompany.busquedabinaria;

import javax.swing.JOptionPane;



public class BusquedaBinaria {

    public static void main(String[] args) {
       
       int arreglo[] = {1,2,3,4,5}; // para poder hacer uso de este metodo de ordenamiento el vector debe estar ordenado.
       int dato,inf,sup,mitad,i;
       boolean band=false;
       
       dato=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a buscar"));
       
       inf=0;// guarda la posicion menor
       sup=5;// guarda la posicion mayor;
       i=0; // posicion en el vector.
       
       mitad=(inf+sup)/2; // hace esta operacion para dividir el vector en dos 
       while(inf<=sup && i<5){ // mientra inferior  sea menor o igual a superior/ si es mayor ya llego al final del vector 
       
           if(arreglo[mitad]==dato){ // si el el numero que esta en la mitad del vector es igual al dato devuelve true i termina el bucle
           
               band=true;
               break;
           }
           if(arreglo[mitad]>dato){ // si el numero llega a ser mayor quiere decir que posiblemente este por debajo de este
           
               sup=mitad; // ahora vamos a dividir el vector desde el inf hasta el dato que estaba en la mitad.
               mitad=(inf+sup/2); // dividimos el vector.
           
           }
            if(arreglo[mitad]<dato){ // si el dato es menor quiere decir que posiblemente este por encima de el numero mitad.
            
                inf=mitad; // ahora vamos a dividir vector  desde la mitad hasta el numero superior del vector,
                mitad=(inf+sup)/2;
            
            }
           
            i++; 
           
       }
       
       if(band==true){
       
           JOptionPane.showMessageDialog(null,"El numero ha sido encontrado en la posicion: "+mitad);
           
       
       }
       else{
       
           JOptionPane.showMessageDialog(null, "No hemos encontrado el numero en arreglo");
       }
       
    }
}
