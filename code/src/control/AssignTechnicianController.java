package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import boundary.AssignTechnicianView;
import boundary.ViewFactory;
import model.ServiceRequest;
import model.ServiceRequestStore;
import model.Technician;
import model.TechnicianStore;

public class AssignTechnicianController implements IController {
	private AssignTechnicianView view;
	private TechnicianStore technicianStore;
	private ServiceRequestStore serviceRequestStore;

	public AssignTechnicianController(
		ViewFactory factory, 
		TechnicianStore technicianStore,
		ServiceRequestStore serviceRequestStore
	) {
		super();
		this.view                = factory.createAssignTechnicianView();
		this.technicianStore     = technicianStore;
		this.serviceRequestStore = serviceRequestStore;
	}

	@Override
	public boolean run() {
		Collection<ServiceRequest> pendingServiceRequests = this.serviceRequestStore.getPending();
		int serviceRequestId                              = this.view.displayServiceRequests(new ArrayList<ServiceRequest>(pendingServiceRequests));
		ServiceRequest chosenServiceRequest               = this.serviceRequestStore.getById(serviceRequestId);
		Collection<Technician> allTehnicians              = this.technicianStore.getAll();
		String technicianId                               = this.view.displayTechnicians(new ArrayList<Technician>(allTehnicians));
		Technician chosenTechnician                       = this.technicianStore.getById(technicianId);
		Date dateOfService                                = this.view.getDateOfService();
		chosenServiceRequest.setTechnician(chosenTechnician);
		chosenServiceRequest.setDateOfService(dateOfService);
		this.view.displaySuccess(chosenServiceRequest);
		return true;
	}

}
