package system;


import boundary.ViewFactory;
import control.ControllerFactory;
import control.IController;
import control.MainController;
import dao.IDAOFactory;
import libs.ConsoleStream;
import mocks.MockDAOFactory;

public class App {
    public static void main(String[] args) {
        IDAOFactory DAOFactory            = new MockDAOFactory();
        ViewFactory viewFactory             = new ViewFactory(new ConsoleStream());
        ControllerFactory controllerFactory = new ControllerFactory(
            viewFactory,
            DAOFactory.getClientDAO(),
            DAOFactory.getTechnicianDAO(),
            DAOFactory.getServiceRequestDAO()
        );
        IController controller = new MainController(controllerFactory, viewFactory);
        while(controller.run());
    }
}
