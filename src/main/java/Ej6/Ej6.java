/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NitroPc
 */
public class Ej6 {

    public static void main(String[] args) {

        // Fichero a leer
        String idFichero = "letras.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        //Array para almacenar las posicione donde se encuentra la secuencia de caracteres
        ArrayList<Coordenada> posicion = new ArrayList<Coordenada>();
        int contadorFila = -1;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            while (datosFichero.hasNextLine()) {
                contadorFila++;
                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(",");

                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].equalsIgnoreCase("j")) {
                        if (i + 1 == tokens.length) {
                            break;
                        }
                        if (tokens[i + 1].equalsIgnoreCase("v")) {
                            posicion.add(new Coordenada(contadorFila, i));
                        }
                    }
                }

                for (String string : tokens) {
                    System.out.print(string + "\t");
                }

                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Las posiciones donde se encuentra j y v son:");
        for (int i = 0; i < posicion.size(); i++) {
            System.out.println("Fila: " + posicion.get(i).getFila() + " y Columna: " + posicion.get(i).getColumna());
        }

    }
}
