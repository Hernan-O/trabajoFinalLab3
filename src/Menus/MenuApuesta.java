package Menus;
import Apuestas.*;
import Carreras.Carrera;
import Excepciones.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuApuesta {

    private ArrayList<Apuesta> apuestas;
    private Carrera tipo;

    public MenuApuesta(Carrera dat)
    {
        this.apuestas=crearApuesta();
        desplegarMenu();
    }

    public ArrayList<Apuesta> crearApuesta()
    {
        ArrayList<Apuesta> retorno = new ArrayList<>();
        Apuesta exacta = new Exacta();

        retorno.add(exacta);

        return retorno;
    }


    public void desplegarMenu()
    {
        int continuar = 0;
        while (continuar == 0) {
            try {

                Scanner in = new Scanner(System.in);
                System.out.println("Ingrese opcion:");
                System.out.println("1: Exacta");
                System.out.println("2: Trifecta");
                System.out.println("3: Imperfecta");
                System.out.println("4: ATRAS");

                int op = in.nextInt();

                switch (op) {
                    case 1:
                           Exacta siguiente0 = new Exacta();
                           siguiente0.desplegarMenu();
                        break;
                    case 2:
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
            }catch (opcionInexistente e)
            {
                System.out.println("Opcio Inexistente");
            }
        }

    }


}
