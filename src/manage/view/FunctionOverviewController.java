package manage.view;

import javafx.fxml.FXML;
import manage.MainApp;

public class FunctionOverviewController {
    private MainApp mainApp;
    
    // 构造函数
    public FunctionOverviewController() {
    	
    }

    // 加载FXML文件
    @FXML
    private void initialize() {
        
    }

    // 显示数据
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