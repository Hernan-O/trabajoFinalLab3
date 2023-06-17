package carreras;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import entes.Caballo;
import menus.MenuCarreras;

public abstract class Carrera {
    private String nombreCarrera;
    private ArrayList<Caballo> listaCaballos;
    private String dificultad;
    

    public Carrera(){}
    public Carrera(String nombreCarrera , String dificultad) {
        this.nombreCarrera = nombreCarrera;
        this.listaCaballos = new ArrayList<>();;
        this.dificultad = dificultad;
        new MenuCarreras().menuCarrera();
        
    }
    
	public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public ArrayList<Caballo> getCaballoList() {
        return listaCaballos;
    }

    public void setCaballoList(ArrayList<Caballo> caballoList) {
        this.listaCaballos = caballoList;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
    
    void listarCaballos()
    {	
    	System.out.println("Lista de Caballos: ");
    	System.out.println("");
    	
    	 for (int i=0; i<listaCaballos.size(); i++)
    	 {
    		 System.out.println(i +". " +listaCaballos.get(i).getNombre());
    	 }
    }
    
    
    
    //Funcion para seleccionar un caballo especifico y mostrar todos sus detalles
    //Falta Implementar navegabilidad
    //Y definir si la cantidad de caballos por carrera es fija o dinamica
    
}
