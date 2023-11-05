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
public class estudiante extends persona{
    protected String prog;
    protected int sem;

    public estudiante(int id, String noms, int edad, String prog, int sem) {
        super(id, noms, edad, 2);
        this.prog = prog;
        this.sem = sem;
    }

    public String getProg() {
        return prog;
    }
    
    @Override
    public void getMostrar(){
        String info="Los datos del estudiante son: \n";
        info += "Id: "+id+"\n";
        info += "Nombres: "+noms+"\n";
        info += "Edad: "+edad+"\n";
        info += "Programa: "+prog+"\n";
        info += "Semestre: "+sem+"\n";
        JOptionPane.showMessageDialog(null, info);
    }
    // otra forma de mostrar los datos sin tener que escribir de nuevo los datos de persona
    @Override
    public String toString(){
        String inf=super.toString();
        inf += "Programa: "+prog+"\n";
        inf += "Semestre: "+sem+"\n";
        return inf;
    }

    public int getSem() {
        return sem;
    }

    public void setProg(String prog) {
        this.prog = prog;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }
    
    
}
