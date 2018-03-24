package control;

import boundary.RecordRequestView;
import model.Client;
import model.ClientStore;
import model.ServiceRequest;
import model.ServiceRequestStore;

public class RecordRequestController implements IController {
	private RecordRequestView view;
	private ClientStore clientStore;
	private ServiceRequestStore serviceRequestStore;

	public RecordRequestController(
		RecordRequestView view, 
		ClientStore clientStore, 
		ServiceRequestStore serviceRequestStore
	) {
		super();
		this.view                = view;
		this.clientStore         = clientStore;
		this.serviceRequestStore = serviceRequestStore;
	}

	@Override
	public boolean run() {
		String clientIc = this.view.getIc();
		Client client = this.clientStore.searchByIc(clientIc);
		if (client == null) {
			if (!this.view.displayClientNotExist()) {
				return false;
			}
			String name = this.view.getName();
			String phoneNum = this.view.getPhoneNum();
			String address = this.view.getAddress();
			client = new Client(clientIc, name, phoneNum, address);
			this.clientStore.add(client);
		} else if (!this.view.displayClientInfo(client.getName())) {
			return false;
		}
		ServiceRequest newServiceRequest = new ServiceRequest(client);
		this.serviceRequestStore.add(newServiceRequest);
		this.view.displayServiceRequestCreated(newServiceRequest);
		return true;
	}

}
