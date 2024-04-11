package Seleccion;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Ángel
 * @version 1.0
 */
public class Jugador {
    /**
     *
     * @param codPais
     * @param nomJugador
     * @param yearNacimiento
     * @param altura
     * @param club
     */
    public Jugador(int codPais, String nomJugador, int yearNacimiento, float altura, String club){
        this.codPais=codPais;
        this.nomJugador=nomJugador;
        this.yearNacimiento=yearNacimiento;
        this.altura=altura;
        this.club=club;
    }
    public int codPais;
    public String nomJugador;
    public int yearNacimiento;
    public float altura;
    public String club;

    /**
     * El menú
     */
    public static void menu(){
        System.out.println("1:Guardar los jugadores en un fichero");
        System.out.println("2:Ordenar y mostrar los jugadores de un fichero");
        System.out.println("-1:Salir del programa");
    }

    /**
     *
     * @param jugadores
     * @param archivo
     * @throws IOException
     */
    public static void guardarJugadores(ArrayList<Jugador> jugadores, File archivo) throws IOException {
        DataOutputStream guardar=new DataOutputStream(new FileOutputStream(archivo));
        try{
            for(int i=0;i<jugadores.size();i++){
                guardar.writeInt(jugadores.get(i).codPais);
                String player= jugadores.get(i).nomJugador;
                if(player.length()<25){
                    player=ponerEspacios(player);
                }
                guardar.writeChars(player);
                guardar.writeInt(jugadores.get(i).yearNacimiento);
                guardar.writeFloat(jugadores.get(i).altura);
                String club= jugadores.get(i).club;
                if(club.length()<25){
                    club=ponerEspacios(club);
                }
                guardar.writeChars(club);
            }
        }catch (Exception e){
            System.out.println("Algún dato introducido no es correcto!!!");
        }finally {
            guardar.close();
        }
    }

    /**
     *
     * @param archivo
     * @return
     * @throws IOException
     *
     */
    public static ArrayList<Jugador> leerJugadores(File archivo) throws IOException {
        DataInputStream leer=new DataInputStream(new FileInputStream(archivo));
        char [] caracteres=new char[25];
        ArrayList<Jugador> players= new ArrayList<Jugador>();
        try{
            for(int i=0; i<archivo.length();i+=137){
                Jugador real =new Jugador (0,"",0,0F, "");
                real.codPais=leer.readInt();
                for(int j=0;j<25;j++){
                    caracteres[j]=leer.readChar();
                }
                real.nomJugador=new String(caracteres);
                real.yearNacimiento=leer.readInt();;
                real.altura=leer.readFloat();
                for(int j=0;j<25;j++){
                    caracteres[j]=leer.readChar();
                }
                real.club=new String(caracteres);
                players.add(real);
            }
        }catch (Exception e){
            System.out.println("Ha sucedido un error con el tipo de datos");
        }finally {
            leer.close();
        }
        return players;
    }

    /**
     *
     * @param jugadores
     */
    public static void ordenar(ArrayList<Jugador> jugadores){
        int numJugadores = jugadores.size();
        Jugador temp;
        for(int i=0; i < numJugadores; i++){
            for(int j=1; j < (numJugadores-i); j++){
                if(jugadores.get(j-1).yearNacimiento > jugadores.get(j).yearNacimiento){
                    //swap elements
                    temp = jugadores.get(j-1);
                    jugadores.set(j-1, jugadores.get(j));
                    jugadores.set(j,temp);
                }
            }
        }
    }

    /**
     *
     * @param jugadores
     */
    public static void mostrar(ArrayList<Jugador> jugadores){
        System.out.println("Código del país\t\tNombre del jugador\t\tAño de nacimiento\t\tAltura\t\tClub");
        for(int i=0;i<jugadores.size();i++){
            System.out.print("\t"+jugadores.get(i).codPais+"\t\t\t");
            System.out.print(jugadores.get(i).nomJugador+"\t\t");
            System.out.print(jugadores.get(i).yearNacimiento+"\t\t");
            System.out.print(jugadores.get(i).altura+"\t\t");
            System.out.print(jugadores.get(i).club+"\t\t");
            System.out.println();
        }
    }

    public static void comprobarExiste(File archivo, String nombre){
        archivo=new File("./archivo/"+nombre);
        while(!archivo.exists()){
            System.out.println("El archivo que buscas no existe. Seleccione otro");
        }
    }
    public static String ponerEspacios(String nombre){
        while (nombre.length()<25){
            nombre+=" ";
        }
        return nombre;
    }
}
