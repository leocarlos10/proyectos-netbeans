
package metodos;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class vectorT {
    
    //Atributos
    tiquete misTiquetes[];
    int tam;
    
    public vectorT(){
        misTiquetes = new tiquete[2];
        int i;
        for(i=0; i<misTiquetes.length; i++){
            misTiquetes[i] = new tiquete("", "", 0, 0);
        }
    }
    
    public vectorT(
            JTextField jtfNElem
    ){
        int i;
        misTiquetes = new tiquete[Integer.parseInt(
        jtfNElem.getText())];
        for(i=0; i<misTiquetes.length; i++){
            misTiquetes[i] = new tiquete("", "", 0, 0);
        }
        JOptionPane.showMessageDialog(null, "Vector creado!");
    }
    
    int getPosId(String id){
        int i;
        for(i=0; i<misTiquetes.length; i++){
            if((misTiquetes[i].id).equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
    
    public boolean setAddInfo(
        JTextField jtfid,
        JTextField jtfNom,
        JTextField jtfCkm,
        JTextField jtfVkm,     
        int indice        
    ){        
        if(getPosId(jtfid.getText())!=-1){
            JOptionPane.showMessageDialog(null,
                "El idPasajero ya se encuentra "
                + "registrado!  Intente nuevamente.");
            jtfid.setText("");
            jtfid.requestFocus(); 
            return false;
        }else{                                                      
            misTiquetes[indice].id = jtfid.getText();
            misTiquetes[indice].noms = jtfNom.getText();
            misTiquetes[indice].ckm = Float.parseFloat( 
                jtfCkm.getText());
            misTiquetes[indice].vkm = Float.parseFloat( 
                jtfVkm.getText());
            misTiquetes[indice].setCalcularCosto();
            jtfid.setText("");
            jtfNom.setText("");
            jtfCkm.setText("");
            jtfVkm.setText("");
            jtfid.requestFocus(); 
            return true;           
        }
    } 
    
    //Método de ordenamiento ascendente
    //utilizando la técnica de burbuja
    public void setOrdenarB(){
        int i, j;
        tiquete temp=new tiquete("", "", 0, 0);
        for(i=0; i<misTiquetes.length; i++){
            for(j=0; j<(misTiquetes.length-1); j++){
                if((misTiquetes[j].id).compareTo(misTiquetes[j+1].id)>0){
                    //Se guardan los datos de la posición
                    //siguiente en una variable temporal
                    temp.id = misTiquetes[j+1].id;
                    temp.noms = misTiquetes[j+1].noms;
                    temp.ckm = misTiquetes[j+1].ckm;
                    temp.vkm = misTiquetes[j+1].vkm;
                    temp.costo = misTiquetes[j+1].costo;
                    //Se reemplazan los valores de la posición
                    //por la posición anterior
                    misTiquetes[j+1].id = misTiquetes[j].id;
                    misTiquetes[j+1].noms = misTiquetes[j].noms;
                    misTiquetes[j+1].ckm = misTiquetes[j].ckm;
                    misTiquetes[j+1].vkm = misTiquetes[j].vkm;
                    misTiquetes[j+1].costo = misTiquetes[j].costo;
                    //A la posición anterior le asigno los datos
                    //de la posición siguiente que estan en la 
                    //variable temporal
                    misTiquetes[j].id = temp.id;
                    misTiquetes[j].noms = temp.noms;
                    misTiquetes[j].ckm = temp.ckm;
                    misTiquetes[j].vkm = temp.vkm;
                    misTiquetes[j].costo = temp.costo;
                }
            }
        }
    }
    
    //Este método registra un dato al JTable
    //teniendo en cuenta el tipo de Persona
    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
        int pFila, int pVec){
        
        miModelo.setValueAt(misTiquetes[pVec].id, pFila, 0);
        miModelo.setValueAt(misTiquetes[pVec].noms, pFila, 1);
        miModelo.setValueAt(misTiquetes[pVec].ckm, pFila, 2);
        miModelo.setValueAt(misTiquetes[pVec].vkm, pFila, 3);
        miModelo.setValueAt(misTiquetes[pVec].costo, pFila, 4);
    }    
    
    //Este método actualiza el contenido de la fila
    //de un JTable a partir de su modelo de datos 
    //(JTableModel)
    public void setLlenarJTable(JTable tab){
        int posTabla=0; //Este índice recorre los elementos de la fila Tabla
        int posVec=0;  //Este índice para ubicar posición del vector
        DefaultTableModel miModelo=new DefaultTableModel();

        miModelo.addColumn("idPasajero");
        miModelo.addColumn("Nombre Pasajero");
        miModelo.addColumn("Kilometros recorridos");  
        miModelo.addColumn("Valor por kilometro");
        miModelo.addColumn("Costo del recorrido");
        while(posVec<misTiquetes.length){                        
            miModelo.addRow(new Object[]{"", "", "", "", ""});              
            setRegistrarFilaJTable(miModelo,posTabla,posVec);            
            posVec++;
            posTabla++;
        }
        tab.setModel(miModelo);
    } 
    
    //Método de búsqueda binaria, es requisito 
    //que el vector este ordenado
    public int getbuscarBin(String dato) {
        int inicio = 0; // indice de inicio
        int fin = misTiquetes.length - 1; // indice final pos del vector -1
        int pos; // indice que divide al vector por la mitad
        // mientras i<=f eso quiere decir que aun falta por recorrer el vector
        while (inicio <= fin) {
            pos = (inicio+fin) / 2; // divide el vector 
            if ( (misTiquetes[pos].id).equals(dato) ) // si el atributo id del objeto en la posicion pos es igual al dato lo encontro devuelve la pos
                return pos;
            // si compareTo devuelve un numero <0 quiere decir que el dato posiblemente este ala derecha del id actual
            else if ( (misTiquetes[pos].id).compareTo(dato)<0 ) {
                inicio = pos+1; // como ya sabemos que el id en pos no es por eso le mandamos pos+1 compara desde ese hasta el final
            } else { // de lo contrario quiere decir que el dato posiblemente este ala izquierda del id actual 
                fin = pos-1;// ya sabemos que pos no es entonces va a comparar desde pos-1 hasta el inicio
            }
        }
        // si se sale del bucle while y no retorno el dato quiere decir que  no lo encontro 
        // entonces returna -1
        return -1;
    }
}
