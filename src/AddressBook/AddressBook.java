package AddressBook;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;

import javax.swing.DefaultListModel;

public class AddressBook extends DefaultListModel<BuddyInfo> implements Serializable {

	
	String filename = "serializedAB.txt";
	
	public AddressBook() {
		super();
	}

	public int size() {
		return super.getSize();
	}

	public void clear() {
		super.clear();
	}

	public void addBuddy(BuddyInfo buddy) {
		if (buddy != null) {
			super.addElement(buddy);
		}
	}

	public BuddyInfo removeBuddy(int index) {
		if (index >= 0 && index < super.getSize()) {
			return super.remove(index);
		}
		return null;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (Object o : this.toArray()) {
			BuddyInfo bd = (BuddyInfo) o;
			s += bd.toString() + "\n";
		}
		return s;
	}

	//==========================================================
	// IO with string parsing
	//==========================================================
	/**
	 * Save an address book to a file using string parsing
	 * 
	 * @param filename
	 */
	public void save(String filename) {
		try {
			FileWriter writer = new FileWriter(filename);
			for (Object b : this.toArray()) {
				BuddyInfo bd = (BuddyInfo) b;
				writer.write(bd.toString() + "\n");
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Factory method to create a new addressbook based on the contents of another
	 * via string parsing
	 * 
	 * @param filename
	 * @return
	 */
	public static AddressBook importAddressBook(String filename) {
		AddressBook importedBook = new AddressBook();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			while (line != null) {
				importedBook.addBuddy(BuddyInfo.importBuddy(line));
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return importedBook;
	}

	//========================================================
	// Serialization with serializable interface
	//=======================================================
	/**
	 * Export implemented with serialization
	 */
	public void export(String filename) {

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(this);

			out.close();
			file.close();

			System.out.println("Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}

	/**
	 * Import implemented with serialization
	 * @return the AddressBook imported
	 */
	public static AddressBook importSerialized(String filename) {
		
		AddressBook newBook = null;
		
		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);	
			
			// Method for deserialization of object
			newBook = (AddressBook) in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized ");
		}

		catch (IOException | ClassNotFoundException ex) {
			System.out.println("IOException is caught");
		}

		return newBook;
	}
	
	
	//==========================================================
	// serialization with xml
	//==========================================================
	/**
	 * 
	 * @return
	 */
	public String toXML() {
		String xml = "<AddressBook>";
		for (Object b : this.toArray()) {
			BuddyInfo bd = (BuddyInfo) b;
			xml += bd.toXML();
		}
		xml += "</AddressBook>";
		
		return xml;
	}
	
	public void exportToXmlFile(String filename) {
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write(toXML());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static AddressBook importFromXmlFile(String filename) {
		AddressBook ab = new AddressBook();
		XmlParser parser = new XmlParser();
		
		return ab;
	}


	public static void main(String[] args) {
		System.out.println("Address book");
		
		//File file = new File("Buddies.txt");
		
		BuddyInfo bud = new BuddyInfo("Homer", "Road", "123");
		BuddyInfo bud2 = new BuddyInfo("Mr.Buddy", "111 Fake St.", "6131234567");
		BuddyInfo bud3 = BuddyInfo.importBuddy("Mrs.Buddy,111 Real St.,613wrongnum,38");
		AddressBook addresses = new AddressBook();
		addresses.addBuddy(bud3);
		addresses.addBuddy(bud2);
		addresses.addBuddy(bud);
		addresses.save("Buddies.txt");
		System.out.println("OG:\n" + addresses.toString());
		AddressBook copy = AddressBook.importAddressBook("Buddies.txt");
		System.out.println("Copy:\n" + copy.toString());
		
		File file2 = new File("serializedAB.txt");
		String filename = "serializedAB.txt";
		addresses.exportToXmlFile(filename);
		AddressBook newAB = AddressBook.importSerialized(filename);
		
		
//		try {
//			//XmlParser.readSAX(file2);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

	}

}
