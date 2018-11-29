package manage.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manage.model.Grade;

public class GradeDao {
	public int create(Connection con,Grade tmp) throws SQLException {
        String sql = "INSERT INTO `final`.`grade`(`course_id`, `student_id`, `garde`) VALUES (?, ?, ?)";
        PreparedStatement pra = con.prepareStatement(sql);
        pra.setInt(1, tmp.getCourse_id().get());
        pra.setString(2, tmp.getStudent_id().get());
        pra.setInt(3, tmp.getGrade().get());
        int resultNum = pra.executeUpdate();
        pra.close();
        return resultNum;
    }
	
	public boolean delete(Connection con, String id) throws SQLException {
		String sql = "DELETE FROM grade WHERE grade_id = ?";
		PreparedStatement pra = con.prepareStatement(sql);
        pra.setString(1, id);
        boolean flag = pra.execute();
        pra.close();
        return flag;
	}
	
	public int update(Connection con, Grade tmp) throws SQLException {
		String sql = "UPDATE `final`.`grade` SET `course_id` = ?, `student_id` = ?, `garde` = ? WHERE `grade_id` = ?";
		PreparedStatement pra = con.prepareStatement(sql);
        pra.setInt(1, tmp.getCourse_id().get());
        pra.setString(2, tmp.getStudent_id().get());
        pra.setInt(3, tmp.getGrade().get());
        pra.setInt(4, tmp.getGrade_id().get());
        int rows = pra.executeUpdate();
        pra.close();
        return rows;
	}
	
	public ArrayList<Grade> query(Connection con, String string) throws SQLException {
		ArrayList<Grade> grades = new ArrayList<Grade>();
		String sql = "SELECT grade.grade_id, grade.course_id, course.`name` AS course_name, grade.student_id, student.`name` AS student_name, grade.garde AS grade1 FROM grade, course, student WHERE grade.course_id = course.course_id AND grade.student_id = student.stu_id  AND grade.grade_id LIKE ? ORDER BY grade_id ASC";
		PreparedStatement pra = con.prepareStatement(sql);
		if (string.equals("*")) string = "%";
		pra.setString(1, string);
		ResultSet rs = pra.executeQuery();
		while(rs.next()){
            int grade_id = rs.getInt("grade_id");
            int course_id = rs.getInt("course_id");
            String course_name = rs.getString("course_name");
            String student_id = rs.getString("student_id");
            String student_name = rs.getString("student_name");
            int grade = rs.getInt("grade1");
            Grade tmp = new Grade(grade_id, course_id, course_name, student_id, student_name, grade);
            grades.add(tmp);
        }
        rs.close();
		return grades;
	}
}
