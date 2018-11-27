package manage;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import manage.util.DbUtil;
import manage.dao.StudentDao;
import manage.model.Person;
import manage.model.Student;
import manage.view.PersonOverviewController;
import manage.view.StudentOverviewController;

public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    
    // 创建对象组
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    private ObservableList<Student> studentData = FXCollections.observableArrayList();

    public MainApp() {
		DbUtil dbUtil = new DbUtil();
    	StudentDao studentDao = new StudentDao();
    	Connection con = null;
		try {
        	con = dbUtil.getCon();
        	ArrayList<Student> student = studentDao.query(con, "*");
        	for (int i=0; i<student.size(); i++) {
        		studentData.add(student.get(i));
        	}
    	} catch (Exception e1) {
    		e1.printStackTrace();
    		dbUtil.closeCon(con);
    	} finally {
    		dbUtil.closeCon(con);
    	}
    }

    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }
    public ObservableList<Student> getStudentData() {
        return studentData;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("学生成绩管理系统 - Terrance - MVC模式");

        initRootLayout();

        showPersonOverview();
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

    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(personOverview);
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showTest() {
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
    
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}