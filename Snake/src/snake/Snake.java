
/*
intenta modificarlo :)
lo rompi a proposito :) si  puedes arreglarlo eres un crack 
*/


package snake;
        
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;

public class Snake extends JFrame implements ActionListener, KeyListener {

    int puntaje;
    String tablero[][] = new String[100][100];
    JButton Cerrar;
    Random Ram = new Random();

    int Y = 0;
    int X = 0;

    // Verifica el ultimo movimiento
    private  String Ultimo_Movimiento = "3";

    public  void setUltimoMove( String a ){
        Ultimo_Movimiento = a;

    }

    int AY = Ram.nextInt(19);
    int AX = Ram.nextInt(19);

    public Snake() {
    }

    public void Inicio_Juego(){
        setLayout(null);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                this.tablero[i][j] = " ";
            }
        }
      
        super.setResizable(false);
        super.setBounds(0, 0, 2000, 1500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.addKeyListener(this);
        Cerrar = new JButton("Regresar");
        Cerrar.setBounds(300, 420, 100, 40);
        Cerrar.addActionListener(this);

        Jugando();
    }

    public static void main(String[] args) {
        /* Create and display the form */
        // Snake a = new Snake();
         Snake a = new Snake();
         a.Inicio_Juego();

    }

    public void reinicio() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                this.tablero[i][j] = " ";
            }
        }

    }

    public void Jugando() {

        // this.cuerpo[0] = [1,1];

        ArrayList<Integer> Historial_Y = new ArrayList<Integer>();
        ArrayList<Integer> Historial_X = new ArrayList<Integer>();

        ArrayList<Integer> Cuerpo_Y = new ArrayList<Integer>();
        ArrayList<Integer> Cuerpo_X = new ArrayList<Integer>();

        Historial_Y.add(Y);
        Historial_X.add(X);

        Cuerpo_Y.add(Y);
        Cuerpo_X.add(X);
        Historial_Y.add(Y);
        Historial_X.add(X);

        Cuerpo_Y.add(Y);
        Cuerpo_X.add(X);

        // this if for the body and the position of the snake

        while (true) {
            // El solo echo de colocar esto lo cambió todo

            paint(getGraphics());

            if (Ultimo_Movimiento.equals("1")) {
                Y += 1;
            } else if (Ultimo_Movimiento.equals("2")) {
                Y -= 1;

            } else if (Ultimo_Movimiento.equals("3")) {
                X += 1;
            } else if (Ultimo_Movimiento.equals("4")) {
                X -= 1;
            }

            try {
                if (tablero[Y][X].equals("0")){
                    super.dispose();

                    JOptionPane.showMessageDialog(null, "Has Perdido tu puntaje es : " + puntaje);

                    Snake a = new Snake();
                    a.Inicio_Juego();

                    break;
                }
            } catch (Exception e) {

                super.dispose();
                JOptionPane.showMessageDialog(null, "Has Perdido tu puntaje es : " + puntaje);

                Snake a = new Snake();
                    a.Inicio_Juego();

                break;
            }

            if (tablero[Y][X].equals( "+")) {
                AY = Ram.nextInt(19);
                AX = Ram.nextInt(19);

                Cuerpo_Y.add(Y);
                Cuerpo_X.add(X);

                tablero[Y][X] = "0";
                puntaje += 1;
            }

            this.tablero[Y][X] = "0";

            this.tablero[AY][AX] = "+";

            System.out.println();

            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    System.out.print(tablero[i][j]);
                }
                System.out.println();
            }

            if (Historial_Y.size() + 1 != Cuerpo_Y.size()) {

                Historial_X.remove(0);
                Historial_Y.remove(0);

            } else {

                for (int index = 0; index < Historial_X.size(); index++) {
                    tablero[Historial_Y.get(index)][Historial_X.get(index)] = "0";
                }
            }

            Historial_Y.add(Y);
            Historial_X.add(X);

            tablero[Historial_Y.get(0)][Historial_X.get(0)] = " ";

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    }

    // this is for close the window
    @Override
    public void actionPerformed(ActionEvent ee) {
        // TODO Auto-generated method stub
        if (ee.getSource() == Cerrar) {

            super.dispose();
           
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            System.out.println("Presionó Enter!" + (char) key);
            Ultimo_Movimiento = "4";

        } else if (key == KeyEvent.VK_UP) {

            System.out.println("Presionó Enter!" + (char) key);

            Ultimo_Movimiento = "2";

        } else if (key == KeyEvent.VK_DOWN) {

            System.out.println("Presionó Enter!" + (char) key);

            Ultimo_Movimiento = "1";

        } else if (key == KeyEvent.VK_RIGHT) {

            System.out.println("Presionó Enter!" + (char) key);

            Ultimo_Movimiento = "3";

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 1000, 1000);

        g.setColor(new Color(255, 255, 255));
        g.drawRect(60, 40, 1000, 1000);
        g.drawString("Este Juego Fue Creado por caleb  ", 180, 470);

        g.setColor(new Color(255, 255, 255));
        g.drawRect(60, 40, 1000, 1000);
        g.drawString("Tu puntage es " + puntaje, 60, 470);

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {

                if (tablero[i][j].equals("0")) {
                    g.setColor(new Color(0, 150, 10));
                    g.fillRect((j * 20) + 60, (i * 20) + 40, 20, 20);

                }

                else if (tablero[i][j].equals("+")) {
                    g.setColor(new Color(255, 10, 10));
                    g.fillRect((j * 20) + 60, (i * 20) + 40, 20, 20);
                }

            }

        }

    }

}