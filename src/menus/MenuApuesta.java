package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import apuestas.Apuesta;
import apuestas.ApuestaExacta;
import apuestas.ApuestaGanador;
import apuestas.ApuestaImperfecta;
import carreras.ResultadoCarrera;

public class MenuApuesta {
	private static final Scanner in = new Scanner(System.in);
	private ResultadoCarrera resultado;
	private Apuesta apuesta;
	
	public MenuApuesta() {
		this.resultado = new ResultadoCarrera();
	}
	
	public void menu() {
		boolean continuar = true;
		while(continuar) {
			try {
		        System.out.println("");
		        System.out.println("Ingrese opcion:");
		        System.out.println("1: GANADOR");
		        System.out.println("2: EXACTA");
		        System.out.println("3: IMPERFECTA");
		        System.out.println("4: ATRAS");
		        System.out.println("");
			
				int opc = in.nextInt();
				in.nextLine();
				switch(opc) {
				case 1:
					
					apuesta = new ApuestaGanador(opc, null);
					
					resultado.ordenDeLlegada();
					resultado.ListarOrdenDeLlegada();
					
					break;
				case 2:
					apuesta = new ApuestaExacta(opc, null, null);
					
					resultado.ordenDeLlegada();
					resultado.ListarOrdenDeLlegada();
					
					break;
				case 3:
					apuesta = new ApuestaImperfecta(opc, null, null);
					
					resultado.ordenDeLlegada();
					resultado.ListarOrdenDeLlegada();
					
					break;
				case 4:
					continuar = false;
					break;
				default: 
					System.out.println("Ingrese una opcion valida...");
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
