package control;

import boundary.ViewFactory;
import model.ClientStore;
import model.ServiceRequestStore;
import model.TechnicianStore;

public class ControllerFactory {
    private ViewFactory viewFactory;
    private ClientStore clientStore;
    private TechnicianStore technicianStore;
    private ServiceRequestStore serviceRequestStore;

    public ControllerFactory(
        ViewFactory viewFactory, 
        ClientStore clientStore, 
        TechnicianStore technicianStore,
        ServiceRequestStore serviceRequestStore
    ) {
        super();
        this.viewFactory = viewFactory;
        this.clientStore = clientStore;
        this.technicianStore = technicianStore;
        this.serviceRequestStore = serviceRequestStore;
    }

    public RecordRequestController createRecordRequestController() {
        return new RecordRequestController(
            this.viewFactory,
            this.clientStore, 
            this.serviceRequestStore
        );
    }

    public AssignTechnicianController createAssignTechnicianController() {
        return new AssignTechnicianController(
            this.viewFactory,
            this.technicianStore,
            this.serviceRequestStore
        );
    }

    public RecordServiceChargeController createRecordServiceChargeController() {
        return new RecordServiceChargeController(
            this.viewFactory,
            this.serviceRequestStore
        );
    }

}
