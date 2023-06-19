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

    public Exacta()
    {
        super();
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


    public void desplegarMenu() throws opcionInexistente
    {
        Scanner in = new Scanner(System.in);
        super.imprimirLista();

        try{
            System.out.println("Ingrese el caballo ganador");
            int op = in.nextInt();

            if(op > 10 || op <= 0)
            {
              throw new opcionInexistente();
            }
            op--;
            if(super.getListaOrden().get(op).equals(ganador))
            {
                System.out.println("GANASTE");
            }else
            {
                System.out.println("Perdiste");
            }

        }catch (InputMismatchException e)
        {
            System.out.println("Solo numeros");
        }
        catch(opcionInexistente e)
        {
            System.out.println("Entre 1 y 10");
        }


    }

}
