package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import boundary.AssignTechnicianView;
import boundary.ViewFactory;
import model.ServiceRequest;
import model.ServiceRequestStore;

public class AssignTechnicianController implements IController {
	private AssignTechnicianView view;
	private ServiceRequestStore serviceRequestStore;
	public AssignTechnicianController(ViewFactory factory, ServiceRequestStore serviceRequestStore) {
		super();
		this.view = factory.createAssignTechnicianView();
		this.serviceRequestStore = serviceRequestStore;
	}

	@Override
	public boolean run() {
		Collection<ServiceRequest> allServiceRequests = this.serviceRequestStore.getAll();
		this.view.displayAllServiceRequests(new ArrayList<ServiceRequest>(allServiceRequests) );
		return true;
	}

}
