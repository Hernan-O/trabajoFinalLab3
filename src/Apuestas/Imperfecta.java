package Apuestas;

import Entes.Caballo;
import Excepciones.opcionInexistente;

import java.util.*;

public class Imperfecta extends Apuesta{

    private ArrayList<Caballo> tresPrimeros;


    public Imperfecta(int cuentaUser)
    {
        super();
        this.getCuentaUser().setSaldo(cuentaUser);
        this.tresPrimeros=ordenar();
    }

    @Override
    public ArrayList<Caballo> ordenar()
    {
        ArrayList<Caballo> resultado = new ArrayList<>(super.getListaOrden());
        Collections.shuffle(resultado);

        return resultado;
    }

    public Saldo desplegarMenu() throws opcionInexistente
    {
        ArrayList<Caballo> resultado=new ArrayList<>();
        Scanner in = new Scanner(System.in);
        super.imprimirLista();
        System.out.println("MOSTRANDO RESULTADOS");
        System.out.println("N1: "+tresPrimeros.get(0).getNombre());
        System.out.println("N1: "+tresPrimeros.get(1).getNombre());
        System.out.println("N1: "+tresPrimeros.get(2).getNombre());

        Saldo cuentaAux = this.getCuentaUser();
        try{

            int i=0;
            while(i!=3)
            {
                System.out.println("Ingrese los 3 primeros caballos, Sin importar el orden");
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

    public boolean resultado(ArrayList<Caballo> ca)
    {
        for(Caballo c:super.getListaOrden())
        {
            if(!(existe(c,ca)))
            {
                return false;
            }
        }
        return true;
    }

}
