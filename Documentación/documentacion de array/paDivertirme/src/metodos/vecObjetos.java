 
package metodos;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class vecObjetos {
    productos miVector[];
    
    public vecObjetos(
            JTextField jtfNElem
    ){
        int i;
        miVector = new productos[Integer.parseInt(
        jtfNElem.getText())];
        for(i=0; i<miVector.length; i++){
            miVector[i] = new productos("", "", 0);
        }
    }
    
    public int getBuscarCod(String cod){
        int i;
        for(i=0; i<miVector.length; i++){
            if((miVector[i].cod).equals(cod)==true)
                return i;
        }
        return -1;
    }
    
    public void setEliminarDato(String codP){
        int pos=getBuscarCod(codP);
        if(pos!=-1){
            miVector[pos].cod="";
            miVector[pos].nomP="";
            miVector[pos].precio=0;
            JOptionPane.showMessageDialog(null,
                "Elemento borrado!!!");
        }
    }
    
    public void setModificarDato(int pos, 
        String codg, String nom, float costo){
        miVector[pos].cod=codg;
        miVector[pos].nomP=nom;
        miVector[pos].precio=costo;
        JOptionPane.showMessageDialog(null,
            "Elemento modificado!!!");
    }
    
    public boolean setAddInfo(
        JTextField jtfCodP,
        JTextField jtfNomP,
        JTextField jtfCosto,      
        int indice        
    ){        
        if(getBuscarCod(jtfCodP.getText())!=-1){
            JOptionPane.showMessageDialog(null,
                "El código del producto ya se encuentra "
                + "registrado!  Intente nuevamente.");
            jtfCodP.setText(""); // limpia el JTexfield y ademas vuelve a dejar el cursor hay para que el usuario digite otro codigo.
            jtfCodP.requestFocus(); // <--
            return false; // retorna falso lo que quiere decir que los datos nose guardaron 
        }else{                                                      
            miVector[indice].cod = jtfCodP.getText();
            miVector[indice].nomP = jtfNomP.getText();
            miVector[indice].precio = Float.parseFloat( 
                jtfCosto.getText());
            jtfCodP.setText("");            // luego de agregar los elementos a el vector limpia los JTexField 
            jtfNomP.setText("");
            jtfCosto.setText("");
            jtfCodP.requestFocus(); // y deja el cursor en el primer JTextField que seria el de el cod del producto.
            return true; // returna true para saber si los datos se cargaron correctamente.          
        }
    }
    
    //Método de ordenamiento ascendente
    //utilizando la técnica de burbuja
    public void setOrdenarB(){
        int i, j;
        productos temp=new productos("", "", 0);
        for(i=0; i<miVector.length; i++){
            for(j=0; j<(miVector.length-1); j++){
                if((miVector[j].cod).compareTo(miVector[j+1].cod)>0){
                    //Se guardan los datos de la posición
                    //siguiente en una variable temporal
                    temp.cod = miVector[j+1].cod;
                    temp.nomP = miVector[j+1].nomP;
                    temp.precio = miVector[j+1].precio;
                    //Se reemplazan los valores de la posición
                    //por la posición anterior
                    miVector[j+1].cod = miVector[j].cod;
                    miVector[j+1].nomP = miVector[j].nomP;
                    miVector[j+1].precio = miVector[j].precio;
                    //A la posición anterior le asigno los datos
                    //de la posición siguiente que estan en la 
                    //variable temporal
                    miVector[j].cod = temp.cod;
                    miVector[j].nomP = temp.nomP;
                    miVector[j].precio = temp.precio;
                }
            }
        }
    }
    
    //Este método registra un dato al JTable
    //teniendo en cuenta el tipo de Persona
    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
        int pFila, int pVec){
        
        miModelo.setValueAt(miVector[pVec].cod, pFila, 0);
        miModelo.setValueAt(miVector[pVec].nomP, pFila, 1);
        miModelo.setValueAt(miVector[pVec].precio, pFila, 2);
    }    
    
    //Este método actualiza el contenido de la fila
    //de un JTable a partir de su modelo de datos 
    //(JTableModel)
    public void setLlenarJTable(JTable tab){
        int posTabla=0; //Este índice recorre los elementos de la fila Tabla
        int posVec=0;  //Este índice para ubicar posición del vector
        DefaultTableModel miModelo=new DefaultTableModel();
        miModelo.addColumn("Código del Producto"); // esto es para agregarle el nombre a las columnas de el JTable.
        miModelo.addColumn("Nombre del Producto");
        miModelo.addColumn("Precio del Producto");        
        while(posVec<miVector.length){                        
            miModelo.addRow(new Object[]{"", "", ""});  // esto es para agregar una nueva fila a el JTable y asi poder actualizar la tabla con los datos.          
            setRegistrarFilaJTable(miModelo,posTabla,posVec);            
            posVec++;
            posTabla++;
        }
        tab.setModel(miModelo);
    }
    
    public float getSumaPrecio(){
        int i;
        float sum=0;
        for(i=0; i<miVector.length; i++){
            sum += miVector[i].precio;
        }
        return sum;
    }
    
    public float getPromedioPrecio(){
        return getSumaPrecio()/miVector.length;
    }
    
    public int getPosMenorPrecio(){
        int i, posM=0;
        float menP=miVector[0].precio;
        for(i=0; i<miVector.length; i++){
            if(miVector[i].precio <= menP){
                menP = miVector[i].precio;
                posM=i;
            }
        }
        return posM;
    }
    
    public int getPosMayorPrecio(){
        int i, posMay=0;
        float mayP=miVector[0].precio;
        for(i=0; i<miVector.length; i++){
            if(miVector[i].precio >= mayP){
                mayP = miVector[i].precio;
                posMay=i;
            }
        }
        return posMay;
    }
    
    //Mostrar en pantalla un producto dada una posición
    public void getInfoPos(int pos){
        String aux="Información del producto en la "
                + "posición: "+pos+"\n";
        aux += "Código: "+miVector[pos].cod+"\n";
        aux += "Nombre: "+miVector[pos].nomP+"\n";
        aux += "Precio: "+miVector[pos].precio+"\n";
        JOptionPane.showMessageDialog(null, aux);
    }
    
    //Reporte de productos mayores de 500
    public void getReporteMay500(){
        int i;
        for(i=0; i<miVector.length; i++){
            if(miVector[i].precio > 500)
                getInfoPos(i);
        }
    }
}
