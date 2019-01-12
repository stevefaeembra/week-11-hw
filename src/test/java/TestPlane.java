import org.junit.Before;
import org.junit.Test;
import java.util.Random;
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
	public void hasType() {
		assertEquals(AircraftType.AIRBUS_A320, plane.getType());
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
	public void canAddPassengersIfRoomLeft() {
		ArrayList<Passenger> group = new ArrayList<Passenger>();
		for (int i=0; i<4; i++) {
			group.add(new Passenger("Bob"));
		}
		assertEquals(true, plane.canAddPassengers(group));
	}

	@Test
	public void canAddPassengersIfNoRoomLeft() {
		ArrayList<Passenger> group = new ArrayList<Passenger>();
		for (int i=0; i<600; i++) {
			group.add(new Passenger("Bob"));
		}
		assertEquals(false, plane.canAddPassengers(group));
	}

	@Test
	public void addingPassengersShouldChangeCapacity() {
		ArrayList<Passenger> group = new ArrayList<Passenger>();
		int capacity = plane.getRemainingCapacity();
		for (int i=0; i<20; i++) {
			group.add(new Passenger("Janey's Hen Do"));
		}
		plane.addPassengers(group);
		assertEquals(capacity-20,plane.getRemainingCapacity());
	}

	@Test
	public void cramThemIn() {
		// creates hundreds of random sized groups between 1 and 8 people
		// we should never exceed plane capacity
		for (int i=0; i<1000; i++) {
			ArrayList<Passenger> group = new ArrayList<>();
			for (int j=0; j< new Random().nextInt(8); j++) {
				group.add(new Passenger("Bob"));
			}
			plane.addPassengers(group);
		}
		assertEquals(plane.getPassengerCount(), plane.getType().getCapacity());
		assertEquals(0,plane.getRemainingCapacity());
	}

}
