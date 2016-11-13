import org.junit.Test;
import static org.junit.Assert.*;

//pinning test

public class MonkeyTest {

	private Monkey m = new Monkey();

	@Test
	public void testGenerateIdWith0() {
		assertEquals(223492, m.generateId(0));
	}

	@Test
	public void testGenerateIdWith16() {
		assertEquals(223508, m.generateId(16));
	}

	@Test
	public void testGenerateIdWithNegative() {
		assertEquals(223491, m.generateId(-1));
	}
}
