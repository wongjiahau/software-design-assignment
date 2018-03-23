package mocks;


import java.util.ArrayList;

import boundary.IPrinter;

public class MockPrinter implements IPrinter {
    private ArrayList<String> printedLines;
    public MockPrinter() {
        this.printedLines = new ArrayList<String>();
    }

	@Override
	public void print(String message) {
        this.printedLines.add(message);
    }

	@Override
	public void printLine(String message) {
        this.printedLines.add(message);
    }
    
    public String getLastPrintedLine() {
        return this.printedLines.get(this.printedLines.size() - 1);
    }

}
