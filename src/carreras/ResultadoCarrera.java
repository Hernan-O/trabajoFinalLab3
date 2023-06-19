package carreras;

import java.util.ArrayList;
import java.util.Random;

import entes.Caballo;
import hipodromo.Hipodromo;

public class ResultadoCarrera {
	private ArrayList<Caballo> ordenDeLlegada;
	
	public ResultadoCarrera() { }
	
	public void ordenDeLlegada() {
		ordenDeLlegada = new ArrayList<Caballo>();
		ArrayList<Caballo> caballosTemp = new ArrayList<Caballo>(Hipodromo.caballos);
		
	   	 for(int i = 0; i < Hipodromo.caballos.size(); i++) {
	   		 
	   		Random random = new Random();
			double sumaProbabilidades = 0;
			
			for(Caballo c : caballosTemp) {
				sumaProbabilidades += c.getProbabilidadDeGanar();
			}
	   		 
	   		 double numeroAleatorio = random.nextDouble() * sumaProbabilidades;
	   		 double sumaParcial = 0;
	           
	         for(Caballo c : caballosTemp) {
	        	 sumaParcial += c.getProbabilidadDeGanar();
	        	 if(numeroAleatorio <= sumaParcial) {
	        		 ordenDeLlegada.add(c);
	        		 caballosTemp.remove(c);
	        		 break;
	        	 }
	         }	
	   	}
	}
	
	public void ListarOrdenDeLlegada() {
		int i = 1;
		for(Caballo c : ordenDeLlegada) {
			System.out.println("Puesto - " + i + "° " + c.toString());
			i++;
		} 
	}

	public ArrayList<Caballo> getOrdenDeLlegada() {
		return ordenDeLlegada;
	}

	public void setOrdenDeLlegada(ArrayList<Caballo> ordenDeLlegada) {
		this.ordenDeLlegada = ordenDeLlegada;
	}
	
	
	
}
