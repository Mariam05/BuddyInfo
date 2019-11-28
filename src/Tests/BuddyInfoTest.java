package Tests;

import static org.junit.Assert.*;
import org.junit.*;

import AddressBook.BuddyInfo;

public class BuddyInfoTest {

	private BuddyInfo buddy;
	private BuddyInfo secondBuddy;
	private BuddyInfo copyBuddy;
	
	@Before
	public void setUp() {
		buddy = new BuddyInfo("Harry Potter", "4 Privet Drive", "12345");
		secondBuddy = new BuddyInfo("Harry Potter", "4 Privet Drive", "12345");
		copyBuddy = new BuddyInfo(buddy);
	}
	
	@Test
	public void testBuddyInfoCopyConstructor() {
		assertTrue(buddy.isEquals(copyBuddy));
	}
	
	@Test
	public void testIsEquals() {
		assertTrue(buddy.isEquals(secondBuddy));
	}
	
	@Test
	public void testGreeting() {
		assertEquals("Hey there bud!",buddy.greetBuddy());
	}
	
	@Test
	public void testSetAge() {
		buddy.setAge(20);
		assertEquals(20, buddy.getAge());
	}

}
