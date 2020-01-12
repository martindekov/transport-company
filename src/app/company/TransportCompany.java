package app.company;

import app.client.CompanyClient;
import app.vechicle.CompanyVehicle;
import app.worker.CompanyWorker;

import java.util.ArrayList;
import java.util.List;

public class TransportCompany {
    private String companyName;
    private List _companyClients;
    private List _companyVehicles;
    private List _companyWorkers;

    public TransportCompany(String companyName){
        this.companyName = companyName;
        _companyClients = new ArrayList();
        _companyVehicles = new ArrayList();
        _companyWorkers = new ArrayList();
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public void addClient(String clientName){
        int clientID = _companyClients.size();
        _companyClients.add(new CompanyClient(clientID,clientName));
    }

    public void addVehicle(String vehicleName){
        int vehicleID = _companyVehicles.size();
        _companyVehicles.add(new CompanyVehicle(vehicleID,vehicleName));
    }

    public void addWorker(String workerName){
        int workerID = _companyClients.size();
        _companyWorkers.add(new CompanyWorker(workerID,workerName));
    }

}
