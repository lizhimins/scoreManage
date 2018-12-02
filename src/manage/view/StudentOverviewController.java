package manage.view;

import java.sql.Connection;
import java.util.ArrayList;

import javafx.fxml.FXML;
import manage.MainApp;
import manage.model.Student;
import manage.util.DbUtil;
import manage.util.AlertUtil;
import manage.dao.StudentDao;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StudentOverviewController {
    @FXML
    private TableView<Student> Table;
    @FXML
    private TableColumn<Student, String> Column1;
    @FXML
    private TableColumn<Student, String> Column2;

    @FXML
    private TextField Textstu_id;
    @FXML
    private TextField TextName;
    @FXML
    private TextField TextPassword;
    @FXML
    private TextField TextSex;
    @FXML
    private TextField TextStu_class;
    @FXML
    private TextField TextStu_dept;
    @FXML
    private TextField TextAge;
    @FXML
    private TextField TextTel;

    private MainApp mainApp;
    DbUtil dbUtil = new DbUtil();
	StudentDao studentDao = new StudentDao();
	Connection con = null;
	
    // 构造函数
    public StudentOverviewController() {
    	
    }

    // 加载FXML文件
    @FXML
    private void initialize() {
        // 初始化两个列
        Column1.setCellValueFactory(cellData -> cellData.getValue().getStu_id() );
        Column2.setCellValueFactory(cellData -> cellData.getValue().getName() );
        
        // 清空表格
        showDetails(null);

        // 监听选择事件
        Table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showDetails(newValue));
    
        
    }

    // 显示数据
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        Table.setItems(mainApp.getStudentData());
        UpdateList();
    }
    
    // 详细数据
    private void showDetails(Student student) {
        if (student != null) {
            Textstu_id.setText(student.getStu_id().get());
            TextName.setText(student.getName().get());
            TextPassword.setText(student.getPass().get());
            TextSex.setText(student.getSex().get());
            TextStu_class.setText(student.getStu_class().get());
            TextStu_dept.setText(student.getStu_dept().get());
            TextAge.setText(Integer.toString(student.getAge().get()));
            TextTel.setText(student.getTel().get());
        }
    }
    
    public void UpdateList() {
    	mainApp.studentData.clear();
		try {
        	con = dbUtil.getCon();
        	ArrayList<Student> student = studentDao.query(con, "*");
        	for (int i=0; i<student.size(); i++) {
        		mainApp.studentData.add(student.get(i));
        	}
    	} catch (Exception e1) {
    		e1.printStackTrace();
    		dbUtil.closeCon(con);
    	} finally {
    		dbUtil.closeCon(con);
    	}
    }
    
    private Student SearchStudent(String id) {
		try {
        	con = dbUtil.getCon();
        	ArrayList<Student> list = studentDao.query(con, id);
        	if (list.size() == 1) {
        		return list.get(0);
        	}
    	} catch (Exception e1) {
    		e1.printStackTrace();
    		dbUtil.closeCon(con);
    	} finally {
    		dbUtil.closeCon(con);
    	}
		return null;
    }
    
    private Student getInformation() {
    	return new Student(Textstu_id.getText(), TextName.getText(), TextPassword.getText(), TextSex.getText(), TextStu_class.getText(),TextStu_dept.getText(),Integer.parseInt(TextAge.getText()),TextTel.getText());
    }
    
	// 新建操作
    @FXML
    private void handleNewStudent() {
    	String id = Textstu_id.getText();
    	if (id.isEmpty()) {
    		AlertUtil.Information("学号不为空", "");
    		return;
    	}
    	Student tmp = SearchStudent(id);
    	if (tmp != null) {
    		AlertUtil.Warning("学号已经存在", "");
    	} else {
        	tmp = getInformation();
        	try {
            	con = dbUtil.getCon();
            	if (1 == studentDao.create(con, tmp)) {
            		AlertUtil.Information("创建成功", "");
            	}
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	}
    	UpdateList();
    }
    
    
    // 查询操作
    @FXML
    private void handleSearchStudent() {
    	String id = Textstu_id.getText();
    	Student tmp = SearchStudent(id);
    	if (tmp != null) {
    		showDetails(tmp);
    		AlertUtil.Information("查询成功", "");
    	} else {
    		AlertUtil.Information("学号不存在", "");
    	}
    	UpdateList();
    }
    
    // 编辑操作
    @FXML
    private void handleEditStudent() {
    	String id = Textstu_id.getText();
    	Student tmp = SearchStudent(id);
    	if (tmp != null) {
    		tmp = getInformation();
        	try {
            	con = dbUtil.getCon();
            	if (1 == studentDao.update(con, tmp)) {
            		AlertUtil.Information("更新成功", "");
            	}
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	} else {
    		AlertUtil.Information("学号不存在", "");
    	}
    	UpdateList();
    }
    
    // 删除操作
    @FXML
    private void handleDeleteStudent() {
    	String id = Textstu_id.getText();
    	if (SearchStudent(id) != null) {
    		try {
            	con = dbUtil.getCon();
            	studentDao.delete(con, id);
            	AlertUtil.Information("删除成功", "");
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	} else {
    		AlertUtil.Information("学号不存在", "");
    	}
    	UpdateList();
    	
    }
    
    // 退出操作
    @FXML
    private void handleExit() {
    	mainApp.showFunctionOverview();
    }
}