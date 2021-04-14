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
public class Deportivo extends Vehiculo {

    private int cilindrada; // Atributo específico para Deportivo

    public Deportivo() {
        this.cilindrada = 19000;
    }

    

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "1:" + super.toString() + ":" + cilindrada;
    }
    
        

}
