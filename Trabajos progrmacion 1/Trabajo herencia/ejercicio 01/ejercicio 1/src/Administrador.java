/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
/**
 *
 * @author leo y moises
 */
public class Administrador extends Persona {
    
    protected int id_Administrador;
    
    Administrador(String nombre, int cedula, int edad, int id_Administrador){
        
        super(nombre,cedula,edad,1);
        this.id_Administrador=id_Administrador;
    }
    
  protected void registrarAdmin(List<Persona> lista, Administrador admin){
      lista.add(admin);
  }
    
    @Override
    public boolean esMayoredad(){
        
        return edad >= 18;
    }
}
