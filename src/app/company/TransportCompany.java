package app.company;

import app.client.CompanyClient;
import app.vechicle.CompanyVehicle;
import app.worker.CompanyWorker;

import java.util.ArrayList;
import java.util.List;

public class TransportCompany {
    private String companyName;
    private List companyClients;
    private List _companyVehicles;
    private List _companyWorkers;

    public TransportCompany(String companyName){
        this.companyName = companyName;
        this.companyClients = new ArrayList();
        _companyVehicles = new ArrayList();
        _companyWorkers = new ArrayList();
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public TransportCompany addDummyClient(String clientName){
        this.companyClients.add(new CompanyClient(clientName));
        return this;
    }

    public void addClient(CompanyClient newClient){
        this.companyClients.add(newClient);
    }

    public void removeClient(int clientPosition){
        this.companyClients.remove(clientPosition);
    }

    public void editClient(CompanyClient companyClient, int clientIndex){
        this.companyClients.set(clientIndex,companyClient);
    }

    public void addVehicle(String vehicleName){
        int vehicleID = _companyVehicles.size();
        _companyVehicles.add(new CompanyVehicle(vehicleID,vehicleName));
    }

    public void addWorker(String workerName){
        int workerID = this._companyWorkers.size();
        _companyWorkers.add(new CompanyWorker(workerID,workerName));
    }

    public List<CompanyClient> getCompanyClients() {
        return this.companyClients;
    }
}
