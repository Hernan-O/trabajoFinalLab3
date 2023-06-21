package Excepciones;
import java.lang.Exception;

import Apuestas.Apuesta;

public class SaldoInsuficiente extends Exception{

    public SaldoInsuficiente()
    {
        System.out.println("El saldo que tienes es insuficiente");
    }
}