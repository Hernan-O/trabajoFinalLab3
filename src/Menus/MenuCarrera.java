package Menus;

import Apuestas.Saldo;
import Carreras.Carrera;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCarrera {

    private Saldo cuentaUser = new Saldo(20000);//Arranca con 20k para probár, se puede poner como archivo para guardar la plata total.
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
        desplegarMenu();
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
        int continuar = 0;
        while (continuar == 0) {
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
                        MenuApuesta siguiente0 = new MenuApuesta(getCarreras().get(0));
                        this.cuentaUser = siguiente0.getCuentaUser();
                        break;
                    case 2:
                        MenuApuesta siguiente1 = new MenuApuesta(getCarreras().get(1));
                        break;
                    case 3:
                        MenuApuesta siguiente2 = new MenuApuesta(getCarreras().get(2));
                        break;
                    case 4:
                        System.out.println("Fin juego");
                        System.exit(0);
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
