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

}
