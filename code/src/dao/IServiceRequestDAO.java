package dao;

import java.util.ArrayList;
import java.util.Collection;

import entity.ServiceRequest;

public interface IServiceRequestDAO {
    public boolean add(ServiceRequest newServiceRequest);
    public ServiceRequest getById(int id);
	public Collection<ServiceRequest> getPending();
	public ArrayList<ServiceRequest> getOnGoing();
}
