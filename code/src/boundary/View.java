package boundary;

import libs.IStream;
import libs.Prompter;

public abstract class View {
    protected IStream ioStream;
    protected Prompter prompter;
    public View(IStream ioStream) {
        this.ioStream = ioStream;
        this.prompter = new Prompter(ioStream);
    }

}
