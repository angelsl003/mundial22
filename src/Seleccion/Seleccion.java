package Seleccion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ángel
 * @version 1.0
 */
public class Seleccion {
    /**
     * @param args
     * @throws IOException
     */
    /*public static void main(String[] args) throws IOException {
        Scanner esc=new Scanner(System.in);
        int opcion;
        String nombreArchivo="dinamarca.txt";
        File archivoOriginal=new File("./archivos/dinamarca.dat");
        File archivoExportado;
        Jugador eriksen=new Jugador(14,"Christiann Eriksen", 1992, 1.81F, "Manchester Unieted");
        Jugador schmeichel=new Jugador(14,"Kasper Schmeichel", 1986, 1.90F, "OGC Nice");
        Jugador kjaer=new Jugador(14,"Simon Kjaer", 1989, 1.91F, "Milan");
        Jugador braithwaite=new Jugador(14,"Martin Braithwaite", 1991, 1.80F, "Espanyol");
        Jugador kristensen=new Jugador(14,"Ramsus Kristensen", 1997, 1.87F, "Leeds United");
        Jugador hojbjerg=new Jugador(14,"Pierre-Emile Hojbjerg", 1995, 1.87F, "Tottenham Hotspur");
        Jugador poulsen=new Jugador(14,"Yussuf Yurary Poulsen", 1994, 1.93F, "RB Leipzig");
        ArrayList<Jugador> jugadores =new ArrayList<Jugador>();
        ArrayList<Jugador> extranjeros =new ArrayList<Jugador>();
        jugadores.add(eriksen);
        jugadores.add(schmeichel);
        jugadores.add(kjaer);
        jugadores.add(braithwaite);
        jugadores.add(kristensen);
        //jugadores.add(hojbjerg);
        //jugadores.add(poulsen);
        //Tamaño de cada jugaor: 4 + 16 + + 16 + 4 + 4 + 16= 12 + 75= 60 bytes
        System.out.println("¿Qué quieres hacer?");
        Jugador.menu();
        try{
            opcion= esc.nextInt();
        }catch (Exception e){
            System.out.println("ERROR. Se va a salir del programa");
            opcion=-1;
        }
        while(opcion!=-1){
            if (opcion<1||opcion>3){
                System.out.println("La opción seleccionada no está disponible. Escoge otra");
                Jugador.menu();
                try{
                    opcion= esc.nextInt();
                }catch (Exception e){
                    System.out.println("ERROR. Se va a salir del programa");
                    opcion=-1;
                }
            }else if(opcion==1){
                System.out.println("nombre del archivo?");
                nombreArchivo=esc.nextLine();
                nombreArchivo=esc.nextLine();
                archivoExportado=new File("archivos/"+nombreArchivo);
                Jugador.guardarJugadores(jugadores,archivoExportado);
                System.out.println("¿Qué más quieres hacer?");
                Jugador.menu();
                opcion= esc.nextInt();
            } else if (opcion==2) {
                System.out.println("¿Qué archivo quieres leer?");
                nombreArchivo= esc.next();
                archivoExportado=new File("./archivos/"+nombreArchivo);
                if(!archivoExportado.exists()){
                    System.out.println("El archivo no existe. Escribe otro.");
                } else if (!archivoExportado.canRead()) {
                    System.out.println("El archivo no se puede leer. Selecciona otro.");
                }else{
                    Jugador.mostrar(jugadores);
                    System.out.println("¿Qué más quieres hacer?");
                    Jugador.menu();
                    opcion= esc.nextInt();
                }
            } else if(opcion==3){
                Jugador.ordenar(jugadores);
                Jugador.mostrar(jugadores);
                System.out.println("¿Qué más quieres hacer?");
                Jugador.menu();
                opcion= esc.nextInt();
            }
        }
        System.out.println("Gracias por usar el programa");
    }*/
}
