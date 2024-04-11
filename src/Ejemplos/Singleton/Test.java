package Ejemplos.Singleton;

public class Test
{
    //static java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
    public static java.sql.Connection con;
    public Test(){
        //con = DatabaseConnection.getInstance().getConnection();

    }
    public Test(String url, String user, String password){
        con = DBConnection.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        // Comprobamos el funcionamiento de Connection::close() para una conexión no establecida
        Test myTest1 = new Test("jdbc:mysql://localhost/mundialAngel" , "angelTest", "1234");
        try {
            Test.con.close();
        }catch(Exception e){
            System.out.println("Error forzado de usuario");
        }
        // Establecemos conexión correcta y comprobamos efecto singleton
        Test myTest2 = new Test("jdbc:mysql://192.168.201.112:33060/mundial22", "dora123", "dora123");
        myTest1 = new Test("jdbc:mysql://192.168.201.112:33060/mundial22", "dora123", "dora123");
        // Cerramos conexión y comprobamos reconexión
        try {
            Test.con.close();
            System.out.println("Conexion cerrada");
        }catch(Exception e){
            System.out.println("E1");
        }
        Test myTest3 = new Test("jdbc:mysql://192.168.201.112:33060/mundial22", "dora123", "dora123");
        // Conexión con clase alternativa. Se crea otra conexión al ser otro tipo de clase.
        myTest1 = new Test();
    }
}

