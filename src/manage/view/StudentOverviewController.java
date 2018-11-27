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
    
    // ���캯��
    public StudentOverviewController() {
    	
    }

    // ����FXML�ļ�
    @FXML
    private void initialize() {
        // ��ʼ��������
        Column1.setCellValueFactory(cellData -> cellData.getValue().getStu_id() );
        Column2.setCellValueFactory(cellData -> cellData.getValue().getName() );
        
        // ��ձ��
        showDetails(null);

        // ����ѡ���¼�
        Table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showDetails(newValue));
    }

    // ��ʾ����
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        Table.setItems(mainApp.getStudentData());
    }
    
    // ��ϸ����
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
    
	// �½�����
    @FXML
    private void handleNewStudent() {
    	/*Student tmp = new Student();
        if (Textstu_id.getText().equals("")) {
        	
        }*/
    }
    
    // ��ѯ����
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
        		AlertUtil.Information("��������ȷ��ѧ��", "");
        	}
    	} catch (Exception e1) {
    		e1.printStackTrace();
    		dbUtil.closeCon(con);
    	} finally {
    		dbUtil.closeCon(con);
    	}
    	
    }
    
    // �༭����
    @FXML
    private void handleEditStudent() {
    	
    }
    
    // ɾ������
    @FXML
    private void handleDeleteStudent() {
        
    }
    
    // �˳�����
    @FXML
    private void handleExit() {
    	
    }

    public void setStage(Stage stage) {
        
    }
}