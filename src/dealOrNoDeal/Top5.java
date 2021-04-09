/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealOrNoDeal;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Top5 implements Serializable{
    private String nombre;
    private double dinero;
    private String dineroRedondeado;

    public Top5(String nombre, double dinero, String dineroRedondeado) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.dineroRedondeado = dineroRedondeado;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getDineroRedondeado() {
        dineroRedondeado = String.format("$ %.0f", dinero);
        return dineroRedondeado;
    }   
}
