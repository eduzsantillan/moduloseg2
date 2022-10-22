package pe.isil.moduloseguridad;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {


    public MysqlConnection(){
    }

    public Connection getConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/moduloseg2","root","budakar01");
    }

    public void closeConnection(Connection con) throws Exception{
        con.close();
    }
}
