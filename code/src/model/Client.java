package model;

public class Client extends Contactable {
    private String icNumber;
    private String address;

    public Client(String icNumber) {
        this.icNumber = icNumber;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
