/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author NitroPc
 */
public class Ej2 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "teclado.txt";
        String texto = "";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            do {
                try {
                    System.out.println("Introduce texto: ");
                    texto = teclado.nextLine();
                    
                    if(texto.equalsIgnoreCase("EOF")){
                        break;
                    }
                    flujo.write(texto + "\n");

                } catch (InputMismatchException ime) {
                    System.out.println("Debes introducir una palabra: ");
                    teclado.nextLine(); // Limpia los posibles datos que hay en el buffer
                }
            } while (!texto.equalsIgnoreCase("EOF"));

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
