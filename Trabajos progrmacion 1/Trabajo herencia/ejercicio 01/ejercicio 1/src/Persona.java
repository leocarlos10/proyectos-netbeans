/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leo y moises
 */
public class Persona {
    
    protected String nombre;
    protected  int cedula;
    protected  int edad;
    protected  int Tp;
    
    Persona(){}
    
    public Persona(String nombre, int cedula, int edad,int Tp) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.Tp=Tp;
    }
    
    public boolean esMayoredad(){
        return edad >= 18;
    }
    
    
    
}
