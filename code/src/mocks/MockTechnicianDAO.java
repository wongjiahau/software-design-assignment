package mocks;

import java.util.Collection;

import dao.ITechnicianDAO;
import model.Technician;

public class MockTechnicianDAO extends MockDAO<Technician> implements ITechnicianDAO {
    public MockTechnicianDAO() {
        super();
    }

    /* (non-Javadoc)
	 * @see mocks.ITechnicianDAO#getAll()
	 */
    @Override
	public Collection<Technician> getAll() {
        return super.getAll();
    }

    /* (non-Javadoc)
	 * @see mocks.ITechnicianDAO#add(model.Technician)
	 */
    @Override
	public void add(Technician newTechnician) {
        super.add(newTechnician.getId(), newTechnician);
    }

    /* (non-Javadoc)
	 * @see mocks.ITechnicianDAO#getById(java.lang.String)
	 */
    @Override
	public Technician getById(String technicianId) {
        return super.getById(technicianId);
    }
}
