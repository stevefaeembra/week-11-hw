import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAircraftType {

	private AircraftType type;

	@Before
	public void setUp() {
		type = AircraftType.BOEING_747;
	}

	@Test
	public void hasCapacity() {
		assertEquals(450, type.getCapacity());
	}
}
