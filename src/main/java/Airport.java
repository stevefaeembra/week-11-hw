import java.lang.reflect.Array;
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


	public void assignPlaneToHangar(Plane plane, Hangar hangar) {
		planeAssignments.put(plane, hangar);
	}


	public Hangar getPlaneLocation(Plane plane) {
		if (planeAssignments.containsKey(plane)) {
			return planeAssignments.get(plane);
		}
		else {
			return null;
		}
	}

	public ArrayList<String> dumpInfo() {
		ArrayList<String> result = new ArrayList<>();
		// Returns a load of text lines
		result.add("STATE OF THE AIRPORT");
		result.add("====================");
		result.add(String.format("Airport: %s", this.toString()));
		result.add("\tHangars:");
		for (Hangar hangar: hangars) {
			result.add(String.format("\t\t%s", hangar.toString()));
		};
		result.add("\tFlights:");
		for (Flight flight: flights) {
			result.add(String.format("\t\t%s", flight.toString()));
			Plane plane = flight.getPlane();
			result.add(String.format("\t\t\t%s", plane.toString()));
		}
		result.add("\tHangar Assignments:");
		for (Plane plane: planeAssignments.keySet()) {
			result.add(String.format("\t\t%s is in %s", plane.toString(), planeAssignments.get(plane).toString()));
		}
		result.add("\tFlight Roster:");
		for (Passenger passenger: flightRoster.keySet()) {
			result.add(String.format("\t\t%s is on %s", passenger.toString(), flightRoster.get(passenger).toString()));
		}
		return result;
	}

	public String toString() {
		return String.format("Airport: {code:%s name:%s}", this.code, this.name);
	}

}
