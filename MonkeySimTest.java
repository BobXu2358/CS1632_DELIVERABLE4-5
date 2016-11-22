import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.util.*;
import static org.mockito.Mockito.*;

//pinning test

public class MonkeySimTest {

	//pinning test for stringifyResults
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
		catch (NoIdException noidex) {}
			assertEquals(str, MonkeySim.stringifyResults(1, m1, m2));
	}

	//pinning test for stringifyResults
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
		catch (NoIdException noidex) {}
			assertEquals(str, MonkeySim.stringifyResults(3, m1, m2));
	}

	//pinning test for stringifyResults
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
		catch (NoIdException noidex) {}
			assertEquals(str, MonkeySim.stringifyResults(11, m1, m2));
	}

	//pinning test for testGetFirstMonkey()
	@Test
	public void testGetFirstMonkey1() {
		List<Monkey> ml = new LinkedList<Monkey>();
		Monkey m1 = Mockito.mock(Monkey.class);
		Monkey m2 = Mockito.mock(Monkey.class);
		Monkey m3 = Mockito.mock(Monkey.class);
		Monkey m4 = Mockito.mock(Monkey.class);
		Mockito.when(m1.getMonkeyNum()).thenReturn(1);
		Mockito.when(m2.getMonkeyNum()).thenReturn(2);
		Mockito.when(m3.getMonkeyNum()).thenReturn(3);
		Mockito.when(m4.getMonkeyNum()).thenReturn(4);
		ml.add(m1);
		ml.add(m2);
		ml.add(m3);
		assertEquals(1, MonkeySim.getFirstMonkey(ml).getMonkeyNum());
	}

	//pinning test for testGetFirstMonkey()
	@Test
	public void testGetFirstMonkey2() {
		List<Monkey> ml = new LinkedList<Monkey>();
		Monkey m1 = Mockito.mock(Monkey.class);
		Monkey m2 = Mockito.mock(Monkey.class);
		Monkey m3 = Mockito.mock(Monkey.class);
		Monkey m4 = Mockito.mock(Monkey.class);
		Mockito.when(m1.getMonkeyNum()).thenReturn(2);
		Mockito.when(m2.getMonkeyNum()).thenReturn(1);
		Mockito.when(m3.getMonkeyNum()).thenReturn(4);
		Mockito.when(m4.getMonkeyNum()).thenReturn(3);
		ml.add(m1);
		ml.add(m2);
		ml.add(m3);
		assertEquals(1, MonkeySim.getFirstMonkey(ml).getMonkeyNum());
	}

	//pinning test for testGetFirstMonkey()
	@Test
	public void testGetFirstMonkeyWithEmptyList() {
		List<Monkey> ml = new LinkedList<Monkey>();
		assertNull(MonkeySim.getFirstMonkey(ml));
	}

	//pinning test for testGetFirstMonkey()
	@Test
	public void testGetFirstMonkeyWithoutFirstMonkey() {
		List<Monkey> ml = new LinkedList<Monkey>();
		Monkey m1 = Mockito.mock(Monkey.class);
		Monkey m2 = Mockito.mock(Monkey.class);
		Monkey m3 = Mockito.mock(Monkey.class);
		Monkey m4 = Mockito.mock(Monkey.class);
		Mockito.when(m1.getMonkeyNum()).thenReturn(3);
		Mockito.when(m2.getMonkeyNum()).thenReturn(4);
		Mockito.when(m3.getMonkeyNum()).thenReturn(5);
		Mockito.when(m4.getMonkeyNum()).thenReturn(2);
		ml.add(m1);
		ml.add(m2);
		ml.add(m3);
		ml.add(m4);
		assertNull(MonkeySim.getFirstMonkey(ml));
	}

	/************************************************
	 *below are unit tests created for deliverable 5
	 ************************************************/

	 //test for method nextMonkeyAndResize
	 //assume currently in 1st round and use mockito to have method nextMonkey return 2 when it is called
	 //int 2 is expected
	 @Test
	 public void testNextMonkeyAndResizeFirstRound() {
		 List<Monkey> ml = new LinkedList<Monkey>();
		 Monkey m = Mockito.mock(Monkey.class);
		 Mockito.when(m.nextMonkey()).thenReturn(2);
		 ml.add(m);
		 assertEquals(2, MonkeySim.nextMonkeyAndResize(m, ml, 1));
	 }

	 //test for method nextMonkeyAndResize
	 //assume currently in 2nd round and use mockito to have method nextMonkeySecond return 3 when it is called
	 //int 3 is expected
	 @Test
	 public void testNextMonkeyAndResizeSecondRound() {
		 List<Monkey> ml = new LinkedList<Monkey>();
		 Monkey m = Mockito.mock(Monkey.class);
		 Mockito.when(m.nextMonkeySecond()).thenReturn(3);
		 assertEquals(3, MonkeySim.nextMonkeyAndResize(m, ml, 2));
	 }

	 //test for method nextMonkeyAndResize
	 //assume currently in 2nd round and the linked list already has a monkey
	 //test to see if the linked list is resized to size > num
	 //int 4 is expected
	 @Test
	 public void testNextMonkeyAndResizeListSizeWithLargerNextNum() {
		 List<Monkey> ml = new LinkedList<Monkey>();
		 Monkey m1 = Mockito.mock(Monkey.class);
		 Monkey m2 = Mockito.mock(Monkey.class);
		 Mockito.when(m2.nextMonkeySecond()).thenReturn(3);
		 ml.add(m1);
		 ml.add(m2);
		 MonkeySim.nextMonkeyAndResize(m2, ml, 2);
		 assertEquals(4, ml.size());
	 }

	 //test for method nextMonkeyAndResize
	 //assume currently in 2nd round and the linked list already has a monkey
	 //test to see if the linked list is NOT resized when next monkey number is smaller
	 //int 2 is expected
	 @Test
	 public void testNextMonkeyAndResizeListSizeWithSmallerNextNum() {
		 List<Monkey> ml = new LinkedList<Monkey>();
		 Monkey m1 = Mockito.mock(Monkey.class);
		 Monkey m2 = Mockito.mock(Monkey.class);
		 Mockito.when(m2.nextMonkeySecond()).thenReturn(1);
		 ml.add(m1);
		 ml.add(m2);
		 MonkeySim.nextMonkeyAndResize(m2, ml, 2);
		 assertEquals(2, ml.size());
	 }
}
