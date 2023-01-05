package utils;
import java.util.Scanner;
public class ControlDatos {

    public static int controlErrorsint(String mensaje) {
        Scanner input = new Scanner(System.in);

        boolean tipoCorrecto;
        int retorno = 0;

        do {
            System.out.println(mensaje);
            System.out.println();
            tipoCorrecto = input.hasNextInt();
            if (!tipoCorrecto) {
                System.out.println("Has introducido un valor no numérico");
                input.nextLine();
            } else {
                retorno = input.nextInt();
                input.nextLine();
            }
            if (retorno < 1 || retorno > 9){
                System.out.println("ERROR: Valor fora de rang.");
                tipoCorrecto = false;
            }
        } while (!tipoCorrecto);
        return retorno;
    }
}
