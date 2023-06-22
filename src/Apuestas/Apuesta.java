package Apuestas;

import Carreras.Carrera;
import Entes.Caballo;
import Entes.ListaGenerica;
import Interfaces.Apostable;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Apuesta implements Apostable {

    public static ListaGenerica<Caballo> listaOrden;
    private Saldo cuentaUser;
    private Carrera tipo;
    
    //Constructor
    public Apuesta(Carrera dat,Saldo saldo) {
        this.tipo = dat;
        this.cuentaUser=saldo;
        this.listaOrden = archivoBuffer();
    }
    
    //Getters & Setters
    public ListaGenerica<Caballo> getListaOrden() {
        return listaOrden;
    }

    public Carrera getTipo() {
        return tipo;
    }

    public void setTipo(Carrera tipo) {
        this.tipo = tipo;
    }

    public Saldo getCuentaUser() {
        return cuentaUser; 
    }

    public void setCuentaUser(Saldo cuentaUser) {
        this.cuentaUser = cuentaUser;
    }
    
    //Lee el archivo de caballos en una lista generica y lo devuelve
	@SuppressWarnings("unchecked")
	public static ListaGenerica<Caballo> archivoBuffer() {
        ListaGenerica<Caballo> aux = new ListaGenerica<>();
        try {
            File archivo = new File("caballos.txt");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));
            aux = (ListaGenerica<Caballo>) in.readObject();

            in.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return aux;
    }
	
	//Recorre la lista de caballos e imprime el nombre
    public void imprimirListaApuesta()
    {
        System.out.println("Lista de caballos");
        int i = 1;
        for(Caballo ca: getListaOrden())
        {
            System.out.println("----------------------"+ i +"----------------------");
            System.out.println(ca.getNombre());
            System.out.println("Modificador" + ca.getPorcentajeGanancia());
            System.out.println("Probabilidad" + ca.getProbabilidad());
            i++;
        }
    }
    
    //Asigna un valor random al monto acumulado y calcula que porcentaje del total de lo apostado es
    public void calcularPorcentajeMonto()
    {
    	float suma=0;
    	float resultado;
    	
    	for(Caballo ca: getListaOrden())
    	{
    		ca.setMontoAcumuladoApuestas((new Random().nextFloat(0,1)*2)*ca.getProbabilidad());
    		suma=ca.getMontoAcumuladoApuestas()+suma;
    	}

    	for(Caballo ca: getListaOrden())
    	{
    		
    		resultado = (ca.getMontoAcumuladoApuestas()*100)/suma;
        	ca.setPorcentajeGanancia((float) (100-(resultado))/ca.getProbabilidad());

    	}
    	 System.out.println("Total: "+suma);
    }
    
    //Chequea si existe un caballo especifico en la lista
    public boolean existe(Caballo ente,ListaGenerica<Caballo> datos)
    {
        for(Caballo c:datos)
        {
            if(c.equals(ente))
            {
                return true;
            }
        }
        return false;
    }
}
