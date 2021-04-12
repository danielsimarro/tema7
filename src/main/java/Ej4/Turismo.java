/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4;

import java.util.Random;

/**
 *
 * @author NitroPc
 */
public class Turismo extends Vehiculo {

    // Además de los atributos de Vehiculo, esta clase tiene los siguientes
    private int puertas;
    private boolean marchaAutomatica;
    
    private static Random aleatorio = new Random();

    public Turismo() {
        this.puertas = 5;
        this.marchaAutomatica = aleatorio.nextBoolean();
    }

   

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public boolean isMarchaAutomatica() {
        return marchaAutomatica;
    }

    public void setMarchaAutomatica(boolean marchaAutomatica) {
        this.marchaAutomatica = marchaAutomatica;
    }

    @Override
    public String toString() {
        return "0:" + super.toString() + ":" + puertas + ":" + marchaAutomatica;
    }
    
    

}
