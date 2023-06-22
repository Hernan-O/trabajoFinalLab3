package Apuestas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Carreras.Carrera;
import Entes.Caballo;
import Entes.ListaGenerica;
import Excepciones.SaldoInsuficiente;
import Excepciones.opcionInexistente;

public class Trifecta extends Apuesta implements Serializable{

    private ListaGenerica<Caballo> ganadores;
    //Constructor
    public Trifecta(Carrera dat,Saldo saldo)
    {
        super(dat,saldo);
        this.ganadores=ordenar();
        this.ganadores = this.getTipo().cambiaProb(this.ganadores);
    }
    
    @Override
    public ListaGenerica<Caballo> ordenar()
    {
    	ListaGenerica<Caballo> seleccionados = new ListaGenerica<>();
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
        /* ANTERIOR FORMA DE ORDEN ALEATORIO
        ArrayList<Caballo> resultado = new ArrayList<>(super.getListaOrden());
        Collections.shuffle(resultado);

        ArrayList<Caballo> aux = new ArrayList<>();
        aux.add(resultado.get(0));
        aux.add(resultado.get(1));
        aux.add(resultado.get(2));

        return aux;
    */
        return seleccionados;
    }

    //Despliega el menu para que el usuario pueda seleccionar los caballos ganadores
    public void desplegarMenu() throws opcionInexistente
    {
    	boolean continuar = true;
 
    	ListaGenerica<Caballo> resultado=new ListaGenerica<>();
        Scanner in = new Scanner(System.in);
        super.imprimirListaApuesta();

        Saldo cuentaAux = this.getCuentaUser();
        
    	while(continuar) {
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
	
	            if(resultado(resultado))
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
	            System.out.println("N1: "+ganadores.get(0).getNombre());
	            System.out.println("N2: "+ganadores.get(1).getNombre());
	            System.out.println("N3: "+ganadores.get(2).getNombre());
	            
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
    //Chequea si los caballos elegidos por el usuario se corresponden con los ganadores de la carrera
    public boolean resultado(ListaGenerica<Caballo> resu)
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
