package mocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


import libs.IStream;

public class MockStream implements IStream {
    private String printedLines;
    private Stack<String> inputLinesStack;

    public MockStream(ArrayList<String> inputLines) {
        this.printedLines = "";
        this.inputLinesStack = new Stack<String>();
        Collections.reverse(inputLines);
        for (String line : inputLines) {
            this.inputLinesStack.push(line);
        }
    }

    @Override
    public String getNextLine() {
        return this.inputLinesStack.pop();
    }

	@Override
	public void print(String message) {
        this.printedLines += message;
    }

	@Override
	public void printLine(String message) {
        this.printedLines += message + "\n";
    }

    public String getPrintedLines() {
        return this.printedLines;
    }

	@Override
	public void pressAnyKeyToContinue() {} 
}
