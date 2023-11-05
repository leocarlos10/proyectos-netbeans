/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ruben
 */
public class miPersonal {
    // es mucho mejor si declaramos que la lista sea de tipo persona 
    // asi nos complicamos menos.
    
//  public ArrayList miLista;
    // este es otro tipo de arrayList donde utilizando gnericos podemos 
    // hacer que la lista solo guarde objetos de tipo persona y asi con cualquier tipo de datos.
    public List<persona> miLista;
    
    // cosntructor que inicializa la lista
    // obs en este tipo de listas no es necesario inicializarlas en 0 
    miPersonal(){ miLista = new ArrayList<>(); }
    
    // metodo que busca un ID repetido
    public int getBuscarId(int id){
        int i;
        persona aux=null;
        for(i=0; i<miLista.size(); i++){
            aux = miLista.get(i);
            if(aux.id == id)
                return i;
        }
        return -1;
    }
    
    // metodo que agrega un docente.
    public void setAddD() {
        // creamos las variables para los atributos del objeto docente.
        int id, edad, pos = -1;
        String noms, preg, post;
        try {
            do {
                id = Integer.parseInt(JOptionPane.showInputDialog(
                        "Entre Id Docente: "));
                pos = getBuscarId(id);
                if (pos != -1) {
                    JOptionPane.showMessageDialog(null,
                            "Error! El id ya esta registrado.  Intente nuevamente!");
                }
            } while (pos != -1);// mientras que el id se encuentre repetido.
            
            edad = Integer.parseInt(JOptionPane.showInputDialog(
                    "Entre edad del Docente: "));
            noms = JOptionPane.showInputDialog("Entre Nombres: ");
            preg = JOptionPane.showInputDialog("Entre Pregrado: ");
            post = JOptionPane.showInputDialog("Entre Postgrado: ");
            // se puede hacer asi
            docente miDoc = new docente(id, noms, edad, preg, post);
            miLista.add(miDoc);
            // o asi  miLista.add(new docente(id, noms, edad, preg, post)); esta es una forma muchos mas abreviada y ahora lineas de codigo.
            JOptionPane.showMessageDialog(null, "Nuevo docente registrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }
    
    public void setAddE() {
        int id, edad, sem=0, pos = -1;
        String noms, prog;
        try {
            do {
                id = Integer.parseInt(JOptionPane.showInputDialog(
                        "Entre Id Estudiante: "));
                pos = getBuscarId(id);
                if (pos != -1) {
                    JOptionPane.showMessageDialog(null,
                            "Error! El id ya esta registrado.  Intente nuevamente!");
                }
            } while (pos != -1);
            edad = Integer.parseInt(JOptionPane.showInputDialog(
                    "Entre edad del Estudiante: "));
            noms = JOptionPane.showInputDialog("Entre Nombres: ");
            prog = JOptionPane.showInputDialog("Entre Programa: ");
            sem = Integer.parseInt(JOptionPane.showInputDialog(
                "Entre Semestre: "));
            // mejor forma de agregar un estudiante a la lista
            miLista.add( new estudiante(id, noms, edad, prog, sem));
            JOptionPane.showMessageDialog(null, "Nuevo estudiante registrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }
    
    public void getTodos(){
        int i;
        docente auxd=null;
        estudiante auxe=null;
        persona aux=null;
        for(i=0; i<miLista.size(); i++){
            aux= miLista.get(i);
            if(aux.tipoPersona==1){
                auxd= (docente) miLista.get(i);
               JOptionPane.showMessageDialog(null, auxd.toString());
            }else{
                auxe=(estudiante) miLista.get(i);
               JOptionPane.showMessageDialog(null, auxe.toString());
            }   
        }
    }
}
