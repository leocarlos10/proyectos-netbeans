/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;  //Datos del JTable

/**
 *
 * @author ruben
 * colaborador: leocarlos
 * 
 */
public class ventas {
    
    ArrayList misVehiculos;
    // creacion de un array
    ventas(){ misVehiculos = new ArrayList(); }
    
    //este metodo busca una matricula repetida.
    public int getMat(String placa){
        int i;
        Vehiculo temp=null;
        for(i=0; i<misVehiculos.size(); i++){
            temp = (Vehiculo) misVehiculos.get(i);
            if((temp.mat).equals(placa))
                return i;
        }
        return -1;
    }
    
    
    public boolean setAddCarro(
        JTextField jtfMat,
        JTextField jtfMod,
        JTextField jtfNPuestos
    ){
        int posM = getMat(jtfMat.getText());
        
        if(posM!=-1){
            JOptionPane.showMessageDialog(null,
                    "La matricula que trata de ingresar ya "
                    + "se encuentra registrada en el ArrayList! \n"
                    + "Intente nuevamente.");
            jtfMat.setText("");
            jtfMat.requestFocus();
            return false;// retorna falso ya que no agrego el carro a el Arraylist
        } else {
            Exception band=null;// variable para saber si hubo excepcion o no.
             carro Caux=null;
            try{
                 Caux=new carro(
                    Integer.parseInt(jtfNPuestos.getText()),
                    jtfMat.getText(),
                    jtfMod.getText()
                );
            }catch(Exception e){
                // si hubo excepcion la captura y la guarda en la variable
                band=e;
                JOptionPane.showMessageDialog(null, " Error "+e);
                jtfNPuestos.setText("");
                jtfNPuestos.requestFocus();
                
            }
            // si la bandera esta vacia agrega los datos a la lista
            if(band==null){
            misVehiculos.add(Caux);
            jtfMat.setText("");
            jtfMod.setText("");
            jtfNPuestos.setText("");
            jtfMat.requestFocus();
            return true;
            }
            // de lo contrario retorna falso
            return false;
        }
    }
    
    public boolean setAddMoto(
        JTextField jtfMat,
        JTextField jtfMod,
        JTextField jtfMarca
    ){
        int posM = getMat(jtfMat.getText());
        
        if(posM!=-1){
            JOptionPane.showMessageDialog(null,
                    "La matricula que trata de ingresar ya "
                    + "se encuentra registrada en el ArrayList! \n"
                    + "Intente nuevamente.");
            jtfMat.setText("");
            jtfMat.requestFocus();
            return false;
        } else {
               moto Maux=new moto(
                         jtfMarca.getText(),
                         jtfMat.getText(),
                         jtfMod.getText()
                );
            misVehiculos.add(Maux);
            jtfMat.setText("");
            jtfMod.setText("");
            jtfMarca.setText("");
            jtfMat.requestFocus();
            return true;
        }
    }
    
    //Este método registra un dato al JTable
    //teniendo en cuenta el tipo de vehiculo
    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
            int Fila, int indiceArray) {

        Vehiculo Vaux = null;
        carro Caux = null;
        moto Maux = null;

        Vaux = (Vehiculo) misVehiculos.get(indiceArray);
        //Validamos si el tipo de vehiculo a mostrar es
        //un carro
        if (Vaux.tipoV == 0) {
            Caux = (carro) misVehiculos.get(indiceArray);

            miModelo.setValueAt(Caux.mat, Fila, 0);
            miModelo.setValueAt(Caux.modelo, Fila, 1);
            miModelo.setValueAt("Carro", Fila, 2);
            miModelo.setValueAt(Caux.nPuestos, Fila, 3);
            miModelo.setValueAt("", Fila, 4);
           
        } //Sino es un carro
        else {
            Maux = (moto) misVehiculos.get(indiceArray);

            miModelo.setValueAt(Maux.mat, Fila, 0);
            miModelo.setValueAt(Maux.modelo, Fila, 1);
            miModelo.setValueAt("Moto", Fila, 2);
            miModelo.setValueAt("", Fila, 3);
            miModelo.setValueAt(Maux.marca, Fila, 4);
            
        }
    }

    //Este método actualiza el contenido de la fila
    //de un JTable a partir de su modelo de datos 
    //(JTableModel)
    public void setLlenarJTable(JTable tab) {
        int indice = 0; //Este índice recorre los elementos del ArrayList
        int i = 0;  //Este índice para ubicar posición de fila en el JTable
        DefaultTableModel miModelo = new DefaultTableModel();
        miModelo.addColumn("Matricula");
        miModelo.addColumn("Modelo");
        miModelo.addColumn("Tipo Vehiculo");
        miModelo.addColumn("Número de Puestos (Carro)");
        miModelo.addColumn("Marca (Moto)");

        while (indice < misVehiculos.size()) {
            miModelo.addRow(new Object[]{"", "", "", "", ""});
            setRegistrarFilaJTable(miModelo, i, indice);
            i++;
            indice++;
        }
        tab.setModel(miModelo);
    }
    
    public void setDelMat(String mat) {
        int posM = getMat(mat);
        if (posM == -1) {
            JOptionPane.showMessageDialog(null,
                    "La matricula ingresada para elminiar "
                    + "no se encuentra registrada!");
        } else {
            misVehiculos.remove(posM);
            JOptionPane.showMessageDialog(null,
                    "Los datos del vehiculo con matricula: " + mat
                    + " fueron eliminados!");
        }
    }
}
