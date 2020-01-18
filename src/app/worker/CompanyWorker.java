package app.worker;

public class CompanyWorker {
    private String workerName;

    public CompanyWorker(String workerName){
        this.workerName = workerName;
    }

    public String getWorkerName(){
        return this.workerName;
    }

    public void setWorkerName(String clientName){
        this.workerName = clientName;
    }

    @Override
    public String toString() {
        return workerName;
    }
}
