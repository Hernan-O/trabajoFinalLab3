package Apuestas;

import Carreras.Carrera;
import Entes.Caballo;
import Entes.ListaGenerica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import Excepciones.*;

public class Exacta extends Apuesta{
    private Caballo ganador;
    
    //Constructor
    public Exacta(Carrera dat, Saldo saldo)
    {
        super(dat,saldo);
        this.ganador = ordenar().get(0);
    }
    //Ordena los caballos por orden de llegada, aplica modificadores segun tipo de carrera y raza del caballo
    @Override
    public ListaGenerica<Caballo> ordenar()
    {
    	ListaGenerica<Caballo> resultado = new ListaGenerica<>();
    	ListaGenerica<Caballo> aux = new ListaGenerica<>();
        aux = super.getListaOrden();
        aux = this.getTipo().cambiaProb(aux);
        resultado.agregar(aux.get(0));

        for(int i = 1; i < aux.size(); i++) {

             if(resultado.get(0).getProbabilidad()<aux.get(i).getProbabilidad())
             {
                 resultado.agregar(0,aux.get(i));
             }
        }
        return resultado;
    }
    
    //Despliega el menu por consola para realizar la apuesta
    public void desplegarMenu() throws opcionInexistente
    {
           	boolean continuar = true;
    	while(continuar) {
	        Scanner in = new Scanner(System.in);
	        super.imprimirListaApuesta();
	        
	        Saldo cuentaAux = this.getCuentaUser();
	        try{
	            System.out.println("Ingrese el caballo ganador");
	            int op = in.nextInt();
	            System.out.println("Cuenta actual:"+cuentaAux.getSaldo()+"\nIngrese el monto que quiere apostar:");
	            float apuesta = in.nextFloat();
	            
	            if(apuesta > cuentaAux.getSaldo() || apuesta <= 0){
	               System.out.println("Ingrese minimo 0 y maximo "+ cuentaAux.getSaldo());
	               apuesta = 0;
	               throw new SaldoInsuficiente();
	            }
	            if(op > 10 || op <= 0)
	            {
	              throw new opcionInexistente();
	            }
	            op--;
	            if(super.getListaOrden().get(op).equals(ganador))
	            {
	                System.out.println("GANASTE");
	                cuentaAux.apuestaGanada(apuesta, super.getListaOrden().get(op).getPorcentajeGanancia());
	            }else
	            {
	                System.out.println("Perdiste");
	                cuentaAux.apuestaPerdida(apuesta);
	            }
	            System.out.println("Monto luego de las apuestas:"+cuentaAux.getSaldo());
	            super.setCuentaUser(cuentaAux);
	            continuar = false;
	
	        }catch (InputMismatchException e)
	        {
	            System.out.println("Solo numeros");
	        }
	        catch(opcionInexistente e)
	        {
	            System.out.println("Entre 1 y 10");
	        } catch (SaldoInsuficiente e) {
				e.printStackTrace();
			}
    	}
       // super.setCuentaUser(cuentaAux);
    }



}
