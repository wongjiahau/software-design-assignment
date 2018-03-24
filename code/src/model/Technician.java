package model;

public class Technician extends Contactable {
    private String id;

    public Technician(String id, String name, String phoneNumber) {
        super(name, phoneNumber);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
