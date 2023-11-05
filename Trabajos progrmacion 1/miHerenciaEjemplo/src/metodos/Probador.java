
package metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author ruben
 */
public class Probador {
    public static void main(String args[]){
        miPersonal miUniversidad=new miPersonal();
        int op;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
            "Menú Principal \n"+
            "1. Registrar docente \n"+
            "2. Registrar estudiante \n"+
            "3. Mostrar todos \n"+
            "4. Salir \n"+
            "Entre su opción \n"
            ));
            
            switch(op){
                case 1:
                    miUniversidad.setAddD();
                break;
                case 2:
                    miUniversidad.setAddE();
                break;
                case 3:
                    miUniversidad.getTodos();
                break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Adios!!");
                break;
                default:
                    JOptionPane.showMessageDialog(null, 
                        "Invalido!!  Intente nuevamente.");
            }
            
        }while(op!=4);
        System.exit(0);
    }
}
