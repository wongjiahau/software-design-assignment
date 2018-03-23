package boundary;

import libs.IStream;

public class RecordRequestView extends View {
    public RecordRequestView(IStream stream) {
        super(stream);
    }
    public String getIc() {
        return this.prompter.prompt(
            "Enter client's I/C number", 
            "\\d{6}-\\d{2}-\\d{4}", 
            "I/C should be in format of XXXXXX-XX-XXXX"
        );
    }

	public boolean displayClientNotExist() {
        this.stream.printLine("This client does not exist in the system.");
        String result = this.prompter.prompt(
            "Do you want to create a new client? (y/n)", 
            "^([yY]|[nN])$", 
            "Invalid choice."
        );
        return result.equalsIgnoreCase("y");
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

	public void displayServiceRequestCreated(String clientName, String dateTime, String serviceRequestId) {
        String message = "A new service request has been created for " 
                       + clientName + " at " + dateTime  + ".";
        message += "\nThe ID of this service request is " + serviceRequestId + ".";
        this.stream.printLine(message);
	}
	public boolean displayClientInfo() {
		return false;
	}


}