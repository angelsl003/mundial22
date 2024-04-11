import Ejemplos.Singleton.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Registros {
	static java.sql.Connection con= DatabaseConnection.getInstance().getConnection();
	static Scanner esc=new Scanner(System.in);
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
		ResultSet resultSet = null;
		try{
			String[] datos=pedirDatos();
			statement = con.createStatement();
			int pais= Integer.parseInt(datos[0]);
			String nombre=datos[1];
			int year= Integer.parseInt(datos[2]);
			int altura= Integer.parseInt(datos[3]);
			String equipo=datos[4];
			resultSet = statement.executeQuery("insert into jugadores (cod_pais, nombre_jugador, year_nacimiento, altura_cm, club) values" +
					"(");
			while (resultSet.next()){
				System.out.println(resultSet.getString(1));
			}
		}catch (SQLException e){
			System.out.println("Error "+e.getMessage());
		}finally {
			try{
				if(statement!=null){
					statement.close();
				}
			}catch (java.sql.SQLException ex){
				System.out.println("Error "+ex.getMessage());
			}
			try {
				if(resultSet!=null){
					resultSet.close();
				}
			}catch (java.sql.SQLException ex){
				System.out.println("Error "+ex.getMessage());
			}
		}
	}

	public static void main(String[] args) {

	}
}
