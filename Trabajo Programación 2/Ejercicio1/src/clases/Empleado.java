/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author USUARIO
 */
public class Empleado {
    
    private int id_empleado;
    private String nombre;
    private String genero;
    private int horas_Trab;
    private float salario_B;
    private int estrato;
    private float horasExtra;
    private LocalDate fecha_vin;

    public Empleado(int id_empleado, String nombre, String genero, int horas_Trab, float salario_B, int estrato, float horasExtra, LocalDate fecha_vin) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.genero = genero;
        this.horas_Trab = horas_Trab;
        this.salario_B = salario_B;
        this.estrato = estrato;
        this.horasExtra = horasExtra;
        this.fecha_vin = fecha_vin;
    }

    public int getHoras_Trab() {
        return horas_Trab;
    }

    public void setHoras_Trab(int horas_Trab) {
        this.horas_Trab = horas_Trab;
    }
  
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getSalario_B() {
        return salario_B;
    }

    public void setSalario_B(float salario_B) {
        this.salario_B = salario_B;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public float getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(float horasExtra) {
        this.horasExtra = horasExtra;
    }

    public LocalDate getFecha_vin() {
        return fecha_vin;
    }

    public void setFecha_vin(LocalDate fecha_vin) {
        this.fecha_vin = fecha_vin;
    }
    
    public String getNeto_Pagar(){
        
        String info ="";
        float neto_pagar=0;
        float aporte_salud= salario_B - (salario_B*0.04f);
        float aporte_pension=salario_B - (salario_B*0.0375f);
        float ARL=salario_B - (salario_B*0.02f);
        float devegando_hrs_extra=0;
        float subsidio_tte=0;
        float valor_H_E=0;
        
        // calculo la diferencia entre las fechas
        Period periodo = Period.between(fecha_vin, LocalDate.now());
        // obtnemos los años.
        int annos = periodo.getYears();
        
        if(annos>10){
            
            valor_H_E=45000;
            devegando_hrs_extra=horas_Trab*(horasExtra*valor_H_E);
            
        }else if((annos>=5) && (annos<=10)){
            
             valor_H_E=35000;
            devegando_hrs_extra=horas_Trab*(horasExtra*valor_H_E);
            
        }else if((annos>=3) && (annos<=5)){
            
             valor_H_E=30000;
            devegando_hrs_extra=horas_Trab*(horasExtra*valor_H_E);
            
        }else if(annos<3){
            
             valor_H_E=25000;
            devegando_hrs_extra=horas_Trab*(horasExtra*valor_H_E);
        }
        
        if(estrato==1 || estrato ==2){
            
            subsidio_tte=78000;
        }
        
        // por ultimo calculamos el neto a pagar
        neto_pagar = aporte_salud + aporte_pension + ARL + devegando_hrs_extra + subsidio_tte;
        
        return info= "sueldo basico: "+salario_B
                +"\n H.E Laboradas: "+horasExtra
                +"\n valor H.E:"+valor_H_E
                +"\n total_H.E: "+devegando_hrs_extra
                +"\n aporte salud: "+aporte_salud
                +"\n aporte pension: "+aporte_pension
                +"\n aporte ARL: "+ARL
                +"\n subsidio TTE: "+subsidio_tte
                +"\n NETO A PAGAR: "+neto_pagar;
    }

    
    public String mostrar() {
        return "Empleado" + 
                "id_empleado= " +id_empleado + 
                "\n nombre= " + nombre + 
                "\n genero= " + genero + 
                "\n salario_B= " + salario_B + 
                "\n estrato= " + estrato + 
                "\n horasExtra= " + horasExtra + 
                "\n fecha_vin= " + fecha_vin ;
    }
    
    
    
}
