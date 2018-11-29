package manage.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher {
	private StringProperty teacher_id;
	private StringProperty name;
    private StringProperty sex;
    private StringProperty education;
    private StringProperty academic;
    private IntegerProperty age;
    private StringProperty tel;
    
    public Teacher() {
		this.teacher_id = new SimpleStringProperty("");
		this.name = new SimpleStringProperty("");
		this.sex = new SimpleStringProperty("");
		this.education = new SimpleStringProperty("");
		this.academic = new SimpleStringProperty("");
		this.age = new SimpleIntegerProperty(0);
		this.tel = new SimpleStringProperty("");
	}
    
    public Teacher(String teacher_id, String name, String sex, String education, String academic, int age, String tel) {
		this.teacher_id = new SimpleStringProperty(teacher_id);
		this.name = new SimpleStringProperty(name);
		this.sex = new SimpleStringProperty(sex);
		this.education = new SimpleStringProperty(education);
		this.academic = new SimpleStringProperty(academic);
		this.age = new SimpleIntegerProperty(age);
		this.tel = new SimpleStringProperty(tel);
	}
    
	public StringProperty getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(StringProperty teacher_id) {
		this.teacher_id = teacher_id;
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	public StringProperty getSex() {
		return sex;
	}
	public void setSex(StringProperty sex) {
		this.sex = sex;
	}
	public StringProperty getEducation() {
		return education;
	}
	public void setEducation(StringProperty education) {
		this.education = education;
	}
	public StringProperty getAcademic() {
		return academic;
	}
	public void setAcademic(StringProperty academic) {
		this.academic = academic;
	}
	public IntegerProperty getAge() {
		return age;
	}
	public void setAge(IntegerProperty age) {
		this.age = age;
	}
	public StringProperty getTel() {
		return tel;
	}
	public void setTel(StringProperty tel) {
		this.tel = tel;
	}
}