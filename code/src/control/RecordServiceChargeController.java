package control;

import java.util.ArrayList;

import boundary.RecordServiceChargeView;
import dao.IServiceRequestDAO;
import entity.ServiceRequest;

public class RecordServiceChargeController implements IController {
    private RecordServiceChargeView view;
    private IServiceRequestDAO serviceRequestDAO;
    public RecordServiceChargeController(RecordServiceChargeView view, IServiceRequestDAO serviceRequestDAO) {
        super();
        this.view = view;
        this.serviceRequestDAO = serviceRequestDAO;
    }

    @Override
    public boolean run() {
        ArrayList<ServiceRequest> onGoingServiceRequests = this.serviceRequestDAO.getOnGoing();
        if(onGoingServiceRequests.size() == 0) {
            this.view.displayNoOnGoingServiceRequest();
            return false;
        }
        int serviceRequestId                = this.view.displayServiceRequests(onGoingServiceRequests);
        ServiceRequest chosenServiceRequest = this.serviceRequestDAO.getById(serviceRequestId);
        double serviceCharge                = this.view.getServiceCharge();
        chosenServiceRequest.setCharge(serviceCharge);
        this.view.displaySuccess();
        return true;
    }

}
