package system;


import boundary.ViewFactory;
import control.ControllerFactory;
import control.IController;
import control.MainController;
import libs.ConsoleStream;
import mocks.MockStoreFactory;
import model.IStoreFactory;

public class App {
    public static void main(String[] args) {
        IStoreFactory storeFactory              = new MockStoreFactory();
        ViewFactory viewFactory                 = new ViewFactory(new ConsoleStream());
        ControllerFactory controllerFactory     = new ControllerFactory(
            viewFactory,
            storeFactory.createClientStore(),
            storeFactory.createTechnicianStore(),
            storeFactory.createServiceRequestStore()
        );
        IController controller = new MainController(controllerFactory, viewFactory);
        while(controller.run());
    }
}
