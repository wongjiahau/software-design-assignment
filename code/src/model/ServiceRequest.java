package model;

import java.util.Date;

public class ServiceRequest {
    private String id;
    private Date dateOfRequest;
    private Date dateOfService;
	private double charge;
	private Client client;
	private Technician technician;

    public ServiceRequest(Client client) {
		this.client = client;
		this.dateOfRequest = new Date();
    }

	public String getId() {
		return id;
	}

	public String setId() {
		return id;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public Date getDateOfService() {
		return dateOfService;
	}

	public void setDateOfService(Date dateOfService) {
		this.dateOfService = dateOfService;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public Client getClient() {
		return client;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}
}