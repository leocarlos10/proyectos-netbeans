/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginjavafx.models.com;


/**
 *
 * @author Leocarlos
 */
public class Usuario {
    
    private String id;
    private String user;
    private String pass;
    private String nombre;
    
    public Usuario(){}

    public Usuario(String user, String pass,String nom) {
        this.user = user;
        this.pass = pass;
        this.nombre=nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public String mostrar(){
        
        String info=" \nnombre: "+nombre;
               info+="\n usuario: "+user;
               info+="\ncontraseña: "+pass;
               info+="\n";
               
      return info;
    }
}
