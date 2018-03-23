package mocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import boundary.IScanner;

public class MockScanner implements IScanner {
    private Stack<String> inputLinesStack;

    public MockScanner(ArrayList<String> inputLines) {
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

}
