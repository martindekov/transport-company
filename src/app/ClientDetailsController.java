package app;

import app.client.CompanyClient;
import app.company.TransportCompany;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClientDetailsController {
    @FXML
    private Label customerName;
    void initialize() {}
    void initData(TransportCompany tc) {
        /*
         * Will be used to pass argument to this controller
        */
        /*
        CompanyClient cc = tc.getClient(0);
        cc.setClientName("NewName");
        tc.setClient(0, cc);
        customerName.setText(cc.getClientName());
         */
    }
}
