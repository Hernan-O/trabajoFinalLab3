package Apuestas;

import Carreras.Carrera;
import Entes.Caballo;
import Excepciones.SaldoInsuficiente;
import Excepciones.opcionInexistente;
import genericos.ListaGenerica;

import java.util.*;

public class Imperfecta extends Apuesta{

    private ListaGenerica<Caballo> tresPrimeros;


    public Imperfecta(Carrera dat, Saldo saldo)
    {
        super(dat,saldo);
        this.tresPrimeros=ordenar();
        this.tresPrimeros = this.getTipo().cambiaProb(this.tresPrimeros);
    }

    @Override
    public ListaGenerica<Caballo> ordenar()
    {
        ListaGenerica<Caballo> seleccionados = new ListaGenerica<Caballo>();
        Random random = new Random();

        // Calcula la suma total de las probabilidades
        double sumaProbabilidades = 0.0;
        for (Caballo objeto : super.getListaOrden()) {
            sumaProbabilidades += objeto.getProbabilidad();
        }

        for (int i = 0; i <= 3; i++) {
            double r = random.nextDouble() * sumaProbabilidades;
            double acumulado = 0.0;
            int selectedIndex = -1;
            for (int j = 0; j < super.getListaOrden().size(); j++) {
                Caballo objeto = super.getListaOrden().get(j);
                acumulado += objeto.getProbabilidad();
                if (r <= acumulado) {
                    selectedIndex = j;
                    break;
                }
            }
            if (selectedIndex != -1) {
                if(!(existe(super.getListaOrden().get(selectedIndex),seleccionados)))
                {
                    seleccionados.agregar(super.getListaOrden().get(selectedIndex));
                    sumaProbabilidades -= super.getListaOrden().get(selectedIndex).getProbabilidad();
                }
            }
        }
        return seleccionados;
    }

    public void desplegarMenu() throws opcionInexistente
    {
    	boolean continuar = true;
        ListaGenerica<Caballo> resultado=new ListaGenerica<Caballo>();
        Scanner in = new Scanner(System.in);
        super.imprimirListaApuesta();

        Saldo cuentaAux = this.getCuentaUser();
        while(continuar) {
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
	                resultado.agregar(super.getListaOrden().get(op-1));
	                i++;
	            }
	
	            System.out.println("Cuenta actual:"+cuentaAux.getSaldo()+"\nIngrese el monto que quiere apostar:");
	            float apuesta = in.nextFloat();
	            if(apuesta > cuentaAux.getSaldo() || apuesta <= 0){
	                System.out.println("Ingrese minimo 0 y maximo "+ cuentaAux.getSaldo());
	                apuesta = 0;
	                throw new SaldoInsuficiente();
	            }
	
	            System.out.println("INTENTO 1: "+ resultado.get(0).getNombre());
	            System.out.println("INTENTO 2: "+ resultado.get(1).getNombre());
	            System.out.println("INTENTO 3: "+ resultado.get(2).getNombre());
	
	            if(resultado(tresPrimeros,resultado))
	            {
	            	float modificarSumadoGanadores = resultado.get(0).getPorcentajeGanancia()+
	            			resultado.get(1).getPorcentajeGanancia() + 
	            			resultado.get(2).getPorcentajeGanancia();
	                System.out.println("GANASTE");
	                cuentaAux.apuestaGanada(apuesta, modificarSumadoGanadores);
	                
	                
	            }else
	            {
	                System.out.println("Perdiste");
	                cuentaAux.apuestaPerdida(apuesta);
	            }
	            System.out.println("Monto luego de las apuestas:"+cuentaAux.getSaldo());
	            super.setCuentaUser(cuentaAux);
	            continuar = false;
	            System.out.println("MOSTRANDO RESULTADOS");
	            System.out.println("N1: "+tresPrimeros.get(0).getNombre());
	            System.out.println("N2: "+tresPrimeros.get(1).getNombre());
	            System.out.println("N3: "+tresPrimeros.get(2).getNombre());
	            
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
        //super.setCuentaUser(cuentaAux);
    }

    public boolean resultado(ListaGenerica<Caballo> tresPrimeros2,ListaGenerica<Caballo> resultado)
    {
        for(Caballo c:resultado)
        {
            if(!(existe(c,tresPrimeros2)))
            {
                return false;
            }
        }
        return true;
    }

}
