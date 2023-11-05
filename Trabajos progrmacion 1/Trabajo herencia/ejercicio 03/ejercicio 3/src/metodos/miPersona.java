
package metodos;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leocarlos moises
 */
public class miPersona {
    
    List<Persona> mipersona;
    
    miPersona(){ mipersona= new ArrayList<>();}
    
    public int getBuscarId(int id){
       
        Persona temp=null;
        Alumno temp_a=null;
        Instructor temp_i=null;
        
        for(int i=0;i<mipersona.size();i++){
             temp = mipersona.get(i);
             
             if(temp.Tp==0){
                 
                 temp_a =(Alumno) mipersona.get(i);
                 if(temp_a.idAlumno==id)
                     return i;
             }
             else{
                 
                 temp_i = (Instructor) mipersona.get(i);
                 if(temp_i.idInstructor==id)
                     return i;
             }
        }
        return -1;
    }
    
    public void setllenarAlumno(
           JTextField nombre,
           JTextField apellido,
           JTextField correo,
           LocalDate fechaNa,
           JTextField id
    ){
        int posid= getBuscarId(Integer.parseInt(id.getText())); 
        
        if(posid != -1){
            
            JOptionPane.showMessageDialog(null, 
                    " Lo sentimos el id que ingreso ya se encuentra en la lista.");
            id.setText("");
            nombre.requestFocus();
        }
        else{
            
            Exception band=null;
            Alumno Alaux=null;
            
            try{
                Alaux =new Alumno(
                        fechaNa,
                        Integer.parseInt(id.getText()),
                        apellido.getText(),
                        correo.getText(),
                        nombre.getText()
                );
                
            }catch(Exception e){
                band=e;
                JOptionPane.showMessageDialog(null, " Error: "+e);
            }
            
            if(band==null){
                mipersona.add(Alaux);
                nombre.setText("");
                apellido.setText("");
                correo.setText("");
                id.setText("");
                nombre.requestFocus();
            } 
        } 
    }
    
     public void setllenarInstructor(
           JTextField nombre,
           JTextField apellido,
           JTextField correo,
           LocalDate fechaIn,
           JTextField id
    ){
        int posid= getBuscarId(Integer.parseInt(id.getText())); 
        
        if(posid != -1){
            
            JOptionPane.showMessageDialog(null, 
                    " Lo sentimos el id que ingreso ya se encuentra en la lista.");
            id.setText("");
            nombre.requestFocus();
        }
        else{
            
            Exception band=null;
            Instructor Insaux=null;
            
            try{
                Insaux =new Instructor(
                        fechaIn,
                        Integer.parseInt(id.getText()),
                        apellido.getText(),
                        correo.getText(),
                        nombre.getText()
                );
                
            }catch(Exception e){
                band=e;
                JOptionPane.showMessageDialog(null, " Error: "+e);
            }
            
            if(band==null){
                mipersona.add(Insaux);
                nombre.setText("");
                apellido.setText("");
                correo.setText("");
                id.setText("");
                nombre.requestFocus();
            } 
        }
    }
     
     public void cargarelementos( DefaultTableModel modelo,int indice,int i){
         
         Persona per= mipersona.get(indice);
         Alumno alum=null;
         Instructor ins=null;
         
         if(per.Tp==0){
             
             alum= (Alumno) mipersona.get(indice);
             modelo.setValueAt(alum.nombre, i, 0);
             modelo.setValueAt(alum.apellido, i, 1);
             modelo.setValueAt(alum.correoElectronico, i, 2);
             modelo.setValueAt("Alumno", i, 3);
             modelo.setValueAt(alum.idAlumno, i, 4);
             modelo.setValueAt(alum.fechaNacimiento, i, 5);
             
         }
         else{
             
             ins=(Instructor) mipersona.get(indice);
             modelo.setValueAt(ins.nombre, i, 0);
             modelo.setValueAt(ins.apellido, i, 1);
             modelo.setValueAt(ins.correoElectronico, i, 2);
             modelo.setValueAt("Instructor", i, 3);
             modelo.setValueAt(ins.idInstructor, i, 6);
             modelo.setValueAt(ins.fechaIngreso, i, 7);
         }
    }
     
     public void setllenarJTable(JTable tabla){
         
         int indice=0;
         int i=0;
         
         DefaultTableModel modelo = new DefaultTableModel();
         
         modelo.addColumn("Nombre");
         modelo.addColumn("apellido");
         modelo.addColumn("correo");
         modelo.addColumn("Tipo de Persona");
         modelo.addColumn("id (Alumno)");
         modelo.addColumn("Fecha de nacimiento (Alumno)");
         modelo.addColumn("id (Instructor)");
         modelo.addColumn("Fecha de ingreso(Instructor)");
         
         
         while(indice < mipersona.size()){
             
             modelo.addRow(new Object[] {"","","","","","","",""});
             cargarelementos(modelo,indice,i);
             indice++;
             i++;
         }
         tabla.setModel(modelo);
     }
}
