package main;

import Apuestas.Saldo;
import Menus.Jugar;
import Entes.*;

import java.io.*;
import java.util.ArrayList;

public class Main implements Serializable{
    public static void main(String[] args) {

    	Jugar juego = new Jugar();

        // INSTANCIAS Y CREACION DEL ARCHIVO.
    	/*
        String[] nombres = {"Trotrón", "Relámpago", "Viento Veloz", "Galope Brillante", "Centella", "Rayo Dorado", "Fuego Salvaje", "Mariposa Veloz", "Estrella Fulgurante", "Tormenta Cautivadora"};

        Caballo caballo1 = new Caballo(nombres[0], 3, 0);
        Caballo caballo2 = new Caballo(nombres[1], 4, 1);
        Caballo caballo3 = new Caballo(nombres[2], 5, 2);
        Caballo caballo4 = new Caballo(nombres[3], 3, 0);
        Caballo caballo5 = new Caballo(nombres[4], 4, 1);
        Caballo caballo6 = new Caballo(nombres[5], 5, 2);
        Caballo caballo7 = new Caballo(nombres[6], 3, 0);
        Caballo caballo8 = new Caballo(nombres[7], 4, 1);
        Caballo caballo9 = new Caballo(nombres[8], 5, 2);
        Caballo caballo10 = new Caballo(nombres[9], 3, 0);


        ListaGenerica<Caballo> lista = new ListaGenerica<>();
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
            File archivo = new File("caballos.txt");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo));

            out.writeObject(lista);

            out.close();
            System.out.println("Lista de caballos serializada correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Saldo saldito = new Saldo();

        try{
            File archivo = new File("saldo.txt");
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(archivo));

            obj.writeObject(saldito);

            obj.close();

        }catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }catch (IOException e){

            System.out.println(e.getMessage());
        }
		*/

    }
}
