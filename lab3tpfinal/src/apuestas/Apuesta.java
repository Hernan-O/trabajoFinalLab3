package apuestas;

import entes.Cliente;

public abstract class Apuesta {
    private Cliente cliente;
    private double monto;

    public Apuesta(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }
   
}
