package control;

import boundary.ViewFactory;
import dao.IDAOFactory;

public class ControllerFactory {
    private ViewFactory viewFactory;
    private IDAOFactory daoFactory;

    public ControllerFactory( ViewFactory viewFactory, IDAOFactory daoFactory) {
        super();
        this.viewFactory = viewFactory;
        this.daoFactory = daoFactory;
    }

    public RecordRequestController createRecordRequestController() {
        return new RecordRequestController(
            this.viewFactory.createRecordRequestView(),
            this.daoFactory.getClientDAO(), 
            this.daoFactory.getServiceRequestDAO()
        );
    }

    public AssignTechnicianController createAssignTechnicianController() {
        return new AssignTechnicianController(
            this.viewFactory.createAssignTechnicianView(),
            this.daoFactory.getTechnicianDAO(),
            this.daoFactory.getServiceRequestDAO()
        );
    }

    public RecordServiceChargeController createRecordServiceChargeController() {
        return new RecordServiceChargeController(
            this.viewFactory.createRecordServiceChargeView(),
            this.daoFactory.getServiceRequestDAO()
        );
    }

}
