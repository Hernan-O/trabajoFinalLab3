package apuestas;

import java.util.InputMismatchException;

import entes.Caballo;

public class ApuestaGanador extends Apuesta {

	private Caballo ganador;

	public ApuestaGanador(double monto, Caballo ganador) {
		super(monto);
		this.ganador = ganador;
	}

	@Override
	public boolean acertar() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

