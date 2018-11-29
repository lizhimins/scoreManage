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
	
    // ���캯��
    public TeacherOverviewController() {
    	
    }

    // ����FXML�ļ�
    @FXML
    private void initialize() {
        // ��ʼ��������
        Column1.setCellValueFactory(cellData -> cellData.getValue().getTeacher_id() );
        Column2.setCellValueFactory(cellData -> cellData.getValue().getName() );
        
        // ��ձ��
        showDetails(null);

        // ����ѡ���¼�
        Table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showDetails(newValue));
    
        
    }

    // ��ʾ����
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        Table.setItems(mainApp.getTeacherData());
        UpdateList();
    }
    
    // ��ϸ����
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
    
	// �½�����
    @FXML
    private void handleNew() {
    	String id = TextTeacher_id.getText();
    	if (id.isEmpty()) {
    		AlertUtil.Information("�̹��Ų�Ϊ��", "");
    		return;
    	}
    	Teacher tmp = SearchTeacher(id);
    	if (tmp != null) {
    		AlertUtil.Warning("�̹����Ѿ�����", "");
    	} else {
        	tmp = getInformation();
        	try {
            	con = dbUtil.getCon();
            	if (1 == teacherDao.create(con, tmp)) {
            		AlertUtil.Information("�����ɹ�", "");
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
    
    
    // ��ѯ����
    @FXML
    private void handleSearch() {
    	String id = TextTeacher_id.getText();
    	Teacher tmp = SearchTeacher(id);
    	if (tmp != null) {
    		showDetails(tmp);
    		AlertUtil.Information("��ѯ�ɹ�", "");
    	} else {
    		AlertUtil.Information("�̹��Ų�����", "");
    	}
    	UpdateList();
    }
    
    // �༭����
    @FXML
    private void handleEdit() {
    	String id = TextTeacher_id.getText();
    	Teacher tmp = SearchTeacher(id);
    	if (tmp != null) {
    		tmp = getInformation();
        	try {
            	con = dbUtil.getCon();
            	if (1 == teacherDao.update(con, tmp)) {
            		AlertUtil.Information("���³ɹ�", "");
            	}
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	} else {
    		AlertUtil.Information("�̹��Ų�����", "");
    	}
    	UpdateList();
    }
    
    // ɾ������
    @FXML
    private void handleDelete() {
    	String id = TextTeacher_id.getText();
    	if (SearchTeacher(id) != null) {
    		try {
            	con = dbUtil.getCon();
            	teacherDao.delete(con, id);
            	AlertUtil.Information("ɾ���ɹ�", "");
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	} else {
    		AlertUtil.Information("�̹��Ų�����", "");
    	}
    	UpdateList();
    	
    }
    
    // �˳�����
    @FXML
    private void handleExit() {
    	mainApp.showFunctionOverview();
    }
}