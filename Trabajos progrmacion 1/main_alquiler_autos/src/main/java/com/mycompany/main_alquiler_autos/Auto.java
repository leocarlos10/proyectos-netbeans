
package com.mycompany.main_alquiler_autos;

import javax.swing.JOptionPane;


public class Auto {
    
    private String placa;
            int Dias_ult_mantenimiento;
            boolean tiene_seguro;
            
      public Auto(String p,int d,boolean t){
      
          placa=p; Dias_ult_mantenimiento=d; tiene_seguro=t;
          
      }
      
      public String getPlaca(){
      
          return placa;
      }
      
      public int getDia_ult_mantenimiento(){
      
          return Dias_ult_mantenimiento;
      }
      
      public boolean getTiene_seguro(){
      
          return tiene_seguro;
      }
      
      public boolean nececita_mantenimiento(){
      
          if(Dias_ult_mantenimiento>20){
          
              return true;
          }
          else{
          
              return false;
          }  
      }
      
      public boolean sepuderentar(){
      
          if(tiene_seguro==true && nececita_mantenimiento()==false){
          
              return true;
          }
          else{
          
              return false;
          }
      }
      
      public String mostrar(){
      
          return "el auto necesita mantenimiento ? "+"= "+nececita_mantenimiento()+"\n el auto se puede rentar"+" = "+sepuderentar();
          
      }
      
    
}
