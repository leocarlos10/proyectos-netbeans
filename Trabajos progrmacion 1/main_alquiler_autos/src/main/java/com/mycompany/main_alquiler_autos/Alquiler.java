
package com.mycompany.main_alquiler_autos;

import java.util.List;




public class Alquiler {
    
    private Cliente cliente;
            Auto auto;
            int horas_alquiler;
            
      
      public Alquiler(Cliente cli,Auto Au,int h){

      cliente=cli;
       auto =Au;
       horas_alquiler=h;
      
   }
      
      public Cliente getCliente(){
      
          return cliente;
      }
      
      public Auto getAuto(){
      
          return auto;
      }
      
     
      
      public int getHoras_Alquiler(){
      
          return horas_alquiler;
      }
      
      public int obtener_Descuento(List<Alquiler> alquiler){
          
          int descuento=0;
      
          for(int i=0;i<alquiler.size();i++){
          
              if(alquiler.get(i).getAuto().nececita_mantenimiento()==true || alquiler.get(i).getAuto().sepuderentar()==false){
              
                  descuento=0;
                  
              }
              else{
              
                  if(alquiler.get(i).getHoras_Alquiler()<=20){
                  
                      descuento= 0;
                  }
                  else if(alquiler.get(i).getHoras_Alquiler()>20 && alquiler.get(i).getHoras_Alquiler()<=50 ){
                  
                      descuento= 2;
                  } 
                  else if(alquiler.get(i).getHoras_Alquiler()>=50){
                  
                      descuento= 5;
                 
                  }
                  
              }
              
          }
         return descuento;
      }
    
      public String mostrar(List<Alquiler> alquiler){
      
          return getCliente().mostrar()+"\n"+getAuto().mostrar()+"\n"+"El descuento es de "+obtener_Descuento(alquiler);
      }
}
