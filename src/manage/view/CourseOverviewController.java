package manage.view;

import java.sql.Connection;
import java.util.ArrayList;

import javafx.fxml.FXML;
import manage.MainApp;
import manage.model.Course;
import manage.util.DbUtil;
import manage.util.AlertUtil;
import manage.dao.CourseDao;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CourseOverviewController {
    @FXML
    private TableView<Course> Table;
    @FXML
    private TableColumn<Course, String> Column1;
    @FXML
    private TableColumn<Course, String> Column2;

    @FXML
    private TextField TextCourse_id;
    @FXML
    private TextField TextName;
    @FXML
    private TextField TextTeacher_id;
    @FXML
    private TextField TextTeacherName;
    @FXML
    private TextField TextTime;

    private MainApp mainApp;
    DbUtil dbUtil = new DbUtil();
	CourseDao courseDao = new CourseDao();
 	Connection con = null;
	
    // 构造函数
    public CourseOverviewController() {
    	
    }

    // 加载FXML文件
    @FXML
    private void initialize() {
        // 初始化两个列
        Column1.setCellValueFactory(cellData -> cellData.getValue().getName());
        Column2.setCellValueFactory(cellData -> cellData.getValue().getTeacherName() );
        
        // 清空表格
        showDetails(null);

        // 监听选择事件
        Table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showDetails(newValue));
    }

    // 显示数据
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        Table.setItems(mainApp.getCourseData());
        UpdateList();
    }
    
    // 详细数据
    private void showDetails(Course course) {
        if (course != null) {
        	TextCourse_id.setText(course.getCourse_id().get() + "");
            TextName.setText(course.getName().get());
            TextTeacher_id.setText(course.getTeacher_id().get());
            TextTeacherName.setText(course.getTeacherName().get());
            TextTime.setText(course.getTime().get() + "");
        }
    }
    
    public void UpdateList() {
    	mainApp.courseData.clear();
		try {
        	con = dbUtil.getCon();
        	ArrayList<Course> course = courseDao.query(con, "*");
        	for (int i=0; i<course.size(); i++) {
        		mainApp.courseData.add(course.get(i));
        	}
    	} catch (Exception e1) {
    		e1.printStackTrace();
    		dbUtil.closeCon(con);
    	} finally {
    		dbUtil.closeCon(con);
    	}
    }
    
    private Course SearchCourse(String id) {
		try {
        	con = dbUtil.getCon();
        	ArrayList<Course> list = courseDao.query(con, id);
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
    
    private Course getInformation() {
    	return new Course(Integer.parseInt(TextCourse_id.getText()),
						  TextName.getText(),
						  TextTeacher_id.getText(),
						  TextTeacherName.getText(),
						  Integer.parseInt(TextTime.getText()));
    }
    
	// 新建操作
    @FXML
    private void handleNew() {
    	String id = TextCourse_id.getText() + "";
    	if (id.isEmpty()) {
    		AlertUtil.Information("记录号不为空", "");
    		return;
    	}
    	Course tmp = SearchCourse(id);
    	if (tmp != null) {
    		AlertUtil.Warning("记录号已经存在", "");
    	} else {
        	tmp = getInformation();
        	try {
            	con = dbUtil.getCon();
            	if (1 == courseDao.create(con, tmp)) {
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
    private void handleSearch() {
    	String id = TextCourse_id.getText();
    	Course tmp = SearchCourse(id);
    	if (tmp != null) {
    		showDetails(tmp);
    		AlertUtil.Information("查询成功", "");
    	} else {
    		AlertUtil.Information("记录号不存在", "");
    	}
    	UpdateList();
    }
    
    // 编辑操作
    @FXML
    private void handleEdit() {
    	String id = TextCourse_id.getText();
    	Course tmp = SearchCourse(id);
    	if (tmp != null) {
    		tmp = getInformation();
        	try {
            	con = dbUtil.getCon();
            	if (1 == courseDao.update(con, tmp)) {
            		AlertUtil.Information("更新成功", "");
            	}
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	} else {
    		AlertUtil.Information("记录号不存在", "");
    	}
    	UpdateList();
    }
    
    // 删除操作
    @FXML
    private void handleDelete() {
    	String id = TextCourse_id.getText();
    	if (SearchCourse(id) != null) {
    		try {
            	con = dbUtil.getCon();
            	courseDao.delete(con, id);
            	AlertUtil.Information("删除成功", "");
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	} else {
    		AlertUtil.Information("记录号不存在", "");
    	}
    	UpdateList();
    	
    }
    
    // 退出操作
    @FXML
    private void handleExit() {
    	mainApp.showFunctionOverview();
    }
}