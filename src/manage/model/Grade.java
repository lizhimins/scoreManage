package manage.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Grade {
	private IntegerProperty grade_id;
	private IntegerProperty course_id;
    private StringProperty course_name;
    private StringProperty student_id;
    private StringProperty student_name;
    private IntegerProperty grade;
    
    public Grade() {
		this.grade_id = new SimpleIntegerProperty(0);
		this.course_id = new SimpleIntegerProperty(0);
		this.course_name = new SimpleStringProperty("");
		this.student_id = new SimpleStringProperty("");
		this.student_name = new SimpleStringProperty("");
		this.grade = new SimpleIntegerProperty(0);
	}
    
	public Grade(int grade_id, int course_id, String course_name, String student_id, String student_name, int grade) {
		this.grade_id = new SimpleIntegerProperty(grade_id);
		this.course_id = new SimpleIntegerProperty(course_id);
		this.course_name = new SimpleStringProperty(course_name);
		this.student_id = new SimpleStringProperty(student_id);
		this.student_name = new SimpleStringProperty(student_name);
		this.grade = new SimpleIntegerProperty(grade);
	}
	
	public IntegerProperty getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(IntegerProperty grade_id) {
		this.grade_id = grade_id;
	}

	public IntegerProperty getCourse_id() {
		return course_id;
	}

	public void setCourse_id(IntegerProperty course_id) {
		this.course_id = course_id;
	}

	public StringProperty getCourse_name() {
		return course_name;
	}

	public void setCourse_name(StringProperty course_name) {
		this.course_name = course_name;
	}

	public StringProperty getStudent_id() {
		return student_id;
	}

	public void setStudent_id(StringProperty student_id) {
		this.student_id = student_id;
	}

	public StringProperty getStudent_name() {
		return student_name;
	}

	public void setStudent_name(StringProperty student_name) {
		this.student_name = student_name;
	}

	public IntegerProperty getGrade() {
		return grade;
	}

	public void setGrade(IntegerProperty grade) {
		this.grade = grade;
	}
}