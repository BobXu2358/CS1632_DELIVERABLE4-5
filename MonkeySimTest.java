import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.util.*;

//pinning test

public class MonkeySimTest {

	@Test
	public void testStringify1() {
		String str = "//Round 1: Threw banana from Monkey (#32 / ID 223524) to Monkey (#16 / ID 223508)";
		Monkey m1 = Mockito.mock(Monkey.class);
		Monkey m2 = Mockito.mock(Monkey.class);
		Mockito.when(m1.getMonkeyNum()).thenReturn(32);
		Mockito.when(m2.getMonkeyNum()).thenReturn(16);
		try{ 
			Mockito.when(m1.getId()).thenReturn(223524);
			Mockito.when(m2.getId()).thenReturn(223508);
		}
		catch (NoIdException noidex) {
		    System.out.println("INVALID MONKEY!");
		    System.exit(2);
		}
			assertEquals(str, MonkeySim.stringifyResults(1, m1, m2));
	}

	@Test
	public void testStringify2() {
		String str = "//Round 3: Threw banana from Monkey (#23 / ID 223515) to Monkey (#70 / ID 223562)";
		Monkey m1 = Mockito.mock(Monkey.class);
		Monkey m2 = Mockito.mock(Monkey.class);
		Mockito.when(m1.getMonkeyNum()).thenReturn(23);
		Mockito.when(m2.getMonkeyNum()).thenReturn(70);
		try{
			Mockito.when(m1.getId()).thenReturn(223515);
			Mockito.when(m2.getId()).thenReturn(223562);
		}
		catch (NoIdException noidex) {
		    System.out.println("INVALID MONKEY!");
		    System.exit(2);
		}
			assertEquals(str, MonkeySim.stringifyResults(3, m1, m2));
	}
	
	@Test
	public void testStringify3() {
		String str = "//Round 11: Threw banana from Monkey (#20 / ID 223512) to Monkey (#10 / ID 223502)";
		Monkey m1 = Mockito.mock(Monkey.class);
		Monkey m2 = Mockito.mock(Monkey.class);
		Mockito.when(m1.getMonkeyNum()).thenReturn(20);
		Mockito.when(m2.getMonkeyNum()).thenReturn(10);
		try{ 
			Mockito.when(m1.getId()).thenReturn(223512);
			Mockito.when(m2.getId()).thenReturn(223502);
		}
		catch (NoIdException noidex) {
		    System.out.println("INVALID MONKEY!");
		    System.exit(2);
		}
			assertEquals(str, MonkeySim.stringifyResults(11, m1, m2));
	}
	
	
}