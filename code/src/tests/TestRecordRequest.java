package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.ViewFactory;
import control.IController;
import control.RecordRequestController;
import mocks.MockStoreFactory;
import mocks.MockStream;
import model.ClientStore;
import model.ServiceRequestStore;

public class TestRecordRequest {
	private MockStream mockStream;
	private ClientStore clientStore;
	private ServiceRequestStore serviceRequestStore;
	public RecordRequestController getController(ArrayList<String> inputLines) {
		this.mockStream = new MockStream(inputLines);
		ViewFactory viewFactory = new ViewFactory(this.mockStream);
		this.clientStore = new MockStoreFactory().createMockClientStore();
		this.serviceRequestStore = new ServiceRequestStore();
		return new RecordRequestController(viewFactory, clientStore, serviceRequestStore);
	}

	@Test 
	public void flow1_userEnteredIcOfExistingCustomer() {
		ArrayList<String> inputLines = new ArrayList<String>();
		inputLines.add("960819-43-5437");
		inputLines.add("y");
		IController controller = this.getController(inputLines);
		controller.run();
		String expectedOutput = ""
		    + "Enter client's I/C number\n"
			+ ">> "
			+ "The I/C matched a client named 'Ali'.\n"
			+ "Do you want to create a new service request for this client?  (y/n) \n"
			+ ">> ";
		System.out.println(mockStream.getPrintedLines());
		assertTrue(this.mockStream.getPrintedLines().contains(expectedOutput));

	}

	@Test
	public void flow2_userEnteredIcOfNonExistingCustomer() {
		ArrayList<String> inputLines = new ArrayList<String>();
		String ic = "960619-43-5555";
		String name ="John M. O'Reilly";
		inputLines.add(ic);
		inputLines.add("y");
		inputLines.add(name);
		inputLines.add("019-82392834");
		inputLines.add("UTAR Sungai Long");
		IController controller = this.getController(inputLines);
		controller.run();
		assertEquals(this.clientStore.searchByIc(ic).getName(), name);
		assertEquals(this.serviceRequestStore.getLastInserted().getClient().getIcNumber(), ic);
		String expectedOutput = ""
			+ "Enter client's I/C number\n"
			+ ">> "
			+ "This client does not exist in the system.\n"
			+ "Do you want to create a new client? (y/n) \n"
			+ ">> "
			+ "Enter name\n"
			+ ">> "
			+ "Enter phone number\n"
			+ ">> "
			+ "Enter address\n"
			+ ">> ";
		assertTrue(this.mockStream.getPrintedLines().contains(expectedOutput)); 
	}
}
