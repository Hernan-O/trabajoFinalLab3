package genericos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaGenerica<T> implements Iterable<T>, Serializable{
   
	private static final long serialVersionUID = -7058970356820460117L;
	private List<T> elementos;

    public ListaGenerica() {
        elementos = new ArrayList<>();
    }

    public void agregar(T valor) {
        elementos.add(valor);
    }
    
    public void agregar(int indice, T valor) {
        elementos.add(indice, valor);
    }
    
    public void contiene(T valor)
    {
    	elementos.contains(valor);
    	
    }
    
    public T get(int indice)
    {
    	return elementos.get(indice);
    	
    }
    
    public void eliminar(int indice)
    {
    	elementos.remove(indice);
    }
    
    public int size()
    {
    	return elementos.size();
    }
    
    public ArrayList<T> listaEntera(){
    	return (ArrayList<T>) elementos;
    }

    
    @Override
    public Iterator<T> iterator() {
        return elementos.iterator();
    }

    
}