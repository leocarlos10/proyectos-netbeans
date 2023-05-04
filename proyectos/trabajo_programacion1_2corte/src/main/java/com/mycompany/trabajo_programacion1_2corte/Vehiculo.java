
package com.mycompany.trabajo_programacion1_2corte;
import javax.swing.JOptionPane;

public class Vehiculo {
    
     String matricula;
     String marca;
     String modelo;
     float precio;
     Boolean estado;

    public Vehiculo(String matricula, String marca, String modelo, float precio, Boolean estado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.estado = estado;
    }
 // agregamos los metodos setter y getter para poder hacer la modificacion y el intercambio en los metodos de ordenamiento.
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    
    public void mostrar(){
        
        String datos= " Matricula: "+matricula+"\n marca: "+marca+"\n modelo: "+modelo+"\n precio: "+precio+"\n estado: "+estado;
        JOptionPane.showMessageDialog(null,datos);
    
    }
    
    
     
     
    
    
}
