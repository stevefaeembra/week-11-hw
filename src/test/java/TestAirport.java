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


	@Test
	public void ableToAddHangar() {
		Hangar hangar = new Hangar("Hangar A");
		airport.addHangar(hangar);
		assertEquals(hangar, airport.getHangarByName("Hangar A"));
	}

	@Test
	public void ableToAddFlight() {
		Airline airline = new Airline("easayJet","EZY");
		Plane plane = new Plane(airline,AircraftType.AIRBUS_A320);
		Flight flight = new Flight("Glasgow", "EZY123", plane);
		airport.addFlight(flight);
		assertEquals(flight,airport.getFlightByFlightNumber("EZY123"));
	}
}
