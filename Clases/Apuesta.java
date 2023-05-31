package Clases;

public class Apuesta {
    private Cliente cliente;
    private double monto;

    public Apuesta(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
