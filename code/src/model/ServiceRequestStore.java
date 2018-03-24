package model;

import java.util.ArrayList;
import java.util.Collection;

public class ServiceRequestStore extends Store<ServiceRequest> {
    private static int nextId = 0;

    public ServiceRequestStore() {
        super();
    }

    public boolean add(ServiceRequest newServiceRequest) {
        int hash = ServiceRequestStore.nextId++;
        newServiceRequest.setId(hash);
        return super.add(String.valueOf(hash), newServiceRequest);
    }

    public ServiceRequest getById(int id) {
        return super.getById(String.valueOf(id));
    }

    public ServiceRequest getLastInserted() {
        return super.getLastInserted();
    }

    public Collection<ServiceRequest> getAll() {
        return super.getAll();
    }

	public Collection<ServiceRequest> getPending() {
        ArrayList<ServiceRequest> allServiceRequests = new ArrayList<ServiceRequest>(this.getAll());
        ArrayList<ServiceRequest> pendingServiceRequests = new ArrayList<ServiceRequest>();
        for (int i = 0; i < allServiceRequests.size(); i++) {
            ServiceRequest serviceRequest = allServiceRequests.get(i);
            if(serviceRequest.getTechnician() == null) {
                pendingServiceRequests.add(serviceRequest);
            }
            
        }
		return pendingServiceRequests;
	}

}