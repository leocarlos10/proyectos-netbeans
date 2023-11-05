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
public class moto extends Vehiculo{
    String marca;

    public moto(String marca, String mat, String modelo) {
        super(mat, modelo, 1);
        this.marca = marca;
    }
    
}
