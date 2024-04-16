package seleccion;

import ejemplos.singleton.DatabaseConnection;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportarJugadores {
    static java.sql.Connection con= DatabaseConnection.getInstance().getConnection();

    public static void importarJugadores() throws IOException, SQLException {
        Statement statement = null;
        String sql="";
        try{
            statement = con.createStatement();
            String nombreArchivo;
            Scanner miEscaner = new Scanner(System.in);
            System.out.println("¿Cómo se llama el archivo?");
            nombreArchivo = miEscaner.nextLine();
            File file=new File("archivos/"+ nombreArchivo );
            while (!file.exists()){
                System.out.println("Ese fichero no existe");
                nombreArchivo = miEscaner.nextLine();
                file=new File("archivos/"+ nombreArchivo );
            }
            ArrayList<Jugador> jugadores =Jugador.leerJugadores(file);
            for(Jugador jugador : jugadores){
                sql="insert into jugadores (cod_pais, nombre_jugador, year_nacimiento, altura_cm, club) values ("+jugador.codPais+", '"+jugador.nomJugador.trim()+"', "+jugador.yearNacimiento+", "+jugador.altura+", '"+jugador.club.trim()+"')";
                statement.executeUpdate(sql);
            }
        } catch (java.sql.SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
	}
}
