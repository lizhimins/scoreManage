package manage.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
	// �����û�������������
	public String query(Connection con, String string) throws SQLException {
		String password = "";
		String sql = "SELECT admin.`password` FROM admin WHERE admin.users = ?";
		PreparedStatement pra = con.prepareStatement(sql);
		pra.setString(1, string);
		ResultSet rs = pra.executeQuery();
		while(rs.next()){
            password = rs.getString("password");
        }
        rs.close();
		return password;
	}
}
