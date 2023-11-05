/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.time.LocalDate;
import javax.swing.*;

/**
 *
 * @author Leocarlos y moises.
 */
public class Alumno extends Persona {
    
    protected LocalDate fechaNacimiento;
    protected int idAlumno;

    public Alumno(LocalDate fechaNacimiento, int idAlumno, String apellido, String correoElectronico, String nombre) {
        super(apellido, correoElectronico, nombre,0);
        this.fechaNacimiento = fechaNacimiento;
        this.idAlumno = idAlumno;
    }
    
    @Override
     public void Tovalidate(JTextPane inf){
         
         // si la persona existe en la lista entonces se mostraran sus datos.
         String info=" Nombre: "+nombre+
                 "\n Apellido: "+apellido+
                 "\n correo: "+correoElectronico+
                 "\n Id del instructor: "+idAlumno+
                 "\n fecha de nacimiento: "+fechaNacimiento;
         inf.setText(info);
     }
}
