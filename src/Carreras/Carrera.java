package Carreras;

import Entes.Caballo;
import genericos.ListaGenerica;


public class Carrera {

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

    public ListaGenerica<Caballo> cambiaProb(ListaGenerica<Caballo> aux) {
        switch (this.nombre) {
            case "CAMPO_TRAVIESA" -> {
                aux = recorreYCambia(aux, "AMERICANO", 10);
                aux = recorreYCambia(aux, "ARABE", 5);
            }
            case "LISA" -> {
                aux = recorreYCambia(aux, "ARABE", 10);
                aux = recorreYCambia(aux, "ANGLO", 5);
            }
            case "OBSTACULOS" -> {
                aux = recorreYCambia(aux, "ANGLO", 10);
                aux = recorreYCambia(aux, "AMERICANO", 5);
            }
        }
        return aux;
    }

    public ListaGenerica<Caballo> recorreYCambia(ListaGenerica<Caballo> aux, String raza, int buff) {
        for (Caballo ca : aux) {
            if (ca.getnRaza().equalsIgnoreCase(raza) && (ca.getProbabilidad() + buff) <= 100) {
                ca.setProbabilidad(ca.getProbabilidad() + buff);
            } else if (ca.getnRaza().equalsIgnoreCase(raza) && (ca.getProbabilidad() + buff) <= 100) {
                ca.setProbabilidad(100);
            }
        }
        return aux;
    }
}
