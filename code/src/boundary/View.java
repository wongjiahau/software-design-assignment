package boundary;

import libs.IStream;
import libs.Prompter;

public abstract class View {
    protected IStream stream;
    protected Prompter prompter;
    public View(IStream stream) {
        this.stream = stream;
        this.prompter = new Prompter(stream);
    }

    protected void displayTitle(String title) {
        String line = "";
        for (int i = 0; i < title.length(); i++) {
            line += "=";
        }
        this.stream.printLine(line);
        this.stream.printLine(title.toUpperCase());
        this.stream.printLine(line);
        

    }

}
