package libs;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.*;

import boundary.IPrinter;
import boundary.IScanner;

public class Prompter {
    private IPrinter printer;
    private IScanner scanner;

    public Prompter(IPrinter printer, IScanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public String prompt(String message, String prompt, String regexPattern, String errorMessage) {
        this.printer.printLine(message);
        return this.prompt(prompt, regexPattern, errorMessage);
    }

    public String prompt(String prompt, String regexPattern, String errorMessage) {
        this.printer.print(prompt + " >> ");
        while (true) {
            String input = this.scanner.getNextLine();
            if (Pattern.matches(regexPattern, input)) {
                return input;
            }
            this.printer.printLine("ERROR : " + errorMessage);
            this.printer.print(prompt + " >> ");
        }
    }

}
