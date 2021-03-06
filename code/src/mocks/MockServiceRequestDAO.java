package mocks;

import java.util.ArrayList;
import java.util.Collection;

import dao.IServiceRequestDAO;
import entity.ServiceRequest;

public class MockServiceRequestDAO extends MockDAO<ServiceRequest> implements IServiceRequestDAO {
    private static int nextId = 0;

    public MockServiceRequestDAO() {
        super();
    }

    public boolean add(ServiceRequest newServiceRequest) {
        int hash = MockServiceRequestDAO.nextId++;
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

    public ArrayList<ServiceRequest> getPending() {
        ArrayList<ServiceRequest> allServiceRequests = new ArrayList<ServiceRequest>(this.getAll());
        ArrayList<ServiceRequest> pendingServiceRequests = new ArrayList<ServiceRequest>();
        for (int i = 0; i < allServiceRequests.size(); i++) {
            ServiceRequest serviceRequest = allServiceRequests.get(i);
            if(serviceRequest.isPending()) {
                pendingServiceRequests.add(serviceRequest);
            }
        }
        return pendingServiceRequests;
    }

    public ArrayList<ServiceRequest> getOnGoing() {
        ArrayList<ServiceRequest> allServiceRequests = new ArrayList<ServiceRequest>(this.getAll());
        ArrayList<ServiceRequest> onGoingServiceRequests = new ArrayList<ServiceRequest>();
        for (int i = 0; i < allServiceRequests.size(); i++) {
            ServiceRequest serviceRequest = allServiceRequests.get(i);
            if(serviceRequest.isOnGoing()) {
                onGoingServiceRequests.add(serviceRequest);
            }
        }
        return onGoingServiceRequests;
    }

}