package libs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public int promptInteger(String prompt) {
        return Integer.parseInt(this.prompt(prompt, "^[0-9]+$", "Invalid format."));
    }

    public double promptDouble(String prompt) {
        return Double.parseDouble(this.prompt(prompt + " (XX.XX)", "^[0-9]+[.][0-9]+$", "Invalid format."));
    }

    public String promptForStringId(String prompt, ArrayList<String> validIds) {
        while(true) {
            String chosenId = this.prompt(prompt, ".*", "");
            for (String id : validIds) {
                if(id.equals(chosenId)) {
                    return chosenId;
                }
            }
            this.stream.printLine("ERROR: Invalid ID.");
        }
    }

    public int promptForIntegerId(String prompt, ArrayList<Integer> validIds) {
        ArrayList<String> stringIds = new ArrayList<String>();
        for (Integer id : validIds) {
            stringIds.add(String.valueOf(id));
        }
        return Integer.parseInt(this.promptForStringId(prompt, stringIds));
    }

    public Date promptDate(String prompt) {
        while(true) {
            String inputDate = this.prompt(
                prompt + " (yyyy-MM-dd/today)", 
                "^(20[0-9]{2}-(0[0-9]|1[012])-[0123][0-9]|today)$", 
                "Invalid date format."
            );
            if(inputDate.equals("today")) {
                return new Date();
            }
            try {
                return (new SimpleDateFormat("yyyy-MM-dd")).parse(inputDate);
            } catch (Exception e) {
                this.stream.printLine("ERROR: Invalid date.");                
            }
        }
    }
}
