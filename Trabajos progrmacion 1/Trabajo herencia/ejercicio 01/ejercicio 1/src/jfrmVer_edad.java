
import javax.swing.JOptionPane;
/**
 *
 * @author Leocarlos y moises
 */
public class jfrmVer_edad extends javax.swing.JFrame {

    ventana jfrmVer;
    
     public jfrmVer_edad(ventana aux) {
        initComponents();
        jfrmVer=aux;
         setLocationRelativeTo(null);
    }
    
    public jfrmVer_edad() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        verificar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Verificacion de edad");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Ingrese el nombre de la persona a verificar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        verificar.setText("Verificar");
        verificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarActionPerformed(evt);
            }
        });

        cerrar.setText("cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(verificar)
                .addGap(18, 18, 18)
                .addComponent(cerrar)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verificar)
                    .addComponent(cerrar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
     dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void verificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarActionPerformed
        
        String nom=nombre.getText();
        Persona p =null;
        Cliente c=null;
        Administrador a=null;
        boolean verf_edad_c=false;
        boolean verf_edad_a=false;
        boolean band=false; // variable para saber si existe o no la persona consultada

       for(int i=0;i<jfrmVer.jfrmpri.persona.size();i++){
           p=jfrmVer.jfrmpri.persona.get(i);
           if(p.Tp==0 ){
                c= (Cliente) jfrmVer.jfrmpri.persona.get(i);
                    if(c.nombre.equalsIgnoreCase(nom)) { 
               
                        verf_edad_c=c.esMayoredad();
                        if(verf_edad_c!=true){

                            JOptionPane.showMessageDialog(null," El cliente que consulto es menor de edad");
                            nombre.setText("");
                            nombre.requestFocus();
                            band =true;
                        
                        }
                        else{
                          JOptionPane.showMessageDialog(null," El cliente que consulto es mayor de edad");
                          nombre.setText("");
                          nombre.requestFocus();
                          band =true;
                         
                        }
                    }
                    
           }
           else{
               a= (Administrador) jfrmVer.jfrmpri.persona.get(i);
               if(a.nombre.equalsIgnoreCase(nom)){
                    verf_edad_a= a.esMayoredad();
                    if(verf_edad_a!= true){
                        JOptionPane.showMessageDialog(null," El Administrador que consulto es menor de edad");
                        nombre.setText("");
                        nombre.requestFocus();
                        band =true;
                      
                    }
                    else{
                        JOptionPane.showMessageDialog(null," El Administrador que consulto es mayor de edad");
                        nombre.setText("");
                        nombre.requestFocus();
                        band =true;
                        
                    }
               }
           } 
       }
       // si hizo todo los ciclos y no encontro un cliente o admin con el nombre consultado entonces esa persona no exise en la lista
       if(band==false){
           
           JOptionPane.showMessageDialog(null," La persona consultado no existe" );
           nombre.setText("");
           nombre.requestFocus();
       }
    }//GEN-LAST:event_verificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfrmVer_edad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmVer_edad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmVer_edad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmVer_edad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmVer_edad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton verificar;
    // End of variables declaration//GEN-END:variables
}
