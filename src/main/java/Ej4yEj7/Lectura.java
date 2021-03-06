/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4yEj7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author daniel
 */
public class Lectura {

    public static void main(String[] args) {

        //Creacion del fichero copias
        Path directory = Paths.get("./copias");
        try {
            Files.createDirectory(directory);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio.");
            System.out.println(e.toString());
        }
        //Copiar los ficheros de copia en la carpeta copias
        Path origenDe = Paths.get("./Deportivos.csv");
        Path origenFu = Paths.get("./Furgoneta.csv");
        Path origenTu = Paths.get("./Turismo.csv");
        Path destinoDe = Paths.get("./copias/Deportivos.csv");
        Path destinoTu = Paths.get("./copias/Turismo.csv");
        Path destinoFu = Paths.get("./copias/Furgoneta.csv");
        try {
            Files.copy(origenDe, destinoDe);
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");

        }

        try {
            Files.copy(origenFu, destinoFu);
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");

        }

        try {
            Files.copy(origenTu, destinoTu);
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");

        }

        System.out.println("\nEl fichero contiene:");

        File f = new File("./copias");
        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        String depor = "./copias/Deportivos.csv";

        //Lectura del fichero deportivo.csv
        try ( Scanner datosFichero = new Scanner(new File(depor))) {

            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // l??nea en funci??n del car??cter separador coma
                tokens = linea.split(",");

                Deportivo d1 = new Deportivo();
                d1.setMatricula(tokens[0]);
                d1.setMarca(tokens[1]);
                d1.setModelo(tokens[2]);
                d1.setColor(tokens[3]);
                d1.setTarifa(Double.parseDouble(tokens[4]));
                d1.setBastidor(Long.parseLong(tokens[5]));
                d1.setDisponible(Boolean.parseBoolean(tokens[6]));
                d1.setCilindrada(Integer.parseInt(tokens[7]));
                listaVehiculos.add(d1);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String turis = "./copias/Turismo.csv";

        //Lectura del fichero deportivo.csv
        try ( Scanner datosFichero = new Scanner(new File(turis))) {

            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // l??nea en funci??n del car??cter separador coma
                tokens = linea.split(",");

                Turismo t1 = new Turismo();
                t1.setMatricula(tokens[0]);
                t1.setMarca(tokens[1]);
                t1.setModelo(tokens[2]);
                t1.setColor(tokens[3]);
                t1.setTarifa(Double.parseDouble(tokens[4]));
                t1.setBastidor(Long.parseLong(tokens[5]));
                t1.setDisponible(Boolean.parseBoolean(tokens[6]));
                t1.setPuertas(Integer.parseInt(tokens[7]));
                t1.setMarchaAutomatica(Boolean.parseBoolean(tokens[8]));
                listaVehiculos.add(t1);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String furgo = "./copias/Furgoneta.csv";

        //Lectura del fichero deportivo.csv
        try ( Scanner datosFichero = new Scanner(new File(furgo))) {

            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // l??nea en funci??n del car??cter separador coma
                tokens = linea.split(",");

                Furgoneta f1 = new Furgoneta();
                f1.setMatricula(tokens[0]);
                f1.setMarca(tokens[1]);
                f1.setModelo(tokens[2]);
                f1.setColor(tokens[3]);
                f1.setTarifa(Double.parseDouble(tokens[4]));
                f1.setBastidor(Long.parseLong(tokens[5]));
                f1.setDisponible(Boolean.parseBoolean(tokens[6]));
                f1.setCarga(Integer.parseInt(tokens[7]));
                f1.setVolumen(Integer.parseInt(tokens[8]));
                listaVehiculos.add(f1);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (Vehiculo l : listaVehiculos) {
            System.out.println(l);
        }

        ArrayList<String> listaRaiz = new ArrayList<>();

        File raiz = new File("./");
        if (f.exists()) {
            File[] ficheros = raiz.listFiles();
            for (File file2 : ficheros) {
                if (file2.getName().contains("csv")) {
                    listaRaiz.add(file2.getName());
                }

            }
        } else {
            System.out.println("El directorio a listar no existe");
        }

        for (String l : listaRaiz) {
            System.out.println(l);
        }

        for (int i = 0; i < listaRaiz.size(); i++) {

            Path element = Paths.get(listaRaiz.get(i));
            try {
                Files.delete(element);
            } catch (IOException e) {
                System.out.println("Problema borrando el archivo.");
                System.out.println(e.toString());
            }

        }
        System.out.println("\nEl fichero raiz contiene:");

        if (f.exists()) {
            File[] ficheros = raiz.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
        
        
        List<Vehiculo> blanco = listaVehiculos.stream()
                .filter(v -> v.getColor().equalsIgnoreCase("negro"))
                .sorted((v1,v2)->v1.getMatricula().compareTo(v2.getMatricula()))
                .collect(Collectors.toList());
        
        System.out.println("\nLos vehiculos negros son:");
        for(Vehiculo v: blanco){
            System.out.println(v);
        }
        
        System.out.println("\nLos vehiculos no disponibles son:");
        List<String> disponible = listaVehiculos.stream()
                .filter(v -> v.isDisponible() != true)
                .map(d -> d.getMarca())
                .collect(Collectors.toList());
        disponible.forEach(System.out::println);
        
        long cantidadMarca = listaVehiculos.stream()
                .filter(p -> p.getMarca().equalsIgnoreCase("Renault"))
                .count();
        System.out.println("\nEl n??mero de coches Renault son: " + cantidadMarca);
        
        boolean seat = listaVehiculos.stream().anyMatch((p) -> p.getMarca().equalsIgnoreCase("Seat") && p.getColor().equalsIgnoreCase("dorado"));
        
        System.out.println("Hay algun seat dorado :" + seat);
        
                
    }
    
}
