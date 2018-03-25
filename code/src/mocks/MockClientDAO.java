package mocks;

import dao.IClientDAO;
import model.Client;

public class MockClientDAO extends MockDAO<Client> implements IClientDAO {
    public MockClientDAO() {
        super();
    }

    public Client searchByIc(String icNumber) {
        return super.getById(icNumber);
    }

    public boolean add(Client newClient) {
        return super.add(newClient.getIcNumber(), newClient);
    }
}
