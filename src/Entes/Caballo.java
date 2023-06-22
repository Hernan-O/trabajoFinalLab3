package Entes;
import java.io.Serializable;
import java.util.Random;

public class Caballo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3765160581934983034L;
	
	private int edad;
    private String nombre;
    private String nRaza;
    private float probabilidad;
    private float montoAcumuladoApuestas;
    private float porcentajeGanancia;
    private Jockey piloto;
    
    
    public float getPorcentajeGanancia() {
		return porcentajeGanancia;
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

    public Jockey getPiloto() {
        return piloto;
    }

    public void setPiloto(Jockey piloto) {
        this.piloto = piloto;
    }

    public Caballo(String nombre, int edad, int opc)
    {
        Caballo.Raza[] opciones = Caballo.Raza.values();
        this.nRaza= opciones[opc].toString();
        this.nombre=nombre;
        this.edad=edad;
        this.probabilidad = new Random().nextFloat()*100+1;
        
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

    @Override
    public String toString()
    {
        return  "Nombre: "+ getNombre()+"\n" +
                "Edad: "+ getEdad()+"\n"+
                "Raza: "+ getnRaza()+"\n"+
                "Probabilidad: "+ getProbabilidad()+
                "Nombre del jockey: "+ getPiloto().getNombre();
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
