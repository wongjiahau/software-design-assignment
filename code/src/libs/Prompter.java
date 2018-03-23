package libs;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.*;

public class Prompter {
    private PrintStream printer;
    private Scanner scanner;

    public Prompter() {
        this.printer = new PrintStream(System.out);
        this.scanner = new Scanner(System.in);
    }

    public String prompt(String message, String prompt, String regexPattern, String errorMessage) {
        this.printer.println(message);
        return this.prompt(prompt, regexPattern, errorMessage);
    }

    public String prompt(String prompt, String regexPattern, String errorMessage) {
        this.printer.print(prompt + " >> ");
        while (true) {
            String input = this.scanner.nextLine();
            if (Pattern.matches(regexPattern, input)) {
                return input;
            }
            this.printer.println("ERROR : " + errorMessage);
            this.printer.print(prompt + " >> ");
        }
    }

}
