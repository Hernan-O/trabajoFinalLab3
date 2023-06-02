package clases;

import java.util.ArrayList;

public abstract class Carrera {
    private String nombreCarrera;
    private ArrayList<Caballo> caballoList = new ArrayList<>();
    private String dificultad;

    public Carrera(){}
    public Carrera(String nombreCarrera, ArrayList<Caballo> caballoList, String dificultad) {
        this.nombreCarrera = nombreCarrera;
        this.caballoList = caballoList;
        this.dificultad = dificultad;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public ArrayList<Caballo> getCaballoList() {
        return caballoList;
    }

    public void setCaballoList(ArrayList<Caballo> caballoList) {
        this.caballoList = caballoList;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

}
