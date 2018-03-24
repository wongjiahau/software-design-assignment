package system;


import boundary.ViewFactory;
import control.ControllerFactory;
import control.IController;
import control.MainController;
import libs.ConsoleStream;
import mocks.MockStoreFactory;
import model.ClientStore;
import model.ServiceRequestStore;
import model.TechnicianStore;

public class App {
    public static void main(String[] args) {
        MockStoreFactory mockStoreFactory       = new MockStoreFactory();
        ClientStore clientStore                 = mockStoreFactory.createMockClientStore();
        TechnicianStore technicianStore         = mockStoreFactory.createMockTechnicianStore();
        ServiceRequestStore serviceRequestStore = mockStoreFactory.createMockServiceRequestStore();
        ViewFactory viewFactory                 = new ViewFactory(new ConsoleStream());
        ControllerFactory controllerFactory     = new ControllerFactory(
            viewFactory,
            clientStore,
            technicianStore,
            serviceRequestStore
        );
        IController controller = new MainController(controllerFactory, viewFactory);
        while(controller.run());
    }
}
