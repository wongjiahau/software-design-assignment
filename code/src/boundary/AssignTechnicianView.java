package boundary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.ServiceRequest;
import entity.Technician;
import libs.IStream;

public class AssignTechnicianView extends View {
    public AssignTechnicianView(IStream stream) {
        super(stream);
    }

    public int displayServiceRequests(ArrayList<ServiceRequest> serviceRequests) {
        super.displayTitle("Assign technician to pending service request");
        ArrayList<String> rows = new ArrayList<String>();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (ServiceRequest sr : serviceRequests) {
            ids.add(sr.getId());
            rows.add(
                sr.getId() + "," + 
                sr.getDateOfRequest() + "," + 
                sr.getClient().getName() + "," + 
                sr.getClient().getIcNumber()
            );
        }
        super.displayTable("ID,DATE-OF-REQUEST,CLIENT-NAME,CLIENT-IC", rows);
        return super.prompter.promptForIntegerId("\nEnter ID of desired service request", ids);
    }

	public String displayTechnicians(ArrayList<Technician> technicians) {
        ArrayList<String> rows = new ArrayList<String>();
        ArrayList<String> ids = new ArrayList<String>();
        for (Technician t: technicians) {
            ids.add(t.getId());
            rows.add(
                t.getId() + "," + 
                t.getName() + "," + 
                t.getPhoneNumber()
            );
        }
        super.displayTable("ID,NAME,PHONE-NUMBER", rows);
        return super.prompter.promptForStringId("\nEnter ID of technician to be assigned", ids);
	}

	public Date getDateOfService() {
        return super.prompter.promptDate("Enter date of service");
	}

	public void displaySuccess(ServiceRequest serviceRequest) {
        super.stream.printLine(
            "Technician " + 
            serviceRequest.getTechnician().getId() +
            " (" + serviceRequest.getTechnician().getName() + ")" +
            " has been assigned to service request " + 
            serviceRequest.getId() + "."
        ); 

        super.stream.printLine(
            "The date of service is set to " + 
            new SimpleDateFormat("yyyy-MM-dd").format(serviceRequest.getDateOfService()) +
            "."
        );
        super.stream.pressAnyKeyToContinue();
	}

	public void displayNoPendingServiceRequest() {
        super.stream.printLine("There are no pending service request.");
        super.stream.pressAnyKeyToContinue();
	}

}
