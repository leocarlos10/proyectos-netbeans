
package com.mycompany.examen_01;

import javax.swing.JOptionPane;



public class Planeta {
    
    private  String nombre;
             int cantidad_satelites;
             double masa;
             double volumen;
             int diametro;
             int distancia;
             enum tipo_Planeta{};
             boolean observable_vista;

    public Planeta() {
        nombre ="";
        cantidad_satelites = 0;
        masa = 0;
        volumen = 0;
        diametro = 0;
        distancia = 0;
        tipo_Planeta gaseoso,terrestre,enano;
        observable_vista = false;
    }
    
    public void setDatos(String nom, int c_satelites, double m,double v,int d,int dis, boolean obs){
    
        nombre=nom;
        cantidad_satelites=c_satelites;
        masa=m;
        volumen=v;
        diametro=d;
        distancia=dis;
        observable_vista=obs;

    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad_satelites() {
        return cantidad_satelites;
    }

    public double getMasa() {
        return masa;
    }

    public double getVolumen() {
        return volumen;
    }

    public int getDiametro() {
        return diametro;
    }

    public int getDistancia() {
        return distancia;
    }

    public boolean isObservable_vista() {
        return observable_vista;
    }
    
    
    @Override
    public String toString(){
    
        return "nombre: "+nombre+"\n"+"cantidad de satelites: " +cantidad_satelites+"\n"+"Masa: "+masa+"\n"+"Volumen: " +volumen 
                +"\n"+ "diametro: "+diametro+"\n"+"distancia: "+distancia +"\n"+"es observanle? "+observable_vista;
    }
    
    
    
    
    public double densidad(){
    
        double den=0;
        
        try{
        den= masa/volumen; // si llega a ver una division con cero no se rompa el programa.
        
        }catch(ArithmeticException e){
            
            JOptionPane.showMessageDialog(null, e);
        
        }
        
    return den;
    }
    
      //  2.1 ua = 314155440.22 kilometros 3.4 ua= 508632617.5 Kilómetros
    
     public String ver_Planeta_exterior(){
     
         String estado="";
         
         if(distancia<314155440.22 || (distancia>=314155440.22 && distancia<=508632617.5))
             estado="no se considera exterior";
         else if(distancia>508632617.5)
             estado="si se considera exterior";
        
         return estado;
         
     }
             
             
     
             
    
}
