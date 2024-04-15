package seleccion;

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
            System.out.println("3) Añadir registro de un nuevo jugador");
            System.out.println("4) Eliminar registro");
            System.out.println("5) Modificar registro");
            System.out.println("6) Importar jugadores desde un fichero")
            System.out.println("\n Elige una opción. Introduce -1 para salir");
            opcionUsuario = miEscaner.nextInt();
            int codigoPaisUsr;

            switch(opcionUsuario){
                case -1:
                    break;
                case 1:
                    System.out.println("¿Cuál es el código de país que quieres consultar?");
                    codigoPaisUsr = miEscaner.nextInt();
                    Consultas.codigosPaises(codigoPaisUsr);
                    break;
                case 2:
                    codigoPaisUsr = miEscaner.nextInt();
                    Consultas.jugadoresPorPais();
                    break;
                case 3:
                    Registros.insertarJugador();
                    break;
                case 4:
                    Registros.quitarJugador();
                    break;
                case 5:
                    
                case 6:
                    ImportarJugadores.importarJugadores();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

    }
}