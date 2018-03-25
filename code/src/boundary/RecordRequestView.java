package boundary;

import libs.IStream;
import model.Client;
import model.ServiceRequest;

public class RecordRequestView extends View {
    public RecordRequestView(IStream stream) {
        super(stream);
    }
    public String getIc() {
        super.displayTitle("record request for service");
        return this.prompter.prompt(
            "Enter client's I/C number", 
            "\\d{6}-\\d{2}-\\d{4}", 
            "I/C should be in format of XXXXXX-XX-XXXX"
        );
    }

	public boolean displayClientNotExist() {
        this.stream.printLine("This client does not exist in the system.");
        return this.prompter.promptYesNo(
            "Do you want to create a new client?"
        );
	}

	public String getName() {
		return this.prompter.prompt(
            "Enter name", 
            "^([a-z]|[A-Z]|[ '.,])+$", 
            "Name should not contain weird symbols."
        );
	}

	public String getPhoneNum() {
        return this.prompter.prompt(
            "Enter phone number",
            "^[0-9]{3}-[0-9]{7}[0-9]?$",
             "Phone number must be in format of XXX-XXXXXXX"
        );
	}

	public String getAddress() {
        return this.prompter.prompt(
            "Enter address",
            ".*",
             ""
        );
	}

	public void displayServiceRequestCreated(ServiceRequest serviceRequest) {
        String clientName    = serviceRequest.getClient().getName();
        String dateTime      = serviceRequest.getDateOfRequest().toString();
        int serviceRequestId = serviceRequest.getId();
        String message = "A new service request has been created for " 
                       + clientName + " at " + dateTime  + ".";
        message += "\nThe ID of this service request is " + serviceRequestId + ".";
        this.stream.printLine(message);
    }

	public boolean displayClientInfo(Client client) {
        return this.prompter.promptYesNo(
            "The I/C matched a client named '" + client.getName() + "'.\n", 
            "Do you want to create a new service request for this client? "
        );
	}


}
