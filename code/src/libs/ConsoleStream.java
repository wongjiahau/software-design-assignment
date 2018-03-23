package libs;

import java.util.Scanner;

public class ConsoleStream implements IStream {
    private Scanner scanner;
    public ConsoleStream() {
        this.scanner = new Scanner(System.in);
    }
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

	@Override
	public String getNextLine() {
        return this.scanner.nextLine();
	}
}
