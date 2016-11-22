import org.junit.Test;
import static org.junit.Assert.*;

//pinning test

public class MonkeyTest {

	//pinning test for generateID()
	@Test
	public void testGenerateIdWith0() {
		Monkey m = new Monkey(0);
		assertEquals(223492, m.generateId(0));
	}

	//pinning test for generateID()
	@Test
	public void testGenerateIdWith16() {
		Monkey m = new Monkey(16);
		assertEquals(223508, m.generateId(16));
	}

	//pinning test for generateID()
	@Test
	public void testGenerateIdWithNegative() {
		Monkey m = new Monkey(-1);
		assertEquals(223491, m.generateId(-1));
	}

	/************************************************
	 *below are unit tests created for deliverable 5
	 ************************************************/

 	//test modified constructor
	//monkey initialized with integer 16
	//int 16 for monkey number and int 223508 for monkey id is expected
	@Test
 	public void testMonkeyConstructor() {
 		Monkey m = new Monkey(16);
		try{
			int[] expected = {16, 223508};
			int[] observed = {m.getMonkeyNum(), m.getId()};
			assertArrayEquals(expected, observed);
		}
		catch (NoIdException noidex) {}
 	}

	//test modified constructor
	//monkey initialized with integer 0
	//int 16 for monkey number and int 223492 for monkey id is expected
	@Test
 	public void testMonkeyConstructorWithZero() {
 		Monkey m = new Monkey(0);
		try{
			int[] expected = {0, 223492};
			int[] observed = {m.getMonkeyNum(), m.getId()};
			assertArrayEquals(expected, observed);
		}
		catch (NoIdException noidex) {}
 	}

	//unit test for new method nextMonkeySecond()
	//in second round, monkey #5 shuold pass banana to monkey #3
	//therefore, int 3 is expected
	@Test
	public void testNextMonkeySecondWithMonkeyNum5() {
		Monkey[] monkeyArr = new Monkey[5];
		for(int i = 0; i < 5; i++) {
			monkeyArr[i] = new Monkey(i+1);
		}
		assertEquals(3, monkeyArr[4].nextMonkeySecond());
	}

	//unit test for new method nextMonkeySecond()
	//in second round, monkey #1 shuold not pass to any other monkeys
	//therefore, int 1 is expected
	@Test
	public void testNextMonkeySecondWithMonkeyNum1() {
		Monkey m = new Monkey(1);
		assertEquals(1, m.nextMonkeySecond());
	}
}
