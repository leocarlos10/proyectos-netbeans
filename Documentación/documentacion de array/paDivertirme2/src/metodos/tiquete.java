/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class tiquete {
    
    //Atributos
    String id;
    String noms;
    float ckm;
    float vkm;
    float costo;

    //Método Constructor
    public tiquete(String id, String noms, float ckm, float vkm) {
        this.id = id;
        this.noms = noms;
        this.ckm = ckm;
        this.vkm = vkm;
        costo = ckm * vkm;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }
    
    public void setCalcularCosto(){
        costo=ckm*vkm;
    }

    public float getCkm() {
        return ckm;
    }

    public void setCkm(float ckm) {
        this.ckm = ckm;
    }

    public float getVkm() {
        return vkm;
    }

    public void setVkm(float vkm) {
        this.vkm = vkm;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void m_Tiquete(){
        String info="La información del tiquete es: \n";
        info += "IdPasajero: "+id+"\n";
        info += "Nombres: "+noms+"\n";
        info += "Cantidad Kilometros a recorrer: "+ckm+"\n";
        info += "Valor por Kilometro: "+vkm+"\n";
        info += "Total recorrido a pagar: "+costo+"\n";
        JOptionPane.showMessageDialog(null, info);
    }
    
}
