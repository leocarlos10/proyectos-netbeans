
import javax.swing.JOptionPane;
import javax.swing.*;

    public class MisProductos  {

        Producto p[];

        public int verf_id(String cod){

            for(int i=0;i<p.length;i++){

                if(p[i].id.equals(cod)){

                    return i;
                }
            }
                return -1;
        }
        
        
        
        public void llenar_arreglo(){

                int tamaño=Integer.parseInt(JOptionPane.showInputDialog(" Ingrese cuantos productos desea ingresar"));
                String nom=""; float precio=0; String id=""; int post=0;

                p=new Producto[tamaño];

                for(int i=0;i<p.length;i++){
                    // verificando que el usuario no ingrese un producto ya existente.

                    do{

                        id=JOptionPane.showInputDialog("ingrese el id del producto ");
                       post= verf_id(id);
                        if (post>= 0) {

                            JOptionPane.showMessageDialog(null, " Error el producto que desea ingresar ya existe porfavor ingrese uno diferente");
                        }

                    }while(post>=0);
                    
                    nom=JOptionPane.showInputDialog("ingrese el nombre del producto");
                 
                 p[i]=new Producto(nom,id,precio);
                 
                }
            }
        
        
        public void actualizarList(JList lista){
            
            ListModel<Producto> modelo = new DefaultListModel<>(p);
            
            lista = new JList<>(modelo);
           
        }
        
        
        
        public float suma_pre(){
        
            float sum=0;
            
            for(int i=0;i<p.length;i++){
                
                sum+=p[i].precio;
            
            }
            return sum;
        }
        
        
        
         public float promedio_precio(){
             
             float total=(float) p.length;
             float prom=0;
             
             return suma_pre()/total;
             
         }
         
       // ahora ya solo queda unir el objeto con el JFrame.
         
      }
