/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;
import javax.swing.JOptionPane;
/**
 *
 * @author Ruben
 */
public class computador {
    //Atributos
    private int id;
    private int nRAM;
    private int cSSD;
    private String nProc;
    
    //Constructor
    public computador(int id, int nRAM, int cSSD, String nProc) {
        this.id = id;
        this.nRAM = nRAM;
        this.cSSD = cSSD;
        this.nProc = nProc;
    }
    
   
    
    //Métodos Analizadores
    public int getId() {
        return id;
    }

    public int getnRAM() {
        return nRAM;
    }

    public int getcSSD() {
        return cSSD;
    }

    public String getnProc() {
        return nProc;
    }
    
    public void getMostrar(){
        String info="Los datos del computador son: \n";
        info += "idComputador    : "+id+"\n";
        info += "Tamaño RAM      : "+nRAM+"\n";
        info += "Capacidad SSD   : "+cSSD+"\n";
        info += "Marca procesador: "+nProc+"\n";
        JOptionPane.showMessageDialog(null, info);
    }
    
    //Modificadores
    public void setId(int id) {
        this.id = id;
    }

    public void setnRAM(int nRAM) {
        this.nRAM = nRAM;
    }

    public void setcSSD(int cSSD) {
        this.cSSD = cSSD;
    }

    public void setnProc(String nProc) {
        this.nProc = nProc;
    }
    
}
