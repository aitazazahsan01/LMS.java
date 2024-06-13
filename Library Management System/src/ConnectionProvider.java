import java.sql.*;

public class ConnectionProvider {
    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql6492450", "root", "mcsnust123");
            return con;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }

}
