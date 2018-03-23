package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import boundary.View;
import mocks.MockStream;

public class TestView {

	@Test
	public void testDisplayTable() {
		MockStream mockStream  = new MockStream(new ArrayList<String>());
		View view = new View(mockStream);
		String header = "ID,DATE-OF-REQUEST,NAME";
		String[] rows = {
			"s1,2018-09-02,John Connor",
			"s2,2018-10-22,Kim"
		};
		view.displayTable(header, rows);
		String expected = "" 
			+ "ID  DATE-OF-REQUEST  NAME         \n"
			+ "s1  2018-09-02       John Connor  \n"
			+ "s2  2018-10-22       Kim          \n";
		System.out.println(mockStream.getPrintedLines());
		assertEquals(expected, mockStream.getPrintedLines());
	}

}
