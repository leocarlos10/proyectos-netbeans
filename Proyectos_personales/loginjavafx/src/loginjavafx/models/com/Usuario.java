/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginjavafx;





/**
 *
 * @author Leocarlos
 */
public class Usuario {
    
    String user;
    String pass;
    String nombre;

    public Usuario(String user, String pass,String nom) {
        this.user = user;
        this.pass = pass;
        this.nombre=nom;
    }
    
    public String mostrar(){
        
        String info=" \nnombre: "+nombre;
               info+="\n usuario: "+user;
               info+="\ncontraseña: "+pass;
               info+="\n";
               
      return info;
    }
    
}
