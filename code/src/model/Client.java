package model;

public class Client extends Contactable {
    private String icNumber;
    private String address;

    public Client(String icNumber, String name, String phoneNumber, String address) {
        super(name, phoneNumber);
        this.icNumber = icNumber;
        this.address = address;
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
