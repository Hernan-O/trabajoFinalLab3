package Apuestas;

import Entes.Caballo;
import Excepciones.opcionInexistente;

import java.util.*;

public class Trifecta extends Apuesta{

    private ArrayList<Caballo> ganadores;

    public Trifecta(Saldo saldo)
    {
        super(saldo);
        this.ganadores=ordenar();

    }

    @Override
    public ArrayList<Caballo> ordenar()
    {
        ArrayList<Caballo> resultado = new ArrayList<>(super.getListaOrden());
        Collections.shuffle(resultado);

        ArrayList<Caballo> aux = new ArrayList<>();
        aux.add(resultado.get(0));
        aux.add(resultado.get(1));
        aux.add(resultado.get(2));

        return aux;
    }

    public void desplegarMenu() throws opcionInexistente
    {
        ArrayList<Caballo> resultado=new ArrayList<>();
        Scanner in = new Scanner(System.in);
        super.imprimirLista();
        System.out.println("MOSTRANDO RESULTADOS");
        System.out.println("N1: "+ganadores.get(0).getNombre());
        System.out.println("N1: "+ganadores.get(1).getNombre());
        System.out.println("N1: "+ganadores.get(2).getNombre());

        Saldo cuentaAux = this.getCuentaUser();
        try{

            int i=0;
            while(i!=3)
            {
                System.out.println("Ingrese el puesto: "+(i+1));
                int op = in.nextInt();
                if(op > 10 || op <= 0)
                {
                    throw new opcionInexistente();
                }
                if(super.existe(super.getListaOrden().get(op-1),resultado))
                {
                    System.out.println("No puede elegir el mismo caballo");
                    i--;
                }
                resultado.add(super.getListaOrden().get(op-1));
                i++;
            }

            System.out.println("Cuenta actual:"+cuentaAux.getSaldo()+"\nIngrese el monto que quiere apostar:");
            int apuesta = in.nextInt();
            if(apuesta > cuentaAux.getSaldo() || apuesta <= 0){
                System.out.println("Ingrese minimo 0 y maximo "+ cuentaAux.getSaldo());
                apuesta = 0;
            }


            if(resultado(resultado))
            {
                System.out.println("GANASTE");
                cuentaAux.apuestaGanada(apuesta);
            }else
            {
                System.out.println("Perdiste");
                cuentaAux.apuestaPerdida(apuesta);
            }
            System.out.println("Monto luego de las apuestas:"+cuentaAux.getSaldo());
            super.setCuentaUser(cuentaAux);

        }catch (InputMismatchException e)
        {
            System.out.println("Solo numeros");
        }
        catch(opcionInexistente e)
        {
            System.out.println("Entre 1 y 10");
        }
        super.setCuentaUser(cuentaAux);
    }



    public boolean resultado(ArrayList<Caballo> resu)
    {
        int i=0;
        for(Caballo c:resu)
        {
            if(c.equals(this.ganadores.get(i)))
            {
                i++;
            }else
            {
                return false;
            }
        }
        return true;
    }
}
