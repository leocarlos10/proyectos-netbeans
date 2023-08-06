/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionDAO;

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
 * 
 * clase encargada de hacer la conexion a la base de datos 
 */
public class usuarioDAO {
    
    // metodo encargado de hacer la conexion con la base de datos
    public Connection conectar(){
        
        String nombre_DB = "Aplicacion_login";
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
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }       
    }
    
    // metodo encargado de traer todos los usuarios registrados en la base de datos.
    public List<Usuario> getUserAll(){
        
        List<Usuario> userlist = new ArrayList<>();
        
        try{
            Connection conexion = conectar();
            
            // agregamos el codigo sql
            String sql = "SELECT * FROM `usuario`"; 
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            // creamos un bucle que recorra toda la tabla y que convierta cada atributo a tipo Usuario.
            while(resultado.next()){
                
                Usuario u = new Usuario();
                u.setId(resultado.getString("id"));
                u.setUser(resultado.getString("user"));
                u.setPass(resultado.getString("pass"));
                
                userlist.add(u);
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return userlist;
    }
}
