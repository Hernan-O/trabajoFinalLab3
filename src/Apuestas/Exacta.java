package Apuestas;

import Carreras.Carrera;
import Entes.Caballo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import Excepciones.*;
import Menus.Estetica;
import genericos.ListaGenerica;

public class Exacta extends Apuesta {
    private Caballo ganador;

    public Exacta(Carrera dat, Saldo saldo) {
        super(dat, saldo);
        this.ganador = ordenar().get(0);
    }

    @Override
    public ListaGenerica<Caballo> ordenar() {
        ListaGenerica<Caballo> resultado = new ListaGenerica<Caballo>();
        ListaGenerica<Caballo> aux = new ListaGenerica<Caballo>();
        aux = super.getListaOrden();
        aux = this.getTipo().cambiaProb(aux);
        resultado.agregar(aux.get(0));

        for (int i = 1; i < aux.size(); i++) {

            if (resultado.get(0).getProbabilidad() < aux.get(i).getProbabilidad()) {
                resultado.agregar(0, aux.get(i));
            }
        }
        return resultado;
    }

    public Saldo devolverTotal() {
        return this.getCuentaUser();
    }

    public void desplegarMenu() throws opcionInexistente {
        Estetica screenCleaner = new Estetica();
        boolean continuar = true;
        while (continuar) {
            Scanner in = new Scanner(System.in);
            super.imprimirListaApuesta();
            Saldo cuentaAux = this.getCuentaUser();
            try {
                System.out.println("Ingrese el caballo ganador");
                int op = in.nextInt();
                System.out.println("Cuenta actual:" + cuentaAux.getSaldo() + "\nIngrese el monto que quiere apostar:");
                float apuesta = in.nextFloat();

                if (apuesta > cuentaAux.getSaldo() || apuesta <= 0) {
                    System.out.println("Ingrese minimo 0 y maximo " + cuentaAux.getSaldo());
                    apuesta = 0;
                    throw new SaldoInsuficiente();
                }
                if (op > 10 || op <= 0) {
                    throw new opcionInexistente();
                }
                op--;
                screenCleaner.limpiaPantalla();
                System.out.println("El caballo ganador fue:" + ganador.getNombre());
                if (super.getListaOrden().get(op).equals(ganador)) {
                    System.out.println("GANASTE");
                    cuentaAux.apuestaGanada(apuesta, super.getListaOrden().get(op).getPorcentajeGanancia());
                } else {
                    System.out.println("Perdiste");
                    cuentaAux.apuestaPerdida(apuesta);
                }
                System.out.println("Monto luego de las apuestas:" + cuentaAux.getSaldo());
                super.setCuentaUser(cuentaAux);
                continuar = false;

            } catch (InputMismatchException e) {
                System.out.println("Solo numeros");
            } catch (opcionInexistente e) {
                System.out.println("Entre 1 y 10");
            } catch (SaldoInsuficiente e) {
                e.printStackTrace();
            }
        }
        // super.setCuentaUser(cuentaAux);
    }


}
