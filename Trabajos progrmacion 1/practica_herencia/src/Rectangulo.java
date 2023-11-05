/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class Rectangulo extends Poligonos {
    
    protected double base,altura;
    
    Rectangulo( double base, double altura){
        super(3,1);
        this.base=base; this.altura=altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
//    @Override
//    public double area(){
//        return base*altura;
//    }
//    
//    @Override
//    public String toString(){
//        
//        return super.toString()+" \n La base del rectangulo: "+ base+"\n La altura del rectangulo: "+altura;
//    }
 }
