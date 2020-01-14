package app;

import app.client.CompanyClient;
import app.company.TransportCompany;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void editClient(CellEditEvent editEvent){
        CompanyClient companyClient = companyClientsTableView.getSelectionModel().getSelectedItem();
        companyClient.setClientName(editEvent.getNewValue().toString());
    }

    public void createCompany(){
        CompanyClient newCompanyClient = new CompanyClient(clientNameTextField.getText());
        companyClientsTableView.getItems().add(newCompanyClient);
        transportCompanies.get(transportCompanyIndex).addClient(newCompanyClient);
    }

    public void deleteCompany(){
        ObservableList<CompanyClient> companyClients;
        companyClients = companyClientsTableView.getItems();
        int selectedCompanyClient = companyClientsTableView.getSelectionModel().getFocusedIndex();
        companyClients.remove(selectedCompanyClient);
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
    }
}
