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
public class miVector {
    //Atributo
    public computador miData[];
    
    //Constructor
    public miVector( ){
        int tam = Integer.parseInt(JOptionPane.showInputDialog(
        "Entre tamaño del vector de objetos: "));
        //Se define el tamaño del vector.
        miData = new computador[tam];
        //Definimos el vector vacío en memoria.
        int i;
        for(i=0; i<miData.length; i++){
            miData[i] = new computador(-1, -1, -1, "");
        }
        JOptionPane.showMessageDialog(null, 
        "Se ha creado el vector vacío de tamaño: "+miData.length);
    }
    
    public int getBuscarconID(int id){        
        int i;
        for(i=0; i<miData.length; i++){
            if(miData[i].getId() == id)
                return i;  //Retorna i, si encuentra el elemento   
        }
        //Si realizó todo el ciclo, entonces no lo encontró
        //retorna -1
        return -1;
    }

    //Métodos
    public void setLlenar(){
        int i, pos=-1, id;
        for(i=0; i<miData.length; i++){
            do{
                //Pedimos el idComputador a registrar
                id=Integer.parseInt(
                JOptionPane.showInputDialog(
                "Entre el idComputador en la posición "+i+":"));
                
                //Se busca que IdComputador no este registrado
                pos=getBuscarconID(id);
                
                if(pos==-1)
                    miData[i].setId(id);
                else                    
                    JOptionPane.showMessageDialog(null,
                    "El idComputador ya existe!!! "
                    + "Intente nuevamente.");
            }while(pos>=0);
            
            miData[i].setnRAM(Integer.parseInt(
            JOptionPane.showInputDialog(
            "Entre el #RAM del PC en la posición "+i+":")));
            miData[i].setcSSD(Integer.parseInt(
            JOptionPane.showInputDialog(
            "Entre el #SSD en la posición "+i+":")));
            miData[i].setnProc(JOptionPane.showInputDialog(
            "Entre la marca del procesador "
            + "en la posición "+i+":"));
        }
    }
    
    public void getMostrarAll(){
        int i;
        for(i=0; i<miData.length; i++){
            miData[i].getMostrar();
        }
    }
    
    public int getBuscarID(){
        int id=Integer.parseInt(JOptionPane.showInputDialog(
        "Entre el idComputador a buscar: "));
        int i=0;
        while(i<miData.length){
            if(miData[i].getId() == id)
                return i;  //Retorna i, si encuentra el elemento            
            i++;
        }
        //Si realizó todo el ciclo, entonces no lo encontró
        //retorna -1
        return -1;
    }
    
    public void getMostrarPC(){
        int pos = getBuscarID();
        
        if(pos==-1)
            JOptionPane.showMessageDialog(null, 
            "El idComputador no esta registrado!!!");
        else
            miData[pos].getMostrar();
    }
    
    public void setBurbuja(){
        int i, j;
        computador temp=null;
        
        for(i=0; i<miData.length; i++){
            for(j=0; j<(miData.length - 1); j++){
                if(miData[j].getId()>=miData[j+1].getId()){
                    //Copiamos en un objeto temporal 
                    //la información a intercambiar.
                    temp=new computador(
                    miData[j+1].getId(),
                    miData[j+1].getnRAM(),
                    miData[j+1].getcSSD(),
                    miData[j+1].getnProc()
                    );
                    
                    //Se intercambia la información
                    //del objeto siguiente con el objeto
                    //anterior.
                    miData[j+1].setId(miData[j].getId());
                    miData[j+1].setnRAM(miData[j].getnRAM());
                    miData[j+1].setcSSD(miData[j].getcSSD());
                    miData[j+1].setnProc(miData[j].getnProc());
                    
                    //Se intercambia la información
                    //de la posición anterior con lo que 
                    //tenía la posición siguiente (temporal).
                    miData[j].setId(temp.getId());
                    miData[j].setnRAM(temp.getnRAM());
                    miData[j].setcSSD(temp.getcSSD());
                    miData[j].setnProc(temp.getnProc());
                    
                }
            }
        }
    }
    
    //Denominado así por su desarrollador Donald Shell (1959),
    //ordena utilizando la segmentación (salto), puede ser de 
    //cualquier tamaño de acuerdo a una secuencia de 
    //valores que empiezan con un valor grande 
    //(pero menor al tamaño total de la estructura) 
    //y van disminuyendo hasta llegar al '1'.
    public void setShell(){
        int salto, i;
        computador temp=null;        
        boolean cambios;
  
        for (salto = miData.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento                                         
                cambios = false;
                for (i = salto; i < miData.length; i++)   // se da una pasada
                {
                    if ((miData[i - salto].getnProc()).
                        compareTo(miData[i].getnProc())>0) {       // y si están desordenados
                        //Copiamos en un objeto temporal 
                        //la información a intercambiar.
                        temp=new computador(
                        miData[i].getId(),
                        miData[i].getnRAM(),
                        miData[i].getcSSD(),
                        miData[i].getnProc()
                        );  //Se copia para reordenar.                                                
                        
                        //Se intercambia la información                        
                        miData[i].setId(miData[i - salto].getId());
                        miData[i].setnRAM(miData[i - salto].getnRAM());
                        miData[i].setcSSD(miData[i - salto].getcSSD());
                        miData[i].setnProc(miData[i - salto].getnProc());
                                                
                        miData[i - salto].setId(temp.getId());
                        miData[i - salto].setnRAM(temp.getnRAM());
                        miData[i - salto].setcSSD(temp.getcSSD());
                        miData[i - salto].setnProc(temp.getnProc());                        
                        cambios = true;              // y se marca como cambio.                                   
                    }
                }
            }
        }
    }
    
    public int getPosMayorRAM( ){
        int i, posM=0;
        int may=miData[0].getnRAM();
        
        for(i=0; i<miData.length; i++){
            if(miData[i].getnRAM()>=may){
                may=miData[i].getnRAM();
                posM=i;
            }
        }
        return posM;
    }
    
    public void getMostrarPos(int pos){                
        if(pos==-1)
            JOptionPane.showMessageDialog(null, 
            "El idComputador no esta registrado!!!");
        else
            miData[pos].getMostrar();
    }
    
    public int getSumaSSD(){
        int i, suma=0;
        for(i=0; i<miData.length; i++){
            suma += miData[i].getcSSD();
        }
        return suma;
    }
    
    public int getPromedioSSD(){
        return getSumaSSD()/miData.length;
    }
    
    public int getCantPCMayorSSDPromedio(){
        int prom=getPromedioSSD();
        int i, cont=0;
        
        for(i=0; i<miData.length; i++){
            if(miData[i].getcSSD()>prom)
                cont++;
        }
        return cont;
    }
    
    //El método se basa en buscar en cada iteracción el mínimo
    //elemento del “subvector” situado entre el índice i y el 
    //final del vector e intercambiarlo con el de índice i. 
    public void setSeleccion(){
        int i, j, imin;
        computador temp; // una varible de tipo computador para poder intercambiar los datos.
         for (i=0; i<miData.length; i++){
            imin=i; // inicializa imin en i suponiendo que esa es la poscision del dato menor.
            for (j=i+1; j<miData.length; j++){ // este for ayuda a buscar el indice del dato menor de todo el vector.
                if(miData[j].getcSSD()<miData[imin].getcSSD())
                    imin=j;
            }
            // cuando sale de este bucle while ya tiene el menor
            //Copiamos en un objeto temporal 
            //la información a intercambiar.
            temp=new computador(
                miData[i].getId(),
                miData[i].getnRAM(),
                miData[i].getcSSD(),
                miData[i].getnProc()
            ); 
            
            //Se intercambia la información                        
            miData[i].setId(miData[imin].getId());
            miData[i].setnRAM(miData[imin].getnRAM());
            miData[i].setcSSD(miData[imin].getcSSD());
            miData[i].setnProc(miData[imin].getnProc());
            
            miData[imin].setId(temp.getId());
            miData[imin].setnRAM(temp.getnRAM());
            miData[imin].setcSSD(temp.getcSSD());
            miData[imin].setnProc(temp.getnProc());            
        }
    }
    
    //Método QuickSort
    /*
    En el método quickSort, inicio y fin son los índices que definen el 
    subarreglo actual que se está ordenando. El pivote se selecciona 
    como el último elemento del subarreglo. Luego, se recorre el subarreglo 
    desde el inicio hasta el penúltimo elemento, y se intercambia 
    cualquier elemento menor que el pivote con el primer elemento que sea 
    mayor que el pivote. Finalmente, se intercambia el pivote con el 
    primer elemento mayor que el pivote, de modo que el pivote queda 
    en su posición final en el arreglo ordenado.
    Luego, se llama recursivamente al método quickSort en los 
    subarreglos izquierdo (desde inicio hasta i - 1) y derecho 
    (desde i + 1 hasta fin). El proceso se repite hasta que cada 
    subarreglo tenga longitud 0 o 1, lo que significa que ya está ordenado.
    */
    public void quickSort(int inicio, int fin) {
        if (inicio < fin) {
            int pivote = miData[fin].getId();
            int i = inicio - 1;
            for (int j = inicio; j < fin; j++) {
                if (miData[j].getId() < pivote) {
                    i++;
                    swap(i, j);
                }
            }
            i++;
            swap(i, fin);
            quickSort(inicio, i - 1);
            quickSort(i + 1, fin);
        }
    }
    
    //Método de intercambio para QuickSort
    public void swap(int i, int j) {
        computador temp = miData[i];
        miData[i] = miData[j];
        miData[j] = temp;
    }
    
}
