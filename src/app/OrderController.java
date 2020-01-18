package app;

import app.client.CompanyClient;
import app.company.TransportCompany;
import app.order.TransportOrder;
import app.vechicle.CompanyVehicle;
import app.worker.CompanyWorker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

    @FXML
    private Label companyName;

    private List<TransportCompany> transportCompanies;

    private int transportCompanyIndex;

    @FXML
    private ChoiceBox<CompanyClient> clientChoiceBox;

    @FXML
    private ChoiceBox<CompanyVehicle> vehicleChoiceBox;

    @FXML
    private ChoiceBox<CompanyWorker> workerChoiceBox;

    @FXML
    private TextField distanceInKM;

    @FXML
    private TextField startLocation;

    @FXML
    private TextField endLocation;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    public void showMainView(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainAppView.fxml"));
        Parent mainAppView = loader.load();
        Scene mainAppViewScene = new Scene(mainAppView);
        MainAppController controller = loader.getController();
        controller.initData(this.transportCompanies);
        Stage mainAppWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        mainAppWindow.setScene(mainAppViewScene);

        mainAppWindow.show();
    }

    public void createOrder(ActionEvent actionEvent) throws IOException {
        CompanyVehicle chosenVehicle = vehicleChoiceBox.getSelectionModel().getSelectedItem();
        CompanyClient chosenClient = clientChoiceBox.getSelectionModel().getSelectedItem();
        CompanyWorker chosenWorker = workerChoiceBox.getSelectionModel().getSelectedItem();
        Date chosenStartDate = Date.valueOf(startDate.getValue());
        Date chosenEndDate = Date.valueOf(endDate.getValue());
        long chosenDistance = Integer.parseInt(distanceInKM.getText());
        String chosenStartLocation = startLocation.getText();
        String chosenEndLocation = endLocation.getText();
        this.transportCompanies.get(transportCompanyIndex).addOrder(
                new TransportOrder(chosenVehicle,
                        chosenClient,
                        chosenWorker,
                        chosenDistance,
                        chosenStartDate,
                        chosenEndDate,
                        chosenStartLocation,
                        chosenEndLocation));
        this.showMainView(actionEvent);
    }

    public void initData(List<TransportCompany> transportCompany, int index) {
        this.transportCompanies = transportCompany;
        this.transportCompanyIndex = index;
        this.companyName.setText(this.transportCompanies.get(this.transportCompanyIndex).getCompanyName());
        clientChoiceBox.getItems().addAll(transportCompanies.get(transportCompanyIndex).getCompanyClients());
        workerChoiceBox.getItems().addAll(transportCompanies.get(transportCompanyIndex).getCompanyWorkers());
        vehicleChoiceBox.getItems().addAll(transportCompanies.get(transportCompanyIndex).getCompanyVehicles());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
