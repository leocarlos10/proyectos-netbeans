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
public class docente extends persona{
   // atributos respectivos de la clase docente
    String preg;
    String post;

    public docente(int id, String noms, int edad, String preg, String post) {
        // super palabra reservada para poder heredar los atributos de la clase persona.
        super(id, noms, edad, 1);
        this.preg = preg;
        this.post = post;
    }

    public String getPreg() {
        return preg;
    }

    public String getPost() {
        return post;
    }
    
    // getMostrar es un metodo que esta sobre escribiendo el metodo que esta en la clase persona.
    @Override
    public void getMostrar(){
        String info="Los datos del docente son: \n";
        info += "Id: "+id+"\n";
        info += "Nombres: "+noms+"\n";
        info += "Edad: "+edad+"\n";
        info += "Pregrado: "+preg+"\n";
        info += "Postgrado: "+post+"\n";
        JOptionPane.showMessageDialog(null, info);
    }
    
    @Override
    public String toString(){
        String info=super.toString();
        info += "Pregrado: "+preg+"\n";
        info += "Postgrado: "+post+"\n";
        
        return info;
    }

    public void setPreg(String preg) {
        this.preg = preg;
    }

    public void setPost(String post) {
        this.post = post;
    }
    
}
