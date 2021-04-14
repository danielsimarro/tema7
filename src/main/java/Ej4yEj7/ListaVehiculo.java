/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4yEj7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author NitroPc
 */
public class ListaVehiculo {

    public static void main(String[] args) {
        ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();

        for (int i = 0; i < 30; i++) {
            lista.add(new Turismo());
            lista.add(new Deportivo());
            lista.add(new Furgoneta());
        }

        String idFichero = "vehiculos.csv";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            
            flujo.write("TipoVehiculo:Matricula:Marca:Modelo:Color:Precio:Bastidor:Disponible");
            flujo.newLine();

            for (Vehiculo lib : lista) {

                //En estos dos if dentro se realiza conversion explicita
                if (lib instanceof Turismo) {

                    flujo.write(((Turismo) lib).toString());

                }

                if (lib instanceof Deportivo) {

                    flujo.write(((Deportivo) lib).toString());
                }

                if (lib instanceof Furgoneta) {

                    flujo.write(((Furgoneta) lib).toString());
                }
                
                flujo.newLine();
            }

            // Metodo newLine() añade salto de línea después de cada fila
            

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
