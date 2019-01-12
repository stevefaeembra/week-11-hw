import java.lang.reflect.Array;
import java.util.ArrayList;

public class Plane {

	private Airline airline;
	private AircraftType type;
	private ArrayList<Passenger> passengers;

	public Plane(Airline airline, AircraftType type) {
		this.airline = airline;
		this.type = type;
		this.passengers = new ArrayList<Passenger>();
	}

	public Airline getAirline() {
		return airline;
	}

	public AircraftType getType() {
		return type;
	}

	public boolean canAddPassengers(ArrayList<Passenger> passengers) {
		return passengers.size() + this.passengers.size() <= this.type.getCapacity();
	}

}
