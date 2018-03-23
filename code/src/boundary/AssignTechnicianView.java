package boundary;

import java.util.ArrayList;

import libs.IStream;
import model.ServiceRequest;

public class AssignTechnicianView extends View {
    public AssignTechnicianView(IStream stream) {
        super(stream);
    }

    public void displayAllServiceRequests(ArrayList<ServiceRequest> allServiceRequests) {
        super.displayTitle("Assign technician to service request");
        ArrayList<String> rows = new ArrayList<String>();
        for (ServiceRequest sr : allServiceRequests) {
            rows.add(
                sr.getId() + "," + 
                sr.getDateOfRequest() + "," + 
                sr.getClient().getName() + "," + 
                sr.getClient().getIcNumber()
            );
        }
        super.displayTable("ID,DATE-OF-REQUEST,NAME,IC", rows);
    }

}
