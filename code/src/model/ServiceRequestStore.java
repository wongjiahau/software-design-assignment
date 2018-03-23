package model;


public class ServiceRequestStore extends Store<ServiceRequest> {
    public ServiceRequestStore() {
        super();
    }

    public boolean add(ServiceRequest newServiceRequest) {
        String hash = String.valueOf(newServiceRequest.hashCode());
        return super.add(hash, newServiceRequest);
    }

    public ServiceRequest getLastInserted() {
        return super.getLastInserted();
    }

}