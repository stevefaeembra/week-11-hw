import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestAirportDumpInfo {

	private Airport airport;
	private Flight flight;
	private Plane plane;
	private ArrayList<Passenger> group;
	private Hangar hangar;

	@Before
	public void setUp() {
		hangar = new Hangar("Hangar A");
		plane = new Plane(
			new Airline("easyJet","EZY"),
			AircraftType.AIRBUS_A320
		);
		airport = new Airport("EDI", "Edinburgh");
		airport.addHangar(hangar);
		flight = new Flight("Glasgow", "EZY123", plane);
		airport.addFlight(flight);
		group = new ArrayList<>();
		group.add(new Passenger("Peter Griffin"));
		group.add(new Passenger("Lois Griffin"));
		group.add(new Passenger("Brian Griffin"));
		group.add(new Passenger("Chris Griffin"));
		group.add(new Passenger("Meg Griffin"));
		group.add(new Passenger("Stewie Griffin"));
		airport.assignPlaneToHangar(plane, hangar);
		airport.sellFlight(flight, group);
	}

	@Test
	public void dumpInfo() {
		ArrayList<String> dump = airport.dumpInfo();
		for (String line : dump) {
			System.out.println(line);
		}
	}



}
