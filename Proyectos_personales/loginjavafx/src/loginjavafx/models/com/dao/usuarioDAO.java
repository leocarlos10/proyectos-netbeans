/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginjavafx.models.com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import loginjavafx.models.com.Usuario;
import java.sql.ResultSet;
/**
 *
 * @author Leocarlos
 * esta clase es la encargada de hacer todas las operaciones ala base de datos.
 */
public class usuarioDAO {
    
    // este metodo es el encargado de hacer la conexion 
    public Connection conectar(){
        
        // variables necesarias para la conexion a la base de datos
            String baseDeDatos ="java";
            String usuario = "root";
            String pass="";
            String hosting="localhost";
            String puerto="3306";
            String driver="com.mysql.cj.jdbc.Driver";
            String url ="jdbc:mysql://"+ hosting + ":" +puerto + "/" + baseDeDatos + "?useSSL=false";
            Connection conexion =null;
        try {
            // dentro de este try catch realizamos la conexion.
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,usuario,pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
    
    // metodo que agrega un usuario
    public boolean agregar(Usuario u){
        
        boolean band = false;
        try {
            
            Connection conexion = conectar();
            // agregamos un usario
            String sql = "INSERT INTO `usuarios` (`id`, `user`, `password`, `name`) "
                    + "VALUES (NULL, '"+u.getUser()+"', '"+u.getPass()+"', '"+u.getNombre()+"')";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            band =true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
            band=false;
        }
        return band;
    }
    
    // metodo que devuelve la lista de usuarios.
    public List<Usuario> listar(){
        
            // lista que resive el listado de Usuarios.
            List<Usuario> lista = new ArrayList<>();
            
        try {
            
            Connection conexion = conectar();
            // con este codigo sql traemos todos los usuarios de la base de datos.
            String sql = "SELECT * FROM `usuarios`"; 
            Statement statement = conexion.createStatement();
            ResultSet resultado =statement.executeQuery(sql);
            
            // este bucle recorre todas las tablas y convierte cada atributo a tipo usuario.
            while(resultado.next()){
                
                Usuario u = new Usuario();
                u.setId(resultado.getString("id"));
                u.setUser(resultado.getString("user"));
                u.setPass(resultado.getString("password"));
                u.setNombre(resultado.getString("name"));
                
                lista.add(u);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE); 
        }
        return lista;
    }
    
     public void eliminarUser(Usuario u){
         
        try {
            
            Connection conexion = conectar();
            // agregamos un usario
            String sql = "DELETE FROM usuarios WHERE `usuarios`.`id` = "+ u.getId();
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
           
        }
    }
}
