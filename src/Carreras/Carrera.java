package Carreras;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Carrera {

    private String nombre;
    private enum Tipo
    {
        CAMPO_TRAVIESA,
        LISA,
        OBSTACULOS;
    }
    public Carrera(int opc) {
        Tipo [] opciones = Tipo.values();
        this.nombre= opciones[opc].toString();
    }





}
