package apuestas;

import entes.Caballo;

public abstract class Apuesta {
    protected double monto;
    
	public Apuesta(double monto) {
		this.monto = monto;
	}
    
   public abstract boolean acertar();
}
