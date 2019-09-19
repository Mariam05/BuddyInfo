import java.util.ArrayList;

public class AddressBook {

	ArrayList<BuddyInfo> buddyInfos; 
	
	public AddressBook() {
		buddyInfos = new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo buddy) {
		buddyInfos.add(buddy);
	}
	
	public void removeBuddy(BuddyInfo buddy) {
		buddyInfos.remove(buddy);
	}
	

	public static void main(String[] args) {
		System.out.println("Address book");
	}

}
