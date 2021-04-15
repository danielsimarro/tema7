/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4yEj7;

import Ej6.Coordenada;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author NitroPc
 */
public class LeerVehiculos {

    public static void main(String[] args) {

        // Fichero a leer
        String idFichero = "vehiculos.csv";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        //Array para almacenar las posicione donde se encuentra la secuencia de caracteres
        ArrayList<Vehiculo> listaVehiculo = new ArrayList<Vehiculo>();

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero))) {

            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(":");


                    switch (Integer.parseInt(tokens[0])) { //el swicht se permite string
                        case 0:
                            Turismo t1 = new Turismo();
                            t1.setMatricula(tokens[1]);
                            t1.setMarca(tokens[2]);
                            t1.setModelo(tokens[3]);
                            t1.setColor(tokens[4]);
                            t1.setTarifa(Double.parseDouble(tokens[5]));
                            t1.setBastidor(Long.parseLong(tokens[6]));
                            t1.setDisponible(Boolean.parseBoolean(tokens[7]));
                            t1.setPuertas(Integer.parseInt(tokens[8]));
                            t1.setMarchaAutomatica(Boolean.parseBoolean(tokens[9]));
                            listaVehiculo.add(t1);
                            break;
                        case 1:
                            Deportivo d1 = new Deportivo();
                            d1.setMatricula(tokens[1]);
                            d1.setMarca(tokens[2]);
                            d1.setModelo(tokens[3]);
                            d1.setColor(tokens[4]);
                            d1.setTarifa(Double.parseDouble(tokens[5]));
                            d1.setBastidor(Long.parseLong(tokens[6]));
                            d1.setDisponible(Boolean.parseBoolean(tokens[7]));
                            d1.setCilindrada(Integer.parseInt(tokens[8]));
                            listaVehiculo.add(d1);
                            break;
                        case 2:
                            Furgoneta f1 = new Furgoneta();
                            f1.setMatricula(tokens[1]);
                            f1.setMarca(tokens[2]);
                            f1.setModelo(tokens[3]);
                            f1.setColor(tokens[4]);
                            f1.setTarifa(Double.parseDouble(tokens[5]));
                            f1.setBastidor(Long.parseLong(tokens[6]));
                            f1.setDisponible(Boolean.parseBoolean(tokens[7]));
                            f1.setCarga(Integer.parseInt(tokens[8]));
                            f1.setVolumen(Integer.parseInt(tokens[9]));
                            listaVehiculo.add(f1);
                            break;
                    
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Collections.sort(listaVehiculo);

        for (Vehiculo lista : listaVehiculo) {
            System.out.println(lista);
        }

    }

}
