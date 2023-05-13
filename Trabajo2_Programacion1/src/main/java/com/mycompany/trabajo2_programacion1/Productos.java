
package com.mycompany.trabajo2_programacion1;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
*
*  Leocarlos Ospina y moises Doria
*/
/*
   Utilizando otro vector auxiliar, almacenar el valor total que cobrara 
   el supermercado por la venta cada producto en existencia.
   Se debe tener en cuenta el precio de cada producto y la cantidad en existencia.
   */

  public class Productos {
     int codigoProducto[];
     String nombreProducto[]; 
     float precioProducto[]; 
     int cantidad[];
     float total_pagar[];
     int tamaño;
    
    public  Productos(){ 
          codigoProducto = new int[2];
          nombreProducto = new String[2];
          precioProducto = new float[2];
          cantidad = new int[2];
          total_pagar = new float[2];
         
         for(int i=0;i<2;i++){
             
             codigoProducto[i]= 0;
             nombreProducto[i]="";
             precioProducto[i]=0;
             cantidad[i]=0;
             total_pagar[i]=0;
             
         }
    }

    public  Productos(JTextField tam){ 
        codigoProducto = new int[Integer.parseInt(tam.getText())];
        nombreProducto = new String[Integer.parseInt(tam.getText())];
        precioProducto = new float[Integer.parseInt(tam.getText())];
        cantidad = new int[Integer.parseInt(tam.getText())];
        total_pagar = new float[Integer.parseInt(tam.getText())];
         
         for(int i=0;i<codigoProducto.length;i++){
             
             codigoProducto[i]= 0;
             nombreProducto[i]="";
             precioProducto[i]=0;
             cantidad[i]=0;
             total_pagar[i] =0;
         }
         this.tamaño=Integer.parseInt(tam.getText());
    }
        
    public float mayorPrecio(){
        
        float mayor = precioProducto[0];
        for ( int i=0; i<precioProducto.length; i++){ 
            if (precioProducto[i] > mayor){
                mayor = precioProducto[i];
            }
        }
        return mayor;
    }
    
    public int getTamaño(){
        
        return tamaño;
    }
    
    public float menor_Precio(){
        
        float menor = precioProducto[0];
        for(int i=0;i<precioProducto.length;i++){
            
            if(precioProducto[i] < menor){
                menor= precioProducto[i];
            }
        }
        return menor;
    }
    
    // funcionalidad de busqueda de codigo agregada.
    
    public int getBusquedaC(int codigo){
        
        int inicio=0;
        int fin=codigoProducto.length-1;
        int pos;
        
        while(inicio<=fin){
            
            pos=((inicio+fin)/2);
            if(codigoProducto[pos]== codigo){
                
                return pos;
                
            } else if(codigoProducto[pos] < codigo){
                inicio=pos+1;
            } else if(codigoProducto[pos] > codigo){
                fin=pos-1;
            }
        }
        return -1;
    }
    
    
    public int getBusqueda_P(int p){
        int i;
        
        for(i=0;i<codigoProducto.length;i++){
            if( codigoProducto[i]==p){
                return i;
            }
        }
        
        return -1;
    }
    
    public boolean setAddinfo(
           JTextField jtcodigo, 
          String jtnombre,
           float jtprecio,
           int jtcantidad,
           int indice
    ){
      
      if(getBusqueda_P(Integer.parseInt(jtcodigo.getText()))!= -1){
          
          JOptionPane.showMessageDialog(null," El elemento que ha ingresado ya existe !!");
          jtcodigo.setText("");
          jtcodigo.requestFocus();
          // si retorna false quiere decir que no guardo los datos 
          return false;
      }else{
       
       codigoProducto[indice]=Integer.parseInt(jtcodigo.getText());
       nombreProducto[indice]= jtnombre;
       precioProducto[indice]= jtprecio;
       cantidad[indice]=jtcantidad;
       jtcodigo.requestFocus();
        return true;
      }
    }
    
    public void cargarElementos(DefaultTableModel modelo,int posvec,int fila ){
        
        modelo.setValueAt(codigoProducto[posvec], fila, 0);
        modelo.setValueAt(nombreProducto[posvec], fila, 1);
        modelo.setValueAt(precioProducto[posvec], fila, 2);
        modelo.setValueAt(cantidad[posvec], fila, 3);
        modelo.setValueAt(total_pagar[posvec], fila, 4);
    }
    
    public void setllenarJTable(JTable tabla){
        
        int posvec=0; // indice para moverme en el vector
        int posfilat=0; // indice para moverme en la fila del JTable
       
        
        // creamos el modelo.
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Total a pagar");
        
        while(posvec<codigoProducto.length){
            
            // creamos una nueva fila para agregar los datos.
            modelo.addRow( new Object[] {"","","","",""});
            cargarElementos(modelo,posvec,posfilat);
            posvec++;
            posfilat++;
        }
        // mandamos la tabla
        tabla.setModel(modelo);
    }
    
   public void Mostrar_Informe(){
       
       String info=" Los nombres que cumplen con las condiciones son: \n";
       boolean band=false;
       
       for(int i=0;i<nombreProducto.length;i++){
           
           if(precioProducto[i]>2500 && cantidad[i]<5){
               info+=nombreProducto[i]+"\n";
               band=true;
           }
       }
       
       if(band==false){
       JOptionPane.showMessageDialog(null," Lo sentimos!. No se han encontrado productos que cumplan con las condiciones dadas");
       }else{
       JOptionPane.showMessageDialog(null,info);
       }
   }
   
   // metodo para calcular el total a pagar al supermercado
   public float calcTotal_p(){
       
       float total=0;
       
       for(int i=0;i<getTamaño();i++){
           
          total+=(precioProducto[i]*cantidad[i]);
          
       }
       return total;
   }
   
   public void llenar_vTotal_pagar(){
       
       int i=0;
       total_pagar[i]=calcTotal_p();
       i++;
   }
   
    public void MostrarInfo(int indice){
        
        String info= " Los datos del producto solicitado son: \n";
        info+= " Codigo: "+codigoProducto[indice]+"\n";
        info+= " Nombre: "+nombreProducto[indice]+"\n";
        info+= " Precio: "+precioProducto[indice]+"\n";
        info+= " Cantidad:"+cantidad[indice]+"\n";
        JOptionPane.showMessageDialog(null, info);
        
    
    }
}


            
