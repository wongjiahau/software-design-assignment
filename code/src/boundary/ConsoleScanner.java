package boundary;

import java.util.Scanner;

public class ConsoleScanner implements IScanner {
    private Scanner scanner;
    public ConsoleScanner() {
        this.scanner = new Scanner(System.in);
    }

	@Override
	public String getNextLine() {
        return this.scanner.nextLine();
	}


}
