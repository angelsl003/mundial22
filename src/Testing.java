import Ejemplos.Singleton.DatabaseConnection;
import Seleccion.Consultas;

import java.sql.*;
public class Testing {
    static java.sql.Connection con=DatabaseConnection.getInstance().getConnection();
    public Testing(){

    }
    public static void createTable() throws SQLException{
        Statement statement = con.createStatement();
        statement.executeUpdate("create table t1 (c1 varchar(50))");
        statement.close();
    }
    public static void deleteTable() throws SQLException{
        Statement statement = con.createStatement();
        statement.executeUpdate("drop table t1");
        statement.close();
    }

    public static void getAllPlayers() throws SQLException{
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = con.createStatement();
            resultSet = statement.executeQuery("Select * from jugadores");
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

    public static void main(String[] args) throws SQLException {
        Consultas.codigosPaises(12);
    }
}
