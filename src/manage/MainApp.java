package manage;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import manage.model.Course;
import manage.model.Grade;
import manage.model.Identity;
import manage.model.Student;
import manage.model.Teacher;
import manage.view.CourseOverviewController;
import manage.view.FunctionOverviewController;
import manage.view.GradeOverviewController;
import manage.view.StudentOverviewController;
import manage.view.TeacherOverviewController;

public class MainApp extends Application {
	private Stage primaryStage;
    private BorderPane rootLayout;

    // ����������
    public ObservableList<Student> studentData = FXCollections.observableArrayList();
    public ObservableList<Teacher> teacherData = FXCollections.observableArrayList();
    public ObservableList<Course> courseData = FXCollections.observableArrayList();
    public ObservableList<Grade> gradeData = FXCollections.observableArrayList();
    public MainApp() {
    	//Identity.setAdmin();
    	Identity.setVisitor();
    }

    // �����������
    public ObservableList<Student> getStudentData() {
        return studentData;
    }
    public ObservableList<Teacher> getTeacherData() {
        return teacherData;
    }
    public ObservableList<Course> getCourseData() {
        return courseData;
    }
    public ObservableList<Grade> getGradeData() {
        return gradeData;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ѧ���ɼ�����ϵͳ - Terrance - MVCģʽ");

        initRootLayout();
        showFunctionOverview();
        //showStudentOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // ��ʼ��ѡ�����
    public void showFunctionOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/FunctionOverview.fxml"));
            AnchorPane ap = (AnchorPane) loader.load();
            rootLayout.setCenter(ap);
            FunctionOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // ѧ�����
    public void showStudentOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StudentOverview.fxml"));
            AnchorPane studentOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(studentOverview);
            StudentOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // ��ʦ���
    public void showTeacherOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TeacherOverview.fxml"));
            AnchorPane studentOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(studentOverview);
            TeacherOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // �γ����
    public void showCourseOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CourseOverview.fxml"));
            AnchorPane studentOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(studentOverview);
            CourseOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // �ɼ����
    public void showGradeOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/GradeOverview.fxml"));
            AnchorPane studentOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(studentOverview);
            GradeOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}