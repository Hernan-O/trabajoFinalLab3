package main;

import java.util.HashSet;

import entes.Caballo;
import hipodromo.Hipodromo;

public class Main {
    public static void main(String[] args) {
    	HashSet<Caballo> archivoCaballos = new HashSet<>();
    	
    	archivoCaballos.add(new Caballo(5, "Caballo1", null, "Raza1"));
    	archivoCaballos.add(new Caballo(6, "Caballo2", null, "Raza2"));
    	archivoCaballos.add(new Caballo(4, "Caballo3", null, "Raza3"));
    	archivoCaballos.add(new Caballo(7, "Caballo4", null, "Raza4"));
    	archivoCaballos.add(new Caballo(6, "Caballo5", null, "Raza5"));
    	archivoCaballos.add(new Caballo(8, "Caballo6", null, "Raza6"));
    	archivoCaballos.add(new Caballo(5, "Caballo7", null, "Raza7"));
    	archivoCaballos.add(new Caballo(6, "Caballo8", null, "Raza8"));
    	archivoCaballos.add(new Caballo(4, "Caballo9", null, "Raza9"));
    	archivoCaballos.add(new Caballo(7, "Caballo10", null, "Raza10"));
    	archivoCaballos.add(new Caballo(6, "Caballo11", null, "Raza11"));
    	archivoCaballos.add(new Caballo(8, "Caballo12", null, "Raza12"));
    	archivoCaballos.add(new Caballo(5, "Caballo13", null, "Raza13"));
    	archivoCaballos.add(new Caballo(6, "Caballo14", null, "Raza14"));
    	archivoCaballos.add(new Caballo(4, "Caballo15", null, "Raza15"));
    	archivoCaballos.add(new Caballo(7, "Caballo16", null, "Raza16"));
    	new Hipodromo(archivoCaballos).menu();
    	
    }
}
