
package maquinaexpendedora;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MaquinaExpendedora {

     String[][] nombresGolosinas = {
        {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
        {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
        {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
        {"Lacasitos", "Crunch", "Milkybar", "KitKat"}

    };

    double[][] precio = {
        {1000, 200, 500, 950},
        {1800, 100, 120, 100},
        {1750, 130, 120, 800},
        {1500, 110, 720, 350}

    };

    int[][] cantidad = {
        {5, 5, 5, 5},
        {5, 5, 5, 5},
        {5, 5, 5, 5},
        {5, 5, 5, 5}

    };    
  
    
    public void CargarDatos(DefaultTableModel modelo, int pfila,int pcol, int post){
        
        modelo.setValueAt(nombresGolosinas[pfila][pcol], post, 0);
        modelo.setValueAt(precio[pfila][pcol], post, 1);
        modelo.setValueAt(cantidad[pfila][pcol], post, 2);
    }
    
    
    public void setllenarJTable(JTable tabla){
        
        int pf =0, pcol=0;
        int post=0;
        
        // creamos el modelo
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn(" Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        
        while(pf<4){
            for(int i=0;i<4;i++){
                modelo.addRow(new Object[] {"","",""});
                CargarDatos(modelo,pf,pcol,post);
                pcol++;
                post++;
            }
            pf++;
        }
        
    }
    
    
    
}

        
