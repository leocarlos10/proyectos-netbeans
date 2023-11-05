/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class misDatos {
    
    public float ventas[][];
    public int tf;   //Representa vendedor
    public int tc;  //Representa mes
    
    public misDatos(){
        tc=Integer.parseInt(JOptionPane.showInputDialog(
        "Entre el número de meses para la matriz de ventas: "));
        tf=Integer.parseInt(JOptionPane.showInputDialog(
        "Entre el número de vendedores: "));
        ventas = new float[tf][tc];
    }
    
    public void setLlenarMatriz(){
        int i, j;
        
        for(i=0; i<tf; i++){
            for(j=0; j<tc; j++){
                ventas[i][j]=Float.parseFloat(JOptionPane.showInputDialog(
                "Entre el dato de venta del vendedor "
                +i+" para el mes "+j+": "));
            }
        }
    }
    
    public void getSeeMatriz(){
        int i, j;
        String info="La información de ventas es: \n";
        
        for(i=0; i<tf; i++){
            for(j=0; j<tc; j++){
                info += "["+ventas[i][j]+"]";
            }
            info+="\n";
        }
        JOptionPane.showMessageDialog(null, info);
    } 
    
    //Este método dado un vendedor determina la suma
    //de todas sus ventas.
    public float getSumaVendedor(int vend){
        float suma=0;
        int j;
        for(j=0; j<tc; j++){
            suma+=ventas[vend][j];
        }
        return suma;
    }
    
    //Este método dado un mes determina la suma
    //de todas sus ventas.
    public float getSumaMes(int mes){
        float suma=0;
        int i;
        for(i=0; i<tf; i++){
            suma+=ventas[i][mes];
        }
        return suma;
    }
    
    //Este método dado un vendedor determina el promedio
    //de todas sus ventas.
    public float getPromedioVendedor(int vend){
        float suma=getSumaVendedor(vend);
        float tam=(float) tc;
        return suma/tam;
    }
    
    //Este método dado un mes determina el promedio
    //de todas sus ventas.
    public float getPromedioMes(int mes){
        float suma=getSumaMes(mes);
        float tam=(float) tf;
        return suma/tam;
    }
    
    //Este método determinar el total de venta de todos 
    //los vendedores
    public float[] getVentasxVendedor(){
        float vendedores[] = new float[tf];
        int i, j;
        for(i=0; i<tf; i++){
            for(j=0; j<tc; j++){
                vendedores[i]+=ventas[i][j];
            }
        }
        return vendedores;
    }
    
    //Este método determinar el total de venta de todos 
    //los meses
    public float[] getVentasxMes(){
        float meses[] = new float[tc];
        int i, j;
        for(j=0; j<tc; j++){
            for(i=0; i<tf; i++){
                meses[j]+=ventas[i][j];
            }
        }
        return meses;
    }
    
    //Metodo para mostrar vector
    public void getMostrarVector(float vec[]){
        int i;
        String info="La información es: \n";
        for(i=0; i<vec.length; i++){
            if(i<(vec.length -1))
                info+=""+vec[i]+", ";
            else
                info+=""+vec[i]+".";
        }
        JOptionPane.showMessageDialog(null, info);
    }
    
    //Este método determina cual es el mejor vendedor
    public void getMejorVendedor(){
        float vendedores[]=getVentasxVendedor();
        int i;
        int pos=0;
        float may=vendedores[0];
        
        for(i=0; i<vendedores.length; i++){
            if(vendedores[i]>=may){
                pos=i;
                may=vendedores[i];
            }
        }
        
        JOptionPane.showMessageDialog(null, 
        "El mejore vendedor es: "+pos+".\n"+
        "Con unt total de "+may+" ventas."
        );
    }
}
