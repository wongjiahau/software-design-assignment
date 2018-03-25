package control;

import boundary.RecordRequestView;
import dao.IClientDAO;
import dao.IServiceRequestDAO;
import model.Client;
import model.ServiceRequest;

public class RecordRequestController implements IController {
	private RecordRequestView view;
	private IClientDAO clientDAO;
	private IServiceRequestDAO serviceRequestDAO;

	public RecordRequestController(
		RecordRequestView view, 
		IClientDAO clientDAO, 
		IServiceRequestDAO serviceRequestDAO
	) {
		super();
		this.view                = view;
		this.clientDAO         = clientDAO;
		this.serviceRequestDAO = serviceRequestDAO;
	}

	@Override
	public boolean run() {
		String clientIc = this.view.getIc();
		Client client = this.clientDAO.searchByIc(clientIc);
		if (client == null) {
			if (!this.view.displayClientNotExist()) {
				return false;
			}
			String name = this.view.getName();
			String phoneNum = this.view.getPhoneNum();
			String address = this.view.getAddress();
			client = new Client(clientIc, name, phoneNum, address);
			this.clientDAO.add(client);
		} else if (!this.view.displayClientInfo(client)) {
			return false;
		}
		ServiceRequest newServiceRequest = new ServiceRequest(client);
		this.serviceRequestDAO.add(newServiceRequest);
		this.view.displayServiceRequestCreated(newServiceRequest);
		return true;
	}

}
