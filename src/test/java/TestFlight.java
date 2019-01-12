import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TestFlight {

	private Flight flight;
	private Plane plane;

	@Before
	public void setUp() {
		plane = new Plane(
			new Airline("easyJet","EZY"),
			AircraftType.AIRBUS_A320
		);
		flight = new Flight("Paris CDG","EZ324",plane);
	}


	@Test
	public void hasDestination() {
		assertEquals("Paris CDG", flight.getDestination());
	}

	@Test
	public void hasFlightNumber() {
		assertEquals("EZ324", flight.getFlightNumber());
	}

	@Test
	public void hasGotPlaneAssigned() {
		assertEquals(plane, flight.getPlane());
	}

}
