package boundary;

import libs.IStream;

public class ViewFactory {
    private IStream ioStream;
    public ViewFactory(IStream ioStream) {
        this.ioStream = ioStream;
    }
    public MainView createMainView() {
        return new MainView(this.ioStream);
    }
	
}
