package seleccion;

import ejemplos.singleton.DatabaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public java.sql.Connection con= DatabaseConnection.getInstance().getConnection();

    public static void main(String[] args) throws SQLException, IOException {


        int opcionUsuario = 0;
        Scanner miEscaner = new Scanner(System.in);

        while(opcionUsuario != -1){
            System.out.println("1) Consultar código de país");
            System.out.println("2) Consultar jugadores por código de país");
            System.out.println("3) Añadir registro de un nuevo jugador");
            System.out.println("4) Eliminar registro");
            System.out.println("5) Modificar registro");
            System.out.println("6) Importar jugadores desde un fichero");
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
                    System.out.println("¿De que país quieres obtener sus jugadores? Introduce su código");
                    codigoPaisUsr = miEscaner.nextInt();
                    Consultas.jugadoresPorPais(codigoPaisUsr);
                    break;
                case 3:
                    Registros.insertarJugador();
                    break;
                case 4:
                    Registros.quitarJugador();
                    break;
                case 5:
                    Registros.modificarJugador();
                    break;
                case 6:
                    ImportarJugadores.importarJugadores();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}