package manage.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manage.model.Course;

public class CourseDao {
	public int create(Connection con, Course tmp) throws SQLException {
        String sql = "INSERT INTO `final`.`course`(`name`, `teacher_id`, `time`) VALUES (?, ?, ?)";
        PreparedStatement pra = con.prepareStatement(sql);
        pra.setString(1, tmp.getName().get());
        pra.setString(2, tmp.getTeacher_id().get());
        pra.setInt(3, tmp.getTime().get());
        int resultNum = pra.executeUpdate();
        pra.close();
        return resultNum;
    }
	
	public boolean delete(Connection con, String string) throws SQLException {
		String sql = "DELETE FROM course WHERE course_id = ?";
		int id = Integer.parseInt(string);
		PreparedStatement pra = con.prepareStatement(sql);
        pra.setInt(1, id);
        boolean flag = pra.execute();
        pra.close();
        return flag;
	}
	
	public int update(Connection con, Course tmp) throws SQLException {
		String sql = "UPDATE `final`.`course` SET `name` = ?, `teacher_id` = ?, `time` = ? WHERE `course_id` = ?";
		PreparedStatement pra = con.prepareStatement(sql);
		pra.setString(1, tmp.getName().get());
        pra.setString(2, tmp.getTeacher_id().get());
        pra.setInt(3, tmp.getTime().get());
        pra.setInt(4, tmp.getCourse_id().get());
        int rows = pra.executeUpdate();
        pra.close();
        return rows;
	}
	
	public ArrayList<Course> query(Connection con, String string) throws SQLException {
		ArrayList<Course> course = new ArrayList<Course>();
		String sql = "SELECT course.course_id, course.`name`, course.teacher_id, course.time, teacher.`name` AS teacherName FROM course , teacher WHERE course.course_id LIKE ? AND course.teacher_id = teacher.teacher_id ORDER BY course.course_id ASC";
		PreparedStatement pra = con.prepareStatement(sql);
		if (string.equals("*")) string = "%";
		pra.setString(1, string);
		ResultSet rs = pra.executeQuery();
		while(rs.next()){
            int course_id = Integer.valueOf(rs.getString("course_id"));
            String name = rs.getString("name");
            String teacher_id = rs.getString("teacher_id");
            String teacherName = rs.getString("teacherName");
            int time = Integer.valueOf(rs.getString("time"));
            Course tmp = new Course(course_id, name, teacher_id, teacherName, time);
            course.add(tmp);
        }
        rs.close();
		return course;
	}
}
