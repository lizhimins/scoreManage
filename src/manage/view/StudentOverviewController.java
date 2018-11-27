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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    }
    
    // 详细数据
    private void showDetails(Student student) {
        if (student != null) {
            Textstu_id.setText(student.getStu_id().get());
            TextName.setText(student.getName().get());
            TextSex.setText(student.getSex().get());
            TextStu_class.setText(student.getStu_class().get());
            TextStu_dept.setText(student.getStu_dept().get());
            TextAge.setText(Integer.toString(student.getAge().get()));
            TextTel.setText(student.getTel().get());
        }
    }
    
	// 新建操作
    @FXML
    private void handleNewStudent() {
    	/*Student tmp = new Student();
        if (Textstu_id.getText().equals("")) {
        	
        }*/
    }
    
    // 查询操作
    @FXML
    private void handleSearchStudent() {
    	String id = Textstu_id.getText();
    	DbUtil dbUtil = new DbUtil();
    	StudentDao studentDao = new StudentDao();
    	Connection con = null;
		try {
        	con = dbUtil.getCon();
        	ArrayList<Student> list = studentDao.query(con, id);
        	if (list.size() == 1) {
        		showDetails(list.get(0));
        	} else {
        		AlertUtil.Information("请输入正确的学号", "");
        	}
    	} catch (Exception e1) {
    		e1.printStackTrace();
    		dbUtil.closeCon(con);
    	} finally {
    		dbUtil.closeCon(con);
    	}
    	
    }
    
    // 编辑操作
    @FXML
    private void handleEditStudent() {
    	
    }
    
    // 删除操作
    @FXML
    private void handleDeleteStudent() {
        
    }
    
    // 退出操作
    @FXML
    private void handleExit() {
    	
    }

    public void setStage(Stage stage) {
        
    }
}