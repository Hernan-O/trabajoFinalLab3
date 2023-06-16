import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int continuar = 0;
        while (continuar == 0) {
            try {
                Scanner teclado = new Scanner(System.in);

                System.out.println("Ingrese opcion:");
                System.out.println("1: JUGAR");
                System.out.println("2: SALIR");

                int op = teclado.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Opcion 1");
                        break;

                    case 2:
                        System.out.println("Opcion 2");
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
