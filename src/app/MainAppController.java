package app;


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
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {

    private TransportCompany tc;

    @FXML
    private TextField companyNameTextField;

    @FXML
    private TableView<TransportCompany> transportCompanyTableView;

    @FXML
    private TableColumn<TransportCompany,String> transportCompanyNameColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transportCompanyNameColumn.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        transportCompanyTableView.setItems(getTransportCompanies());
        transportCompanyTableView.setEditable(true);
        transportCompanyNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void editCompany(CellEditEvent editEvent){
        TransportCompany company = transportCompanyTableView.getSelectionModel().getSelectedItem();
        company.setCompanyName(editEvent.getNewValue().toString());
    }

    public void createCompany(){
        TransportCompany newTransportCompany = new TransportCompany(companyNameTextField.getText());
        transportCompanyTableView.getItems().add(newTransportCompany);
    }

    public void deleteCompany(){
        ObservableList<TransportCompany> transportCompanies;
        transportCompanies = transportCompanyTableView.getItems();
        int selectedTransportCompany = transportCompanyTableView.getSelectionModel().getFocusedIndex();
        transportCompanies.remove(selectedTransportCompany);
    }

    public ObservableList<TransportCompany> getTransportCompanies(){
        ObservableList<TransportCompany> transportCompanies = FXCollections.observableArrayList();
        transportCompanies.add(new TransportCompany("Cmpany a"));
        transportCompanies.add(new TransportCompany("Cmpany b"));
        transportCompanies.add(new TransportCompany("Cmpany c"));
        return transportCompanies;
    }

    public void showCompanyView(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CompanyDetailsView.fxml"));
        Parent companyDetailsView = loader.load();
        Scene companyDetailsViewScene = new Scene(companyDetailsView);
        Stage companyDetailsWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        companyDetailsWindow.setScene(companyDetailsViewScene);

        CompanyDetailsController controller = loader.getController();
        controller.initData(transportCompanyTableView.getSelectionModel().getSelectedItem());
        companyDetailsWindow.show();
    }
}


