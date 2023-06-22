package Menus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Apuestas.Saldo;
import Archivos.Escribir;
import Archivos.Leer;
import Carreras.Carrera;

public class MenuCarrera {

    private Saldo cuentaUser;
    private ArrayList<Carrera> carreras;

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public MenuCarrera()
    {
        this.carreras=crearCarreras();
        this.cuentaUser=archivoBufferSaldo();
        desplegarMenu();
    }

    public Saldo getCuentaUser() {
        return cuentaUser;
    }

    public Saldo archivoBufferSaldo()
    {
        Saldo saldo= new Saldo();
        Leer<Object> leer = new Leer<Object>();
        
        try {
			leer.abrir("saldo");
	        saldo = (Saldo) leer.leer();
	        leer.cerrar();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        return saldo;
    }

    public void bufferArchivoSaldo()
    {
           Escribir escribir = new Escribir();
           try {
			escribir.abrir("saldo");
			escribir.escribir(getCuentaUser());
	        escribir.cerrar();
		} catch (IOException e) {
			e.printStackTrace();
		}
           
    }

    public ArrayList<Carrera> crearCarreras()
    {
        ArrayList<Carrera> retorno = new ArrayList<>();

        Carrera campo_traviesa = new Carrera(0);
        Carrera lisa = new Carrera(1);
        Carrera obstaculos = new Carrera(2);

        retorno.add(campo_traviesa);
        retorno.add(lisa);
        retorno.add(obstaculos);

        return retorno;
    }

    public void desplegarMenu()
    {
        boolean continuar = true;
        while (continuar) {
            try {

                Scanner in = new Scanner(System.in);
                System.out.println("Ingrese opcion:");
                System.out.println("1: Campo_Traviesa");
                System.out.println("2: Obstaculos");
                System.out.println("3: Lisa");
                System.out.println("4: Atras");

                int op = in.nextInt();
                in.nextLine();
                switch (op) {
                    case 1:
                        MenuApuesta siguiente0 = new MenuApuesta(getCarreras().get(0), getCuentaUser());
                        break;
                    case 2:
                        MenuApuesta siguiente1 = new MenuApuesta(getCarreras().get(1),getCuentaUser());
                        break;
                    case 3:
                        MenuApuesta siguiente2 = new MenuApuesta(getCarreras().get(2), getCuentaUser());
                        break;
                    case 4:
                        bufferArchivoSaldo();
                        continuar= false;
                        break;

                    default:
                        System.out.println("Ingrese una opcion correcta.");
                        break;
                }

            } catch (InputMismatchException e) {
                //System.out.println(e.getMessage());
                //e.printStackTrace();
                System.out.println("Ingrese una opcion correcta");
            }
        }



    }

}
