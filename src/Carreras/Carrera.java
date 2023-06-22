package Carreras;

import Entes.Caballo;
import Entes.ListaGenerica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Carrera implements Serializable{

    private String nombre;

    private enum Tipo {
        CAMPO_TRAVIESA,
        LISA,
        OBSTACULOS;
    }

    public Carrera(int opc) {
        Tipo[] opciones = Tipo.values();
        this.nombre = opciones[opc].toString();
    }

    public ListaGenerica cambiaProb(ListaGenerica<Caballo> dat) {
        switch (this.nombre) {
            case "CAMPO_TRAVIESA" -> {
                dat = recorreYCambia(dat, "AMERICANO", 10);
                dat = recorreYCambia(dat, "ARABE", 5);
            }
            case "LISA" -> {
                dat = recorreYCambia(dat, "ARABE", 10);
                dat = recorreYCambia(dat, "ANGLO", 5);
            }
            case "OBSTACULOS" -> {
                dat = recorreYCambia(dat, "ANGLO", 10);
                dat = recorreYCambia(dat, "AMERICANO", 5);
            }
        }
        return dat;
    }

    public ListaGenerica recorreYCambia(ListaGenerica<Caballo> dat, String raza, int buff) {
        for (Caballo ca : dat) {
            if (ca.getnRaza().equalsIgnoreCase(raza) && (ca.getProbabilidad() + buff) <= 100) {
                ca.setProbabilidad(ca.getProbabilidad() + buff);
            } else if (ca.getnRaza().equalsIgnoreCase(raza) && (ca.getProbabilidad() + buff) <= 100) {
                ca.setProbabilidad(100);
            }
        }
        return dat;
    }
}
