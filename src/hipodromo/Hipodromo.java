package hipodromo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import apuestas.Apuesta;
import carreras.Carrera;
import carreras.Obstaculos;
import entes.Caballo;
import menus.Jugar;

public class Hipodromo {
    private String nombre;
    private Obstaculos tipoPista;
    private int distancia;
    private int lugares;
    private ArrayList<Carrera> carreras = new ArrayList<>();
    private LinkedList<Apuesta> apuestas = new LinkedList<>();
    private static final Scanner in = new Scanner(System.in);
    
    public void menu() {
        int continuar = 0;
        while (continuar == 0) {
            try {

                System.out.println("Ingrese opcion:");
                System.out.println("1: JUGAR");
                System.out.println("2: SALIR");

                int op = in.nextInt();
                in.nextLine();
                switch (op) {
                    case 1:
                        new Jugar().elegirCarrera();
                        break;

                    case 2:
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
    
}
