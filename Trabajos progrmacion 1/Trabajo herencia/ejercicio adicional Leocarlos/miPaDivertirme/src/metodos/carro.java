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
public class carro extends Vehiculo{
    int nPuestos;

    public carro(int nPuestos, String mat, String modelo) {
        super(mat, modelo, 0);
        this.nPuestos = nPuestos;
    }
    
}
