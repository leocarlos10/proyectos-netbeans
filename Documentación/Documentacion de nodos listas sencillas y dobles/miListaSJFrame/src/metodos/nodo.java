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
    //Atributos: Información
    String cod;
    String noms;
    double nHorasT;
    double valorHora;
    double nHorasE;  //El valor de la HE es el doble HT
    //Apuntador
    nodo sig;

    public nodo(String cod, String noms, double nHorasT, double valorHora, double nHorasE) {
        this.cod = cod;
        this.noms = noms;
        this.nHorasT = nHorasT;
        this.valorHora = valorHora;
        this.nHorasE = nHorasE;
        sig=null;
    }
    
    public double getSalarioParcial(){
        return nHorasT * valorHora;  //Pago Parcial        
    }
    
    public double getPagoExtras(){      
        return nHorasE * (valorHora * 2);  //Pago Extras        
    }
    
    public double getSalarioNeto(){
        double pagoP = nHorasT * valorHora;  //Pago Parcial
        double pagoE = nHorasE * (valorHora * 2);  //Pago Extras
        return (pagoP + pagoE);      
        //return ((nHorasT*valorHora)+(nHorasE * (valorHora * 2));
    }
       
}
