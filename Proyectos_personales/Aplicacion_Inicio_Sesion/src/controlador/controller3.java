/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import ConexionDAO.usuarioDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;



/**
 *
 * @author Leocarlos.
 */
/*
    el componente TableView es parecido a el 
    JTable de la clase JFrame tambien funciona con 
    un modelo pero este modelo es de tipo ObservableList
    se inicializa 
    
     ObservableList<Pass_Users> list = FXCollections.observableArrayList();
     se agregan el nombre a las columnas que va a tener la tabla.
     this.Col_usuario.setCellValueFactory(new PropertyValueFactory("user"));
     this.Col_pass.setCellValueFactory(new PropertyValueFactory("pass"));
    
     luego le agregamos los objetos de tipo Pass_users ala list 
     para posteriormente mandar los items a el TableView
     table.setItems(list);
    
    
    */
public class controller3 implements Initializable {
    
    usuarioDAO dao;
    misUsuarios users;
    List<Usuario> lista;
    int  id_usuarios =0;
    boolean click = true;
    ObservableList<Pass_Users> list;
    
    @FXML
    private TextField sitio;

    @FXML
    private TextField text_usuario;

    @FXML
    private PasswordField text_pass;

    @FXML
    private Button Ingresar;

    @FXML
    private Button editar;
    
    @FXML
    private Button mostrar;
    
    @FXML
    private TableView<Pass_Users> table;
    
    @FXML
    private TableColumn col_usuario;

    @FXML
    private TableColumn col_pass;
    
    @FXML
    private TableColumn col_sitio;
    
    @FXML
    private SplitMenuButton opcion_user;
    
    @FXML
    private Button limpiar;
    
    @FXML
    private Button btn_eliminar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // agrego estilos para  el momento que el cursor enfoque el boton
        Ingresar.setCursor(Cursor.HAND);
        editar.setCursor(Cursor.HAND);
        // este bloque es el que me ayuda a saber con cual id se van a guardar los passwords.
        dao = new usuarioDAO();
        lista = dao.getUserAll();
        MenuItem item;
        
        // este for ayuda a generar un menuItem por cada cuenta que tenga en la base de datos usuario.
        // todos los menuItem tienen un evento que al momento de seleccionar guarda el id respectivo en 
        // la variable id_usuarios.
        for(Usuario e:lista){
            
            item = new MenuItem(e.getUser());
            
            item.setOnAction(event ->{
                // seleccionamos el id
                id_usuarios = e.getId();
                // luego llamamos el evento para que muestre todos los Pass_Users.
                evento_mostrar(event);
            } );
            
            opcion_user.getItems().add(item);
        }
        
        list = FXCollections.observableArrayList();
        
        this.col_sitio.setCellValueFactory(new PropertyValueFactory("sitio"));
        this.col_usuario.setCellValueFactory(new PropertyValueFactory("user"));
        this.col_pass.setCellValueFactory(new PropertyValueFactory("pass"));
    }
    
    // evento que me ayuda a editar un password ya ingresado.
     @FXML
    void event_editar(ActionEvent event) {
        
        Pass_Users selectedPass_users = table.getSelectionModel().getSelectedItem();
        
        if(selectedPass_users != null){
            
             String s = selectedPass_users.getSitio();
             String user4 = selectedPass_users.getUser();
             String pass = selectedPass_users.getPass();
             // codigo para que un mismo boton realize dos eventos diferenes con nombre diferente 
             // en este caso editar y Guardar el usuario editado
            if(click){
                // agregamos los datos de la tabla a los textfields
                sitio.setText(s); 
                text_usuario.setText(user4);
                text_pass.setText(pass);
                // cambiamos la descripcion del boton
                editar.setText("Guardar"); 
                click = false;
            }else{
                
                dao = new usuarioDAO();
                // elimino el usuario de la base de datos
                dao.eliminar_pass_user(user4);
                // luego creo y agrego el nuevo usuario.
                Pass_Users pass_user2 = new Pass_Users();
                pass_user2.setSitio(sitio.getText());
                pass_user2.setUser(text_usuario.getText());
                pass_user2.setPass(text_pass.getText());
                pass_user2.setId_usuario(id_usuarios);
                // guardo el usuario
                dao.agregar_passUsers(pass_user2);
                // limpio los campos
                text_usuario.setText("");
                text_pass.setText("");
                sitio.setText("");
                sitio.requestFocus();
                // muestro los datos en la tabla.
                evento_mostrar(event);
                // por ultimo cambio la descripcion del boton.
                editar.setText("Editar");
                click = true;
            }
        } else{
        
            JOptionPane.showMessageDialog(null, "Por favor seleccione un campo de la tabla","AVISO",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    // evento que ingresa una password nuevo.
     @FXML
    void evento_ingresar(ActionEvent event) {
        
        dao = new usuarioDAO();
        users = new misUsuarios();
        lista = dao.getUserAll();
        // cargo los datos de ingreso
        String s = sitio.getText();
        String user = text_usuario.getText();
        String pass = text_pass.getText();
        int id_u =id_usuarios;
        /* 
         creamos un objeto de tipo pass_users
         posteriormente le pasamos los datos de el usuario
         y contraseña que esta guardando el usuario que inicio sesion
          */
        Pass_Users u = new Pass_Users(s, user, pass, id_u);
        dao.agregar_passUsers(u);
        sitio.setText("");
        text_usuario.setText("");
        text_pass.setText("");
        sitio.requestFocus();
        Pass_Users u1 = new Pass_Users();
        u1.setSitio(s);
        u1.setUser(user);
        u1.setPass(pass);
        list.add(u1);
        table.setItems(list);
        
    }
    
    // evento que muestra las datos dependiendo de la cuenta seleccionada.
     @FXML
    void evento_mostrar(ActionEvent event) {
        
        //si la lista esta llena se limpia
        ObservableList<Pass_Users> list4 = table.getItems();
        
        if(!list4.isEmpty()){
            
            list4.clear();
            List<Pass_Users> lista1 = dao.getPass_UsersAll(id_usuarios);

            for (Pass_Users e : lista1) {

                list.add(e);
            }
            table.setItems(list);
        }else{
            
            // agrego los elementos.
         List<Pass_Users> lista1 = dao.getPass_UsersAll(id_usuarios);

         for (Pass_Users e : lista1) {

             list.add(e);
         }
         table.setItems(list);
        
        }
    }
    
    // evento que ayuda a limpiar los campos.
    @FXML
    void event_limpiar(ActionEvent event) {
        
        ObservableList<Pass_Users> list_limpiar = table.getItems();
        list_limpiar.clear();
        table.setItems(list_limpiar);
        text_usuario.setText("");
        text_pass.setText("");
        sitio.setText("");
        sitio.requestFocus();
        
    }
    
     @FXML
    void evento_eliminar(ActionEvent event) {
        
        Pass_Users selectedPass = table.getSelectionModel().getSelectedItem();
        
        if(selectedPass != null){
            
            String user1= selectedPass.getUser();
            dao.eliminar_pass_user(user1);
            evento_mostrar(event);
        } else{
            
            JOptionPane.showMessageDialog(null, "Por favor seleccione un campo de la tabla","AVISO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /*
    private void loadStage(String url, Event event) {
        try{
            
            // obtenemos el evento, para luego obtener la scene y la ventana anterior
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
           
            
        }catch(IOException e){
            
            JOptionPane.showMessageDialog(null, e,"Error al cambiar de scene",
                    JOptionPane.ERROR_MESSAGE);
            
        }
     }
*/
}
