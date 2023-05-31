package Clases;

public class Jockey {
    private String nombre;
    private int edad;

    public Jockey(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void mostrarInformacion(){
        System.out.println("Nombre del Jockey:"+this.getNombre()+"\nEdad del Jockey:"+this.getEdad());
    }
}
