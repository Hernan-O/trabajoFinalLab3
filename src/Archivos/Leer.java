package Archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Leer<T> {
	FileInputStream file;
	ObjectInputStream input;
	
	public void abrir(String nombreArchivo) throws IOException{
		file = new FileInputStream(nombreArchivo+".txt");
		input = new ObjectInputStream(file);
	}
	
	public void cerrar() throws IOException{
		if(input != null) {
			input.close();
		}
	}
	
	public Object leer() throws IOException, ClassNotFoundException{
		Object o = null;
		if(input != null) {
			try {
				o = (Object)input.readObject();
			}catch(EOFException EOFE) {
				
			}
		}
		return o;
	}
}
