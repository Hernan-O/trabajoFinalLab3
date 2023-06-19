package Apuestas;

import Entes.Caballo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import Excepciones.*;

public class Exacta extends Apuesta{

    private Caballo ganador;

    public Exacta(int cuentaUser)
    {
        super();
        this.getCuentaUser().setSaldo(cuentaUser);
        this.ganador = ordenar().get(0);
    }

    @Override
    public ArrayList<Caballo> ordenar()
    {
        ArrayList<Caballo> resultado = new ArrayList<>();
        resultado.add(super.getListaOrden().get(0));

        for(int i = 1; i < super.getListaOrden().size(); i++) {

             if(resultado.get(0).getProbabilidad()<super.getListaOrden().get(i).getProbabilidad())
             {
                 resultado.set(0,super.getListaOrden().get(i));
             }
        }
        return resultado;
    }

    public Saldo devolverTotal(){
        return this.getCuentaUser();
    }
    public Saldo desplegarMenu() throws opcionInexistente
    {
        Scanner in = new Scanner(System.in);
        super.imprimirLista();
        Saldo cuentaAux = this.getCuentaUser();
        try{
            System.out.println("Ingrese el caballo ganador");
            int op = in.nextInt();
            System.out.println("Cuenta actual:"+cuentaAux.getSaldo()+"\nIngrese el monto que quiere apostar:");
            int apuesta = in.nextInt();
            if(apuesta > cuentaAux.getSaldo() || apuesta <= 0){
                System.out.println("Ingrese minimo 0 y maximo "+ cuentaAux.getSaldo());
                apuesta = 0;
            }
            if(op > 10 || op <= 0)
            {
              throw new opcionInexistente();
            }
            op--;
            if(super.getListaOrden().get(op).equals(ganador))
            {
                System.out.println("GANASTE");
                cuentaAux.apuestaGanada(apuesta);
            }else
            {
                System.out.println("Perdiste");
                cuentaAux.apuestaPerdida(apuesta);
            }
            System.out.println("Monto luego de las apuestas:"+cuentaAux.getSaldo());
            return cuentaAux;

        }catch (InputMismatchException e)
        {
            System.out.println("Solo numeros");
        }
        catch(opcionInexistente e)
        {
            System.out.println("Entre 1 y 10");
        }
        return cuentaAux;
    }
}
