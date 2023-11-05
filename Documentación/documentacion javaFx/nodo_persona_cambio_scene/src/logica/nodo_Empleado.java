/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class nodo_Empleado {
    // informacion
    String nombre;
    String apellido;
    String id;
    String trabajo;
    float sueldo;
    // apuntador
    // el apuntador esta publico para poder acceder a el desde otras clases.
    public nodo_Empleado sig;

    public nodo_Empleado(String nombre, String apellido, String id, String trabajo, float sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.trabajo = trabajo;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    public void mostrar(){
        String info ="nombre:" + nombre 
                + "\n apellido:" + apellido 
                + "\n id:" + id 
                + "\n trabajo:" + trabajo 
                + "\n sueldo:" + sueldo;
        
        JOptionPane.showMessageDialog(null,info,"Info empleado",JOptionPane.INFORMATION_MESSAGE);
    }  
}
