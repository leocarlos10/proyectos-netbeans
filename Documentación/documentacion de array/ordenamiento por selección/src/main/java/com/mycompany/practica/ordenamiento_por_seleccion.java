

package com.mycompany.practica;

/**
 *
 * @author USUARIO
 */
public class ordenamiento_por_seleccion {
    
    public static void ordenamiento_seleccion( int a[]){
        
        int imin,temp=0; // imin almacena el indice del posible numero menor 
        for(int i=0;i<a.length;i++){ // hace todas las comparaciones hasta que el arreglo este ordenado.
            imin=i; 
            for(int j=i+1;j<a.length;j++){// con este bucle busco el menor del vector comparando el numero en la posicion j con el imin.
                
                if(a[j]<a[imin]){
                    
                    imin=j;// cuando encuentre uno menor actualiza el indice menor.
                }
            }
            
            // intercambio el menor.
            temp=a[i];
            a[i]=a[imin];
            a[imin]=temp;
            
        }
    }
    
    public static void mostrar(int a[]){
        
        for(int i:a){
            
            System.out.println(i+",");
        }
    }

    public static void main(String[] args) {
      
        int a[]={10,9,8,7,6,5,4,3,2,1};
        ordenamiento_seleccion(a);
        mostrar(a);
    }
}
