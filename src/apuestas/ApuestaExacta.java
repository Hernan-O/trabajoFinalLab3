package apuestas;

import entes.Caballo;

public class ApuestaExacta extends Apuesta {
	private Caballo primer_puesto;
	private Caballo segundo_puesto;
	
	public ApuestaExacta(double monto, Caballo primer_puesto, Caballo segundo_puesto) {
		super(monto);
		this.primer_puesto = primer_puesto;
		this.segundo_puesto = segundo_puesto;
	}

}
