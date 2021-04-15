/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4yEj7;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author NitroPc
 */
public class Vehiculo implements Comparable<Vehiculo> {

    private Long bastidor;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    //Atributos para controlar la clase
    private static ArrayList<String> listaSerie = new ArrayList<>();
    private static ArrayList<String> listaSerieBastidor = new ArrayList<>();

    public Vehiculo() {
        
        Random aleatorio = new Random();
        
        int numero = aleatorio.nextInt(4 - 0 + 1) + 0;
        
        this.bastidor = crearBastidor();
        this.matricula = crearMatricula();
        this.marca = marca(numero);
        this.modelo = modelo(numero);
        this.color = color();
        this.tarifa = tarifa(numero);
        this.disponible = false;
    }

    public Long getBastidor() {
        return bastidor;
    }

    public void setBastidor(Long bastidor) {
        this.bastidor = bastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return matricula + ":" + marca + ":" + modelo + ":" + color + ":" + tarifa + ':' + bastidor + ":" + disponible;
    }

    private static String crearMatricula() {
        Random aleatorio = new Random();
        String cadena = "";

        do {
            for (int i = 0; i < 7; i++) {

                if (i > 3) {
                    String letras = "abcdefghijklmnñopqrstuvwxyz";
                    String toUpperCase = letras.toUpperCase();
                    int posicion = aleatorio.nextInt(toUpperCase.length());
                    char letra = toUpperCase.charAt(posicion);
                    cadena += Character.toString(letra);
                } else {
                    int enteroAleatorio = aleatorio.nextInt(9 - 0 + 1) + 0;
                    cadena += Integer.toString(enteroAleatorio);
                }

            }
        } while (comprobarDubplicado(cadena));
        
        listaSerie.add(cadena);

        return cadena;

    }

    //Metodo que comprueba que el valor no este repetido
    private static boolean comprobarDubplicado(String cadena) {

        boolean valor = false;

        if (!listaSerie.isEmpty()) {

            for (int i = 0; i < listaSerie.size(); i++) {
                if (cadena == listaSerie.get(i)) {
                    valor = true;

                }
            }

        }

        return valor;
    }
    
    private static Long crearBastidor() {
        Random aleatorio = new Random();
        String cadena = "";

        do {
            for (int i = 0; i < 7; i++) {

                    int enteroAleatorio = aleatorio.nextInt(9 - 0 + 1) + 0;
                    cadena += Integer.toString(enteroAleatorio);
                }    
            
        } while (comprobarDubplicadoBastidor(cadena));
        
        listaSerieBastidor.add(cadena);
        
        return Long.parseLong(cadena);

    }
    
    private static boolean comprobarDubplicadoBastidor(String cadena) {

        boolean valor = false;

        if (!listaSerieBastidor.isEmpty()) {

            for (int i = 0; i < listaSerieBastidor.size(); i++) {
                if (cadena == listaSerieBastidor.get(i)) {
                    valor = true;

                }
            }

        }

        return valor;
    }
    
    private static String color(){
        String cadena = "rojo,azul,amarillo,negro,dorado";
        String [] array = cadena.split(",");
        
        Random aleatorio = new Random();
        
        int numero = aleatorio.nextInt(4 - 0 + 1) + 0;
        
        String color = array[numero];
        
        return color;
    }
    
    private static String marca(int posicion){
        String cadena = "Alfa Romeo,Citroen,Renault,Seat,Opel";
        String [] lista = cadena.split(",");
        
        return lista [posicion];
    }
    
    private static String modelo(int posicion){
        String cadena = "Guiullia,C4,Megane,Ibiza,Astra";
        String [] lista = cadena.split(",");
        
        return lista [posicion];
    }
    
    private static double tarifa(int posicion){
        String cadena = "23500,19300,21320,18569,23658";
        String [] lista = cadena.split(",");
        
        return Double.parseDouble(lista[posicion]);
    }

    @Override
    public int compareTo(Vehiculo uno) {
        return this.getMarca().compareTo(uno.getMarca());
    }


}
