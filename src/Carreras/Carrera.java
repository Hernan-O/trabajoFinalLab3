package Carreras;

import Entes.Caballo;
import Entes.ListaGenerica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Carrera implements Serializable{

    private String nombre;

    //Constructor
    public Carrera(int opc) {
        Tipo[] opciones = Tipo.values();
        this.nombre = opciones[opc].toString();
    }
    
    private enum Tipo {
        CAMPO_TRAVIESA,
        LISA,
        OBSTACULOS;
    }
    
    //Cambia las probabilidades de victoria de cada caballo segun tipo de carrera
    public ListaGenerica cambiaProb(ListaGenerica<Caballo> dat) {
        switch (this.nombre) {
            case "CAMPO_TRAVIESA" -> {
                dat = recorreYCambia(dat, "AMERICANO", 10);
                dat = recorreYCambia(dat, "ARABE", 5);
                dat = modificaXPeso(dat, 5);
                dat = modificaXAltura(dat, -5);
            }
            case "LISA" -> {
                dat = recorreYCambia(dat, "ARABE", 10);
                dat = recorreYCambia(dat, "ANGLO", 5);
                dat = modificaXPeso(dat, -5);
                dat = modificaXAltura(dat, 5);
            }
            case "OBSTACULOS" -> {
                dat = recorreYCambia(dat, "ANGLO", 10);
                dat = recorreYCambia(dat, "AMERICANO", 5);
                dat = modificaXPeso(dat, -5);
                dat = modificaXAltura(dat, 5);
            }
        }
        return dat;
    }
    //Aplica cambios en la probabilidad de victoria de cada caballo segun cierta raza
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
    
    public ListaGenerica modificaXPeso(ListaGenerica<Caballo> dato, int buff)
    {
    	for (Caballo ca : dato) {
            if (ca.getPeso()>= 475&& (ca.getProbabilidad() + buff) <= 100) {
                ca.setProbabilidad(ca.getProbabilidad() + buff);
            } else if (ca.getPeso()>= 475 && (ca.getProbabilidad() + buff) >= 100) {
                ca.setProbabilidad(100);
            } else if (ca.getPeso()>= 475&& (ca.getProbabilidad() + buff) <= 0)
            	ca.setProbabilidad(1);	
    		}
        return dato;
    }
    
    public ListaGenerica modificaXAltura(ListaGenerica<Caballo> dato, int buff)
    {
    	for (Caballo ca : dato) {
            if (ca.getAltura()>= 167&& (ca.getProbabilidad() + buff) <= 100) {
                ca.setProbabilidad(ca.getProbabilidad() + buff);
            } else if (ca.getAltura()>= 167 && (ca.getProbabilidad() + buff) >= 100) {
                ca.setProbabilidad(100);
            } else if (ca.getAltura()>= 167&& (ca.getProbabilidad() + buff) <= 0)
            	ca.setProbabilidad(1);	
    		}       
    	return dato;
    }
    
}
