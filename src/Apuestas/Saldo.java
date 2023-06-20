package Apuestas;

import java.io.Serializable;

import Entes.Caballo;

public class Saldo implements Serializable {
    private float saldo;

    public Saldo() {
        this.saldo=20000;
    }

    public Saldo(float saldoActual) {
        this.saldo = saldoActual;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void apuestaPerdida(float apuesta) {
        this.saldo = saldo - apuesta;
    }

    public void apuestaGanada(float apuesta, float modificador) {
        this.saldo = this.saldo + (apuesta + (apuesta * modificador));
    }
}
