/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author Leocarlos
 
 */
public class nodo1 {
    
    
    String cod;
    String noms;
    double nHorasT;
    double valorHora;
    double nHorasE;  
    //Apuntador
    nodo1 sig;
    
     public nodo1(String cod, String noms, double nHorasT, double valorHora, double nHorasE) {
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
       
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public double getNHorasT() {
        return nHorasT;
    }

    public void setNHorasT(double nHorasT) {
        this.nHorasT = nHorasT;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getNHorasE() {
        return nHorasE;
    }

    public void setNHorasE(double nHorasE) {
        this.nHorasE = nHorasE;
    }
}
