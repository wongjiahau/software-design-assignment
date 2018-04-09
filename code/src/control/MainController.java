package control;

import boundary.MainView;
import boundary.ViewFactory;

public class MainController implements IController {
    private MainView view;
    private ControllerFactory controllerFactory;
    public MainController(ControllerFactory controllerFactory, ViewFactory viewFactory) {
        this.view = viewFactory.createMainView();
        this.controllerFactory = controllerFactory;
    }

    @Override
    public boolean run() throws Exception {
        String choice = this.view.displayMenu();
        IController controller = new NullController();
        switch (choice) {
        case "1":
            controller = this.controllerFactory.createRecordRequestController();
            break;
        case "2":
            controller = this.controllerFactory.createAssignTechnicianController();
            break;
        case "3":
            controller = this.controllerFactory.createRecordServiceChargeController();
            break;
        case "4":
            this.view.displayGoodBye();
            return false;
        }
        controller.run();
        return true;
        
    }

}
