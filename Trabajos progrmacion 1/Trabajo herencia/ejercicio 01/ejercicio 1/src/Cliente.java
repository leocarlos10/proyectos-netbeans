/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
/**
 *
 * @author leo y moises
 */
public class Cliente extends Persona {
    
    protected  int id_cliente;
    
    Cliente(String nombre, int cedula, int edad,int id_cliente){
        
        super(nombre,cedula,edad,0);
        this.id_cliente=id_cliente;   
    }
    
    protected void registrarCliente( List<Persona> lista, Cliente cliente){
        lista.add(cliente);
    }
    
    @Override
    public boolean esMayoredad(){
        return edad >=18;
    }
    
    
    
    
}
