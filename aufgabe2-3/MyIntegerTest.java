package aufgabe2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;


public class MyIntegerTest {
	
	
	public static MyInteger i1, i2, i3, i4, i5, i6, i7, i8, i9;
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		i1 = new MyInteger(127);
		i2 = new MyInteger(-2);
		i3 = new MyInteger(2147483647);
		i4 = new MyInteger(-2147483648);
		i5 = new MyInteger("127");
		i6 = new MyInteger("-2");
		//i7 = new MyInteger("Hallo");
		i8 = new MyInteger("+02147483647");
		i9 = new MyInteger("0");
	}
	
	@Test
	void testHashCode()
	{
		assertTrue(i3.hashCode()==i8.hashCode(), " hashCode of i3 and i8 should be equal");
		assertEquals(110, i1.hashCode(),"hashCode of i1 should be -2147483648");
		assertEquals(-17, i9.hashCode(), "hashCode of i9 should be 0");
	}
	
	@Test
	void testMyIntegerString()
	{
		assertNotNull(i9, "i9 should be not null");
		assertNotNull(i8, "i8 should be not null");
		assertNotNull(i6, "i6 should be not null");
		assertTrue(i3.equals(i8), "i3 and i8 should be equal");
		assertTrue(i2.equals(i6), "i2 and i6 should be equal");
	}
	
	@Test
	void testParseInt()
	{
		assertEquals(-2147483648, MyInteger.parseInt("-2147483648"), "should be -2147483648");
		assertEquals(+2147483647, MyInteger.parseInt("+00002147483647"), "should be +2147483647");
		assertEquals(-1, MyInteger.parseInt("-0000001"), "should be -1");
		assertEquals(0, MyInteger.parseInt("000"), "should be 0");
	}
	
	@Rule
	public static ExpectedException thrown = ExpectedException.none();

	@Test
    public static void parseIntShouldThrow1() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("keine Zahl!");
        MyInteger.parseInt("hallo");
    }
	
	@Test
	void testIntValue()
	{
		assertEquals(-2147483648, i4.intValue(), "should be -2147483648");
		assertEquals(+2147483647, i3.intValue(), "should be +2147483647");
		assertEquals(+2147483647, i8.intValue(), "should be +2147483647");
	}
	
	@Test
	void testDoubleValue()
	{
		assertEquals(-2147483648.0, i4.doubleValue(), "should be -2147483648.0");
		assertEquals(+2147483647.0, i3.doubleValue(), "should be +2147483647.0");
		assertEquals(+2147483647.0, i8.doubleValue(), "should be +2147483647.0");
	}
	
	@Test
	void testValueOfString()
	{
		assertTrue(i4.equals(MyInteger.valueOf("-2147483648")), "should be equal to i4");
		assertTrue(i3.equals(MyInteger.valueOf("2147483647")), "should be equal to i3");
		assertTrue(i8.equals(MyInteger.valueOf("2147483647")), "should be equal to i8");
	}
	
	@Test
	void testValueOfInt()
	{
		assertTrue(i4.equals(MyInteger.valueOf(-2147483648)), "should be equal to i4");
		assertTrue(i3.equals(MyInteger.valueOf(2147483647)), "should be equal to i3");
		assertTrue(i8.equals(MyInteger.valueOf(2147483647)), "should be equal to i8");
	}
	
	@Test
	void testEqualsObject()
	{
		assertTrue(i3.equals(i8), "i3 and i8 should be equal");
		assertTrue(i2.equals(i6), "i2 and i6 should be equal");
		assertFalse(i3.equals(i2), "i3 and i2 should not be equal");
		assertFalse(i8.equals(i6), "i8 and i6 should not be equal");
	}
	
	@Test
	void testToString()
	{
		assertEquals("-2147483648", i4.toString(), "should be '-2147483648'");
		assertEquals("2147483647", i3.toString(), "should be '2147483647' ");
		assertEquals("2147483647", i8.toString(), "should be '2147483647' ");
	}
	
	@Test
	void testCompare()
	{
		assertTrue(MyInteger.compare(5, 4)>0, "5,4 should be > 0");
		assertTrue(MyInteger.compare(4, 4)==0, "4,4 should be == 0");
		assertTrue(MyInteger.compare(4, 5)<0, "4,5 should be < 0");
		assertTrue(MyInteger.compare(MyInteger.MAX_VALUE, MyInteger.MIN_VALUE)>0, "MAX,MIN should be > 0");
		assertTrue(MyInteger.compare(MyInteger.MAX_VALUE, MyInteger.MAX_VALUE)==0, "MAX,MAX should be == 0");
		assertTrue(MyInteger.compare(MyInteger.MIN_VALUE, MyInteger.MAX_VALUE)<0, "MIN,MAX should be > 0");
	}
	
	@Test
	void testCompareTo()
	{
		assertTrue(i1.compareTo(i2)>0, "i1, i2 should be > 0");
		assertTrue(i2.compareTo(i1)<0, "i2, i1 should be < 0");
		assertTrue(i2.compareTo(i6)==0, "i2, i6 should be == 0");
		assertTrue(i3.compareTo(i8)==0, "i3, i8 should be == 0");
	}
}
