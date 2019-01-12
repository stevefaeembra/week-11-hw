import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAirline {

	private Airline airline;

	@Before
	public void setUp() {
		airline = new Airline("easyJet","EZJ");
	}

	@Test
	public void hasName() {
		assertEquals("easyJet",airline.getName());
	}

	@Test
	public void hasCode() {
		assertEquals("EZJ",airline.getCode());
	}

}
