package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.AppUi;
import control.AppController;
import mocks.MockPrinter;
import mocks.MockScanner;
import model.ClientStore;
import model.ServiceRequestStore;

public class TestApp {
	private MockScanner mockScanner;
	private MockPrinter mockPrinter;
	public AppController initializeAppController(ArrayList<String> inputLines) {
		this.mockScanner = new MockScanner(inputLines);
		this.mockPrinter = new MockPrinter();
		return new AppController(
            new AppUi(this.mockPrinter, this.mockScanner), 
            new ClientStore(), 
            new ServiceRequestStore()
        );
	}

	@Test
	public void testExit() {
		// appController should return false when user chose exits
		ArrayList<String> inputLines = new ArrayList<String>();
		inputLines.add("4");
		AppController mockAppController = this.initializeAppController(inputLines);
		boolean exited = mockAppController.run();
		assertEquals(false, exited);
		assertEquals(this.mockPrinter.getLastPrintedLine(), "Good bye.");
	}

}
