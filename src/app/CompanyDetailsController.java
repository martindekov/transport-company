package app;

import app.client.CompanyClient;
import app.company.TransportCompany;
import app.vechicle.CompanyVehicle;
import app.worker.CompanyWorker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CompanyDetailsController implements Initializable {

    private List<TransportCompany> transportCompanies;
    private int transportCompanyIndex;

    @FXML
    private TextField clientNameTextField;

    @FXML
    private Label companyName;

    @FXML
    private TableView<CompanyClient> companyClientsTableView;

    @FXML
    private TableColumn<CompanyClient,String> companyClientsColumn;

    @FXML
    private TextField workerNameTextField;

    @FXML
    private TableView<CompanyWorker> companyWorkersTableView;

    @FXML
    private TableColumn<CompanyWorker,String> companyWorkersColumn;

    @FXML
    private TextField vehicleNameTextField;

    @FXML
    private TableView<CompanyVehicle> companyVehiclesTableView;

    @FXML
    private TableColumn<CompanyVehicle,String> companyVehiclesColumn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void editClient(CellEditEvent editEvent){
        CompanyClient companyClient = companyClientsTableView.getSelectionModel().getSelectedItem();
        companyClient.setClientName(editEvent.getNewValue().toString());
    }

    public void createClient(){
        CompanyClient newCompanyClient = new CompanyClient(clientNameTextField.getText());
        companyClientsTableView.getItems().add(newCompanyClient);
        transportCompanies.get(transportCompanyIndex).addClient(newCompanyClient);
    }

    public void deleteClient(){
        ObservableList<CompanyVehicle> companyVehicles;
        companyVehicles = companyVehiclesTableView.getItems();
        int selectedCompanyVehicle = companyVehiclesTableView.getSelectionModel().getFocusedIndex();
        companyVehicles.remove(selectedCompanyVehicle);
        this.transportCompanies.get(this.transportCompanyIndex).removeClient(selectedCompanyVehicle);
    }

    public void editWorker(CellEditEvent editEvent){
        CompanyWorker companyWorker = companyWorkersTableView.getSelectionModel().getSelectedItem();
        companyWorker.setWorkerName(editEvent.getNewValue().toString());
    }

    public void createWorker(){
        CompanyWorker newCompanyWorker = new CompanyWorker(workerNameTextField.getText());
        companyWorkersTableView.getItems().add(newCompanyWorker);
        transportCompanies.get(transportCompanyIndex).addWorker(newCompanyWorker);
    }

    public void deleteWorker(){
        ObservableList<CompanyWorker> companyWorkers;
        companyWorkers = companyWorkersTableView.getItems();
        int selectedCompanyWorker = companyWorkersTableView.getSelectionModel().getFocusedIndex();
        companyWorkers.remove(selectedCompanyWorker);
        this.transportCompanies.get(transportCompanyIndex).removeWorker(selectedCompanyWorker);
    }

    public void editVehicle(CellEditEvent editEvent){
        CompanyVehicle companyVehicle = companyVehiclesTableView.getSelectionModel().getSelectedItem();
        companyVehicle.setVehicleName(editEvent.getNewValue().toString());
    }

    public void createVehicle(){
        CompanyVehicle newCompanyVehicle = new CompanyVehicle(vehicleNameTextField.getText());
        companyVehiclesTableView.getItems().add(newCompanyVehicle);
        transportCompanies.get(transportCompanyIndex).addVehicle(newCompanyVehicle);
    }

    public void deleteVehicle(){
        ObservableList<CompanyVehicle> companyVehicles;
        companyVehicles = companyVehiclesTableView.getItems();
        int selectedCompanyVehicle = companyVehiclesTableView.getSelectionModel().getFocusedIndex();
        companyVehicles.remove(selectedCompanyVehicle);
        this.transportCompanies.get(transportCompanyIndex).removeVehicle(selectedCompanyVehicle);
    }

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

    public void initData(List<TransportCompany> transportCompany, int index){
        this.transportCompanies = transportCompany;
        this.transportCompanyIndex = index;
        this.companyName.setText(this.transportCompanies.get(this.transportCompanyIndex).getCompanyName());

        companyClientsColumn.setCellValueFactory(new PropertyValueFactory<CompanyClient,String>("clientName"));
        companyClientsTableView.setItems(FXCollections.observableArrayList(this.transportCompanies.get(this.transportCompanyIndex).getCompanyClients()));
        companyClientsTableView.setEditable(true);
        companyClientsColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        companyWorkersColumn.setCellValueFactory(new PropertyValueFactory<CompanyWorker,String>("workerName"));
        companyWorkersTableView.setItems(FXCollections.observableArrayList(this.transportCompanies.get(this.transportCompanyIndex).getCompanyWorkers()));
        companyWorkersTableView.setEditable(true);
        companyWorkersColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        companyVehiclesColumn.setCellValueFactory(new PropertyValueFactory<CompanyVehicle,String>("vehicleName"));
        companyVehiclesTableView.setItems(FXCollections.observableArrayList(this.transportCompanies.get(this.transportCompanyIndex).getCompanyVehicles()));
        companyVehiclesTableView.setEditable(true);
        companyVehiclesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }
}
