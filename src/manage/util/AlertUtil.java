package manage.util;

import javafx.scene.control.Alert;

public class AlertUtil {
    public static void Information(String header, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("信息");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.show();
    }
    
    public static void Warning(String header, String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("警告");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void Confirmation(String header, String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("询问");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void error(String header, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("错误");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
