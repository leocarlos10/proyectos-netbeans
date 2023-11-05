/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase_programacion;

import javax.swing.JOptionPane;

/**
 *
 * @author Leocarlos 
 * esta seria la estructura del nodo
 */
public class Nodo {
    //-Informacion.-
    String id;
    String noms;
    float KmR;
    //-Puntero-
    Nodo sig;

    // un constructor(que no contiene al puntero)
    public Nodo(String id, String noms, float KmR) {
        this.id = id;
        this.noms = noms;
        this.KmR = KmR;
    }
    
    // mostrar.
    public void getMostrarNodo(){
        
        JOptionPane.showMessageDialog(null, 
                "id=" + id +
                "\n noms=" + noms + 
                "\n KmR=" + KmR);
    }
    
}
