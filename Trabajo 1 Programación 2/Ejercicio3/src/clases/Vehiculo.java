/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.Duration;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Vehiculo {
    
    private String n_placa;
    public  enum tipo_vehiculo {AUTOMOVIL,MOTOCICLETA,CAMIONETA}
    private String t_vehiculo;
    private LocalDateTime fecha_hora_ingreso;
    private LocalDateTime fecha_hora_salida;
    public double valor_pagar;
    public double tiempo_estacionamiento;

    public Vehiculo(String n_placa,String t_vehiculo, LocalDateTime fecha_hora_ingreso, LocalDateTime fecha_hora_salida) {
        this.n_placa = n_placa;
        this.fecha_hora_ingreso = fecha_hora_ingreso;
        this.fecha_hora_salida = fecha_hora_salida;
        this.t_vehiculo=t_vehiculo;
    }
    
    public Vehiculo(){
    
    }

    public String getT_vehiculo() {
        return t_vehiculo;
    }

    public void setT_vehiculo(String t_vehiculo) {
        this.t_vehiculo = t_vehiculo;
    }
    
    public String getN_placa() {
        return n_placa;
    }

    public void setN_placa(String n_placa) {
        this.n_placa = n_placa;
    }

    public LocalDateTime getFecha_hora_ingreso() {
        return fecha_hora_ingreso;
    }

    public void setFecha_hora_ingreso(LocalDateTime fecha_hora_ingreso) {
        this.fecha_hora_ingreso = fecha_hora_ingreso;
    }

    public LocalDateTime getFecha_hora_salida() {
        return fecha_hora_salida;
    }

    public void setFecha_hora_salida(LocalDateTime fecha_hora_salida) {
        this.fecha_hora_salida = fecha_hora_salida;
    }
    
   public double getTiempo_estacionamiento(Vehiculo v){
       
        Duration duracion = Duration.between(fecha_hora_ingreso, fecha_hora_salida);
        double tiempo_est = (double) duracion.toMinutes() / 60.0;
        return tiempo_est;
   }
    
    
    public double getValor_pagar(Vehiculo v){
        
        double tiempo_est = getTiempo_estacionamiento(v);
        double valor_a_pagar = 0;
        double costo_hora = 0;

        // verificamos que costo debe tener el vehiculo segun su tipo
        if(v.getT_vehiculo().equals("AUTOMOVIL") || v.getT_vehiculo().equals("CAMIONETA")){
            
            costo_hora=2000;
            
        }else if(v.getT_vehiculo().equals("MOTOCICLETA") ){
            
            costo_hora=1000;
            
        }
        
        // calculamos el valor a pagar
        valor_a_pagar = costo_hora *tiempo_est;
        
        // esto nos va ayudar a capturar el valor a pagar de cada vehiculo para posteriormente ordenarlos descendentemente.
        this.valor_pagar=valor_a_pagar;
        this.tiempo_estacionamiento= tiempo_est;
        return valor_a_pagar;
    }
    
    public void setMostrar_datos(Vehiculo v){
        
        
        double valor_a_pagar=getValor_pagar(v);
        double tiempo_est=getTiempo_estacionamiento(v);
        
        String info = 
                "fecha y hora de ingreso: "+v.getFecha_hora_ingreso()
                +"\n fecha y hora de salida:"+v.getFecha_hora_salida()
                +"\nTiempo de estacionamiento: "+tiempo_est
                +"\nVALOR A PAGAR: "+valor_a_pagar;
        
        // por ultimo mostramos la info con un JOptionPane
        JOptionPane.showMessageDialog(null, info);
    }
    
}
