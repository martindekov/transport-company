package app.client;

public class CompanyClient {
    private String clientName;

    public CompanyClient(String clientName){
        this.clientName = clientName;
    }

    public String getClientName(){
        return this.clientName;
    }

    public void setClientName(String clientName){
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return this.clientName;
    }
}
