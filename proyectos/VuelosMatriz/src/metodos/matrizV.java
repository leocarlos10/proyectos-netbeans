
package metodos;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruben
 * colaboradores: leocarlos y moises
 */
public class matrizV {
    
    int vuelos[][];
    String nombresdest[];
    int tf, tc;
    
    matrizV(){
        Exception band=null;
        
        try{
            tf = Integer.parseInt(JOptionPane.showInputDialog(
                "Entre cantidad de rutas disponibles: "));
            tc = Integer.parseInt(JOptionPane.showInputDialog(
                "Entre cantidad de jornadas disponibles (Mañana=1/Tarde=2/Noche=3): "));
        }catch(Exception e){
            band=e;
         JOptionPane.showMessageDialog(null, " Error, por favor revise los datos de ingreso");
        }
        // si no hay excepcion entra
        if(band==null){
            
            Exception band1=null;
            // de nuevo hacemos las verificaciones de los datos de entrada.
            try{
                nombresdest = new String[tf];
                // inicializo la array de nombresdest
                for(int e=0;e<tf;e++){
                    nombresdest[e]= JOptionPane.showInputDialog("entre el nombre del destino en la posición "+e);
                }

                vuelos = new int[tf][tc];
                //Cargamos la matriz con la cantidad de sillas disponibles
                //para cada vuelo.
                int i, j;
                for(i=0; i<tf; i++){
                    for(j=0; j<tc; j++){
                        if(j==0){
                            vuelos[i][j] = Integer.parseInt(JOptionPane.showInputDialog(
                            "Entre el número de sillas para el vuelo "+i+" en la jornada Mañana: "));
                        }else if(j==1){
                            vuelos[i][j] = Integer.parseInt(JOptionPane.showInputDialog(
                            "Entre el número de sillas para el vuelo "+i+" en la jornada Tarde: "));
                        }else{
                            vuelos[i][j] = Integer.parseInt(JOptionPane.showInputDialog(
                            "Entre el número de sillas para el vuelo "+i+" en la jornada Noche: "));
                        }
                    }
                }
            }catch(Exception e){
                band1=e;
                JOptionPane.showMessageDialog(null, " Error, por favor revise los datos de ingreso");
            }
        }
    }
    
    //Comprar tiquetes
    public void setCompraTiquetes(){
        int Pvuelo=0, Pjornada=0, cant=0;
        
        try{
            Pvuelo = Integer.parseInt(JOptionPane.showInputDialog(
                "Entre el número del vuelo de interes: "
            ));
            //Validamos si el vuelo existe
            if((Pvuelo>=0)&&(Pvuelo<tf)){
                Pjornada = Integer.parseInt(JOptionPane.showInputDialog(
                    "Entre jornada del vuelo Mañana=0/Tarde=1/Noche=2: "
                ));
                //Validamos si la jornada existe
                if((Pjornada>=0)&&(Pjornada<tc)){
                    cant = Integer.parseInt(JOptionPane.showInputDialog(
                        "Entre la cantidad de tiquetes a comprar: "
                    ));
                    if(cant<0)
                        JOptionPane.showMessageDialog(null, "Error!!! "
                           + "La cantidad de tiquetes a comprar debe ser positiva.");
                    else{
                        if(cant>vuelos[Pvuelo][Pjornada]){
                            if(Pjornada==0)
                                JOptionPane.showMessageDialog(null, 
                                    "Error: El vuelo en la posición "+Pvuelo+" de la "
                                    + "jornada de la mañana, tiene puestos insuficientes!");
                            else if (Pjornada==1)
                                JOptionPane.showMessageDialog(null, 
                                    "Error: El vuelo en la posición "+Pvuelo+" de la "
                                    + "jornada de la tarde, tiene puestos insuficientes!");
                            else
                                JOptionPane.showMessageDialog(null, 
                                    "Error: El vuelo en la posición "+Pvuelo+" de la "
                                    + "jornada de la noche, tiene puestos insuficientes!");
                        }else{
                            if(Pjornada==0){
                                vuelos[Pvuelo][Pjornada] -= cant;
                                JOptionPane.showMessageDialog(null, 
                                    "Para el vuelo en la posición "+Pvuelo+" de la "
                                    + "jornada de la mañana, se vendieron "+cant+" puestos "
                                    + "quedan disponibles: "+vuelos[Pvuelo][Pjornada]);
                            }else if (Pjornada==1){
                                vuelos[Pvuelo][Pjornada] -= cant;
                                JOptionPane.showMessageDialog(null, 
                                    "Para el vuelo en la posición "+Pvuelo+" de la "
                                    + "jornada de la tarde, se vendieron "+cant+" puestos "
                                    + "quedan disponibles: "+vuelos[Pvuelo][Pjornada]);
                            }else{
                                vuelos[Pvuelo][Pjornada] -= cant;
                                JOptionPane.showMessageDialog(null, 
                                    "Para el vuelo en la posición "+Pvuelo+" de la "
                                    + "jornada de la noche, se vendieron "+cant+" puestos "
                                    + "quedan disponibles: "+vuelos[Pvuelo][Pjornada]);
                            }
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, 
                        "Error: La jornada solicitada no existe!!!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, 
                    "Error: El vuelo solicitado no existe!!!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void getObtenerDisponibles(){
        int Pvuelo=0, Pjornada=0;
        
        try{
            Pvuelo = Integer.parseInt(JOptionPane.showInputDialog(
                "Entre el número del vuelo de interes: "
            ));
            //Validamos si el vuelo existe
            if((Pvuelo>=0)&&(Pvuelo<tf)){
                Pjornada = Integer.parseInt(JOptionPane.showInputDialog(
                    "Entre jornada del vuelo Mañana=0/Tarde=1/Noche=2: "
                ));
                //Validamos si la jornada existe
                if((Pjornada>=0)&&(Pjornada<tc)){
                    
                    if(Pjornada==0)
                        JOptionPane.showMessageDialog(null, 
                            "Para el vuelo en la posición "+Pvuelo+" de la "
                            + "jornada de la mañana, tiene "+vuelos[Pvuelo][Pjornada]
                            +"puestos disponibles!");
                    else if (Pjornada==1)
                        JOptionPane.showMessageDialog(null, 
                            "Para el vuelo en la posición "+Pvuelo+" de la "
                            + "jornada de la tarde, tiene "+vuelos[Pvuelo][Pjornada]
                            +"puestos disponibles!");
                    else
                        JOptionPane.showMessageDialog(null, 
                            "Para el vuelo en la posición "+Pvuelo+" de la "
                            + "jornada de la noche, tiene "+vuelos[Pvuelo][Pjornada]
                            +"puestos disponibles!");
                }
                else
                    JOptionPane.showMessageDialog(null, 
                        "Error: La jornada no existe!!");
            }
            else
                JOptionPane.showMessageDialog(null, 
                "Error: El vuelo no existe!!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void getdestinos_mayor_puesto(){
        
        int mayor=vuelos[0][0];
        String nombre="";
        
        for(int i=0;i<tf;i++){
            
            for(int j=0;j<tc;j++){
                
                if(vuelos[i][j]>mayor){
                    
                    mayor=vuelos[i][j];
                    nombre=nombresdest[i];
                }
            }
        }
        getMostrar("Destino con mayor numero de puestos ",mayor,nombre);
    }
    
    public void getdestinos_menor_puesto(){
        
        int menor=vuelos[0][0];
        String nombre_m="";
        
        for(int i=0;i<tf;i++){
            
            for(int j=0;j<tc;j++){
                
                if(vuelos[i][j]<menor){
                    
                    menor=vuelos[i][j];
                    nombre_m=nombresdest[i];
                }
            }
        }
        getMostrar("Destino con menor numero de puestos ",menor,nombre_m);
    }
    
    
    public void setllenarJTable(JTable tabla){
        
        int i=0,j=0;
        Exception band=null;
        
        // creamos el modelo
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Destinos");
        modelo.addColumn("Mañana");
        modelo.addColumn("Tarde");
        modelo.addColumn("Noche");
        
        try{
            for(i=0;i<tf;i++){
                modelo.addRow(new Object[tc]);
                modelo.setValueAt(nombresdest[i], i, 0);
                for(j=0;j<tc;j++){
                    modelo.setValueAt(vuelos[i][j], (i), (j+1));
                }
            }
        }catch(Exception e){
            band=e;
        }
        // si no hubo excepcion se actualiza 
        if(band==null)
            tabla.setModel(modelo);
    }
    
    public void seteliminar(){
        
       for(int i=0;i<tf;i++){
           
           nombresdest[i]="";
           for(int j=0;j<tc;j++){
               
               vuelos[i][j]=0;
           }
       }
    }
    
    public void setLimpiarJTable(JTable tabla){
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Destinos");
        modelo.addColumn("Mañana");
        modelo.addColumn("Tarde");
        modelo.addColumn("Noche");
        
        tabla.setModel(modelo);
    }
    
    public void getMostrar(String inf, int estado, String nombre){
        String info = inf+" \n";
                      info+="- "+nombre+" = "+estado;
        
        JOptionPane.showMessageDialog(null,info);
    }
}
