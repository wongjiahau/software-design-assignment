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
	private ClientStore clientStore;
	private ServiceRequestStore serviceRequestStore;
	public AppController initializeAppController(ArrayList<String> inputLines) {
		this.mockScanner = new MockScanner(inputLines);
		this.mockPrinter = new MockPrinter();
		this.clientStore = new ClientStore();
		this.serviceRequestStore = new ServiceRequestStore();
		return new AppController(
            new AppUi(this.mockPrinter, this.mockScanner), 
            this.clientStore, 
            this.serviceRequestStore
        );
	}

	@Test
	public void test_RequestForService() {
		ArrayList<String> inputLines = new ArrayList<String>();
		String choice = "1";
		String ic = "960619-43-5555";
		String name ="John M. O'Reilly";
		inputLines.add(choice);
		inputLines.add(ic);
		inputLines.add(name);
		inputLines.add("019-82392834");
		inputLines.add("UTAR Sungai Long");
		AppController mockAppController = this.initializeAppController(inputLines);
		mockAppController.run();
		assertEquals(this.clientStore.searchByIc(ic).getName(), name);
		assertEquals(this.serviceRequestStore.getLastInserted().getClient().getIcNumber(), ic);
	}

	@Test
	public void test_Exit() {
		// appController should return false when user chose exits
		ArrayList<String> inputLines = new ArrayList<String>();
		inputLines.add("4");
		AppController mockAppController = this.initializeAppController(inputLines);
		boolean exited = mockAppController.run();
		assertEquals(false, exited);
		assertEquals(this.mockPrinter.getLastPrintedLine(), "Good bye.");
	}

}
