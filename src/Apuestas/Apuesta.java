package Apuestas;

import java.io.IOException;
import java.util.Random;

import Archivos.Leer;
import Carreras.Carrera;
import Entes.Caballo;
import Entes.Jockey;
import Interfaces.Apostable;
import genericos.ListaGenerica;

public abstract class Apuesta implements Apostable {

    public static ListaGenerica<Caballo> listaOrden;
    private ListaGenerica<Jockey> listaJockey;
    private Saldo cuentaUser;
    private Carrera tipo;

    public ListaGenerica<Caballo> getListaOrden() {
        return listaOrden;
    }

    public Apuesta(Carrera dat,Saldo saldo) {
        this.tipo = dat;
        this.cuentaUser=saldo;
        Apuesta.listaOrden = archivoBuffer();
        cargarArrayDeJockey();
    }
    
 
	@SuppressWarnings("unchecked")
	public static ListaGenerica<Caballo> archivoBuffer() {
    	ListaGenerica<Caballo> aux= new ListaGenerica<Caballo>();
        Leer<Object> leer = new Leer<Object>();
        try {
			leer.abrir("caballos");
			aux = (ListaGenerica<Caballo>) leer.leer();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return aux;
    }
    
    @SuppressWarnings("unchecked")
	public void cargarArrayDeJockey() {
    	Leer<Object> leer = new Leer<Object>();
    	try {
			leer.abrir("jockey");
			listaJockey = (ListaGenerica<Jockey>) leer.leer();
			//System.out.println(listaJockey.listaEntera()); //Para que toto vea que si funciona. "borrar comentario"
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
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
    
    
    public boolean existe(Caballo ente,ListaGenerica<Caballo> tresPrimeros2)
    {
        for(Caballo c:tresPrimeros2)
        {
            if(c.equals(ente))
            {
                return true;
            }
        }
        return false;
    }
}
