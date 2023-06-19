package apuestas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import carreras.ResultadoCarrera;
import entes.Caballo;
import hipodromo.Hipodromo;

public class MenuApuestaGanadora {
	private static final Scanner in = new Scanner(System.in);
	private ResultadoCarrera resultado;
	Caballo caballoElegido;
	int montoApostado;
	
	public MenuApuestaGanadora()
	{
		this.resultado = new ResultadoCarrera();
	}
	
	public void menu() {
		boolean continuar = true;
		ArrayList<Caballo> caballosTemp = new ArrayList<Caballo>(Hipodromo.caballos);
		
		while(continuar) {
			try {
				System.out.println("¡Seleccione su Caballo! ¿Saldra ganador?");
		        Hipodromo.listarCaballos();
			
		        
				int opc = in.nextInt();
				in.nextLine();
					
				caballoElegido = caballosTemp.get(opc-1);
				System.out.println("¿Cuanto le va a apostar?");
				montoApostado = in.nextInt();
				resultado.ordenDeLlegada();
				resultado.ListarOrdenDeLlegada();
				
				if(caballoElegido.equals(resultado.getOrdenDeLlegada().get(0)))
				{	
					System.out.println("¡Su prediccion ha sido acertada!");
					System.out.println("¡Usted ha ganado: " + montoApostado*4 + "!");
				}
				else
				{
					System.out.println("Usted ha perdido :((((((");
				}
				continuar = false;
				
			} catch (InputMismatchException e) {
                //System.out.println(e.getMessage());
                //e.printStackTrace();
                System.out.println("Ingrese una opcion correcta");
			}catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Ingrese una opcion correcta");
			}
			
		}
	}
}
