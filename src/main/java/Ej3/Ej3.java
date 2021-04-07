/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author NitroPc
 */
public class Ej3 {

    private static Random aleatorio = new Random();

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "letras.txt";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (int i = 0; i < 50; i++) {

                String letraFinal;
                do {
                    String letras = "abcdefghijklmnñopqrstuvwxyz";
                    String mayusculas= letras.toUpperCase();
                    letras+=mayusculas;
                    int indiceLetraSacar = aleatorio.nextInt(letras.length());
                    
                    char letra = letras.charAt(indiceLetraSacar);
                    letraFinal= Character.toString(letra);
                    
                    i++;

                    if(letraFinal.equalsIgnoreCase("x")){
                        flujo.write(letraFinal);
                        break;
                    }
                    
                    flujo.write(letraFinal+",");
                    
                } while (!letraFinal.equalsIgnoreCase("x"));

                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
                i-=1;
            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
