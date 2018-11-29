package manage.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {
	private IntegerProperty course_id;
	private StringProperty name;
    private StringProperty teacher_id;
    private StringProperty teacherName;
    private IntegerProperty time;
    
    public Course() {
		this.course_id = new SimpleIntegerProperty(0);
		this.name = new SimpleStringProperty("");
		this.teacher_id = new SimpleStringProperty("");
		this.teacherName = new SimpleStringProperty("");
		this.time = new SimpleIntegerProperty(0);
	}
    
    public Course(int course_id, String name, String teacher_id, String teacherName, int time) {
		this.course_id = new SimpleIntegerProperty(course_id);
		this.name = new SimpleStringProperty(name);
		this.teacher_id = new SimpleStringProperty(teacher_id);
		this.teacherName = new SimpleStringProperty(teacherName);
		this.time = new SimpleIntegerProperty(time);
	}
    
	public IntegerProperty getCourse_id() {
		return course_id;
	}
	public void setStu_id(IntegerProperty course_id) {
		this.course_id = course_id;
	}
	
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	
	public StringProperty getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(StringProperty teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	public StringProperty getTeacherName() {
		return teacherName;
	}
	public void setteacher_id(StringProperty teacherName) {
		this.teacherName = teacherName;
	}
	
	public IntegerProperty getTime() {
		return time;
	}
	public void setTime(IntegerProperty time) {
		this.time = time;
	}
}