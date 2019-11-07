import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.DefaultListModel;

public class AddressBook extends DefaultListModel<BuddyInfo> {

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
	
	public void save(String filename) {
		try {
			FileWriter writer = new FileWriter(filename);
			for(Object b : this.toArray()) {
				BuddyInfo bd = (BuddyInfo)b;
				writer.write(bd.toString() + "\n");
			}
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void importAddressBook() {
		//reads the exported file and recreats the addressBook. Use BufferedReader to import. 
	}

	public static void main(String[] args) {
		System.out.println("Address book");
		BuddyInfo bud = new BuddyInfo("Homer", "Road", "123");
		BuddyInfo bud2 = new BuddyInfo("Mr.Buddy", "111 Fake St.", "6131234567");
		BuddyInfo bud3 = BuddyInfo.importBuddy("Mrs.Buddy,111 Real St.,613wrongnum,38");
		AddressBook addresses = new AddressBook();
		addresses.addBuddy(bud);
		addresses.addBuddy(bud2);
		addresses.addBuddy(bud3);
		addresses.save("Buddies.txt");
		
	}

}
