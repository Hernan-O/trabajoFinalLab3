package apuestas;

import entes.Caballo;

public class ApuestaImperfecta extends Apuesta {

	private Caballo primer_puesto;
	private Caballo Segundo_puesto;
	
	public ApuestaImperfecta(double monto, Caballo primer_puesto, Caballo segundo_puesto) {
		super(monto);
		this.primer_puesto = primer_puesto;
		Segundo_puesto = segundo_puesto;
	}

}
