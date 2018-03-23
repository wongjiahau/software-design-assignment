package model;

public class ClientStore extends Store<Client> {
    public ClientStore() {
        super();
    }

    public Client searchByIc(String icNumber) {
        return super.searchById(icNumber);
    }

    public boolean add(Client newClient) {
        return super.add(newClient.getIcNumber(), newClient);
    }
}
