package dao;

import model.Client;

public interface IClientDAO {
    public Client searchByIc(String icNumber);
    public boolean add(Client newClient);

}
