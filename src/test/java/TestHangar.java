import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHangar {

	private Hangar hangar;

	@Before
	public void setUp() {
		hangar = new Hangar("Hangar A");
	}

	@Test
	public void hasName() {
		assertEquals("Hangar A",hangar.getName());
	}

}
