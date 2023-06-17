package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuApuesta {
	
	void menuApuesta()
	{
		int continuar = 0;
        while (continuar == 0) {
            try {
                Scanner teclado = new Scanner(System.in);
				System.out.println("");
		        System.out.println("Ingrese opcion:");
		        System.out.println("1: Apostar al primer puesto");
		        System.out.println("2: Apostar al segundo puesto");
		        System.out.println("3: Apostar al tercer puesto");
		        System.out.println("4: Apostar a la Trifecta");
		        System.out.println("5: Apostar a la Cuatrifecta");
		        System.out.println("6: Apostar a la Quintafecta");
		        System.out.println("0: Volver");
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
	                    
	                    break;
	                    
	                case 5:
	                    System.out.println("Opcion 4");
	                    
	                    break;
	                    
	                case 6:
	                    System.out.println("Opcion 4");
	                    
	                    break;
	                    
	                case 0:
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
