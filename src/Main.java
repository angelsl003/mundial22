import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //usuario:angel123
        //pass:1234

        int opcionUsuario = 0;
        Scanner miEscaner = new Scanner(System.in);

        while(opcionUsuario != -1){
            System.out.println("1) Consultar código de país");
            System.out.println("2) Consultar jugadores por código de país");
            System.out.println("\n Elige una opción. Introduce -1 para salir");
            opcionUsuario = miEscaner.nextInt();

            switch(opcionUsuario){
                case -1:
                    break;
                case 1:
                    System.out.println("¿Cuál es el código de país que quieres consultar?");
                    int codigoPaisUsr = miEscaner.nextInt();
                    Consultas.codigosPaises(codigoPaisUsr);
                default:
                    System.out.println("Opción no válida");
            }
        }

    }
}