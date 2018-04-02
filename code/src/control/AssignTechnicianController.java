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
	public boolean run() {
		Collection<ServiceRequest> pendingServiceRequests = this.serviceRequestDAO.getPending();
		if(pendingServiceRequests.size() == 0) {
			this.view.displayNoPendingServiceRequest();
			return false;
		}
		int serviceRequestId                              = this.view.displayServiceRequests(new ArrayList<ServiceRequest>(pendingServiceRequests));
		ServiceRequest chosenServiceRequest               = this.serviceRequestDAO.getById(serviceRequestId);
		Collection<Technician> allTehnicians              = this.technicianDAO.getAll();
		String technicianId                               = this.view.displayTechnicians(new ArrayList<Technician>(allTehnicians));
		Technician chosenTechnician                       = this.technicianDAO.getById(technicianId);
		Date dateOfService                                = this.view.getDateOfService();
		chosenServiceRequest.setTechnician(chosenTechnician, dateOfService);
		this.view.displaySuccess(chosenServiceRequest);
		return true;
	}

}
