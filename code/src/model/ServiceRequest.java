package model;

import java.util.Date;

public class ServiceRequest {
    private int id;
    private Date dateOfRequest;
    private Date dateOfService;
	private double charge;
	private Client client;
	private Technician technician;

    public ServiceRequest(Client client) {
		this.client = client;
		this.dateOfRequest = new Date();
		this.charge = 0;
	}
	
    /**
     * Pending service request are those that have yet to be assign a technician
     */
	public boolean isPending() {
		return this.getTechnician() == null;
	}

    /**
     * Assigned service request are those that have a techinician associated but no service charge recorded yet
     */
	public boolean isAssigned() {
		return !this.isPending() && this.charge == 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;	
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public Date getDateOfService() {
		return dateOfService;
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

	public void setTechnician(Technician technician, Date dateOfService) {
		this.technician = technician;
		this.dateOfService = dateOfService;
	}
}
