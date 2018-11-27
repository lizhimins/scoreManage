package manage.view;

import javafx.fxml.FXML;
import manage.MainApp;
import manage.model.Person;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

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
    @FXML
    private MainApp mainApp;
    // ���캯��
    public PersonOverviewController() {
    }

    // ����FXML�ļ�
    @FXML
    private void initialize() {
        // ��ʼ��������
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        // ��ձ��
        showPersonDetails(null);

        // ����ѡ���¼�
        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    // �õ�����
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        personTable.setItems(mainApp.getPersonData());
    }
    
    // ��ʾ����
    private void showPersonDetails(Person person) {
        if (person != null) {
            Textstu_id.setText(person.getFirstName());
            TextName.setText(person.getFirstName());
            TextSex.setText(person.getFirstName());
            TextStu_class.setText(person.getFirstName());
            TextStu_dept.setText(person.getFirstName());
            TextAge.setText(person.getFirstName());
            TextTel.setText(person.getFirstName());
        } else {
        	// ȫ�����
        }
    }
    
    // ɾ������
    @FXML
    private void handleDeletePerson() {
        
    }
    
    // �½�����
    @FXML
    private void handleNewPerson() {
        
    }
    
    // �༭����
    @FXML
    private void handleEditPerson() {
        
    }
}