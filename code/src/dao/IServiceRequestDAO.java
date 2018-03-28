package dao;

import java.util.ArrayList;
import java.util.Collection;

import model.ServiceRequest;

public interface IServiceRequestDAO {
    public boolean add(ServiceRequest newServiceRequest);
    public ServiceRequest getById(int id);
	public Collection<ServiceRequest> getPending();
	public ArrayList<ServiceRequest> getOnGoing();
}
