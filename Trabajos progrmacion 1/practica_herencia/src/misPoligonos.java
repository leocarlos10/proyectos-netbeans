/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author leo
 */
public class misPoligonos {
    
    List<Poligonos> poligono;
    
    misPoligonos(){ poligono = new ArrayList<>();}
    
    
    public void setaddTriangulo(
            JTextField base,
            JTextField lado2,
            JTextField lado3
    ){
        // agregamos un nuevo triangulo a el arrayList.
        poligono.add( new  Triangulo(
                Double.parseDouble(base.getText()),
                Double.parseDouble(lado2.getText()),
                Double.parseDouble(lado3.getText())));
        // limpiamos los JTextField y dejamos el cursor en la base.
        base.setText("");
        lado2.setText("");
        lado3.setText("");
        base.requestFocus();
    }
    
    public void setaddRectangulo(
            JTextField base,
            JTextField altura
    ){
        // agregamos un nuevo triangulo a el arrayList.
        poligono.add(new Rectangulo(
                Double.parseDouble(base.getText()),
                Double.parseDouble(altura.getText())));
        // limpiamos los JTextField y dejamos el cursor en la base.
        base.setText("");
        altura.setText("");
        base.requestFocus();
    }
    
    public void cargarelementos(DefaultTableModel modelo,int indice,int i){
        
        Poligonos Paux= poligono.get(indice);
        Triangulo Taux=null;
        Rectangulo Raux=null;
        // validamos el tipo de poligono
        if(Paux.Tp==0){
            Taux =(Triangulo) poligono.get(indice);
            // guardamos los datos del Triangulo
            modelo.setValueAt(Taux.base, i, 0);
            modelo.setValueAt("Triangulo", i, 1);
            modelo.setValueAt(Taux.lado2, i, 2);
            modelo.setValueAt(Taux.lado3, i, 3);
        }
        else{
            
            Raux= (Rectangulo) poligono.get(indice);
            // guardamos los datos de el Rectangulo.
            modelo.setValueAt(Raux.base, i, 0);
            modelo.setValueAt("Rectagnulo", i, 1);
            modelo.setValueAt(Raux.altura, i, 4);
        }
    }
    
    public void setllenarJTable(JTable tabla){
        
        int indice=0;// indice para moverme ene el vector
        int i=0; // indice para moverme en la tabla
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn(" Base");
        modelo.addColumn(" Tipo de poligono");
        modelo.addColumn(" Lado2");
        modelo.addColumn(" Lado3");
        modelo.addColumn(" Altura");
        
        while(indice < poligono.size()){
            
            modelo.addRow(new Object[] {"","","","",""});
            cargarelementos(modelo,indice,i);
            indice++;
            i++;
        }
        tabla.setModel(modelo);
    }
    
    
    
    
}
