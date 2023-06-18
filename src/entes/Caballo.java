package entes;

import java.util.Random;

public class Caballo {
    private int edad;
    private String nombre;
    private Jockey piloto;
    private Raza raza;
    private double probabilidadDeGanar;

    public Caballo(int edad,String nombre,Jockey piloto,Raza raza) {
        this.edad = edad;
        this.nombre = nombre;
        this.piloto = piloto;
        this.raza = raza;
        this.probabilidadDeGanar = new Random().nextDouble();
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Jockey getPiloto() {
        return piloto;
    }

    public void setPiloto(Jockey piloto) {
        this.piloto = piloto;
    }

    public double getProbabilidadDeGanar() {
		return probabilidadDeGanar;
	}
	public void setProbabilidadDeGanar(double probabilidadDeGanar) {
		this.probabilidadDeGanar = probabilidadDeGanar;
	}
	public void mostrarInformacion(){
        System.out.println("Nombre del caballo:"+this.getNombre()+"\nEdad caballo"+this.getEdad());
        this.piloto.mostrarInformacion();
    }
	@Override
	public String toString() {
		return "Caballo [edad=" + edad + ", nombre=" + nombre + ", piloto=" + piloto + ", raza=" + this.getRaza() + 
				"Probabilidad de ganar= " + probabilidadDeGanar + "]";
	}
    
    

}
