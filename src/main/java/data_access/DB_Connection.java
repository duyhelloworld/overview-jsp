package data_access;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
    
    public static Connection getConnection() {
        String DB_name = "WebServlet";
        String url = "jdbc:mysql://localhost:3306/" + DB_name;
        String usr = "duyaiti";
        String pwd = "12345678";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usr, pwd);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static boolean isConnected(Connection conn) {
        if (conn == null) {
            return false;
        }
        System.out.println("Connect Success");
        return true;
    }
}
