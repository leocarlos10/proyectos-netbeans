
package com.mycompany.main_alquiler_autos;


public class Cliente {
    
    private String cedula,nombre;
             int edad;
             
   
    public Cliente(String ce,String nom,int ed){
    
         cedula=ce; nombre=nom; edad=ed;
        
        
    }
    
    
    public String getCedula(){
    
        return cedula;
    }
    
    public int getEdad(){
    
        return edad;
    }
    
    public String getNombre(){
    
        return nombre;
    }
    
    public String mostrar(){
        
        return "nombre: "+getNombre()+"\n cedula: "+getCedula()+"\n edad: "+ getEdad();
    
    }
             
    
}
