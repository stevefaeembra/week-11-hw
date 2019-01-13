public enum AircraftType {

	BOEING_747(450),
	AIRBUS_A320(236),
	BEECHCRAFT_BONANZA(4)
	;


	private final int capacity;

	AircraftType(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return this.capacity;
	}
}
