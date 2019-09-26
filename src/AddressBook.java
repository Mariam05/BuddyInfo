import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private List<BuddyInfo> buddyInfos; 
	
	public AddressBook() {
		buddyInfos = new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo buddy) {
		if (buddy != null) {
			buddyInfos.add(buddy);
		}
		
	}
	
	public BuddyInfo removeBuddy(int index) {
		if (index >=0 && index < buddyInfos.size()) {
			return this.buddyInfos.remove(index);
		}
		return null;
	}
	

	public static void main(String[] args) {
		System.out.println("Address book");
		BuddyInfo bud = new BuddyInfo("Homer", "Road", "123");
		AddressBook addresses = new AddressBook();
		addresses.addBuddy(bud);
		addresses.removeBuddy(0);

	}

}
