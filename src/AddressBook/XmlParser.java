package AddressBook;
import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class XmlParser extends DefaultHandler{

	AddressBook addressBook;
	BuddyInfo bud;
	String current = null;
	String address;
	String phoneNum;
	String name;
	int age;
		
	public void readSAX(File f) throws Exception{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser s = spf.newSAXParser();
		
	
		
		s.parse(f, this);
	}
	
	public static void makeNewAddressBook() {
		
	}
	
	public void startElement(String u, String ln, String qName, Attributes a) {
		System.out.println("START: " + qName);
		String currElem = qName;
		if (currElem.equals("AddressBook")) {
			addressBook = new AddressBook();
		}
		
	}
	
	public void endElement(String uri, String localName, String qName) {
		System.out.println("END: " + qName);
		if (current.equals("BuddyInfo")) {
			bud = new BuddyInfo(name, address, phoneNum);
			bud.setAge(age);
			addressBook.addElement(bud);
		}
	}
	
	public void characters(char[] ch, int start, int length) {
		System.out.println("CHARS: " + new String(ch, start, length));
		String contents = new String(ch, start, length);
		switch(current) {
		case "AddressBook": 
		case "Address": address = contents; break;
		case "phoneNum": phoneNum = contents; break;
		case "name": name = contents; break;
		case "age": age = Integer.parseInt(contents); break;
			
		}
	}	
}
