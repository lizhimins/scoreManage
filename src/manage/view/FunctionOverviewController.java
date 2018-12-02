package manage.view;

import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import manage.MainApp;
import manage.dao.AdminDao;
import manage.dao.StudentDao;
import manage.dao.TeacherDao;
import manage.model.Identity;
import manage.util.AlertUtil;
import manage.util.DbUtil;

public class FunctionOverviewController {
    private MainApp mainApp;
    @FXML
    private Label LabelWelcome;
    @FXML
    private TextField TextName;
    @FXML
    private TextField TextPass;
    @FXML
    private Button BtnStudent;
    @FXML
    private Button BtnTeacher;
    @FXML
    private Button BtnCourse;
    @FXML
    private Button BtnGrade;
    @FXML
    private Button BtnLogin;
    @FXML
    private Button BtnExit;
    
    DbUtil dbUtil = new DbUtil();
	AdminDao admindao = new AdminDao();
	StudentDao studentDao = new StudentDao();
	TeacherDao teacherDao = new TeacherDao();
	Connection con = null;
    
	// ���캯��
    public FunctionOverviewController() {
    	
    }

    // ����FXML�ļ�
    @FXML
    private void initialize() {
    	flashButton();
    }
    
    private void flashButton() {
    	String tmp = Identity.getIdentity();
    	BtnLogin.setDisable(true);
		BtnExit.setDisable(false);
        if (tmp.equals("Admin")) {
        	BtnStudent.setDisable(false);
            BtnTeacher.setDisable(false);
            BtnCourse.setDisable(false);
            BtnGrade.setDisable(false);
        	tmp = "����Ա";
        } else if (tmp.equals("Teacher")) {
        	BtnStudent.setDisable(false);
            BtnTeacher.setDisable(false);
            BtnCourse.setDisable(true);
            BtnGrade.setDisable(false);
        	tmp = "��ʦ";
        } else if (tmp.equals("Student")) {
        	BtnStudent.setDisable(false);
            BtnTeacher.setDisable(true);
            BtnCourse.setDisable(true);
            BtnGrade.setDisable(false);
        	tmp = "ѧ��";
        } else {
        	BtnStudent.setDisable(true);
            BtnTeacher.setDisable(true);
            BtnCourse.setDisable(true);
            BtnGrade.setDisable(true);
            BtnLogin.setDisable(false);
    		BtnExit.setDisable(true);
        }
        LabelWelcome.setText("��ӭ��, " + tmp);
    }
    
    @FXML
    private void handleLogin() {
    	String user = TextName.getText();
    	String pass = TextPass.getText();
    	if (user.isEmpty() || pass.isEmpty()) {
    		AlertUtil.error("��¼ʧ��", "");
    		return;
    	}
    	try {
        	con = dbUtil.getCon();
        	String truePass = "";
        	truePass = admindao.queryPassWord(con, user);
        	if (truePass.equals(pass)) {
        		Identity.setAdmin();
        	}
        	truePass = teacherDao.queryPassWord(con, user);
        	if (truePass.equals(pass)) {
        		Identity.setTeacher();
        	}
        	truePass = studentDao.queryPassWord(con, user);
        	if (truePass.equals(pass)) {
        		Identity.setStudent();
        	}
    	} catch (Exception e1) {
    		e1.printStackTrace();
    		dbUtil.closeCon(con);
    	} finally {
    		dbUtil.closeCon(con);
    	}
    	if (Identity.getIdentity().equals("Visitor")) {
    		AlertUtil.error("��¼ʧ��", "");
    	} else {
        	flashButton();
    		BtnLogin.setDisable(true);
    		BtnExit.setDisable(false);
    	}
    }
    
    @FXML
    private void handleExit() {
    	Identity.setVisitor();
    	BtnLogin.setDisable(false);
		BtnExit.setDisable(true);
    	flashButton();
    }
    
    // ��ʾ����
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleStudent() {
    	mainApp.showStudentOverview();
    }
    
    @FXML
    private void handleTeacher() {
    	mainApp.showTeacherOverview();
    }
    
    @FXML
    private void handleCourse() {
    	mainApp.showCourseOverview();
    }
    
    @FXML
    private void handleGrade() {
    	mainApp.showGradeOverview();
    	
    }
}