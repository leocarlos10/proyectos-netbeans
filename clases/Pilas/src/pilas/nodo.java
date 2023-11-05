/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;
import javax.swing.JOptionPane;
/**
 *
 * @author Leocarlos
 */
public class nodo {
    
    String idTiq;
    String ciudadD;
    float valorT;
    nodo sig;

    public nodo(String idTiq, String ciudadD, float valorT) {
        this.idTiq = idTiq;
        this.ciudadD = ciudadD;
        this.valorT = valorT;
    }
    
    
    public void mostrar() {
        
        JOptionPane.showMessageDialog(null,
                "La informacion del nodo es: \n"
                        +"idTiq=" + idTiq 
                        + "\n ciudadD="+ ciudadD 
                        + "\n valorT=" + valorT); 
    }
}
