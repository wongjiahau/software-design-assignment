package boundary;

import libs.IStream;

public class ViewFactory {
    private IStream stream;

    public ViewFactory(IStream stream) {
        this.stream = stream;
    }

    public MainView createMainView() {
        return new MainView(this.stream);
    }

    public RecordRequestView createRecordRequestView() {
        return new RecordRequestView(this.stream);
    }

    public AssignTechnicianView createAssignTechnicianView() {
        return new AssignTechnicianView(this.stream);
    }

    public RecordServiceChargeView createRecordServiceChargeView() {
        return new RecordServiceChargeView(this.stream);
    }

}
