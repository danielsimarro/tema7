/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4yEj7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();

        ArrayList<Turismo> listaTurismo = new ArrayList<>();
        ArrayList<Deportivo> listaDeportivo = new ArrayList<>();
        ArrayList<Furgoneta> listaFurgoneta = new ArrayList<>();

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

              
                    switch (Integer.parseInt(tokens[0])) {
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
                            listaTurismo.add(t1);
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
                            listaDeportivo.add(d1);
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
                            listaFurgoneta.add(f1);
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
        


        String depor = "Deportivos.csv";

        try ( BufferedWriter flujo1 = new BufferedWriter(new FileWriter(depor))) {

            for (int i = 0; i < listaDeportivo.size(); i++) {

                flujo1.write(listaDeportivo.get(i).getMatricula() + ",");
                flujo1.write(listaDeportivo.get(i).getMarca() + ",");
                flujo1.write(listaDeportivo.get(i).getModelo() + ",");
                flujo1.write(listaDeportivo.get(i).getColor() + ",");
                flujo1.write(listaDeportivo.get(i).getTarifa() + ",");
                flujo1.write(listaDeportivo.get(i).getBastidor() + ",");
                flujo1.write(listaDeportivo.get(i).isDisponible() + ",");
                flujo1.write(listaDeportivo.get(i).getCilindrada() + ",");
                //Este metodo salta a la siguiente linea
                flujo1.newLine();

            }

            // Metodo fluh() guarda cambios en disco 
            flujo1.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String furgo = "Furgoneta.csv";

        try ( BufferedWriter flujo2 = new BufferedWriter(new FileWriter(furgo))) {

            for (int i = 0; i < listaFurgoneta.size(); i++) {

                flujo2.write(listaFurgoneta.get(i).getMatricula() + ",");
                flujo2.write(listaFurgoneta.get(i).getMarca() + ",");
                flujo2.write(listaFurgoneta.get(i).getModelo() + ",");
                flujo2.write(listaFurgoneta.get(i).getColor() + ",");
                flujo2.write(listaFurgoneta.get(i).getTarifa() + ",");
                flujo2.write(listaFurgoneta.get(i).getBastidor() + ",");
                flujo2.write(listaFurgoneta.get(i).isDisponible() + ",");
                flujo2.write(listaFurgoneta.get(i).getCarga() + ",");
                flujo2.write(listaFurgoneta.get(i).getVolumen() + ",");
                //Este metodo salta a la siguiente linea
                flujo2.newLine();

            }

            // Metodo fluh() guarda cambios en disco 
            flujo2.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String turis = "Turismo.csv";

        try ( BufferedWriter flujo3 = new BufferedWriter(new FileWriter(turis))) {

            for (int i = 0; i < listaTurismo.size(); i++) {

                flujo3.write(listaTurismo.get(i).getMatricula() + ",");
                flujo3.write(listaTurismo.get(i).getMarca() + ",");
                flujo3.write(listaTurismo.get(i).getModelo() + ",");
                flujo3.write(listaTurismo.get(i).getColor() + ",");
                flujo3.write(listaTurismo.get(i).getTarifa() + ",");
                flujo3.write(listaTurismo.get(i).getBastidor() + ",");
                flujo3.write(listaTurismo.get(i).isDisponible() + ",");
                flujo3.write(listaTurismo.get(i).getPuertas() + ",");
                flujo3.write(listaTurismo.get(i).isMarchaAutomatica() + ",");
                //Este metodo salta a la siguiente linea
                flujo3.newLine();

            }

            // Metodo fluh() guarda cambios en disco 
            flujo3.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
