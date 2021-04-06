/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author NitroPc
 */
public class Ej1 {

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "matriz.txt";
        String tmp;
        // Array a escribir
        int matrizNumeros[][] = new int[5][8];

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        int inicial = 100;
        String primerValor = "";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < matrizNumeros.length; i++) {
                inicial = 100*(i+1);
                matrizNumeros[i][0] = inicial;
                for (int j = 0; j < matrizNumeros[i].length; j++) {
                    matrizNumeros[i][j] = inicial + j;
                    // Obtengo en un String el elemento int de la matriz
                    tmp = String.valueOf(matrizNumeros[i][j]);

                    flujo.write(tmp + "\t");

                }

                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
