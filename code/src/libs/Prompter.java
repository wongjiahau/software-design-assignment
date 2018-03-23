package libs;

import java.util.regex.*;

public class Prompter {
    private IStream ioStream;
    public Prompter(IStream ioStream) {
        this.ioStream = ioStream;
    }

    public String prompt(String message, String prompt, String regexPattern, String errorMessage) {
        this.ioStream.printLine(message);
        return this.prompt(prompt, regexPattern, errorMessage);
    }

    public String prompt(String prompt, String regexPattern, String errorMessage) {
        this.ioStream.print(prompt + " >> ");
        while (true) {
            String input = this.ioStream.getNextLine();
            if (Pattern.matches(regexPattern, input)) {
                return input;
            }
            this.ioStream.printLine("ERROR : " + errorMessage);
            this.ioStream.print(prompt + " >> ");
        }
    }

}
