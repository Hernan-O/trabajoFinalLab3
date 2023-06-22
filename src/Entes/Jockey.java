package Entes;

import java.io.Serializable;
import java.util.Objects;

public class Jockey implements Serializable{
	private String nombre;
	private float peso;
	
	public Jockey(String nombre, float peso) {
		this.nombre = nombre;
		this.peso = peso;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jockey other = (Jockey) obj;
		return Objects.equals(nombre, other.nombre) && Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso);
	}

	@Override
	public String toString() {
		return "Jockey [nombre=" + nombre + ", peso=" + peso + "]";
	}
	
	
	
}
