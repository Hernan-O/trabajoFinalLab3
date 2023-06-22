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

    public ListaGenerica<Caballo> getListaOrden() {
        return listaOrden;
    }

    public Apuesta(Carrera dat,Saldo saldo) {
        this.tipo = dat;
        this.cuentaUser=saldo;
        this.listaOrden = archivoBuffer();
    }
    
    
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

    public void imprimirListaApuesta()
    {
        System.out.println("Lista de caballos");
        int i = 1;
        for(Caballo ca: getListaOrden())
        {
            System.out.println("----------------------"+ i +"----------------------");
            System.out.println(ca.getNombre());
            i++;
        }
    }
    
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
