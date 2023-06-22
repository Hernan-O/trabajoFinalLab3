package Menus;

import Apuestas.*;
import Carreras.Carrera;
import Entes.Caballo;
import Excepciones.*;
import genericos.ListaGenerica;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuApuesta {

    private Carrera tipo;
    private ListaGenerica<Caballo> lista;
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
        boolean continuar = true;
        while (continuar) {
            try {

                Scanner in = new Scanner(System.in);
                System.out.println("Ingrese opcion:");
                System.out.println("1: Exacta");
                System.out.println("2: Trifecta");
                System.out.println("3: Imperfecta");
                System.out.println("4: Mostrar estadisticas de Caballos");
                System.out.println("5: ATRAS");
                int op = in.nextInt();

                switch (op) {
                    case 1:
                        Exacta siguiente0 = new Exacta(tipo,getCuentaUser());
                        siguiente0.calcularPorcentajeMonto();
                        siguiente0.desplegarMenu();
                        break;
                    case 2:
                        Trifecta siguiente1 = new Trifecta(tipo,getCuentaUser());
                        siguiente1.calcularPorcentajeMonto();
                        siguiente1.desplegarMenu();
                        break;
                    case 3:
                        Imperfecta siguiente2 = new Imperfecta(tipo,getCuentaUser());
                        siguiente2.calcularPorcentajeMonto();
                        siguiente2.desplegarMenu();
                        break;
                    case 4:
                        imprimirLista();
                        System.out.println();
                        break;
                    case 5:

                        continuar = false;
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

    public void imprimirLista()
    {
        this.lista=Apuesta.archivoBuffer();
        int i=1;
        for(Caballo c: this.lista)
        {
            System.out.println("----------------------"+ i +"----------------------");
            System.out.println(c.toString());
            i++;
        }

    }


    }
