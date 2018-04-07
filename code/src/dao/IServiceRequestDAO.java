package dao;

import java.util.ArrayList;

import entity.ServiceRequest;

public interface IServiceRequestDAO {
    public boolean add(ServiceRequest newServiceRequest);
    public ServiceRequest getById(int id);
	public ArrayList<ServiceRequest> getPending();
	public ArrayList<ServiceRequest> getOnGoing();
}
