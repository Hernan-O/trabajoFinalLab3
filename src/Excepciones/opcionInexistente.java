package Excepciones;
import java.io.Serializable;
import java.lang.Exception;
public class opcionInexistente extends Exception implements Serializable{

    public opcionInexistente()
    {
        System.out.println("Opcio inexistente");
    }
}
