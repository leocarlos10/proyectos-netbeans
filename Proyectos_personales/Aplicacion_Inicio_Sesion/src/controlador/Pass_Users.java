/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author USUARIO
 */
public class Pass_Users {
    
     String sitio;
     String user;
     String pass;
     int id_usuario;
     
      public Pass_Users(){}
     
     public Pass_Users(String user,String pass){
         
         this.user = user;
         this.pass = pass;
     }

    public Pass_Users(String sitio,String user, String pass,int id_usuario) {
        
        this.sitio=sitio;
        this.user = user;
        this.pass = pass;
        this.id_usuario=id_usuario;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id) {
        this.id_usuario = id;
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
}
