
package com.mycompany.curso_jframe;

import javax.swing.*;
import javax.swing.JFrame;


// Aprendiendo JFrame 

    public class Formulario extends JFrame {

         public Formulario(){

           initcomponets();

        }

    public void initcomponets(){
    
        setSize(500,500);// con este metodo inicializamos el tamaño de el JFame
        setTitle("Formulario de ejemplo"); // con este metodo le agrego un titulo a el jFrame 
        setDefaultCloseOperation(EXIT_ON_CLOSE);// con este metodo cuando yo le de en la x automaticamente la ventana se va a cerrrar
       // ademas del metodo setLocationRelativeTO(null);
       // con el metodo setLocation(x,y); podemos ubicar la ventana en cualquier parte de la pantalla
       //setBounds(450, 150, 500, 500); podemos combinar setSize con setLocation para ubicar y darle el tamaño al mismo

        setResizable(false); // este metodo lo que hace es que no deja que el usuario no pueda maximizar ni modificar la ventana.
        JPanel panel = new JPanel();// creacion de un panel
        panel.setLayout(null); // desactivamos el Layoaut osea la ubicacion por defecto.
        this.getContentPane().add(panel); // this para referirnos a la clase formulario getContentPane() ayuda a almacenar la ventana y add() para agregar el panel a la ventana
//        jp1.setBackground(Color.red); metodo para agregar color a los paneles e incluso a el JFrame 
       
      
        JLabel etiqueta = new JLabel("hola !!"); // creacion de una etiqueta.
//        etiqueta.setText("hola "); tambien podemos agregar etiquetas de esta forma.
        panel.add(etiqueta);// luego para agregarla a el panel utilizamos el obj panel antes creado y con el metodo add agregamos la etiqueta.
        etiqueta.setBounds(50, 50, 50, 30); // este metodo le da el tamaño y la ubicacion a las etiquetas.
         
         
    } 
     
     
     
     
     
     
     // no es necesario utilizar otra clase para hacer el metodo main para poder mostrar el JFrame lo podemos hacer en la misma clase del JFrame.
      public static void main(String[] args) {
      
          Formulario obj = new Formulario();
          
          obj.setVisible(true); // por defecto en java los JFrame estan invisbles entonces con este metodo los hacemos visibles.
          obj.setLocationRelativeTo(null); // con este metodo hacemos que la pantallita del JFrame se muestre en el centro de nuestra computadora.
         
    }
 
}
