package Archivos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Escribir {
	private FileOutputStream file;
	private ObjectOutputStream output;
	
	public void abrir(String nombreArchivo) throws IOException{
		file = new FileOutputStream(nombreArchivo+".txt");
		output = new ObjectOutputStream(file);
	}
	
	public void cerrar() throws IOException {
		if(output != null) {
			output.close();
		}
	}
	
	public void escribir(Object o)throws IOException{
		if(output != null) {
			output.writeObject(o);
		}
	}
}
