package Seleccion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CargarJugadores {

    private static void cargarJugadores() throws IOException{
        String nombreArchivo;
        Scanner miEscaner = new Scanner(System.in);
        System.out.println("¿Cómo se llama el archivo");
        nombreArchivo = miEscaner.nextLine();

        File file=new File("archivos/"+ nombreArchivo );
        ArrayList<Jugador> jugadores =Jugador.leerJugadores(file);
        for(Jugador jugador : jugadores){
            System.out.print(jugador.codPais);
            System.out.print(jugador.nomJugador);
            System.out.print(jugador.yearNacimiento);
            System.out.print(jugador.altura);
            System.out.println(jugador.club);
        }
    }
}
