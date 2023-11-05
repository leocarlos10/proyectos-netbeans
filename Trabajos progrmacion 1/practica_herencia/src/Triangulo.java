/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leo
 */
public class Triangulo extends Poligonos {
    
    protected double base, lado2,lado3;
    
    Triangulo(double b, double l2, double l3 ){  
        super(3,0);
        base=b; lado2=l2; lado3=l3; 
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    
//    @Override
//    public double area(){
//        double p=(base+lado2+lado3) /2;
//        return Math.sqrt(p*(p-base)*(p-lado2)*(p-lado3));
//    }
//    
//    @Override
//    public String toString(){
//        
//        return super.toString()+"\n La base del triangulo es de: "+ base+" \nLos lados del triangulo son de: "+lado2+" "+lado3;
//    }
    
}
