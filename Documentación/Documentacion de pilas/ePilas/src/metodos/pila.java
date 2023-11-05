/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;
import javax.swing.JOptionPane;
import java.util.Calendar;

/**
 *
 * @author Ruben
 */
public class pila {
    nodo tope;
    
    pila(){
        tope=null;
    }
    
    int getlogPila(){
        int cont=0;
        if(tope==null)
            return 0;
        else{
            nodo p=tope;
            do{
                cont++;
                p=p.sig;
            }while(p!=tope);
            return cont;
        }
    }
    
    nodo getBuscarPeli(int id){
        if(tope==null)
            return null;
        else{
            nodo p=tope;
            do{
                if(id==p.idPelicula)
                    return p;
                p=p.sig;
            }while(p!=tope);
            return null;
        }
    }
    
    void setEstadoP(int id){
        
        nodo p=getBuscarPeli(id);
        if(p==null){
            JOptionPane.showMessageDialog(null, 
            "Esta pelicula no esta registrada!");
        }else{
            if(p.estado==true){
                //Obtiene la fecha actual del sistema
                Calendar c=Calendar.getInstance();
                //Obtener los datos de la fecha
                int ano, mes, diaDelmes;
                ano=c.get(Calendar.YEAR);
                mes=c.get(Calendar.MONTH);
                diaDelmes=c.get(Calendar.DAY_OF_MONTH);
                p.fechaP=""+diaDelmes+"/"+mes+"/"+ano;
                p.estado=false;
                JOptionPane.showMessageDialog(null, 
                "Pelicula con id: "+p.idPelicula+" fue prestada!");
            }else{
                JOptionPane.showMessageDialog(null, 
                "La pelicula no esta disponible!");
            }
        }
    }
    
    void setEstadoE(int id){
        
        nodo p=getBuscarPeli(id);
        if(p==null){
            JOptionPane.showMessageDialog(null, 
            "Esta pelicula no esta registrada!");
        }else{
            if(p.estado==false){
                p.fechaP="";
                p.estado=true;
                JOptionPane.showMessageDialog(null, 
                "Pelicula con id: "+p.idPelicula+" fue entregada!");
            }else{
                JOptionPane.showMessageDialog(null, 
                "La pelicula esta disponible!");
            }
        }
    }
    
    boolean getEsvacia(){
        return tope==null?true:false;
    }
    
    nodo setCrearNodo(){
        int id;
        String nomp;
        id=Integer.parseInt(JOptionPane.showInputDialog(
        "Entre IdPelicula: "));
        nodo p=getBuscarPeli(id);
        if(p==null){
            nomp=JOptionPane.showInputDialog(
            "Entre nombre de pelicula: ");
            nodo q=new nodo(id, nomp);
            return q;
        }else{
            JOptionPane.showMessageDialog(null, 
            "IdPelicula ya se encuentra registrado!");
            return null;
        }
    }
    
    void setPush(){
        
        nodo q=setCrearNodo();
        if(q!=null){
            if(tope==null){
                tope=q;
                tope.sig=tope;
                JOptionPane.showMessageDialog(null, 
                "Elemento agregado!, Pila estaba vacia...");
            }else{
                nodo p=tope;
                do{
                    p=p.sig;
                }while(p.sig!=tope);
                q.sig=tope;
                p.sig=q;
                tope=q;
                JOptionPane.showMessageDialog(null, "Elemento agregado!");
            }
        }
    }
    
    void setPoP(){
        if(tope==null)
            JOptionPane.showMessageDialog(null, 
            "La pila no tiene elementos!");
        else{
            nodo p=tope;
            if(tope.sig==tope){
                tope=null;
                JOptionPane.showMessageDialog(null, 
                "Elemento eliminado, Pila vacía!");
            }
            else{    
                do{
                    p=p.sig;
                }while(p.sig!=tope);
                p.sig=tope.sig;
                nodo q=tope;
                tope=tope.sig;
                q.sig=null;
                q=null;
                JOptionPane.showMessageDialog(null, "Desapilado!");
            }
        }
    }
    
    void getInfoPeli(int id){
        nodo p=getBuscarPeli(id);
        if(p==null)
            JOptionPane.showMessageDialog(null, 
            "Esta pelicula no se encuentra registrada!");
        else{
            String aux="Información de la pelicula \n";
            aux+="IdPelicula: "+p.idPelicula+"\n";
            aux+="Nombre pelicula: "+p.nomPelicula+"\n";
            aux+="Fecha Prestamo: "+p.fechaP+"\n";
            aux+="Estado: "+p.estado+"\n";
            JOptionPane.showMessageDialog(null, aux);
        }
    }
    
    void setPushData(nodo q){
        nodo p=getBuscarPeli(q.idPelicula);
        if(p==null){
            if(tope==null){
                tope=q;
                tope.sig=tope;
            }else{
                p=tope;
                do{
                    p=p.sig;
                }while(p.sig!=tope);
                q.sig=tope;
                p.sig=q;
                tope=q;                
            }
        }
    } 
    
    //Este método desapila de la pila original
    //dado un un idPelicula
    void setPoPId(int id){
        
        pila paux=null;
        nodo p=null, q=null, aux=null;
        if(tope==null){
            JOptionPane.showMessageDialog(null, 
            "Pila vacia!");
        }else{
            if((tope.sig==tope)&&(tope.idPelicula==id)){
                tope=null;
                JOptionPane.showMessageDialog(null, 
                "Atendido! Pila esta vacia...");
            }else{
                //Desapilamos elementos y copiamos 
                //a una pila auxiliar
                paux=new pila();
                p=getBuscarPeli(id);
                q=tope; 
                aux=null;
                while(q!=p){
                    //Apilamos elemento 
                    //temporalmente a una pila auxiliar
                    aux=new nodo(
                    q.idPelicula, q.nomPelicula, q.fechaP, q.estado);
                    paux.setPushData(aux);                    
                    q=q.sig;
                    //Eliminamos elemento de la pila original
                    setPoP();
                    aux=null;
                }
                //Eliminamos elemento con idPelicula dado
                setPoP();
                if(tope==null){
                    tope=paux.tope;
                }else{
                    //Enlazamos pilas
                    aux=paux.tope;
                    while(aux.sig!=paux.tope)
                        aux=aux.sig;                
                    p=tope;
                    while(p.sig!=tope)
                        p=p.sig;                
                    p.sig=paux.tope;
                    aux.sig=this.tope;
                    this.tope=paux.tope;
                    paux.tope=null;
                }
            }
        }
    }
}
