package dao;

public interface IDAOFactory {

    IClientDAO getClientDAO();

    ITechnicianDAO getTechnicianDAO();

    IServiceRequestDAO getServiceRequestDAO();
}