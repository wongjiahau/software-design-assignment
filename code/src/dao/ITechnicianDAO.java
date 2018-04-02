package dao;

import java.util.Collection;

import entity.Technician;

public interface ITechnicianDAO {

	Collection<Technician> getAll();

	void add(Technician newTechnician);

	Technician getById(String technicianId);

}