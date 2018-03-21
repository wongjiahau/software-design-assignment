package system;

import boundary.AppUi;
import control.AppController;

public class App {
    public static void main(String[] args) {
        AppUi appUi = new AppUi(new AppController());
        appUi.run();
        System.out.println("hello");
    }

}
