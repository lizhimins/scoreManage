package manage.view;

import java.sql.Connection;
import java.util.ArrayList;

import javafx.fxml.FXML;
import manage.MainApp;
import manage.model.Grade;
import manage.util.DbUtil;
import manage.util.AlertUtil;
import manage.dao.GradeDao;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GradeOverviewController {
    @FXML
    private TableView<Grade> Table;
    @FXML
    private TableColumn<Grade, String> Column1;
    @FXML
    private TableColumn<Grade, String> Column2;

    @FXML
    private TextField TextGrade_id;
    @FXML
    private TextField TextCourse_id;
    @FXML
    private TextField TextCourse_name;
    @FXML
    private TextField TextStudent_id;
    @FXML
    private TextField TextStudent_name;
    @FXML
    private TextField TextGrade;

    private MainApp mainApp;
    DbUtil dbUtil = new DbUtil();
	GradeDao gradeDao = new GradeDao();
	Connection con = null;
	
    // ���캯��
    public GradeOverviewController() {
    	
    }

    // ����FXML�ļ�
    @FXML
    private void initialize() {
        // ��ʼ��������
        Column1.setCellValueFactory(cellData -> cellData.getValue().getCourse_name() );
        Column2.setCellValueFactory(cellData -> cellData.getValue().getStudent_name() );
        
        // ��ձ��
        showDetails(null);

        // ����ѡ���¼�
        Table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showDetails(newValue));
    
        
    }

    // ��ʾ����
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        Table.setItems(mainApp.getGradeData());
        UpdateList();
    }
    
    // ��ϸ����
    private void showDetails(Grade tmp) {
        if (tmp != null) {
        	TextGrade_id.setText(tmp.getGrade_id().get() + "");
            TextCourse_id.setText(tmp.getCourse_id().get() + "");
            TextCourse_name.setText(tmp.getCourse_name().get());
            TextStudent_id.setText(tmp.getStudent_id().get());
            TextStudent_name.setText(tmp.getStudent_name().get());
            TextGrade.setText(tmp.getGrade().get() + "");
        }
    }
    
    public void UpdateList() {
    	mainApp.gradeData.clear();
		try {
        	con = dbUtil.getCon();
        	ArrayList<Grade> tmp = gradeDao.query(con, "*");
        	for (int i=0; i<tmp.size(); i++) {
        		mainApp.gradeData.add(tmp.get(i));
        	}
    	} catch (Exception e1) {
    		e1.printStackTrace();
    		dbUtil.closeCon(con);
    	} finally {
    		dbUtil.closeCon(con);
    	}
    }
    
    private Grade Search(String id) {
		try {
        	con = dbUtil.getCon();
        	ArrayList<Grade> list = gradeDao.query(con, id);
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
    
    private Grade getInformation() {
    	return new Grade(Integer.parseInt(TextGrade_id.getText()),
    					 Integer.parseInt(TextCourse_id.getText()),
				         TextCourse_name.getText(),
				         TextStudent_id.getText(),
				         TextStudent_name.getText(),
				         Integer.parseInt(TextGrade.getText()));
    }
    
	// �½�����
    @FXML
    private void handleNew() {
    	String id = TextGrade_id.getText();
    	if (id.isEmpty()) {
    		AlertUtil.Information("��¼�Ų�Ϊ��", "");
    		return;
    	}
    	Grade tmp = Search(id);
    	if (tmp != null) {
    		AlertUtil.Warning("��¼���Ѿ�����", "");
    	} else {
        	tmp = getInformation();
        	try {
            	con = dbUtil.getCon();
            	if (1 == gradeDao.create(con, tmp)) {
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
    	String id = TextGrade_id.getText();
    	Grade tmp = Search(id);
    	if (tmp != null) {
    		showDetails(tmp);
    		AlertUtil.Information("��ѯ�ɹ�", "");
    	} else {
    		AlertUtil.Information("��¼�Ų�����", "");
    	}
    	UpdateList();
    }
    
    // �༭����
    @FXML
    private void handleEdit() {
    	String id = TextGrade_id.getText();
    	Grade tmp = Search(id);
    	if (tmp != null) {
    		tmp = getInformation();
        	try {
            	con = dbUtil.getCon();
            	if (1 == gradeDao.update(con, tmp)) {
            		AlertUtil.Information("���³ɹ�", "");
            	}
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	} else {
    		AlertUtil.Information("��¼�Ų�����", "");
    	}
    	UpdateList();
    }
    
    // ɾ������
    @FXML
    private void handleDelete() {
    	String id = TextGrade_id.getText();
    	if (Search(id) != null) {
    		try {
            	con = dbUtil.getCon();
            	gradeDao.delete(con, id);
            	AlertUtil.Information("ɾ���ɹ�", "");
        	} catch (Exception e1) {
        		e1.printStackTrace();
        		dbUtil.closeCon(con);
        	} finally {
        		dbUtil.closeCon(con);
        	}
    	} else {
    		AlertUtil.Information("��¼�Ų�����", "");
    	}
    	UpdateList();
    	
    }
    
    // �˳�����
    @FXML
    private void handleExit() {
    	mainApp.showFunctionOverview();
    }
}