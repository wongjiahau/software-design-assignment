package boundary;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.*;

import control.AppController;

public class AppUi {
    private AppController appController;
    private Scanner scanner;
    private PrintStream printer;

    public AppUi(AppController appController) {
        this.appController = appController;
        this.scanner = new Scanner(System.in);
        this.printer = new PrintStream(System.out);
    }

    public void run() {
        while (true) {
            String choice = this.displayMenu();
            switch (choice) {
            case "1":
                this.recordRequestForService();
                break;
            case "2":
                this.assignTechnician();
                break;
            case "3":
                this.recordServiceCharge();
                break;
            }
        }
    }

    private void recordRequestForService() {
    }

    private void assignTechnician() {
    }

    private void recordServiceCharge() {
    }

    private String displayMenu() {
        String menu = "Select your options: \n";
        menu += " 1. Record request for service (RFS)\n";
        menu += " 2. Assign technician to RFS\n";
        menu += " 3. Record service charge for RFS\n";
        menu += "\tSelect your choice >> ";
        this.printer.print(menu);
        while (true) {
            String choice = this.scanner.nextLine();
            if (Pattern.matches("[1-3]{1}", choice)) {
                return choice;
            }
            this.printer.print("Invalid choice! Please key in again >> ");
        }
    }
}
