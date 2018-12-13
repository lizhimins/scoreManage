package manage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	String dbUrl = "jdbc:mysql://47.100.14.134:3306/zstu?useUnicode=true&characterEncoding=UTF-8";
    String dbUser = "root";
    String dbPass = "123456";
    String driveName = "com.mysql.jdbc.Driver";
    
    public Connection getCon()throws Exception {
        Class.forName(driveName);
        Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
        return con;
    }
    
    public void closeCon(Connection con) {
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}