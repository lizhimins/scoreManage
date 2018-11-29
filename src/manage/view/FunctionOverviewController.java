package manage.view;

import javafx.fxml.FXML;
import manage.MainApp;

public class FunctionOverviewController {
    private MainApp mainApp;
    
    // ���캯��
    public FunctionOverviewController() {
    	
    }

    // ����FXML�ļ�
    @FXML
    private void initialize() {
        
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