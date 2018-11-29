package manage.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manage.model.Teacher;

public class TeacherDao {
	public int create(Connection con, Teacher tmp) throws SQLException {
        String sql = "INSERT INTO teacher VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pra = con.prepareStatement(sql);
        pra.setString(1, tmp.getTeacher_id().get());
        pra.setString(2, tmp.getName().get());
        pra.setString(3, tmp.getSex().get());
        pra.setString(4, tmp.getEducation().get());
        pra.setString(5, tmp.getAcademic().get());
        pra.setString(6, tmp.getAge().get() + "");
        pra.setString(7, tmp.getTel().get());
        int resultNum = pra.executeUpdate();
        pra.close();
        return resultNum;
    }
	
	public boolean delete(Connection con, String id) throws SQLException {
		String sql = "DELETE FROM teacher WHERE teacher_id = ?";
		PreparedStatement pra = con.prepareStatement(sql);
        pra.setString(1, id);
        boolean flag = pra.execute();
        pra.close();
        return flag;
	}
	
	public int update(Connection con, Teacher tmp) throws SQLException {
		String sql = "UPDATE teacher SET teacher.`name` = ?, `sex` = ?, `education` = ?, `academic` = ?, `age` = ?, `tel` = ? WHERE teacher_id = ?;";
		PreparedStatement pra = con.prepareStatement(sql);
        pra.setString(1, tmp.getName().get());
        pra.setString(2, tmp.getSex().get());
        pra.setString(3, tmp.getEducation().get());
        pra.setString(4, tmp.getAcademic().get());
        pra.setInt(5, tmp.getAge().get());
        pra.setString(6, tmp.getTel().get());
        pra.setString(7, tmp.getTeacher_id().get());
        int rows = pra.executeUpdate();
        pra.close();
        return rows;
	}
	
	public ArrayList<Teacher> query(Connection con, String string) throws SQLException {
		ArrayList<Teacher> teacher = new ArrayList<Teacher>();
		String sql = "SELECT * FROM teacher WHERE teacher.teacher_id LIKE ? ORDER BY teacher.teacher_id ASC";
		PreparedStatement pra = con.prepareStatement(sql);
		if (string.equals("*")) string = "%";
		pra.setString(1, string);
		ResultSet rs = pra.executeQuery();
		while(rs.next()){
            String teacher_id = rs.getString("teacher_id");
            String name = rs.getString("name");
            String sex = rs.getString("sex");
            String education = rs.getString("education");
            String academic = rs.getString("academic");
            int age = Integer.valueOf(rs.getString("age"));
            String tel = rs.getString("tel");
            Teacher tmp = new Teacher(teacher_id, name, sex, education, academic, age, tel);
            teacher.add(tmp);
        }
        rs.close();
		return teacher;
	}
}
