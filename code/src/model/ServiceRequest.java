package model;

import java.util.Date;

public class ServiceRequest {
    private String id;
    private Date dateOfRequest;
    private Date dateOfService;
    private double charge;

    public ServiceRequest(String id) {
        this.id = id;
    }

	public String getId() {
		return id;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
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
}
