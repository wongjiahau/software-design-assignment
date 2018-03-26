package system;

import boundary.ViewFactory;
import control.ControllerFactory;
import control.IController;
import control.MainController;
import dao.DAOFactory;
import dao.IDAOFactory;
import libs.ConsoleStream;
import mocks.MockDAOFactory;

enum Environment {
    Development, Production
}

public class App {
    public static void main(String[] args) throws Exception {
        Environment environment = Environment.Development;
        IDAOFactory daoFactory;
        if(environment == Environment.Development) {
            daoFactory = new MockDAOFactory();
        } else if(environment == Environment.Production) {
            daoFactory = new DAOFactory();
        } else {
            throw new Exception("Invalid environment.");
        }
        ViewFactory viewFactory = new ViewFactory(new ConsoleStream());
        ControllerFactory controllerFactory = new ControllerFactory(viewFactory, daoFactory);
        IController controller = new MainController(controllerFactory, viewFactory);
        while (controller.run());
    }
}
