package manage.view;

import java.sql.Connection;
import java.util.ArrayList;

import javafx.fxml.FXML;
import manage.MainApp;
import manage.model.Teacher;
import manage.util.DbUtil;
import manage.util.AlertUtil;
import manage.dao.TeacherDao;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TeacherOverviewController {
    @FXML
    private TableView<Teacher> Table;
    @FXML
    private TableColumn<Teacher, String> Column1;
    @FXML
    private TableColumn<Teacher, String> Column2;

    @FXML
    private TextField TextTeacher_id;
    @FXML
    private TextField TextName;
    @FXML
    private TextField TextSex;
    @FXML
    private TextField TextEducation;
    @FXML
    private TextField TextAcademic;
    @FXML
    private TextField TextAge;
    @FXML
    private TextField TextTel;

    private MainApp mainApp;
    DbUtil dbUtil = new DbUtil();
	TeacherDao teacherDao = new TeacherDao();
	Connection con = null;
	
    // 构造函数
    public TeacherOverviewController() {
    	
    }

    // 加载FXML文件
    @FXML
    private void initialize() {
        // 初始化两个列
        Column1.setCellValueFactory(cellData -> cellData.getValue().getTeacher_id() );
        Column2.setCellValueFactory(cellData -> cellData.getValue().getName() );
        
        // 清空表格
        showDetails(null);

        // 监听选择事件
        Table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showDetails(newValue));
    
        
    }

    // 显示数据
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        Table.setItems(mainApp.getTeacherData());
        UpdateList();
    }
    
    // 详细数据
    private void showDetails(Teacher teacher) {
        if (teacher != null) {
        	TextTeacher_id.setText(teacher.getTeacher_id().get());
            TextName.setText(teacher.getName().get());
            TextSex.setText(teacher.getSex().get());
            TextEducation.setText(teacher.getEducation().get());
            TextAcademic.setText(teacher.getAcademic().get());
            TextAge.setText(Integer.toString(teacher.getAge().get()));
            TextTel.setText(teacher.getTel().get());
        }
    }
    
    public void UpdateList() {
    	mainApp.teacherData.clear();
    	DbUtil dbUtil = new DbUtil();
    	TeacherDao teacherDao = new TeacherDao();
    	Connection con = null;
		try {
        	con = dbUtil.getCon();
        	ArrayList<Teacher> teacher = teacherDao.query(con, "*");
        	for (int i=0; i<teacher.size(); i++) {
        		mainApp.teacherData.add(teacher.get(i));
        	}
    	} catch (Exception e1) {
    		e1.printStackTrace();
    		dbUtil.closeCon(con);
    	} finally {
    		dbUtil.closeCon(con);
    	}
    }
    
    private Teacher SearchTeacher(String id) {
		try {
        	con = dbUtil.getCon();
        	ArrayList<Teacher> list = teacherDao.query(con, id);
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
    
    private Teacher getInformation() {
    	return new Teacher(TextTeacher_id.getText(), TextName.getText(),TextSex.getText(), TextEducation.getText(), TextAcademic.getText(), Integer.parseInt(TextAge.getText()), TextTel.getText());
    }
    
	// 新建操作
    @FXML
    private void handleNew() {
    	String id = TextTeacher_id.getText();
    	if (id.isEmpty()) {
    		AlertUtil.Information("教工号不为空", "");
    		return;
    	}
    	Teacher tmp = SearchTeacher(id);
    	if (tmp != null) {
    		AlertUtil.Warning("教工号已经存在", "");
    	} else {
        	tmp = getInformation();
        	try {
            	con = dbUtil.getCon();
            	if (1 == teacherDao.create(con, tmp)) {
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
    	String id = TextTeacher_id.getText();
    	Teacher tmp = SearchTeacher(id);
    	if (tmp != null) {
    		showDetails(tmp);
    		AlertUtil.Information("查询成功", "");
    	} else {
    		AlertUtil.Information("教工号不存在", "");
    	}
    	UpdateList();
    }
    
    // 编辑操作
    @FXML
    private void handleEdit() {
    	String id = TextTeacher_id.getText();
    	Teacher tmp = SearchTeacher(id);
    	if (tmp != null) {
    		tmp = getInformation();
        	try {
            	con = dbUtil.getCon();
            	if (1 == teacherDao.update(con, tmp)) {
            		AlertUtil.Information("更新成功", "");
            	}
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	} else {
    		AlertUtil.Information("教工号不存在", "");
    	}
    	UpdateList();
    }
    
    // 删除操作
    @FXML
    private void handleDelete() {
    	String id = TextTeacher_id.getText();
    	if (SearchTeacher(id) != null) {
    		try {
            	con = dbUtil.getCon();
            	teacherDao.delete(con, id);
            	AlertUtil.Information("删除成功", "");
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	} else {
    		AlertUtil.Information("教工号不存在", "");
    	}
    	UpdateList();
    	
    }
    
    // 退出操作
    @FXML
    private void handleExit() {
    	mainApp.showFunctionOverview();
    }
}