package mocks;

import java.util.Date;

import dao.IClientDAO;
import dao.IDAOFactory;
import dao.IServiceRequestDAO;
import dao.ITechnicianDAO;
import entity.Client;
import entity.ServiceRequest;
import entity.Technician;

public class MockDAOFactory implements IDAOFactory {
    private IClientDAO clientDAO;
    private ITechnicianDAO technicianDAO;
    private IServiceRequestDAO serviceRequestDAO;
    public MockDAOFactory() {
        super();
        Client client1 = new Client("960819-43-5437", "Ali", "011-8274382", "17-3-8, Winner Court B, Desa Petaling");
        Client client2 = new Client("971231-12-1234", "John", "012-3456789", "Lot 10, Jln Redang, Bukit Serdang");
        Client client3 = new Client("880808-08-8888", "Ah Huat", "018-8888888", "18-8-8, Taman Gembira, OUG");
        this.clientDAO = new MockClientDAO();
        this.clientDAO.add(client1);
        this.clientDAO.add(client2);
        Technician technician1 = new Technician("T0001", "Bob Chan", "014-5673829");
        Technician technician2 = new Technician("T0002", "Bob Connor", "019-8765432");
        this.technicianDAO = new MockTechnicianDAO();
        technicianDAO.add(technician1);
        technicianDAO.add(technician2);
        this.serviceRequestDAO = new MockServiceRequestDAO();
        ServiceRequest serviceRequest1          = new ServiceRequest(client1);
        ServiceRequest serviceRequest2          = new ServiceRequest(client2);
        ServiceRequest serviceRequest3          = new ServiceRequest(client3);
        serviceRequest2.setTechnician(technician1, new Date());
        serviceRequestDAO.add(serviceRequest1);
        serviceRequestDAO.add(serviceRequest2);
        serviceRequestDAO.add(serviceRequest3);
    }

    public IClientDAO getClientDAO() {
        return this.clientDAO;
    }

    public ITechnicianDAO getTechnicianDAO() {
        return this.technicianDAO;
    }

    public IServiceRequestDAO getServiceRequestDAO() {
        return this.serviceRequestDAO;
    }
}
