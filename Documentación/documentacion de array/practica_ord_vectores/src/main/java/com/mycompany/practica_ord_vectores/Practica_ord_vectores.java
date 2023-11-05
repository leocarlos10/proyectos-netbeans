

package com.mycompany.practica_ord_vectores;
import javax.swing.JOptionPane;

// 3,4,5,2,9  conclusion el ordenamiento por inserccion es mucho mas optimizado para este tipo de ordenamientos.

//              
public class Practica_ord_vectores {
    
    public static void metodoBurbuja(int vec[]){
        /*
        teniendo en cuenta que cuando el algoritmo ya dio una vuelta 
        significa que el mayor ya quedo en la ultima posicion (esta ordenado)
        lo que queda por comparar seria el antepenultimo y el penultimo
        cada vez va comparando menos casillas.
        */
        int temp=0;
   for(int i=0;i<=(5-1);i++){
              
            for(int j=0;j<=(5-i)-2;j++){ // ayuda a comparar solo la casillas que no se encuentran ordenadas. 
                
                if(vec[j]>vec[j+1]){        // si se quiere hacer de menor a mayor seria con > si es de mayor a menor seria <.
                   
                   temp=vec[j];
                   vec[j]=vec[j+1];
                   vec[j+1]=temp;
                }
            }
        
        }
        
        for(int h:vec){
        
            System.out.print(h+",");
        
        }
        
      
    }
    
    public static void metodoInserccion(int vec[]){
        // en cuestion de optimizacion el metodo por insercion hace menos vueltas de bucle para ordenar el vector.
        int pos=0,aux=0,c1=0,c2=0;
        for(int i=0;i<5;i++){ // i<al tamaño del vector
            
            pos=i;// guardamos la i para poder restarla y refrescar el nuemero en el anterior
            aux=vec[i];// aqui guardamos el numero en el que va para posteriormente colocarlo en la pos-1
            
            while((pos>0) && vec[pos-1]>vec[pos]){ // pos>0 se asegura de que empiece desde el 1 y la otra de el intercambio
            
                vec[pos]=vec[pos-1]; // intercambia
                pos--; // le resta para seguir comparando con los demas elementos.;
                c2++;
            }
            vec[pos]=aux; // guarda el elemento remplazado en la posicion anterior.
            c1++;
        }
        
        for(int h:vec){
        
            System.out.print(h+",");
        }
        
        System.out.println("bucle1 "+c1+" bucle2 "+c2);
    }    

    public static void main(String[] args) {
   
        
        //inicializamos el vector
        int vec[]={5,3,4,2,9};  int opcion=0;
        
        boolean band=false;
         do{ // para evitar que el usuario digite numeros diferentes de  1y2
        
        String info= """
                    Menu: escoga que algoritmo desea para ordenar el vector 
                      1: Burbuja
                      2: inserccion
                  
                    """;
        
         opcion=Integer.parseInt(JOptionPane.showInputDialog(info));
        
       
        switch(opcion){
            
            case 1: metodoBurbuja(vec);
                    band=true;
                    break;
            case 2: metodoInserccion(vec);
                    band=true;
                    break;
            default: JOptionPane.showMessageDialog(null," Opcion Invalida !!");
                    
        }
        
        }while(band==false);
        
        
        
        
    }
}
