package Tests;
import static org.junit.Assert.*;

import org.junit.*;

import AddressBook.AddressBook;
import AddressBook.BuddyInfo;

public class AddressBookTest {

	private AddressBook addressBook;
	private BuddyInfo buddy1;
	private BuddyInfo buddy2;
	
	@Before
	public void setUp() throws Exception {
		addressBook = new AddressBook();
		buddy1 = new BuddyInfo("Harry Potter", "4 Privet Drive", "12345");
		buddy2 = new BuddyInfo("Sherlock Holmes", "221b Baker St", "56790");
		addressBook.addBuddy(buddy1);
		addressBook.addBuddy(buddy2);	
	}

	@Test
	public void testSize() {
		assertEquals(2, addressBook.size());
	}
	
	@Test
	public void testClear() {
		addressBook.clear();
		assertEquals(0, addressBook.size());
	}
	
	@Test
	public void testFactoryMethod() {
		String filename = "Buddies.txt";
		addressBook.save(filename);
		AddressBook copy = AddressBook.importAddressBook(filename);
		assertTrue(addressBook.toString().equals(copy.toString()));
	}
	
	@Test
	public void testSerialization() {
		String filename = "serializedAB.txt";
		addressBook.export(filename);
		AddressBook newAB = AddressBook.importSerialized(filename);
		assertTrue(addressBook.toString().equals(newAB.toString()));
	}

}
