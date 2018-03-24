package mocks;

import model.Client;
import model.ClientStore;
import model.ServiceRequest;
import model.ServiceRequestStore;
import model.Technician;
import model.TechnicianStore;

public class MockStoreFactory {
    private Client client1;
    private Client client2;
    private Technician technician1;
    private Technician technician2;

    public MockStoreFactory() {
        super();
        this.client1 = new Client("960819-43-5437", "Ali", "011-8274382", "17-3-8, Winner Court B, Desa Petaling");
        this.client2 = new Client("971231-12-1234", "John", "012-3456789", "Lot 10, Jln Redang, Bukit Serdang");
    }

    public ClientStore createMockClientStore() {
        ClientStore clientStore = new ClientStore();
        clientStore.add(this.client1);
        clientStore.add(this.client2);
        return clientStore;
    }

    public TechnicianStore createMockTechnicianStore() {
        this.technician1 = new Technician("T0001", "Bob Chan", "014-5673829");
        this.technician2 = new Technician("T0002", "Bob Connor", "019-8765432");
        TechnicianStore technicianStore = new TechnicianStore();
        technicianStore.add(technician1);
        technicianStore.add(technician2);
        return technicianStore;
    }

    public ServiceRequestStore createMockServiceRequestStore() {
        ServiceRequestStore serviceRequestStore = new ServiceRequestStore();
        serviceRequestStore.add(new ServiceRequest(this.client1));
        serviceRequestStore.add(new ServiceRequest(this.client2));
        return serviceRequestStore;
    }
}
