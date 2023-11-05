/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author ruben
 */
public class persona {
    protected int id;
    protected String noms;
    protected int edad;
    protected int tipoPersona;  //1=Docente, 2=Estudiante

    public persona(int id, String noms, int edad, int tipoP) {
        this.id = id;
        this.noms = noms;
        this.edad = edad;
        this.tipoPersona = tipoP;
    }

    public int getId() {
        return id;
    }

    public String getNoms() {
        return noms;
    }

    public int getEdad() {
        return edad;
    }
    
    public int getTipoP() {
        return tipoPersona;
    }
    
    public void getMostrar(){
        String info="Los datos personales son: \n";
        info += "Id: "+id+"\n";
        info += "Nombres: "+noms+"\n";
        info += "Edad: "+edad+"\n";
        JOptionPane.showMessageDialog(null, info);
    }
    
    @Override
    public String toString(){
        String info="Los datos personales son: \n";
        info += "Id: "+id+"\n";
        info += "Nombres: "+noms+"\n";
        info += "Edad: "+edad+"\n";
        return info;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setTipoP(int tipoP) {
        this.tipoPersona = tipoP;
    }
    
}
