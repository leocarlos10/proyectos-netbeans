/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import ConexionDAO.usuarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leocarlos
 */
public class misUsuarios {
    
    List<Usuario> lista = new ArrayList<>();
    usuarioDAO dao = new usuarioDAO();
    
    public void setUsuario(String u, String pass) {

        lista.add(new Usuario(u, pass));
    }
    
    public Usuario getUser(){
        
       Usuario u = lista.get(0);
       lista.remove(0);
       return u;
    }
    
    public boolean Verf_user(String u,String pass){
        
        // en esta lista estan todos los usuario obtenidos de la base de datos.
        lista.addAll(dao.getUserAll());
        
        // si el usuario y contrasena son validos retorna true;
       for(int i=0;i<lista.size();i++){
           
           if(lista.get(i).getUser().equals(u) && lista.get(i).getPass().equals(pass))
               return true;
       }
       lista.clear();
       return false;
    }
    
    
}

 // documentacion de ficheros.
    // metodo para guardar los datos de los usuarios en el fichero.
    /*
    public void guardarinfo(String inf){
        
        try{
        FileWriter guardar = new FileWriter("C:/Users/USUARIO/Desktop/texto/infoUsuarios2.txt",true);
        guardar.write(inf);
        guardar.close();
        lista.clear();
        
        }catch(IOException e){
            
            JOptionPane.showMessageDialog(null, e,"Error",
                    JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    // metodo que lee el fichero.
    public List<String> leerfichero(){
        
        // lista que almacena en este orden Usuario,contrasena
         List<String> info= new ArrayList<>();
        
        try{
            File archivo = new File("C:/Users/USUARIO/Desktop/texto/infoUsuarios2.txt");
            /*
            utilizo el scanner para guardar linea por linea y asi en cada linea
            verificar el usuario y la contraseña.
            
            Scanner scanner = new Scanner(archivo);
            // mientras halla lineas por leer el va a seguir leeyendo.
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                info.add(linea);
            }
            
            scanner.close();
            
        }catch(IOException e){
            
            JOptionPane.showMessageDialog(null, e,"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return info;
    }
    
    public boolean Verf_user(String u,String pass){
        
        // cada casilla contiene usuario y contrasena.
        List<String> users = leerfichero();
        String users2 = u+pass;
        
        // si encuentra una linea parecida retorna true
       for(int i=0;i<users.size();i++){
           
           if(users.get(i).equals(users2))
               return true;
       }
       return false;
    }
*/
