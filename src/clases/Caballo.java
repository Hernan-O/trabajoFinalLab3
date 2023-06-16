package trabajao;

import static java.lang.Math.random;

public class Caballo {
    private int edad;
    private String nombre;
    private Jockey piloto;
    private String raza;
    private float stat; //Le genera un numero al azar con el que se mide la posibilidad de ganar

    public Caballo(int edad,String nombre,Jockey piloto,String raza) {
        this.edad = edad;
        this.nombre = nombre;
        this.piloto = piloto;
        if (raza.equalsIgnoreCase("Arabe") || raza.equalsIgnoreCase("Anglo") || raza.equalsIgnoreCase("Americano")) {
            this.raza = raza;
        }
        this.stat =(float)(Math.random()*10+1);
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Jockey getPiloto() {
        return piloto;
    }

    public void setPiloto(Jockey piloto) {
        this.piloto = piloto;
    }
    public void setStat(){
        this.stat =(float)(Math.random()*10+1);
    }
    public float getStat(){
        return this.stat;
    }
    public void mostrarInformacion(){
        System.out.println("Nombre del caballo:"+this.getNombre()+"\nEdad caballo"+this.getEdad());
        this.piloto.mostrarInformacion();
    }

}
