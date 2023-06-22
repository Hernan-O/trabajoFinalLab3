package Excepciones;
import java.io.Serializable;
import java.lang.Exception;

import Apuestas.Apuesta;

public class SaldoInsuficiente extends Exception implements Serializable{

    public SaldoInsuficiente()
    {
        System.out.println("El saldo que tienes es insuficiente");
    }
}