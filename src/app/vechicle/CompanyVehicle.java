package app.vechicle;

public class CompanyVehicle {
    private String vehicleName;

    public CompanyVehicle(String vehicleName){
        this.vehicleName = vehicleName;
    }

    public String getVehicleName(){
        return this.vehicleName;
    }

    public void setVehicleName(String clientName){
        this.vehicleName = clientName;
    }

    @Override
    public String toString() {
        return vehicleName;
    }
}
