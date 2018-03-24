package control;

import java.util.ArrayList;

import boundary.RecordServiceChargeView;
import model.ServiceRequest;
import model.ServiceRequestStore;

public class RecordServiceChargeController implements IController {
	private RecordServiceChargeView view;
	private ServiceRequestStore serviceRequestStore;
	public RecordServiceChargeController(RecordServiceChargeView view, ServiceRequestStore serviceRequestStore) {
		super();
		this.view = view;
		this.serviceRequestStore = serviceRequestStore;
	}

	@Override
	public boolean run() {
		ArrayList<ServiceRequest> allAssignedServiceRequest = this.serviceRequestStore.getAssigned();
		if(allAssignedServiceRequest.size() == 0) {
			this.view.displayNoAssignedServiceRequest();
			return false;
		}
		int serviceRequestId                = this.view.displayServiceRequests(allAssignedServiceRequest);
		ServiceRequest chosenServiceRequest = this.serviceRequestStore.getById(serviceRequestId);
		double serviceCharge                = this.view.getServiceCharge();
		chosenServiceRequest.setCharge(serviceCharge);
		this.view.displaySuccess();
		return true;
	}

}
