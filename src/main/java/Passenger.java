public class Passenger {

	private String name;

	public Passenger(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return String.format("Passenger: {name:%s}", this.name);
	}
}
