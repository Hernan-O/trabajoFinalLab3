package Entes;
import java.io.Serializable;
import java.util.Random;
import Carreras.Carrera;

public class Caballo implements Serializable {

    private int edad;
    private String nombre;
    private String nRaza;
    private float probabilidad;

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

    public Caballo(String nombre, int edad, int opc)
    {
        Caballo.Raza[] opciones = Caballo.Raza.values();
        this.nRaza= opciones[opc].toString();
        this.nombre=nombre;
        this.edad=edad;
        this.probabilidad = new Random().nextFloat()*100+1;
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
                "Raza: "+ getnRaza()+"\n";
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
