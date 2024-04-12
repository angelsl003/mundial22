package Seleccion;

import Ejemplos.Singleton.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Registros {
	static java.sql.Connection con= DatabaseConnection.getInstance().getConnection();
	static Scanner esc=new Scanner(System.in);
	static String[] elementosJugador={/*introducir los elementos*/};
	public Registros(){

	}
	public static String[] pedirDatos(){
		String[] datos=new String[5];
		String dato="";
		for(int i=0;i< datos.length;i++){
			System.out.println("introduce");
			dato=esc.nextLine();
			datos[i]=dato;
		}
		return datos;
	}

	public static void insertarJugador() throws SQLException {
		Statement statement = null;
		String sql="";
		try{
			String[] datos=pedirDatos();
			statement = con.createStatement();
			int pais= Integer.parseInt(datos[0]);
			String nombre=datos[1];
			int year= Integer.parseInt(datos[2]);
			int altura= Integer.parseInt(datos[3]);
			String equipo=datos[4];
			sql="insert into jugadores (cod_pais, nombre_jugador, year_nacimiento, altura_cm, club) values "+pais+", "+nombre+", "+year+", "+altura+", "+equipo+")";
			statement.executeUpdate(sql);
		}catch (SQLException e){
			System.out.println("Error "+e.getMessage());
		}finally {
			try{
				if(statement!=null && !statement.isClosed()){
					statement.close();
				}
			}catch (java.sql.SQLException ex){
				System.out.println("Error "+ex.getMessage());
			}
			try {
				if(con!=null && !con.isClosed()){
					con.close();
				}
			}catch (java.sql.SQLException ex){
				System.out.println("Error "+ex.getMessage());
			}
		}
	}

	public static void quitarJugador() throws SQLException {
		Statement statement = null;
		String sql = "";
		String jugador = "";
		try {
			System.out.println("quitar jugador");
			jugador = esc.nextLine();
			sql = "delete from jugadores where nombre_jugador = " + jugador;
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Error " + e.getMessage());
		} finally {
			try {
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}
			} catch (java.sql.SQLException ex) {
				System.out.println("Error " + ex.getMessage());
			}
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (java.sql.SQLException ex) {
				System.out.println("Error " + ex.getMessage());
			}
		}
	}
	public static void modificarJugador() throws SQLException {
		Statement statement = null;
		String sql="";
		String jugador="";
		int elemento=0;
		String modificacion="";
		try{
			System.out.println("modificar jugador");
			jugador= esc.nextLine();
			System.out.println("que quieres cambiar?");
			elemento=esc.nextInt();
			while(elemento<1||elemento>5){
				System.out.println("no disponible");
				elemento= esc.nextInt();
			}
			sql="update jugadores set "+elementosJugador[elemento-1]+" where nombre_jugador=" +jugador;
			statement.executeUpdate(sql);
		}catch (SQLException e){
			System.out.println("Error "+e.getMessage());
		}finally {
			try{
				if(statement!=null && !statement.isClosed()){
					statement.close();
				}
			}catch (java.sql.SQLException ex){
				System.out.println("Error "+ex.getMessage());
			}
			try {
				if(con!=null && !con.isClosed()){
					con.close();
				}
			}catch (java.sql.SQLException ex){
				System.out.println("Error "+ex.getMessage());
			}
		}
	}

	public static void main(String[] args) {

	}
}
