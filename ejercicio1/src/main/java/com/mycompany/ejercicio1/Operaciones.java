
package com.mycompany.ejercicio1;

import javax.swing.JOptionPane;


public class Operaciones {
    
    private double numero1, numero2;

    public Operaciones() {

        numero1 = 0;
        numero2 = 0;

    }

    public void setDatos(double n1, double n2) {

        numero1 = n1;
        numero2 = n2;

    }

    public double getNumero1(){

        return numero1;
    }

    public double getNumero2(){

        return numero2;
    }

    public double suma(){

        return numero1 + numero2 ;

    }

    public double resta(){

        return numero1 - numero2;
    }

    public double mult(){

        return numero1 * numero2;

    }

    public double division(){
        double div =0;

        try{ // por si se  llega a dividir entre 0 no se rompa el programa

            div =numero1 / numero2;

        } catch(ArithmeticException e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return div;
    }
    
}
