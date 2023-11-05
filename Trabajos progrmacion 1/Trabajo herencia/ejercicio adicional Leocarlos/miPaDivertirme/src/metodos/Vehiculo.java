/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author ruben
 * colaborador: leocarlos
 */
public class Vehiculo {
    protected String mat;
    protected String modelo;
    protected int tipoV;

    public Vehiculo(String mat, String modelo, int tv) {
        this.mat = mat;
        this.modelo = modelo;
        tipoV = tv;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public int getTipoV() {
        return tipoV;
    }

    public void setTipoV(int tv) {
        this.tipoV = tv;
    }
    
}
