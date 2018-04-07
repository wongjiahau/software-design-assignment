package mocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import dao.ITechnicianDAO;
import entity.Technician;

public class MockTechnicianDAO extends MockDAO<Technician> implements ITechnicianDAO {
    public MockTechnicianDAO() {
        super();
    }

    @Override
	public Collection<Technician> getAll() {
        return super.getAll();
    }

    @Override
	public void add(Technician newTechnician) {
        super.add(newTechnician.getId(), newTechnician);
    }

    @Override
	public Technician getById(String technicianId) {
        return super.getById(technicianId);
    }

	@Override
	public ArrayList<Technician> getAvailable(Date dateOfService) {
        ArrayList<Technician> result = new ArrayList<Technician>();
        Collection<Technician> allTechnicians = this.getAll();
        for (Technician technician : allTechnicians) {
            if(technician.isAvailableOn(dateOfService)) {
                result.add(technician);
            }
        }
        return result;
	}
}
