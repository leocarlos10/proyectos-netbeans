
package metodos;
import javax.swing.*;
/**
 *
 * @author Leocarlos y moises
 */
public class Persona {
    
    protected String apellido;
    protected String correoElectronico;
    protected String nombre;
    protected int Tp;
    

    public Persona(String apellido, String correoElectronico, String nombre,int Tp) {
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.Tp=Tp;
    }
    
    public void Tovalidate(JTextPane inf){
        String info= "Nombre: "+nombre+
                     "\n apellido: "+apellido+
                     "\n correo: "+correoElectronico;
        inf.setText(info);
    }
}
