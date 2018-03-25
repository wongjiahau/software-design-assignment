package dao;

public interface IDAOInitiator {

    IClientDAO getClientDAO();

    ITechnicianDAO getTechnicianDAO();

    IServiceRequestDAO getServiceRequestDAO();
}