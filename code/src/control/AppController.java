package control;

import boundary.AppUi;
import model.Client;
import model.ClientStore;
import model.ServiceRequest;
import model.ServiceRequestStore;

public class AppController {
    private ClientStore clientStore;
    private ServiceRequestStore serviceRequestStore;
    private AppUi ui;
    public AppController(AppUi ui, ClientStore clientStore, ServiceRequestStore serviceRequestStore) {
        this.clientStore = clientStore;
        this.serviceRequestStore = serviceRequestStore;
        this.ui = ui;
    }

    public boolean run() {
        String choice = this.ui.displayMenu();
        switch (choice) {
        case "1":
            this.recordRequestForService();
            break;
        case "2":
            this.assignTechnician();
            break;
        case "3":
            this.recordServiceCharge();
            break;
        case "4":
            this.ui.displayGoodBye();
            return false;
        }
        return true;
    }

    private void recordRequestForService() {
        String clientIc = this.ui.getIc();
        Client client = this.clientStore.searchByIc(clientIc);
        if(client == null) {
            this.ui.displayClientNotExist();
            String name = this.ui.getName();
            String phoneNum = this.ui.getPhoneNum();
            String address = this.ui.getAddress();
            client = new Client(clientIc, name, phoneNum, address);
            this.clientStore.add(client);
        }
        ServiceRequest newServiceRequest = new ServiceRequest(client);
        this.serviceRequestStore.add(newServiceRequest);
        this.ui.displayServiceRequestCreated(
            client.getName(), 
            newServiceRequest.getDateOfRequest().toString(), 
            newServiceRequest.getId()
        );
    }

    private void assignTechnician() {
    }

    private void recordServiceCharge() {
    }
}
