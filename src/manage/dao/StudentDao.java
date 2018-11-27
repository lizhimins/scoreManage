package manage.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manage.model.Student;

public class StudentDao {
	public int create(Connection con,Student stu) throws SQLException {
        String sql = "INSERT INTO 'student'('stu_id', 'name', 'sex', 'stu_class', 'stu_dept', 'age', 'tel') "
        		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pra = con.prepareStatement(sql);
        pra.setString(1, stu.getStu_id().get());
        pra.setString(2, stu.getName().get());
        pra.setString(3, stu.getSex().get());
        pra.setString(4, stu.getStu_class().get());
        pra.setString(5, stu.getStu_dept().get());
        pra.setString(6, stu.getAge().get() + "");
        pra.setString(7, stu.getTel().get());
        int resultNum = pra.executeUpdate();
        pra.close();
        return resultNum;
    }
	
	public int delete(Connection con, String id) throws SQLException {
		String sql = "DELETE FROM 'final'.'student' WHERE 'stu_id' = ?";
		PreparedStatement pra = con.prepareStatement(sql);
        pra.setString(1, id.toString());
        int resultNum = pra.executeUpdate();
        pra.close();
        return resultNum;
	}
	
	public int update(Connection con, String id, Student stu) throws SQLException {
		String sql = "UPDATE 'student' SET 'name' = ?, 'sex' = ?, 'stu_class' = ?, 'stu_dept' = ?,"
				+ " 'age' = ?, 'tel' = ? WHERE 'stu_id' = ?";
		PreparedStatement pra = con.prepareStatement(sql);
        pra.setString(1, stu.getStu_id().get());
        pra.setString(2, stu.getName().get());
        pra.setString(3, stu.getSex().get());
        pra.setString(4, stu.getStu_class().get());
        pra.setString(5, stu.getStu_dept().get());
        pra.setString(6, stu.getAge().get() + "");
        pra.setString(7, stu.getTel().get());
        pra.setString(8, id.toString());
        int resultNum = pra.executeUpdate();
        pra.close();
        return resultNum;
	}
	
	public ArrayList<Student> query(Connection con, String string) throws SQLException {
		ArrayList<Student> student = new ArrayList<Student>();
		String sql = "SELECT * FROM student WHERE student.stu_id LIKE ? ORDER BY student.stu_id ASC";
		PreparedStatement pra = con.prepareStatement(sql);
		if (string.equals("*")) string = "%";
		pra.setString(1, string);
		ResultSet rs = pra.executeQuery();
		while(rs.next()){
            String stu_id = rs.getString("stu_id");
            String name = rs.getString("name");
            String sex = rs.getString("sex");
            String stu_class = rs.getString("stu_class");
            String stu_dept = rs.getString("stu_dept");
            int age = Integer.valueOf(rs.getString("age"));
            String tel = rs.getString("tel");
            Student tmp = new Student(stu_id, name, sex, stu_class, stu_dept, age, tel);
            student.add(tmp);
        }
        rs.close();
		return student;
	}
}
