package clases;

public class Caballo {
    private int edad;
    private String nombre;
    private Jockey piloto;
    private String raza;

    public Caballo(int edad,String nombre,Jockey piloto){
        this.edad = edad;
        this.nombre = nombre;
        this.piloto = piloto;
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
   public void mostrarInformacion(){
        System.out.println("Nombre del caballo:"+this.getNombre()+"\nEdad caballo"+this.getEdad());
        this.piloto.mostrarInformacion();
    }
    

}
