package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import entity.Technician;

public interface ITechnicianDAO {

	Collection<Technician> getAll();

	void add(Technician newTechnician);

	Technician getById(String technicianId);

	ArrayList<Technician> getAvailable(Date date);

}