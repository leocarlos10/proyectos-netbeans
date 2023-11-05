/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Examen2;

import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Trabajador {
    
    private String nombre;
    private String apellido;
    private String codigo;
    private String departamento;
    private int ageTrabajo;
    private String cargo;
    private float salario;
    
    public Trabajador(){
    
    }

    public Trabajador(String nombre, String apellido, String codigo, String departamento, int ageTrabajo, String cargo, float salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.departamento = departamento;
        this.ageTrabajo = ageTrabajo;
        this.cargo = cargo;
        this.salario = salario;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getAgeTrabajo() {
        return ageTrabajo;
    }

    public void setAgeTrabajo(int ageTrabajo) {
        this.ageTrabajo = ageTrabajo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void mostrar(String inf) {
        
          String info= "Trabajador " +inf+ 
                "\n nombre: " + getNombre() + 
                "\n apellido: " + getApellido() + 
                "\n codigo: " + getCodigo() + 
                "\n departamento: " + getDepartamento() +
                "\n años de trabajo: " +getAgeTrabajo() + 
                "\n cargo: " + getCargo() + 
                "\n salario: " + getSalario();
          
        JOptionPane.showMessageDialog(null,info);
    }
    
    public void mostrar() {
        
          String info= "Trabajador " + 
                "\n nombre: " + getNombre() + 
                "\n apellido: " + getApellido() + 
                "\n codigo: " + getCodigo() + 
                "\n departamento: " + getDepartamento() +
                "\n años de trabajo: " +getAgeTrabajo() + 
                "\n cargo: " + getCargo() + 
                "\n salario: " + getSalario();
          
        JOptionPane.showMessageDialog(null,info);
    }
    
    
}
