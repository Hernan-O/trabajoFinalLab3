package main;

import Apuestas.Saldo;
import Archivos.Escribir;
import Menus.Jugar;
import genericos.ListaGenerica;
import Entes.*;

import java.io.*;


public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        Jugar juego = new Jugar();

        // INSTANCIAS Y CREACION DEL ARCHIVO.
/*
        ListaGenerica<Jockey> listaJ = new ListaGenerica<Jockey>();
        listaJ.agregar(new Jockey("Guillermo Gimenez", 78));
        listaJ.agregar(new Jockey("Leo Messirve", 80));
        listaJ.agregar(new Jockey("Sergio Busquets", 90));
        listaJ.agregar(new Jockey("Juan Manuel Belgrano", 75));
        listaJ.agregar(new Jockey("San Martin", 83));
        listaJ.agregar(new Jockey("El maestro Yoda", 25.2F));
        listaJ.agregar(new Jockey("Senador Palpatin(Con poder ilimitado)", 78.6F));
        listaJ.agregar(new Jockey("Mario Santos", 92.4F));
        listaJ.agregar(new Jockey("Luigi", 91.8F));
        listaJ.agregar(new Jockey("Emilio Ravenna", 85.1F));
        Escribir escribir = new Escribir();
        try {
            escribir.abrir("jockey");
            escribir.escribir(listaJ);
            escribir.cerrar();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] nombres = {"Trotrón", "Relámpago", "Viento Veloz", "Galope Brillante", "Centella", "Rayo Dorado", "Fuego Salvaje", "Mariposa Veloz", "Estrella Fulgurante", "Tormenta Cautivadora"};

        Caballo caballo1 = new Caballo(nombres[0], 3, 0,listaJ.get(0));
        Caballo caballo2 = new Caballo(nombres[1], 4, 1,listaJ.get(1));
        Caballo caballo3 = new Caballo(nombres[2], 5, 2,listaJ.get(2));
        Caballo caballo4 = new Caballo(nombres[3], 3, 0,listaJ.get(3));
        Caballo caballo5 = new Caballo(nombres[4], 4, 1,listaJ.get(4));
        Caballo caballo6 = new Caballo(nombres[5], 5, 2,listaJ.get(5));
        Caballo caballo7 = new Caballo(nombres[6], 3, 0,listaJ.get(6));
        Caballo caballo8 = new Caballo(nombres[7], 4, 1,listaJ.get(7));
        Caballo caballo9 = new Caballo(nombres[8], 5, 2,listaJ.get(8));
        Caballo caballo10 = new Caballo(nombres[9], 3, 0,listaJ.get(9));


        ListaGenerica<Caballo> lista = new ListaGenerica<Caballo>();
        lista.agregar(caballo1);
        lista.agregar(caballo2);
        lista.agregar(caballo3);
        lista.agregar(caballo4);
        lista.agregar(caballo5);
        lista.agregar(caballo6);
        lista.agregar(caballo7);
        lista.agregar(caballo8);
        lista.agregar(caballo9);
        lista.agregar(caballo10);
        
        try {
			escribir.abrir("caballos");
			escribir.escribir(lista);
	        escribir.cerrar();
		} catch (IOException e1) {
			e1.printStackTrace();
		}            

        Saldo saldito = new Saldo();

        try {
			escribir.abrir("saldo");
			escribir.escribir(saldito);
	        escribir.cerrar();
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
    }
}
