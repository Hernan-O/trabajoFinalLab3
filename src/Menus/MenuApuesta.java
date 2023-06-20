package Menus;

import Apuestas.*;
import Carreras.Carrera;
import Excepciones.*;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuApuesta {

    private Carrera tipo;
    private Saldo cuentaUser;   //Arranca con 20k, la idea es que sea un archivito o algo que mantenga persistencia

    public MenuApuesta(Carrera dat,Saldo saldo) {
        this.tipo = dat;
        this.cuentaUser=saldo;
        desplegarMenu();
    }

    public Saldo getCuentaUser() {
        return cuentaUser;
    }

    public void desplegarMenu() {
        int continuar = 0;
        while (continuar == 0) {
            try {

                Scanner in = new Scanner(System.in);
                System.out.println("Ingrese opcion:");
                System.out.println("1: Exacta");
                System.out.println("2: Trifecta");
                System.out.println("3: Imperfecta");
                System.out.println("4: ATRAS");
                int op = in.nextInt();

                switch (op) {
                    case 1:
                        Exacta siguiente0 = new Exacta(tipo,getCuentaUser());
                        siguiente0.desplegarMenu();
                        break;
                    case 2:
                        Trifecta siguiente1 = new Trifecta(tipo,getCuentaUser());
                        siguiente1.desplegarMenu();
                        break;
                    case 3:
                        Imperfecta siguiente2 = new Imperfecta(tipo,getCuentaUser());
                        siguiente2.desplegarMenu();
                    case 4:

                        continuar =1;
                        break;

                    default:
                        System.out.println("Ingrese una opcion correcta.");
                        break;
                }

            } catch (InputMismatchException e) {
                //System.out.println(e.getMessage());
                //e.printStackTrace();
                System.out.println("Ingrese una opcion correcta");
            } catch (opcionInexistente e) {
                System.out.println("Opcio Inexistente");
            }
        }


    }


}
