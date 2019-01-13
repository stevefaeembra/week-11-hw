public class Flight {

	private String destination;
	private String flightNumber;
	private Plane plane;

	public Flight(String destination, String flightNumber, Plane plane) {
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.plane = plane;
	}


	public String getDestination() {
		return destination;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public Plane getPlane() {
		return plane;
	}

	public String toString() {
		return String.format("Flight: {number:%s destination:%s}", this.flightNumber, this.destination);
	}


}
