package Interfaces;

import Entes.Caballo;
import Entes.ListaGenerica;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface Apostable extends Serializable{

    public ListaGenerica<Caballo> ordenar();

}
