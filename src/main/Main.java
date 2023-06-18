package main;

import java.util.HashSet;

import entes.Caballo;
import hipodromo.Hipodromo;

public class Main {
    public static void main(String[] args) {
    	HashSet<Caballo> archivoCaballos = new HashSet<>();
    	
    	archivoCaballos.add(new Caballo(5, "Caballo1", null, Raza.AMERICANO));
    	archivoCaballos.add(new Caballo(6, "Caballo2", null, Raza.AMERICANO));
    	archivoCaballos.add(new Caballo(4, "Caballo3", null, Raza.ARABE));
    	archivoCaballos.add(new Caballo(7, "Caballo4", null, Raza.ARABE));
    	archivoCaballos.add(new Caballo(6, "Caballo5", null, Raza.ARABE));
    	archivoCaballos.add(new Caballo(8, "Caballo6", null, Raza.ARABE));
    	archivoCaballos.add(new Caballo(5, "Caballo7", null, Raza.ARABE));
    	archivoCaballos.add(new Caballo(6, "Caballo8", null, Raza.AMERICANO));
    	archivoCaballos.add(new Caballo(4, "Caballo9", null, Raza.AMERICANO));
    	archivoCaballos.add(new Caballo(7, "Caballo10", null, Raza.ANGLO));
    	archivoCaballos.add(new Caballo(6, "Caballo11", null, Raza.ANGLO));
    	archivoCaballos.add(new Caballo(8, "Caballo12", null, Raza.ANGLO));
    	archivoCaballos.add(new Caballo(5, "Caballo13", null, Raza.ANGLO));
    	archivoCaballos.add(new Caballo(6, "Caballo14", null, Raza.ANGLO));
    	archivoCaballos.add(new Caballo(4, "Caballo15", null, Raza.ARABE));
    	archivoCaballos.add(new Caballo(7, "Caballo16", null, Raza.ARABE));
    	new Hipodromo(archivoCaballos).menu();
    	
    }
}
