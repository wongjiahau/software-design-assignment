package system;


import boundary.AppUi;
import boundary.ConsolePrinter;
import boundary.ConsoleScanner;
import control.AppController;
import model.ClientStore;
import model.ServiceRequestStore;

public class App {
    public static void main(String[] args) {
        AppController appController = new AppController(
            new AppUi(new ConsolePrinter(), new ConsoleScanner()), 
            new ClientStore(), 
            new ServiceRequestStore()
        );
        appController.run();
    }

}
