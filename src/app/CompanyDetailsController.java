package app;

import app.company.TransportCompany;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CompanyDetailsController implements Initializable {

    private TransportCompany transportCompany;

    @FXML
    private Label companyName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void showMainView(ActionEvent actionEvent) throws IOException {
        Parent mainAppView = FXMLLoader.load(getClass().getResource("MainAppView.fxml"));
        Scene mainAppViewScene = new Scene(mainAppView);
        Stage mainAppWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainAppWindow.setScene(mainAppViewScene);

        mainAppWindow.show();
    }

    public void initData(TransportCompany transportCompany){
        this.transportCompany = transportCompany;
        this.companyName.setText(this.transportCompany.getCompanyName());
    }
}
