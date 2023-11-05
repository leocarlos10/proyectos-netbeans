/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author Ruben
 */
public class nodo {
    int idPelicula;
    String nomPelicula;
    String fechaP;
    boolean estado;
    nodo sig;
    
    //FechaP es vacía porque la pelicula
    //no esta prestada.
    nodo(){
        idPelicula=-1;
        nomPelicula=fechaP="";
        estado=true; //Disponible
        sig=null; 
    }
    
    nodo(int id, String nomp){
        idPelicula=id;
        nomPelicula=nomp;
        fechaP="";
        estado=true;
        sig=null;
    }
    
    nodo(int id, String nomp, String fecha, boolean est){
        idPelicula=id;
        nomPelicula=nomp;
        fechaP=fecha;
        estado=est;
        sig=null;
    }
    
}
