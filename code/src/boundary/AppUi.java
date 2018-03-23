package boundary;

import java.io.PrintStream;
import java.util.Scanner;

import libs.Prompter;

public class AppUi {
    private Scanner scanner;
    private PrintStream printer;
    private Prompter prompter;

    public AppUi() {
        this.scanner = new Scanner(System.in);
        this.printer = new PrintStream(System.out);
        this.prompter = new Prompter();
    }

    public void run() {
    }

    public String getIc() {
        return this.prompter.prompt(
            "Enter client's I/C number", 
            "\\d{6}-\\d{2}-\\d{4}", 
            "I/C should be in format of XXXXXX-XX-XXXX"
        );
    }

    public String displayMenu() {
        String menu = "Select your options: \n";
        menu += " 1. Record request for service (RFS)\n";
        menu += " 2. Assign technician to RFS\n";
        menu += " 3. Record service charge for RFS\n";
        return this.prompter.prompt(
            menu, 
            "Select your choice", 
            "[1-3]{1}", 
            "Invalid choice."
        );

    }

	public void displayClientNotExist() {
        this.printer.println("This client does not exist in the system.");
        this.printer.println("Please key in his/her detail.");
	}

	public String getName() {
		return this.prompter.prompt(
            "Enter name", 
            "^([a-z]|[A-Z]|[ '.,])+$", 
            "Name should not contain weird symbols."
        );
	}

	public String getPhoneNum() {
        return this.prompter.prompt(
            "Enter phone number",
            "^[0-9]{3}-[0-9]{7}[0-9]?$",
             "Phone number must be in format of XXX-XXXXXXX"
        );
	}

	public String getAddress() {
        return this.prompter.prompt(
            "Enter address",
            ".*",
             ""
        );
	}

	public void displayServiceRequestCreated(String clientName, String dateTime, String serviceRequestId) {
        String message = "A new service request has been created for " 
                       + clientName + " at " + dateTime  + ".";
        message += "\nThe ID of this service request is " + serviceRequestId + ".";
        this.printer.println(message);
	}
}
