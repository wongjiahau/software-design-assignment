package dao;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DAOFactory implements IDAOFactory {

    @Override
    public IClientDAO getClientDAO() {
        throw new NotImplementedException();
    }

    @Override
    public ITechnicianDAO getTechnicianDAO() {
        throw new NotImplementedException();
    }

    @Override
    public IServiceRequestDAO getServiceRequestDAO() {
        throw new NotImplementedException();
    }

}