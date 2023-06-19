package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import entes.Caballo;
import hipodromo.Hipodromo;

public class MenuCarreras {
	private MenuApuesta menuApuesta;
	
	public MenuCarreras()
	{
		menuApuesta = new MenuApuesta();
	}
	
	
	
	public void menuCarrera()
    {
    	int continuar = 0;
        while (continuar == 0) {
            try {
                Scanner teclado = new Scanner(System.in);
               
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
                        menuApuesta.menu();
                        break;

                    case 2:
                        System.out.println("Opcion 2");
                        Hipodromo.listarCaballos();
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
}
