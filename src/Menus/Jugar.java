package Menus;
import Entes.*;
import Apuestas.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Jugar implements Serializable{

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
                System.out.println("2: SALIR");

                int op = in.nextInt();
                in.nextLine();
                switch (op) {
                    case 1:
                        MenuCarrera siguiente = new MenuCarrera();
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
