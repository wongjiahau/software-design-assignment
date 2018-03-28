package boundary;

import java.util.ArrayList;

import libs.IStream;
import model.ServiceRequest;

public class RecordServiceChargeView extends View {
    public RecordServiceChargeView(IStream stream) {
        super(stream);
    }

	public int displayServiceRequests(ArrayList<ServiceRequest> serviceRequests) {
        ArrayList<String> rows = new ArrayList<String>();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (ServiceRequest sr: serviceRequests) {
            ids.add(sr.getId());
            rows.add(
                sr.getId() + "," + 
                sr.getDateOfService() + "," + 
                sr.getClient().getName() + "," + 
                sr.getTechnician().getName()
            );
        }
        super.displayTable("ID,DATE-OF-SERVICE,CLIENT-NAME,TECHNICIAN-NAME", rows);
        return super.prompter.promptForIntegerId("\nEnter ID of desired service request", ids);
	}

	public double getServiceCharge() {
        return super.prompter.promptDouble("Enter service charge");
	}

	public void displaySuccess() {
        this.stream.printLine("The entered service charge had been recorded\nfor the chosen service request");
        this.stream.pressAnyKeyToContinue();
	}

	public void displayNoAssignedServiceRequest() {
        this.stream.printLine("There are no on going service request.");
        this.stream.pressAnyKeyToContinue();
	}
}
