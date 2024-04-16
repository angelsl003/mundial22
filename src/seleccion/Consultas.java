package seleccion;

import ejemplos.singleton.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
    static java.sql.Connection con= DatabaseConnection.getInstance().getConnection();

    public static void codigosPaises(int pais) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = con.createStatement();
            resultSet = statement.executeQuery("select nombre_pais from paises p where p.cod_pais="+pais);
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

    public static void jugadoresPorPais (int pais){
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = con.createStatement();
            resultSet = statement.executeQuery("select nombre_jugador from jugadores j \n where cod_pais="+pais);
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

}
