package control;

public class ControllerFactory {
    public RecordRequestController createRecordRequestController() {
        return new RecordRequestController();
    }

    public AssignTechnicianController createAssignTechnicianController() {
        return new AssignTechnicianController();
    }

    public RecordServiceChargeController createRecordServiceChargeController() {
        return new RecordServiceChargeController();
    }

}
