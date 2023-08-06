/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author USUARIO
 */
public class Usuario {
    
     String user;
     String pass;

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    public String mostrar(){
        
        String info=user+pass;
               info+="\n";
      return info;
    }
    
    
}
