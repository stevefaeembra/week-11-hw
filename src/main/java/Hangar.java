public class Hangar {

	private String name;

	public Hangar(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return String.format("Hangar: {name:%s}", this.name);
	}

}
