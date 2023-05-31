package Clases;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hipodromo {
    private String nombre;
    private Obstaculos tipoPista;
    private int distancia;
    private int lugares;
    private ArrayList<Carrera> carreras = new ArrayList<>();
    private LinkedList<Apuesta> apuestas = new LinkedList<>();
}
