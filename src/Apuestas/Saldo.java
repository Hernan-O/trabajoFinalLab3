package Apuestas;

import java.io.Serializable;

import Entes.Caballo;

public class Saldo implements Serializable {
    private float saldo;
    //Constructores
    public Saldo() {
        this.saldo=20000;
    }
    
    public Saldo(float saldoActual) {
        this.saldo = saldoActual;
    }
    //Gets and set
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public float getSaldo() {
        return saldo;
    }
    //Modifica el saldo del usuario de manera negativa
    public void apuestaPerdida(float apuesta) {
        this.saldo = saldo - apuesta;
    }
    //Modifica el saldo del ususario segun el modificador de manera positiva
    public void apuestaGanada(float apuesta, float modificador) {
        this.saldo = this.saldo + (apuesta + (apuesta * modificador));
    }
}
