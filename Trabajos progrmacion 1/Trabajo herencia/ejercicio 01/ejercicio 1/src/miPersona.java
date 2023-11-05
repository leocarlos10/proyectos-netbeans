/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leo y moises
 
 */
public class miPersona {
    
    /*
    utilizamos una lista con estas dos clases List y arrayList 
    ademas atraves del generico <Persona> le hago saber a java 
    que en esta lista solo se van a guardar objetos de tipo persona incluyendo sus subclases.
    */
    List<Persona> persona;
    
    miPersona (){ persona = new ArrayList<>();}
    
    public int getBuscarId(int id){
        
        Persona p=null;
        Cliente c=null;
        Administrador a=null;
        
        for(int i=0;i<persona.size();i++){
            
            p= persona.get(i);
            
            if(p.Tp == 0){
                
                c= (Cliente) persona.get(i); 
                if(c.id_cliente == id)
                    return i;
            }
            else{
                
                a=(Administrador) persona.get(i);
                if(a.Tp == id)
                    return i;
            }
        }
        return -1;
    }
    
    public void setllenarcliente(
            JTextField nombre,
            JTextField cedula,
            JTextField edad,
            JTextField id
    ){
        if(getBuscarId(Integer.parseInt(id.getText())) != -1){
            
            JOptionPane.showMessageDialog(null,
                    " Lo sentimos pero el id que ingreso ya existe en la lista");
            id.setText("");
            id.requestFocus();
        }
        else{
            
            Cliente clien= new Cliente(nombre.getText(),Integer.parseInt(cedula.getText()),Integer.parseInt(edad.getText()),Integer.parseInt(id.getText()));
            clien.registrarCliente(persona, clien);
            nombre.setText("");
            cedula.setText("");
            edad.setText("");
            id.setText("");
            nombre.requestFocus();
        }
    }
    
     public void setllenaradmin(
            JTextField nombre,
            JTextField cedula,
            JTextField edad,
            JTextField id_admin
    ){
         if(getBuscarId(Integer.parseInt(id_admin.getText())) != -1){
               JOptionPane.showMessageDialog(null,
                    " Lo sentimos pero el id que ingreso ya existe en la lista");
            id_admin.setText("");
            id_admin.requestFocus();
             
         }
         else{
             
            Administrador admin= new Administrador(nombre.getText(),Integer.parseInt(cedula.getText()),Integer.parseInt(edad.getText()),Integer.parseInt(id_admin.getText()));
            admin.registrarAdmin(persona, admin);
            nombre.setText("");
            cedula.setText("");
            edad.setText("");
            id_admin.setText("");
            nombre.requestFocus();
         }
    }
     
     public void cargarelementos(DefaultTableModel modelo,int indice, int i){
         
         Persona Per= persona.get(indice);
         Cliente clien=null;
         Administrador admin=null;
         
         if(Per.Tp==0){
             
             clien = (Cliente) persona.get(indice);
             
             modelo.setValueAt(clien.nombre, i, 0);
             modelo.setValueAt(clien.cedula, i, 1);
             modelo.setValueAt(clien.edad, i, 2);
             modelo.setValueAt("cliente", i, 3);
             modelo.setValueAt(clien.id_cliente, i, 4);
         }
         else{
             
             admin = (Administrador) persona.get(indice);
             
             modelo.setValueAt(admin.nombre, i, 0);
             modelo.setValueAt(admin.cedula, i, 1);
             modelo.setValueAt(admin.cedula, i, 2);
             modelo.setValueAt("Adiminstrador", i, 3);
             modelo.setValueAt(admin.id_Administrador, i, 5);
         }
     }
     
    public void setllenarJTable(JTable tabla){
        
        int indice=0;
        int i=0;
        Persona per = new Persona();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Nombre");
        modelo.addColumn("cedula");
        modelo.addColumn("edad");
        modelo.addColumn("Tipo de persona");
        modelo.addColumn(" id (Cliente)");
        modelo.addColumn(" id(Adiminstrador)");
        
        while(indice < persona.size()){
            
            modelo.addRow(new Object[] {"","","","","",""});
            cargarelementos(modelo,indice,i);
            indice++;
            i++;
        }
        tabla.setModel(modelo);
        
    }
}
