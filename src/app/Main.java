package app;

import app.company.TransportCompany;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainAppView.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Transport Company");
        MainAppController mainAppController = loader.getController();
        mainAppController.initData(dummyTransportCompanies());
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public List<TransportCompany> dummyTransportCompanies(){
        List<TransportCompany> transportCompanies = new ArrayList<>();
        transportCompanies.add(new TransportCompany("Cmpany a").addDummyClient("Client"));
        transportCompanies.add(new TransportCompany("Cmpany b").addDummyClient("Another Client"));
        transportCompanies.add(new TransportCompany("Cmpany c").addDummyClient("Yet Another Client"));
        return transportCompanies;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
