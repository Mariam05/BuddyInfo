package AddressBook;
import java.io.Serializable;
import java.util.Scanner;

public class BuddyInfo implements Serializable {

	private String name;
	private String address;
	private String phoneNum;
	private int age;

	public BuddyInfo(String name, String address, String phoneNum) {
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.age = age;
	}

	public BuddyInfo(BuddyInfo aBuddy) {
		this.name = aBuddy.getName();
		this.address = aBuddy.getAddress();
		this.phoneNum = aBuddy.getPhoneNum();
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public boolean isOver18() {
		return age > 18;
	}

	public String greetBuddy() {
		return "Hey there bud!";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setphoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String toXML() {
		return "<BuddyInfo> <Address>" + address + "</Address> <name>" + name + "</name><phoneNum>" + phoneNum 
				+ "</phoneNum><age>" + age + "</age></BuddyInfo>";
	}

	public boolean isEquals(BuddyInfo bI) {
		return bI.address.equals(this.address) && bI.name.equals(this.name) && bI.phoneNum.equals(this.phoneNum);
	}

	public String toString() {
		return name + "," + address + "," + phoneNum + "," + age;
	}

	public static BuddyInfo importBuddy(String input) {
		BuddyInfo newBud = null;

		Scanner dscanner = new Scanner(input).useDelimiter("\\s*,\\s*");
		try {
			String name = dscanner.next();
			String address = dscanner.next();
			String phoneNum = dscanner.next();
			int age = dscanner.nextInt();
			newBud = new BuddyInfo(name, address, phoneNum);
			newBud.setAge(age);
		} catch (Exception e) {
			// handle exception
		}
		dscanner.close();

		return newBud;

	}

}
