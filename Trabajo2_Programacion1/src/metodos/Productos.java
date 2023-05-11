
package metodos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
*
*  Leocarlos Ospina y moises Doria
*/

  public class Productos {
     int codigoProducto[];
     String nombreProducto[]; 
     float precioProducto[]; 
     int cantidad[];
    
      public  Productos(){ 
       codigoProducto = new int [2]; 
        nombreProducto = new String[2];
        precioProducto = new float[2];
         cantidad = new int[2];
         
         for(int i=0;i<2;i++){
             
             codigoProducto[i]= 0;
             nombreProducto[i]="";
             precioProducto[i]=0;
             cantidad[i]=0;
             
         }
    }

    public  Productos(JTextField tam){ 
       codigoProducto = new int[Integer.parseInt(tam.getText())]; 
        nombreProducto = new String[Integer.parseInt(tam.getText())];
        precioProducto = new float[Integer.parseInt(tam.getText())];
         cantidad = new int[Integer.parseInt(tam.getText())];
         
         for(int i=0;i<codigoProducto.length;i++){
             
             codigoProducto[i]= 0;
             nombreProducto[i]="";
             precioProducto[i]=0;
             cantidad[i]=0;
             
         }
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
        
        while(posvec<codigoProducto.length){
            
            // creamos una nueva fila para agregar los datos.
            modelo.addRow( new Object[] {"","","",""});
            cargarElementos(modelo,posvec,posfilat);
            posvec++;
            posfilat++;
        }
        // mandamos la tabla
        tabla.setModel(modelo);
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


            
