/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;


import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class vecParalelo {
    public String nomP[];
    public float totalV[];
        
    public vecParalelo(
        JTextField jtfNElem
    ){
        int i;
        nomP = new String[Integer.parseInt(jtfNElem.getText())];
        totalV = new float[Integer.parseInt(jtfNElem.getText())];
        //Inicializamos los vectores vacíos:
        for(i=0; i<totalV.length; i++){
            nomP[i]="";
            totalV[i]=0;
        }
        JOptionPane.showMessageDialog(null, "Vectores Inicializados!");
    }
    
    public int getBuscarP(String nombreP){
        int i;
        for(i=0; i<nomP.length; i++){
            if(nomP[i].equals(nombreP)==true)
                return i;
        }
        return -1;
    }
    
    public float getTotalVentas(){
        int i;
        float suma=0;
        for(i=0; i<totalV.length; i++)
            suma += totalV[i];
        return suma;
    }
    
    public float getPromedioVentas(){
        float tam=(float) totalV.length;
        return (getTotalVentas()/tam);
    }
    
    public int getPosMayor(){
        int i, posM=0;
        float may=totalV[0];
        for(i=0; i<totalV.length; i++){
            if(totalV[i]>=may){
                may=totalV[i];
                posM=i;
            }
        }
        return posM;
    }
    
    public void getInfoMayor(){
        int posM=getPosMayor();
        JOptionPane.showMessageDialog(null,
            "Nombre del producto: "+nomP[posM]+"\n"+
            "Total de venta: "+totalV[posM]);
    }
    
    public boolean setAddInfo(
        JTextField jtfNomP,
        JTextField jtfTventa,      
        int indice        
    ){        
        try{
            if(getBuscarP(jtfNomP.getText())!=-1){
                JOptionPane.showMessageDialog(null,
                "El nombre del producto ya se encuentra "
                + "registrado!  Intente nuevamente.");
                jtfNomP.setText("");
                jtfNomP.requestFocus(); 
                return false;
            }else{                                                      
                nomP[indice]=jtfNomP.getText();
                totalV[indice]=Float.parseFloat(
                jtfTventa.getText());
                jtfNomP.setText("");
                jtfTventa.setText("");
                jtfNomP.requestFocus(); 
                return true;           
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, 
                "Error: "+e);
            return false;
        }
    }
    
    public void setEliminarDato(String nombreP){
        int pos=getBuscarP(nombreP);
        if(pos!=-1){
            nomP[pos]="";
            totalV[pos]=0;
            JOptionPane.showMessageDialog(null,
                "Elemento borrado!!!");
        }
    }
    
    public void setModificarDato(int pos, 
        String nombreP, float totales){
        nomP[pos]=nombreP;
        totalV[pos]=totales;
        JOptionPane.showMessageDialog(null,
            "Elemento modificado!!!");
    }
    
    //Este método registra un dato al JTable
    //teniendo en cuenta el tipo de Persona
    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
        int Fila, int indiceArray){
        
        miModelo.setValueAt(nomP[indiceArray], Fila, 0);
        miModelo.setValueAt(totalV[indiceArray], Fila, 1);            
    }    
    
    
    //Este método actualiza el contenido de la fila
    //de un JTable a partir de su modelo de datos 
    //(JTableModel)
    public void setLlenarJTable(JTable tab){
        int indice=0; //Este índice recorre los elementos del ArrayList
        int i=0;  //Este índice para ubicar posición de fila en el JTable
        DefaultTableModel miModelo=new DefaultTableModel();
        miModelo.addColumn("Nombre del Producto");
        miModelo.addColumn("Total de Ventas");        
        while(indice<nomP.length){                        
            miModelo.addRow(new Object[]{"", ""});              
            setRegistrarFilaJTable(miModelo,i,indice);            
            i++;
            indice++;
        }
        tab.setModel(miModelo);
    }    
}
