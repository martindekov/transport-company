package sample.company;

import sample.client.CompanyClient;
import sample.vechicle.CompanyVehicle;
import sample.worker.CompanyWorker;

import java.util.ArrayList;
import java.util.List;

public class TransportCompany {
    private String _companyName;
    private List _companyClients;
    private List _companyVehicles;
    private List _companyWorkers;

    public TransportCompany(String companyName){
        _companyName = companyName;
        _companyClients = new ArrayList();
        _companyVehicles = new ArrayList();
        _companyWorkers = new ArrayList();
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
