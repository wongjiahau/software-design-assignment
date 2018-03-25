package mocks;

import java.util.Date;

import model.Client;
import model.ClientStore;
import model.IStoreFactory;
import model.ServiceRequest;
import model.ServiceRequestStore;
import model.Technician;
import model.TechnicianStore;

public class MockStoreFactory implements IStoreFactory {
    private Client client1;
    private Client client2;
    private Client client3;
    private Technician technician1;
    private Technician technician2;

    public MockStoreFactory() {
        super();
        this.client1 = new Client("960819-43-5437", "Ali", "011-8274382", "17-3-8, Winner Court B, Desa Petaling");
        this.client2 = new Client("971231-12-1234", "John", "012-3456789", "Lot 10, Jln Redang, Bukit Serdang");
        this.client3 = new Client("880808-08-8888", "Ah Huat", "018-8888888", "18-8-8, Taman Gembira, OUG");
    }

    public ClientStore createClientStore() {
        ClientStore clientStore = new ClientStore();
        clientStore.add(this.client1);
        clientStore.add(this.client2);
        return clientStore;
    }

    public TechnicianStore createTechnicianStore() {
        this.technician1 = new Technician("T0001", "Bob Chan", "014-5673829");
        this.technician2 = new Technician("T0002", "Bob Connor", "019-8765432");
        TechnicianStore technicianStore = new TechnicianStore();
        technicianStore.add(technician1);
        technicianStore.add(technician2);
        return technicianStore;
    }

    public ServiceRequestStore createServiceRequestStore() {
        ServiceRequestStore serviceRequestStore = new ServiceRequestStore();
        ServiceRequest serviceRequest1          = new ServiceRequest(this.client1);
        ServiceRequest serviceRequest2          = new ServiceRequest(this.client2);
        ServiceRequest serviceRequest3          = new ServiceRequest(this.client3);
        serviceRequest2.setTechnician(this.technician1, new Date());
        serviceRequestStore.add(serviceRequest1);
        serviceRequestStore.add(serviceRequest2);
        serviceRequestStore.add(serviceRequest3);
        return serviceRequestStore;
    }
}
