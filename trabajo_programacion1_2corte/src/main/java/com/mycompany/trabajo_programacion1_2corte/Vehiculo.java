
package com.mycompany.trabajo_programacion1_2corte;
import javax.swing.JOptionPane;

public class Vehiculo {
    
     String matricula;
     String marca;
     String modelo;
     String precio;
     Boolean estado;

    public Vehiculo(String matricula, String marca, String modelo, String precio, Boolean estado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.estado = estado;
    }
    
    public void mostrar(){
        
        String datos= " Matricula: "+matricula+"\n marca: "+marca+"\n modelo: "+modelo+"\n precio: "+precio+"\n estado: "+estado;
        JOptionPane.showMessageDialog(null,datos);
    
    }
    
    
     
     
    
    
}
