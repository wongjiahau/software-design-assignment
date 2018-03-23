package system;


import boundary.ViewFactory;
import control.ControllerFactory;
import control.IController;
import control.MainController;
import libs.ConsoleStream;
import model.ClientStore;
import model.ServiceRequestStore;
import model.TechnicianStore;

public class App {
    public static void main(String[] args) {
        ViewFactory viewFactory = new ViewFactory(new ConsoleStream());
        ControllerFactory controllerFactory = new ControllerFactory(
            viewFactory,
            new ClientStore(),
            new TechnicianStore(),
            new ServiceRequestStore()
        );
        IController controller = new MainController(controllerFactory, viewFactory);
        while(controller.run());
    }
}
