package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import carreras.CampoTraviesa;
import carreras.Lisa;
import carreras.Obstaculos;

public class Jugar {
	private static final Scanner in = new Scanner(System.in);
	private CampoTraviesa campo_traviesa;
	private Obstaculos obstaculos;
	private Lisa lisa;
	public Jugar() {
		this.campo_traviesa = new CampoTraviesa();
		this.lisa = new Lisa();
		this.obstaculos = new Obstaculos();
	}
	
	public void elegirCarrera() {
		boolean continuar = true;
        while (continuar) {
            try {

                System.out.println("*** CARRERAS ***");
        		System.out.println("1-" + campo_traviesa.toString());
        		System.out.println("2-" + obstaculos.toString());
        		System.out.println("3-" + lisa.toString());
        		System.out.println("4-ATRAS " );

                int op = 0;
                op = in.nextInt();
                in.nextLine();
                
                switch (op) {
                    case 1:
                        campo_traviesa.menuCarreras();
                        break;

                    case 2:
                        obstaculos.menuCarreras();
                        break;
                    case 3:
                    	lisa.menuCarreras();
                        break;
                    case 4:
                        continuar = false;
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
