package mocks;

import java.util.Date;

import dao.IClientDAO;
import dao.IDAOInitiator;
import dao.IServiceRequestDAO;
import dao.ITechnicianDAO;
import model.Client;
import model.ServiceRequest;
import model.Technician;

public class MockDAOInitiator implements IDAOInitiator {
    private Client client1;
    private Client client2;
    private Client client3;
    private Technician technician1;
    private Technician technician2;

    public MockDAOInitiator() {
        super();
        this.client1 = new Client("960819-43-5437", "Ali", "011-8274382", "17-3-8, Winner Court B, Desa Petaling");
        this.client2 = new Client("971231-12-1234", "John", "012-3456789", "Lot 10, Jln Redang, Bukit Serdang");
        this.client3 = new Client("880808-08-8888", "Ah Huat", "018-8888888", "18-8-8, Taman Gembira, OUG");
    }

    public IClientDAO getClientDAO() {
        MockClientDAO clientDAO = new MockClientDAO();
        clientDAO.add(this.client1);
        clientDAO.add(this.client2);
        return clientDAO;
    }

    public ITechnicianDAO getTechnicianDAO() {
        this.technician1 = new Technician("T0001", "Bob Chan", "014-5673829");
        this.technician2 = new Technician("T0002", "Bob Connor", "019-8765432");
        MockTechnicianDAO technicianDAO = new MockTechnicianDAO();
        technicianDAO.add(technician1);
        technicianDAO.add(technician2);
        return technicianDAO;
    }

    public IServiceRequestDAO getServiceRequestDAO() {
        MockServiceRequestDAO serviceRequestDAO = new MockServiceRequestDAO();
        ServiceRequest serviceRequest1          = new ServiceRequest(this.client1);
        ServiceRequest serviceRequest2          = new ServiceRequest(this.client2);
        ServiceRequest serviceRequest3          = new ServiceRequest(this.client3);
        serviceRequest2.setTechnician(this.technician1, new Date());
        serviceRequestDAO.add(serviceRequest1);
        serviceRequestDAO.add(serviceRequest2);
        serviceRequestDAO.add(serviceRequest3);
        return serviceRequestDAO;
    }
}
