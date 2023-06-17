package menus;

import java.util.Scanner;

import carreras.CampoTraviesa;
import carreras.Lisa;
import carreras.Obstaculos;

public class Jugar {
	private static final Scanner in = new Scanner(System.in);
	public Jugar() {

	}
	
	public void elegirCarrera() {
		System.out.println("*** CARRERAS ***");
		System.out.println("-" + new CampoTraviesa().toString());
		System.out.println("-" + new Obstaculos().toString());
		System.out.println("-" + new Lisa().toString());
		
		int opc = 0;
		opc = in.nextInt();
		in.nextLine();
		
		switch(opc) {
		case 1:
			
			break;
			
		case 2:
			
			break;
		
		default:
			break;
		}
	}
}
