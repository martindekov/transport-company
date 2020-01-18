package app.order;

import app.client.CompanyClient;
import app.vechicle.CompanyVehicle;
import app.worker.CompanyWorker;

import java.util.Date;

public class TransportOrder {

    private CompanyVehicle vehicle;
    private CompanyWorker worker;
    private CompanyClient client;
    private long distance;
    private Date startDate;
    private Date endDate;
    private String beginLocation;
    private String endLocation;

    public TransportOrder(CompanyVehicle choseVehicle,
                          CompanyClient chosenClient,
                          CompanyWorker chosenWorker,
                          long chosenDistance,
                          Date chosenStartDate,
                          Date chosenEndDate,
                          String chosenBeginLocation,
                          String chosenEndLocation){

        vehicle = choseVehicle;
        client = chosenClient;
        worker = chosenWorker;
        distance = chosenDistance;
        startDate = chosenStartDate;
        endDate = chosenEndDate;
        beginLocation = chosenBeginLocation;
        endLocation = chosenEndLocation;
    }
}
