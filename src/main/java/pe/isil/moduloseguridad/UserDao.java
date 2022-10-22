package pe.isil.moduloseguridad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public String loginUser(String username, String pass) throws Exception{

        MysqlConnection mysqlConnection = new MysqlConnection();
        Connection con = mysqlConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from users where username = '"+username+"' and pass = '"+pass+"'");
        if(rs.next()) {
            return rs.getString("name");
        }else{
            return "";
        }
    }

    public List<User> getall() throws Exception{
        MysqlConnection mysqlConnection = new MysqlConnection();
        Connection con = mysqlConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from users");
        List<User> userList = new ArrayList<>();

        while(rs.next()){

            User user = new User();
            user.setId(Integer.parseInt(rs.getString("id")));
            user.setName(rs.getString("name"));
            user.setLastname(rs.getString("lastname"));
            user.setUsername(rs.getString("username"));
            user.setNroDoc(rs.getString("nroDoc"));
            user.setEnable(Integer.parseInt(rs.getString("enable")));
            userList.add(user);
        }
        return userList;
    }


}
