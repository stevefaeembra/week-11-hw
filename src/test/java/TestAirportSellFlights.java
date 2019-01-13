import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestAirportSellFlights {

	private Airport airport;
	private Flight flight;
	private Plane plane;
	private ArrayList<Passenger> group;

	@Before
	public void setUp() {
		plane = new Plane(
			new Airline("easyJet","EZY"),
			AircraftType.AIRBUS_A320
		);
		airport = new Airport("EDI", "Edinburgh");
		flight = new Flight("Glasgow", "EZY123", plane);
		group = new ArrayList<>();
		group.add(new Passenger("Peter Griffin"));
		group.add(new Passenger("Lois Griffin"));
		group.add(new Passenger("Brian Griffin"));
		group.add(new Passenger("Chris Griffin"));
		group.add(new Passenger("Meg Griffin"));
		group.add(new Passenger("Stewie Griffin"));
	}

	@Test
	public void ableToSellFlight() {
		airport.sellFlight(flight, group);
		Plane plane1 = flight.getPlane();
		// added to plane?
		assertEquals(6,plane1.getPassengerCount());
		// added to flight roster?
		assertEquals(flight, airport.getPassengerFlight("Meg Griffin"));
		assertEquals(flight, airport.getPassengerFlight("Brian Griffin"));
		// someone not on flight
		assertEquals(null, airport.getPassengerFlight("D. B. Cooper"));
	}



}
