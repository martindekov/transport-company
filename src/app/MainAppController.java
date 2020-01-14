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
import java.util.List;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {

    private List<TransportCompany> transportCompanies;

    @FXML
    private TextField companyNameTextField;

    @FXML
    private TableView<TransportCompany> transportCompanyTableView;

    @FXML
    private TableColumn<TransportCompany,String> transportCompanyNameColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    public void editCompany(CellEditEvent editEvent){
        TransportCompany company = transportCompanyTableView.getSelectionModel().getSelectedItem();
        company.setCompanyName(editEvent.getNewValue().toString());
    }

    public void createCompany(){
        TransportCompany newTransportCompany = new TransportCompany(companyNameTextField.getText());
        transportCompanyTableView.getItems().add(newTransportCompany);
        transportCompanies.add(newTransportCompany);
    }

    public void deleteCompany(){
        ObservableList<TransportCompany> transportCompanies;
        transportCompanies = transportCompanyTableView.getItems();
        int selectedTransportCompany = transportCompanyTableView.getSelectionModel().getFocusedIndex();
        transportCompanies.remove(selectedTransportCompany);
    }

    public void showCompanyView(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CompanyDetailsView.fxml"));
        Parent companyDetailsView = loader.load();
        Scene companyDetailsViewScene = new Scene(companyDetailsView);
        CompanyDetailsController controller = loader.getController();
        controller.initData(transportCompanies,transportCompanyTableView.getSelectionModel().getFocusedIndex());
        Stage companyDetailsWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        companyDetailsWindow.setScene(companyDetailsViewScene);

        companyDetailsWindow.show();
    }

    public void initData(List<TransportCompany> transportCompanies){
        this.transportCompanies = transportCompanies;
        transportCompanyNameColumn.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        transportCompanyTableView.setItems(FXCollections.observableArrayList(this.transportCompanies));
        transportCompanyTableView.getSelectionModel().selectFirst();
        transportCompanyTableView.setEditable(true);
        transportCompanyNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }
}


