package Menus;
import Archivos.Escribir;
import Entes.*;
import Apuestas.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashSet;

public class Jugar {

    public Jugar(){

        menuJugar();
    }
    public void menuJugar() throws InputMismatchException
    {
        boolean continuar = true;
        while (continuar) {
            try {

                Scanner in = new Scanner(System.in);
                System.out.println("Ingrese opcion:");
                System.out.println("1: JUGAR");
                System.out.println("2: CARGAR SALDO");
                System.out.println("3: SALIR");

                int op = in.nextInt();
                in.nextLine();
                switch (op) {
                    case 1:
                        MenuCarrera siguiente = new MenuCarrera();
                        break;
                    case 2:
                        cargarSaldo();
                        break;
                    case 3:
                        System.out.println("Fin juego");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Ingrese una opcion correcta.");
                        break;
                }

            } catch (InputMismatchException e) {
                //System.out.println(e.getMessage());
                //e.printStackTrace();
                System.out.println("Ingrese una opcion correcta");
            }
        }
    }
    public void cargarSaldo(){
        Scanner in = new Scanner(System.in);
        Escribir escribir = new Escribir();
        System.out.println("Ingrese el monto");
        Saldo saldito = new Saldo(in.nextInt());
        try {
            escribir.abrir("saldo");
            escribir.escribir(saldito);
            escribir.cerrar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
