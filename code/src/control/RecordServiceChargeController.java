package control;

import java.util.ArrayList;

import boundary.RecordServiceChargeView;
import boundary.ViewFactory;
import model.ServiceRequest;
import model.ServiceRequestStore;

public class RecordServiceChargeController implements IController {
	private RecordServiceChargeView view;
	private ServiceRequestStore serviceRequestStore;
	public RecordServiceChargeController(ViewFactory viewFactory, ServiceRequestStore serviceRequestStore) {
		super();
		this.view = viewFactory.createRecordServiceChargeView();
		this.serviceRequestStore = serviceRequestStore;
	}

	@Override
	public boolean run() {
		ArrayList<ServiceRequest> allAssignedServiceRequest = this.serviceRequestStore.getAssigned();
		int serviceRequestId = this.view.displayServiceRequests(allAssignedServiceRequest);
		ServiceRequest chosenServiceRequest = this.serviceRequestStore.getById(serviceRequestId);
		double serviceCharge = this.view.getServiceCharge();
		chosenServiceRequest.setCharge(serviceCharge);
		this.view.displaySuccess();
		return true;
	}

}
