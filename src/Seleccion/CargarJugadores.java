package Seleccion;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CargarJugadores {
    public CargarJugadores(){

    }

    public static void main(String[] args) throws IOException {
        File file=new File("archivos/dinamarca.dat");
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
