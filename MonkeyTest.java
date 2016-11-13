import org.junit.Test;
import static org.junit.Assert.*;

//pinning test

public class MonkeyTest {

	private Monkey m = new Monkey();

	@Test
	public void testGenerateIdWith4() {
		assertEquals(223496, m.generateId(4));
	}

	@Test
	public void testGenerateIdWith16() {
		assertEquals(223508, m.generateId(16));
	}

	@Test
	public void testGenerateIdWith40() {
		assertEquals(223532, m.generateId(40));
	}
}
