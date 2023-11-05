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
public class mVentas {
    double ventas[][];
    int nv;  //Número de vendedores
    int nm; //Número de meses
    
    
    // nueva forma de constructor por default modificacion hecha por mi. 
    mVentas(){
        nv = Integer.parseInt(JOptionPane.showInputDialog(
        "Entre el número de vendedores: "));
        nm = Integer.parseInt(JOptionPane.showInputDialog(
        "Entre el número de meses: "));
        ventas = new double[nv][nm];
    }
    
    public void setLlenar( ){
        int i, j;
        for(i=0; i<nv; i++){
            for(j=0; j<nm; j++){
                ventas[i][j] = Double.parseDouble(
                JOptionPane.showInputDialog(
                "Entre el valor de venta del vendedor "+i
                +" en el mes "+j+":"));
            }
        }
    }
    
    public void getMostrarV( ){
        int i, j;
        String info="La matriz de ventas es: \n";
        for(i=0; i<nv; i++){
            for(j=0; j<nm; j++){
                info+="("+ventas[i][j]+")";
            }
            info+="\n";
        }
        JOptionPane.showMessageDialog(null, info);
    }
    
    public double getSumaM( ){
        int i, j;
        double suma = 0;
        for(i=0; i<nv; i++){
            for(j=0; j<nm; j++){
                suma += ventas[i][j];
            }
        }
        return suma;
    }
    
    public double getPromedioM( ){
        return (getSumaM()/(nv*nm));
    }
    
    public int getMayoresPromedio( ){
        int i, j, contMay=0;
        double prom = getPromedioM();
        
        for(i=0; i<nv; i++){
            for(j=0; j<nm; j++){
                if(ventas[i][j]>prom)
                    contMay++;
            }
        }
        return contMay;
    }
    
    public int[] getPosMayor( ){
        int pos[]=new int[2];
        int i, j;
        double may=ventas[0][0];
        
        for(i=0; i<nv; i++){
            for(j=0; j<nm; j++){
                if(ventas[i][j]>=may){
                    may=ventas[i][j];
                    pos[0]=i;  //Guardo posición fila                 
                    pos[1]=j;  //Guardo posición columna
                }
            }
        }        
        return pos;
    }
    
    //Este método dada la posición de un vendedor
    //determina su total de ventas.
    public double getVentasVendedor(int posV){
        double suma=0;
        int j;
        for(j=0; j<nm; j++){
            suma+=ventas[posV][j];
        }
        return suma;
    }
    
    //Este método dada la posición de un mes
    //determina su total de ventas.
    public double getVentasMes(int posM){
        double suma=0;
        int i;
        for(i=0; i<nv; i++){
            suma+=ventas[i][posM];
        }
        return suma;
    }
    
    //Este metodo determina las ventas anuales de
    //todos los vendedores.
    public double[] getVentasXVendedor( ){
        double vVendedores[]=new double[nv];
        int i;
        for(i=0; i<nv; i++){         
            vVendedores[i]=getVentasVendedor(i);
        }        
        return vVendedores;
    }
    
    //Este metodo determina las ventas de todos los 
    //vendedores por mes.
    public double[] getVentasXMes( ){
        double vMes[]=new double[nm];
        int j;
        for(j=0; j<nm; j++){         
            vMes[j]=getVentasMes(j);
        }        
        return vMes;
    }
    
    //Este método determina el mejor vendedor
    //de un año.
    public int getMejorVendorA(){
        double vVendedores[]=getVentasXVendedor();
        double may=vVendedores[0];
        int i, posm=0;
        
        for(i=0; i<vVendedores.length; i++){
            if(vVendedores[i]>=may){
                may=vVendedores[i];
                posm=i;
            }
        } 
        return posm;
    }
    
    //Este método determina el mes de mayores
    //ventas.
    public int getMejorMesV( ){
        double vMes[]=getVentasXMes();
        double may=vMes[0];
        int i, posm=0;
        
        for(i=0; i<vMes.length; i++){
            if(vMes[i]>=may){
                may=vMes[i];
                posm=i;
            }
        } 
        return posm;
    }
            
    public void getMostrarVec(double vec[]){
        int i;
        String info="La información es: \n[";
        for(i=0;i<vec.length;i++){
            if(i<(vec.length-1))
                info+=""+vec[i]+", ";
            else
                info+=""+vec[i]+"]";
        }
        JOptionPane.showMessageDialog(null, info);
    }
    
    //Ventas de un vendedor
    public void getVentasdeUNVendedor(int v){
        double vVendedor[]=new double[nm];
        int j;
        for(j=0; j<nm; j++){
            vVendedor[j]=ventas[v][j];
        }
        getMostrarVec(vVendedor);
    }
    
    //Ventas de un mes
    public void getVentasdeUNMes(int m){
        double vMes[]=new double[nv];
        int i;
        for(i=0; i<nv; i++){
            vMes[i]=ventas[i][m];
        }
        getMostrarVec(vMes);
    }
}
