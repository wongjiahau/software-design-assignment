package boundary;

import libs.IStream;
import libs.Prompter;

public abstract class View {
    protected IStream stream;
    protected Prompter prompter;
    public View(IStream ioStream) {
        this.stream = ioStream;
        this.prompter = new Prompter(ioStream);
    }

}
