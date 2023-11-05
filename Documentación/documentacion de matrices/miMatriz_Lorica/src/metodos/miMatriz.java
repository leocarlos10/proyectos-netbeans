/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class miMatriz {
    //Definimos la matriz
    float ventas[][];
    int tf, tc;
    
    miMatriz(){
        int i, j;
        tf = Integer.parseInt(JOptionPane.showInputDialog(
            "Entre el número de filas (# vendedores) de la matriz ventas: "
            ));
        tc = Integer.parseInt(JOptionPane.showInputDialog(
            "Entre el número de columnas (# meses) de la matriz ventas: "
            ));
        ventas = new float[tf][tc];
        //Se llena una matriz vacía a partir del recorrido
        //de su filas.
        for(i=0; i<tf; i++){
            for(j=0; j<tc; j++){
                ventas[i][j]=0;
            }
        }
    }
    
    public void setLlenarMatriz(){
        int i;  //Índice para las filas.
        int j;  //Índice para las columnas.
        String mens="Entre las ventas del vendedor";
        for(i=0; i<tf; i++){
            mens+=" "+i+", en el mes";
            for(j=0; j<tc; j++){
                mens+=" "+j+": ";
                ventas[i][j]=Float.parseFloat(
                    JOptionPane.showInputDialog(
                mens));
               // mens="Entre las ventas del vendedor "+i+", en el mes";
            }
            mens="Entre las ventas del vendedor";
        }        
    }           
    
    //Este método actualiza el contenido de la fila
    //de un JTable a partir de su modelo de datos 
    //(JTableModel)
    public void setLlenarJTable(JTable tab){
        int i, j; //Este índice recorre los elementos de la matriz
        int indice=0;  //Este índice para ubicar posición de fila en el JTable
        DefaultTableModel miModelo=new DefaultTableModel();        
        for(j=0; j<tc; j++)
            miModelo.addColumn("Mes "+j);
        
        for(i=0; i<tf; i++){
            miModelo.addRow(new Object[tc]);
            for(j=0; j<tc; j++){                
                miModelo.setValueAt(ventas[i][j], i, j);                
            }
        }        
        tab.setModel(miModelo);
    }
    
    //Método que retorna el Total de ventas de 
    //cada vendedor
    public float[] getTotalV(){
        float TotalV[] = new float[tf];
        int i, j;
        
        //Inicializo el vector en cero
        for(i=0; i<TotalV.length; i++)
            TotalV[i]=0;
        
        //Sumamos las ventas de cada vendedor
        //y se almacenan en el vector
        for(i=0; i<tf; i++){
            for(j=0; j<tc; j++){
                TotalV[i]+=ventas[i][j];
            }
        }        
        return TotalV;
    }
    
    //Método que retorna el Total de ventas de 
    //cada mes
    public float[] getTotalM(){
        float TotalM[] = new float[tf];
        int i, j;
        
        //Inicializo el vector en cero
        for(i=0; i<TotalM.length; i++)
            TotalM[i]=0;
        
        //Sumamos las ventas de cada vendor
        //y se almacenan en el vector
        for(j=0; j<tc; j++){
            for(i=0; i<tf; i++){
                TotalM[j]+=ventas[i][j];
            }
        }        
        return TotalM;
    }
    
    public void MostrarVector(String cadena, float vec[]){
        int i;
        String info="";
        if(cadena.equals("vendedor")){
            for(i=0; i<vec.length; i++){
                info+="El total de ventas del vendedor "+i+" es :"
                      +vec[i]+"\n";
            }
            JOptionPane.showMessageDialog(null, 
                "Las ventas de los vendedores son: \n"+info);
        }else{
            for(i=0; i<vec.length; i++){
                info+="El total de ventas del mes "+i+" es :"
                      +vec[i]+"\n";
            }
            JOptionPane.showMessageDialog(null, 
                "Las ventas de por mes son: \n"+info);
        }
    }
    
    public float getSumaVentas(){
        float suma=0;
        int i, j;
        for(i=0; i<tf; i++){
            for(j=0; j<tc; j++){
                suma+=ventas[i][j];
            }
        }
        return suma;
    }
    
    //Este método determina quien es el mejor vendedor
    public void getMejorVendedor(){
        float TotalV[]=getTotalV();
        int i, pos=0;
        float may=TotalV[0];
        for(i=0;i<TotalV.length; i++){
            if(TotalV[i]>=may){
                may=TotalV[i];
                pos=i;
            }
        }
        JOptionPane.showMessageDialog(null, 
            "El mejor vendedor es: "+pos+" su "
            + "total de ventas es: "+TotalV[pos]);
    }
    
    //Este método determina quien es el mejor mes
    public void getMejorMes(){
        float TotalM[]=getTotalM();
        int i, pos=0;
        float may=TotalM[0];
        for(i=0;i<TotalM.length; i++){
            if(TotalM[i]>=may){
                may=TotalM[i];
                pos=i;
            }
        }
        JOptionPane.showMessageDialog(null, 
            "El mejor mes es: "+pos+" su "
            + "total de ventas es: "+TotalM[pos]);
    }
    
}
