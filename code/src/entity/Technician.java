package entity;

import java.util.ArrayList;
import java.util.Date;

public class Technician extends Contactable {
    private final int MAX_NUM_OF_SERVICE_PER_DAY = 1;
    private String id;
    private ArrayList<ServiceRequest> serviceRequests;

    public Technician(String id, String name, String phoneNumber) {
        super(name, phoneNumber);
        this.id = id;
        this.serviceRequests = new ArrayList<ServiceRequest>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvailableOn(Date date) {
        int count = 0;
        for (ServiceRequest serviceRequest : this.serviceRequests) {
            long oneDay = 24 * 60 * 60 * 1000;
            long d1 = serviceRequest.getDateOfService().getTime() / oneDay;
            long d2 = date.getTime() / oneDay;
            if (d1 == d2) {
                count++;
            }
        }
        return count < MAX_NUM_OF_SERVICE_PER_DAY;
    }

    public void addServiceRequest(ServiceRequest newServiceRequest) throws Exception {
        if (newServiceRequest.getTechnician() != this) {
            throw new Exception("You cannot assigned a service request to an unrelated technician.");
        }
        this.serviceRequests.add(newServiceRequest);
    }
}
