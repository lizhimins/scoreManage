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
    // 构造函数
    public PersonOverviewController() {
    }

    // 加载FXML文件
    @FXML
    private void initialize() {
        // 初始化两个列
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        // 清空表格
        showPersonDetails(null);

        // 监听选择事件
        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    // 得到数据
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        personTable.setItems(mainApp.getPersonData());
    }
    
    // 显示数据
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
        	// 全部清空
        }
    }
    
    // 删除操作
    @FXML
    private void handleDeletePerson() {
        
    }
    
    // 新建操作
    @FXML
    private void handleNewPerson() {
        
    }
    
    // 编辑操作
    @FXML
    private void handleEditPerson() {
        
    }
}