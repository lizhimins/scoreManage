package manage.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
	private StringProperty stu_id;
	private StringProperty name;
	private StringProperty pass;
    private StringProperty sex;
    private StringProperty stu_class;
    private StringProperty stu_dept;
    private IntegerProperty age;
    private StringProperty tel;
    
    public Student() {
		this.stu_id = new SimpleStringProperty("");
		this.name = new SimpleStringProperty("");
		this.pass = new SimpleStringProperty("");
		this.sex = new SimpleStringProperty("");
		this.stu_class = new SimpleStringProperty("");
		this.stu_dept = new SimpleStringProperty("");
		this.age = new SimpleIntegerProperty(0);
		this.tel = new SimpleStringProperty("");
	}
    
    public Student(String stu_id, String name, String pass, String sex, String stu_class, String stu_dept, int age, String tel) {
		this.stu_id = new SimpleStringProperty(stu_id);
		this.name = new SimpleStringProperty(name);
		this.pass = new SimpleStringProperty(pass);
		this.sex = new SimpleStringProperty(sex);
		this.stu_class = new SimpleStringProperty(stu_class);
		this.stu_dept = new SimpleStringProperty(stu_dept);
		this.age = new SimpleIntegerProperty(age);
		this.tel = new SimpleStringProperty(tel);
	}
    
	public StringProperty getStu_id() {
		return stu_id;
	}
	public void setStu_id(StringProperty stu_id) {
		this.stu_id = stu_id;
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	
	public StringProperty getPass() {
		return pass;
	}

	public void setPass(StringProperty pass) {
		this.pass = pass;
	}

	public StringProperty getSex() {
		return sex;
	}
	public void setSex(StringProperty sex) {
		this.sex = sex;
	}
	public StringProperty getStu_class() {
		return stu_class;
	}
	public void setStu_class(StringProperty stu_class) {
		this.stu_class = stu_class;
	}
	public StringProperty getStu_dept() {
		return stu_dept;
	}
	public void setStu_dept(StringProperty stu_dept) {
		this.stu_dept = stu_dept;
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