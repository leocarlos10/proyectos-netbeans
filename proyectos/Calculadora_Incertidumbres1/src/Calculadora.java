
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Leocarlos.
 * 
 */
public class Calculadora {
    
    private float tiempos[][];
    float promedio[];
    float desviacion[];
    String nombrestiempo[];
    
    int filas;
    int col;
    
    public Calculadora(){
        // pedimos las filas y columnas
        int filas=Integer.parseInt(JOptionPane.showInputDialog(" digite las filas(dependiendo del numero de metros) "));
        int col=Integer.parseInt(JOptionPane.showInputDialog(" digite las columnas(dependiendo de el numero de tiempos) "));
        // inicializamos los atributos filas y columnas.
        this.filas=filas;
        this.col=col;
        
        tiempos= new float[col][filas];
        promedio = new float[col];
        nombrestiempo = new String[col];
        
        
        // inicializamos la matriz.
        for(int i=0;i<col;i++){
            
            for(int j=0;j<filas;j++){
                
                tiempos[i][j]=0;
            }
        }
        
        // inicializo promedio
        for(int i=0;i<promedio.length;i++){
            promedio[i]=0;
        }
        
        // inicializo el vector nombrestiempo
          for(int i=0;i<col;i++){
            nombrestiempo[i]="tiempo "+(i+1);
        }
    }
    
    
    // llenamos la matriz.
    public void setllenarMat(){
        
        String info="";
        for(int i=0;i<col;i++){
            for(int j=0;j<filas;j++){
                info=" ingrese los tiempos en la columna "+i+" fila"+j;
                tiempos[i][j]=Float.parseFloat(JOptionPane.showInputDialog(info));
            }
        }
    }
    
    public float[] sumas(){
        
        float sumas[]= new float[col];
        // inicializamos el vector suma para guardar las sumas de los tiempos.
        for(int i=0;i<sumas.length;i++){
            sumas[i]=0;
        }
        
        float p=0;
        
        for(int i=0;i<col;i++){
            
            for(int j=0;j<filas;j++){
                // va hacer una suma iterativa
               p+=tiempos[i][j];
            }
            /*
            cuando salga de este for anterior
            va a tener la suma de los tiempos de la 
            columna respectiva.
            por tanto guardo el valor en el vector suma 
            y refresco la variable.
            */
            sumas[i]=p;
            p=0;
        }
        return sumas;
    }
    
    public void promedio(){
        float prom[]= new float[col];
        // inicializo el vector
        for(int i=0;i<prom.length;i++){
            prom[i]=0;
        }
        
        float sumas[]=sumas();
        
         try{
            for(int i=0;i<col;i++){
                prom[i]=sumas[i]/filas;
            }
         }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        this.promedio=prom;
    }
    
    // calculamos la desviación estandar
    public void desviacionestandar(){
      // para calcular la desviacion estandar debemos hacer la suma de las resta de Xi-X elevado al cuadrado
      // luego dividirlo entre el numero de de datos de el tiempo, por ultimo se le saca Raiz cuadrada.

        float desviacionest[]=new float[col];
        float sum=0;
        float n=(float) filas;
        
        // inicializo vector local
        for(int i=0;i<desviacionest.length;i++){
            desviacionest[i]=0;
        }
        
        try{
            for(int i=0;i<col;i++){
            
                for (int j=0;j<filas;j++){
                
                sum+=Math.pow((tiempos[i][j]-promedio[i]), 2);
                }
                /*
                luego que termine de hacer la suma va a dividir el resultado y a sacarle raiz cuadrada
                */
            desviacionest[i]= (float) Math.sqrt((sum/n));
                // refrescamos la variable suma para que vuelva a repetir el proceso con el siguiente tiempo.
                sum=0;
            }
         }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        
       this.desviacion=desviacionest;
    }
    
    
    public void cargarDatos(DefaultTableModel modelo,int posv,int ptabla){
        
        modelo.setValueAt(nombrestiempo[posv], ptabla, 0);
        modelo.setValueAt(promedio[posv], ptabla, 1);
        modelo.setValueAt(desviacion[posv], ptabla, 2);  
    }
    
    // metodo que actualiza el JTable del Jframe.
    public void setllenarJTable(JTable tabla){
        
        int ptabla=0;
        int pv=0;
        // creamos el modelo
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Tiempos");
        modelo.addColumn("Promedio");
        modelo.addColumn("desviacion estandar");
        
        
        while(pv<col){
            modelo.addRow( new Object[] {"","",""});
            cargarDatos(modelo,pv,ptabla);
            pv++;
            ptabla++;
        }
        
        tabla.setModel(modelo);
    }
    
    public void limpiarM(){
        
       for(int i=0;i<col;i++){
           
           promedio[i]=0;
           desviacion[i]=0;
           nombrestiempo[i]="";
           
            for(int j=0;j<filas;j++){
                
                tiempos[i][j]=0;
            }
        }
    }
    
    public void limpiarJTable(JTable tabla){
        
         DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Tiempos");
        modelo.addColumn("Promedio");
        modelo.addColumn("desviacion estandar");
        
        tabla.setModel(modelo); 
        
    }
}
