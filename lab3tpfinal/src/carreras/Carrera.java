package carreras;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import entes.Caballo;

public abstract class Carrera {
    private String nombreCarrera;
    private ArrayList<Caballo> listaCaballos;
    private String dificultad;

    public Carrera(){}
    public Carrera(String nombreCarrera , String dificultad) {
        this.nombreCarrera = nombreCarrera;
        this.listaCaballos = new ArrayList<>();;
        this.dificultad = dificultad;
        
        menuCarrera();
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
    
    void menuCarrera()
    {
    	int continuar = 0;
        while (continuar == 0) {
            try {
                Scanner teclado = new Scanner(System.in);
                
                listarCaballos();
                
                System.out.println("");
                System.out.println("Ingrese opcion:");
                System.out.println("1: APOSTAR");
                System.out.println("2: INFORMACION DE LOS CABALLOS");
                System.out.println("3: ESTADO APUESTAS");
                System.out.println("4: ATRAS");
                System.out.println("");
                
                int op = teclado.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Opcion 1");
                        break;

                    case 2:
                        System.out.println("Opcion 2");
                        break;
                       
                    case 3:
                        System.out.println("Opcion 3");
                        break;
                        
                    case 4:
                        System.out.println("Opcion 4");
                        continuar = 1;
                        break;
                        
                    default:
                        System.out.println("Ingrese una opcion correcta.");
                        break;
                }

            } catch (InputMismatchException e) {
                //System.out.println(e.getMessage());
                //e.printStackTrace();
                System.out.println("Ingrese una opcion correcta");
            }
        }
    }
    
    //Funcion para seleccionar un caballo especifico y mostrar todos sus detalles
    //Falta Implementar navegabilidad
    //Y definir si la cantidad de caballos por carrera es fija o dinamica
    void muestraInformacionCaballos()
    {
    	int continuar = 0;
        while (continuar == 0) {
	        try {
		    	Scanner teclado = new Scanner(System.in);
		        
		        listarCaballos();
		        
		        System.out.println("");
		        System.out.println("Ingrese opcion:");
		        
		        int op = teclado.nextInt();
		        System.out.println("");
		        
		        switch (op) {
		            case 1:
		                System.out.println("Opcion 1");
		                break;
		
		            case 2:
		                System.out.println("Opcion 2");
		                break;
		               
		            case 3:
		                System.out.println("Opcion 3");
		                break;
		                
		            case 4:
		                System.out.println("Opcion 4");
		                break;
		                
		            default:
		                System.out.println("Ingrese una opcion correcta.");
		                break;
	        	}
	
	        }catch (InputMismatchException e) {
	        //System.out.println(e.getMessage());
	        //e.printStackTrace();
	        System.out.println("Ingrese una opcion correcta");
	        }
        }
    }
}
