package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import carreras.CampoTraviesa;
import carreras.Lisa;
import carreras.Obstaculos;

public class Jugar {
	private static final Scanner in = new Scanner(System.in);
	public Jugar() {

	}
	
	public void elegirCarrera() {
		int continuar = 0;
        while (continuar == 0) {
            try {

                System.out.println("*** CARRERAS ***");
        		System.out.println("1-" + new CampoTraviesa().toString());
        		System.out.println("2-" + new Obstaculos().toString());
        		System.out.println("3-" + new Lisa().toString());
        		System.out.println("4-Salir " );

                int op = in.nextInt();
                in.nextLine();
                
                switch (op) {
                    case 1:
                        new CampoTraviesa("Anashe", "Dificileasymode");
                        break;

                    case 2:
                        new Obstaculos(); 
                        break;
                    case 3:
                    	new Lisa();
                        break;
                    case 4:
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
}
