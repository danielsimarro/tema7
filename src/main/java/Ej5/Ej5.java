/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Ej5 {

    public static void main(String[] args) {

        // Fichero a leer
        String idFichero = "matriz.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens ;
        int valor = 0;
        int total = 0;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            System.out.println("Separando cada elemento del fichero: ");

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split("\t");
                for(int i=0;i<tokens.length;i++){
                    valor = Integer.parseInt(tokens[i]);
                    total += valor;
                }
                

                for (String string : tokens) {
                    System.out.print(string + "\t");
                }

                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("La suma de todos los numeros es de: " + total);

    }


}
