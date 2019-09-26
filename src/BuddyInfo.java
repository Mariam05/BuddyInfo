public class BuddyInfo {

	private String name;
	private String address;
	private String phoneNum;
	
	public BuddyInfo(String name, String address, String phoneNum) {
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
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

	public String getphoneNum() {
		return this.phoneNum;
	}

	public void setphoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public static void main(String[] args) {
		BuddyInfo bud = new BuddyInfo("Homer", "Road", "123");
		AddressBook addresses = new AddressBook();

	}

}
