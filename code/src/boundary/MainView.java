package boundary;

import libs.IStream;

public class MainView extends View {
    public MainView(IStream ioStream) {
        super(ioStream);
    }

    public String displayMenu() {
        String menu = "Select your options: \n";
        menu += " 1. Record request for service (RFS)\n";
        menu += " 2. Assign technician to RFS\n";
        menu += " 3. Record service charge for RFS\n";
        menu += " 4. Exit\n";
        return this.prompter.prompt(
            menu, 
            "Select your choice", 
            "[1-4]{1}", 
            "Invalid choice."
        );

    }

	public void displayGoodBye() {
        this.ioStream.printLine("Good bye.");
	}

}
