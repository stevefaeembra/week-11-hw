import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestPlane {

	private Plane plane;
	private Airline airline;

	@Before
	public void setUp() {
		airline = new Airline("easyJet", "EZY");
		plane = new Plane(airline,AircraftType.AIRBUS_A320);
	}

	@Test
	public void hasAirline() {
		assertEquals("easyJet",plane.getAirline().getName());
	}

	@Test
	public void hasAircraftType() {
		assertEquals(airline, plane.getAirline());
	}

	@Test
	public void canAddPaseengersIfRoomLeft() {
		ArrayList<Passenger> group = new ArrayList<Passenger>();
		for (int i=0; i<4; i++) {
			group.add(new Passenger("Bob"));
		}
		assertEquals(true, plane.canAddPassengers(group));
	}

	@Test
	public void canAddPaseengersIfNoRoomLeft() {
		ArrayList<Passenger> group = new ArrayList<Passenger>();
		for (int i=0; i<600; i++) {
			group.add(new Passenger("Bob"));
		}
		assertEquals(false, plane.canAddPassengers(group));
	}




}
