package control;

import boundary.RecordRequestView;
import boundary.ViewFactory;
import model.Client;
import model.ClientStore;
import model.ServiceRequest;
import model.ServiceRequestStore;

public class RecordRequestController implements IController {
	private RecordRequestView view;
	private ClientStore clientStore;
	private ServiceRequestStore serviceRequestStore;

	public RecordRequestController(ViewFactory viewFactory, ClientStore clientStore, ServiceRequestStore serviceRequestStore) {
		super();
		this.view = viewFactory.createRecordRequestView();
		this.clientStore = clientStore;
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
		} else if (this.view.displayClientInfo()) {
			return true;
		}
		ServiceRequest newServiceRequest = new ServiceRequest(client);
		this.serviceRequestStore.add(newServiceRequest);
		this.view.displayServiceRequestCreated(client.getName(), newServiceRequest.getDateOfRequest().toString(),
				newServiceRequest.getId());
		return true;
	}

}