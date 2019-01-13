import java.util.ArrayList;
import java.util.HashMap;

public class Airport {

	private String code;
	private String name;
	private ArrayList<Hangar> hangars;
	private HashMap<Plane,Hangar> planeAssignments;
	private HashMap<Passenger,Flight> flightRoster;
	private ArrayList<Flight> flights;

	public Airport(String code, String name) {
		this.code = code;
		this.name = name;
		this.hangars = new ArrayList<>();
		this.planeAssignments = new HashMap<>();
		this.flightRoster = new HashMap<>();
		this.flights = new ArrayList<>();
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void addHangar(Hangar hangar) {
		this.hangars.add(hangar);
	}

	public Hangar getHangarByName(String name) {
		for (Hangar h:hangars) {
			if (h.getName() == name) {
				return h;
			}
		};
		return null;
	}

	public void addFlight(Flight flight) {
		flights.add(flight);
	}

	public Flight getFlightByFlightNumber(String name) {
		for (Flight f:flights) {
			if (f.getFlightNumber() == name) {
				return f;
			}
		};
		return null;
	}

	public void sellFlight(Flight flight, ArrayList<Passenger> group) {
		Plane plane = flight.getPlane();
		if (plane.canAddPassengers(group)) {
			plane.addPassengers(group);
			assignPassengersToFlight(group, flight);
		}
	}

	private void assignPassengersToFlight(ArrayList<Passenger> group, Flight flight) {
		for (Passenger p: group) {
			flightRoster.put(p, flight);
		}
	}

	public Flight getPassengerFlight(String passengerName) {
		// not ideal as we may have two passengers with same name
		// on different flights :-)
		for (Passenger p: flightRoster.keySet()) {
			if (p.getName() == passengerName) {
				return flightRoster.get(p);
			}
		}
		return null;
	}


}
