package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnotherApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("second.fxml"));
        stage.setTitle("Another Window");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }
}
