package model;

public interface IStoreFactory {

    ClientStore createClientStore();

    TechnicianStore createTechnicianStore();

    ServiceRequestStore createServiceRequestStore();
}