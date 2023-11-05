/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layoutgridpane;


import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Leocarlos
 */
public class Operaciones {
    
    private String info="";
    private List <Double> lista;
    private String tipo_oper="";
    
    Operaciones(){lista = new ArrayList<>();}
    
    public double suma(double n1,double n2){
        
        return n1+n2;
    }
    
    public double resta(double n1,double n2){
        
        return n1-n2;
    }
    
    public double mult(double n1,double n2){
        
        return n1*n2;
    }
    
    public double div(double n1, double n2){
        
        double div=0;
        try{
            
             div=n1/n2;
        }catch(ArithmeticException e){
            
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return div;
    }
    
    // metodo encargado de realizar las operaciones ademas de mostrar los numeros en el TextField
     public void onButtonClick(String button,TextField text) {
        
        info += button;
        double sum=0;
        double rest=0;
        double mult=0;
        double divi=0;
        
        
        if(       button.equals("0") || button.equals("1")
                || button.equals("2") || button.equals("3")
                || button.equals("4") || button.equals("5")
                || button.equals("6") || button.equals("7")
                || button.equals("8") || button.equals("9")){
            
            text.setText(info);
            lista.add(Double.valueOf(button));
            
        }else if(button.equals("+") || button.equals("-")
                || button.equals("*") || button.equals("/")){
            
            text.setText(info);
            tipo_oper=button;
        }else if(button.equals("=")){
            
              if (tipo_oper.equals("+")) {

                sum = suma(lista.get(0), lista.get(1));
                lista.clear();
                lista.add(sum);
                text.setText(String.valueOf(sum));
            } else if (tipo_oper.equals("-")) {

                rest = resta(lista.get(0), lista.get(1));
                lista.clear();
                lista.add(rest);
                text.setText(String.valueOf(rest));
            } else if (tipo_oper.equals("*")) {

                mult = mult(lista.get(0), lista.get(1));
                lista.clear();
                lista.add(mult);
                text.setText(String.valueOf(mult));
            } else if (tipo_oper.equals("/")) {

                divi = div(lista.get(0), lista.get(1));
                lista.clear();
                lista.add(divi);
                text.setText(String.valueOf(divi));
            }
            
            info = "";
            sum = 0;
            rest = 0;
            mult = 0;
            divi = 0;

        } else if(button.equals("c")){
            
            info="";
            text.setText("");
            lista.clear();
        }
    }
}
