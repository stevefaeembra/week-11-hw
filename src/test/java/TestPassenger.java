import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPassenger {

	private Passenger passenger;

	@Before
	public void setUp() {
		passenger = new Passenger("John Smith");
	}

	@Test
	public void hasName() {
		assertEquals("John Smith",passenger.getName());
	}

}
