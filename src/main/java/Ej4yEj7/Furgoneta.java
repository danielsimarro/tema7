/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4yEj7;

/**
 *
 * @author NitroPc
 */
public class Furgoneta extends Vehiculo {

    // Atributos específicos
    private int carga;
    private int volumen;

    public Furgoneta() {
        this.carga = 3000;
        this.volumen = 1500;
    }

    

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return "2:" + super.toString() + ":" + carga + ":" + volumen;
    }
    
    

}
