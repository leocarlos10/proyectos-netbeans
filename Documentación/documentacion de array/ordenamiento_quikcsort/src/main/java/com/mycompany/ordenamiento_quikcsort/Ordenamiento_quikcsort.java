

package com.mycompany.ordenamiento_quikcsort;

public class Ordenamiento_quikcsort {
    
    public static void ord_quick(int arreglo[],int izq,int der){
       
        // se toma como pivote el primer elemento del vector.
        int pivote= arreglo[izq];
        
        int i= izq;// puntero de izq =0
        int j= der;// puntero de derecha= tamaño del vector -1
        int aux;
        
        while(i<j){ // mientras no se crucen los punteros
            
            while(arreglo[i] <= pivote && i<j) // si esta ordenado avanza  este verifica de izq a derecha
                i++;
            
            while(arreglo[j] > pivote ) // si esta ordenado retrocede este verifica de derecha a izquierda
                j--;
            
            // cuando los ciclos terminan quedan apuntando hacia los numeros que estan desordenados respecto a el pivote
            if(i<j){ // entonces si los punteros no se han cruzado intercambia esos numeros
                
                aux=arreglo[i];
                arreglo[i]=arreglo[j];
                arreglo[j]=aux;
            
            }
        }
        // como los punteros se cruzan la j queda a puntando a el nuemero que esta en la mitad de los intercambiados anteriormente
        // entonces se intercambia el pivote que seria el que esta en la pocision 0 con el de el medio
        arreglo[izq]= arreglo[j];
        arreglo[j]=pivote;
        
        
        if(izq < j-1)
            ord_quick(arreglo, izq, j-1);
        
        
        if(j+1 < der)
            ord_quick(arreglo, j+1, der);
    }
    
    public static void mostrar(int a[]){
        
        for(int i:a){
        
            System.out.print(i+",");
        }
    
        
    }

    public static void main(String[] args) {
        
        int v[]={10,40,7,9,15,27};
        ord_quick(v,0,v.length-1);
        mostrar(v);
        
     
    }
}
