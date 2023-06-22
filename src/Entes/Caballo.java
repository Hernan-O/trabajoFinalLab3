package Entes;
import java.io.Serializable;
import java.util.Random;
import Carreras.Carrera;

public class Caballo implements Serializable {

    private int edad;
    private String nombre;
    private String nRaza;
    private float probabilidad;
    private float montoAcumuladoApuestas;
    private float porcentajeGanancia;
    private float peso;
    private int altura;
    //Constructor
    public Caballo(String nombre, int edad, int opc)
    {
        Caballo.Raza[] opciones = Caballo.Raza.values();
        this.nRaza= opciones[opc].toString();
        this.nombre=nombre;
        this.edad=edad;
        this.altura = new Random().nextInt(187 - 147 + 1) + 147;
        this.peso = 409 + new Random().nextFloat() * (522 - 409);
        this.probabilidad = calculaProbabilidad();
         
        
    }
    //Gets & sets

    public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public float getMontoAcumuladoApuestas()
    {
    	return montoAcumuladoApuestas;
    }
    
    public void setMontoAcumuladoApuestas(float montoAcumulado)
    {
    	this.montoAcumuladoApuestas = montoAcumulado;
    }	
   
    public float getProbabilidad() {
        return probabilidad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getnRaza() {
        return nRaza;
    }

    public void setProbabilidad(float probabilidad) {
        this.probabilidad = probabilidad;
    }

    private enum Raza
    {
        ANGLO,
        AMERICANO,
        ARABE;
    }
    
    
    public float calculaProbabilidad()
    {
    	float probabilidad = new Random().nextFloat()*100+1;
    	return probabilidad;
    }
    //Metodos
    @Override
    public String toString()
    {
        return  "Nombre: "+ getNombre()+"\n" +
                "Edad: "+ getEdad()+"\n"+
                "Raza: "+ getnRaza()+"\n"+
                "Altura: "+ getAltura()+"\n"+
                "Peso: "+ getPeso()+"\n"+
                "Probabilidad: "+ getProbabilidad();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){return true;}
        if(!(obj instanceof Caballo)){return false;}
        else{
            Caballo nuevo = (Caballo) obj;
            return nuevo.getNombre().equals(this.getNombre());
        }
    }

    @Override
    public int hashCode() {
        return this.getNombre().hashCode();
    }

}
