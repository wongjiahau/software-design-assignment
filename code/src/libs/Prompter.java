package libs;

import java.util.regex.*;

public class Prompter {
    private IStream stream;
    public Prompter(IStream stream) {
        this.stream = stream;
    }

    public String prompt(String message, String prompt, String regexPattern, String errorMessage) {
        this.stream.printLine(message);
        return this.prompt(prompt, regexPattern, errorMessage);
    }

    public String prompt(String prompt, String regexPattern, String errorMessage) {
        this.stream.print(prompt + "\n>> ");
        while (true) {
            String input = this.stream.getNextLine();
            if (Pattern.matches(regexPattern, input)) {
                return input;
            }
            this.stream.printLine("ERROR : " + errorMessage);
            this.stream.print(prompt + "\n>> ");
        }
    }

    public boolean promptYesNo(String message, String prompt) {
        this.stream.print(message);
        return this.promptYesNo(prompt);
    }

    public boolean promptYesNo(String prompt) {
        return this.prompt(
            prompt + " (y/n) ", 
            "^([yY]|[nN])$", 
            "Invalid choice."
        ).equalsIgnoreCase("y");
    }

}
