package Apuestas;

import java.io.Serializable;

public class Saldo implements Serializable {
    private int saldo;

    public Saldo() {
        this.saldo=20000;
    }

    public Saldo(int saldoActual) {
        this.saldo = saldoActual;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void apuestaPerdida(int apuesta) {
        this.saldo = saldo - apuesta;
    }

    public void apuestaGanada(int apuesta) {
        this.saldo = this.saldo + (apuesta * 2);
    }
}
