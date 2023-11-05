
package com.mycompany.Examen2;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MiTrabajador {
    
    Trabajador v[];
    int tamano;
    
    public MiTrabajador(){
        
        v= new Trabajador[2];
        tamano=0;
        for(int i=0;i<2;i++){
            
            v[i]= new Trabajador("","","","",0,"",0);
            
        }
    } 
    
    
     public MiTrabajador(int tam){
        
        v= new Trabajador[tam];
        tamano=tam;
        for(int i=0;i<tam;i++){
            
            v[i]= new Trabajador("","","","",0,"",0);
            
        }
    } 
    
     
     public int getBuscarCod(String codigo){
         
         for(int i=0;i<tamano;i++){
             
             if(v[i].getCodigo().equalsIgnoreCase(codigo))
                 return i;
         }
         // si no lo encuentra retorna negativo.
            return -1;
     }
     
     
     public boolean getCargarV(
             JTextField nom,
             String apellido,
             JTextField codigo,
             String dep,
             int ageT,
             String cargo,
             float salario,
             int i
     ){
         if(getBuscarCod(codigo.getText())!= -1){
             
             JOptionPane.showMessageDialog(null, " Lo sentimos el codigo que ingreso ya existe ");
             codigo.setText("");
             codigo.requestFocus();
             return false;
         }else{
             
             v[i]= new Trabajador(nom.getText(),apellido,codigo.getText(),dep,ageT,cargo,salario);
             return true;
             
         } 
     }
     
     
     public boolean eliminarTrabajador(String cod){
         
         for(int i=0;i<v.length;i++){
             
             if(v[i].getCodigo().equalsIgnoreCase(cod)){
               v[i] = new Trabajador("","","","",0,"",0);
               return true;
             } 
         }
         // si no encuentra el codigo retorna -1;
         return false;
     }
     
     public int TrabajadorM_salario(){
         
         int pos=0;
         float mayor=v[0].getSalario();
         for(int i=0;i<v.length;i++){
             
             if(v[i].getSalario()>mayor){
                 pos=i;
             }
         }
         return pos;
     }
     
     public int Trabajadorm_salario(){
         
         int pos=0;
         float menor=v[0].getSalario();
         for(int i=0;i<v.length;i++){
             
             if(v[i].getSalario()<menor){
                 pos=i;
             }
         }
         return pos; 
     }
     
     public float promedio(){
         
         float suma=0;
         float tam= (float) v.length;
         
         for(int i=0;i<v.length;i++){
             
             suma+=v[i].getSalario();
         }
         
         return suma/tam ;
     }
     
     public void trabajador_salario_m_pro(){
     
         for(Trabajador i:v){
             
             if(i.getSalario()<promedio()){
                 
                 i.mostrar("con salario menor al promedio");
             }
         }
     }
     
      public void trabajador_salario_M_pro(){
     
         for( Trabajador h:v){
             
             if(h.getSalario()>promedio()){
                 
                 h.mostrar(" con salario mayor al promedio");
             }
         }
     }
     
     
     
     public void cargarelementos(DefaultTableModel modelo,int posvec, int fila){
           
         modelo.setValueAt(v[posvec].getNombre(), fila, 0);
         modelo.setValueAt(v[posvec].getApellido(), fila, 1);
         modelo.setValueAt(v[posvec].getCodigo(), fila, 2);
         modelo.setValueAt(v[posvec].getDepartamento(), fila, 3);
         modelo.setValueAt(v[posvec].getAgeTrabajo(), fila, 4);
         modelo.setValueAt(v[posvec].getCargo(), fila, 5);
         modelo.setValueAt(v[posvec].getSalario(), fila, 6);
         
     }
     
      public void SetllenarJTable(JTable tabla){
          
          int posvec=0;
          int postabla=0;
          
          // cremaos el modelo
          DefaultTableModel modelo = new DefaultTableModel();
          
          // creamos las columnas del modelo.
          modelo.addColumn("Nombre");
          modelo.addColumn("Apelido");
          modelo.addColumn("Codigo");
          modelo.addColumn("Departamento");
          modelo.addColumn("Años de Trabajo");
          modelo.addColumn("Cargo");
          modelo.addColumn("Salario");
          
          while(posvec<v.length){
              
              modelo.addRow( new Object[] {"","","","","","",""});
              cargarelementos(modelo,posvec,postabla);
              posvec++;
              postabla++;
          }
          
          // actualizamos la tabla
          tabla.setModel(modelo);
      }
      
      public void mostrar(int pos) {
          
          String info= "Trabajador " +pos+ 
                "\n nombre: " + v[pos].getNombre() + 
                "\n apellido: " + v[pos].getApellido() + 
                "\n codigo: " + v[pos].getCodigo() + 
                "\n departamento: " + v[pos].getDepartamento() +
                "\n años de trabajo: " + v[pos].getAgeTrabajo() + 
                "\n cargo: " + v[pos].getCargo() + 
                "\n salario: " + v[pos].getSalario();
          
        JOptionPane.showMessageDialog(null,info);
    }
      
    public void mostrar(int pos, String inf) {
          
          String info= "Trabajador " +inf+ 
                "\n nombre: " + v[pos].getNombre() + 
                "\n apellido: " + v[pos].getApellido() + 
                "\n codigo: " + v[pos].getCodigo() + 
                "\n departamento: " + v[pos].getDepartamento() +
                "\n años de trabajo: " + v[pos].getAgeTrabajo() + 
                "\n cargo: " + v[pos].getCargo() + 
                "\n salario: " + v[pos].getSalario();
          
        JOptionPane.showMessageDialog(null,info);
    }
}
