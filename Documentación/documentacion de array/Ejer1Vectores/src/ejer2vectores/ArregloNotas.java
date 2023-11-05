package ejer2vectores;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author USUARIO
 */
public class ArregloNotas {

    public int elementos;
    public float NotasEst[];
    public String NombresEst[];

    public ArregloNotas() {
    }

    public void TamañoVec() {
        int i;
        elementos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de elementos que quiere agregar"));

        NotasEst = new float[elementos];
        NombresEst = new String[elementos];

        for (i = 0; i < NotasEst.length; i++) {

            NombresEst[i] = JOptionPane.showInputDialog("Digite el nombre en la posicion" + (i + 1));
            //Validando ingreso de notas
            //Estas ason mis correcciones!!
            do{
                NotasEst[i] = Float.parseFloat(JOptionPane.showInputDialog("Digite la nota en la posicion" + (i + 1)));
                if((NotasEst[i]<0)||(NotasEst[i]>5)) // asi se comparan valores que esten fuera de un intervalo dado obs
                    JOptionPane.showMessageDialog(null, 
                    "Error: Nota invalida!! Ingrese entre [0 a 5].");
            }while((NotasEst[i]<0)||(NotasEst[i]>5));

        }

        /*
        for (i = 0; i < NotasEst.length; i++) {

            if (NotasEst[i] > 5) {
                JOptionPane.showMessageDialog(null, "Tenga en cuenta que la nota que esta digitando debe ser entre 0.1 y 5");
            }
            if (NotasEst[i] < 0) {
                JOptionPane.showMessageDialog(null, "Tenga en cuenta que la nota que esta digitando debe ser entre 0.1 y 5");
            }
        }
        */
    }

    public void Notasentre3y4() {

        int NE34 = 0;
        int i;

        for (i = 0; i < NotasEst.length; i++) {

            if (NotasEst[i] >= 3 && NotasEst[i] <= 4) { // asi se comparan valores que esten dentro de un intervalo dado obs.
                NE34+= 1; 
            }

        } 
        JOptionPane.showMessageDialog(null, "El numero total de notas entre 3 y 4 es de: " + NE34);

    }

    public void NotasSup4() {

        int NS4 = 0;
        int i;

        for (i = 0; i < NotasEst.length; i++) {

            if (NotasEst[i] >= 4) {

                NS4 += 1;
            }
        }

        JOptionPane.showMessageDialog(null, "El numero total de notas mayores a 4.0 es: " + NS4);

    }

    public int NotasReprob() {
        int NR = 0;
        int i;

        for (i = 0; i < NotasEst.length; i++) {
            if (NotasEst[i] < 3) {

                NR += 1;
            }
        } // modificaciones realizadas por leocarlos ospina 
        if(NR>0){
            JOptionPane.showMessageDialog(null, "El numero total de reprobadas es: " + NR);
        } 
         else if(NR<=0){
            JOptionPane.showMessageDialog(null, " No hay Notas reprobadas ");
        }
        return NR;
    }

    public void PromedioNotasR() {
        float PNR =0;
        int i;

        for (i = 0; i < NotasEst.length; i++) {
            if (NotasEst[i] < 3) {
                PNR += NotasEst[i];
            }

        } // modificacion realizada por leoacarlos ospina 
        PNR = (PNR / NotasReprob());
        JOptionPane.showMessageDialog(null, "El promedio de notas reprobadas es  " + PNR);
        
    }

    public void PromedioGen() {

        float PG = 0;
        int i;

        for (i = 0; i < NotasEst.length; i++) {
            PG += NotasEst[i];
        }

        PG = PG / NotasEst.length;

        JOptionPane.showMessageDialog(null, "El promedio general de notas es de  " + PG);

    }
// debo aprender a como llenar estos jtable con codigo.
    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
            int Fila, int indiceArray) {

        miModelo.setValueAt(NombresEst[indiceArray], Fila, 0);
        miModelo.setValueAt(NotasEst[indiceArray], Fila, 1);
    }

    public void setLlenarJTable(JTable tab) {
        int indice = 0; //Este índice recorre los elementos del ArrayList
        int i = 0;  //Este índice para ubicar posición de fila en el JTable
        DefaultTableModel miModelo = new DefaultTableModel();
        miModelo.addColumn("Nombre del Estudiante");
        miModelo.addColumn("Nota");
        while (indice < NombresEst.length) {
            miModelo.addRow(new Object[]{"", ""});
            setRegistrarFilaJTable(miModelo, i, indice);
            i++;
            indice++;
        }
        tab.setModel(miModelo);
    }

}
