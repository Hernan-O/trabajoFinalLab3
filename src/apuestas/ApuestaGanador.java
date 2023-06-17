package apuestas;

import entes.Caballo;

public class ApuestaGanador extends Apuesta {

	private Caballo ganador;

	public ApuestaGanador(double monto, Caballo ganador) {
		super(monto);
		this.ganador = ganador;
	}

}
