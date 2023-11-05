/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.time.LocalDate;
import javax.swing.*;
/**
 *
 * @author Leocarlos y moises
 */
public class Instructor extends Persona {
    
    protected LocalDate fechaIngreso;
    protected int idInstructor;

    public Instructor(LocalDate fechaIngreso, int idInstructor, String apellido, String correoElectronico, String nombre) {
        super(apellido, correoElectronico, nombre,1);
        this.fechaIngreso = fechaIngreso;
        this.idInstructor = idInstructor;
    }
    
    @Override
     public void Tovalidate(JTextPane inf){
     // si la Instructor existe en la lista entonces se mostraran sus datos.
         String info=" Nombre: "+nombre+
                 "\n Apellido: "+apellido+
                 "\n correo: "+correoElectronico+
                 "\n Id del instructor: "+idInstructor+
                 "\n Fecha de ingreso: "+fechaIngreso;
         inf.setText(info);
     }
    
}
