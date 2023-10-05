/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionDAO;

import controlador.Pass_Users;
import controlador.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 *
 * @author Leocarlos
 * clase encargada de hacer la conexion a la base de datos 
 */
public class usuarioDAO {
    
    // metodo encargado de hacer la conexion con la base de datos
    public Connection conectar(){
        
        String nombre_DB = "aplicacion_login";
        String usuario = "root";
        String pass = "";
        String hosting = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://" + hosting + ":" + puerto + "/" + nombre_DB + "?useSSL=false";
        Connection conexion = null;
        
        try{
            
            // realizamos la conexion a la base de datos.
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,usuario,pass);
            
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);  
        }
        return conexion;
    }
    
    // metodo encargado de agregar un usuario ala base de datos.
    public void agregar(Usuario u){
        
        try{
            Connection conexion = conectar();
            // agregamos el codigo sql para agregar un usuario.
            String sql = "INSERT INTO `usuario` (`id`, `user`, `pass`) "
                    + "VALUES (NULL, '" + u.getUser() + "', '" + u.getPass() + "')";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            
            // cerramos la conexion.
            conexion.close();
            statement.close();
                        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }       
    }
    
     public void agregar_passUsers(Pass_Users user){
        
        try{
            Connection conexion = conectar();
            // agregamos el codigo sql para agregar un usuario.
            String sql = "INSERT INTO `pass_usuarios` (`sitio`, `usuario`, `pass`, `id_usuario`) "
                    + "VALUES ('"+user.getSitio()+"', '"+user.getUser()+"', '"+user.getPass()+"', '"+user.getId_usuario()+"')";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            
            // cerramos la conexion.
            conexion.close();
            statement.close();
                        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }       
    }
     
     
    
    // metodo encargado de traer todos los usuarios registrados en la base de datos.
    public List<Usuario> getUserAll(){
        
        List<Usuario> userlist = new ArrayList<>();
        
        /*
        El bloque try-with-resources es una característica de Java introducida en Java 7 
        que facilita la gestión de recursos que deben cerrarse explícitamente, 
        como conexiones a bases de datos, flujos de archivos o sockets. 
        Esta característica automatiza el proceso de cierre de recursos y garantiza que se realice de manera segura 
        y adecuada, incluso si ocurre una excepción durante la ejecución del bloque try.
        El bloque try-with-resources se utiliza para crear un ámbito en el que uno o más recursos se abren y utilizan, 
        y después se cierran automáticamente al salir del ámbito, ya sea cuando el bloque try se ejecuta con éxito o si 
        se lanza una excepción.

        Los recursos declarados en el encabezado del try-with-resources deben ser objetos que implementen la interfaz AutoCloseable 
        (o java.lang.AutoCloseable). Esta interfaz define el método close() que se llama automáticamente cuando se sale del bloque try, 
        lo que permite que el recurso se cierre de manera adecuada.
        Beneficios del bloque try-with-resources:
        Limpieza automática: No es necesario escribir código explícito para cerrar los recursos, ya que se cierran automáticamente al finalizar el bloque try.
        Gestión de excepciones: Si ocurre una excepción durante el uso del recurso, se cerrará correctamente antes de que se propague la excepción, evitando posibles fugas de recursos.
        Reducción de errores: Elimina la necesidad de recordar cerrar explícitamente los recursos, lo que reduce la posibilidad de errores en la gestión de recursos.
        Ejemplo de uso del bloque try-with-resources con una conexión JDBC:
        
        Documentacion 
        Manipulación de Columnas:
        Puedes acceder a los valores de las columnas mediante el índice de columna (empezando desde 1)
        o mediante el nombre de la columna. Los métodos getInt, getString, getDouble, etc.,
        te permiten obtener valores de diferentes tipos de columnas.
        */
        
        try(Connection conexion = conectar();){
            
            // agregamos el codigo sql
            String sql = "SELECT * FROM `usuario`"; 
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            // creamos un bucle que recorra toda la tabla y que convierta cada atributo a tipo Usuario.
            while(resultado.next()){
                
                Usuario u = new Usuario();
                u.setId(resultado.getInt("id"));
                u.setUser(resultado.getString("user"));
                u.setPass(resultado.getString("pass"));
                
                userlist.add(u);
            }
            /*
            Liberación de Recursos:
            Similar a los objetos Statement, 
            es importante cerrar el ResultSet cuando ya no se necesita para liberar los recursos 
            y evitar problemas de memoria. Esto se hace llamando al método close() en el objeto ResultSet 
            y en el objeto statement.
            */
            statement.close();
            resultado.close();
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return userlist;
    }
    
     public List<Pass_Users> getPass_UsersAll(int id){
        
        List<Pass_Users> pass_userlist = new ArrayList<>();
        
        try(Connection conexion = conectar();){
            
            // agregamos el codigo sql
            String sql = "SELECT * FROM `pass_usuarios` WHERE id_usuario = " +id; 
            
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            // creamos un bucle que recorra toda la tabla y que convierta cada atributo a tipo Usuario.
            while(resultado.next()){
                
                Pass_Users u = new Pass_Users();
                u.setSitio(resultado.getString("sitio"));
                u.setUser(resultado.getString("usuario"));
                u.setPass(resultado.getString("pass"));
                
                pass_userlist.add(u);
            }
           
            statement.close();
            resultado.close();
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return pass_userlist;
    }
     
     public void eliminar_pass_user(String user){
         
          try{
            Connection conexion = conectar();
            // agregamos el codigo sql para agregar un usuario.
            String sql = " DELETE FROM `pass_usuarios` WHERE `usuario` = '"+user+"'";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            
            // cerramos la conexion.
            conexion.close();
            statement.close();
                        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        } 
     }
}
