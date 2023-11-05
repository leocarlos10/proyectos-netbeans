/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author USUARIO
 */
  public class Productos {
    private int codigoProducto[];
    private String nombreProducto[]; 
    private float precioProducto[]; 
    private int cantida[];
    private int tamano; 

    public void Productos(){ 
        codigoProducto = null; 
        nombreProducto = null; 
        precioProducto = null; 
        cantida = null;
        tamano = 0;
    }
        
    public void setTamano(int n){
        tamano = n;
    }
    
    public int getTamano(){
        return tamano;
    }
        
        
    public void crearVectores(){
        codigoProducto = new int[tamano]; 
        nombreProducto = new String[tamano]; 
        precioProducto = new float[tamano];
         cantida = new int[tamano];
    }

    public void setCodigoProducto(int p, int dato){
        codigoProducto[p] = dato;
    }
    
    public void setNombreProducto(int p, String dato){
        nombreProducto[p] = dato;
    }
    
    public void setPrecioProducto(int p, float dato){
        precioProducto[p] = dato;
    }
    
    public void setCantidad(int p, int dato){
        cantida[p] = dato;
    }

    public int getCodigoProducto(int p){
        return codigoProducto[p];
    }
    
    public String getNombreProducto(int p){
        return nombreProducto[p];
    }
    
    public float getPrecioProducto(int p){
        return precioProducto[p];
    }
    
    public int getCantidad(int p){
        return cantida[p];
    }
        
    public float mayorPrecio(){
        float mayor = getPrecioProducto(0); 
        for (int i=0; i<=getTamano()-1; i++){ 
            if (getPrecioProducto(i) > mayor){
                mayor = getPrecioProducto(i);
            }
        }
        return mayor;
    }
}


            
