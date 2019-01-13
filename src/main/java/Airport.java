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
}
