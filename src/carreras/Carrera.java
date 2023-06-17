package carreras;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import entes.Caballo;
import menus.MenuCarreras;

public abstract class Carrera {
    private String nombreCarrera;
    private ArrayList<Caballo> listaCaballos;
    private MenuCarreras menu;
    
    public Carrera() {
        this.listaCaballos = new ArrayList<>();;
        
    }
    
    public void menuCarreras() {
    	this.menu = new MenuCarreras();
    	menu.menuCarrera();
    }
    
    public ArrayList<Caballo> getCaballoList() {
        return listaCaballos;
    }

    public void setCaballoList(ArrayList<Caballo> caballoList) {
        this.listaCaballos = caballoList;
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
