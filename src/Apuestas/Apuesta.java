package Apuestas;

import Entes.Caballo;
import Interfaces.Apostable;

import java.io.*;
import java.util.ArrayList;

public abstract class Apuesta implements Apostable {

    private ArrayList<Caballo> listaOrden;

    public ArrayList<Caballo> getListaOrden() {
        return listaOrden;
    }
    public Apuesta()
    {
        this.listaOrden=archivoBuffer();

    }
    public ArrayList<Caballo> archivoBuffer()
    {
        ArrayList<Caballo> aux= new ArrayList<>();
        try{
            File archivo = new File("C:\\Users\\Felip\\Desktop\\Prueba FINAL\\untitled\\caballos.txt");

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));

            ArrayList<Caballo> lista = (ArrayList<Caballo>) in.readObject();

            aux= lista;
            in.close();


        }catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return aux;
    }

    public void imprimirLista()
    {
        System.out.println("Lista de caballos");
        int i =1;
        for(Caballo ca: getListaOrden())
        {
            System.out.println(i + ":" +ca.toString());
            System.out.println("Prob Victoria: "+ ca.getProbabilidad());
            i++;
        }
    }

}
