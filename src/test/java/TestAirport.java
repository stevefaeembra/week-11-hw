import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAirport {

	private Airport airport;

	@Before
	public void setUp() {
		airport = new Airport("EDI", "Edinburgh");
	}

	@Test
	public void gotAirportCode() {
		assertEquals("EDI", airport.getCode());
	}

	@Test
	public void gotAirportName() {
		assertEquals("Edinburgh", airport.getName());
	}

}
