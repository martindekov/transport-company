package app.company;

import app.client.CompanyClient;
import app.order.TransportOrder;
import app.vechicle.CompanyVehicle;
import app.worker.CompanyWorker;

import java.util.ArrayList;
import java.util.List;

public class TransportCompany {
    private String companyName;
    private List companyClients;
    private List companyVehicles;
    private List companyWorkers;
    private List companyOrders;

    public TransportCompany(String companyName) {
        this.companyName = companyName;
        this.companyClients = new ArrayList();
        this.companyVehicles = new ArrayList();
        this.companyWorkers = new ArrayList();
        this.companyOrders = new ArrayList();
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public TransportCompany addDummyClient(String clientName) {
        this.companyClients.add(new CompanyClient(clientName));
        return this;
    }

    public void addClient(CompanyClient newClient) {
        this.companyClients.add(newClient);
    }

    public void editClient(CompanyClient companyClient, int clientIndex) {
        this.companyClients.set(clientIndex, companyClient);
    }

    public void addVehicle(CompanyVehicle newVehicle) {
        companyVehicles.add(newVehicle);
    }

    public void addWorker(CompanyWorker newWorker) {
        companyWorkers.add(newWorker);
    }

    public void addOrder(TransportOrder newOrder){
        this.companyOrders.add(newOrder);
    }

    public List<CompanyClient> getCompanyClients() {
        return this.companyClients;
    }

    public List<CompanyWorker> getCompanyWorkers() { return this.companyWorkers; }

    public List<CompanyVehicle> getCompanyVehicles() { return this.companyVehicles; }

    public void removeVehicle(int oldVehicleIndex) {
        companyVehicles.remove(oldVehicleIndex);
    }

    public void removeWorker(int oldWorkerIndex) {
        companyWorkers.remove(oldWorkerIndex);
    }

    public void removeClient(int clientPosition) {
        this.companyClients.remove(clientPosition);
    }
}
