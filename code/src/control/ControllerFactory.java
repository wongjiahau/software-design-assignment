package control;

import boundary.ViewFactory;
import dao.IClientDAO;
import dao.IServiceRequestDAO;
import dao.ITechnicianDAO;

public class ControllerFactory {
    private ViewFactory viewFactory;
    private IClientDAO clientDAO;
    private ITechnicianDAO technicianDAO;
    private IServiceRequestDAO serviceRequestDAO;

    public ControllerFactory(
        ViewFactory viewFactory, 
        IClientDAO clientDAO, 
        ITechnicianDAO technicianDAO,
        IServiceRequestDAO serviceRequestDAO
    ) {
        super();
        this.viewFactory = viewFactory;
        this.clientDAO = clientDAO;
        this.technicianDAO = technicianDAO;
        this.serviceRequestDAO = serviceRequestDAO;
    }

    public RecordRequestController createRecordRequestController() {
        return new RecordRequestController(
            this.viewFactory.createRecordRequestView(),
            this.clientDAO, 
            this.serviceRequestDAO
        );
    }

    public AssignTechnicianController createAssignTechnicianController() {
        return new AssignTechnicianController(
            this.viewFactory.createAssignTechnicianView(),
            this.technicianDAO,
            this.serviceRequestDAO
        );
    }

    public RecordServiceChargeController createRecordServiceChargeController() {
        return new RecordServiceChargeController(
            this.viewFactory.createRecordServiceChargeView(),
            this.serviceRequestDAO
        );
    }

}
