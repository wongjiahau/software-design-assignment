package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import boundary.AssignTechnicianView;
import dao.IServiceRequestDAO;
import dao.ITechnicianDAO;
import entity.ServiceRequest;
import entity.Technician;

public class AssignTechnicianController implements IController {
	private AssignTechnicianView view;
	private ITechnicianDAO technicianDAO;
	private IServiceRequestDAO serviceRequestDAO;

	public AssignTechnicianController(
		AssignTechnicianView view,
		ITechnicianDAO technicianDAO,
		IServiceRequestDAO serviceRequestDAO
	) {
		super();
		this.view                = view;
		this.technicianDAO     = technicianDAO;
		this.serviceRequestDAO = serviceRequestDAO;
	}

	@Override
	public boolean run() throws Exception {
		Collection<ServiceRequest> pendingServiceRequests = this.serviceRequestDAO.getPending();
		if(pendingServiceRequests.size() == 0) {
			this.view.displayNoPendingServiceRequest();
			return false;
		}
		int serviceRequestId                              = this.view.displayServiceRequests(new ArrayList<ServiceRequest>(pendingServiceRequests));
		ServiceRequest chosenServiceRequest               = this.serviceRequestDAO.getById(serviceRequestId);
		Date dateOfService                                = this.view.getDateOfService();
		Collection<Technician> availableTechnicians       = this.technicianDAO.getAvailable(dateOfService);
		if(availableTechnicians.size() == 0) {
			this.view.displayNoAvailableTechnicians(dateOfService);
			return false;
		}
		String technicianId                               = this.view.displayTechnicians(new ArrayList<Technician>(availableTechnicians));
		Technician chosenTechnician                       = this.technicianDAO.getById(technicianId);
		chosenServiceRequest.setTechnician(chosenTechnician, dateOfService);
		this.view.displaySuccess(chosenServiceRequest);
		return true;
	}

}
