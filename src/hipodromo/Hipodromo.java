package hipodromo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import apuestas.Apuesta;
import carreras.Carrera;
import entes.Caballo;
import menus.Jugar;

public class Hipodromo {
   
    private HashSet<Carrera> carreras;
    private HashSet<Apuesta> apuestas ;
    public static  HashSet<Caballo> caballos ;
    private static final Scanner in = new Scanner(System.in);
    
    public Hipodromo(HashSet<Caballo> caballosSinSeleccionar)
    {
    	 this.carreras = new HashSet<Carrera>();
    	 this.apuestas = new HashSet<Apuesta>();
    	 caballos= new HashSet<Caballo>();
    	 seleccionarCaballos(caballosSinSeleccionar);
    }
    
    public void menu() {
        int continuar = 0;
        while (continuar == 0) {
            try {

                System.out.println("Ingrese opcion:");
                System.out.println("1: JUGAR");
                System.out.println("2: SALIR");

                int op = in.nextInt();
                in.nextLine();
                switch (op) {
                    case 1:
                    	
                        new Jugar().elegirCarrera();
                        break;

                    case 2:
                        System.out.println("Fin juego");
                        System.exit(0);
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
    
    public void seleccionarCaballos(HashSet<Caballo> caballosSinSeleccionar)
    {
    	List<Caballo> caballosTemp = new ArrayList<>(caballosSinSeleccionar);
    	 Random random = new Random();
    	 while (caballos.size() < 8 && !caballosTemp.isEmpty()) {
    		int index = random.nextInt(caballosTemp.size());
            Caballo caballoSeleccionado = caballosTemp.get(index);
            
            if (!caballos.contains(caballoSeleccionado)) {
                caballos.add(caballoSeleccionado);
            }
            caballosTemp.remove(index);
    		
    	}
    }
    
    public static void listarCaballos()
	{
    	int i = 1;
		for(Caballo caballo : caballos)
		{
			System.out.println(i + caballo.getNombre());
			i++;
		}
	}
}
