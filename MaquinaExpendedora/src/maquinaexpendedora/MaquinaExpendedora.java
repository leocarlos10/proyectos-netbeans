
package maquinaexpendedora;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
aun falta por agregar el ultimo punto del trabajo 
*/

public class MaquinaExpendedora {;;

    String nombresGolosinas[][];
    double precio[][];
    int cantidad[][];
    int fila,col;

    public MaquinaExpendedora() {
        
        fila=4;
        col=4;
        
        String[][] nombresG = {
        {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
        {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
        {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
        {"Lacasitos", "Crunch", "Milkybar", "KitKat"}

        };
        
          double[][] pre = {
        {1000, 200, 500, 950},
        {1800, 100, 120, 100},
        {1750, 130, 120, 800},
        {1500, 110, 720, 350}

        };
          
        int[][] cant = {
        {5, 5, 5, 5},
        {5, 5, 5, 5},
        {5, 5, 5, 5},
        {5, 5, 5, 5}

        };
        
       this.nombresGolosinas=nombresG;
       this.precio=pre;
       this.cantidad=cant;
        
    }
    
    public String menu_pedirgolosinas(){
        
        String info="""
                    Ingrese la posición de la golosina.
                    00:KitKat
                    01:chiles de fresa
                    02:Lacasitos
                    03:Palotes
                    10:Kinder Bueno
                    11:Bolsa varida Haribo
                    12:Chetoos
                    13:Twix
                    20:Kinder Bueno
                    21:M&M'S
                    22:Papa Delta
                    23:Chicles de menta
                    30:Lacasitos
                    31:Crunch
                    32:Milkybar
                    33KitKat
                    """;
        String posG=""; // posicion de la golosina

        posG= JOptionPane.showInputDialog(info);
        
        return posG;
    }
    
    
    public void pedirGolosinas(){
        String pos = menu_pedirgolosinas();
        
            String fil = "";
            String colum = "";

            /* 
        el metodo charAt divide la variable
       pos como si fuese un vector asi podemos almacenar el primer 
       numero en la variable fila y el segundo en la varible col
       para posterirmente poder buscar la posicion de la golosina 
       en la matriz
             */
           try {
            for (int i = 0; i < 2; i++) {

                if (i == 0) {
                    fil = String.valueOf(pos.charAt(i));
                } else if (i == 1) {

                    colum = String.valueOf(pos.charAt(i));
                }
            }

            // convertimos las variables a entero para poder ubicar la pos de la golosina
            int f = Integer.parseInt(fil);
            int c = Integer.parseInt(colum);

            if ((cantidad[f][c]) > 0) {

                cantidad[f][c]--;
                JOptionPane.showMessageDialog(null, "La golosina "+nombresGolosinas[f][c]+" fue adquirida correctamente ! "
                        + " quedan: " + cantidad[f][c]);

            } else {

                JOptionPane.showMessageDialog(null, " Lo sentimos la golosina que pidio esta agotada");
            }
        } catch (Exception e) {

             JOptionPane.showMessageDialog(null, "Error, por favor revise los datos de ingreso"); 
        }
    }
    
    public void rellenarGolosina(String pos,int c){
        
        String fil="";
        String colum="";
        
        for(int i=0;i<2;i++){
           
           if(i==0){
              fil= String.valueOf( pos.charAt(i));
           } else if(i==1){
               
               colum= String.valueOf( pos.charAt(i));
           }
       }

       int f1= Integer.parseInt(fil);
       int c1= Integer.parseInt(colum);
       
       cantidad[f1][c1]+=c;
       JOptionPane.showMessageDialog(null, " se han agregado "+c+" golosinas a la casilla "+nombresGolosinas[f1][c1]);
        
    }
    
    public boolean eliminarGolosina(String pos){
        String fil = "";
        String colum = "";
        int f =0;
        int c =0;
        Exception band=null;
        boolean band1=false;
        try {
            for (int i = 0; i < 2; i++) {

                if (i == 0) {
                    fil = String.valueOf(pos.charAt(i));
                } else if (i == 1) {

                    colum = String.valueOf(pos.charAt(i));
                }
            }

            // convertimos las variables a entero para poder ubicar la pos de la golosina
            f = Integer.parseInt(fil);
            c = Integer.parseInt(colum);
            
        } catch (Exception e) {
            band=e;
             JOptionPane.showMessageDialog(null, "Error, por favor revise los datos de ingreso");
             band1=false;
        }
        
        if(band==null){
            nombresGolosinas[f][c]="";
            precio[f][c]=0;
            cantidad[f][c]=0;
            band1=true;
        }
        return band1;
    }
    
    public void limpiarMaquina(){
        
        for(int i=0;i<fila;i++){
            
            for(int j=0;j<col;j++){
                
                nombresGolosinas[i][j]="";
                precio[i][j]=0;
                cantidad[i][j]=0;
            }
        }
    }
    
    public void limpiarJTable(JTable tabla){
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn(" Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        tabla.setModel(modelo);
    }
    
    
    public void setllenarJTable(JTable tabla){
        
        int i =0, j=0;
        int post=0;
        
        // creamos el modelo
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn(" Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        
        for( i=0;i<fila;i++){
            
            for( j=0;j<col;j++){
                
                modelo.addRow(new Object[] {"","",""});
                modelo.setValueAt(nombresGolosinas[i][j], post, 0);
                modelo.setValueAt(precio[i][j], post, 1);
                modelo.setValueAt(cantidad[i][j], post, 2);
                post++;
            }
        }
        tabla.setModel(modelo);
    }      
}
        
    
    
    
    


        
